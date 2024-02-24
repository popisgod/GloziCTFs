package p020i0;

import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;
import p020i0.InterfaceC0249g.InterfaceC0252b;
import p034p0.InterfaceC0611l;

/* renamed from: i0.b */
/* loaded from: classes.dex */
public abstract class AbstractC0241b<B extends InterfaceC0249g.InterfaceC0252b, E extends B> implements InterfaceC0249g.InterfaceC0254c<E> {

    /* renamed from: d */
    private final InterfaceC0611l<InterfaceC0249g.InterfaceC0252b, E> f293d;

    /* renamed from: e */
    private final InterfaceC0249g.InterfaceC0254c<?> f294e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [p0.l<i0.g$b, E extends B>, p0.l<? super i0.g$b, ? extends E extends B>, java.lang.Object] */
    public AbstractC0241b(InterfaceC0249g.InterfaceC0254c<B> baseKey, InterfaceC0611l<? super InterfaceC0249g.InterfaceC0252b, ? extends E> safeCast) {
        C0465i.m1048e(baseKey, "baseKey");
        C0465i.m1048e(safeCast, "safeCast");
        this.f293d = safeCast;
        this.f294e = baseKey instanceof AbstractC0241b ? (InterfaceC0249g.InterfaceC0254c<B>) ((AbstractC0241b) baseKey).f294e : baseKey;
    }

    /* renamed from: a */
    public final boolean m1831a(InterfaceC0249g.InterfaceC0254c<?> key) {
        C0465i.m1048e(key, "key");
        return key == this || this.f294e == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Li0/g$b;)TE; */
    /* renamed from: b */
    public final InterfaceC0249g.InterfaceC0252b m1830b(InterfaceC0249g.InterfaceC0252b element) {
        C0465i.m1048e(element, "element");
        return (InterfaceC0249g.InterfaceC0252b) this.f293d.invoke(element);
    }
}