package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0611l;
import p048w0.AbstractC0801z0;
import p048w0.C0710c0;
import p048w0.C0718e0;
import p048w0.C0728f2;
import p048w0.C0736h2;
import p048w0.C0768p0;
import p048w0.InterfaceC0764o1;

/* renamed from: kotlinx.coroutines.internal.h */
/* loaded from: classes.dex */
public final class C0489h {

    /* renamed from: a */
    private static final C0520z f1014a = new C0520z("UNDEFINED");

    /* renamed from: b */
    public static final C0520z f1015b = new C0520z("REUSABLE_CLAIMED");

    /* renamed from: a */
    public static final /* synthetic */ C0520z m969a() {
        return f1014a;
    }

    /* renamed from: b */
    public static final <T> void m968b(InterfaceC0244d<? super T> interfaceC0244d, Object obj, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        boolean z;
        if (!(interfaceC0244d instanceof C0487g)) {
            interfaceC0244d.resumeWith(obj);
            return;
        }
        C0487g c0487g = (C0487g) interfaceC0244d;
        Object m483b = C0710c0.m483b(obj, interfaceC0611l);
        if (c0487g.f1006g.mo241p(c0487g.getContext())) {
            c0487g.f1008i = m483b;
            c0487g.f1370f = 1;
            c0487g.f1006g.mo242o(c0487g.getContext(), c0487g);
            return;
        }
        C0768p0.m398a();
        AbstractC0801z0 m467a = C0728f2.f1323a.m467a();
        if (m467a.m251w()) {
            c0487g.f1008i = m483b;
            c0487g.f1370f = 1;
            m467a.m255s(c0487g);
            return;
        }
        m467a.m253u(true);
        try {
            InterfaceC0764o1 interfaceC0764o1 = (InterfaceC0764o1) c0487g.getContext().get(InterfaceC0764o1.f1356c);
            if (interfaceC0764o1 == null || interfaceC0764o1.mo322a()) {
                z = false;
            } else {
                CancellationException mo307l = interfaceC0764o1.mo307l();
                c0487g.mo375a(m483b, mo307l);
                C0161k.C0162a c0162a = C0161k.f229d;
                c0487g.resumeWith(C0161k.m2010a(C0164l.m2006a(mo307l)));
                z = true;
            }
            if (!z) {
                InterfaceC0244d<T> interfaceC0244d2 = c0487g.f1007h;
                Object obj2 = c0487g.f1009j;
                InterfaceC0249g context = interfaceC0244d2.getContext();
                Object m996c = C0479d0.m996c(context, obj2);
                C0736h2<?> m473e = m996c != C0479d0.f995a ? C0718e0.m473e(interfaceC0244d2, context, m996c) : null;
                c0487g.f1007h.resumeWith(obj);
                C0169q c0169q = C0169q.f235a;
                if (m473e == null || m473e.m454y0()) {
                    C0479d0.m998a(context, m996c);
                }
            }
            do {
            } while (m467a.m249y());
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: c */
    public static /* synthetic */ void m967c(InterfaceC0244d interfaceC0244d, Object obj, InterfaceC0611l interfaceC0611l, int i, Object obj2) {
        if ((i & 2) != 0) {
            interfaceC0611l = null;
        }
        m968b(interfaceC0244d, obj, interfaceC0611l);
    }
}