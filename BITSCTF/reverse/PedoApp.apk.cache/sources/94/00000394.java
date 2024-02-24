package p048w0;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;
import p040s0.C0647f;
import p046v0.C0690l;

/* renamed from: w0.v */
/* loaded from: classes.dex */
public final class C0785v extends AbstractC0725f1 {

    /* renamed from: f */
    public static final C0785v f1373f = new C0785v();

    /* renamed from: g */
    private static final int f1374g;

    /* renamed from: h */
    private static boolean f1375h;
    private static volatile Executor pool;

    static {
        String str;
        Integer m564f;
        int intValue;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            intValue = -1;
        } else {
            m564f = C0690l.m564f(str);
            if (m564f == null || m564f.intValue() < 1) {
                throw new IllegalStateException(C0465i.m1043j("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            intValue = m564f.intValue();
        }
        f1374g = intValue;
    }

    private C0785v() {
    }

    /* renamed from: q */
    public static /* synthetic */ void m357q() {
        m349y();
    }

    /* renamed from: r */
    public static /* synthetic */ Thread m356r(AtomicInteger atomicInteger, Runnable runnable) {
        return m354t(atomicInteger, runnable);
    }

    /* renamed from: s */
    private final ExecutorService m355s() {
        final AtomicInteger atomicInteger = new AtomicInteger();
        return Executors.newFixedThreadPool(m351w(), new ThreadFactory() { // from class: w0.u
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C0785v.m356r(atomicInteger, runnable);
            }
        });
    }

    /* renamed from: t */
    public static final Thread m354t(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, C0465i.m1043j("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x003d  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.concurrent.ExecutorService m353u() {
        /*
            r6 = this;
            java.lang.SecurityManager r0 = java.lang.System.getSecurityManager()
            if (r0 == 0) goto Lb
            java.util.concurrent.ExecutorService r0 = r6.m355s()
            return r0
        Lb:
            r0 = 0
            java.lang.String r1 = "java.util.concurrent.ForkJoinPool"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L13
            goto L14
        L13:
            r1 = r0
        L14:
            if (r1 != 0) goto L1b
            java.util.concurrent.ExecutorService r0 = r6.m355s()
            return r0
        L1b:
            boolean r2 = p048w0.C0785v.f1375h
            r3 = 0
            if (r2 != 0) goto L4b
            int r2 = p048w0.C0785v.f1374g
            if (r2 >= 0) goto L4b
            java.lang.String r2 = "commonPool"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L39
            java.lang.reflect.Method r2 = r1.getMethod(r2, r4)     // Catch: java.lang.Throwable -> L39
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L39
            java.lang.Object r2 = r2.invoke(r0, r4)     // Catch: java.lang.Throwable -> L39
            boolean r4 = r2 instanceof java.util.concurrent.ExecutorService     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L39
            java.util.concurrent.ExecutorService r2 = (java.util.concurrent.ExecutorService) r2     // Catch: java.lang.Throwable -> L39
            goto L3a
        L39:
            r2 = r0
        L3a:
            if (r2 != 0) goto L3d
            goto L4b
        L3d:
            w0.v r4 = p048w0.C0785v.f1373f
            boolean r4 = r4.m350x(r1, r2)
            if (r4 == 0) goto L46
            goto L47
        L46:
            r2 = r0
        L47:
            if (r2 != 0) goto L4a
            goto L4b
        L4a:
            return r2
        L4b:
            r2 = 1
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L70
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L70
            r4[r3] = r5     // Catch: java.lang.Throwable -> L70
            java.lang.reflect.Constructor r1 = r1.getConstructor(r4)     // Catch: java.lang.Throwable -> L70
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L70
            w0.v r4 = p048w0.C0785v.f1373f     // Catch: java.lang.Throwable -> L70
            int r4 = r4.m351w()     // Catch: java.lang.Throwable -> L70
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L70
            r2[r3] = r4     // Catch: java.lang.Throwable -> L70
            java.lang.Object r1 = r1.newInstance(r2)     // Catch: java.lang.Throwable -> L70
            boolean r2 = r1 instanceof java.util.concurrent.ExecutorService     // Catch: java.lang.Throwable -> L70
            if (r2 == 0) goto L71
            java.util.concurrent.ExecutorService r1 = (java.util.concurrent.ExecutorService) r1     // Catch: java.lang.Throwable -> L70
            r0 = r1
            goto L71
        L70:
        L71:
            if (r0 != 0) goto L77
            java.util.concurrent.ExecutorService r0 = r6.m355s()
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p048w0.C0785v.m353u():java.util.concurrent.ExecutorService");
    }

    /* renamed from: v */
    private final synchronized Executor m352v() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = m353u();
            pool = executor;
        }
        return executor;
    }

    /* renamed from: w */
    private final int m351w() {
        int m645a;
        Integer valueOf = Integer.valueOf(f1374g);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf == null) {
            m645a = C0647f.m645a(Runtime.getRuntime().availableProcessors() - 1, 1);
            return m645a;
        }
        return valueOf.intValue();
    }

    /* renamed from: y */
    public static final void m349y() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: o */
    public void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = m352v();
            }
            C0709c.m485a();
            executor.execute(runnable);
        } catch (RejectedExecutionException unused) {
            C0709c.m485a();
            RunnableC0774r0.f1365j.m505G(runnable);
        }
    }

    @Override // p048w0.AbstractC0722f0
    public String toString() {
        return "CommonPool";
    }

    /* renamed from: x */
    public final boolean m350x(Class<?> cls, ExecutorService executorService) {
        executorService.submit(new Runnable() { // from class: w0.t
            @Override // java.lang.Runnable
            public final void run() {
                C0785v.m357q();
            }
        });
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            }
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }
}