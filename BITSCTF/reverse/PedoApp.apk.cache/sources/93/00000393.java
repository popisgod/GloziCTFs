package p048w0;

import kotlin.jvm.internal.C0465i;

/* renamed from: w0.u1 */
/* loaded from: classes.dex */
public abstract class AbstractC0784u1 extends AbstractC0700a0 implements InterfaceC0795x0, InterfaceC0744j1 {

    /* renamed from: g */
    public C0787v1 f1372g;

    /* renamed from: A */
    public final void m359A(C0787v1 c0787v1) {
        this.f1372g = c0787v1;
    }

    @Override // p048w0.InterfaceC0744j1
    /* renamed from: a */
    public boolean mo247a() {
        return true;
    }

    @Override // p048w0.InterfaceC0795x0
    /* renamed from: b */
    public void mo262b() {
        m358z().m312h0(this);
    }

    @Override // p048w0.InterfaceC0744j1
    /* renamed from: c */
    public C0802z1 mo246c() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.C0504o
    public String toString() {
        return C0771q0.m392a(this) + '@' + C0771q0.m391b(this) + "[job@" + C0771q0.m391b(m358z()) + ']';
    }

    /* renamed from: z */
    public final C0787v1 m358z() {
        C0787v1 c0787v1 = this.f1372g;
        if (c0787v1 != null) {
            return c0787v1;
        }
        C0465i.m1038o("job");
        return null;
    }
}