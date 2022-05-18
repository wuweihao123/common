package com.wwh.springcloud.uitl;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;

public interface Convert<V, P> {

    default void vo2po(V v) {
        if (!Objects.isNull(v)) {
            BeanUtils.copyProperties(v, this);
        }
    }

    default List<P> vos2pos(List<V> list) {
        return null;
    }

    default V po2vo() {
        return null;
    }

    default List<V> pos2vos(List<P> list) {
        return null;
    }
}
