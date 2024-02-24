package p048w0;

import p014f0.C0169q;

/* renamed from: w0.r */
/* loaded from: classes.dex */
public final class C0773r extends AbstractC0772q1 implements InterfaceC0770q {

    /* renamed from: h */
    public final InterfaceC0776s f1364h;

    public C0773r(InterfaceC0776s interfaceC0776s) {
        this.f1364h = interfaceC0776s;
    }

    @Override // p048w0.InterfaceC0770q
    /* renamed from: g */
    public boolean mo389g(Throwable th) {
        return m358z().m345D(th);
    }

    @Override // p048w0.InterfaceC0770q
    public InterfaceC0764o1 getParent() {
        return m358z();
    }

    @Override // p034p0.InterfaceC0611l
    public /* bridge */ /* synthetic */ C0169q invoke(Throwable th) {
        mo289y(th);
        return C0169q.f235a;
    }

    @Override // p048w0.AbstractC0700a0
    /* renamed from: y */
    public void mo289y(Throwable th) {
        this.f1364h.mo310j(m358z());
    }
}