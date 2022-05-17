package com.wwh.springcloud.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageConditionVo {
    @NotNull
    @Size(min = 0, max = 200, message = "")
    private Integer pageSize = 20;

    @NotNull
    private Integer pageNum = 1;
}
