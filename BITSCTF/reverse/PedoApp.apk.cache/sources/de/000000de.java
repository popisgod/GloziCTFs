package p006b1;

import kotlin.coroutines.jvm.internal.C0450h;
import kotlin.jvm.internal.C0470n;
import kotlinx.coroutines.internal.C0479d0;
import p014f0.C0161k;
import p014f0.C0164l;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p022j0.C0437d;
import p034p0.InterfaceC0615p;

/* renamed from: b1.b */
/* loaded from: classes.dex */
public final class C0112b {
    /* renamed from: a */
    public static final <R, T> void m2090a(InterfaceC0615p<? super R, ? super InterfaceC0244d<? super T>, ? extends Object> interfaceC0615p, R r, InterfaceC0244d<? super T> interfaceC0244d) {
        Object m2006a;
        InterfaceC0249g context;
        Object m996c;
        Object m1077c;
        InterfaceC0244d m1062a = C0450h.m1062a(interfaceC0244d);
        try {
            context = interfaceC0244d.getContext();
            m996c = C0479d0.m996c(context, null);
        } catch (Throwable th) {
            C0161k.C0162a c0162a = C0161k.f229d;
            m2006a = C0164l.m2006a(th);
        }
        if (interfaceC0615p == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        m2006a = ((InterfaceC0615p) C0470n.m1026a(interfaceC0615p, 2)).invoke(r, m1062a);
        C0479d0.m998a(context, m996c);
        m1077c = C0437d.m1077c();
        if (m2006a != m1077c) {
            C0161k.C0162a c0162a2 = C0161k.f229d;
            m1062a.resumeWith(C0161k.m2010a(m2006a));
        }
    }
}