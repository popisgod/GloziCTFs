package p048w0;

import p006b1.C0111a;
import p006b1.C0112b;
import p014f0.C0159i;
import p020i0.C0248f;
import p020i0.InterfaceC0244d;
import p034p0.InterfaceC0615p;

/* renamed from: w0.n0 */
/* loaded from: classes.dex */
public enum EnumC0759n0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* renamed from: w0.n0$a */
    /* loaded from: classes.dex */
    public /* synthetic */ class C0760a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1353a;

        static {
            int[] iArr = new int[EnumC0759n0.values().length];
            iArr[EnumC0759n0.DEFAULT.ordinal()] = 1;
            iArr[EnumC0759n0.ATOMIC.ordinal()] = 2;
            iArr[EnumC0759n0.UNDISPATCHED.ordinal()] = 3;
            iArr[EnumC0759n0.LAZY.ordinal()] = 4;
            f1353a = iArr;
        }
    }

    /* renamed from: b */
    public final <R, T> void m407b(InterfaceC0615p<? super R, ? super InterfaceC0244d<? super T>, ? extends Object> interfaceC0615p, R r, InterfaceC0244d<? super T> interfaceC0244d) {
        int i = C0760a.f1353a[ordinal()];
        if (i == 1) {
            C0111a.m2091e(interfaceC0615p, r, interfaceC0244d, null, 4, null);
        } else if (i == 2) {
            C0248f.m1823a(interfaceC0615p, r, interfaceC0244d);
        } else if (i == 3) {
            C0112b.m2090a(interfaceC0615p, r, interfaceC0244d);
        } else if (i != 4) {
            throw new C0159i();
        }
    }

    /* renamed from: c */
    public final boolean m406c() {
        return this == LAZY;
    }
}