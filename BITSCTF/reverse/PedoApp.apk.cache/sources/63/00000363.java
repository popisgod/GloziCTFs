package p048w0;

import kotlinx.coroutines.internal.C0479d0;
import kotlinx.coroutines.internal.C0518x;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;

/* renamed from: w0.h2 */
/* loaded from: classes.dex */
public final class C0736h2<T> extends C0518x<T> {

    /* renamed from: g */
    private InterfaceC0249g f1328g;

    /* renamed from: h */
    private Object f1329h;

    @Override // kotlinx.coroutines.internal.C0518x, p048w0.AbstractC0699a
    /* renamed from: t0 */
    protected void mo382t0(Object obj) {
        InterfaceC0249g interfaceC0249g = this.f1328g;
        if (interfaceC0249g != null) {
            C0479d0.m998a(interfaceC0249g, this.f1329h);
            this.f1328g = null;
            this.f1329h = null;
        }
        Object m484a = C0710c0.m484a(obj, this.f1054f);
        InterfaceC0244d<T> interfaceC0244d = this.f1054f;
        InterfaceC0249g context = interfaceC0244d.getContext();
        Object m996c = C0479d0.m996c(context, null);
        C0736h2<?> m473e = m996c != C0479d0.f995a ? C0718e0.m473e(interfaceC0244d, context, m996c) : null;
        try {
            this.f1054f.resumeWith(m484a);
            C0169q c0169q = C0169q.f235a;
        } finally {
            if (m473e == null || m473e.m454y0()) {
                C0479d0.m998a(context, m996c);
            }
        }
    }

    /* renamed from: y0 */
    public final boolean m454y0() {
        if (this.f1328g == null) {
            return false;
        }
        this.f1328g = null;
        this.f1329h = null;
        return true;
    }

    /* renamed from: z0 */
    public final void m453z0(InterfaceC0249g interfaceC0249g, Object obj) {
        this.f1328g = interfaceC0249g;
        this.f1329h = obj;
    }
}