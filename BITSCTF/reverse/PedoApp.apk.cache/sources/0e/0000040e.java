package p054z0;

import kotlin.coroutines.jvm.internal.AbstractC0446d;
import kotlin.coroutines.jvm.internal.InterfaceC0448f;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;

/* renamed from: z0.a */
/* loaded from: classes.dex */
public abstract class AbstractC0907a<T> implements InterfaceC0909b<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    @InterfaceC0448f(m1071c = "kotlinx.coroutines.flow.AbstractFlow", m1070f = "Flow.kt", m1069l = {212}, m1068m = "collect")
    /* renamed from: z0.a$a */
    /* loaded from: classes.dex */
    public static final class C0908a extends AbstractC0446d {

        /* renamed from: d */
        Object f1662d;

        /* renamed from: e */
        /* synthetic */ Object f1663e;

        /* renamed from: f */
        final /* synthetic */ AbstractC0907a<T> f1664f;

        /* renamed from: g */
        int f1665g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0908a(AbstractC0907a<T> abstractC0907a, InterfaceC0244d<? super C0908a> interfaceC0244d) {
            super(interfaceC0244d);
            this.f1664f = abstractC0907a;
        }

        @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
        public final Object invokeSuspend(Object obj) {
            this.f1663e = obj;
            this.f1665g |= Integer.MIN_VALUE;
            return this.f1664f.mo3a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    @Override // p054z0.InterfaceC0909b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo3a(p054z0.InterfaceC0910c<? super T> r6, p020i0.InterfaceC0244d<? super p014f0.C0169q> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof p054z0.AbstractC0907a.C0908a
            if (r0 == 0) goto L13
            r0 = r7
            z0.a$a r0 = (p054z0.AbstractC0907a.C0908a) r0
            int r1 = r0.f1665g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1665g = r1
            goto L18
        L13:
            z0.a$a r0 = new z0.a$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f1663e
            java.lang.Object r1 = p022j0.C0433b.m1080c()
            int r2 = r0.f1665g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f1662d
            a1.c r6 = (p002a1.C0052c) r6
            p014f0.C0164l.m2005b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            p014f0.C0164l.m2005b(r7)
            a1.c r7 = new a1.c
            i0.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f1662d = r7     // Catch: java.lang.Throwable -> L55
            r0.f1665g = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.mo0b(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            f0.q r6 = p014f0.C0169q.f235a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p054z0.AbstractC0907a.mo3a(z0.c, i0.d):java.lang.Object");
    }

    /* renamed from: b */
    public abstract Object mo0b(InterfaceC0910c<? super T> interfaceC0910c, InterfaceC0244d<? super C0169q> interfaceC0244d);
}