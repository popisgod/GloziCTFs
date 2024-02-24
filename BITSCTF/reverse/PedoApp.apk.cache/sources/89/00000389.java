package p048w0;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import p040s0.C0647f;

/* renamed from: w0.r0 */
/* loaded from: classes.dex */
public final class RunnableC0774r0 extends AbstractC0701a1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: j */
    public static final RunnableC0774r0 f1365j;

    /* renamed from: k */
    private static final long f1366k;

    static {
        Long l;
        RunnableC0774r0 runnableC0774r0 = new RunnableC0774r0();
        f1365j = runnableC0774r0;
        AbstractC0801z0.m252v(runnableC0774r0, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f1366k = timeUnit.toNanos(l.longValue());
    }

    private RunnableC0774r0() {
    }

    /* renamed from: R */
    private final synchronized void m387R() {
        if (m385T()) {
            debugStatus = 3;
            m499M();
            notifyAll();
        }
    }

    /* renamed from: S */
    private final synchronized Thread m386S() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* renamed from: T */
    private final boolean m385T() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    /* renamed from: U */
    private final synchronized boolean m384U() {
        if (m385T()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // p048w0.AbstractC0707b1
    /* renamed from: A */
    protected Thread mo388A() {
        Thread thread = _thread;
        return thread == null ? m386S() : thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean m502J;
        C0728f2.f1323a.m465c(this);
        C0709c.m485a();
        try {
            if (!m384U()) {
                if (m502J) {
                    return;
                }
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long m501K = m501K();
                if (m501K == Long.MAX_VALUE) {
                    C0709c.m485a();
                    long nanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = f1366k + nanoTime;
                    }
                    long j2 = j - nanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        m387R();
                        C0709c.m485a();
                        if (m502J()) {
                            return;
                        }
                        mo388A();
                        return;
                    }
                    m501K = C0647f.m642d(m501K, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (m501K > 0) {
                    if (m385T()) {
                        _thread = null;
                        m387R();
                        C0709c.m485a();
                        if (m502J()) {
                            return;
                        }
                        mo388A();
                        return;
                    }
                    C0709c.m485a();
                    LockSupport.parkNanos(this, m501K);
                }
            }
        } finally {
            _thread = null;
            m387R();
            C0709c.m485a();
            if (!m502J()) {
                mo388A();
            }
        }
    }
}