package com.wwh.springcloud.uitl;

import java.util.List;

public interface Convert<V, P> {

    P vo2po(V v);

    List<P> vos2pos(List<V> list);
}
