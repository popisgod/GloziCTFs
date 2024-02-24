package p048w0;

import p014f0.C0169q;
import p034p0.InterfaceC0611l;

/* renamed from: w0.l1 */
/* loaded from: classes.dex */
final class C0754l1 extends AbstractC0737i {

    /* renamed from: d */
    private final InterfaceC0611l<Throwable, C0169q> f1344d;

    /* JADX WARN: Multi-variable type inference failed */
    public C0754l1(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        this.f1344d = interfaceC0611l;
    }

    @Override // p048w0.AbstractC0741j
    /* renamed from: a */
    public void mo224a(Throwable th) {
        this.f1344d.invoke(th);
    }

    @Override // p034p0.InterfaceC0611l
    public /* bridge */ /* synthetic */ C0169q invoke(Throwable th) {
        mo224a(th);
        return C0169q.f235a;
    }

    public String toString() {
        return "InvokeOnCancel[" + C0771q0.m392a(this.f1344d) + '@' + C0771q0.m391b(this) + ']';
    }
}