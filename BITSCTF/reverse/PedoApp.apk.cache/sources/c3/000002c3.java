package p031o;

import android.util.Log;

/* renamed from: o.b */
/* loaded from: classes.dex */
public class C0576b {
    /* renamed from: a */
    public static void m742a(String str, String str2) {
    }

    /* renamed from: b */
    public static void m741b(String str, String str2) {
        Log.e(str, str2);
    }

    /* renamed from: c */
    public static void m740c(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    /* renamed from: d */
    public static String m739d(Throwable th) {
        return Log.getStackTraceString(th);
    }

    /* renamed from: e */
    public static void m738e(String str, String str2) {
    }

    /* renamed from: f */
    public static void m737f(String str, String str2) {
    }

    /* renamed from: g */
    public static void m736g(String str, String str2) {
        Log.w(str, str2);
    }

    /* renamed from: h */
    public static void m735h(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }
}