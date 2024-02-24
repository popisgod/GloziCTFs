package p048w0;

import java.util.concurrent.atomic.AtomicLong;

/* renamed from: w0.p0 */
/* loaded from: classes.dex */
public final class C0768p0 {

    /* renamed from: a */
    private static final boolean f1359a = false;

    /* renamed from: b */
    private static final boolean f1360b;

    /* renamed from: c */
    private static final boolean f1361c;

    /* renamed from: d */
    private static final AtomicLong f1362d;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r0.equals("auto") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (r0.equals("on") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        if (r0.equals("") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        r0 = true;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.C0473a0.m1012d(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L64
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3a
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L31
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L27
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L44
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L64
        L27:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            r0 = 0
            goto L68
        L31:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L42
        L3a:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
        L42:
            r0 = 1
            goto L68
        L44:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L64:
            boolean r0 = m398a()
        L68:
            p048w0.C0768p0.f1360b = r0
            if (r0 == 0) goto L75
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.C0473a0.m1011e(r0, r2)
            if (r0 == 0) goto L75
            r1 = 1
        L75:
            p048w0.C0768p0.f1361c = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            p048w0.C0768p0.f1362d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p048w0.C0768p0.<clinit>():void");
    }

    /* renamed from: a */
    public static final boolean m398a() {
        return f1359a;
    }

    /* renamed from: b */
    public static final AtomicLong m397b() {
        return f1362d;
    }

    /* renamed from: c */
    public static final boolean m396c() {
        return f1360b;
    }

    /* renamed from: d */
    public static final boolean m395d() {
        return f1361c;
    }
}