package p033p;

import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import p001a0.C0015b;
import p001a0.C0048t;
import p001a0.InterfaceC0016c;
import p012e0.C0143e;
import p031o.C0572a;
import p031o.C0576b;
import p037r.C0632d;

/* renamed from: p.a */
/* loaded from: classes.dex */
public class C0579a implements InterfaceC0016c {

    /* renamed from: a */
    private final FlutterJNI f1178a;

    /* renamed from: b */
    private final AssetManager f1179b;

    /* renamed from: c */
    private final C0585c f1180c;

    /* renamed from: d */
    private final InterfaceC0016c f1181d;

    /* renamed from: e */
    private boolean f1182e;

    /* renamed from: f */
    private String f1183f;

    /* renamed from: g */
    private InterfaceC0583d f1184g;

    /* renamed from: h */
    private final InterfaceC0016c.InterfaceC0017a f1185h;

    /* renamed from: p.a$a */
    /* loaded from: classes.dex */
    class C0580a implements InterfaceC0016c.InterfaceC0017a {
        C0580a() {
        }

        @Override // p001a0.InterfaceC0016c.InterfaceC0017a
        /* renamed from: a */
        public void mo724a(ByteBuffer byteBuffer, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
            C0579a.this.f1183f = C0048t.f56b.mo2243a(byteBuffer);
            if (C0579a.this.f1184g != null) {
                C0579a.this.f1184g.m722a(C0579a.this.f1183f);
            }
        }
    }

    /* renamed from: p.a$b */
    /* loaded from: classes.dex */
    public static class C0581b {

        /* renamed from: a */
        public final String f1187a;

        /* renamed from: b */
        public final String f1188b;

        /* renamed from: c */
        public final String f1189c;

        public C0581b(String str, String str2) {
            this.f1187a = str;
            this.f1188b = null;
            this.f1189c = str2;
        }

        public C0581b(String str, String str2, String str3) {
            this.f1187a = str;
            this.f1188b = str2;
            this.f1189c = str3;
        }

        /* renamed from: a */
        public static C0581b m723a() {
            C0632d m747c = C0572a.m745e().m747c();
            if (m747c.m674i()) {
                return new C0581b(m747c.m676g(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0581b c0581b = (C0581b) obj;
            if (this.f1187a.equals(c0581b.f1187a)) {
                return this.f1189c.equals(c0581b.f1189c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f1187a.hashCode() * 31) + this.f1189c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f1187a + ", function: " + this.f1189c + " )";
        }
    }

    /* renamed from: p.a$c */
    /* loaded from: classes.dex */
    private static class C0582c implements InterfaceC0016c {

        /* renamed from: a */
        private final C0585c f1190a;

        private C0582c(C0585c c0585c) {
            this.f1190a = c0585c;
        }

        /* synthetic */ C0582c(C0585c c0585c, C0580a c0580a) {
            this(c0585c);
        }

        @Override // p001a0.InterfaceC0016c
        /* renamed from: a */
        public InterfaceC0016c.InterfaceC0019c mo721a(InterfaceC0016c.C0020d c0020d) {
            return this.f1190a.mo721a(c0020d);
        }

        @Override // p001a0.InterfaceC0016c
        /* renamed from: b */
        public /* synthetic */ InterfaceC0016c.InterfaceC0019c mo720b() {
            return C0015b.m2287a(this);
        }

        @Override // p001a0.InterfaceC0016c
        /* renamed from: c */
        public void mo719c(String str, ByteBuffer byteBuffer, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
            this.f1190a.mo719c(str, byteBuffer, interfaceC0018b);
        }

        @Override // p001a0.InterfaceC0016c
        /* renamed from: d */
        public void mo718d(String str, InterfaceC0016c.InterfaceC0017a interfaceC0017a, InterfaceC0016c.InterfaceC0019c interfaceC0019c) {
            this.f1190a.mo718d(str, interfaceC0017a, interfaceC0019c);
        }

        @Override // p001a0.InterfaceC0016c
        /* renamed from: f */
        public void mo717f(String str, ByteBuffer byteBuffer) {
            this.f1190a.mo719c(str, byteBuffer, null);
        }

        @Override // p001a0.InterfaceC0016c
        /* renamed from: g */
        public void mo716g(String str, InterfaceC0016c.InterfaceC0017a interfaceC0017a) {
            this.f1190a.mo716g(str, interfaceC0017a);
        }
    }

    /* renamed from: p.a$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0583d {
        /* renamed from: a */
        void m722a(String str);
    }

    public C0579a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f1182e = false;
        C0580a c0580a = new C0580a();
        this.f1185h = c0580a;
        this.f1178a = flutterJNI;
        this.f1179b = assetManager;
        C0585c c0585c = new C0585c(flutterJNI);
        this.f1180c = c0585c;
        c0585c.mo716g("flutter/isolate", c0580a);
        this.f1181d = new C0582c(c0585c, null);
        if (flutterJNI.isAttached()) {
            this.f1182e = true;
        }
    }

    @Override // p001a0.InterfaceC0016c
    @Deprecated
    /* renamed from: a */
    public InterfaceC0016c.InterfaceC0019c mo721a(InterfaceC0016c.C0020d c0020d) {
        return this.f1181d.mo721a(c0020d);
    }

    @Override // p001a0.InterfaceC0016c
    /* renamed from: b */
    public /* synthetic */ InterfaceC0016c.InterfaceC0019c mo720b() {
        return C0015b.m2287a(this);
    }

    @Override // p001a0.InterfaceC0016c
    @Deprecated
    /* renamed from: c */
    public void mo719c(String str, ByteBuffer byteBuffer, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
        this.f1181d.mo719c(str, byteBuffer, interfaceC0018b);
    }

    @Override // p001a0.InterfaceC0016c
    @Deprecated
    /* renamed from: d */
    public void mo718d(String str, InterfaceC0016c.InterfaceC0017a interfaceC0017a, InterfaceC0016c.InterfaceC0019c interfaceC0019c) {
        this.f1181d.mo718d(str, interfaceC0017a, interfaceC0019c);
    }

    @Override // p001a0.InterfaceC0016c
    @Deprecated
    /* renamed from: f */
    public void mo717f(String str, ByteBuffer byteBuffer) {
        this.f1181d.mo717f(str, byteBuffer);
    }

    @Override // p001a0.InterfaceC0016c
    @Deprecated
    /* renamed from: g */
    public void mo716g(String str, InterfaceC0016c.InterfaceC0017a interfaceC0017a) {
        this.f1181d.mo716g(str, interfaceC0017a);
    }

    /* renamed from: j */
    public void m729j(C0581b c0581b, List<String> list) {
        if (this.f1182e) {
            C0576b.m736g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        C0143e.m2035a("DartExecutor#executeDartEntrypoint");
        try {
            C0576b.m737f("DartExecutor", "Executing Dart entrypoint: " + c0581b);
            this.f1178a.runBundleAndSnapshotFromLibrary(c0581b.f1187a, c0581b.f1189c, c0581b.f1188b, this.f1179b, list);
            this.f1182e = true;
        } finally {
            C0143e.m2032d();
        }
    }

    /* renamed from: k */
    public boolean m728k() {
        return this.f1182e;
    }

    /* renamed from: l */
    public void m727l() {
        if (this.f1178a.isAttached()) {
            this.f1178a.notifyLowMemoryWarning();
        }
    }

    /* renamed from: m */
    public void m726m() {
        C0576b.m737f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f1178a.setPlatformMessageHandler(this.f1180c);
    }

    /* renamed from: n */
    public void m725n() {
        C0576b.m737f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f1178a.setPlatformMessageHandler(null);
    }
}