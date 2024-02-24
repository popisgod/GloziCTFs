package p020i0;

import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;

/* renamed from: i0.e */
/* loaded from: classes.dex */
public interface InterfaceC0245e extends InterfaceC0249g.InterfaceC0252b {

    /* renamed from: a */
    public static final C0247b f298a = C0247b.f299d;

    /* renamed from: i0.e$a */
    /* loaded from: classes.dex */
    public static final class C0246a {
        /* renamed from: a */
        public static <E extends InterfaceC0249g.InterfaceC0252b> E m1825a(InterfaceC0245e interfaceC0245e, InterfaceC0249g.InterfaceC0254c<E> key) {
            C0465i.m1048e(key, "key");
            if (!(key instanceof AbstractC0241b)) {
                if (InterfaceC0245e.f298a == key) {
                    C0465i.m1050c(interfaceC0245e, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                    return interfaceC0245e;
                }
                return null;
            }
            AbstractC0241b abstractC0241b = (AbstractC0241b) key;
            if (abstractC0241b.m1831a(interfaceC0245e.getKey())) {
                E e = (E) abstractC0241b.m1830b(interfaceC0245e);
                if (e instanceof InterfaceC0249g.InterfaceC0252b) {
                    return e;
                }
                return null;
            }
            return null;
        }

        /* renamed from: b */
        public static InterfaceC0249g m1824b(InterfaceC0245e interfaceC0245e, InterfaceC0249g.InterfaceC0254c<?> key) {
            C0465i.m1048e(key, "key");
            if (!(key instanceof AbstractC0241b)) {
                return InterfaceC0245e.f298a == key ? C0255h.f301d : interfaceC0245e;
            }
            AbstractC0241b abstractC0241b = (AbstractC0241b) key;
            return (!abstractC0241b.m1831a(interfaceC0245e.getKey()) || abstractC0241b.m1830b(interfaceC0245e) == null) ? interfaceC0245e : C0255h.f301d;
        }
    }

    /* renamed from: i0.e$b */
    /* loaded from: classes.dex */
    public static final class C0247b implements InterfaceC0249g.InterfaceC0254c<InterfaceC0245e> {

        /* renamed from: d */
        static final /* synthetic */ C0247b f299d = new C0247b();

        private C0247b() {
        }
    }

    /* renamed from: f */
    void mo471f(InterfaceC0244d<?> interfaceC0244d);

    /* renamed from: i */
    <T> InterfaceC0244d<T> mo470i(InterfaceC0244d<? super T> interfaceC0244d);
}