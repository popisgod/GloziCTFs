package p052y0;

import kotlin.coroutines.jvm.internal.C0444b;
import kotlin.coroutines.jvm.internal.C0450h;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0503n;
import kotlinx.coroutines.internal.C0504o;
import kotlinx.coroutines.internal.C0514u;
import kotlinx.coroutines.internal.C0519y;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p022j0.C0434c;
import p022j0.C0437d;
import p034p0.InterfaceC0611l;
import p048w0.AbstractC0717e;
import p048w0.C0752l;
import p048w0.C0755m;
import p048w0.C0758n;
import p048w0.C0768p0;
import p048w0.C0771q0;
import p048w0.InterfaceC0747k;

/* renamed from: y0.a */
/* loaded from: classes.dex */
public abstract class AbstractC0809a<E> extends AbstractC0815c<E> implements InterfaceC0820f<E> {

    /* renamed from: y0.a$a */
    /* loaded from: classes.dex */
    public static final class C0810a<E> implements InterfaceC0822g<E> {

        /* renamed from: a */
        public final AbstractC0809a<E> f1416a;

        /* renamed from: b */
        private Object f1417b = C0814b.f1427d;

        public C0810a(AbstractC0809a<E> abstractC0809a) {
            this.f1416a = abstractC0809a;
        }

        /* renamed from: c */
        private final boolean m228c(Object obj) {
            if (obj instanceof C0828j) {
                C0828j c0828j = (C0828j) obj;
                if (c0828j.f1450g == null) {
                    return false;
                }
                throw C0519y.m880k(c0828j.m196E());
            }
            return true;
        }

        /* renamed from: d */
        private final Object m227d(InterfaceC0244d<? super Boolean> interfaceC0244d) {
            InterfaceC0244d m1078b;
            Object m1077c;
            Object m2006a;
            m1078b = C0434c.m1078b(interfaceC0244d);
            C0752l m409a = C0758n.m409a(m1078b);
            C0811b c0811b = new C0811b(this, m409a);
            while (true) {
                if (this.f1416a.m233p(c0811b)) {
                    this.f1416a.m230w(m409a, c0811b);
                    break;
                }
                Object mo192v = this.f1416a.mo192v();
                m226e(mo192v);
                if (mo192v instanceof C0828j) {
                    C0828j c0828j = (C0828j) mo192v;
                    if (c0828j.f1450g == null) {
                        m2006a = C0444b.m1072a(false);
                        C0161k.C0162a c0162a = C0161k.f229d;
                    } else {
                        Throwable m196E = c0828j.m196E();
                        C0161k.C0162a c0162a2 = C0161k.f229d;
                        m2006a = C0164l.m2006a(m196E);
                    }
                    m409a.resumeWith(C0161k.m2010a(m2006a));
                } else if (mo192v != C0814b.f1427d) {
                    Boolean m1072a = C0444b.m1072a(true);
                    InterfaceC0611l<E, C0169q> interfaceC0611l = this.f1416a.f1431b;
                    m409a.mo420r(m1072a, interfaceC0611l == null ? null : C0514u.m899a(interfaceC0611l, mo192v, m409a.getContext()));
                }
            }
            Object m415w = m409a.m415w();
            m1077c = C0437d.m1077c();
            if (m415w == m1077c) {
                C0450h.m1060c(interfaceC0244d);
            }
            return m415w;
        }

        @Override // p052y0.InterfaceC0822g
        /* renamed from: a */
        public Object mo206a(InterfaceC0244d<? super Boolean> interfaceC0244d) {
            Object m229b = m229b();
            C0520z c0520z = C0814b.f1427d;
            if (m229b == c0520z) {
                m226e(this.f1416a.mo192v());
                if (m229b() == c0520z) {
                    return m227d(interfaceC0244d);
                }
            }
            return C0444b.m1072a(m228c(m229b()));
        }

        /* renamed from: b */
        public final Object m229b() {
            return this.f1417b;
        }

        /* renamed from: e */
        public final void m226e(Object obj) {
            this.f1417b = obj;
        }

        @Override // p052y0.InterfaceC0822g
        public E next() {
            E e = (E) this.f1417b;
            if (e instanceof C0828j) {
                throw C0519y.m880k(((C0828j) e).m196E());
            }
            C0520z c0520z = C0814b.f1427d;
            if (e != c0520z) {
                this.f1417b = c0520z;
                return e;
            }
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        }
    }

    /* renamed from: y0.a$b */
    /* loaded from: classes.dex */
    public static class C0811b<E> extends AbstractC0833o<E> {

        /* renamed from: g */
        public final C0810a<E> f1418g;

        /* renamed from: h */
        public final InterfaceC0747k<Boolean> f1419h;

        /* JADX WARN: Multi-variable type inference failed */
        public C0811b(C0810a<E> c0810a, InterfaceC0747k<? super Boolean> interfaceC0747k) {
            this.f1418g = c0810a;
            this.f1419h = interfaceC0747k;
        }

        /* renamed from: A */
        public InterfaceC0611l<Throwable, C0169q> m225A(E e) {
            InterfaceC0611l<E, C0169q> interfaceC0611l = this.f1418g.f1416a.f1431b;
            if (interfaceC0611l == null) {
                return null;
            }
            return C0514u.m899a(interfaceC0611l, e, this.f1419h.getContext());
        }

        @Override // p052y0.InterfaceC0835q
        /* renamed from: d */
        public void mo187d(E e) {
            this.f1418g.m226e(e);
            this.f1419h.mo421q(C0755m.f1345a);
        }

        @Override // p052y0.InterfaceC0835q
        /* renamed from: h */
        public C0520z mo185h(E e, C0504o.C0506b c0506b) {
            Object mo423o = this.f1419h.mo423o(Boolean.TRUE, null, m225A(e));
            if (mo423o == null) {
                return null;
            }
            if (C0768p0.m398a()) {
                if (!(mo423o == C0755m.f1345a)) {
                    throw new AssertionError();
                }
            }
            return C0755m.f1345a;
        }

        @Override // kotlinx.coroutines.internal.C0504o
        public String toString() {
            return C0465i.m1043j("ReceiveHasNext@", C0771q0.m391b(this));
        }

        @Override // p052y0.AbstractC0833o
        /* renamed from: z */
        public void mo188z(C0828j<?> c0828j) {
            Object m446a = c0828j.f1450g == null ? InterfaceC0747k.C0748a.m446a(this.f1419h, Boolean.FALSE, null, 2, null) : this.f1419h.mo422p(c0828j.m196E());
            if (m446a != null) {
                this.f1418g.m226e(c0828j);
                this.f1419h.mo421q(m446a);
            }
        }
    }

    /* renamed from: y0.a$c */
    /* loaded from: classes.dex */
    public final class C0812c extends AbstractC0717e {

        /* renamed from: d */
        private final AbstractC0833o<?> f1420d;

        public C0812c(AbstractC0833o<?> abstractC0833o) {
            AbstractC0809a.this = r1;
            this.f1420d = abstractC0833o;
        }

        @Override // p048w0.AbstractC0741j
        /* renamed from: a */
        public void mo224a(Throwable th) {
            if (this.f1420d.m931u()) {
                AbstractC0809a.this.m232t();
            }
        }

        @Override // p034p0.InterfaceC0611l
        public /* bridge */ /* synthetic */ C0169q invoke(Throwable th) {
            mo224a(th);
            return C0169q.f235a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f1420d + ']';
        }
    }

    /* renamed from: y0.a$d */
    /* loaded from: classes.dex */
    public static final class C0813d extends C0504o.AbstractC0505a {

        /* renamed from: d */
        final /* synthetic */ C0504o f1422d;

        /* renamed from: e */
        final /* synthetic */ AbstractC0809a f1423e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0813d(C0504o c0504o, AbstractC0809a abstractC0809a) {
            super(c0504o);
            this.f1422d = c0504o;
            this.f1423e = abstractC0809a;
        }

        @Override // kotlinx.coroutines.internal.AbstractC0478d
        /* renamed from: i */
        public Object mo223g(C0504o c0504o) {
            if (this.f1423e.mo183s()) {
                return null;
            }
            return C0503n.m945a();
        }
    }

    public AbstractC0809a(InterfaceC0611l<? super E, C0169q> interfaceC0611l) {
        super(interfaceC0611l);
    }

    /* renamed from: p */
    public final boolean m233p(AbstractC0833o<? super E> abstractC0833o) {
        boolean mo193q = mo193q(abstractC0833o);
        if (mo193q) {
            m231u();
        }
        return mo193q;
    }

    /* renamed from: w */
    public final void m230w(InterfaceC0747k<?> interfaceC0747k, AbstractC0833o<?> abstractC0833o) {
        interfaceC0747k.mo427k(new C0812c(abstractC0833o));
    }

    @Override // p052y0.InterfaceC0834p
    public final InterfaceC0822g<E> iterator() {
        return new C0810a(this);
    }

    @Override // p052y0.AbstractC0815c
    /* renamed from: l */
    public InterfaceC0835q<E> mo213l() {
        InterfaceC0835q<E> mo213l = super.mo213l();
        if (mo213l != null && !(mo213l instanceof C0828j)) {
            m232t();
        }
        return mo213l;
    }

    /* renamed from: q */
    public boolean mo193q(AbstractC0833o<? super E> abstractC0833o) {
        int m928x;
        C0504o m935q;
        if (!mo184r()) {
            C0504o m219e = m219e();
            C0813d c0813d = new C0813d(abstractC0833o, this);
            do {
                C0504o m935q2 = m219e.m935q();
                if (!(!(m935q2 instanceof AbstractC0837s))) {
                    return false;
                }
                m928x = m935q2.m928x(abstractC0833o, m219e, c0813d);
                if (m928x != 1) {
                }
            } while (m928x != 2);
            return false;
        }
        C0504o m219e2 = m219e();
        do {
            m935q = m219e2.m935q();
            if (!(!(m935q instanceof AbstractC0837s))) {
                return false;
            }
        } while (!m935q.m942j(abstractC0833o, m219e2));
        return true;
    }

    /* renamed from: r */
    protected abstract boolean mo184r();

    /* renamed from: s */
    protected abstract boolean mo183s();

    /* renamed from: t */
    protected void m232t() {
    }

    /* renamed from: u */
    protected void m231u() {
    }

    /* renamed from: v */
    protected Object mo192v() {
        while (true) {
            AbstractC0837s m212m = m212m();
            if (m212m == null) {
                return C0814b.f1427d;
            }
            C0520z mo182A = m212m.mo182A(null);
            if (mo182A != null) {
                if (C0768p0.m398a()) {
                    if (!(mo182A == C0755m.f1345a)) {
                        throw new AssertionError();
                    }
                }
                m212m.mo180y();
                return m212m.mo179z();
            }
            m212m.m181B();
        }
    }
}