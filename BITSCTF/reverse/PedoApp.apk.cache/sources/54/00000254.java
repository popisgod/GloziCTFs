package kotlin.jvm.internal;

import p042t0.InterfaceC0654c;
import p042t0.InterfaceC0655d;
import p042t0.InterfaceC0656e;

/* renamed from: kotlin.jvm.internal.m */
/* loaded from: classes.dex */
public class C0469m {
    /* renamed from: a */
    public InterfaceC0656e m1031a(C0463g c0463g) {
        return c0463g;
    }

    /* renamed from: b */
    public InterfaceC0654c m1030b(Class cls) {
        return new C0458c(cls);
    }

    /* renamed from: c */
    public InterfaceC0655d m1029c(Class cls, String str) {
        return new C0467k(cls, str);
    }

    /* renamed from: d */
    public String m1028d(InterfaceC0462f interfaceC0462f) {
        String obj = interfaceC0462f.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    /* renamed from: e */
    public String m1027e(AbstractC0466j abstractC0466j) {
        return m1028d(abstractC0466j);
    }
}