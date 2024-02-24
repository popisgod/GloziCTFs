package p001a0;

import java.nio.ByteBuffer;
import p001a0.InterfaceC0016c;
import p031o.C0576b;

/* renamed from: a0.k */
/* loaded from: classes.dex */
public class C0033k {

    /* renamed from: a */
    private final InterfaceC0016c f40a;

    /* renamed from: b */
    private final String f41b;

    /* renamed from: c */
    private final InterfaceC0039l f42c;

    /* renamed from: d */
    private final InterfaceC0016c.InterfaceC0019c f43d;

    /* renamed from: a0.k$a */
    /* loaded from: classes.dex */
    private final class C0034a implements InterfaceC0016c.InterfaceC0017a {

        /* renamed from: a */
        private final InterfaceC0037c f44a;

        /* renamed from: a0.k$a$a */
        /* loaded from: classes.dex */
        class C0035a implements InterfaceC0038d {

            /* renamed from: a */
            final /* synthetic */ InterfaceC0016c.InterfaceC0018b f46a;

            C0035a(InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
                this.f46a = interfaceC0018b;
            }

            @Override // p001a0.C0033k.InterfaceC0038d
            /* renamed from: a */
            public void mo66a(String str, String str2, Object obj) {
                this.f46a.mo710a(C0033k.this.f42c.mo2247c(str, str2, obj));
            }

            @Override // p001a0.C0033k.InterfaceC0038d
            /* renamed from: b */
            public void mo65b(Object obj) {
                this.f46a.mo710a(C0033k.this.f42c.mo2246d(obj));
            }

            @Override // p001a0.C0033k.InterfaceC0038d
            /* renamed from: c */
            public void mo64c() {
                this.f46a.mo710a(null);
            }
        }

        C0034a(InterfaceC0037c interfaceC0037c) {
            this.f44a = interfaceC0037c;
        }

        @Override // p001a0.InterfaceC0016c.InterfaceC0017a
        /* renamed from: a */
        public void mo724a(ByteBuffer byteBuffer, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
            try {
                this.f44a.mo24a(C0033k.this.f42c.mo2245e(byteBuffer), new C0035a(interfaceC0018b));
            } catch (RuntimeException e) {
                C0576b.m740c("MethodChannel#" + C0033k.this.f41b, "Failed to handle method call", e);
                interfaceC0018b.mo710a(C0033k.this.f42c.mo2249a("error", e.getMessage(), null, C0576b.m739d(e)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0.k$b */
    /* loaded from: classes.dex */
    public final class C0036b implements InterfaceC0016c.InterfaceC0018b {

        /* renamed from: a */
        private final InterfaceC0038d f48a;

        C0036b(InterfaceC0038d interfaceC0038d) {
            this.f48a = interfaceC0038d;
        }

        @Override // p001a0.InterfaceC0016c.InterfaceC0018b
        /* renamed from: a */
        public void mo710a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f48a.mo64c();
                } else {
                    try {
                        this.f48a.mo65b(C0033k.this.f42c.mo2244f(byteBuffer));
                    } catch (C0027e e) {
                        this.f48a.mo66a(e.f34d, e.getMessage(), e.f35e);
                    }
                }
            } catch (RuntimeException e2) {
                C0576b.m740c("MethodChannel#" + C0033k.this.f41b, "Failed to handle method call result", e2);
            }
        }
    }

    /* renamed from: a0.k$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0037c {
        /* renamed from: a */
        void mo24a(C0032j c0032j, InterfaceC0038d interfaceC0038d);
    }

    /* renamed from: a0.k$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0038d {
        /* renamed from: a */
        void mo66a(String str, String str2, Object obj);

        /* renamed from: b */
        void mo65b(Object obj);

        /* renamed from: c */
        void mo64c();
    }

    public C0033k(InterfaceC0016c interfaceC0016c, String str) {
        this(interfaceC0016c, str, C0047s.f53b);
    }

    public C0033k(InterfaceC0016c interfaceC0016c, String str, InterfaceC0039l interfaceC0039l) {
        this(interfaceC0016c, str, interfaceC0039l, null);
    }

    public C0033k(InterfaceC0016c interfaceC0016c, String str, InterfaceC0039l interfaceC0039l, InterfaceC0016c.InterfaceC0019c interfaceC0019c) {
        this.f40a = interfaceC0016c;
        this.f41b = str;
        this.f42c = interfaceC0039l;
        this.f43d = interfaceC0019c;
    }

    /* renamed from: c */
    public void m2271c(String str, Object obj) {
        m2270d(str, obj, null);
    }

    /* renamed from: d */
    public void m2270d(String str, Object obj, InterfaceC0038d interfaceC0038d) {
        this.f40a.mo719c(this.f41b, this.f42c.mo2248b(new C0032j(str, obj)), interfaceC0038d == null ? null : new C0036b(interfaceC0038d));
    }

    /* renamed from: e */
    public void m2269e(InterfaceC0037c interfaceC0037c) {
        if (this.f43d != null) {
            this.f40a.mo718d(this.f41b, interfaceC0037c != null ? new C0034a(interfaceC0037c) : null, this.f43d);
        } else {
            this.f40a.mo716g(this.f41b, interfaceC0037c != null ? new C0034a(interfaceC0037c) : null);
        }
    }
}