package androidx.lifecycle;

import androidx.lifecycle.AbstractC0066c;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements InterfaceC0069d {

    /* renamed from: a */
    private final InterfaceC0065b[] f97a;

    @Override // androidx.lifecycle.InterfaceC0069d
    /* renamed from: g */
    public void mo2193g(InterfaceC0071f interfaceC0071f, AbstractC0066c.EnumC0067a enumC0067a) {
        C0076i c0076i = new C0076i();
        for (InterfaceC0065b interfaceC0065b : this.f97a) {
            interfaceC0065b.m2211a(interfaceC0071f, enumC0067a, false, c0076i);
        }
        for (InterfaceC0065b interfaceC0065b2 : this.f97a) {
            interfaceC0065b2.m2211a(interfaceC0071f, enumC0067a, true, c0076i);
        }
    }
}