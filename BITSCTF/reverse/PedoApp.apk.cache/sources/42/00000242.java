package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.C0465i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: kotlin.coroutines.jvm.internal.i */
/* loaded from: classes.dex */
public final class C0451i {

    /* renamed from: a */
    public static final C0451i f967a = new C0451i();

    /* renamed from: b */
    private static final C0452a f968b = new C0452a(null, null, null);

    /* renamed from: c */
    private static C0452a f969c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kotlin.coroutines.jvm.internal.i$a */
    /* loaded from: classes.dex */
    public static final class C0452a {

        /* renamed from: a */
        public final Method f970a;

        /* renamed from: b */
        public final Method f971b;

        /* renamed from: c */
        public final Method f972c;

        public C0452a(Method method, Method method2, Method method3) {
            this.f970a = method;
            this.f971b = method2;
            this.f972c = method3;
        }
    }

    private C0451i() {
    }

    /* renamed from: a */
    private final C0452a m1059a(AbstractC0443a abstractC0443a) {
        try {
            C0452a c0452a = new C0452a(Class.class.getDeclaredMethod("getModule", new Class[0]), abstractC0443a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), abstractC0443a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f969c = c0452a;
            return c0452a;
        } catch (Exception unused) {
            C0452a c0452a2 = f968b;
            f969c = c0452a2;
            return c0452a2;
        }
    }

    /* renamed from: b */
    public final String m1058b(AbstractC0443a continuation) {
        C0465i.m1048e(continuation, "continuation");
        C0452a c0452a = f969c;
        if (c0452a == null) {
            c0452a = m1059a(continuation);
        }
        if (c0452a == f968b) {
            return null;
        }
        Method method = c0452a.f970a;
        Object invoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = c0452a.f971b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = c0452a.f972c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}