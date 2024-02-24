package p048w0;

/* renamed from: w0.r1 */
/* loaded from: classes.dex */
public class C0775r1 extends C0787v1 implements InterfaceC0791w {

    /* renamed from: e */
    private final boolean f1367e;

    public C0775r1(InterfaceC0764o1 interfaceC0764o1) {
        super(true);
        m330S(interfaceC0764o1);
        this.f1367e = m383t0();
    }

    /* renamed from: t0 */
    private final boolean m383t0() {
        InterfaceC0770q m334O = m334O();
        C0773r c0773r = m334O instanceof C0773r ? (C0773r) m334O : null;
        if (c0773r == null) {
            return false;
        }
        do {
            C0787v1 m358z = c0773r.m358z();
            if (m358z.mo337L()) {
                return true;
            }
            InterfaceC0770q m334O2 = m358z.m334O();
            if (m334O2 instanceof C0773r) {
                c0773r = (C0773r) m334O2;
                continue;
            } else {
                c0773r = null;
                continue;
            }
        } while (c0773r != null);
        return false;
    }

    @Override // p048w0.C0787v1
    /* renamed from: L */
    public boolean mo337L() {
        return this.f1367e;
    }

    @Override // p048w0.C0787v1
    /* renamed from: M */
    public boolean mo336M() {
        return true;
    }
}