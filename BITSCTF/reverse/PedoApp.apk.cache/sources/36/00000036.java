package p002a1;

import kotlin.jvm.internal.C0464h;
import kotlin.jvm.internal.C0470n;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p034p0.InterfaceC0616q;
import p054z0.InterfaceC0910c;

/* renamed from: a1.d */
/* loaded from: classes.dex */
public final class C0054d {

    /* renamed from: a */
    private static final InterfaceC0616q<InterfaceC0910c<Object>, Object, InterfaceC0244d<? super C0169q>, Object> f68a = (InterfaceC0616q) C0470n.m1026a(C0055a.f69d, 3);

    /* renamed from: a1.d$a */
    /* loaded from: classes.dex */
    /* synthetic */ class C0055a extends C0464h implements InterfaceC0616q {

        /* renamed from: d */
        public static final C0055a f69d = new C0055a();

        C0055a() {
            super(3, InterfaceC0910c.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p034p0.InterfaceC0616q
        /* renamed from: b */
        public final Object mo700f(InterfaceC0910c<Object> interfaceC0910c, Object obj, InterfaceC0244d<? super C0169q> interfaceC0244d) {
            return interfaceC0910c.emit(obj, interfaceC0244d);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ InterfaceC0616q m2235a() {
        return f68a;
    }
}