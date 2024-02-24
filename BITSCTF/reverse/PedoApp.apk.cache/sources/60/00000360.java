package p048w0;

import p014f0.C0169q;
import p020i0.C0255h;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: w0.h */
/* loaded from: classes.dex */
public final /* synthetic */ class C0733h {
    /* renamed from: a */
    public static final InterfaceC0764o1 m459a(InterfaceC0753l0 interfaceC0753l0, InterfaceC0249g interfaceC0249g, EnumC0759n0 enumC0759n0, InterfaceC0615p<? super InterfaceC0753l0, ? super InterfaceC0244d<? super C0169q>, ? extends Object> interfaceC0615p) {
        InterfaceC0249g m475c = C0718e0.m475c(interfaceC0753l0, interfaceC0249g);
        AbstractC0699a c0796x1 = enumC0759n0.m406c() ? new C0796x1(m475c, interfaceC0615p) : new C0716d2(m475c, true);
        c0796x1.m509w0(enumC0759n0, c0796x1, interfaceC0615p);
        return c0796x1;
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC0764o1 m458b(InterfaceC0753l0 interfaceC0753l0, InterfaceC0249g interfaceC0249g, EnumC0759n0 enumC0759n0, InterfaceC0615p interfaceC0615p, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0249g = C0255h.f301d;
        }
        if ((i & 2) != 0) {
            enumC0759n0 = EnumC0759n0.DEFAULT;
        }
        return C0729g.m464a(interfaceC0753l0, interfaceC0249g, enumC0759n0, interfaceC0615p);
    }
}