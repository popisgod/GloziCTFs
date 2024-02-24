package p048w0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0476c;
import kotlinx.coroutines.internal.C0484e0;
import kotlinx.coroutines.internal.C0508q;
import kotlinx.coroutines.internal.C0520z;
import kotlinx.coroutines.internal.InterfaceC0486f0;
import p020i0.InterfaceC0249g;
import p040s0.C0647f;

/* renamed from: w0.a1 */
/* loaded from: classes.dex */
public abstract class AbstractC0701a1 extends AbstractC0707b1 {

    /* renamed from: h */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1306h = AtomicReferenceFieldUpdater.newUpdater(AbstractC0701a1.class, Object.class, "_queue");

    /* renamed from: i */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1307i = AtomicReferenceFieldUpdater.newUpdater(AbstractC0701a1.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* renamed from: w0.a1$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractRunnableC0702a implements Runnable, Comparable<AbstractRunnableC0702a>, InterfaceC0795x0, InterfaceC0486f0 {

        /* renamed from: d */
        public long f1308d;

        /* renamed from: e */
        private Object f1309e;

        /* renamed from: f */
        private int f1310f;

        @Override // kotlinx.coroutines.internal.InterfaceC0486f0
        /* renamed from: a */
        public C0484e0<?> mo494a() {
            Object obj = this.f1309e;
            if (obj instanceof C0484e0) {
                return (C0484e0) obj;
            }
            return null;
        }

        @Override // p048w0.InterfaceC0795x0
        /* renamed from: b */
        public final synchronized void mo262b() {
            C0520z c0520z;
            C0520z c0520z2;
            Object obj = this.f1309e;
            c0520z = C0715d1.f1315a;
            if (obj == c0520z) {
                return;
            }
            C0703b c0703b = obj instanceof C0703b ? (C0703b) obj : null;
            if (c0703b != null) {
                c0703b.m985g(this);
            }
            c0520z2 = C0715d1.f1315a;
            this.f1309e = c0520z2;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC0486f0
        /* renamed from: c */
        public void mo493c(int i) {
            this.f1310f = i;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC0486f0
        /* renamed from: d */
        public void mo492d(C0484e0<?> c0484e0) {
            C0520z c0520z;
            Object obj = this.f1309e;
            c0520z = C0715d1.f1315a;
            if (!(obj != c0520z)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f1309e = c0484e0;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC0486f0
        /* renamed from: e */
        public int mo491e() {
            return this.f1310f;
        }

        @Override // java.lang.Comparable
        /* renamed from: f */
        public int compareTo(AbstractRunnableC0702a abstractRunnableC0702a) {
            long j = this.f1308d - abstractRunnableC0702a.f1308d;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x0040 A[Catch: all -> 0x0048, TryCatch #1 {, blocks: (B:43:0x0001, B:48:0x000c, B:52:0x001a, B:69:0x0045, B:49:0x000d, B:57:0x0021, B:65:0x0037, B:67:0x0040, B:68:0x0042, B:58:0x0024, B:62:0x002e), top: B:79:0x0001 }] */
        /* renamed from: h */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized int m489h(long r8, p048w0.AbstractC0701a1.C0703b r10, p048w0.AbstractC0701a1 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7.f1309e     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.z r1 = p048w0.C0715d1.m478b()     // Catch: java.lang.Throwable -> L4b
                if (r0 != r1) goto Lc
                r8 = 2
            La:
                monitor-exit(r7)
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.f0 r0 = r10.m990b()     // Catch: java.lang.Throwable -> L48
                w0.a1$a r0 = (p048w0.AbstractC0701a1.AbstractRunnableC0702a) r0     // Catch: java.lang.Throwable -> L48
                boolean r11 = p048w0.AbstractC0701a1.m508D(r11)     // Catch: java.lang.Throwable -> L48
                if (r11 == 0) goto L1d
                r8 = 1
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                monitor-exit(r7)
                return r8
            L1d:
                r1 = 0
                if (r0 != 0) goto L24
            L21:
                r10.f1311b = r8     // Catch: java.lang.Throwable -> L48
                goto L37
            L24:
                long r3 = r0.f1308d     // Catch: java.lang.Throwable -> L48
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L2d
                goto L2e
            L2d:
                r8 = r3
            L2e:
                long r3 = r10.f1311b     // Catch: java.lang.Throwable -> L48
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L37
                goto L21
            L37:
                long r8 = r7.f1308d     // Catch: java.lang.Throwable -> L48
                long r3 = r10.f1311b     // Catch: java.lang.Throwable -> L48
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L42
                r7.f1308d = r3     // Catch: java.lang.Throwable -> L48
            L42:
                r10.m991a(r7)     // Catch: java.lang.Throwable -> L48
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                r8 = 0
                goto La
            L48:
                r8 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                throw r8     // Catch: java.lang.Throwable -> L4b
            L4b:
                r8 = move-exception
                monitor-exit(r7)
                goto L4f
            L4e:
                throw r8
            L4f:
                goto L4e
            */
            throw new UnsupportedOperationException("Method not decompiled: p048w0.AbstractC0701a1.AbstractRunnableC0702a.m489h(long, w0.a1$b, w0.a1):int");
        }

        /* renamed from: i */
        public final boolean m488i(long j) {
            return j - this.f1308d >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f1308d + ']';
        }
    }

    /* renamed from: w0.a1$b */
    /* loaded from: classes.dex */
    public static final class C0703b extends C0484e0<AbstractRunnableC0702a> {

        /* renamed from: b */
        public long f1311b;

        public C0703b(long j) {
            this.f1311b = j;
        }
    }

    /* renamed from: E */
    private final void m507E() {
        C0520z c0520z;
        C0520z c0520z2;
        if (C0768p0.m398a() && !m503I()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1306h;
                c0520z = C0715d1.f1316b;
                if (C0476c.m1006a(atomicReferenceFieldUpdater, this, null, c0520z)) {
                    return;
                }
            } else if (obj instanceof C0508q) {
                ((C0508q) obj).m918d();
                return;
            } else {
                c0520z2 = C0715d1.f1316b;
                if (obj == c0520z2) {
                    return;
                }
                C0508q c0508q = new C0508q(8, true);
                c0508q.m921a((Runnable) obj);
                if (C0476c.m1006a(f1306h, this, obj, c0508q)) {
                    return;
                }
            }
        }
    }

    /* renamed from: F */
    private final Runnable m506F() {
        C0520z c0520z;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof C0508q) {
                C0508q c0508q = (C0508q) obj;
                Object m912j = c0508q.m912j();
                if (m912j != C0508q.f1038h) {
                    return (Runnable) m912j;
                }
                C0476c.m1006a(f1306h, this, obj, c0508q.m913i());
            } else {
                c0520z = C0715d1.f1316b;
                if (obj == c0520z) {
                    return null;
                }
                if (C0476c.m1006a(f1306h, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    /* renamed from: H */
    private final boolean m504H(Runnable runnable) {
        C0520z c0520z;
        while (true) {
            Object obj = this._queue;
            if (m503I()) {
                return false;
            }
            if (obj == null) {
                if (C0476c.m1006a(f1306h, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C0508q) {
                C0508q c0508q = (C0508q) obj;
                int m921a = c0508q.m921a(runnable);
                if (m921a == 0) {
                    return true;
                }
                if (m921a == 1) {
                    C0476c.m1006a(f1306h, this, obj, c0508q.m913i());
                } else if (m921a == 2) {
                    return false;
                }
            } else {
                c0520z = C0715d1.f1316b;
                if (obj == c0520z) {
                    return false;
                }
                C0508q c0508q2 = new C0508q(8, true);
                c0508q2.m921a((Runnable) obj);
                c0508q2.m921a(runnable);
                if (C0476c.m1006a(f1306h, this, obj, c0508q2)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: I */
    public final boolean m503I() {
        return this._isCompleted;
    }

    /* renamed from: L */
    private final void m500L() {
        C0709c.m485a();
        long nanoTime = System.nanoTime();
        while (true) {
            C0703b c0703b = (C0703b) this._delayed;
            AbstractRunnableC0702a m983i = c0703b == null ? null : c0703b.m983i();
            if (m983i == null) {
                return;
            }
            m487B(nanoTime, m983i);
        }
    }

    /* renamed from: O */
    private final int m497O(long j, AbstractRunnableC0702a abstractRunnableC0702a) {
        if (m503I()) {
            return 1;
        }
        C0703b c0703b = (C0703b) this._delayed;
        if (c0703b == null) {
            C0476c.m1006a(f1307i, this, null, new C0703b(j));
            Object obj = this._delayed;
            C0465i.m1051b(obj);
            c0703b = (C0703b) obj;
        }
        return abstractRunnableC0702a.m489h(j, c0703b, this);
    }

    /* renamed from: P */
    private final void m496P(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    /* renamed from: Q */
    private final boolean m495Q(AbstractRunnableC0702a abstractRunnableC0702a) {
        C0703b c0703b = (C0703b) this._delayed;
        return (c0703b == null ? null : c0703b.m987e()) == abstractRunnableC0702a;
    }

    /* renamed from: G */
    public final void m505G(Runnable runnable) {
        if (m504H(runnable)) {
            m486C();
        } else {
            RunnableC0774r0.f1365j.m505G(runnable);
        }
    }

    /* renamed from: J */
    public boolean m502J() {
        C0520z c0520z;
        if (m250x()) {
            C0703b c0703b = (C0703b) this._delayed;
            if (c0703b == null || c0703b.m988d()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof C0508q) {
                        return ((C0508q) obj).m915g();
                    }
                    c0520z = C0715d1.f1316b;
                    if (obj != c0520z) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x004f  */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m501K() {
        /*
            r9 = this;
            boolean r0 = r9.m249y()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            w0.a1$b r0 = (p048w0.AbstractC0701a1.C0703b) r0
            if (r0 == 0) goto L45
            boolean r3 = r0.m988d()
            if (r3 != 0) goto L45
            p048w0.C0709c.m485a()
            long r3 = java.lang.System.nanoTime()
        L1c:
            monitor-enter(r0)
            kotlinx.coroutines.internal.f0 r5 = r0.m990b()     // Catch: java.lang.Throwable -> L42
            r6 = 0
            if (r5 != 0) goto L26
        L24:
            monitor-exit(r0)
            goto L3d
        L26:
            w0.a1$a r5 = (p048w0.AbstractC0701a1.AbstractRunnableC0702a) r5     // Catch: java.lang.Throwable -> L42
            boolean r7 = r5.m488i(r3)     // Catch: java.lang.Throwable -> L42
            r8 = 0
            if (r7 == 0) goto L34
            boolean r5 = r9.m504H(r5)     // Catch: java.lang.Throwable -> L42
            goto L35
        L34:
            r5 = 0
        L35:
            if (r5 == 0) goto L24
            kotlinx.coroutines.internal.f0 r5 = r0.m984h(r8)     // Catch: java.lang.Throwable -> L42
            r6 = r5
            goto L24
        L3d:
            w0.a1$a r6 = (p048w0.AbstractC0701a1.AbstractRunnableC0702a) r6
            if (r6 != 0) goto L1c
            goto L45
        L42:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L45:
            java.lang.Runnable r0 = r9.m506F()
            if (r0 == 0) goto L4f
            r0.run()
            return r1
        L4f:
            long r0 = r9.mo254t()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p048w0.AbstractC0701a1.m501K():long");
    }

    /* renamed from: M */
    public final void m499M() {
        this._queue = null;
        this._delayed = null;
    }

    /* renamed from: N */
    public final void m498N(long j, AbstractRunnableC0702a abstractRunnableC0702a) {
        int m497O = m497O(j, abstractRunnableC0702a);
        if (m497O == 0) {
            if (m495Q(abstractRunnableC0702a)) {
                m486C();
            }
        } else if (m497O == 1) {
            m487B(j, abstractRunnableC0702a);
        } else if (m497O != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: o */
    public final void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        m505G(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p048w0.AbstractC0801z0
    /* renamed from: t */
    public long mo254t() {
        long m644b;
        C0520z c0520z;
        if (super.mo254t() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof C0508q)) {
                c0520z = C0715d1.f1316b;
                return obj == c0520z ? Long.MAX_VALUE : 0L;
            } else if (!((C0508q) obj).m915g()) {
                return 0L;
            }
        }
        C0703b c0703b = (C0703b) this._delayed;
        AbstractRunnableC0702a m987e = c0703b == null ? null : c0703b.m987e();
        if (m987e == null) {
            return Long.MAX_VALUE;
        }
        long j = m987e.f1308d;
        C0709c.m485a();
        m644b = C0647f.m644b(j - System.nanoTime(), 0L);
        return m644b;
    }

    @Override // p048w0.AbstractC0801z0
    /* renamed from: z */
    protected void mo248z() {
        C0728f2.f1323a.m466b();
        m496P(true);
        m507E();
        do {
        } while (m501K() <= 0);
        m500L();
    }
}