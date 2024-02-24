package p048w0;

import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import kotlinx.coroutines.scheduling.C0526b;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0245e;
import p020i0.InterfaceC0249g;

/* renamed from: w0.e0 */
/* loaded from: classes.dex */
public final class C0718e0 {

    /* renamed from: a */
    private static final boolean f1317a;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r0.equals("on") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.C0473a0.m1012d(r0)
            if (r0 == 0) goto L53
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2a
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L21
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L33
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            r0 = 0
            goto L54
        L21:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L2a:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L53:
            r0 = 1
        L54:
            p048w0.C0718e0.f1317a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p048w0.C0718e0.<clinit>():void");
    }

    /* renamed from: a */
    public static final AbstractC0722f0 m477a() {
        return f1317a ? C0526b.f1085k : C0785v.f1373f;
    }

    /* renamed from: b */
    public static final String m476b(InterfaceC0249g interfaceC0249g) {
        C0742j0 c0742j0;
        String m445o;
        if (C0768p0.m396c() && (c0742j0 = (C0742j0) interfaceC0249g.get(C0742j0.f1332e)) != null) {
            C0749k0 c0749k0 = (C0749k0) interfaceC0249g.get(C0749k0.f1336e);
            String str = "coroutine";
            if (c0749k0 != null && (m445o = c0749k0.m445o()) != null) {
                str = m445o;
            }
            return str + '#' + c0742j0.m449o();
        }
        return null;
    }

    /* renamed from: c */
    public static final InterfaceC0249g m475c(InterfaceC0753l0 interfaceC0753l0, InterfaceC0249g interfaceC0249g) {
        InterfaceC0249g plus = interfaceC0753l0.mo411s().plus(interfaceC0249g);
        InterfaceC0249g plus2 = C0768p0.m396c() ? plus.plus(new C0742j0(C0768p0.m397b().incrementAndGet())) : plus;
        return (plus == C0792w0.m276a() || plus.get(InterfaceC0245e.f298a) != null) ? plus2 : plus2.plus(C0792w0.m276a());
    }

    /* renamed from: d */
    public static final C0736h2<?> m474d(InterfaceC0447e interfaceC0447e) {
        while (!(interfaceC0447e instanceof C0777s0) && (interfaceC0447e = interfaceC0447e.getCallerFrame()) != null) {
            if (interfaceC0447e instanceof C0736h2) {
                return (C0736h2) interfaceC0447e;
            }
        }
        return null;
    }

    /* renamed from: e */
    public static final C0736h2<?> m473e(InterfaceC0244d<?> interfaceC0244d, InterfaceC0249g interfaceC0249g, Object obj) {
        if (interfaceC0244d instanceof InterfaceC0447e) {
            if (interfaceC0249g.get(C0740i2.f1331d) != null) {
                C0736h2<?> m474d = m474d((InterfaceC0447e) interfaceC0244d);
                if (m474d != null) {
                    m474d.m453z0(interfaceC0249g, obj);
                }
                return m474d;
            }
            return null;
        }
        return null;
    }
}