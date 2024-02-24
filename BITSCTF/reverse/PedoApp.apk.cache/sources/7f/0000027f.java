package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C0461e;
import p048w0.C0768p0;

/* renamed from: kotlinx.coroutines.internal.q */
/* loaded from: classes.dex */
public final class C0508q<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a */
    private final int f1039a;

    /* renamed from: b */
    private final boolean f1040b;

    /* renamed from: c */
    private final int f1041c;

    /* renamed from: d */
    private /* synthetic */ AtomicReferenceArray f1042d;

    /* renamed from: e */
    public static final C0509a f1035e = new C0509a(null);

    /* renamed from: h */
    public static final C0520z f1038h = new C0520z("REMOVE_FROZEN");

    /* renamed from: f */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1036f = AtomicReferenceFieldUpdater.newUpdater(C0508q.class, Object.class, "_next");

    /* renamed from: g */
    private static final /* synthetic */ AtomicLongFieldUpdater f1037g = AtomicLongFieldUpdater.newUpdater(C0508q.class, "_state");

    /* renamed from: kotlinx.coroutines.internal.q$a */
    /* loaded from: classes.dex */
    public static final class C0509a {
        private C0509a() {
        }

        public /* synthetic */ C0509a(C0461e c0461e) {
            this();
        }

        /* renamed from: a */
        public final int m910a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        /* renamed from: b */
        public final long m909b(long j, int i) {
            return m907d(j, 1073741823L) | (i << 0);
        }

        /* renamed from: c */
        public final long m908c(long j, int i) {
            return m907d(j, 1152921503533105152L) | (i << 30);
        }

        /* renamed from: d */
        public final long m907d(long j, long j2) {
            return j & (j2 ^ (-1));
        }
    }

    /* renamed from: kotlinx.coroutines.internal.q$b */
    /* loaded from: classes.dex */
    public static final class C0510b {

        /* renamed from: a */
        public final int f1043a;

        public C0510b(int i) {
            this.f1043a = i;
        }
    }

    public C0508q(int i, boolean z) {
        this.f1039a = i;
        this.f1040b = z;
        int i2 = i - 1;
        this.f1041c = i2;
        this.f1042d = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i & i2) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private final C0508q<E> m920b(long j) {
        C0508q<E> c0508q = new C0508q<>(this.f1039a * 2, this.f1040b);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.f1041c;
            if ((i & i3) == (i2 & i3)) {
                c0508q._state = f1035e.m907d(j, 1152921504606846976L);
                return c0508q;
            }
            Object obj = this.f1042d.get(i3 & i);
            if (obj == null) {
                obj = new C0510b(i);
            }
            c0508q.f1042d.set(c0508q.f1041c & i, obj);
            i++;
        }
    }

    /* renamed from: c */
    private final C0508q<E> m919c(long j) {
        while (true) {
            C0508q<E> c0508q = (C0508q) this._next;
            if (c0508q != null) {
                return c0508q;
            }
            C0476c.m1006a(f1036f, this, null, m920b(j));
        }
    }

    /* renamed from: e */
    private final C0508q<E> m917e(int i, E e) {
        Object obj = this.f1042d.get(this.f1041c & i);
        if ((obj instanceof C0510b) && ((C0510b) obj).f1043a == i) {
            this.f1042d.set(i & this.f1041c, e);
            return this;
        }
        return null;
    }

    /* renamed from: h */
    private final long m914h() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f1037g.compareAndSet(this, j, j2));
        return j2;
    }

    /* renamed from: k */
    private final C0508q<E> m911k(int i, int i2) {
        long j;
        C0509a c0509a;
        int i3;
        do {
            j = this._state;
            c0509a = f1035e;
            i3 = (int) ((1073741823 & j) >> 0);
            if (C0768p0.m398a()) {
                if (!(i3 == i)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return m913i();
            }
        } while (!f1037g.compareAndSet(this, j, c0509a.m909b(j, i2)));
        this.f1042d.set(this.f1041c & i3, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        return 1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m921a(E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.q$a r14 = kotlinx.coroutines.internal.C0508q.f1035e
            int r14 = r14.m910a(r2)
            return r14
        L12:
            kotlinx.coroutines.internal.q$a r0 = kotlinx.coroutines.internal.C0508q.f1035e
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.f1041c
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.f1040b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f1042d
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.f1039a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r11
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.C0508q.f1037g
            long r11 = r0.m908c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f1042d
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L73
            goto L7d
        L73:
            kotlinx.coroutines.internal.q r0 = r0.m913i()
            kotlinx.coroutines.internal.q r0 = r0.m917e(r9, r14)
            if (r0 != 0) goto L69
        L7d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C0508q.m921a(java.lang.Object):int");
    }

    /* renamed from: d */
    public final boolean m918d() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f1037g.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* renamed from: f */
    public final int m916f() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    /* renamed from: g */
    public final boolean m915g() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* renamed from: i */
    public final C0508q<E> m913i() {
        return m919c(m914h());
    }

    /* renamed from: j */
    public final Object m912j() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return f1038h;
            }
            C0509a c0509a = f1035e;
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.f1041c;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.f1042d.get(i3 & i);
            if (obj == null) {
                if (this.f1040b) {
                    return null;
                }
            } else if (obj instanceof C0510b) {
                return null;
            } else {
                int i4 = (i + 1) & 1073741823;
                if (f1037g.compareAndSet(this, j, c0509a.m909b(j, i4))) {
                    this.f1042d.set(this.f1041c & i, null);
                    return obj;
                } else if (this.f1040b) {
                    C0508q<E> c0508q = this;
                    do {
                        c0508q = c0508q.m911k(i, i4);
                    } while (c0508q != null);
                    return obj;
                }
            }
        }
    }
}