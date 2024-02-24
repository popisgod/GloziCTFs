package p048w0;

import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* renamed from: w0.a */
/* loaded from: classes.dex */
public abstract class AbstractC0699a<T> extends C0787v1 implements InterfaceC0244d<T>, InterfaceC0753l0 {

    /* renamed from: e */
    private final InterfaceC0249g f1305e;

    public AbstractC0699a(InterfaceC0249g interfaceC0249g, boolean z, boolean z2) {
        super(z2);
        if (z) {
            m330S((InterfaceC0764o1) interfaceC0249g.get(InterfaceC0764o1.f1356c));
        }
        this.f1305e = interfaceC0249g.plus(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p048w0.C0787v1
    /* renamed from: C */
    public String mo346C() {
        return C0465i.m1043j(C0771q0.m392a(this), " was cancelled");
    }

    @Override // p048w0.C0787v1
    /* renamed from: R */
    public final void mo331R(Throwable th) {
        C0734h0.m457a(this.f1305e, th);
    }

    @Override // p048w0.C0787v1
    /* renamed from: Y */
    public String mo324Y() {
        String m476b = C0718e0.m476b(this.f1305e);
        if (m476b == null) {
            return super.mo324Y();
        }
        return '\"' + m476b + "\":" + super.mo324Y();
    }

    @Override // p048w0.C0787v1, p048w0.InterfaceC0764o1
    /* renamed from: a */
    public boolean mo322a() {
        return super.mo322a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p048w0.C0787v1
    /* renamed from: d0 */
    protected final void mo316d0(Object obj) {
        if (!(obj instanceof C0797y)) {
            m510v0(obj);
            return;
        }
        C0797y c0797y = (C0797y) obj;
        m511u0(c0797y.f1404a, c0797y.m260a());
    }

    @Override // p020i0.InterfaceC0244d
    public final InterfaceC0249g getContext() {
        return this.f1305e;
    }

    @Override // p020i0.InterfaceC0244d
    public final void resumeWith(Object obj) {
        Object m326W = m326W(C0710c0.m481d(obj, null, 1, null));
        if (m326W == C0793w1.f1391b) {
            return;
        }
        mo382t0(m326W);
    }

    @Override // p048w0.InterfaceC0753l0
    /* renamed from: s */
    public InterfaceC0249g mo411s() {
        return this.f1305e;
    }

    /* renamed from: t0 */
    protected void mo382t0(Object obj) {
        mo292x(obj);
    }

    /* renamed from: u0 */
    protected void m511u0(Throwable th, boolean z) {
    }

    /* renamed from: v0 */
    protected void m510v0(T t) {
    }

    /* renamed from: w0 */
    public final <R> void m509w0(EnumC0759n0 enumC0759n0, R r, InterfaceC0615p<? super R, ? super InterfaceC0244d<? super T>, ? extends Object> interfaceC0615p) {
        enumC0759n0.m407b(interfaceC0615p, r, this);
    }
}