package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;
import p048w0.InterfaceC0720e2;

/* renamed from: kotlinx.coroutines.internal.d0 */
/* loaded from: classes.dex */
public final class C0479d0 {

    /* renamed from: a */
    public static final C0520z f995a = new C0520z("NO_THREAD_ELEMENTS");

    /* renamed from: b */
    private static final InterfaceC0615p<Object, InterfaceC0249g.InterfaceC0252b, Object> f996b = C0480a.f999d;

    /* renamed from: c */
    private static final InterfaceC0615p<InterfaceC0720e2<?>, InterfaceC0249g.InterfaceC0252b, InterfaceC0720e2<?>> f997c = C0481b.f1000d;

    /* renamed from: d */
    private static final InterfaceC0615p<C0488g0, InterfaceC0249g.InterfaceC0252b, C0488g0> f998d = C0482c.f1001d;

    /* renamed from: kotlinx.coroutines.internal.d0$a */
    /* loaded from: classes.dex */
    static final class C0480a extends AbstractC0466j implements InterfaceC0615p<Object, InterfaceC0249g.InterfaceC0252b, Object> {

        /* renamed from: d */
        public static final C0480a f999d = new C0480a();

        C0480a() {
            super(2);
        }

        @Override // p034p0.InterfaceC0615p
        /* renamed from: a */
        public final Object invoke(Object obj, InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
            if (interfaceC0252b instanceof InterfaceC0720e2) {
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int intValue = num == null ? 1 : num.intValue();
                return intValue == 0 ? interfaceC0252b : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    }

    /* renamed from: kotlinx.coroutines.internal.d0$b */
    /* loaded from: classes.dex */
    static final class C0481b extends AbstractC0466j implements InterfaceC0615p<InterfaceC0720e2<?>, InterfaceC0249g.InterfaceC0252b, InterfaceC0720e2<?>> {

        /* renamed from: d */
        public static final C0481b f1000d = new C0481b();

        C0481b() {
            super(2);
        }

        @Override // p034p0.InterfaceC0615p
        /* renamed from: a */
        public final InterfaceC0720e2<?> invoke(InterfaceC0720e2<?> interfaceC0720e2, InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
            if (interfaceC0720e2 != null) {
                return interfaceC0720e2;
            }
            if (interfaceC0252b instanceof InterfaceC0720e2) {
                return (InterfaceC0720e2) interfaceC0252b;
            }
            return null;
        }
    }

    /* renamed from: kotlinx.coroutines.internal.d0$c */
    /* loaded from: classes.dex */
    static final class C0482c extends AbstractC0466j implements InterfaceC0615p<C0488g0, InterfaceC0249g.InterfaceC0252b, C0488g0> {

        /* renamed from: d */
        public static final C0482c f1001d = new C0482c();

        C0482c() {
            super(2);
        }

        @Override // p034p0.InterfaceC0615p
        /* renamed from: a */
        public final C0488g0 invoke(C0488g0 c0488g0, InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
            if (interfaceC0252b instanceof InterfaceC0720e2) {
                InterfaceC0720e2<?> interfaceC0720e2 = (InterfaceC0720e2) interfaceC0252b;
                c0488g0.m971a(interfaceC0720e2, interfaceC0720e2.mo451c(c0488g0.f1010a));
            }
            return c0488g0;
        }
    }

    /* renamed from: a */
    public static final void m998a(InterfaceC0249g interfaceC0249g, Object obj) {
        if (obj == f995a) {
            return;
        }
        if (obj instanceof C0488g0) {
            ((C0488g0) obj).m970b(interfaceC0249g);
            return;
        }
        Object fold = interfaceC0249g.fold(null, f997c);
        Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((InterfaceC0720e2) fold).mo450e(interfaceC0249g, obj);
    }

    /* renamed from: b */
    public static final Object m997b(InterfaceC0249g interfaceC0249g) {
        Object fold = interfaceC0249g.fold(0, f996b);
        C0465i.m1051b(fold);
        return fold;
    }

    /* renamed from: c */
    public static final Object m996c(InterfaceC0249g interfaceC0249g, Object obj) {
        if (obj == null) {
            obj = m997b(interfaceC0249g);
        }
        return obj == 0 ? f995a : obj instanceof Integer ? interfaceC0249g.fold(new C0488g0(interfaceC0249g, ((Number) obj).intValue()), f998d) : ((InterfaceC0720e2) obj).mo451c(interfaceC0249g);
    }
}