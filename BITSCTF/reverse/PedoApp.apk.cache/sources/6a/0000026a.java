package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p048w0.AbstractC0722f0;
import p048w0.AbstractC0780t0;
import p048w0.AbstractC0801z0;
import p048w0.C0710c0;
import p048w0.C0728f2;
import p048w0.C0752l;
import p048w0.C0768p0;
import p048w0.C0771q0;
import p048w0.C0800z;
import p048w0.InterfaceC0747k;

/* renamed from: kotlinx.coroutines.internal.g */
/* loaded from: classes.dex */
public final class C0487g<T> extends AbstractC0780t0<T> implements InterfaceC0447e, InterfaceC0244d<T> {

    /* renamed from: k */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1005k = AtomicReferenceFieldUpdater.newUpdater(C0487g.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: g */
    public final AbstractC0722f0 f1006g;

    /* renamed from: h */
    public final InterfaceC0244d<T> f1007h;

    /* renamed from: i */
    public Object f1008i;

    /* renamed from: j */
    public final Object f1009j;

    /* JADX WARN: Multi-variable type inference failed */
    public C0487g(AbstractC0722f0 abstractC0722f0, InterfaceC0244d<? super T> interfaceC0244d) {
        super(-1);
        this.f1006g = abstractC0722f0;
        this.f1007h = interfaceC0244d;
        this.f1008i = C0489h.m969a();
        this.f1009j = C0479d0.m997b(getContext());
        this._reusableCancellableContinuation = null;
    }

    /* renamed from: j */
    private final C0752l<?> m976j() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof C0752l) {
            return (C0752l) obj;
        }
        return null;
    }

    @Override // p048w0.AbstractC0780t0
    /* renamed from: a */
    public void mo375a(Object obj, Throwable th) {
        if (obj instanceof C0800z) {
            ((C0800z) obj).f1407b.invoke(th);
        }
    }

    @Override // p048w0.AbstractC0780t0
    /* renamed from: b */
    public InterfaceC0244d<T> mo374b() {
        return this;
    }

    @Override // p048w0.AbstractC0780t0
    /* renamed from: f */
    public Object mo370f() {
        Object obj = this.f1008i;
        if (C0768p0.m398a()) {
            if (!(obj != C0489h.m969a())) {
                throw new AssertionError();
            }
        }
        this.f1008i = C0489h.m969a();
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.InterfaceC0447e
    public InterfaceC0447e getCallerFrame() {
        InterfaceC0244d<T> interfaceC0244d = this.f1007h;
        if (interfaceC0244d instanceof InterfaceC0447e) {
            return (InterfaceC0447e) interfaceC0244d;
        }
        return null;
    }

    @Override // p020i0.InterfaceC0244d
    public InterfaceC0249g getContext() {
        return this.f1007h.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.InterfaceC0447e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* renamed from: h */
    public final void m978h() {
        do {
        } while (this._reusableCancellableContinuation == C0489h.f1015b);
    }

    /* renamed from: i */
    public final C0752l<T> m977i() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = C0489h.f1015b;
                return null;
            } else if (obj instanceof C0752l) {
                if (C0476c.m1006a(f1005k, this, obj, C0489h.f1015b)) {
                    return (C0752l) obj;
                }
            } else if (obj != C0489h.f1015b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(C0465i.m1043j("Inconsistent state ", obj).toString());
            }
        }
    }

    /* renamed from: l */
    public final boolean m975l() {
        return this._reusableCancellableContinuation != null;
    }

    /* renamed from: m */
    public final boolean m974m(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            C0520z c0520z = C0489h.f1015b;
            if (C0465i.m1052a(obj, c0520z)) {
                if (C0476c.m1006a(f1005k, this, c0520z, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (C0476c.m1006a(f1005k, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    /* renamed from: n */
    public final void m973n() {
        m978h();
        C0752l<?> m976j = m976j();
        if (m976j == null) {
            return;
        }
        m976j.m419s();
    }

    @Override // p020i0.InterfaceC0244d
    public void resumeWith(Object obj) {
        InterfaceC0249g context = this.f1007h.getContext();
        Object m481d = C0710c0.m481d(obj, null, 1, null);
        if (this.f1006g.mo241p(context)) {
            this.f1008i = m481d;
            this.f1370f = 0;
            this.f1006g.mo242o(context, this);
            return;
        }
        C0768p0.m398a();
        AbstractC0801z0 m467a = C0728f2.f1323a.m467a();
        if (m467a.m251w()) {
            this.f1008i = m481d;
            this.f1370f = 0;
            m467a.m255s(this);
            return;
        }
        m467a.m253u(true);
        try {
            InterfaceC0249g context2 = getContext();
            Object m996c = C0479d0.m996c(context2, this.f1009j);
            this.f1007h.resumeWith(obj);
            C0169q c0169q = C0169q.f235a;
            C0479d0.m998a(context2, m996c);
            do {
            } while (m467a.m249y());
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: s */
    public final Throwable m972s(InterfaceC0747k<?> interfaceC0747k) {
        C0520z c0520z;
        do {
            Object obj = this._reusableCancellableContinuation;
            c0520z = C0489h.f1015b;
            if (obj != c0520z) {
                if (obj instanceof Throwable) {
                    if (C0476c.m1006a(f1005k, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(C0465i.m1043j("Inconsistent state ", obj).toString());
            }
        } while (!C0476c.m1006a(f1005k, this, c0520z, interfaceC0747k));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f1006g + ", " + C0771q0.m390c(this.f1007h) + ']';
    }
}