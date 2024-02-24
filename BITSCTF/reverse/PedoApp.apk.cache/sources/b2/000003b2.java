package p052y0;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0501l;
import kotlinx.coroutines.internal.C0502m;
import kotlinx.coroutines.internal.C0504o;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0169q;
import p034p0.InterfaceC0611l;
import p048w0.C0755m;
import p048w0.C0768p0;
import p048w0.C0771q0;
import p052y0.C0824i;

/* renamed from: y0.c */
/* loaded from: classes.dex */
public abstract class AbstractC0815c<E> implements InterfaceC0838t<E> {

    /* renamed from: d */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1430d = AtomicReferenceFieldUpdater.newUpdater(AbstractC0815c.class, Object.class, "onCloseHandler");

    /* renamed from: b */
    protected final InterfaceC0611l<E, C0169q> f1431b;

    /* renamed from: c */
    private final C0502m f1432c = new C0502m();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* renamed from: y0.c$a */
    /* loaded from: classes.dex */
    public static final class C0816a<E> extends AbstractC0837s {

        /* renamed from: g */
        public final E f1433g;

        public C0816a(E e) {
            this.f1433g = e;
        }

        @Override // p052y0.AbstractC0837s
        /* renamed from: A */
        public C0520z mo182A(C0504o.C0506b c0506b) {
            return C0755m.f1345a;
        }

        @Override // kotlinx.coroutines.internal.C0504o
        public String toString() {
            return "SendBuffered@" + C0771q0.m391b(this) + '(' + this.f1433g + ')';
        }

        @Override // p052y0.AbstractC0837s
        /* renamed from: y */
        public void mo180y() {
        }

        @Override // p052y0.AbstractC0837s
        /* renamed from: z */
        public Object mo179z() {
            return this.f1433g;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC0815c(InterfaceC0611l<? super E, C0169q> interfaceC0611l) {
        this.f1431b = interfaceC0611l;
    }

    /* renamed from: b */
    private final int m221b() {
        C0502m c0502m = this.f1432c;
        int i = 0;
        for (C0504o c0504o = (C0504o) c0502m.m937o(); !C0465i.m1052a(c0504o, c0502m); c0504o = c0504o.m936p()) {
            if (c0504o instanceof C0504o) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: f */
    private final String m218f() {
        C0504o m936p = this.f1432c.m936p();
        if (m936p == this.f1432c) {
            return "EmptyQueue";
        }
        String c0504o = m936p instanceof C0828j ? m936p.toString() : m936p instanceof AbstractC0833o ? "ReceiveQueued" : m936p instanceof AbstractC0837s ? "SendQueued" : C0465i.m1043j("UNEXPECTED:", m936p);
        C0504o m935q = this.f1432c.m935q();
        if (m935q != m936p) {
            String str = c0504o + ",queueSize=" + m221b();
            if (m935q instanceof C0828j) {
                return str + ",closedForSend=" + m935q;
            }
            return str;
        }
        return c0504o;
    }

    /* renamed from: g */
    private final void m217g(C0828j<?> c0828j) {
        Object m947b = C0501l.m947b(null, 1, null);
        while (true) {
            C0504o m935q = c0828j.m935q();
            AbstractC0833o abstractC0833o = m935q instanceof AbstractC0833o ? (AbstractC0833o) m935q : null;
            if (abstractC0833o == null) {
                break;
            } else if (abstractC0833o.m931u()) {
                m947b = C0501l.m946c(m947b, abstractC0833o);
            } else {
                abstractC0833o.m934r();
            }
        }
        if (m947b != null) {
            if (m947b instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) m947b;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        ((AbstractC0833o) arrayList.get(size)).mo188z(c0828j);
                        if (i < 0) {
                            break;
                        }
                        size = i;
                    }
                }
            } else {
                ((AbstractC0833o) m947b).mo188z(c0828j);
            }
        }
        m215j(c0828j);
    }

    /* renamed from: h */
    private final Throwable m216h(C0828j<?> c0828j) {
        m217g(c0828j);
        return c0828j.m195F();
    }

    @Override // p052y0.InterfaceC0838t
    /* renamed from: a */
    public final Object mo178a(E e) {
        C0824i.C0826b c0826b;
        C0828j<?> c0828j;
        Object mo190i = mo190i(e);
        if (mo190i == C0814b.f1425b) {
            return C0824i.f1447a.m199c(C0169q.f235a);
        }
        if (mo190i == C0814b.f1426c) {
            c0828j = m220d();
            if (c0828j == null) {
                return C0824i.f1447a.m200b();
            }
            c0826b = C0824i.f1447a;
        } else if (!(mo190i instanceof C0828j)) {
            throw new IllegalStateException(C0465i.m1043j("trySend returned ", mo190i).toString());
        } else {
            c0826b = C0824i.f1447a;
            c0828j = (C0828j) mo190i;
        }
        return c0826b.m201a(m216h(c0828j));
    }

    /* renamed from: c */
    protected String mo194c() {
        return "";
    }

    /* renamed from: d */
    public final C0828j<?> m220d() {
        C0504o m935q = this.f1432c.m935q();
        C0828j<?> c0828j = m935q instanceof C0828j ? (C0828j) m935q : null;
        if (c0828j == null) {
            return null;
        }
        m217g(c0828j);
        return c0828j;
    }

    /* renamed from: e */
    public final C0502m m219e() {
        return this.f1432c;
    }

    /* renamed from: i */
    public Object mo190i(E e) {
        InterfaceC0835q<E> mo213l;
        C0520z mo185h;
        do {
            mo213l = mo213l();
            if (mo213l == null) {
                return C0814b.f1426c;
            }
            mo185h = mo213l.mo185h(e, null);
        } while (mo185h == null);
        if (C0768p0.m398a()) {
            if (!(mo185h == C0755m.f1345a)) {
                throw new AssertionError();
            }
        }
        mo213l.mo187d(e);
        return mo213l.mo186e();
    }

    /* renamed from: j */
    protected void m215j(C0504o c0504o) {
    }

    /* renamed from: k */
    public final InterfaceC0835q<?> m214k(E e) {
        C0504o m935q;
        C0504o c0504o = this.f1432c;
        C0816a c0816a = new C0816a(e);
        do {
            m935q = c0504o.m935q();
            if (m935q instanceof InterfaceC0835q) {
                return (InterfaceC0835q) m935q;
            }
        } while (!m935q.m942j(c0816a, c0504o));
        return null;
    }

    /* renamed from: l */
    public InterfaceC0835q<E> mo213l() {
        C0504o c0504o;
        C0504o m930v;
        C0502m c0502m = this.f1432c;
        while (true) {
            c0504o = (C0504o) c0502m.m937o();
            if (c0504o != c0502m && (c0504o instanceof InterfaceC0835q)) {
                if (((((InterfaceC0835q) c0504o) instanceof C0828j) && !c0504o.mo932t()) || (m930v = c0504o.m930v()) == null) {
                    break;
                }
                m930v.m933s();
            }
        }
        c0504o = null;
        return (InterfaceC0835q) c0504o;
    }

    /* renamed from: m */
    public final AbstractC0837s m212m() {
        C0504o c0504o;
        C0504o m930v;
        C0502m c0502m = this.f1432c;
        while (true) {
            c0504o = (C0504o) c0502m.m937o();
            if (c0504o != c0502m && (c0504o instanceof AbstractC0837s)) {
                if (((((AbstractC0837s) c0504o) instanceof C0828j) && !c0504o.mo932t()) || (m930v = c0504o.m930v()) == null) {
                    break;
                }
                m930v.m933s();
            }
        }
        c0504o = null;
        return (AbstractC0837s) c0504o;
    }

    public String toString() {
        return C0771q0.m392a(this) + '@' + C0771q0.m391b(this) + '{' + m218f() + '}' + mo194c();
    }
}