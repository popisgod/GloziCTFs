package p048w0;

import kotlinx.coroutines.internal.C0472a;

/* renamed from: w0.z0 */
/* loaded from: classes.dex */
public abstract class AbstractC0801z0 extends AbstractC0722f0 {

    /* renamed from: e */
    private long f1408e;

    /* renamed from: f */
    private boolean f1409f;

    /* renamed from: g */
    private C0472a<AbstractC0780t0<?>> f1410g;

    /* renamed from: r */
    private final long m256r(boolean z) {
        return z ? 4294967296L : 1L;
    }

    /* renamed from: v */
    public static /* synthetic */ void m252v(AbstractC0801z0 abstractC0801z0, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        abstractC0801z0.m253u(z);
    }

    /* renamed from: q */
    public final void m257q(boolean z) {
        long m256r = this.f1408e - m256r(z);
        this.f1408e = m256r;
        if (m256r > 0) {
            return;
        }
        if (C0768p0.m398a()) {
            if (!(this.f1408e == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f1409f) {
            mo248z();
        }
    }

    /* renamed from: s */
    public final void m255s(AbstractC0780t0<?> abstractC0780t0) {
        C0472a<AbstractC0780t0<?>> c0472a = this.f1410g;
        if (c0472a == null) {
            c0472a = new C0472a<>();
            this.f1410g = c0472a;
        }
        c0472a.m1019a(abstractC0780t0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public long mo254t() {
        C0472a<AbstractC0780t0<?>> c0472a = this.f1410g;
        return (c0472a == null || c0472a.m1017c()) ? Long.MAX_VALUE : 0L;
    }

    /* renamed from: u */
    public final void m253u(boolean z) {
        this.f1408e += m256r(z);
        if (z) {
            return;
        }
        this.f1409f = true;
    }

    /* renamed from: w */
    public final boolean m251w() {
        return this.f1408e >= m256r(true);
    }

    /* renamed from: x */
    public final boolean m250x() {
        C0472a<AbstractC0780t0<?>> c0472a = this.f1410g;
        if (c0472a == null) {
            return true;
        }
        return c0472a.m1017c();
    }

    /* renamed from: y */
    public final boolean m249y() {
        AbstractC0780t0<?> m1016d;
        C0472a<AbstractC0780t0<?>> c0472a = this.f1410g;
        if (c0472a == null || (m1016d = c0472a.m1016d()) == null) {
            return false;
        }
        m1016d.run();
        return true;
    }

    /* renamed from: z */
    protected void mo248z() {
    }
}