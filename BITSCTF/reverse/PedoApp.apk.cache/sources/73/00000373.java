package p048w0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0476c;
import kotlinx.coroutines.internal.C0487g;
import kotlinx.coroutines.internal.C0519y;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0154d;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p022j0.C0437d;
import p034p0.InterfaceC0611l;
import p048w0.InterfaceC0764o1;

/* renamed from: w0.l */
/* loaded from: classes.dex */
public class C0752l<T> extends AbstractC0780t0<T> implements InterfaceC0747k<T>, InterfaceC0447e {

    /* renamed from: j */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1339j = AtomicIntegerFieldUpdater.newUpdater(C0752l.class, "_decision");

    /* renamed from: k */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1340k = AtomicReferenceFieldUpdater.newUpdater(C0752l.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: g */
    private final InterfaceC0244d<T> f1341g;

    /* renamed from: h */
    private final InterfaceC0249g f1342h;

    /* renamed from: i */
    private InterfaceC0795x0 f1343i;

    /* JADX WARN: Multi-variable type inference failed */
    public C0752l(InterfaceC0244d<? super T> interfaceC0244d, int i) {
        super(i);
        this.f1341g = interfaceC0244d;
        if (C0768p0.m398a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.f1342h = interfaceC0244d.getContext();
        this._decision = 0;
        this._state = C0713d.f1314d;
    }

    /* renamed from: A */
    private final boolean m444A() {
        return C0783u0.m362c(this.f1370f) && ((C0487g) this.f1341g).m975l();
    }

    /* renamed from: B */
    private final AbstractC0737i m443B(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        return interfaceC0611l instanceof AbstractC0737i ? (AbstractC0737i) interfaceC0611l : new C0754l1(interfaceC0611l);
    }

    /* renamed from: C */
    private final void m442C(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + interfaceC0611l + ", already has " + obj).toString());
    }

    /* renamed from: F */
    private final void m439F() {
        InterfaceC0244d<T> interfaceC0244d = this.f1341g;
        C0487g c0487g = interfaceC0244d instanceof C0487g ? (C0487g) interfaceC0244d : null;
        Throwable m972s = c0487g != null ? c0487g.m972s(this) : null;
        if (m972s == null) {
            return;
        }
        m419s();
        m425m(m972s);
    }

    /* renamed from: H */
    private final void m437H(Object obj, int i, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof InterfaceC0708b2)) {
                if (obj2 instanceof C0762o) {
                    C0762o c0762o = (C0762o) obj2;
                    if (c0762o.m405c()) {
                        if (interfaceC0611l == null) {
                            return;
                        }
                        m426l(interfaceC0611l, c0762o.f1404a);
                        return;
                    }
                }
                m430h(obj);
                throw new C0154d();
            }
        } while (!C0476c.m1006a(f1340k, this, obj2, m435J((InterfaceC0708b2) obj2, obj, i, interfaceC0611l, null)));
        m418t();
        m417u(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: I */
    static /* synthetic */ void m436I(C0752l c0752l, Object obj, int i, InterfaceC0611l interfaceC0611l, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            interfaceC0611l = null;
        }
        c0752l.m437H(obj, i, interfaceC0611l);
    }

    /* renamed from: J */
    private final Object m435J(InterfaceC0708b2 interfaceC0708b2, Object obj, int i, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l, Object obj2) {
        if (obj instanceof C0797y) {
            if (C0768p0.m398a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (C0768p0.m398a()) {
                if (interfaceC0611l == null) {
                    return obj;
                }
                throw new AssertionError();
            }
            return obj;
        } else if (C0783u0.m363b(i) || obj2 != null) {
            if (interfaceC0611l != null || (((interfaceC0708b2 instanceof AbstractC0737i) && !(interfaceC0708b2 instanceof AbstractC0717e)) || obj2 != null)) {
                return new C0794x(obj, interfaceC0708b2 instanceof AbstractC0737i ? (AbstractC0737i) interfaceC0708b2 : null, interfaceC0611l, obj2, null, 16, null);
            }
            return obj;
        } else {
            return obj;
        }
    }

    /* renamed from: K */
    private final boolean m434K() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f1339j.compareAndSet(this, 0, 2));
        return true;
    }

    /* renamed from: L */
    private final C0520z m433L(Object obj, Object obj2, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof InterfaceC0708b2)) {
                if (!(obj3 instanceof C0794x) || obj2 == null) {
                    return null;
                }
                C0794x c0794x = (C0794x) obj3;
                if (c0794x.f1400d == obj2) {
                    if (!C0768p0.m398a() || C0465i.m1052a(c0794x.f1397a, obj)) {
                        return C0755m.f1345a;
                    }
                    throw new AssertionError();
                }
                return null;
            }
        } while (!C0476c.m1006a(f1340k, this, obj3, m435J((InterfaceC0708b2) obj3, obj, this.f1370f, interfaceC0611l, obj2)));
        m418t();
        return C0755m.f1345a;
    }

    /* renamed from: M */
    private final boolean m432M() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f1339j.compareAndSet(this, 0, 1));
        return true;
    }

    /* renamed from: h */
    private final Void m430h(Object obj) {
        throw new IllegalStateException(C0465i.m1043j("Already resumed, but proposed with update ", obj).toString());
    }

    /* renamed from: i */
    private final void m429i(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l, Throwable th) {
        try {
            interfaceC0611l.invoke(th);
        } catch (Throwable th2) {
            C0734h0.m457a(getContext(), new C0706b0(C0465i.m1043j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    /* renamed from: n */
    private final boolean m424n(Throwable th) {
        if (m444A()) {
            return ((C0487g) this.f1341g).m974m(th);
        }
        return false;
    }

    /* renamed from: t */
    private final void m418t() {
        if (m444A()) {
            return;
        }
        m419s();
    }

    /* renamed from: u */
    private final void m417u(int i) {
        if (m434K()) {
            return;
        }
        C0783u0.m364a(this, i);
    }

    /* renamed from: y */
    private final String m413y() {
        Object m414x = m414x();
        return m414x instanceof InterfaceC0708b2 ? "Active" : m414x instanceof C0762o ? "Cancelled" : "Completed";
    }

    /* renamed from: z */
    private final InterfaceC0795x0 m412z() {
        InterfaceC0764o1 interfaceC0764o1 = (InterfaceC0764o1) getContext().get(InterfaceC0764o1.f1356c);
        if (interfaceC0764o1 == null) {
            return null;
        }
        InterfaceC0795x0 m401d = InterfaceC0764o1.C0765a.m401d(interfaceC0764o1, true, false, new C0767p(this), 2, null);
        this.f1343i = m401d;
        return m401d;
    }

    /* renamed from: D */
    protected String m441D() {
        return "CancellableContinuation";
    }

    /* renamed from: E */
    public final void m440E(Throwable th) {
        if (m424n(th)) {
            return;
        }
        m425m(th);
        m418t();
    }

    /* renamed from: G */
    public final boolean m438G() {
        if (C0768p0.m398a()) {
            if (!(this.f1370f == 2)) {
                throw new AssertionError();
            }
        }
        if (C0768p0.m398a()) {
            if (!(this.f1343i != C0704a2.f1312d)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (!C0768p0.m398a() || (!(obj instanceof InterfaceC0708b2))) {
            if ((obj instanceof C0794x) && ((C0794x) obj).f1400d != null) {
                m419s();
                return false;
            }
            this._decision = 0;
            this._state = C0713d.f1314d;
            return true;
        }
        throw new AssertionError();
    }

    @Override // p048w0.AbstractC0780t0
    /* renamed from: a */
    public void mo375a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof InterfaceC0708b2) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof C0797y) {
                return;
            }
            if (obj2 instanceof C0794x) {
                C0794x c0794x = (C0794x) obj2;
                if (!(!c0794x.m264c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (C0476c.m1006a(f1340k, this, obj2, C0794x.m265b(c0794x, null, null, null, null, th, 15, null))) {
                    c0794x.m263d(this, th);
                    return;
                }
            } else if (C0476c.m1006a(f1340k, this, obj2, new C0794x(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // p048w0.AbstractC0780t0
    /* renamed from: b */
    public final InterfaceC0244d<T> mo374b() {
        return this.f1341g;
    }

    @Override // p048w0.AbstractC0780t0
    /* renamed from: c */
    public Throwable mo373c(Object obj) {
        Throwable m881j;
        Throwable mo373c = super.mo373c(obj);
        if (mo373c == null) {
            return null;
        }
        InterfaceC0244d<T> mo374b = mo374b();
        if (C0768p0.m395d() && (mo374b instanceof InterfaceC0447e)) {
            m881j = C0519y.m881j(mo373c, (InterfaceC0447e) mo374b);
            return m881j;
        }
        return mo373c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p048w0.AbstractC0780t0
    /* renamed from: d */
    public <T> T mo372d(Object obj) {
        return obj instanceof C0794x ? (T) ((C0794x) obj).f1397a : obj;
    }

    @Override // p048w0.AbstractC0780t0
    /* renamed from: f */
    public Object mo370f() {
        return m414x();
    }

    @Override // p048w0.InterfaceC0747k
    /* renamed from: g */
    public Object mo431g(T t, Object obj) {
        return m433L(t, obj, null);
    }

    @Override // kotlin.coroutines.jvm.internal.InterfaceC0447e
    public InterfaceC0447e getCallerFrame() {
        InterfaceC0244d<T> interfaceC0244d = this.f1341g;
        if (interfaceC0244d instanceof InterfaceC0447e) {
            return (InterfaceC0447e) interfaceC0244d;
        }
        return null;
    }

    @Override // p020i0.InterfaceC0244d
    public InterfaceC0249g getContext() {
        return this.f1342h;
    }

    @Override // kotlin.coroutines.jvm.internal.InterfaceC0447e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* renamed from: j */
    public final void m428j(AbstractC0737i abstractC0737i, Throwable th) {
        try {
            abstractC0737i.mo224a(th);
        } catch (Throwable th2) {
            C0734h0.m457a(getContext(), new C0706b0(C0465i.m1043j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    @Override // p048w0.InterfaceC0747k
    /* renamed from: k */
    public void mo427k(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        AbstractC0737i m443B = m443B(interfaceC0611l);
        while (true) {
            Object obj = this._state;
            if (obj instanceof C0713d) {
                if (C0476c.m1006a(f1340k, this, obj, m443B)) {
                    return;
                }
            } else if (obj instanceof AbstractC0737i) {
                m442C(interfaceC0611l, obj);
            } else {
                boolean z = obj instanceof C0797y;
                if (z) {
                    C0797y c0797y = (C0797y) obj;
                    if (!c0797y.m259b()) {
                        m442C(interfaceC0611l, obj);
                    }
                    if (obj instanceof C0762o) {
                        if (!z) {
                            c0797y = null;
                        }
                        m429i(interfaceC0611l, c0797y != null ? c0797y.f1404a : null);
                        return;
                    }
                    return;
                } else if (obj instanceof C0794x) {
                    C0794x c0794x = (C0794x) obj;
                    if (c0794x.f1398b != null) {
                        m442C(interfaceC0611l, obj);
                    }
                    if (m443B instanceof AbstractC0717e) {
                        return;
                    }
                    if (c0794x.m264c()) {
                        m429i(interfaceC0611l, c0794x.f1401e);
                        return;
                    } else {
                        if (C0476c.m1006a(f1340k, this, obj, C0794x.m265b(c0794x, null, m443B, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else if (m443B instanceof AbstractC0717e) {
                    return;
                } else {
                    if (C0476c.m1006a(f1340k, this, obj, new C0794x(obj, m443B, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: l */
    public final void m426l(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l, Throwable th) {
        try {
            interfaceC0611l.invoke(th);
        } catch (Throwable th2) {
            C0734h0.m457a(getContext(), new C0706b0(C0465i.m1043j("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    /* renamed from: m */
    public boolean m425m(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof InterfaceC0708b2)) {
                return false;
            }
            z = obj instanceof AbstractC0737i;
        } while (!C0476c.m1006a(f1340k, this, obj, new C0762o(this, th, z)));
        AbstractC0737i abstractC0737i = z ? (AbstractC0737i) obj : null;
        if (abstractC0737i != null) {
            m428j(abstractC0737i, th);
        }
        m418t();
        m417u(this.f1370f);
        return true;
    }

    @Override // p048w0.InterfaceC0747k
    /* renamed from: o */
    public Object mo423o(T t, Object obj, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        return m433L(t, obj, interfaceC0611l);
    }

    @Override // p048w0.InterfaceC0747k
    /* renamed from: p */
    public Object mo422p(Throwable th) {
        return m433L(new C0797y(th, false, 2, null), null, null);
    }

    @Override // p048w0.InterfaceC0747k
    /* renamed from: q */
    public void mo421q(Object obj) {
        if (C0768p0.m398a()) {
            if (!(obj == C0755m.f1345a)) {
                throw new AssertionError();
            }
        }
        m417u(this.f1370f);
    }

    @Override // p048w0.InterfaceC0747k
    /* renamed from: r */
    public void mo420r(T t, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        m437H(t, this.f1370f, interfaceC0611l);
    }

    @Override // p020i0.InterfaceC0244d
    public void resumeWith(Object obj) {
        m436I(this, C0710c0.m482c(obj, this), this.f1370f, null, 4, null);
    }

    /* renamed from: s */
    public final void m419s() {
        InterfaceC0795x0 interfaceC0795x0 = this.f1343i;
        if (interfaceC0795x0 == null) {
            return;
        }
        interfaceC0795x0.mo262b();
        this.f1343i = C0704a2.f1312d;
    }

    public String toString() {
        return m441D() + '(' + C0771q0.m390c(this.f1341g) + "){" + m413y() + "}@" + C0771q0.m391b(this);
    }

    /* renamed from: v */
    public Throwable m416v(InterfaceC0764o1 interfaceC0764o1) {
        return interfaceC0764o1.mo307l();
    }

    /* renamed from: w */
    public final Object m415w() {
        InterfaceC0764o1 interfaceC0764o1;
        Throwable m881j;
        Throwable m881j2;
        Object m1077c;
        boolean m444A = m444A();
        if (m432M()) {
            if (this.f1343i == null) {
                m412z();
            }
            if (m444A) {
                m439F();
            }
            m1077c = C0437d.m1077c();
            return m1077c;
        }
        if (m444A) {
            m439F();
        }
        Object m414x = m414x();
        if (m414x instanceof C0797y) {
            Throwable th = ((C0797y) m414x).f1404a;
            if (C0768p0.m395d()) {
                m881j2 = C0519y.m881j(th, this);
                throw m881j2;
            }
            throw th;
        } else if (!C0783u0.m363b(this.f1370f) || (interfaceC0764o1 = (InterfaceC0764o1) getContext().get(InterfaceC0764o1.f1356c)) == null || interfaceC0764o1.mo322a()) {
            return mo372d(m414x);
        } else {
            CancellationException mo307l = interfaceC0764o1.mo307l();
            mo375a(m414x, mo307l);
            if (C0768p0.m395d()) {
                m881j = C0519y.m881j(mo307l, this);
                throw m881j;
            }
            throw mo307l;
        }
    }

    /* renamed from: x */
    public final Object m414x() {
        return this._state;
    }
}