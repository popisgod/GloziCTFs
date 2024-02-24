package kotlin.jvm.internal;

import p042t0.InterfaceC0654c;
import p042t0.InterfaceC0655d;
import p042t0.InterfaceC0656e;

/* renamed from: kotlin.jvm.internal.l */
/* loaded from: classes.dex */
public class C0468l {

    /* renamed from: a */
    private static final C0469m f984a;

    /* renamed from: b */
    private static final InterfaceC0654c[] f985b;

    static {
        C0469m c0469m = null;
        try {
            c0469m = (C0469m) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c0469m == null) {
            c0469m = new C0469m();
        }
        f984a = c0469m;
        f985b = new InterfaceC0654c[0];
    }

    /* renamed from: a */
    public static InterfaceC0656e m1036a(C0463g c0463g) {
        return f984a.m1031a(c0463g);
    }

    /* renamed from: b */
    public static InterfaceC0654c m1035b(Class cls) {
        return f984a.m1030b(cls);
    }

    /* renamed from: c */
    public static InterfaceC0655d m1034c(Class cls) {
        return f984a.m1029c(cls, "");
    }

    /* renamed from: d */
    public static String m1033d(InterfaceC0462f interfaceC0462f) {
        return f984a.m1028d(interfaceC0462f);
    }

    /* renamed from: e */
    public static String m1032e(AbstractC0466j abstractC0466j) {
        return f984a.m1027e(abstractC0466j);
    }
}