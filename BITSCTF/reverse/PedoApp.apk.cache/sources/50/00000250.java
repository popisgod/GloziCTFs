package kotlin.jvm.internal;

import java.util.Arrays;
import p014f0.C0168p;

/* renamed from: kotlin.jvm.internal.i */
/* loaded from: classes.dex */
public class C0465i {
    private C0465i() {
    }

    /* renamed from: a */
    public static boolean m1052a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: b */
    public static void m1051b(Object obj) {
        if (obj == null) {
            m1042k();
        }
    }

    /* renamed from: c */
    public static void m1050c(Object obj, String str) {
        if (obj == null) {
            m1041l(str);
        }
    }

    /* renamed from: d */
    public static void m1049d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m1045h(new NullPointerException(str + " must not be null")));
    }

    /* renamed from: e */
    public static void m1048e(Object obj, String str) {
        if (obj == null) {
            m1040m(str);
        }
    }

    /* renamed from: f */
    public static int m1047f(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: g */
    private static String m1046g(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    /* renamed from: h */
    private static <T extends Throwable> T m1045h(T t) {
        return (T) m1044i(t, C0465i.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static <T extends Throwable> T m1044i(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    /* renamed from: j */
    public static String m1043j(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: k */
    public static void m1042k() {
        throw ((NullPointerException) m1045h(new NullPointerException()));
    }

    /* renamed from: l */
    public static void m1041l(String str) {
        throw ((NullPointerException) m1045h(new NullPointerException(str)));
    }

    /* renamed from: m */
    private static void m1040m(String str) {
        throw ((NullPointerException) m1045h(new NullPointerException(m1046g(str))));
    }

    /* renamed from: n */
    public static void m1039n(String str) {
        throw ((C0168p) m1045h(new C0168p(str)));
    }

    /* renamed from: o */
    public static void m1038o(String str) {
        m1039n("lateinit property " + str + " has not been initialized");
    }
}