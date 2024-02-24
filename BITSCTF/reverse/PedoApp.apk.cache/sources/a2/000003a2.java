package p048w0;

/* renamed from: w0.y1 */
/* loaded from: classes.dex */
public abstract class AbstractC0799y1 extends AbstractC0722f0 {
    /* renamed from: q */
    public abstract AbstractC0799y1 mo240q();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public final String m258r() {
        AbstractC0799y1 abstractC0799y1;
        AbstractC0799y1 m274c = C0792w0.m274c();
        if (this == m274c) {
            return "Dispatchers.Main";
        }
        try {
            abstractC0799y1 = m274c.mo240q();
        } catch (UnsupportedOperationException unused) {
            abstractC0799y1 = null;
        }
        if (this == abstractC0799y1) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // p048w0.AbstractC0722f0
    public String toString() {
        String m258r = m258r();
        if (m258r == null) {
            return C0771q0.m392a(this) + '@' + C0771q0.m391b(this);
        }
        return m258r;
    }
}