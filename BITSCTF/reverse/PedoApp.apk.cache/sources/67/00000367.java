package p048w0;

import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: w0.i2 */
/* loaded from: classes.dex */
public final class C0740i2 implements InterfaceC0249g.InterfaceC0252b, InterfaceC0249g.InterfaceC0254c<C0740i2> {

    /* renamed from: d */
    public static final C0740i2 f1331d = new C0740i2();

    private C0740i2() {
    }

    @Override // p020i0.InterfaceC0249g
    public <R> R fold(R r, InterfaceC0615p<? super R, ? super InterfaceC0249g.InterfaceC0252b, ? extends R> interfaceC0615p) {
        return (R) InterfaceC0249g.InterfaceC0252b.C0253a.m1820a(this, r, interfaceC0615p);
    }

    @Override // p020i0.InterfaceC0249g.InterfaceC0252b, p020i0.InterfaceC0249g
    public <E extends InterfaceC0249g.InterfaceC0252b> E get(InterfaceC0249g.InterfaceC0254c<E> interfaceC0254c) {
        return (E) InterfaceC0249g.InterfaceC0252b.C0253a.m1819b(this, interfaceC0254c);
    }

    @Override // p020i0.InterfaceC0249g.InterfaceC0252b
    public InterfaceC0249g.InterfaceC0254c<?> getKey() {
        return this;
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g minusKey(InterfaceC0249g.InterfaceC0254c<?> interfaceC0254c) {
        return InterfaceC0249g.InterfaceC0252b.C0253a.m1818c(this, interfaceC0254c);
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g plus(InterfaceC0249g interfaceC0249g) {
        return InterfaceC0249g.InterfaceC0252b.C0253a.m1817d(this, interfaceC0249g);
    }
}