package p048w0;

import kotlinx.coroutines.internal.C0487g;
import p014f0.C0161k;
import p014f0.C0164l;
import p020i0.InterfaceC0244d;

/* renamed from: w0.q0 */
/* loaded from: classes.dex */
public final class C0771q0 {
    /* renamed from: a */
    public static final String m392a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    /* renamed from: b */
    public static final String m391b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* renamed from: c */
    public static final String m390c(InterfaceC0244d<?> interfaceC0244d) {
        String m2010a;
        if (interfaceC0244d instanceof C0487g) {
            return interfaceC0244d.toString();
        }
        try {
            C0161k.C0162a c0162a = C0161k.f229d;
            m2010a = C0161k.m2010a(interfaceC0244d + '@' + m391b(interfaceC0244d));
        } catch (Throwable th) {
            C0161k.C0162a c0162a2 = C0161k.f229d;
            m2010a = C0161k.m2010a(C0164l.m2006a(th));
        }
        if (C0161k.m2009b(m2010a) != null) {
            m2010a = ((Object) interfaceC0244d.getClass().getName()) + '@' + m391b(interfaceC0244d);
        }
        return (String) m2010a;
    }
}