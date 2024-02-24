package p020i0;

import kotlin.jvm.internal.C0465i;
import p014f0.C0161k;
import p014f0.C0169q;
import p022j0.C0434c;
import p034p0.InterfaceC0615p;

/* renamed from: i0.f */
/* loaded from: classes.dex */
public final class C0248f {
    /* renamed from: a */
    public static final <R, T> void m1823a(InterfaceC0615p<? super R, ? super InterfaceC0244d<? super T>, ? extends Object> interfaceC0615p, R r, InterfaceC0244d<? super T> completion) {
        InterfaceC0244d m1079a;
        InterfaceC0244d m1078b;
        C0465i.m1048e(interfaceC0615p, "<this>");
        C0465i.m1048e(completion, "completion");
        m1079a = C0434c.m1079a(interfaceC0615p, r, completion);
        m1078b = C0434c.m1078b(m1079a);
        C0161k.C0162a c0162a = C0161k.f229d;
        m1078b.resumeWith(C0161k.m2010a(C0169q.f235a));
    }
}