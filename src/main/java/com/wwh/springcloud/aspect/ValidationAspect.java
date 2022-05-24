package com.wwh.springcloud.aspect;


import com.alibaba.fastjson2.JSON;
import com.wwh.springcloud.annotation.ValidateRequest;
import com.wwh.springcloud.exception.SystemRuntimeException;
import com.wwh.springcloud.inter.Verifiable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Aspect
public class ValidationAspect {

    @Pointcut("@annotation(com.wwh.springcloud.annotation.ValidateRequest)")
    public void methodPointcut() {
    }

    @Before(value = "methodPointcut()&&@annotation(validateRequest)")
    public void validationBefore(JoinPoint jp, ValidateRequest validateRequest) {
        //获取所有的参数
        Object[] args = jp.getArgs();

        List<Object> needValidateArgs = new ArrayList<>();

        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    List<FieldError> fieldErrors = result.getFieldErrors();
                    HashMap<String, Object> map = new HashMap<>(fieldErrors.size());
                    fieldErrors.forEach(fieldError -> {
                        map.put(fieldError.getField(), fieldError.getDefaultMessage());
                    });
                    //取自定义注解
                    if (validateRequest != null) {
                        if (StringUtils.hasLength(validateRequest.full())) {
                            throw new SystemRuntimeException(map + "", validateRequest.full());
                        }

                        if (StringUtils.hasLength(validateRequest.prefix()) && StringUtils.hasLength(validateRequest.suffix())) {
                            throw new SystemRuntimeException(map + "", validateRequest.prefix() + validateRequest.suffix());
                        }
                    }
                    throw new SystemRuntimeException(JSON.toJSONString(map), "");
                }
            }
            else if ((arg instanceof Verifiable) && validateRequest.check()) {
                needValidateArgs.add(arg);
            }
        }

        //开始自定义参数校验
        doCustomerArgsValidate(needValidateArgs);
    }

    private void doCustomerArgsValidate(List<Object> needValidateArgs) {
        if (CollectionUtils.isEmpty(needValidateArgs)) {
            return;
        }
        for (Object arg : needValidateArgs) {
            if (Objects.nonNull(arg) && (arg instanceof Verifiable)) {
                ((Verifiable) arg).isInvalid();
            }
        }
    }


    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}
