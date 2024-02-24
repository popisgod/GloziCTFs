package p001a0;

import java.nio.ByteBuffer;
import p001a0.InterfaceC0016c;
import p031o.C0576b;

/* renamed from: a0.a */
/* loaded from: classes.dex */
public final class C0008a<T> {

    /* renamed from: a */
    private final InterfaceC0016c f14a;

    /* renamed from: b */
    private final String f15b;

    /* renamed from: c */
    private final InterfaceC0031i<T> f16c;

    /* renamed from: d */
    private final InterfaceC0016c.InterfaceC0019c f17d;

    /* renamed from: a0.a$b */
    /* loaded from: classes.dex */
    private final class C0010b implements InterfaceC0016c.InterfaceC0017a {

        /* renamed from: a */
        private final InterfaceC0013d<T> f18a;

        /* renamed from: a0.a$b$a */
        /* loaded from: classes.dex */
        class C0011a implements InterfaceC0014e<T> {

            /* renamed from: a */
            final /* synthetic */ InterfaceC0016c.InterfaceC0018b f20a;

            C0011a(InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
                this.f20a = interfaceC0018b;
            }

            @Override // p001a0.C0008a.InterfaceC0014e
            /* renamed from: a */
            public void mo56a(T t) {
                this.f20a.mo710a(C0008a.this.f16c.mo2242b(t));
            }
        }

        private C0010b(InterfaceC0013d<T> interfaceC0013d) {
            this.f18a = interfaceC0013d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p001a0.InterfaceC0016c.InterfaceC0017a
        /* renamed from: a */
        public void mo724a(ByteBuffer byteBuffer, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
            try {
                this.f18a.mo170a(C0008a.this.f16c.mo2243a(byteBuffer), new C0011a(interfaceC0018b));
            } catch (RuntimeException e) {
                C0576b.m740c("BasicMessageChannel#" + C0008a.this.f15b, "Failed to handle message", e);
                interfaceC0018b.mo710a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0.a$c */
    /* loaded from: classes.dex */
    public final class C0012c implements InterfaceC0016c.InterfaceC0018b {

        /* renamed from: a */
        private final InterfaceC0014e<T> f22a;

        private C0012c(InterfaceC0014e<T> interfaceC0014e) {
            this.f22a = interfaceC0014e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p001a0.InterfaceC0016c.InterfaceC0018b
        /* renamed from: a */
        public void mo710a(ByteBuffer byteBuffer) {
            try {
                this.f22a.mo56a(C0008a.this.f16c.mo2243a(byteBuffer));
            } catch (RuntimeException e) {
                C0576b.m740c("BasicMessageChannel#" + C0008a.this.f15b, "Failed to handle message reply", e);
            }
        }
    }

    /* renamed from: a0.a$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0013d<T> {
        /* renamed from: a */
        void mo170a(T t, InterfaceC0014e<T> interfaceC0014e);
    }

    /* renamed from: a0.a$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0014e<T> {
        /* renamed from: a */
        void mo56a(T t);
    }

    public C0008a(InterfaceC0016c interfaceC0016c, String str, InterfaceC0031i<T> interfaceC0031i) {
        this(interfaceC0016c, str, interfaceC0031i, null);
    }

    public C0008a(InterfaceC0016c interfaceC0016c, String str, InterfaceC0031i<T> interfaceC0031i, InterfaceC0016c.InterfaceC0019c interfaceC0019c) {
        this.f14a = interfaceC0016c;
        this.f15b = str;
        this.f16c = interfaceC0031i;
        this.f17d = interfaceC0019c;
    }

    /* renamed from: c */
    public void m2290c(T t) {
        m2289d(t, null);
    }

    /* renamed from: d */
    public void m2289d(T t, InterfaceC0014e<T> interfaceC0014e) {
        this.f14a.mo719c(this.f15b, this.f16c.mo2242b(t), interfaceC0014e != null ? new C0012c(interfaceC0014e) : null);
    }

    /* renamed from: e */
    public void m2288e(InterfaceC0013d<T> interfaceC0013d) {
        if (this.f17d != null) {
            this.f14a.mo718d(this.f15b, interfaceC0013d != null ? new C0010b(interfaceC0013d) : null, this.f17d);
        } else {
            this.f14a.mo716g(this.f15b, interfaceC0013d != null ? new C0010b(interfaceC0013d) : null);
        }
    }
}