package kotlin.coroutines.jvm.internal;

import p020i0.C0255h;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;

/* renamed from: kotlin.coroutines.jvm.internal.j */
/* loaded from: classes.dex */
public abstract class AbstractC0453j extends AbstractC0443a {
    public AbstractC0453j(InterfaceC0244d<Object> interfaceC0244d) {
        super(interfaceC0244d);
        if (interfaceC0244d != null) {
            if (!(interfaceC0244d.getContext() == C0255h.f301d)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // p020i0.InterfaceC0244d
    public InterfaceC0249g getContext() {
        return C0255h.f301d;
    }
}