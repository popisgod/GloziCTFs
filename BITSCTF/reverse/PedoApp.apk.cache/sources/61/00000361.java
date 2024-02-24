package p048w0;

import kotlinx.coroutines.CoroutineExceptionHandler;
import p014f0.C0152b;
import p020i0.InterfaceC0249g;

/* renamed from: w0.h0 */
/* loaded from: classes.dex */
public final class C0734h0 {
    /* renamed from: a */
    public static final void m457a(InterfaceC0249g interfaceC0249g, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) interfaceC0249g.get(CoroutineExceptionHandler.f986b);
            if (coroutineExceptionHandler == null) {
                C0730g0.m462a(interfaceC0249g, th);
            } else {
                coroutineExceptionHandler.handleException(interfaceC0249g, th);
            }
        } catch (Throwable th2) {
            C0730g0.m462a(interfaceC0249g, m456b(th, th2));
        }
    }

    /* renamed from: b */
    public static final Throwable m456b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        C0152b.m2017a(runtimeException, th);
        return runtimeException;
    }
}