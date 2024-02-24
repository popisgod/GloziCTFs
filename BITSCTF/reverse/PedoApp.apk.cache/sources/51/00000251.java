package kotlin.jvm.internal;

import java.io.Serializable;

/* renamed from: kotlin.jvm.internal.j */
/* loaded from: classes.dex */
public abstract class AbstractC0466j<R> implements InterfaceC0462f<R>, Serializable {
    private final int arity;

    public AbstractC0466j(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.InterfaceC0462f
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String m1032e = C0468l.m1032e(this);
        C0465i.m1049d(m1032e, "renderLambdaToString(this)");
        return m1032e;
    }
}