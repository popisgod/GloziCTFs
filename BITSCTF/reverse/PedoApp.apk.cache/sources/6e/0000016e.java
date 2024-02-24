package p020i0;

import java.io.Serializable;
import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* renamed from: i0.h */
/* loaded from: classes.dex */
public final class C0255h implements InterfaceC0249g, Serializable {

    /* renamed from: d */
    public static final C0255h f301d = new C0255h();

    private C0255h() {
    }

    @Override // p020i0.InterfaceC0249g
    public <R> R fold(R r, InterfaceC0615p<? super R, ? super InterfaceC0249g.InterfaceC0252b, ? extends R> operation) {
        C0465i.m1048e(operation, "operation");
        return r;
    }

    @Override // p020i0.InterfaceC0249g
    public <E extends InterfaceC0249g.InterfaceC0252b> E get(InterfaceC0249g.InterfaceC0254c<E> key) {
        C0465i.m1048e(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g minusKey(InterfaceC0249g.InterfaceC0254c<?> key) {
        C0465i.m1048e(key, "key");
        return this;
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g plus(InterfaceC0249g context) {
        C0465i.m1048e(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}