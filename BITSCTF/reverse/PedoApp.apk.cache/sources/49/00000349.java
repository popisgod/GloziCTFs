package p048w0;

import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import kotlinx.coroutines.internal.C0519y;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p034p0.InterfaceC0611l;

/* renamed from: w0.c0 */
/* loaded from: classes.dex */
public final class C0710c0 {
    /* renamed from: a */
    public static final <T> Object m484a(Object obj, InterfaceC0244d<? super T> interfaceC0244d) {
        if (obj instanceof C0797y) {
            C0161k.C0162a c0162a = C0161k.f229d;
            Throwable th = ((C0797y) obj).f1404a;
            if (C0768p0.m395d() && (interfaceC0244d instanceof InterfaceC0447e)) {
                th = C0519y.m881j(th, (InterfaceC0447e) interfaceC0244d);
            }
            obj = C0164l.m2006a(th);
        } else {
            C0161k.C0162a c0162a2 = C0161k.f229d;
        }
        return C0161k.m2010a(obj);
    }

    /* renamed from: b */
    public static final <T> Object m483b(Object obj, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        Throwable m2009b = C0161k.m2009b(obj);
        return m2009b == null ? interfaceC0611l != null ? new C0800z(obj, interfaceC0611l) : obj : new C0797y(m2009b, false, 2, null);
    }

    /* renamed from: c */
    public static final <T> Object m482c(Object obj, InterfaceC0747k<?> interfaceC0747k) {
        Throwable m2009b = C0161k.m2009b(obj);
        if (m2009b != null) {
            if (C0768p0.m395d() && (interfaceC0747k instanceof InterfaceC0447e)) {
                m2009b = C0519y.m881j(m2009b, (InterfaceC0447e) interfaceC0747k);
            }
            obj = new C0797y(m2009b, false, 2, null);
        }
        return obj;
    }

    /* renamed from: d */
    public static /* synthetic */ Object m481d(Object obj, InterfaceC0611l interfaceC0611l, int i, Object obj2) {
        if ((i & 1) != 0) {
            interfaceC0611l = null;
        }
        return m483b(obj, interfaceC0611l);
    }
}