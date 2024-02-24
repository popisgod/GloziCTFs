package p048w0;

import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.CoroutineExceptionHandler;
import p020i0.InterfaceC0249g;
import p044u0.C0668f;
import p044u0.C0671h;
import p044u0.InterfaceC0664b;

/* renamed from: w0.g0 */
/* loaded from: classes.dex */
public final class C0730g0 {

    /* renamed from: a */
    private static final List<CoroutineExceptionHandler> f1325a;

    static {
        InterfaceC0664b m608a;
        List<CoroutineExceptionHandler> m604e;
        m608a = C0668f.m608a(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator());
        m604e = C0671h.m604e(m608a);
        f1325a = m604e;
    }

    /* renamed from: a */
    public static final void m462a(InterfaceC0249g interfaceC0249g, Throwable th) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : f1325a) {
            try {
                coroutineExceptionHandler.handleException(interfaceC0249g, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, C0734h0.m456b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}