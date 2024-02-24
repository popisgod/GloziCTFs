package p048w0;

import java.util.concurrent.locks.LockSupport;
import p048w0.AbstractC0701a1;

/* renamed from: w0.b1 */
/* loaded from: classes.dex */
public abstract class AbstractC0707b1 extends AbstractC0801z0 {
    /* renamed from: A */
    protected abstract Thread mo388A();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B */
    public final void m487B(long j, AbstractC0701a1.AbstractRunnableC0702a abstractRunnableC0702a) {
        if (C0768p0.m398a()) {
            if (!(this != RunnableC0774r0.f1365j)) {
                throw new AssertionError();
            }
        }
        RunnableC0774r0.f1365j.m498N(j, abstractRunnableC0702a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C */
    public final void m486C() {
        Thread mo388A = mo388A();
        if (Thread.currentThread() != mo388A) {
            C0709c.m485a();
            LockSupport.unpark(mo388A);
        }
    }
}