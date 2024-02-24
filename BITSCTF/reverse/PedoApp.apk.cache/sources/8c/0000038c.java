package p048w0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.C0489h;
import kotlinx.coroutines.internal.C0518x;
import p020i0.InterfaceC0244d;
import p022j0.C0434c;

/* renamed from: w0.s0 */
/* loaded from: classes.dex */
public final class C0777s0<T> extends C0518x<T> {

    /* renamed from: g */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1368g = AtomicIntegerFieldUpdater.newUpdater(C0777s0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    /* renamed from: y0 */
    private final boolean m381y0() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f1368g.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // kotlinx.coroutines.internal.C0518x, p048w0.AbstractC0699a
    /* renamed from: t0 */
    protected void mo382t0(Object obj) {
        InterfaceC0244d m1078b;
        if (m381y0()) {
            return;
        }
        m1078b = C0434c.m1078b(this.f1054f);
        C0489h.m967c(m1078b, C0710c0.m484a(obj, this.f1054f), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.C0518x, p048w0.C0787v1
    /* renamed from: x */
    public void mo292x(Object obj) {
        mo382t0(obj);
    }
}