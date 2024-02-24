package p048w0;

import p014f0.C0169q;
import p034p0.InterfaceC0611l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: w0.n1 */
/* loaded from: classes.dex */
public final class C0761n1 extends AbstractC0784u1 {

    /* renamed from: h */
    private final InterfaceC0611l<Throwable, C0169q> f1354h;

    /* JADX WARN: Multi-variable type inference failed */
    public C0761n1(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        this.f1354h = interfaceC0611l;
    }

    @Override // p034p0.InterfaceC0611l
    public /* bridge */ /* synthetic */ C0169q invoke(Throwable th) {
        mo289y(th);
        return C0169q.f235a;
    }

    @Override // p048w0.AbstractC0700a0
    /* renamed from: y */
    public void mo289y(Throwable th) {
        this.f1354h.invoke(th);
    }
}