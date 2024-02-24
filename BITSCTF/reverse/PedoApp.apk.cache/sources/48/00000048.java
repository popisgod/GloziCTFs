package androidx.core.content;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Executor;
import p013f.C0149a;

/* renamed from: androidx.core.content.a */
/* loaded from: classes.dex */
public class C0061a {

    /* renamed from: a */
    private static final Object f84a = new Object();

    /* renamed from: b */
    private static final Object f85b = new Object();

    /* renamed from: androidx.core.content.a$a */
    /* loaded from: classes.dex */
    static class C0062a {
        /* renamed from: a */
        static Executor m2224a(Context context) {
            return context.getMainExecutor();
        }
    }

    /* renamed from: a */
    public static int m2226a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    /* renamed from: b */
    public static Executor m2225b(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? C0062a.m2224a(context) : C0149a.m2019a(new Handler(context.getMainLooper()));
    }
}