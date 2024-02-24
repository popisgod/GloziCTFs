package p020i0;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* renamed from: i0.c */
/* loaded from: classes.dex */
public final class C0242c implements InterfaceC0249g, Serializable {

    /* renamed from: d */
    private final InterfaceC0249g f295d;

    /* renamed from: e */
    private final InterfaceC0249g.InterfaceC0252b f296e;

    /* renamed from: i0.c$a */
    /* loaded from: classes.dex */
    static final class C0243a extends AbstractC0466j implements InterfaceC0615p<String, InterfaceC0249g.InterfaceC0252b, String> {

        /* renamed from: d */
        public static final C0243a f297d = new C0243a();

        C0243a() {
            super(2);
        }

        @Override // p034p0.InterfaceC0615p
        /* renamed from: a */
        public final String invoke(String acc, InterfaceC0249g.InterfaceC0252b element) {
            C0465i.m1048e(acc, "acc");
            C0465i.m1048e(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public C0242c(InterfaceC0249g left, InterfaceC0249g.InterfaceC0252b element) {
        C0465i.m1048e(left, "left");
        C0465i.m1048e(element, "element");
        this.f295d = left;
        this.f296e = element;
    }

    /* renamed from: g */
    private final boolean m1829g(InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
        return C0465i.m1052a(get(interfaceC0252b.getKey()), interfaceC0252b);
    }

    /* renamed from: k */
    private final boolean m1828k(C0242c c0242c) {
        while (m1829g(c0242c.f296e)) {
            InterfaceC0249g interfaceC0249g = c0242c.f295d;
            if (!(interfaceC0249g instanceof C0242c)) {
                C0465i.m1050c(interfaceC0249g, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return m1829g((InterfaceC0249g.InterfaceC0252b) interfaceC0249g);
            }
            c0242c = (C0242c) interfaceC0249g;
        }
        return false;
    }

    /* renamed from: o */
    private final int m1827o() {
        int i = 2;
        C0242c c0242c = this;
        while (true) {
            InterfaceC0249g interfaceC0249g = c0242c.f295d;
            c0242c = interfaceC0249g instanceof C0242c ? (C0242c) interfaceC0249g : null;
            if (c0242c == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C0242c) {
                C0242c c0242c = (C0242c) obj;
                if (c0242c.m1827o() != m1827o() || !c0242c.m1828k(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // p020i0.InterfaceC0249g
    public <R> R fold(R r, InterfaceC0615p<? super R, ? super InterfaceC0249g.InterfaceC0252b, ? extends R> operation) {
        C0465i.m1048e(operation, "operation");
        return operation.invoke((Object) this.f295d.fold(r, operation), this.f296e);
    }

    @Override // p020i0.InterfaceC0249g
    public <E extends InterfaceC0249g.InterfaceC0252b> E get(InterfaceC0249g.InterfaceC0254c<E> key) {
        C0465i.m1048e(key, "key");
        C0242c c0242c = this;
        while (true) {
            E e = (E) c0242c.f296e.get(key);
            if (e != null) {
                return e;
            }
            InterfaceC0249g interfaceC0249g = c0242c.f295d;
            if (!(interfaceC0249g instanceof C0242c)) {
                return (E) interfaceC0249g.get(key);
            }
            c0242c = (C0242c) interfaceC0249g;
        }
    }

    public int hashCode() {
        return this.f295d.hashCode() + this.f296e.hashCode();
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g minusKey(InterfaceC0249g.InterfaceC0254c<?> key) {
        C0465i.m1048e(key, "key");
        if (this.f296e.get(key) != null) {
            return this.f295d;
        }
        InterfaceC0249g minusKey = this.f295d.minusKey(key);
        return minusKey == this.f295d ? this : minusKey == C0255h.f301d ? this.f296e : new C0242c(minusKey, this.f296e);
    }

    @Override // p020i0.InterfaceC0249g
    public InterfaceC0249g plus(InterfaceC0249g interfaceC0249g) {
        return InterfaceC0249g.C0250a.m1822a(this, interfaceC0249g);
    }

    public String toString() {
        return '[' + ((String) fold("", C0243a.f297d)) + ']';
    }
}