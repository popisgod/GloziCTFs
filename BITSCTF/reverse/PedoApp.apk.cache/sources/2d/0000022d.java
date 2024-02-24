package p021j;

import android.os.Trace;

/* renamed from: j.c */
/* loaded from: classes.dex */
final class C0431c {
    /* renamed from: a */
    public static void m1085a(String str, int i) {
        Trace.beginAsyncSection(str, i);
    }

    /* renamed from: b */
    public static void m1084b(String str, int i) {
        Trace.endAsyncSection(str, i);
    }
}