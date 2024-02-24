package p053z;

import p001a0.C0033k;
import p001a0.C0047s;
import p033p.C0579a;

/* renamed from: z.h */
/* loaded from: classes.dex */
public class C0857h {

    /* renamed from: a */
    public final C0033k f1487a;

    /* renamed from: b */
    private InterfaceC0859b f1488b;

    /* renamed from: c */
    private final C0033k.InterfaceC0037c f1489c;

    /* renamed from: z.h$a */
    /* loaded from: classes.dex */
    class C0858a implements C0033k.InterfaceC0037c {
        C0858a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo24a(p001a0.C0032j r7, p001a0.C0033k.InterfaceC0038d r8) {
            /*
                r6 = this;
                java.lang.String r0 = "error"
                z.h r1 = p053z.C0857h.this
                z.h$b r1 = p053z.C0857h.m141a(r1)
                if (r1 != 0) goto Lb
                return
            Lb:
                java.lang.String r1 = r7.f38a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Received '"
                r2.append(r3)
                r2.append(r1)
                java.lang.String r3 = "' message."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "MouseCursorChannel"
                p031o.C0576b.m737f(r3, r2)
                r2 = -1
                r3 = 0
                int r4 = r1.hashCode()     // Catch: java.lang.Exception -> L75
                r5 = -1307105544(0xffffffffb21726f8, float:-8.798217E-9)
                if (r4 == r5) goto L34
                goto L3d
            L34:
                java.lang.String r4 = "activateSystemCursor"
                boolean r1 = r1.equals(r4)     // Catch: java.lang.Exception -> L75
                if (r1 == 0) goto L3d
                r2 = 0
            L3d:
                if (r2 == 0) goto L40
                goto L8e
            L40:
                java.lang.Object r7 = r7.f39b     // Catch: java.lang.Exception -> L75
                java.util.HashMap r7 = (java.util.HashMap) r7     // Catch: java.lang.Exception -> L75
                java.lang.String r1 = "kind"
                java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L75
                z.h r1 = p053z.C0857h.this     // Catch: java.lang.Exception -> L5b
                z.h$b r1 = p053z.C0857h.m141a(r1)     // Catch: java.lang.Exception -> L5b
                r1.mo139a(r7)     // Catch: java.lang.Exception -> L5b
                java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L75
                r8.mo65b(r7)     // Catch: java.lang.Exception -> L75
                goto L8e
            L5b:
                r7 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L75
                r1.<init>()     // Catch: java.lang.Exception -> L75
                java.lang.String r2 = "Error when setting cursors: "
                r1.append(r2)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Exception -> L75
                r1.append(r7)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L75
                r8.mo66a(r0, r7, r3)     // Catch: java.lang.Exception -> L75
                goto L8e
            L75:
                r7 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unhandled error: "
                r1.append(r2)
                java.lang.String r7 = r7.getMessage()
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r8.mo66a(r0, r7, r3)
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p053z.C0857h.C0858a.mo24a(a0.j, a0.k$d):void");
        }
    }

    /* renamed from: z.h$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0859b {
        /* renamed from: a */
        void mo139a(String str);
    }

    public C0857h(C0579a c0579a) {
        C0858a c0858a = new C0858a();
        this.f1489c = c0858a;
        C0033k c0033k = new C0033k(c0579a, "flutter/mousecursor", C0047s.f53b);
        this.f1487a = c0033k;
        c0033k.m2269e(c0858a);
    }

    /* renamed from: b */
    public void m140b(InterfaceC0859b interfaceC0859b) {
        this.f1488b = interfaceC0859b;
    }
}