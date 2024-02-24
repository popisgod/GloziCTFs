package androidx.lifecycle;

import androidx.lifecycle.AbstractC0066c;

/* loaded from: classes.dex */
class LiveData$LifecycleBoundObserver extends AbstractC0075h implements InterfaceC0069d {

    /* renamed from: b */
    final InterfaceC0071f f102b;

    @Override // androidx.lifecycle.InterfaceC0069d
    /* renamed from: g */
    public void mo2193g(InterfaceC0071f interfaceC0071f, AbstractC0066c.EnumC0067a enumC0067a) {
        if (this.f102b.mo1748f().mo2209a() == AbstractC0066c.EnumC0068b.DESTROYED) {
            throw null;
        }
        m2194h(m2218i());
    }

    /* renamed from: i */
    boolean m2218i() {
        return this.f102b.mo1748f().mo2209a().m2210a(AbstractC0066c.EnumC0068b.STARTED);
    }
}