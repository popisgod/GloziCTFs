package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.C0476c;
import p048w0.C0768p0;

/* renamed from: kotlinx.coroutines.scheduling.m */
/* loaded from: classes.dex */
public final class C0537m {

    /* renamed from: b */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1110b = AtomicReferenceFieldUpdater.newUpdater(C0537m.class, Object.class, "lastScheduledTask");

    /* renamed from: c */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1111c = AtomicIntegerFieldUpdater.newUpdater(C0537m.class, "producerIndex");

    /* renamed from: d */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1112d = AtomicIntegerFieldUpdater.newUpdater(C0537m.class, "consumerIndex");

    /* renamed from: e */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1113e = AtomicIntegerFieldUpdater.newUpdater(C0537m.class, "blockingTasksInBuffer");

    /* renamed from: a */
    private final AtomicReferenceArray<AbstractRunnableC0533i> f1114a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    /* renamed from: b */
    public static /* synthetic */ AbstractRunnableC0533i m828b(C0537m c0537m, AbstractRunnableC0533i abstractRunnableC0533i, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return c0537m.m829a(abstractRunnableC0533i, z);
    }

    /* renamed from: c */
    private final AbstractRunnableC0533i m827c(AbstractRunnableC0533i abstractRunnableC0533i) {
        if (abstractRunnableC0533i.f1102e.mo831g() == 1) {
            f1113e.incrementAndGet(this);
        }
        if (m825e() == 127) {
            return abstractRunnableC0533i;
        }
        int i = this.producerIndex & 127;
        while (this.f1114a.get(i) != null) {
            Thread.yield();
        }
        this.f1114a.lazySet(i, abstractRunnableC0533i);
        f1111c.incrementAndGet(this);
        return null;
    }

    /* renamed from: d */
    private final void m826d(AbstractRunnableC0533i abstractRunnableC0533i) {
        if (abstractRunnableC0533i != null) {
            if (abstractRunnableC0533i.f1102e.mo831g() == 1) {
                int decrementAndGet = f1113e.decrementAndGet(this);
                if (C0768p0.m398a()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private final AbstractRunnableC0533i m821i() {
        AbstractRunnableC0533i andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (f1112d.compareAndSet(this, i, i + 1) && (andSet = this.f1114a.getAndSet(i2, null)) != null) {
                m826d(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: j */
    private final boolean m820j(C0528d c0528d) {
        AbstractRunnableC0533i m821i = m821i();
        if (m821i == null) {
            return false;
        }
        c0528d.m925a(m821i);
        return true;
    }

    /* renamed from: m */
    private final long m817m(C0537m c0537m, boolean z) {
        AbstractRunnableC0533i abstractRunnableC0533i;
        do {
            abstractRunnableC0533i = (AbstractRunnableC0533i) c0537m.lastScheduledTask;
            if (abstractRunnableC0533i == null) {
                return -2L;
            }
            if (z) {
                if (!(abstractRunnableC0533i.f1102e.mo831g() == 1)) {
                    return -2L;
                }
            }
            long mo832a = C0536l.f1109f.mo832a() - abstractRunnableC0533i.f1101d;
            long j = C0536l.f1104a;
            if (mo832a < j) {
                return j - mo832a;
            }
        } while (!C0476c.m1006a(f1110b, c0537m, abstractRunnableC0533i, null));
        m828b(this, abstractRunnableC0533i, false, 2, null);
        return -1L;
    }

    /* renamed from: a */
    public final AbstractRunnableC0533i m829a(AbstractRunnableC0533i abstractRunnableC0533i, boolean z) {
        if (z) {
            return m827c(abstractRunnableC0533i);
        }
        AbstractRunnableC0533i abstractRunnableC0533i2 = (AbstractRunnableC0533i) f1110b.getAndSet(this, abstractRunnableC0533i);
        if (abstractRunnableC0533i2 == null) {
            return null;
        }
        return m827c(abstractRunnableC0533i2);
    }

    /* renamed from: e */
    public final int m825e() {
        return this.producerIndex - this.consumerIndex;
    }

    /* renamed from: f */
    public final int m824f() {
        return this.lastScheduledTask != null ? m825e() + 1 : m825e();
    }

    /* renamed from: g */
    public final void m823g(C0528d c0528d) {
        AbstractRunnableC0533i abstractRunnableC0533i = (AbstractRunnableC0533i) f1110b.getAndSet(this, null);
        if (abstractRunnableC0533i != null) {
            c0528d.m925a(abstractRunnableC0533i);
        }
        do {
        } while (m820j(c0528d));
    }

    /* renamed from: h */
    public final AbstractRunnableC0533i m822h() {
        AbstractRunnableC0533i abstractRunnableC0533i = (AbstractRunnableC0533i) f1110b.getAndSet(this, null);
        return abstractRunnableC0533i == null ? m821i() : abstractRunnableC0533i;
    }

    /* renamed from: k */
    public final long m819k(C0537m c0537m) {
        if (C0768p0.m398a()) {
            if (!(m825e() == 0)) {
                throw new AssertionError();
            }
        }
        int i = c0537m.producerIndex;
        AtomicReferenceArray<AbstractRunnableC0533i> atomicReferenceArray = c0537m.f1114a;
        for (int i2 = c0537m.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (c0537m.blockingTasksInBuffer == 0) {
                break;
            }
            AbstractRunnableC0533i abstractRunnableC0533i = atomicReferenceArray.get(i3);
            if (abstractRunnableC0533i != null) {
                if ((abstractRunnableC0533i.f1102e.mo831g() == 1) && atomicReferenceArray.compareAndSet(i3, abstractRunnableC0533i, null)) {
                    f1113e.decrementAndGet(c0537m);
                    m828b(this, abstractRunnableC0533i, false, 2, null);
                    return -1L;
                }
            }
        }
        return m817m(c0537m, true);
    }

    /* renamed from: l */
    public final long m818l(C0537m c0537m) {
        if (C0768p0.m398a()) {
            if (!(m825e() == 0)) {
                throw new AssertionError();
            }
        }
        AbstractRunnableC0533i m821i = c0537m.m821i();
        if (m821i != null) {
            AbstractRunnableC0533i m828b = m828b(this, m821i, false, 2, null);
            if (C0768p0.m398a()) {
                if (m828b == null) {
                    return -1L;
                }
                throw new AssertionError();
            }
            return -1L;
        }
        return m817m(c0537m, false);
    }
}