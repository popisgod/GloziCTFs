package p001a0;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p001a0.InterfaceC0016c;
import p031o.C0576b;

/* renamed from: a0.d */
/* loaded from: classes.dex */
public final class C0021d {

    /* renamed from: a */
    private final InterfaceC0016c f25a;

    /* renamed from: b */
    private final String f26b;

    /* renamed from: c */
    private final InterfaceC0039l f27c;

    /* renamed from: d */
    private final InterfaceC0016c.InterfaceC0019c f28d;

    /* renamed from: a0.d$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0023b {
        /* renamed from: a */
        void mo2278a(String str, String str2, Object obj);

        /* renamed from: b */
        void mo2277b(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0.d$c */
    /* loaded from: classes.dex */
    public final class C0024c implements InterfaceC0016c.InterfaceC0017a {

        /* renamed from: a */
        private final InterfaceC0026d f29a;

        /* renamed from: b */
        private final AtomicReference<InterfaceC0023b> f30b = new AtomicReference<>(null);

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a0.d$c$a */
        /* loaded from: classes.dex */
        public final class C0025a implements InterfaceC0023b {

            /* renamed from: a */
            final AtomicBoolean f32a;

            private C0025a() {
                this.f32a = new AtomicBoolean(false);
            }

            @Override // p001a0.C0021d.InterfaceC0023b
            /* renamed from: a */
            public void mo2278a(String str, String str2, Object obj) {
                if (this.f32a.get() || C0024c.this.f30b.get() != this) {
                    return;
                }
                C0021d.this.f25a.mo717f(C0021d.this.f26b, C0021d.this.f27c.mo2247c(str, str2, obj));
            }

            @Override // p001a0.C0021d.InterfaceC0023b
            /* renamed from: b */
            public void mo2277b(Object obj) {
                if (this.f32a.get() || C0024c.this.f30b.get() != this) {
                    return;
                }
                C0021d.this.f25a.mo717f(C0021d.this.f26b, C0021d.this.f27c.mo2246d(obj));
            }
        }

        C0024c(InterfaceC0026d interfaceC0026d) {
            this.f29a = interfaceC0026d;
        }

        /* renamed from: c */
        private void m2280c(Object obj, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
            ByteBuffer mo2247c;
            if (this.f30b.getAndSet(null) != null) {
                try {
                    this.f29a.mo755b(obj);
                    interfaceC0018b.mo710a(C0021d.this.f27c.mo2246d(null));
                    return;
                } catch (RuntimeException e) {
                    C0576b.m740c("EventChannel#" + C0021d.this.f26b, "Failed to close event stream", e);
                    mo2247c = C0021d.this.f27c.mo2247c("error", e.getMessage(), null);
                }
            } else {
                mo2247c = C0021d.this.f27c.mo2247c("error", "No active stream to cancel", null);
            }
            interfaceC0018b.mo710a(mo2247c);
        }

        /* renamed from: d */
        private void m2279d(Object obj, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
            C0025a c0025a = new C0025a();
            if (this.f30b.getAndSet(c0025a) != null) {
                try {
                    this.f29a.mo755b(null);
                } catch (RuntimeException e) {
                    C0576b.m740c("EventChannel#" + C0021d.this.f26b, "Failed to close existing event stream", e);
                }
            }
            try {
                this.f29a.mo756a(obj, c0025a);
                interfaceC0018b.mo710a(C0021d.this.f27c.mo2246d(null));
            } catch (RuntimeException e2) {
                this.f30b.set(null);
                C0576b.m740c("EventChannel#" + C0021d.this.f26b, "Failed to open event stream", e2);
                interfaceC0018b.mo710a(C0021d.this.f27c.mo2247c("error", e2.getMessage(), null));
            }
        }

        @Override // p001a0.InterfaceC0016c.InterfaceC0017a
        /* renamed from: a */
        public void mo724a(ByteBuffer byteBuffer, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
            C0032j mo2245e = C0021d.this.f27c.mo2245e(byteBuffer);
            if (mo2245e.f38a.equals("listen")) {
                m2279d(mo2245e.f39b, interfaceC0018b);
            } else if (mo2245e.f38a.equals("cancel")) {
                m2280c(mo2245e.f39b, interfaceC0018b);
            } else {
                interfaceC0018b.mo710a(null);
            }
        }
    }

    /* renamed from: a0.d$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0026d {
        /* renamed from: a */
        void mo756a(Object obj, InterfaceC0023b interfaceC0023b);

        /* renamed from: b */
        void mo755b(Object obj);
    }

    public C0021d(InterfaceC0016c interfaceC0016c, String str) {
        this(interfaceC0016c, str, C0047s.f53b);
    }

    public C0021d(InterfaceC0016c interfaceC0016c, String str, InterfaceC0039l interfaceC0039l) {
        this(interfaceC0016c, str, interfaceC0039l, null);
    }

    public C0021d(InterfaceC0016c interfaceC0016c, String str, InterfaceC0039l interfaceC0039l, InterfaceC0016c.InterfaceC0019c interfaceC0019c) {
        this.f25a = interfaceC0016c;
        this.f26b = str;
        this.f27c = interfaceC0039l;
        this.f28d = interfaceC0019c;
    }

    /* renamed from: d */
    public void m2282d(InterfaceC0026d interfaceC0026d) {
        if (this.f28d != null) {
            this.f25a.mo718d(this.f26b, interfaceC0026d != null ? new C0024c(interfaceC0026d) : null, this.f28d);
        } else {
            this.f25a.mo716g(this.f26b, interfaceC0026d != null ? new C0024c(interfaceC0026d) : null);
        }
    }
}