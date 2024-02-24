package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C0465i;

/* renamed from: kotlinx.coroutines.internal.o */
/* loaded from: classes.dex */
public class C0504o {

    /* renamed from: d */
    static final /* synthetic */ AtomicReferenceFieldUpdater f1029d = AtomicReferenceFieldUpdater.newUpdater(C0504o.class, Object.class, "_next");

    /* renamed from: e */
    static final /* synthetic */ AtomicReferenceFieldUpdater f1030e = AtomicReferenceFieldUpdater.newUpdater(C0504o.class, Object.class, "_prev");

    /* renamed from: f */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1031f = AtomicReferenceFieldUpdater.newUpdater(C0504o.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* renamed from: kotlinx.coroutines.internal.o$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0505a extends AbstractC0478d<C0504o> {

        /* renamed from: b */
        public final C0504o f1032b;

        /* renamed from: c */
        public C0504o f1033c;

        public AbstractC0505a(C0504o c0504o) {
            this.f1032b = c0504o;
        }

        @Override // kotlinx.coroutines.internal.AbstractC0478d
        /* renamed from: h */
        public void mo927d(C0504o c0504o, Object obj) {
            boolean z = obj == null;
            C0504o c0504o2 = z ? this.f1032b : this.f1033c;
            if (c0504o2 != null && C0476c.m1006a(C0504o.f1029d, c0504o, this, c0504o2) && z) {
                C0504o c0504o3 = this.f1032b;
                C0504o c0504o4 = this.f1033c;
                C0465i.m1051b(c0504o4);
                c0504o3.m938n(c0504o4);
            }
        }
    }

    /* renamed from: kotlinx.coroutines.internal.o$b */
    /* loaded from: classes.dex */
    public static final class C0506b extends AbstractC0516v {
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (kotlinx.coroutines.internal.C0476c.m1006a(kotlinx.coroutines.internal.C0504o.f1029d, r3, r2, ((kotlinx.coroutines.internal.C0517w) r4).f1053a) != false) goto L23;
     */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlinx.coroutines.internal.C0504o m940l(kotlinx.coroutines.internal.AbstractC0516v r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.C0504o) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.C0504o.f1030e
            boolean r0 = kotlinx.coroutines.internal.C0476c.m1006a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.mo932t()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.AbstractC0516v
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.v r0 = (kotlinx.coroutines.internal.AbstractC0516v) r0
            boolean r0 = r8.m893b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.v r4 = (kotlinx.coroutines.internal.AbstractC0516v) r4
            r4.mo892c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.C0517w
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.C0504o.f1029d
            kotlinx.coroutines.internal.w r4 = (kotlinx.coroutines.internal.C0517w) r4
            kotlinx.coroutines.internal.o r4 = r4.f1053a
            boolean r2 = kotlinx.coroutines.internal.C0476c.m1006a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.o r2 = (kotlinx.coroutines.internal.C0504o) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.o r3 = (kotlinx.coroutines.internal.C0504o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C0504o.m940l(kotlinx.coroutines.internal.v):kotlinx.coroutines.internal.o");
    }

    /* renamed from: m */
    private final C0504o m939m(C0504o c0504o) {
        while (c0504o.mo932t()) {
            c0504o = (C0504o) c0504o._prev;
        }
        return c0504o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public final void m938n(C0504o c0504o) {
        C0504o c0504o2;
        do {
            c0504o2 = (C0504o) c0504o._prev;
            if (m937o() != c0504o) {
                return;
            }
        } while (!C0476c.m1006a(f1030e, c0504o, c0504o2, this));
        if (mo932t()) {
            c0504o.m940l(null);
        }
    }

    /* renamed from: w */
    private final C0517w m929w() {
        C0517w c0517w = (C0517w) this._removedRef;
        if (c0517w == null) {
            C0517w c0517w2 = new C0517w(this);
            f1031f.lazySet(this, c0517w2);
            return c0517w2;
        }
        return c0517w;
    }

    /* renamed from: j */
    public final boolean m942j(C0504o c0504o, C0504o c0504o2) {
        f1030e.lazySet(c0504o, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1029d;
        atomicReferenceFieldUpdater.lazySet(c0504o, c0504o2);
        if (C0476c.m1006a(atomicReferenceFieldUpdater, this, c0504o2, c0504o)) {
            c0504o.m938n(c0504o2);
            return true;
        }
        return false;
    }

    /* renamed from: k */
    public final boolean m941k(C0504o c0504o) {
        f1030e.lazySet(c0504o, this);
        f1029d.lazySet(c0504o, this);
        while (m937o() == this) {
            if (C0476c.m1006a(f1029d, this, this, c0504o)) {
                c0504o.m938n(this);
                return true;
            }
        }
        return false;
    }

    /* renamed from: o */
    public final Object m937o() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof AbstractC0516v)) {
                return obj;
            }
            ((AbstractC0516v) obj).mo892c(this);
        }
    }

    /* renamed from: p */
    public final C0504o m936p() {
        return C0503n.m944b(m937o());
    }

    /* renamed from: q */
    public final C0504o m935q() {
        C0504o m940l = m940l(null);
        return m940l == null ? m939m((C0504o) this._prev) : m940l;
    }

    /* renamed from: r */
    public final void m934r() {
        ((C0517w) m937o()).f1053a.m933s();
    }

    /* renamed from: s */
    public final void m933s() {
        C0504o c0504o = this;
        while (true) {
            Object m937o = c0504o.m937o();
            if (!(m937o instanceof C0517w)) {
                c0504o.m940l(null);
                return;
            }
            c0504o = ((C0517w) m937o).f1053a;
        }
    }

    /* renamed from: t */
    public boolean mo932t() {
        return m937o() instanceof C0517w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }

    /* renamed from: u */
    public boolean m931u() {
        return m930v() == null;
    }

    /* renamed from: v */
    public final C0504o m930v() {
        Object m937o;
        C0504o c0504o;
        do {
            m937o = m937o();
            if (m937o instanceof C0517w) {
                return ((C0517w) m937o).f1053a;
            }
            if (m937o == this) {
                return (C0504o) m937o;
            }
            c0504o = (C0504o) m937o;
        } while (!C0476c.m1006a(f1029d, this, m937o, c0504o.m929w()));
        c0504o.m940l(null);
        return null;
    }

    /* renamed from: x */
    public final int m928x(C0504o c0504o, C0504o c0504o2, AbstractC0505a abstractC0505a) {
        f1030e.lazySet(c0504o, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1029d;
        atomicReferenceFieldUpdater.lazySet(c0504o, c0504o2);
        abstractC0505a.f1033c = c0504o2;
        if (C0476c.m1006a(atomicReferenceFieldUpdater, this, c0504o2, abstractC0505a)) {
            return abstractC0505a.mo892c(this) == null ? 1 : 2;
        }
        return 0;
    }
}