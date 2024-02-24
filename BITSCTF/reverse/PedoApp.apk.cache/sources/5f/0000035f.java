package p048w0;

import p020i0.InterfaceC0249g;

/* renamed from: w0.g2 */
/* loaded from: classes.dex */
public final class C0732g2 extends AbstractC0722f0 {

    /* renamed from: e */
    public static final C0732g2 f1327e = new C0732g2();

    private C0732g2() {
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: o */
    public void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        C0745j2 c0745j2 = (C0745j2) interfaceC0249g.get(C0745j2.f1334e);
        if (c0745j2 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        c0745j2.f1335d = true;
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: p */
    public boolean mo241p(InterfaceC0249g interfaceC0249g) {
        return false;
    }

    @Override // p048w0.AbstractC0722f0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}