package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0169q;
import p036q0.AbstractC0627c;
import p040s0.C0647f;
import p048w0.C0709c;
import p048w0.C0768p0;
import p048w0.C0771q0;

/* renamed from: kotlinx.coroutines.scheduling.a */
/* loaded from: classes.dex */
public final class ExecutorC0521a implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* renamed from: d */
    public final int f1063d;

    /* renamed from: e */
    public final int f1064e;

    /* renamed from: f */
    public final long f1065f;

    /* renamed from: g */
    public final String f1066g;

    /* renamed from: h */
    public final C0528d f1067h;

    /* renamed from: i */
    public final C0528d f1068i;

    /* renamed from: j */
    public final AtomicReferenceArray<C0524c> f1069j;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: k */
    public static final C0522a f1058k = new C0522a(null);

    /* renamed from: o */
    public static final C0520z f1062o = new C0520z("NOT_IN_STACK");

    /* renamed from: l */
    private static final /* synthetic */ AtomicLongFieldUpdater f1059l = AtomicLongFieldUpdater.newUpdater(ExecutorC0521a.class, "parkedWorkersStack");

    /* renamed from: m */
    static final /* synthetic */ AtomicLongFieldUpdater f1060m = AtomicLongFieldUpdater.newUpdater(ExecutorC0521a.class, "controlState");

    /* renamed from: n */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1061n = AtomicIntegerFieldUpdater.newUpdater(ExecutorC0521a.class, "_isTerminated");

    /* renamed from: kotlinx.coroutines.scheduling.a$a */
    /* loaded from: classes.dex */
    public static final class C0522a {
        private C0522a() {
        }

        public /* synthetic */ C0522a(C0461e c0461e) {
            this();
        }
    }

    /* renamed from: kotlinx.coroutines.scheduling.a$b */
    /* loaded from: classes.dex */
    public /* synthetic */ class C0523b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1070a;

        static {
            int[] iArr = new int[EnumC0525d.values().length];
            iArr[EnumC0525d.PARKING.ordinal()] = 1;
            iArr[EnumC0525d.BLOCKING.ordinal()] = 2;
            iArr[EnumC0525d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[EnumC0525d.DORMANT.ordinal()] = 4;
            iArr[EnumC0525d.TERMINATED.ordinal()] = 5;
            f1070a = iArr;
        }
    }

    /* renamed from: kotlinx.coroutines.scheduling.a$c */
    /* loaded from: classes.dex */
    public final class C0524c extends Thread {

        /* renamed from: k */
        static final /* synthetic */ AtomicIntegerFieldUpdater f1071k = AtomicIntegerFieldUpdater.newUpdater(C0524c.class, "workerCtl");

        /* renamed from: d */
        public final C0537m f1072d;

        /* renamed from: e */
        public EnumC0525d f1073e;

        /* renamed from: f */
        private long f1074f;

        /* renamed from: g */
        private long f1075g;

        /* renamed from: h */
        private int f1076h;

        /* renamed from: i */
        public boolean f1077i;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private C0524c() {
            ExecutorC0521a.this = r1;
            setDaemon(true);
            this.f1072d = new C0537m();
            this.f1073e = EnumC0525d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = ExecutorC0521a.f1062o;
            this.f1076h = AbstractC0627c.f1224d.mo691b();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C0524c(int i) {
            this();
            ExecutorC0521a.this = r1;
            m844n(i);
        }

        /* renamed from: a */
        private final void m857a(int i) {
            if (i == 0) {
                return;
            }
            ExecutorC0521a.f1060m.addAndGet(ExecutorC0521a.this, -2097152L);
            EnumC0525d enumC0525d = this.f1073e;
            if (enumC0525d != EnumC0525d.TERMINATED) {
                if (C0768p0.m398a()) {
                    if (!(enumC0525d == EnumC0525d.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.f1073e = EnumC0525d.DORMANT;
            }
        }

        /* renamed from: b */
        private final void m856b(int i) {
            if (i != 0 && m840r(EnumC0525d.BLOCKING)) {
                ExecutorC0521a.this.m862o();
            }
        }

        /* renamed from: c */
        private final void m855c(AbstractRunnableC0533i abstractRunnableC0533i) {
            int mo831g = abstractRunnableC0533i.f1102e.mo831g();
            m850h(mo831g);
            m856b(mo831g);
            ExecutorC0521a.this.m865l(abstractRunnableC0533i);
            m857a(mo831g);
        }

        /* renamed from: d */
        private final AbstractRunnableC0533i m854d(boolean z) {
            AbstractRunnableC0533i m846l;
            AbstractRunnableC0533i m846l2;
            if (z) {
                boolean z2 = m848j(ExecutorC0521a.this.f1063d * 2) == 0;
                if (z2 && (m846l2 = m846l()) != null) {
                    return m846l2;
                }
                AbstractRunnableC0533i m822h = this.f1072d.m822h();
                if (m822h != null) {
                    return m822h;
                }
                if (!z2 && (m846l = m846l()) != null) {
                    return m846l;
                }
            } else {
                AbstractRunnableC0533i m846l3 = m846l();
                if (m846l3 != null) {
                    return m846l3;
                }
            }
            return m839s(false);
        }

        /* renamed from: h */
        private final void m850h(int i) {
            this.f1074f = 0L;
            if (this.f1073e == EnumC0525d.PARKING) {
                if (C0768p0.m398a()) {
                    if (!(i == 1)) {
                        throw new AssertionError();
                    }
                }
                this.f1073e = EnumC0525d.BLOCKING;
            }
        }

        /* renamed from: i */
        private final boolean m849i() {
            return this.nextParkedWorker != ExecutorC0521a.f1062o;
        }

        /* renamed from: k */
        private final void m847k() {
            if (this.f1074f == 0) {
                this.f1074f = System.nanoTime() + ExecutorC0521a.this.f1065f;
            }
            LockSupport.parkNanos(ExecutorC0521a.this.f1065f);
            if (System.nanoTime() - this.f1074f >= 0) {
                this.f1074f = 0L;
                m838t();
            }
        }

        /* renamed from: l */
        private final AbstractRunnableC0533i m846l() {
            C0528d c0528d;
            if (m848j(2) == 0) {
                AbstractRunnableC0533i m922d = ExecutorC0521a.this.f1067h.m922d();
                if (m922d != null) {
                    return m922d;
                }
                c0528d = ExecutorC0521a.this.f1068i;
            } else {
                AbstractRunnableC0533i m922d2 = ExecutorC0521a.this.f1068i.m922d();
                if (m922d2 != null) {
                    return m922d2;
                }
                c0528d = ExecutorC0521a.this.f1067h;
            }
            return c0528d.m922d();
        }

        /* renamed from: m */
        private final void m845m() {
            loop0: while (true) {
                boolean z = false;
                while (!ExecutorC0521a.this.m870g() && this.f1073e != EnumC0525d.TERMINATED) {
                    AbstractRunnableC0533i m853e = m853e(this.f1077i);
                    if (m853e != null) {
                        this.f1075g = 0L;
                        m855c(m853e);
                    } else {
                        this.f1077i = false;
                        if (this.f1075g == 0) {
                            m841q();
                        } else if (z) {
                            m840r(EnumC0525d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f1075g);
                            this.f1075g = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            m840r(EnumC0525d.TERMINATED);
        }

        /* renamed from: p */
        private final boolean m842p() {
            boolean z;
            if (this.f1073e != EnumC0525d.CPU_ACQUIRED) {
                ExecutorC0521a executorC0521a = ExecutorC0521a.this;
                while (true) {
                    long j = executorC0521a.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                        if (ExecutorC0521a.f1060m.compareAndSet(executorC0521a, j, j - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.f1073e = EnumC0525d.CPU_ACQUIRED;
            }
            return true;
        }

        /* renamed from: q */
        private final void m841q() {
            if (!m849i()) {
                ExecutorC0521a.this.m867j(this);
                return;
            }
            if (C0768p0.m398a()) {
                if (!(this.f1072d.m824f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (m849i() && this.workerCtl == -1 && !ExecutorC0521a.this.m870g() && this.f1073e != EnumC0525d.TERMINATED) {
                m840r(EnumC0525d.PARKING);
                Thread.interrupted();
                m847k();
            }
        }

        /* renamed from: s */
        private final AbstractRunnableC0533i m839s(boolean z) {
            if (C0768p0.m398a()) {
                if (!(this.f1072d.m824f() == 0)) {
                    throw new AssertionError();
                }
            }
            int i = (int) (ExecutorC0521a.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int m848j = m848j(i);
            ExecutorC0521a executorC0521a = ExecutorC0521a.this;
            long j = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                m848j++;
                if (m848j > i) {
                    m848j = 1;
                }
                C0524c c0524c = executorC0521a.f1069j.get(m848j);
                if (c0524c != null && c0524c != this) {
                    if (C0768p0.m398a()) {
                        if (!(this.f1072d.m824f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    C0537m c0537m = this.f1072d;
                    C0537m c0537m2 = c0524c.f1072d;
                    long m819k = z ? c0537m.m819k(c0537m2) : c0537m.m818l(c0537m2);
                    if (m819k == -1) {
                        return this.f1072d.m822h();
                    }
                    if (m819k > 0) {
                        j = Math.min(j, m819k);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.f1075g = j;
            return null;
        }

        /* renamed from: t */
        private final void m838t() {
            ExecutorC0521a executorC0521a = ExecutorC0521a.this;
            synchronized (executorC0521a.f1069j) {
                if (executorC0521a.m870g()) {
                    return;
                }
                if (((int) (executorC0521a.controlState & 2097151)) <= executorC0521a.f1063d) {
                    return;
                }
                if (f1071k.compareAndSet(this, -1, 1)) {
                    int m852f = m852f();
                    m844n(0);
                    executorC0521a.m866k(this, m852f, 0);
                    int andDecrement = (int) (2097151 & ExecutorC0521a.f1060m.getAndDecrement(executorC0521a));
                    if (andDecrement != m852f) {
                        C0524c c0524c = executorC0521a.f1069j.get(andDecrement);
                        C0465i.m1051b(c0524c);
                        C0524c c0524c2 = c0524c;
                        executorC0521a.f1069j.set(m852f, c0524c2);
                        c0524c2.m844n(m852f);
                        executorC0521a.m866k(c0524c2, andDecrement, m852f);
                    }
                    executorC0521a.f1069j.set(andDecrement, null);
                    C0169q c0169q = C0169q.f235a;
                    this.f1073e = EnumC0525d.TERMINATED;
                }
            }
        }

        /* renamed from: e */
        public final AbstractRunnableC0533i m853e(boolean z) {
            AbstractRunnableC0533i m922d;
            if (m842p()) {
                return m854d(z);
            }
            if (!z || (m922d = this.f1072d.m822h()) == null) {
                m922d = ExecutorC0521a.this.f1068i.m922d();
            }
            return m922d == null ? m839s(true) : m922d;
        }

        /* renamed from: f */
        public final int m852f() {
            return this.indexInArray;
        }

        /* renamed from: g */
        public final Object m851g() {
            return this.nextParkedWorker;
        }

        /* renamed from: j */
        public final int m848j(int i) {
            int i2 = this.f1076h;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f1076h = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        /* renamed from: n */
        public final void m844n(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExecutorC0521a.this.f1066g);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        /* renamed from: o */
        public final void m843o(Object obj) {
            this.nextParkedWorker = obj;
        }

        /* renamed from: r */
        public final boolean m840r(EnumC0525d enumC0525d) {
            EnumC0525d enumC0525d2 = this.f1073e;
            boolean z = enumC0525d2 == EnumC0525d.CPU_ACQUIRED;
            if (z) {
                ExecutorC0521a.f1060m.addAndGet(ExecutorC0521a.this, 4398046511104L);
            }
            if (enumC0525d2 != enumC0525d) {
                this.f1073e = enumC0525d;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m845m();
        }
    }

    /* renamed from: kotlinx.coroutines.scheduling.a$d */
    /* loaded from: classes.dex */
    public enum EnumC0525d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public ExecutorC0521a(int i, int i2, long j, String str) {
        this.f1063d = i;
        this.f1064e = i2;
        this.f1065f = j;
        this.f1066g = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.f1067h = new C0528d();
        this.f1068i = new C0528d();
        this.parkedWorkersStack = 0L;
        this.f1069j = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = i << 42;
        this._isTerminated = 0;
    }

    /* renamed from: a */
    private final boolean m876a(AbstractRunnableC0533i abstractRunnableC0533i) {
        return (abstractRunnableC0533i.f1102e.mo831g() == 1 ? this.f1068i : this.f1067h).m925a(abstractRunnableC0533i);
    }

    /* renamed from: b */
    private final int m875b() {
        int m645a;
        int i;
        synchronized (this.f1069j) {
            if (m870g()) {
                i = -1;
            } else {
                long j = this.controlState;
                int i2 = (int) (j & 2097151);
                m645a = C0647f.m645a(i2 - ((int) ((j & 4398044413952L) >> 21)), 0);
                if (m645a >= this.f1063d) {
                    return 0;
                }
                if (i2 >= this.f1064e) {
                    return 0;
                }
                int i3 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i3 > 0 && this.f1069j.get(i3) == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                C0524c c0524c = new C0524c(i3);
                this.f1069j.set(i3, c0524c);
                if (!(i3 == ((int) (2097151 & f1060m.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c0524c.start();
                i = m645a + 1;
            }
            return i;
        }
    }

    /* renamed from: d */
    private final C0524c m873d() {
        Thread currentThread = Thread.currentThread();
        C0524c c0524c = currentThread instanceof C0524c ? (C0524c) currentThread : null;
        if (c0524c != null && C0465i.m1052a(ExecutorC0521a.this, this)) {
            return c0524c;
        }
        return null;
    }

    /* renamed from: f */
    public static /* synthetic */ void m871f(ExecutorC0521a executorC0521a, Runnable runnable, InterfaceC0534j interfaceC0534j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0534j = C0531g.f1099d;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        executorC0521a.m872e(runnable, interfaceC0534j, z);
    }

    /* renamed from: h */
    private final int m869h(C0524c c0524c) {
        int m852f;
        do {
            Object m851g = c0524c.m851g();
            if (m851g == f1062o) {
                return -1;
            }
            if (m851g == null) {
                return 0;
            }
            c0524c = (C0524c) m851g;
            m852f = c0524c.m852f();
        } while (m852f == 0);
        return m852f;
    }

    /* renamed from: i */
    private final C0524c m868i() {
        while (true) {
            long j = this.parkedWorkersStack;
            C0524c c0524c = this.f1069j.get((int) (2097151 & j));
            if (c0524c == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int m869h = m869h(c0524c);
            if (m869h >= 0 && f1059l.compareAndSet(this, j, m869h | j2)) {
                c0524c.m843o(f1062o);
                return c0524c;
            }
        }
    }

    /* renamed from: n */
    private final void m863n(boolean z) {
        long addAndGet = f1060m.addAndGet(this, 2097152L);
        if (z || m858s() || m860q(addAndGet)) {
            return;
        }
        m858s();
    }

    /* renamed from: p */
    private final AbstractRunnableC0533i m861p(C0524c c0524c, AbstractRunnableC0533i abstractRunnableC0533i, boolean z) {
        if (c0524c == null || c0524c.f1073e == EnumC0525d.TERMINATED) {
            return abstractRunnableC0533i;
        }
        if (abstractRunnableC0533i.f1102e.mo831g() == 0 && c0524c.f1073e == EnumC0525d.BLOCKING) {
            return abstractRunnableC0533i;
        }
        c0524c.f1077i = true;
        return c0524c.f1072d.m829a(abstractRunnableC0533i, z);
    }

    /* renamed from: q */
    private final boolean m860q(long j) {
        int m645a;
        m645a = C0647f.m645a(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0);
        if (m645a < this.f1063d) {
            int m875b = m875b();
            if (m875b == 1 && this.f1063d > 1) {
                m875b();
            }
            if (m875b > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    static /* synthetic */ boolean m859r(ExecutorC0521a executorC0521a, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = executorC0521a.controlState;
        }
        return executorC0521a.m860q(j);
    }

    /* renamed from: s */
    private final boolean m858s() {
        C0524c m868i;
        do {
            m868i = m868i();
            if (m868i == null) {
                return false;
            }
        } while (!C0524c.f1071k.compareAndSet(m868i, -1, 0));
        LockSupport.unpark(m868i);
        return true;
    }

    /* renamed from: c */
    public final AbstractRunnableC0533i m874c(Runnable runnable, InterfaceC0534j interfaceC0534j) {
        long mo832a = C0536l.f1109f.mo832a();
        if (runnable instanceof AbstractRunnableC0533i) {
            AbstractRunnableC0533i abstractRunnableC0533i = (AbstractRunnableC0533i) runnable;
            abstractRunnableC0533i.f1101d = mo832a;
            abstractRunnableC0533i.f1102e = interfaceC0534j;
            return abstractRunnableC0533i;
        }
        return new C0535k(runnable, mo832a, interfaceC0534j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m864m(10000L);
    }

    /* renamed from: e */
    public final void m872e(Runnable runnable, InterfaceC0534j interfaceC0534j, boolean z) {
        C0709c.m485a();
        AbstractRunnableC0533i m874c = m874c(runnable, interfaceC0534j);
        C0524c m873d = m873d();
        AbstractRunnableC0533i m861p = m861p(m873d, m874c, z);
        if (m861p != null && !m876a(m861p)) {
            throw new RejectedExecutionException(C0465i.m1043j(this.f1066g, " was terminated"));
        }
        boolean z2 = z && m873d != null;
        if (m874c.f1102e.mo831g() != 0) {
            m863n(z2);
        } else if (z2) {
        } else {
            m862o();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m871f(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: g */
    public final boolean m870g() {
        return this._isTerminated;
    }

    /* renamed from: j */
    public final boolean m867j(C0524c c0524c) {
        long j;
        long j2;
        int m852f;
        if (c0524c.m851g() != f1062o) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (2097151 & j);
            j2 = (2097152 + j) & (-2097152);
            m852f = c0524c.m852f();
            if (C0768p0.m398a()) {
                if (!(m852f != 0)) {
                    throw new AssertionError();
                }
            }
            c0524c.m843o(this.f1069j.get(i));
        } while (!f1059l.compareAndSet(this, j, m852f | j2));
        return true;
    }

    /* renamed from: k */
    public final void m866k(C0524c c0524c, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                i3 = i2 == 0 ? m869h(c0524c) : i2;
            }
            if (i3 >= 0 && f1059l.compareAndSet(this, j, j2 | i3)) {
                return;
            }
        }
    }

    /* renamed from: l */
    public final void m865l(AbstractRunnableC0533i abstractRunnableC0533i) {
        try {
            abstractRunnableC0533i.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: m */
    public final void m864m(long j) {
        int i;
        if (f1061n.compareAndSet(this, 0, 1)) {
            C0524c m873d = m873d();
            synchronized (this.f1069j) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    int i3 = i2 + 1;
                    C0524c c0524c = this.f1069j.get(i2);
                    C0465i.m1051b(c0524c);
                    C0524c c0524c2 = c0524c;
                    if (c0524c2 != m873d) {
                        while (c0524c2.isAlive()) {
                            LockSupport.unpark(c0524c2);
                            c0524c2.join(j);
                        }
                        EnumC0525d enumC0525d = c0524c2.f1073e;
                        if (C0768p0.m398a()) {
                            if (!(enumC0525d == EnumC0525d.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        c0524c2.f1072d.m823g(this.f1068i);
                    }
                    if (i2 == i) {
                        break;
                    }
                    i2 = i3;
                }
            }
            this.f1068i.m924b();
            this.f1067h.m924b();
            while (true) {
                AbstractRunnableC0533i m853e = m873d == null ? null : m873d.m853e(true);
                if (m853e == null && (m853e = this.f1067h.m922d()) == null && (m853e = this.f1068i.m922d()) == null) {
                    break;
                }
                m865l(m853e);
            }
            if (m873d != null) {
                m873d.m840r(EnumC0525d.TERMINATED);
            }
            if (C0768p0.m398a()) {
                if (!(((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.f1063d)) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    /* renamed from: o */
    public final void m862o() {
        if (m858s() || m859r(this, 0L, 1, null)) {
            return;
        }
        m858s();
    }

    public String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        StringBuilder sb;
        char c;
        ArrayList arrayList = new ArrayList();
        int length = this.f1069j.length();
        int i5 = 0;
        if (1 < length) {
            i2 = 0;
            int i6 = 0;
            i3 = 0;
            i4 = 0;
            int i7 = 1;
            while (true) {
                int i8 = i7 + 1;
                C0524c c0524c = this.f1069j.get(i7);
                if (c0524c != null) {
                    int m824f = c0524c.f1072d.m824f();
                    int i9 = C0523b.f1070a[c0524c.f1073e.ordinal()];
                    if (i9 != 1) {
                        if (i9 == 2) {
                            i2++;
                            sb = new StringBuilder();
                            sb.append(m824f);
                            c = 'b';
                        } else if (i9 == 3) {
                            i6++;
                            sb = new StringBuilder();
                            sb.append(m824f);
                            c = 'c';
                        } else if (i9 == 4) {
                            i3++;
                            if (m824f > 0) {
                                sb = new StringBuilder();
                                sb.append(m824f);
                                c = 'd';
                            }
                        } else if (i9 == 5) {
                            i4++;
                        }
                        sb.append(c);
                        arrayList.add(sb.toString());
                    } else {
                        i5++;
                    }
                }
                if (i8 >= length) {
                    break;
                }
                i7 = i8;
            }
            i = i5;
            i5 = i6;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        long j = this.controlState;
        return this.f1066g + '@' + C0771q0.m391b(this) + "[Pool Size {core = " + this.f1063d + ", max = " + this.f1064e + "}, Worker States {CPU = " + i5 + ", blocking = " + i2 + ", parked = " + i + ", dormant = " + i3 + ", terminated = " + i4 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f1067h.m923c() + ", global blocking queue size = " + this.f1068i.m923c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f1063d - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }
}