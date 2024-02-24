package p012e0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* renamed from: e0.a */
/* loaded from: classes.dex */
public final class C0139a {
    /* renamed from: a */
    public static Handler m2041a(Looper looper) {
        return Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(looper) : new Handler(looper);
    }
}