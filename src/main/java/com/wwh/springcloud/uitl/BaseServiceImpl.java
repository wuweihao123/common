package com.wwh.springcloud.uitl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {
    @Override
    public int insert(T entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int delete(Wrapper<T> queryWrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return 0;
    }

    @Override
    public int updateById(T entity) {
        return 0;
    }

    @Override
    public int update(T entity, Wrapper<T> updateWrapper) {
        return 0;
    }

    @Override
    public T selectById(Serializable id) {
        return null;
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<T> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public T selectOne(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public Integer selectCount(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public List<T> selectList(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<T>> E selectPage(E page, Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E selectMapsPage(E page, Wrapper<T> queryWrapper) {
        return null;
    }
}
