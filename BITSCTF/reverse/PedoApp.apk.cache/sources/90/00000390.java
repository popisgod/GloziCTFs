package p048w0;

import java.util.concurrent.CancellationException;
import p020i0.InterfaceC0249g;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: w0.t1 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0781t1 {
    /* renamed from: a */
    public static final InterfaceC0791w m369a(InterfaceC0764o1 interfaceC0764o1) {
        return new C0775r1(interfaceC0764o1);
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC0791w m368b(InterfaceC0764o1 interfaceC0764o1, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0764o1 = null;
        }
        return C0778s1.m380a(interfaceC0764o1);
    }

    /* renamed from: c */
    public static final void m367c(InterfaceC0249g interfaceC0249g, CancellationException cancellationException) {
        InterfaceC0764o1 interfaceC0764o1 = (InterfaceC0764o1) interfaceC0249g.get(InterfaceC0764o1.f1356c);
        if (interfaceC0764o1 == null) {
            return;
        }
        interfaceC0764o1.mo320b(cancellationException);
    }

    /* renamed from: d */
    public static final void m366d(InterfaceC0249g interfaceC0249g) {
        InterfaceC0764o1 interfaceC0764o1 = (InterfaceC0764o1) interfaceC0249g.get(InterfaceC0764o1.f1356c);
        if (interfaceC0764o1 == null) {
            return;
        }
        C0778s1.m376e(interfaceC0764o1);
    }

    /* renamed from: e */
    public static final void m365e(InterfaceC0764o1 interfaceC0764o1) {
        if (!interfaceC0764o1.mo322a()) {
            throw interfaceC0764o1.mo307l();
        }
    }
}