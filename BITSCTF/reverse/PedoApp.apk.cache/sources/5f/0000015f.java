package p020i0;

import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* renamed from: i0.a */
/* loaded from: classes.dex */
public abstract class AbstractC0240a implements InterfaceC0249g.InterfaceC0252b {
    private final InterfaceC0249g.InterfaceC0254c<?> key;

    public AbstractC0240a(InterfaceC0249g.InterfaceC0254c<?> key) {
        C0465i.m1048e(key, "key");
        this.key = key;
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
        return this.key;
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