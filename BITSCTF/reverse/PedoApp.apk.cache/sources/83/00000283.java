package kotlinx.coroutines.internal;

import java.util.List;
import p014f0.C0154d;
import p048w0.AbstractC0799y1;

/* renamed from: kotlinx.coroutines.internal.s */
/* loaded from: classes.dex */
public final class C0512s {

    /* renamed from: a */
    private static final boolean f1047a = true;

    /* renamed from: a */
    private static final C0513t m905a(Throwable th, String str) {
        if (f1047a) {
            return new C0513t(th, str);
        }
        if (th == null) {
            m903c();
            throw new C0154d();
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ C0513t m904b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return m905a(th, str);
    }

    /* renamed from: c */
    public static final Void m903c() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    /* renamed from: d */
    public static final AbstractC0799y1 m902d(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return m905a(th, mainDispatcherFactory.hintOnError());
        }
    }
}