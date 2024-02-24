package p006b1;

import kotlinx.coroutines.internal.C0489h;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p022j0.C0434c;
import p034p0.InterfaceC0611l;
import p034p0.InterfaceC0615p;

/* renamed from: b1.a */
/* loaded from: classes.dex */
public final class C0111a {
    /* renamed from: b */
    public static final void m2094b(InterfaceC0244d<?> interfaceC0244d, Throwable th) {
        C0161k.C0162a c0162a = C0161k.f229d;
        interfaceC0244d.resumeWith(C0161k.m2010a(C0164l.m2006a(th)));
        throw th;
    }

    /* renamed from: c */
    public static final void m2093c(InterfaceC0244d<? super C0169q> interfaceC0244d, InterfaceC0244d<?> interfaceC0244d2) {
        InterfaceC0244d m1078b;
        try {
            m1078b = C0434c.m1078b(interfaceC0244d);
            C0161k.C0162a c0162a = C0161k.f229d;
            C0489h.m967c(m1078b, C0161k.m2010a(C0169q.f235a), null, 2, null);
        } catch (Throwable th) {
            m2094b(interfaceC0244d2, th);
        }
    }

    /* renamed from: d */
    public static final <R, T> void m2092d(InterfaceC0615p<? super R, ? super InterfaceC0244d<? super T>, ? extends Object> interfaceC0615p, R r, InterfaceC0244d<? super T> interfaceC0244d, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        InterfaceC0244d m1079a;
        InterfaceC0244d m1078b;
        try {
            m1079a = C0434c.m1079a(interfaceC0615p, r, interfaceC0244d);
            m1078b = C0434c.m1078b(m1079a);
            C0161k.C0162a c0162a = C0161k.f229d;
            C0489h.m968b(m1078b, C0161k.m2010a(C0169q.f235a), interfaceC0611l);
        } catch (Throwable th) {
            m2094b(interfaceC0244d, th);
        }
    }

    /* renamed from: e */
    public static /* synthetic */ void m2091e(InterfaceC0615p interfaceC0615p, Object obj, InterfaceC0244d interfaceC0244d, InterfaceC0611l interfaceC0611l, int i, Object obj2) {
        if ((i & 4) != 0) {
            interfaceC0611l = null;
        }
        m2092d(interfaceC0615p, obj, interfaceC0244d, interfaceC0611l);
    }
}