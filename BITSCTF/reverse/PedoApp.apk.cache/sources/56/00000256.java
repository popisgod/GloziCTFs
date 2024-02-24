package kotlinx.coroutines;

import p020i0.InterfaceC0249g;

/* loaded from: classes.dex */
public interface CoroutineExceptionHandler extends InterfaceC0249g.InterfaceC0252b {

    /* renamed from: b */
    public static final C0471a f986b = C0471a.f987d;

    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$a */
    /* loaded from: classes.dex */
    public static final class C0471a implements InterfaceC0249g.InterfaceC0254c<CoroutineExceptionHandler> {

        /* renamed from: d */
        static final /* synthetic */ C0471a f987d = new C0471a();

        private C0471a() {
        }
    }

    void handleException(InterfaceC0249g interfaceC0249g, Throwable th);
}