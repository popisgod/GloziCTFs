package p024k0;

import kotlin.jvm.internal.C0465i;
import p026l0.C0559a;
import p028m0.C0565a;
import p046v0.C0692n;

/* renamed from: k0.b */
/* loaded from: classes.dex */
public final class C0441b {

    /* renamed from: a */
    public static final C0439a f965a;

    static {
        C0439a c0439a;
        Object newInstance;
        Object newInstance2;
        int m1076a = m1076a();
        if (m1076a >= 65544 || m1076a < 65536) {
            try {
                newInstance = C0565a.class.newInstance();
                C0465i.m1049d(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            } catch (ClassNotFoundException unused) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                C0465i.m1049d(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c0439a = (C0439a) newInstance3;
                } catch (ClassCastException e) {
                    ClassLoader classLoader = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader2 = C0439a.class.getClassLoader();
                    if (C0465i.m1052a(classLoader, classLoader2)) {
                        throw e;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                }
            }
            try {
                if (newInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                c0439a = (C0439a) newInstance;
                f965a = c0439a;
            } catch (ClassCastException e2) {
                ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = C0439a.class.getClassLoader();
                if (C0465i.m1052a(classLoader3, classLoader4)) {
                    throw e2;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
            }
        }
        if (m1076a >= 65543 || m1076a < 65536) {
            try {
                try {
                    newInstance2 = C0559a.class.newInstance();
                    C0465i.m1049d(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader6 = C0439a.class.getClassLoader();
                        if (C0465i.m1052a(classLoader5, classLoader6)) {
                            throw e3;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassNotFoundException unused3) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                C0465i.m1049d(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c0439a = (C0439a) newInstance4;
                } catch (ClassCastException e4) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = C0439a.class.getClassLoader();
                    if (C0465i.m1052a(classLoader7, classLoader8)) {
                        throw e4;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                }
            }
            if (newInstance2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            c0439a = (C0439a) newInstance2;
            f965a = c0439a;
        }
        c0439a = new C0439a();
        f965a = c0439a;
    }

    /* renamed from: a */
    private static final int m1076a() {
        int m517z;
        int m517z2;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        m517z = C0692n.m517z(property, '.', 0, false, 6, null);
        if (m517z < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i = m517z + 1;
        m517z2 = C0692n.m517z(property, '.', i, false, 4, null);
        if (m517z2 < 0) {
            m517z2 = property.length();
        }
        String substring = property.substring(0, m517z);
        C0465i.m1049d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = property.substring(i, m517z2);
        C0465i.m1049d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}