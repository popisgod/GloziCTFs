package p002a1;

import kotlin.jvm.internal.AbstractC0466j;
import kotlinx.coroutines.internal.C0518x;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;
import p048w0.InterfaceC0764o1;

/* renamed from: a1.e */
/* loaded from: classes.dex */
public final class C0056e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a1.e$a */
    /* loaded from: classes.dex */
    public static final class C0057a extends AbstractC0466j implements InterfaceC0615p<Integer, InterfaceC0249g.InterfaceC0252b, Integer> {

        /* renamed from: d */
        final /* synthetic */ C0052c<?> f70d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0057a(C0052c<?> c0052c) {
            super(2);
            this.f70d = c0052c;
        }

        /* renamed from: a */
        public final Integer m2231a(int i, InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
            InterfaceC0249g.InterfaceC0254c<?> key = interfaceC0252b.getKey();
            InterfaceC0249g.InterfaceC0252b interfaceC0252b2 = this.f70d.f63e.get(key);
            if (key != InterfaceC0764o1.f1356c) {
                return Integer.valueOf(interfaceC0252b != interfaceC0252b2 ? Integer.MIN_VALUE : i + 1);
            }
            InterfaceC0764o1 interfaceC0764o1 = (InterfaceC0764o1) interfaceC0252b2;
            InterfaceC0764o1 m2232b = C0056e.m2232b((InterfaceC0764o1) interfaceC0252b, interfaceC0764o1);
            if (m2232b == interfaceC0764o1) {
                if (interfaceC0764o1 != null) {
                    i++;
                }
                return Integer.valueOf(i);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + m2232b + ", expected child of " + interfaceC0764o1 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // p034p0.InterfaceC0615p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
            return m2231a(num.intValue(), interfaceC0252b);
        }
    }

    /* renamed from: a */
    public static final void m2233a(C0052c<?> c0052c, InterfaceC0249g interfaceC0249g) {
        if (((Number) interfaceC0249g.fold(0, new C0057a(c0052c))).intValue() == c0052c.f64f) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + c0052c.f63e + ",\n\t\tbut emission happened in " + interfaceC0249g + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    /* renamed from: b */
    public static final InterfaceC0764o1 m2232b(InterfaceC0764o1 interfaceC0764o1, InterfaceC0764o1 interfaceC0764o12) {
        while (interfaceC0764o1 != null) {
            if (interfaceC0764o1 == interfaceC0764o12 || !(interfaceC0764o1 instanceof C0518x)) {
                return interfaceC0764o1;
            }
            interfaceC0764o1 = ((C0518x) interfaceC0764o1).m891x0();
        }
        return null;
    }
}