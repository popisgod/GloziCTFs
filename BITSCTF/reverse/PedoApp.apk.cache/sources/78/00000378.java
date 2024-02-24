package p048w0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p014f0.C0169q;
import p034p0.InterfaceC0611l;

/* renamed from: w0.m1 */
/* loaded from: classes.dex */
final class C0757m1 extends AbstractC0772q1 {

    /* renamed from: i */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1346i = AtomicIntegerFieldUpdater.newUpdater(C0757m1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: h */
    private final InterfaceC0611l<Throwable, C0169q> f1347h;

    /* JADX WARN: Multi-variable type inference failed */
    public C0757m1(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        this.f1347h = interfaceC0611l;
    }

    @Override // p034p0.InterfaceC0611l
    public /* bridge */ /* synthetic */ C0169q invoke(Throwable th) {
        mo289y(th);
        return C0169q.f235a;
    }

    @Override // p048w0.AbstractC0700a0
    /* renamed from: y */
    public void mo289y(Throwable th) {
        if (f1346i.compareAndSet(this, 0, 1)) {
            this.f1347h.invoke(th);
        }
    }
}