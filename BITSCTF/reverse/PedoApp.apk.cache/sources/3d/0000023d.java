package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0245e;
import p020i0.InterfaceC0249g;

/* renamed from: kotlin.coroutines.jvm.internal.d */
/* loaded from: classes.dex */
public abstract class AbstractC0446d extends AbstractC0443a {
    private final InterfaceC0249g _context;
    private transient InterfaceC0244d<Object> intercepted;

    public AbstractC0446d(InterfaceC0244d<Object> interfaceC0244d) {
        this(interfaceC0244d, interfaceC0244d != null ? interfaceC0244d.getContext() : null);
    }

    public AbstractC0446d(InterfaceC0244d<Object> interfaceC0244d, InterfaceC0249g interfaceC0249g) {
        super(interfaceC0244d);
        this._context = interfaceC0249g;
    }

    @Override // p020i0.InterfaceC0244d
    public InterfaceC0249g getContext() {
        InterfaceC0249g interfaceC0249g = this._context;
        C0465i.m1051b(interfaceC0249g);
        return interfaceC0249g;
    }

    public final InterfaceC0244d<Object> intercepted() {
        InterfaceC0244d<Object> interfaceC0244d = this.intercepted;
        if (interfaceC0244d == null) {
            InterfaceC0245e interfaceC0245e = (InterfaceC0245e) getContext().get(InterfaceC0245e.f298a);
            if (interfaceC0245e == null || (interfaceC0244d = interfaceC0245e.mo470i(this)) == null) {
                interfaceC0244d = this;
            }
            this.intercepted = interfaceC0244d;
        }
        return interfaceC0244d;
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
    public void releaseIntercepted() {
        InterfaceC0244d<?> interfaceC0244d = this.intercepted;
        if (interfaceC0244d != null && interfaceC0244d != this) {
            InterfaceC0249g.InterfaceC0252b interfaceC0252b = getContext().get(InterfaceC0245e.f298a);
            C0465i.m1051b(interfaceC0252b);
            ((InterfaceC0245e) interfaceC0252b).mo471f(interfaceC0244d);
        }
        this.intercepted = C0445c.f966d;
    }
}