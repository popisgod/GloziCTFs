package p048w0;

import kotlinx.coroutines.internal.C0479d0;
import kotlinx.coroutines.internal.C0487g;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;

/* renamed from: w0.u0 */
/* loaded from: classes.dex */
public final class C0783u0 {
    /* renamed from: a */
    public static final <T> void m364a(AbstractC0780t0<? super T> abstractC0780t0, int i) {
        if (C0768p0.m398a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        InterfaceC0244d<? super T> mo374b = abstractC0780t0.mo374b();
        boolean z = i == 4;
        if (z || !(mo374b instanceof C0487g) || m363b(i) != m363b(abstractC0780t0.f1370f)) {
            m361d(abstractC0780t0, mo374b, z);
            return;
        }
        AbstractC0722f0 abstractC0722f0 = ((C0487g) mo374b).f1006g;
        InterfaceC0249g context = mo374b.getContext();
        if (abstractC0722f0.mo241p(context)) {
            abstractC0722f0.mo242o(context, abstractC0780t0);
        } else {
            m360e(abstractC0780t0);
        }
    }

    /* renamed from: b */
    public static final boolean m363b(int i) {
        return i == 1 || i == 2;
    }

    /* renamed from: c */
    public static final boolean m362c(int i) {
        return i == 2;
    }

    /* renamed from: d */
    public static final <T> void m361d(AbstractC0780t0<? super T> abstractC0780t0, InterfaceC0244d<? super T> interfaceC0244d, boolean z) {
        Object mo372d;
        Object mo370f = abstractC0780t0.mo370f();
        Throwable mo373c = abstractC0780t0.mo373c(mo370f);
        if (mo373c != null) {
            C0161k.C0162a c0162a = C0161k.f229d;
            mo372d = C0164l.m2006a(mo373c);
        } else {
            C0161k.C0162a c0162a2 = C0161k.f229d;
            mo372d = abstractC0780t0.mo372d(mo370f);
        }
        Object m2010a = C0161k.m2010a(mo372d);
        if (!z) {
            interfaceC0244d.resumeWith(m2010a);
            return;
        }
        C0487g c0487g = (C0487g) interfaceC0244d;
        InterfaceC0244d<T> interfaceC0244d2 = c0487g.f1007h;
        Object obj = c0487g.f1009j;
        InterfaceC0249g context = interfaceC0244d2.getContext();
        Object m996c = C0479d0.m996c(context, obj);
        C0736h2<?> m473e = m996c != C0479d0.f995a ? C0718e0.m473e(interfaceC0244d2, context, m996c) : null;
        try {
            c0487g.f1007h.resumeWith(m2010a);
            C0169q c0169q = C0169q.f235a;
        } finally {
            if (m473e == null || m473e.m454y0()) {
                C0479d0.m998a(context, m996c);
            }
        }
    }

    /* renamed from: e */
    private static final void m360e(AbstractC0780t0<?> abstractC0780t0) {
        AbstractC0801z0 m467a = C0728f2.f1323a.m467a();
        if (m467a.m251w()) {
            m467a.m255s(abstractC0780t0);
            return;
        }
        m467a.m253u(true);
        try {
            m361d(abstractC0780t0, abstractC0780t0.mo374b(), true);
            do {
            } while (m467a.m249y());
        } finally {
            try {
            } finally {
            }
        }
    }
}