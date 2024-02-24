package p022j0;

import kotlin.coroutines.jvm.internal.AbstractC0443a;
import kotlin.coroutines.jvm.internal.AbstractC0446d;
import kotlin.coroutines.jvm.internal.AbstractC0453j;
import kotlin.coroutines.jvm.internal.C0450h;
import kotlin.jvm.internal.C0465i;
import kotlin.jvm.internal.C0470n;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.C0255h;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0615p;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j0.c */
/* loaded from: classes.dex */
public class C0434c {

    /* renamed from: j0.c$a */
    /* loaded from: classes.dex */
    public static final class C0435a extends AbstractC0453j {

        /* renamed from: d */
        private int f956d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC0615p f957e;

        /* renamed from: f */
        final /* synthetic */ Object f958f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0435a(InterfaceC0244d interfaceC0244d, InterfaceC0615p interfaceC0615p, Object obj) {
            super(interfaceC0244d);
            this.f957e = interfaceC0615p;
            this.f958f = obj;
            C0465i.m1050c(interfaceC0244d, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
        protected Object invokeSuspend(Object obj) {
            int i = this.f956d;
            if (i == 0) {
                this.f956d = 1;
                C0164l.m2005b(obj);
                C0465i.m1050c(this.f957e, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC0615p) C0470n.m1026a(this.f957e, 2)).invoke(this.f958f, this);
            } else if (i == 1) {
                this.f956d = 2;
                C0164l.m2005b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* renamed from: j0.c$b */
    /* loaded from: classes.dex */
    public static final class C0436b extends AbstractC0446d {

        /* renamed from: d */
        private int f959d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC0615p f960e;

        /* renamed from: f */
        final /* synthetic */ Object f961f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0436b(InterfaceC0244d interfaceC0244d, InterfaceC0249g interfaceC0249g, InterfaceC0615p interfaceC0615p, Object obj) {
            super(interfaceC0244d, interfaceC0249g);
            this.f960e = interfaceC0615p;
            this.f961f = obj;
            C0465i.m1050c(interfaceC0244d, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
        protected Object invokeSuspend(Object obj) {
            int i = this.f959d;
            if (i == 0) {
                this.f959d = 1;
                C0164l.m2005b(obj);
                C0465i.m1050c(this.f960e, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC0615p) C0470n.m1026a(this.f960e, 2)).invoke(this.f961f, this);
            } else if (i == 1) {
                this.f959d = 2;
                C0164l.m2005b(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* renamed from: a */
    public static <R, T> InterfaceC0244d<C0169q> m1079a(InterfaceC0615p<? super R, ? super InterfaceC0244d<? super T>, ? extends Object> interfaceC0615p, R r, InterfaceC0244d<? super T> completion) {
        C0465i.m1048e(interfaceC0615p, "<this>");
        C0465i.m1048e(completion, "completion");
        InterfaceC0244d<?> m1062a = C0450h.m1062a(completion);
        if (interfaceC0615p instanceof AbstractC0443a) {
            return ((AbstractC0443a) interfaceC0615p).create(r, m1062a);
        }
        InterfaceC0249g context = m1062a.getContext();
        return context == C0255h.f301d ? new C0435a(m1062a, interfaceC0615p, r) : new C0436b(m1062a, context, interfaceC0615p, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static <T> InterfaceC0244d<T> m1078b(InterfaceC0244d<? super T> interfaceC0244d) {
        InterfaceC0244d<T> interfaceC0244d2;
        C0465i.m1048e(interfaceC0244d, "<this>");
        AbstractC0446d abstractC0446d = interfaceC0244d instanceof AbstractC0446d ? (AbstractC0446d) interfaceC0244d : null;
        return (abstractC0446d == null || (interfaceC0244d2 = (InterfaceC0244d<T>) abstractC0446d.intercepted()) == null) ? interfaceC0244d : interfaceC0244d2;
    }
}