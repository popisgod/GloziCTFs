package kotlinx.coroutines.internal;

import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import p020i0.InterfaceC0244d;
import p022j0.C0434c;
import p048w0.AbstractC0699a;
import p048w0.C0710c0;
import p048w0.InterfaceC0764o1;
import p048w0.InterfaceC0770q;

/* renamed from: kotlinx.coroutines.internal.x */
/* loaded from: classes.dex */
public class C0518x<T> extends AbstractC0699a<T> implements InterfaceC0447e {

    /* renamed from: f */
    public final InterfaceC0244d<T> f1054f;

    @Override // p048w0.C0787v1
    /* renamed from: U */
    protected final boolean mo328U() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.InterfaceC0447e
    public final InterfaceC0447e getCallerFrame() {
        InterfaceC0244d<T> interfaceC0244d = this.f1054f;
        if (interfaceC0244d instanceof InterfaceC0447e) {
            return (InterfaceC0447e) interfaceC0244d;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.InterfaceC0447e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // p048w0.AbstractC0699a
    /* renamed from: t0 */
    protected void mo382t0(Object obj) {
        InterfaceC0244d<T> interfaceC0244d = this.f1054f;
        interfaceC0244d.resumeWith(C0710c0.m484a(obj, interfaceC0244d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p048w0.C0787v1
    /* renamed from: x */
    public void mo292x(Object obj) {
        InterfaceC0244d m1078b;
        m1078b = C0434c.m1078b(this.f1054f);
        C0489h.m967c(m1078b, C0710c0.m484a(obj, this.f1054f), null, 2, null);
    }

    /* renamed from: x0 */
    public final InterfaceC0764o1 m891x0() {
        InterfaceC0770q m334O = m334O();
        if (m334O == null) {
            return null;
        }
        return m334O.getParent();
    }
}