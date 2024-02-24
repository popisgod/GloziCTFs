package p050x0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Objects;
import p014f0.C0161k;
import p014f0.C0164l;

/* renamed from: x0.c */
/* loaded from: classes.dex */
public final class C0807c {

    /* renamed from: a */
    public static final AbstractC0806b f1415a;
    private static volatile Choreographer choreographer;

    static {
        Object m2010a;
        try {
            C0161k.C0162a c0162a = C0161k.f229d;
            m2010a = C0161k.m2010a(new C0805a(m237a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            C0161k.C0162a c0162a2 = C0161k.f229d;
            m2010a = C0161k.m2010a(C0164l.m2006a(th));
        }
        f1415a = C0161k.m2008c(m2010a) ? null : m2010a;
    }

    /* renamed from: a */
    public static final Handler m237a(Looper looper, boolean z) {
        int i;
        if (!z || (i = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) invoke;
    }
}