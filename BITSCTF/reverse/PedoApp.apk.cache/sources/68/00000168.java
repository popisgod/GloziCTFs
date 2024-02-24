package p020i0;

import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0245e;
import p034p0.InterfaceC0615p;

/* renamed from: i0.g */
/* loaded from: classes.dex */
public interface InterfaceC0249g {

    /* renamed from: i0.g$a */
    /* loaded from: classes.dex */
    public static final class C0250a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i0.g$a$a */
        /* loaded from: classes.dex */
        public static final class C0251a extends AbstractC0466j implements InterfaceC0615p<InterfaceC0249g, InterfaceC0252b, InterfaceC0249g> {

            /* renamed from: d */
            public static final C0251a f300d = new C0251a();

            C0251a() {
                super(2);
            }

            @Override // p034p0.InterfaceC0615p
            /* renamed from: a */
            public final InterfaceC0249g invoke(InterfaceC0249g acc, InterfaceC0252b element) {
                C0242c c0242c;
                C0465i.m1048e(acc, "acc");
                C0465i.m1048e(element, "element");
                InterfaceC0249g minusKey = acc.minusKey(element.getKey());
                C0255h c0255h = C0255h.f301d;
                if (minusKey == c0255h) {
                    return element;
                }
                InterfaceC0245e.C0247b c0247b = InterfaceC0245e.f298a;
                InterfaceC0245e interfaceC0245e = (InterfaceC0245e) minusKey.get(c0247b);
                if (interfaceC0245e == null) {
                    c0242c = new C0242c(minusKey, element);
                } else {
                    InterfaceC0249g minusKey2 = minusKey.minusKey(c0247b);
                    if (minusKey2 == c0255h) {
                        return new C0242c(element, interfaceC0245e);
                    }
                    c0242c = new C0242c(new C0242c(minusKey2, element), interfaceC0245e);
                }
                return c0242c;
            }
        }

        /* renamed from: a */
        public static InterfaceC0249g m1822a(InterfaceC0249g interfaceC0249g, InterfaceC0249g context) {
            C0465i.m1048e(context, "context");
            return context == C0255h.f301d ? interfaceC0249g : (InterfaceC0249g) context.fold(interfaceC0249g, C0251a.f300d);
        }
    }

    /* renamed from: i0.g$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0252b extends InterfaceC0249g {

        /* renamed from: i0.g$b$a */
        /* loaded from: classes.dex */
        public static final class C0253a {
            /* renamed from: a */
            public static <R> R m1820a(InterfaceC0252b interfaceC0252b, R r, InterfaceC0615p<? super R, ? super InterfaceC0252b, ? extends R> operation) {
                C0465i.m1048e(operation, "operation");
                return operation.invoke(r, interfaceC0252b);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: b */
            public static <E extends InterfaceC0252b> E m1819b(InterfaceC0252b interfaceC0252b, InterfaceC0254c<E> key) {
                C0465i.m1048e(key, "key");
                if (C0465i.m1052a(interfaceC0252b.getKey(), key)) {
                    C0465i.m1050c(interfaceC0252b, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return interfaceC0252b;
                }
                return null;
            }

            /* renamed from: c */
            public static InterfaceC0249g m1818c(InterfaceC0252b interfaceC0252b, InterfaceC0254c<?> key) {
                C0465i.m1048e(key, "key");
                return C0465i.m1052a(interfaceC0252b.getKey(), key) ? C0255h.f301d : interfaceC0252b;
            }

            /* renamed from: d */
            public static InterfaceC0249g m1817d(InterfaceC0252b interfaceC0252b, InterfaceC0249g context) {
                C0465i.m1048e(context, "context");
                return C0250a.m1822a(interfaceC0252b, context);
            }
        }

        @Override // p020i0.InterfaceC0249g
        <E extends InterfaceC0252b> E get(InterfaceC0254c<E> interfaceC0254c);

        InterfaceC0254c<?> getKey();
    }

    /* renamed from: i0.g$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0254c<E extends InterfaceC0252b> {
    }

    <R> R fold(R r, InterfaceC0615p<? super R, ? super InterfaceC0252b, ? extends R> interfaceC0615p);

    <E extends InterfaceC0252b> E get(InterfaceC0254c<E> interfaceC0254c);

    InterfaceC0249g minusKey(InterfaceC0254c<?> interfaceC0254c);

    InterfaceC0249g plus(InterfaceC0249g interfaceC0249g);
}