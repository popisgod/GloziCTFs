package kotlinx.coroutines.scheduling;

import p048w0.C0771q0;

/* renamed from: kotlinx.coroutines.scheduling.k */
/* loaded from: classes.dex */
public final class C0535k extends AbstractRunnableC0533i {

    /* renamed from: f */
    public final Runnable f1103f;

    public C0535k(Runnable runnable, long j, InterfaceC0534j interfaceC0534j) {
        super(j, interfaceC0534j);
        this.f1103f = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1103f.run();
        } finally {
            this.f1102e.mo830k();
        }
    }

    public String toString() {
        return "Task[" + C0771q0.m392a(this.f1103f) + '@' + C0771q0.m391b(this.f1103f) + ", " + this.f1101d + ", " + this.f1102e + ']';
    }
}