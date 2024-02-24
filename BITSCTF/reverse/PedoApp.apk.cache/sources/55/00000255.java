package kotlin.jvm.internal;

import p014f0.InterfaceC0153c;
import p034p0.InterfaceC0600a;
import p034p0.InterfaceC0601b;
import p034p0.InterfaceC0602c;
import p034p0.InterfaceC0603d;
import p034p0.InterfaceC0604e;
import p034p0.InterfaceC0605f;
import p034p0.InterfaceC0606g;
import p034p0.InterfaceC0607h;
import p034p0.InterfaceC0608i;
import p034p0.InterfaceC0609j;
import p034p0.InterfaceC0610k;
import p034p0.InterfaceC0611l;
import p034p0.InterfaceC0612m;
import p034p0.InterfaceC0613n;
import p034p0.InterfaceC0614o;
import p034p0.InterfaceC0615p;
import p034p0.InterfaceC0616q;
import p034p0.InterfaceC0617r;
import p034p0.InterfaceC0618s;
import p034p0.InterfaceC0619t;
import p034p0.InterfaceC0620u;
import p034p0.InterfaceC0621v;
import p034p0.InterfaceC0622w;

/* renamed from: kotlin.jvm.internal.n */
/* loaded from: classes.dex */
public class C0470n {
    /* renamed from: a */
    public static Object m1026a(Object obj, int i) {
        if (obj != null && !m1024c(obj, i)) {
            m1021f(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    /* renamed from: b */
    public static int m1025b(Object obj) {
        if (obj instanceof InterfaceC0462f) {
            return ((InterfaceC0462f) obj).getArity();
        }
        if (obj instanceof InterfaceC0600a) {
            return 0;
        }
        if (obj instanceof InterfaceC0611l) {
            return 1;
        }
        if (obj instanceof InterfaceC0615p) {
            return 2;
        }
        if (obj instanceof InterfaceC0616q) {
            return 3;
        }
        if (obj instanceof InterfaceC0617r) {
            return 4;
        }
        if (obj instanceof InterfaceC0618s) {
            return 5;
        }
        if (obj instanceof InterfaceC0619t) {
            return 6;
        }
        if (obj instanceof InterfaceC0620u) {
            return 7;
        }
        if (obj instanceof InterfaceC0621v) {
            return 8;
        }
        if (obj instanceof InterfaceC0622w) {
            return 9;
        }
        if (obj instanceof InterfaceC0601b) {
            return 10;
        }
        if (obj instanceof InterfaceC0602c) {
            return 11;
        }
        if (obj instanceof InterfaceC0603d) {
            return 12;
        }
        if (obj instanceof InterfaceC0604e) {
            return 13;
        }
        if (obj instanceof InterfaceC0605f) {
            return 14;
        }
        if (obj instanceof InterfaceC0606g) {
            return 15;
        }
        if (obj instanceof InterfaceC0607h) {
            return 16;
        }
        if (obj instanceof InterfaceC0608i) {
            return 17;
        }
        if (obj instanceof InterfaceC0609j) {
            return 18;
        }
        if (obj instanceof InterfaceC0610k) {
            return 19;
        }
        if (obj instanceof InterfaceC0612m) {
            return 20;
        }
        if (obj instanceof InterfaceC0613n) {
            return 21;
        }
        return obj instanceof InterfaceC0614o ? 22 : -1;
    }

    /* renamed from: c */
    public static boolean m1024c(Object obj, int i) {
        return (obj instanceof InterfaceC0153c) && m1025b(obj) == i;
    }

    /* renamed from: d */
    private static <T extends Throwable> T m1023d(T t) {
        return (T) C0465i.m1044i(t, C0470n.class.getName());
    }

    /* renamed from: e */
    public static ClassCastException m1022e(ClassCastException classCastException) {
        throw ((ClassCastException) m1023d(classCastException));
    }

    /* renamed from: f */
    public static void m1021f(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        m1020g(name + " cannot be cast to " + str);
    }

    /* renamed from: g */
    public static void m1020g(String str) {
        throw m1022e(new ClassCastException(str));
    }
}