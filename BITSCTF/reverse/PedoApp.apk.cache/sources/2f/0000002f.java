package p001a0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p001a0.C0045r;
import p031o.C0576b;

/* renamed from: a0.s */
/* loaded from: classes.dex */
public final class C0047s implements InterfaceC0039l {

    /* renamed from: b */
    public static final C0047s f53b = new C0047s(C0045r.f50a);

    /* renamed from: a */
    private final C0045r f54a;

    public C0047s(C0045r c0045r) {
        this.f54a = c0045r;
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: a */
    public ByteBuffer mo2249a(String str, String str2, Object obj, String str3) {
        C0045r.C0046a c0046a = new C0045r.C0046a();
        c0046a.write(1);
        this.f54a.m2251p(c0046a, str);
        this.f54a.m2251p(c0046a, str2);
        if (obj instanceof Throwable) {
            this.f54a.m2251p(c0046a, C0576b.m739d((Throwable) obj));
        } else {
            this.f54a.m2251p(c0046a, obj);
        }
        this.f54a.m2251p(c0046a, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c0046a.size());
        allocateDirect.put(c0046a.m2250a(), 0, c0046a.size());
        return allocateDirect;
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: b */
    public ByteBuffer mo2248b(C0032j c0032j) {
        C0045r.C0046a c0046a = new C0045r.C0046a();
        this.f54a.m2251p(c0046a, c0032j.f38a);
        this.f54a.m2251p(c0046a, c0032j.f39b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c0046a.size());
        allocateDirect.put(c0046a.m2250a(), 0, c0046a.size());
        return allocateDirect;
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: c */
    public ByteBuffer mo2247c(String str, String str2, Object obj) {
        C0045r.C0046a c0046a = new C0045r.C0046a();
        c0046a.write(1);
        this.f54a.m2251p(c0046a, str);
        this.f54a.m2251p(c0046a, str2);
        if (obj instanceof Throwable) {
            this.f54a.m2251p(c0046a, C0576b.m739d((Throwable) obj));
        } else {
            this.f54a.m2251p(c0046a, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c0046a.size());
        allocateDirect.put(c0046a.m2250a(), 0, c0046a.size());
        return allocateDirect;
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: d */
    public ByteBuffer mo2246d(Object obj) {
        C0045r.C0046a c0046a = new C0045r.C0046a();
        c0046a.write(0);
        this.f54a.m2251p(c0046a, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c0046a.size());
        allocateDirect.put(c0046a.m2250a(), 0, c0046a.size());
        return allocateDirect;
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: e */
    public C0032j mo2245e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object m2261f = this.f54a.m2261f(byteBuffer);
        Object m2261f2 = this.f54a.m2261f(byteBuffer);
        if (!(m2261f instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new C0032j((String) m2261f, m2261f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r0 == 1) goto L8;
     */
    @Override // p001a0.InterfaceC0039l
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo2244f(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L4a
            goto L1e
        L11:
            a0.r r0 = r4.f54a
            java.lang.Object r0 = r0.m2261f(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            a0.r r0 = r4.f54a
            java.lang.Object r0 = r0.m2261f(r5)
            a0.r r1 = r4.f54a
            java.lang.Object r1 = r1.m2261f(r5)
            a0.r r2 = r4.f54a
            java.lang.Object r2 = r2.m2261f(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L4a
            if (r1 == 0) goto L3a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L4a
        L3a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L4a
            a0.e r5 = new a0.e
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L4a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a0.C0047s.mo2244f(java.nio.ByteBuffer):java.lang.Object");
    }
}