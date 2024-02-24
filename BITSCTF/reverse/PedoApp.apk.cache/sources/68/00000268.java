package kotlinx.coroutines.internal;

import p020i0.InterfaceC0249g;
import p048w0.InterfaceC0753l0;

/* renamed from: kotlinx.coroutines.internal.f */
/* loaded from: classes.dex */
public final class C0485f implements InterfaceC0753l0 {

    /* renamed from: d */
    private final InterfaceC0249g f1004d;

    public C0485f(InterfaceC0249g interfaceC0249g) {
        this.f1004d = interfaceC0249g;
    }

    @Override // p048w0.InterfaceC0753l0
    /* renamed from: s */
    public InterfaceC0249g mo411s() {
        return this.f1004d;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + mo411s() + ')';
    }
}