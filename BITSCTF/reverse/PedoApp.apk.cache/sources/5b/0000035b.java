package p048w0;

/* renamed from: w0.f2 */
/* loaded from: classes.dex */
public final class C0728f2 {

    /* renamed from: a */
    public static final C0728f2 f1323a = new C0728f2();

    /* renamed from: b */
    private static final ThreadLocal<AbstractC0801z0> f1324b = new ThreadLocal<>();

    private C0728f2() {
    }

    /* renamed from: a */
    public final AbstractC0801z0 m467a() {
        ThreadLocal<AbstractC0801z0> threadLocal = f1324b;
        AbstractC0801z0 abstractC0801z0 = threadLocal.get();
        if (abstractC0801z0 == null) {
            AbstractC0801z0 m480a = C0711c1.m480a();
            threadLocal.set(m480a);
            return m480a;
        }
        return abstractC0801z0;
    }

    /* renamed from: b */
    public final void m466b() {
        f1324b.set(null);
    }

    /* renamed from: c */
    public final void m465c(AbstractC0801z0 abstractC0801z0) {
        f1324b.set(abstractC0801z0);
    }
}