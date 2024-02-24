package p048w0;

import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0461e;
import kotlinx.coroutines.internal.C0487g;
import p020i0.AbstractC0240a;
import p020i0.AbstractC0241b;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0245e;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0611l;

/* renamed from: w0.f0 */
/* loaded from: classes.dex */
public abstract class AbstractC0722f0 extends AbstractC0240a implements InterfaceC0245e {

    /* renamed from: d */
    public static final C0723a f1319d = new C0723a(null);

    /* renamed from: w0.f0$a */
    /* loaded from: classes.dex */
    public static final class C0723a extends AbstractC0241b<InterfaceC0245e, AbstractC0722f0> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: w0.f0$a$a */
        /* loaded from: classes.dex */
        public static final class C0724a extends AbstractC0466j implements InterfaceC0611l<InterfaceC0249g.InterfaceC0252b, AbstractC0722f0> {

            /* renamed from: d */
            public static final C0724a f1320d = new C0724a();

            C0724a() {
                super(1);
            }

            @Override // p034p0.InterfaceC0611l
            /* renamed from: a */
            public final AbstractC0722f0 invoke(InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
                if (interfaceC0252b instanceof AbstractC0722f0) {
                    return (AbstractC0722f0) interfaceC0252b;
                }
                return null;
            }
        }

        private C0723a() {
            super(InterfaceC0245e.f298a, C0724a.f1320d);
        }

        public /* synthetic */ C0723a(C0461e c0461e) {
            this();
        }
    }

    public AbstractC0722f0() {
        super(InterfaceC0245e.f298a);
    }

    @Override // p020i0.InterfaceC0245e
    /* renamed from: f */
    public final void mo471f(InterfaceC0244d<?> interfaceC0244d) {
        ((C0487g) interfaceC0244d).m973n();
    }

    @Override // p020i0.AbstractC0240a, p020i0.InterfaceC0249g.InterfaceC0252b, p020i0.InterfaceC0249g
    public <E extends InterfaceC0249g.InterfaceC0252b> E get(InterfaceC0249g.InterfaceC0254c<E> interfaceC0254c) {
        return (E) InterfaceC0245e.C0246a.m1825a(this, interfaceC0254c);
    }

    @Override // p020i0.InterfaceC0245e
    /* renamed from: i */
    public final <T> InterfaceC0244d<T> mo470i(InterfaceC0244d<? super T> interfaceC0244d) {
        return new C0487g(this, interfaceC0244d);
    }

    @Override // p020i0.AbstractC0240a, p020i0.InterfaceC0249g
    public InterfaceC0249g minusKey(InterfaceC0249g.InterfaceC0254c<?> interfaceC0254c) {
        return InterfaceC0245e.C0246a.m1824b(this, interfaceC0254c);
    }

    /* renamed from: o */
    public abstract void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable);

    /* renamed from: p */
    public boolean mo241p(InterfaceC0249g interfaceC0249g) {
        return true;
    }

    public String toString() {
        return C0771q0.m392a(this) + '@' + C0771q0.m391b(this);
    }
}