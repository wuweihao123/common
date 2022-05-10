package com.wwh.springcloud.uitl;

import java.util.List;

public interface Convert<V, P> {

    void vo2po(V v);

    List<P> vos2pos(List<V> list);

    V po2vo();

    List<V> pos2vos(List<P> list);
}
