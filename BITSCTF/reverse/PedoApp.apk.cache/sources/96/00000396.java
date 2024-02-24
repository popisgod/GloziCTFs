package p048w0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.AbstractC0516v;
import kotlinx.coroutines.internal.C0476c;
import kotlinx.coroutines.internal.C0503n;
import kotlinx.coroutines.internal.C0504o;
import kotlinx.coroutines.internal.C0519y;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0152b;
import p014f0.C0169q;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0611l;
import p034p0.InterfaceC0615p;
import p048w0.InterfaceC0764o1;

/* renamed from: w0.v1 */
/* loaded from: classes.dex */
public class C0787v1 implements InterfaceC0764o1, InterfaceC0776s, InterfaceC0712c2 {

    /* renamed from: d */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1377d = AtomicReferenceFieldUpdater.newUpdater(C0787v1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* renamed from: w0.v1$a */
    /* loaded from: classes.dex */
    public static final class C0788a extends AbstractC0784u1 {

        /* renamed from: h */
        private final C0787v1 f1378h;

        /* renamed from: i */
        private final C0789b f1379i;

        /* renamed from: j */
        private final C0773r f1380j;

        /* renamed from: k */
        private final Object f1381k;

        public C0788a(C0787v1 c0787v1, C0789b c0789b, C0773r c0773r, Object obj) {
            this.f1378h = c0787v1;
            this.f1379i = c0789b;
            this.f1380j = c0773r;
            this.f1381k = obj;
        }

        @Override // p034p0.InterfaceC0611l
        public /* bridge */ /* synthetic */ C0169q invoke(Throwable th) {
            mo289y(th);
            return C0169q.f235a;
        }

        @Override // p048w0.AbstractC0700a0
        /* renamed from: y */
        public void mo289y(Throwable th) {
            this.f1378h.m343F(this.f1379i, this.f1380j, this.f1381k);
        }
    }

    /* renamed from: w0.v1$b */
    /* loaded from: classes.dex */
    public static final class C0789b implements InterfaceC0744j1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: d */
        private final C0802z1 f1382d;

        public C0789b(C0802z1 c0802z1, boolean z, Throwable th) {
            this.f1382d = c0802z1;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* renamed from: d */
        private final ArrayList<Throwable> m287d() {
            return new ArrayList<>(4);
        }

        /* renamed from: e */
        private final Object m286e() {
            return this._exceptionsHolder;
        }

        /* renamed from: l */
        private final void m279l(Object obj) {
            this._exceptionsHolder = obj;
        }

        @Override // p048w0.InterfaceC0744j1
        /* renamed from: a */
        public boolean mo247a() {
            return m285f() == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        public final void m288b(Throwable th) {
            Throwable m285f = m285f();
            if (m285f == null) {
                m278m(th);
            } else if (th == m285f) {
            } else {
                Object m286e = m286e();
                if (m286e == null) {
                    m279l(th);
                } else if (!(m286e instanceof Throwable)) {
                    if (!(m286e instanceof ArrayList)) {
                        throw new IllegalStateException(C0465i.m1043j("State is ", m286e).toString());
                    }
                    ((ArrayList) m286e).add(th);
                } else if (th == m286e) {
                } else {
                    ArrayList<Throwable> m287d = m287d();
                    m287d.add(m286e);
                    m287d.add(th);
                    C0169q c0169q = C0169q.f235a;
                    m279l(m287d);
                }
            }
        }

        @Override // p048w0.InterfaceC0744j1
        /* renamed from: c */
        public C0802z1 mo246c() {
            return this.f1382d;
        }

        /* renamed from: f */
        public final Throwable m285f() {
            return (Throwable) this._rootCause;
        }

        /* renamed from: g */
        public final boolean m284g() {
            return m285f() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        /* renamed from: h */
        public final boolean m283h() {
            return this._isCompleting;
        }

        /* renamed from: i */
        public final boolean m282i() {
            C0520z c0520z;
            Object m286e = m286e();
            c0520z = C0793w1.f1394e;
            return m286e == c0520z;
        }

        /* renamed from: j */
        public final List<Throwable> m281j(Throwable th) {
            ArrayList<Throwable> arrayList;
            C0520z c0520z;
            Object m286e = m286e();
            if (m286e == null) {
                arrayList = m287d();
            } else if (m286e instanceof Throwable) {
                ArrayList<Throwable> m287d = m287d();
                m287d.add(m286e);
                arrayList = m287d;
            } else if (!(m286e instanceof ArrayList)) {
                throw new IllegalStateException(C0465i.m1043j("State is ", m286e).toString());
            } else {
                arrayList = (ArrayList) m286e;
            }
            Throwable m285f = m285f();
            if (m285f != null) {
                arrayList.add(0, m285f);
            }
            if (th != null && !C0465i.m1052a(th, m285f)) {
                arrayList.add(th);
            }
            c0520z = C0793w1.f1394e;
            m279l(c0520z);
            return arrayList;
        }

        /* renamed from: k */
        public final void m280k(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        /* renamed from: m */
        public final void m278m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + m284g() + ", completing=" + m283h() + ", rootCause=" + m285f() + ", exceptions=" + m286e() + ", list=" + mo246c() + ']';
        }
    }

    /* renamed from: w0.v1$c */
    /* loaded from: classes.dex */
    public static final class C0790c extends C0504o.AbstractC0505a {

        /* renamed from: d */
        final /* synthetic */ C0504o f1383d;

        /* renamed from: e */
        final /* synthetic */ C0787v1 f1384e;

        /* renamed from: f */
        final /* synthetic */ Object f1385f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0790c(C0504o c0504o, C0787v1 c0787v1, Object obj) {
            super(c0504o);
            this.f1383d = c0504o;
            this.f1384e = c0787v1;
            this.f1385f = obj;
        }

        @Override // kotlinx.coroutines.internal.AbstractC0478d
        /* renamed from: i */
        public Object mo223g(C0504o c0504o) {
            if (this.f1384e.m333P() == this.f1385f) {
                return null;
            }
            return C0503n.m945a();
        }
    }

    public C0787v1(boolean z) {
        this._state = z ? C0793w1.f1396g : C0793w1.f1395f;
        this._parentHandle = null;
    }

    /* renamed from: A */
    private final Object m348A(Object obj) {
        C0520z c0520z;
        Object m299q0;
        C0520z c0520z2;
        do {
            Object m333P = m333P();
            if (!(m333P instanceof InterfaceC0744j1) || ((m333P instanceof C0789b) && ((C0789b) m333P).m283h())) {
                c0520z = C0793w1.f1390a;
                return c0520z;
            }
            m299q0 = m299q0(m333P, new C0797y(m342G(obj), false, 2, null));
            c0520z2 = C0793w1.f1392c;
        } while (m299q0 == c0520z2);
        return m299q0;
    }

    /* renamed from: B */
    private final boolean m347B(Throwable th) {
        if (mo328U()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        InterfaceC0770q m334O = m334O();
        return (m334O == null || m334O == C0704a2.f1312d) ? z : m334O.mo389g(th) || z;
    }

    /* renamed from: E */
    private final void m344E(InterfaceC0744j1 interfaceC0744j1, Object obj) {
        InterfaceC0770q m334O = m334O();
        if (m334O != null) {
            m334O.mo262b();
            m311i0(C0704a2.f1312d);
        }
        C0797y c0797y = obj instanceof C0797y ? (C0797y) obj : null;
        Throwable th = c0797y != null ? c0797y.f1404a : null;
        if (!(interfaceC0744j1 instanceof AbstractC0784u1)) {
            C0802z1 mo246c = interfaceC0744j1.mo246c();
            if (mo246c == null) {
                return;
            }
            m319b0(mo246c, th);
            return;
        }
        try {
            ((AbstractC0784u1) interfaceC0744j1).mo289y(th);
        } catch (Throwable th2) {
            mo331R(new C0706b0("Exception in completion handler " + interfaceC0744j1 + " for " + this, th2));
        }
    }

    /* renamed from: F */
    public final void m343F(C0789b c0789b, C0773r c0773r, Object obj) {
        if (C0768p0.m398a()) {
            if (!(m333P() == c0789b)) {
                throw new AssertionError();
            }
        }
        C0773r m323Z = m323Z(c0773r);
        if (m323Z == null || !m297s0(c0789b, m323Z, obj)) {
            mo292x(m341H(c0789b, obj));
        }
    }

    /* renamed from: G */
    private final Throwable m342G(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new C0769p1(mo346C(), null, this) : th;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((InterfaceC0712c2) obj).mo317d();
    }

    /* renamed from: H */
    private final Object m341H(C0789b c0789b, Object obj) {
        boolean m284g;
        Throwable m338K;
        boolean z = true;
        if (C0768p0.m398a()) {
            if (!(m333P() == c0789b)) {
                throw new AssertionError();
            }
        }
        if (!C0768p0.m398a() || (!c0789b.m282i())) {
            if (!C0768p0.m398a() || c0789b.m283h()) {
                C0797y c0797y = obj instanceof C0797y ? (C0797y) obj : null;
                Throwable th = c0797y == null ? null : c0797y.f1404a;
                synchronized (c0789b) {
                    m284g = c0789b.m284g();
                    List<Throwable> m281j = c0789b.m281j(th);
                    m338K = m338K(c0789b, m281j);
                    if (m338K != null) {
                        m293w(m338K, m281j);
                    }
                }
                if (m338K != null && m338K != th) {
                    obj = new C0797y(m338K, false, 2, null);
                }
                if (m338K != null) {
                    if (!m347B(m338K) && !mo332Q(m338K)) {
                        z = false;
                    }
                    if (z) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        ((C0797y) obj).m259b();
                    }
                }
                if (!m284g) {
                    m318c0(m338K);
                }
                mo316d0(obj);
                boolean m1006a = C0476c.m1006a(f1377d, this, c0789b, C0793w1.m267g(obj));
                if (!C0768p0.m398a() || m1006a) {
                    m344E(c0789b, obj);
                    return obj;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: I */
    private final C0773r m340I(InterfaceC0744j1 interfaceC0744j1) {
        C0773r c0773r = interfaceC0744j1 instanceof C0773r ? (C0773r) interfaceC0744j1 : null;
        if (c0773r == null) {
            C0802z1 mo246c = interfaceC0744j1.mo246c();
            if (mo246c == null) {
                return null;
            }
            return m323Z(mo246c);
        }
        return c0773r;
    }

    /* renamed from: J */
    private final Throwable m339J(Object obj) {
        C0797y c0797y = obj instanceof C0797y ? (C0797y) obj : null;
        if (c0797y == null) {
            return null;
        }
        return c0797y.f1404a;
    }

    /* renamed from: K */
    private final Throwable m338K(C0789b c0789b, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (c0789b.m284g()) {
                return new C0769p1(mo346C(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    /* renamed from: N */
    private final C0802z1 m335N(InterfaceC0744j1 interfaceC0744j1) {
        C0802z1 mo246c = interfaceC0744j1.mo246c();
        if (mo246c == null) {
            if (interfaceC0744j1 instanceof C0798y0) {
                return new C0802z1();
            }
            if (interfaceC0744j1 instanceof AbstractC0784u1) {
                m314g0((AbstractC0784u1) interfaceC0744j1);
                return null;
            }
            throw new IllegalStateException(C0465i.m1043j("State should have list: ", interfaceC0744j1).toString());
        }
        return mo246c;
    }

    /* renamed from: V */
    private final Object m327V(Object obj) {
        C0520z c0520z;
        C0520z c0520z2;
        C0520z c0520z3;
        C0520z c0520z4;
        C0520z c0520z5;
        C0520z c0520z6;
        Throwable th = null;
        while (true) {
            Object m333P = m333P();
            if (m333P instanceof C0789b) {
                synchronized (m333P) {
                    if (((C0789b) m333P).m282i()) {
                        c0520z2 = C0793w1.f1393d;
                        return c0520z2;
                    }
                    boolean m284g = ((C0789b) m333P).m284g();
                    if (obj != null || !m284g) {
                        if (th == null) {
                            th = m342G(obj);
                        }
                        ((C0789b) m333P).m288b(th);
                    }
                    Throwable m285f = m284g ^ true ? ((C0789b) m333P).m285f() : null;
                    if (m285f != null) {
                        m321a0(((C0789b) m333P).mo246c(), m285f);
                    }
                    c0520z = C0793w1.f1390a;
                    return c0520z;
                }
            } else if (!(m333P instanceof InterfaceC0744j1)) {
                c0520z3 = C0793w1.f1393d;
                return c0520z3;
            } else {
                if (th == null) {
                    th = m342G(obj);
                }
                InterfaceC0744j1 interfaceC0744j1 = (InterfaceC0744j1) m333P;
                if (!interfaceC0744j1.mo247a()) {
                    Object m299q0 = m299q0(m333P, new C0797y(th, false, 2, null));
                    c0520z5 = C0793w1.f1390a;
                    if (m299q0 == c0520z5) {
                        throw new IllegalStateException(C0465i.m1043j("Cannot happen in ", m333P).toString());
                    }
                    c0520z6 = C0793w1.f1392c;
                    if (m299q0 != c0520z6) {
                        return m299q0;
                    }
                } else if (m300p0(interfaceC0744j1, th)) {
                    c0520z4 = C0793w1.f1390a;
                    return c0520z4;
                }
            }
        }
    }

    /* renamed from: X */
    private final AbstractC0784u1 m325X(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l, boolean z) {
        if (z) {
            r0 = interfaceC0611l instanceof AbstractC0772q1 ? (AbstractC0772q1) interfaceC0611l : null;
            if (r0 == null) {
                r0 = new C0757m1(interfaceC0611l);
            }
        } else {
            AbstractC0784u1 abstractC0784u1 = interfaceC0611l instanceof AbstractC0784u1 ? (AbstractC0784u1) interfaceC0611l : null;
            if (abstractC0784u1 != null) {
                if (C0768p0.m398a() && !(!(abstractC0784u1 instanceof AbstractC0772q1))) {
                    throw new AssertionError();
                }
                r0 = abstractC0784u1;
            }
            if (r0 == null) {
                r0 = new C0761n1(interfaceC0611l);
            }
        }
        r0.m359A(this);
        return r0;
    }

    /* renamed from: Z */
    private final C0773r m323Z(C0504o c0504o) {
        while (c0504o.mo932t()) {
            c0504o = c0504o.m935q();
        }
        while (true) {
            c0504o = c0504o.m936p();
            if (!c0504o.mo932t()) {
                if (c0504o instanceof C0773r) {
                    return (C0773r) c0504o;
                }
                if (c0504o instanceof C0802z1) {
                    return null;
                }
            }
        }
    }

    /* renamed from: a0 */
    private final void m321a0(C0802z1 c0802z1, Throwable th) {
        C0706b0 c0706b0;
        m318c0(th);
        C0706b0 c0706b02 = null;
        for (C0504o c0504o = (C0504o) c0802z1.m937o(); !C0465i.m1052a(c0504o, c0802z1); c0504o = c0504o.m936p()) {
            if (c0504o instanceof AbstractC0772q1) {
                AbstractC0784u1 abstractC0784u1 = (AbstractC0784u1) c0504o;
                try {
                    abstractC0784u1.mo289y(th);
                } catch (Throwable th2) {
                    if (c0706b02 == null) {
                        c0706b0 = null;
                    } else {
                        C0152b.m2017a(c0706b02, th2);
                        c0706b0 = c0706b02;
                    }
                    if (c0706b0 == null) {
                        c0706b02 = new C0706b0("Exception in completion handler " + abstractC0784u1 + " for " + this, th2);
                    }
                }
            }
        }
        if (c0706b02 != null) {
            mo331R(c0706b02);
        }
        m347B(th);
    }

    /* renamed from: b0 */
    private final void m319b0(C0802z1 c0802z1, Throwable th) {
        C0706b0 c0706b0;
        C0706b0 c0706b02 = null;
        for (C0504o c0504o = (C0504o) c0802z1.m937o(); !C0465i.m1052a(c0504o, c0802z1); c0504o = c0504o.m936p()) {
            if (c0504o instanceof AbstractC0784u1) {
                AbstractC0784u1 abstractC0784u1 = (AbstractC0784u1) c0504o;
                try {
                    abstractC0784u1.mo289y(th);
                } catch (Throwable th2) {
                    if (c0706b02 == null) {
                        c0706b0 = null;
                    } else {
                        C0152b.m2017a(c0706b02, th2);
                        c0706b0 = c0706b02;
                    }
                    if (c0706b0 == null) {
                        c0706b02 = new C0706b0("Exception in completion handler " + abstractC0784u1 + " for " + this, th2);
                    }
                }
            }
        }
        if (c0706b02 == null) {
            return;
        }
        mo331R(c0706b02);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [w0.i1] */
    /* renamed from: f0 */
    private final void m315f0(C0798y0 c0798y0) {
        C0802z1 c0802z1 = new C0802z1();
        if (!c0798y0.mo247a()) {
            c0802z1 = new C0739i1(c0802z1);
        }
        C0476c.m1006a(f1377d, this, c0798y0, c0802z1);
    }

    /* renamed from: g0 */
    private final void m314g0(AbstractC0784u1 abstractC0784u1) {
        abstractC0784u1.m941k(new C0802z1());
        C0476c.m1006a(f1377d, this, abstractC0784u1, abstractC0784u1.m936p());
    }

    /* renamed from: j0 */
    private final int m309j0(Object obj) {
        C0798y0 c0798y0;
        if (!(obj instanceof C0798y0)) {
            if (obj instanceof C0739i1) {
                if (C0476c.m1006a(f1377d, this, obj, ((C0739i1) obj).mo246c())) {
                    mo261e0();
                    return 1;
                }
                return -1;
            }
            return 0;
        } else if (((C0798y0) obj).mo247a()) {
            return 0;
        } else {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1377d;
            c0798y0 = C0793w1.f1396g;
            if (C0476c.m1006a(atomicReferenceFieldUpdater, this, obj, c0798y0)) {
                mo261e0();
                return 1;
            }
            return -1;
        }
    }

    /* renamed from: k0 */
    private final String m308k0(Object obj) {
        if (!(obj instanceof C0789b)) {
            return obj instanceof InterfaceC0744j1 ? ((InterfaceC0744j1) obj).mo247a() ? "Active" : "New" : obj instanceof C0797y ? "Cancelled" : "Completed";
        }
        C0789b c0789b = (C0789b) obj;
        return c0789b.m284g() ? "Cancelling" : c0789b.m283h() ? "Completing" : "Active";
    }

    /* renamed from: m0 */
    public static /* synthetic */ CancellationException m304m0(C0787v1 c0787v1, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return c0787v1.m306l0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    /* renamed from: o0 */
    private final boolean m301o0(InterfaceC0744j1 interfaceC0744j1, Object obj) {
        if (C0768p0.m398a()) {
            if (!((interfaceC0744j1 instanceof C0798y0) || (interfaceC0744j1 instanceof AbstractC0784u1))) {
                throw new AssertionError();
            }
        }
        if (!C0768p0.m398a() || (!(obj instanceof C0797y))) {
            if (C0476c.m1006a(f1377d, this, interfaceC0744j1, C0793w1.m267g(obj))) {
                m318c0(null);
                mo316d0(obj);
                m344E(interfaceC0744j1, obj);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    /* renamed from: p0 */
    private final boolean m300p0(InterfaceC0744j1 interfaceC0744j1, Throwable th) {
        if (!C0768p0.m398a() || (!(interfaceC0744j1 instanceof C0789b))) {
            if (!C0768p0.m398a() || interfaceC0744j1.mo247a()) {
                C0802z1 m335N = m335N(interfaceC0744j1);
                if (m335N == null) {
                    return false;
                }
                if (C0476c.m1006a(f1377d, this, interfaceC0744j1, new C0789b(m335N, false, th))) {
                    m321a0(m335N, th);
                    return true;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: q0 */
    private final Object m299q0(Object obj, Object obj2) {
        C0520z c0520z;
        C0520z c0520z2;
        if (!(obj instanceof InterfaceC0744j1)) {
            c0520z2 = C0793w1.f1390a;
            return c0520z2;
        } else if ((!(obj instanceof C0798y0) && !(obj instanceof AbstractC0784u1)) || (obj instanceof C0773r) || (obj2 instanceof C0797y)) {
            return m298r0((InterfaceC0744j1) obj, obj2);
        } else {
            if (m301o0((InterfaceC0744j1) obj, obj2)) {
                return obj2;
            }
            c0520z = C0793w1.f1392c;
            return c0520z;
        }
    }

    /* renamed from: r0 */
    private final Object m298r0(InterfaceC0744j1 interfaceC0744j1, Object obj) {
        C0520z c0520z;
        C0520z c0520z2;
        C0520z c0520z3;
        C0802z1 m335N = m335N(interfaceC0744j1);
        if (m335N == null) {
            c0520z3 = C0793w1.f1392c;
            return c0520z3;
        }
        C0789b c0789b = interfaceC0744j1 instanceof C0789b ? (C0789b) interfaceC0744j1 : null;
        if (c0789b == null) {
            c0789b = new C0789b(m335N, false, null);
        }
        synchronized (c0789b) {
            if (c0789b.m283h()) {
                c0520z2 = C0793w1.f1390a;
                return c0520z2;
            }
            c0789b.m280k(true);
            if (c0789b != interfaceC0744j1 && !C0476c.m1006a(f1377d, this, interfaceC0744j1, c0789b)) {
                c0520z = C0793w1.f1392c;
                return c0520z;
            }
            if (C0768p0.m398a() && !(!c0789b.m282i())) {
                throw new AssertionError();
            }
            boolean m284g = c0789b.m284g();
            C0797y c0797y = obj instanceof C0797y ? (C0797y) obj : null;
            if (c0797y != null) {
                c0789b.m288b(c0797y.f1404a);
            }
            Throwable m285f = true ^ m284g ? c0789b.m285f() : null;
            C0169q c0169q = C0169q.f235a;
            if (m285f != null) {
                m321a0(m335N, m285f);
            }
            C0773r m340I = m340I(interfaceC0744j1);
            return (m340I == null || !m297s0(c0789b, m340I, obj)) ? m341H(c0789b, obj) : C0793w1.f1391b;
        }
    }

    /* renamed from: s0 */
    private final boolean m297s0(C0789b c0789b, C0773r c0773r, Object obj) {
        while (InterfaceC0764o1.C0765a.m401d(c0773r.f1364h, false, false, new C0788a(this, c0789b, c0773r, obj), 1, null) == C0704a2.f1312d) {
            c0773r = m323Z(c0773r);
            if (c0773r == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: v */
    private final boolean m294v(Object obj, C0802z1 c0802z1, AbstractC0784u1 abstractC0784u1) {
        int m928x;
        C0790c c0790c = new C0790c(abstractC0784u1, this, obj);
        do {
            m928x = c0802z1.m935q().m928x(abstractC0784u1, c0802z1, c0790c);
            if (m928x == 1) {
                return true;
            }
        } while (m928x != 2);
        return false;
    }

    /* renamed from: w */
    private final void m293w(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable m877n = !C0768p0.m395d() ? th : C0519y.m877n(th);
        for (Throwable th2 : list) {
            if (C0768p0.m395d()) {
                th2 = C0519y.m877n(th2);
            }
            if (th2 != th && th2 != m877n && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                C0152b.m2017a(th, th2);
            }
        }
    }

    /* renamed from: C */
    public String mo346C() {
        return "Job was cancelled";
    }

    /* renamed from: D */
    public boolean m345D(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m291y(th) && mo337L();
    }

    /* renamed from: L */
    public boolean mo337L() {
        return true;
    }

    /* renamed from: M */
    public boolean mo336M() {
        return false;
    }

    /* renamed from: O */
    public final InterfaceC0770q m334O() {
        return (InterfaceC0770q) this._parentHandle;
    }

    /* renamed from: P */
    public final Object m333P() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof AbstractC0516v)) {
                return obj;
            }
            ((AbstractC0516v) obj).mo892c(this);
        }
    }

    /* renamed from: Q */
    protected boolean mo332Q(Throwable th) {
        return false;
    }

    /* renamed from: R */
    public void mo331R(Throwable th) {
        throw th;
    }

    /* renamed from: S */
    public final void m330S(InterfaceC0764o1 interfaceC0764o1) {
        if (C0768p0.m398a()) {
            if (!(m334O() == null)) {
                throw new AssertionError();
            }
        }
        if (interfaceC0764o1 == null) {
            m311i0(C0704a2.f1312d);
            return;
        }
        interfaceC0764o1.mo305m();
        InterfaceC0770q mo313h = interfaceC0764o1.mo313h(this);
        m311i0(mo313h);
        if (m329T()) {
            mo313h.mo262b();
            m311i0(C0704a2.f1312d);
        }
    }

    /* renamed from: T */
    public final boolean m329T() {
        return !(m333P() instanceof InterfaceC0744j1);
    }

    /* renamed from: U */
    protected boolean mo328U() {
        return false;
    }

    /* renamed from: W */
    public final Object m326W(Object obj) {
        Object m299q0;
        C0520z c0520z;
        C0520z c0520z2;
        do {
            m299q0 = m299q0(m333P(), obj);
            c0520z = C0793w1.f1390a;
            if (m299q0 == c0520z) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, m339J(obj));
            }
            c0520z2 = C0793w1.f1392c;
        } while (m299q0 == c0520z2);
        return m299q0;
    }

    /* renamed from: Y */
    public String mo324Y() {
        return C0771q0.m392a(this);
    }

    @Override // p048w0.InterfaceC0764o1
    /* renamed from: a */
    public boolean mo322a() {
        Object m333P = m333P();
        return (m333P instanceof InterfaceC0744j1) && ((InterfaceC0744j1) m333P).mo247a();
    }

    @Override // p048w0.InterfaceC0764o1
    /* renamed from: b */
    public void mo320b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new C0769p1(mo346C(), null, this);
        }
        m290z(cancellationException);
    }

    /* renamed from: c0 */
    protected void m318c0(Throwable th) {
    }

    @Override // p048w0.InterfaceC0712c2
    /* renamed from: d */
    public CancellationException mo317d() {
        Throwable th;
        Object m333P = m333P();
        if (m333P instanceof C0789b) {
            th = ((C0789b) m333P).m285f();
        } else if (m333P instanceof C0797y) {
            th = ((C0797y) m333P).f1404a;
        } else if (m333P instanceof InterfaceC0744j1) {
            throw new IllegalStateException(C0465i.m1043j("Cannot be cancelling child in this state: ", m333P).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        return cancellationException == null ? new C0769p1(C0465i.m1043j("Parent job is ", m308k0(m333P)), th, this) : cancellationException;
    }

    /* renamed from: d0 */
    protected void mo316d0(Object obj) {
    }

    /* renamed from: e0 */
    protected void mo261e0() {
    }

    @Override // p020i0.InterfaceC0249g
    public <R> R fold(R r, InterfaceC0615p<? super R, ? super InterfaceC0249g.InterfaceC0252b, ? extends R> interfaceC0615p) {
        return (R) InterfaceC0764o1.C0765a.m403b(this, r, interfaceC0615p);
    }

    @Override // p020i0.InterfaceC0249g.InterfaceC0252b, p020i0.InterfaceC0249g
    public <E extends InterfaceC0249g.InterfaceC0252b> E get(InterfaceC0249g.InterfaceC0254c<E> interfaceC0254c) {
        return (E) InterfaceC0764o1.C0765a.m402c(this, interfaceC0254c);
    }

    @Override // p020i0.InterfaceC0249g.InterfaceC0252b
    public final InterfaceC0249g.InterfaceC0254c<?> getKey() {
        return InterfaceC0764o1.f1356c;
    }

    @Override // p048w0.InterfaceC0764o1
    /* renamed from: h */
    public final InterfaceC0770q mo313h(InterfaceC0776s interfaceC0776s) {
        return (InterfaceC0770q) InterfaceC0764o1.C0765a.m401d(this, true, false, new C0773r(interfaceC0776s), 2, null);
    }

    /* renamed from: h0 */
    public final void m312h0(AbstractC0784u1 abstractC0784u1) {
        Object m333P;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        C0798y0 c0798y0;
        do {
            m333P = m333P();
            if (!(m333P instanceof AbstractC0784u1)) {
                if (!(m333P instanceof InterfaceC0744j1) || ((InterfaceC0744j1) m333P).mo246c() == null) {
                    return;
                }
                abstractC0784u1.m931u();
                return;
            } else if (m333P != abstractC0784u1) {
                return;
            } else {
                atomicReferenceFieldUpdater = f1377d;
                c0798y0 = C0793w1.f1396g;
            }
        } while (!C0476c.m1006a(atomicReferenceFieldUpdater, this, m333P, c0798y0));
    }

    /* renamed from: i0 */
    public final void m311i0(InterfaceC0770q interfaceC0770q) {
        this._parentHandle = interfaceC0770q;
    }

    @Override // p048w0.InterfaceC0776s
    /* renamed from: j */
    public final void mo310j(InterfaceC0712c2 interfaceC0712c2) {
        m291y(interfaceC0712c2);
    }

    @Override // p048w0.InterfaceC0764o1
    /* renamed from: l */
    public final CancellationException mo307l() {
        Object m333P = m333P();
        if (!(m333P instanceof C0789b)) {
            if (m333P instanceof InterfaceC0744j1) {
                throw new IllegalStateException(C0465i.m1043j("Job is still new or active: ", this).toString());
            }
            return m333P instanceof C0797y ? m304m0(this, ((C0797y) m333P).f1404a, null, 1, null) : new C0769p1(C0465i.m1043j(C0771q0.m392a(this), " has completed normally"), null, this);
        }
        Throwable m285f = ((C0789b) m333P).m285f();
        if (m285f != null) {
            return m306l0(m285f, C0465i.m1043j(C0771q0.m392a(this), " is cancelling"));
        }
        throw new IllegalStateException(C0465i.m1043j("Job is still new or active: ", this).toString());
    }

    /* renamed from: l0 */
    protected final CancellationException m306l0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = mo346C();
            }
            cancellationException = new C0769p1(str, th, this);
        }
        return cancellationException;
    }

    @Override // p048w0.InterfaceC0764o1
    /* renamed from: m */
    public final boolean mo305m() {
        int m309j0;
        do {
            m309j0 = m309j0(m333P());
            if (m309j0 == 0) {
                return false;
            }
        } while (m309j0 != 1);
        return true;
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g minusKey(InterfaceC0249g.InterfaceC0254c<?> interfaceC0254c) {
        return InterfaceC0764o1.C0765a.m400e(this, interfaceC0254c);
    }

    @Override // p048w0.InterfaceC0764o1
    /* renamed from: n */
    public final InterfaceC0795x0 mo303n(boolean z, boolean z2, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        AbstractC0784u1 m325X = m325X(interfaceC0611l, z);
        while (true) {
            Object m333P = m333P();
            if (m333P instanceof C0798y0) {
                C0798y0 c0798y0 = (C0798y0) m333P;
                if (!c0798y0.mo247a()) {
                    m315f0(c0798y0);
                } else if (C0476c.m1006a(f1377d, this, m333P, m325X)) {
                    return m325X;
                }
            } else {
                if (!(m333P instanceof InterfaceC0744j1)) {
                    if (z2) {
                        C0797y c0797y = m333P instanceof C0797y ? (C0797y) m333P : null;
                        interfaceC0611l.invoke(c0797y != null ? c0797y.f1404a : null);
                    }
                    return C0704a2.f1312d;
                }
                C0802z1 mo246c = ((InterfaceC0744j1) m333P).mo246c();
                if (mo246c == null) {
                    Objects.requireNonNull(m333P, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    m314g0((AbstractC0784u1) m333P);
                } else {
                    InterfaceC0795x0 interfaceC0795x0 = C0704a2.f1312d;
                    if (z && (m333P instanceof C0789b)) {
                        synchronized (m333P) {
                            r3 = ((C0789b) m333P).m285f();
                            if (r3 == null || ((interfaceC0611l instanceof C0773r) && !((C0789b) m333P).m283h())) {
                                if (m294v(m333P, mo246c, m325X)) {
                                    if (r3 == null) {
                                        return m325X;
                                    }
                                    interfaceC0795x0 = m325X;
                                }
                            }
                            C0169q c0169q = C0169q.f235a;
                        }
                    }
                    if (r3 != null) {
                        if (z2) {
                            interfaceC0611l.invoke(r3);
                        }
                        return interfaceC0795x0;
                    } else if (m294v(m333P, mo246c, m325X)) {
                        return m325X;
                    }
                }
            }
        }
    }

    /* renamed from: n0 */
    public final String m302n0() {
        return mo324Y() + '{' + m308k0(m333P()) + '}';
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g plus(InterfaceC0249g interfaceC0249g) {
        return InterfaceC0764o1.C0765a.m399f(this, interfaceC0249g);
    }

    public String toString() {
        return m302n0() + '@' + C0771q0.m391b(this);
    }

    /* renamed from: x */
    public void mo292x(Object obj) {
    }

    /* renamed from: y */
    public final boolean m291y(Object obj) {
        Object obj2;
        C0520z c0520z;
        C0520z c0520z2;
        C0520z c0520z3;
        obj2 = C0793w1.f1390a;
        if (mo336M() && (obj2 = m348A(obj)) == C0793w1.f1391b) {
            return true;
        }
        c0520z = C0793w1.f1390a;
        if (obj2 == c0520z) {
            obj2 = m327V(obj);
        }
        c0520z2 = C0793w1.f1390a;
        if (obj2 == c0520z2 || obj2 == C0793w1.f1391b) {
            return true;
        }
        c0520z3 = C0793w1.f1393d;
        if (obj2 == c0520z3) {
            return false;
        }
        mo292x(obj2);
        return true;
    }

    /* renamed from: z */
    public void m290z(Throwable th) {
        m291y(th);
    }
}