package p048w0;

import java.util.concurrent.CancellationException;
import p014f0.C0169q;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0611l;
import p034p0.InterfaceC0615p;

/* renamed from: w0.o1 */
/* loaded from: classes.dex */
public interface InterfaceC0764o1 extends InterfaceC0249g.InterfaceC0252b {

    /* renamed from: c */
    public static final C0766b f1356c = C0766b.f1357d;

    /* renamed from: w0.o1$a */
    /* loaded from: classes.dex */
    public static final class C0765a {
        /* renamed from: a */
        public static /* synthetic */ void m404a(InterfaceC0764o1 interfaceC0764o1, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            interfaceC0764o1.mo320b(cancellationException);
        }

        /* renamed from: b */
        public static <R> R m403b(InterfaceC0764o1 interfaceC0764o1, R r, InterfaceC0615p<? super R, ? super InterfaceC0249g.InterfaceC0252b, ? extends R> interfaceC0615p) {
            return (R) InterfaceC0249g.InterfaceC0252b.C0253a.m1820a(interfaceC0764o1, r, interfaceC0615p);
        }

        /* renamed from: c */
        public static <E extends InterfaceC0249g.InterfaceC0252b> E m402c(InterfaceC0764o1 interfaceC0764o1, InterfaceC0249g.InterfaceC0254c<E> interfaceC0254c) {
            return (E) InterfaceC0249g.InterfaceC0252b.C0253a.m1819b(interfaceC0764o1, interfaceC0254c);
        }

        /* renamed from: d */
        public static /* synthetic */ InterfaceC0795x0 m401d(InterfaceC0764o1 interfaceC0764o1, boolean z, boolean z2, InterfaceC0611l interfaceC0611l, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return interfaceC0764o1.mo303n(z, z2, interfaceC0611l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        /* renamed from: e */
        public static InterfaceC0249g m400e(InterfaceC0764o1 interfaceC0764o1, InterfaceC0249g.InterfaceC0254c<?> interfaceC0254c) {
            return InterfaceC0249g.InterfaceC0252b.C0253a.m1818c(interfaceC0764o1, interfaceC0254c);
        }

        /* renamed from: f */
        public static InterfaceC0249g m399f(InterfaceC0764o1 interfaceC0764o1, InterfaceC0249g interfaceC0249g) {
            return InterfaceC0249g.InterfaceC0252b.C0253a.m1817d(interfaceC0764o1, interfaceC0249g);
        }
    }

    /* renamed from: w0.o1$b */
    /* loaded from: classes.dex */
    public static final class C0766b implements InterfaceC0249g.InterfaceC0254c<InterfaceC0764o1> {

        /* renamed from: d */
        static final /* synthetic */ C0766b f1357d = new C0766b();

        private C0766b() {
        }
    }

    /* renamed from: a */
    boolean mo322a();

    /* renamed from: b */
    void mo320b(CancellationException cancellationException);

    /* renamed from: h */
    InterfaceC0770q mo313h(InterfaceC0776s interfaceC0776s);

    /* renamed from: l */
    CancellationException mo307l();

    /* renamed from: m */
    boolean mo305m();

    /* renamed from: n */
    InterfaceC0795x0 mo303n(boolean z, boolean z2, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l);
}