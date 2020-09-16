package com.bun133.placechooseyou.legacy;

import kotlin.Metadata;

@Metadata(
        mv = {1, 4, 0},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0004\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u00028\u0001X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"},
        d2 = {"Lcom/bun133/placechooseyou/DoubleSet;", "T", "V", "", "t", "v", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getT", "()Ljava/lang/Object;", "setT", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getV", "setV", "PlaceCooseYou"}
)
public final class DoubleSet<T,V> {
    private T t;
    private V v;

    public final T getT() {
        return this.t;
    }

    public final void setT(T var1) {
        this.t = var1;
    }

    public final V getV() {
        return this.v;
    }

    public final void setV(V var1) {
        this.v = var1;
    }

    public DoubleSet(T t, V v) {
        this.t = t;
        this.v = v;
    }
}
