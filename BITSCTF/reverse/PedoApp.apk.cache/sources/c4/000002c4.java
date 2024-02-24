package p032o0;

import kotlin.jvm.internal.C0465i;
import kotlin.jvm.internal.C0468l;
import kotlin.jvm.internal.InterfaceC0457b;
import p042t0.InterfaceC0654c;

/* renamed from: o0.a */
/* loaded from: classes.dex */
public final class C0577a {
    /* renamed from: a */
    public static final <T> Class<T> m734a(InterfaceC0654c<T> interfaceC0654c) {
        C0465i.m1048e(interfaceC0654c, "<this>");
        Class<T> cls = (Class<T>) ((InterfaceC0457b) interfaceC0654c).mo1037b();
        if (!cls.isPrimitive()) {
            C0465i.m1050c(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    cls = (Class<T>) Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    cls = (Class<T>) Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    cls = (Class<T>) Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                    break;
                }
                break;
        }
        C0465i.m1050c(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    /* renamed from: b */
    public static final <T> InterfaceC0654c<T> m733b(Class<T> cls) {
        C0465i.m1048e(cls, "<this>");
        return C0468l.m1035b(cls);
    }
}