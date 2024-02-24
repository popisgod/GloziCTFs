package p002a1;

import kotlin.jvm.internal.C0461e;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* renamed from: a1.a */
/* loaded from: classes.dex */
public final class C0049a implements InterfaceC0249g.InterfaceC0252b {

    /* renamed from: f */
    public static final C0050a f57f = new C0050a(null);

    /* renamed from: d */
    public final Throwable f58d;

    /* renamed from: e */
    private final InterfaceC0249g.InterfaceC0254c<?> f59e = f57f;

    /* renamed from: a1.a$a */
    /* loaded from: classes.dex */
    public static final class C0050a implements InterfaceC0249g.InterfaceC0254c<C0049a> {
        private C0050a() {
        }

        public /* synthetic */ C0050a(C0461e c0461e) {
            this();
        }
    }

    public C0049a(Throwable th) {
        this.f58d = th;
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
        return this.f59e;
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