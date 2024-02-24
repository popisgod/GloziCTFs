package p012e0;

import p021j.C0429a;

/* renamed from: e0.e */
/* loaded from: classes.dex */
public final class C0143e {
    /* renamed from: a */
    public static void m2035a(String str) {
        C0429a.m1092c(m2033c(str));
    }

    /* renamed from: b */
    public static void m2034b(String str, int i) {
        C0429a.m1094a(m2033c(str), i);
    }

    /* renamed from: c */
    private static String m2033c(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    /* renamed from: d */
    public static void m2032d() {
        C0429a.m1089f();
    }

    /* renamed from: e */
    public static void m2031e(String str, int i) {
        C0429a.m1091d(m2033c(str), i);
    }
}