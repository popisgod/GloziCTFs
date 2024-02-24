package p021j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: j.a */
/* loaded from: classes.dex */
public final class C0429a {

    /* renamed from: a */
    private static long f949a;

    /* renamed from: b */
    private static Method f950b;

    /* renamed from: c */
    private static Method f951c;

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m1094a(String str, int i) {
        try {
            if (f950b == null) {
                C0431c.m1085a(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        m1093b(str, i);
    }

    /* renamed from: b */
    private static void m1093b(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f950b == null) {
                    f950b = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                f950b.invoke(null, Long.valueOf(f949a), str, Integer.valueOf(i));
            } catch (Exception e) {
                m1088g("asyncTraceBegin", e);
            }
        }
    }

    /* renamed from: c */
    public static void m1092c(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            C0430b.m1087a(str);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public static void m1091d(String str, int i) {
        try {
            if (f951c == null) {
                C0431c.m1084b(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        m1090e(str, i);
    }

    /* renamed from: e */
    private static void m1090e(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f951c == null) {
                    f951c = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                }
                f951c.invoke(null, Long.valueOf(f949a), str, Integer.valueOf(i));
            } catch (Exception e) {
                m1088g("asyncTraceEnd", e);
            }
        }
    }

    /* renamed from: f */
    public static void m1089f() {
        if (Build.VERSION.SDK_INT >= 18) {
            C0430b.m1086b();
        }
    }

    /* renamed from: g */
    private static void m1088g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }
}