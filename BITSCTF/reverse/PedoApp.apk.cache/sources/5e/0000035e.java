package p048w0;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.internal.C0483e;
import p020i0.InterfaceC0249g;

/* renamed from: w0.g1 */
/* loaded from: classes.dex */
public final class C0731g1 extends AbstractC0725f1 {

    /* renamed from: f */
    private final Executor f1326f;

    public C0731g1(Executor executor) {
        this.f1326f = executor;
        C0483e.m992a(m460r());
    }

    /* renamed from: q */
    private final void m461q(InterfaceC0249g interfaceC0249g, RejectedExecutionException rejectedExecutionException) {
        C0778s1.m378c(interfaceC0249g, C0719e1.m472a("The task was rejected", rejectedExecutionException));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor m460r = m460r();
        ExecutorService executorService = m460r instanceof ExecutorService ? (ExecutorService) m460r : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0731g1) && ((C0731g1) obj).m460r() == m460r();
    }

    public int hashCode() {
        return System.identityHashCode(m460r());
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: o */
    public void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        try {
            Executor m460r = m460r();
            C0709c.m485a();
            m460r.execute(runnable);
        } catch (RejectedExecutionException e) {
            C0709c.m485a();
            m461q(interfaceC0249g, e);
            C0792w0.m275b().mo242o(interfaceC0249g, runnable);
        }
    }

    /* renamed from: r */
    public Executor m460r() {
        return this.f1326f;
    }

    @Override // p048w0.AbstractC0722f0
    public String toString() {
        return m460r().toString();
    }
}