package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.C0465i;
import kotlin.jvm.internal.C0468l;
import kotlin.jvm.internal.InterfaceC0462f;
import p020i0.InterfaceC0244d;

/* renamed from: kotlin.coroutines.jvm.internal.k */
/* loaded from: classes.dex */
public abstract class AbstractC0454k extends AbstractC0446d implements InterfaceC0462f<Object> {
    private final int arity;

    public AbstractC0454k(int i) {
        this(i, null);
    }

    public AbstractC0454k(int i, InterfaceC0244d<Object> interfaceC0244d) {
        super(interfaceC0244d);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.InterfaceC0462f
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
    public String toString() {
        if (getCompletion() == null) {
            String m1033d = C0468l.m1033d(this);
            C0465i.m1049d(m1033d, "renderLambdaToString(this)");
            return m1033d;
        }
        return super.toString();
    }
}