package p053z;

import java.util.HashMap;
import java.util.Map;
import p001a0.C0032j;
import p001a0.C0033k;
import p001a0.C0047s;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.m */
/* loaded from: classes.dex */
public class C0885m {

    /* renamed from: a */
    public final boolean f1583a;

    /* renamed from: b */
    private byte[] f1584b;

    /* renamed from: c */
    private C0033k f1585c;

    /* renamed from: d */
    private C0033k.InterfaceC0038d f1586d;

    /* renamed from: e */
    private boolean f1587e;

    /* renamed from: f */
    private boolean f1588f;

    /* renamed from: g */
    private final C0033k.InterfaceC0037c f1589g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z.m$a */
    /* loaded from: classes.dex */
    public class C0886a implements C0033k.InterfaceC0038d {

        /* renamed from: a */
        final /* synthetic */ byte[] f1590a;

        C0886a(byte[] bArr) {
            this.f1590a = bArr;
        }

        @Override // p001a0.C0033k.InterfaceC0038d
        /* renamed from: a */
        public void mo66a(String str, String str2, Object obj) {
            C0576b.m741b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // p001a0.C0033k.InterfaceC0038d
        /* renamed from: b */
        public void mo65b(Object obj) {
            C0885m.this.f1584b = this.f1590a;
        }

        @Override // p001a0.C0033k.InterfaceC0038d
        /* renamed from: c */
        public void mo64c() {
        }
    }

    /* renamed from: z.m$b */
    /* loaded from: classes.dex */
    class C0887b implements C0033k.InterfaceC0037c {
        C0887b() {
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            Map m68i;
            String str = c0032j.f38a;
            Object obj = c0032j.f39b;
            str.hashCode();
            if (str.equals("get")) {
                C0885m.this.f1588f = true;
                if (!C0885m.this.f1587e) {
                    C0885m c0885m = C0885m.this;
                    if (c0885m.f1583a) {
                        c0885m.f1586d = interfaceC0038d;
                        return;
                    }
                }
                C0885m c0885m2 = C0885m.this;
                m68i = c0885m2.m68i(c0885m2.f1584b);
            } else if (!str.equals("put")) {
                interfaceC0038d.mo64c();
                return;
            } else {
                C0885m.this.f1584b = (byte[]) obj;
                m68i = null;
            }
            interfaceC0038d.mo65b(m68i);
        }
    }

    C0885m(C0033k c0033k, boolean z) {
        this.f1587e = false;
        this.f1588f = false;
        C0887b c0887b = new C0887b();
        this.f1589g = c0887b;
        this.f1585c = c0033k;
        this.f1583a = z;
        c0033k.m2269e(c0887b);
    }

    public C0885m(C0579a c0579a, boolean z) {
        this(new C0033k(c0579a, "flutter/restoration", C0047s.f53b), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public Map<String, Object> m68i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    /* renamed from: g */
    public void m70g() {
        this.f1584b = null;
    }

    /* renamed from: h */
    public byte[] m69h() {
        return this.f1584b;
    }

    /* renamed from: j */
    public void m67j(byte[] bArr) {
        this.f1587e = true;
        C0033k.InterfaceC0038d interfaceC0038d = this.f1586d;
        if (interfaceC0038d != null) {
            interfaceC0038d.mo65b(m68i(bArr));
            this.f1586d = null;
        } else if (this.f1588f) {
            this.f1585c.m2270d("push", m68i(bArr), new C0886a(bArr));
            return;
        }
        this.f1584b = bArr;
    }
}