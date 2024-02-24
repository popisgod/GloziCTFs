package p002a1;

import kotlin.coroutines.jvm.internal.AbstractC0446d;
import kotlin.coroutines.jvm.internal.C0450h;
import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import kotlin.jvm.internal.AbstractC0466j;
import p014f0.C0161k;
import p014f0.C0169q;
import p020i0.C0255h;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p022j0.C0437d;
import p034p0.InterfaceC0615p;
import p046v0.C0682f;
import p048w0.C0778s1;
import p054z0.InterfaceC0910c;

/* renamed from: a1.c */
/* loaded from: classes.dex */
public final class C0052c<T> extends AbstractC0446d implements InterfaceC0910c<T> {

    /* renamed from: d */
    public final InterfaceC0910c<T> f62d;

    /* renamed from: e */
    public final InterfaceC0249g f63e;

    /* renamed from: f */
    public final int f64f;

    /* renamed from: g */
    private InterfaceC0249g f65g;

    /* renamed from: h */
    private InterfaceC0244d<? super C0169q> f66h;

    /* renamed from: a1.c$a */
    /* loaded from: classes.dex */
    static final class C0053a extends AbstractC0466j implements InterfaceC0615p<Integer, InterfaceC0249g.InterfaceC0252b, Integer> {

        /* renamed from: d */
        public static final C0053a f67d = new C0053a();

        C0053a() {
            super(2);
        }

        /* renamed from: a */
        public final Integer m2236a(int i, InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
            return Integer.valueOf(i + 1);
        }

        @Override // p034p0.InterfaceC0615p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
            return m2236a(num.intValue(), interfaceC0252b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0052c(InterfaceC0910c<? super T> interfaceC0910c, InterfaceC0249g interfaceC0249g) {
        super(C0051b.f60d, C0255h.f301d);
        this.f62d = interfaceC0910c;
        this.f63e = interfaceC0249g;
        this.f64f = ((Number) interfaceC0249g.fold(0, C0053a.f67d)).intValue();
    }

    /* renamed from: a */
    private final void m2239a(InterfaceC0249g interfaceC0249g, InterfaceC0249g interfaceC0249g2, T t) {
        if (interfaceC0249g2 instanceof C0049a) {
            m2237c((C0049a) interfaceC0249g2, t);
        }
        C0056e.m2233a(this, interfaceC0249g);
        this.f65g = interfaceC0249g;
    }

    /* renamed from: b */
    private final Object m2238b(InterfaceC0244d<? super C0169q> interfaceC0244d, T t) {
        InterfaceC0249g context = interfaceC0244d.getContext();
        C0778s1.m377d(context);
        InterfaceC0249g interfaceC0249g = this.f65g;
        if (interfaceC0249g != context) {
            m2239a(context, interfaceC0249g, t);
        }
        this.f66h = interfaceC0244d;
        return C0054d.m2235a().mo700f(this.f62d, t, this);
    }

    /* renamed from: c */
    private final void m2237c(C0049a c0049a, Object obj) {
        String m567e;
        m567e = C0682f.m567e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + c0049a.f58d + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(m567e.toString());
    }

    @Override // p054z0.InterfaceC0910c
    public Object emit(T t, InterfaceC0244d<? super C0169q> interfaceC0244d) {
        Object m1077c;
        Object m1077c2;
        try {
            Object m2238b = m2238b(interfaceC0244d, t);
            m1077c = C0437d.m1077c();
            if (m2238b == m1077c) {
                C0450h.m1060c(interfaceC0244d);
            }
            m1077c2 = C0437d.m1077c();
            return m2238b == m1077c2 ? m2238b : C0169q.f235a;
        } catch (Throwable th) {
            this.f65g = new C0049a(th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a, kotlin.coroutines.jvm.internal.InterfaceC0447e
    public InterfaceC0447e getCallerFrame() {
        InterfaceC0244d<? super C0169q> interfaceC0244d = this.f66h;
        if (interfaceC0244d instanceof InterfaceC0447e) {
            return (InterfaceC0447e) interfaceC0244d;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0446d, p020i0.InterfaceC0244d
    public InterfaceC0249g getContext() {
        InterfaceC0244d<? super C0169q> interfaceC0244d = this.f66h;
        InterfaceC0249g context = interfaceC0244d == null ? null : interfaceC0244d.getContext();
        return context == null ? C0255h.f301d : context;
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a, kotlin.coroutines.jvm.internal.InterfaceC0447e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
    public Object invokeSuspend(Object obj) {
        Object m1077c;
        Throwable m2009b = C0161k.m2009b(obj);
        if (m2009b != null) {
            this.f65g = new C0049a(m2009b);
        }
        InterfaceC0244d<? super C0169q> interfaceC0244d = this.f66h;
        if (interfaceC0244d != null) {
            interfaceC0244d.resumeWith(obj);
        }
        m1077c = C0437d.m1077c();
        return m1077c;
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0446d, kotlin.coroutines.jvm.internal.AbstractC0443a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}