package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.C0390r;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p005b0.C0109a;
import p012e0.C0146h;
import p031o.C0572a;
import p031o.C0576b;
import p033p.C0579a;
import p035q.InterfaceC0623a;
import p037r.C0632d;
import p041t.InterfaceC0651b;
import p043u.InterfaceC0660b;
import p051y.C0808a;
import p053z.C0839a;
import p053z.C0842b;
import p053z.C0851f;
import p053z.C0854g;
import p053z.C0857h;
import p053z.C0860i;
import p053z.C0862j;
import p053z.C0885m;
import p053z.C0888n;
import p053z.C0894o;
import p053z.C0897p;
import p053z.C0898q;

/* renamed from: io.flutter.embedding.engine.a */
/* loaded from: classes.dex */
public class C0313a implements C0146h.InterfaceC0147a {

    /* renamed from: a */
    private final FlutterJNI f456a;

    /* renamed from: b */
    private final FlutterRenderer f457b;

    /* renamed from: c */
    private final C0579a f458c;

    /* renamed from: d */
    private final C0317c f459d;

    /* renamed from: e */
    private final C0109a f460e;

    /* renamed from: f */
    private final C0839a f461f;

    /* renamed from: g */
    private final C0842b f462g;

    /* renamed from: h */
    private final C0851f f463h;

    /* renamed from: i */
    private final C0854g f464i;

    /* renamed from: j */
    private final C0857h f465j;

    /* renamed from: k */
    private final C0860i f466k;

    /* renamed from: l */
    private final C0885m f467l;

    /* renamed from: m */
    private final C0862j f468m;

    /* renamed from: n */
    private final C0888n f469n;

    /* renamed from: o */
    private final C0894o f470o;

    /* renamed from: p */
    private final C0897p f471p;

    /* renamed from: q */
    private final C0898q f472q;

    /* renamed from: r */
    private final C0390r f473r;

    /* renamed from: s */
    private final Set<InterfaceC0315b> f474s;

    /* renamed from: t */
    private final InterfaceC0315b f475t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.a$a */
    /* loaded from: classes.dex */
    public class C0314a implements InterfaceC0315b {
        C0314a() {
            C0313a.this = r1;
        }

        @Override // io.flutter.embedding.engine.C0313a.InterfaceC0315b
        /* renamed from: a */
        public void mo1576a() {
            C0576b.m737f("FlutterEngine", "onPreEngineRestart()");
            for (InterfaceC0315b interfaceC0315b : C0313a.this.f474s) {
                interfaceC0315b.mo1576a();
            }
            C0313a.this.f473r.m1331m0();
            C0313a.this.f467l.m70g();
        }

        @Override // io.flutter.embedding.engine.C0313a.InterfaceC0315b
        /* renamed from: b */
        public void mo1575b() {
        }
    }

    /* renamed from: io.flutter.embedding.engine.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0315b {
        /* renamed from: a */
        void mo1576a();

        /* renamed from: b */
        void mo1575b();
    }

    public C0313a(Context context, C0632d c0632d, FlutterJNI flutterJNI, C0390r c0390r, String[] strArr, boolean z, boolean z2) {
        this(context, c0632d, flutterJNI, c0390r, strArr, z, z2, null);
    }

    public C0313a(Context context, C0632d c0632d, FlutterJNI flutterJNI, C0390r c0390r, String[] strArr, boolean z, boolean z2, C0324d c0324d) {
        AssetManager assets;
        this.f474s = new HashSet();
        this.f475t = new C0314a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        C0572a m745e = C0572a.m745e();
        flutterJNI = flutterJNI == null ? m745e.m746d().m1629a() : flutterJNI;
        this.f456a = flutterJNI;
        C0579a c0579a = new C0579a(flutterJNI, assets);
        this.f458c = c0579a;
        c0579a.m726m();
        InterfaceC0623a m749a = C0572a.m745e().m749a();
        this.f461f = new C0839a(c0579a, flutterJNI);
        C0842b c0842b = new C0842b(c0579a);
        this.f462g = c0842b;
        this.f463h = new C0851f(c0579a);
        C0854g c0854g = new C0854g(c0579a);
        this.f464i = c0854g;
        this.f465j = new C0857h(c0579a);
        this.f466k = new C0860i(c0579a);
        this.f468m = new C0862j(c0579a);
        this.f467l = new C0885m(c0579a, z2);
        this.f469n = new C0888n(c0579a);
        this.f470o = new C0894o(c0579a);
        this.f471p = new C0897p(c0579a);
        this.f472q = new C0898q(c0579a);
        if (m749a != null) {
            m749a.m695e(c0842b);
        }
        C0109a c0109a = new C0109a(context, c0854g);
        this.f460e = c0109a;
        c0632d = c0632d == null ? m745e.m747c() : c0632d;
        if (!flutterJNI.isAttached()) {
            c0632d.m672k(context.getApplicationContext());
            c0632d.m677f(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.f475t);
        flutterJNI.setPlatformViewsController(c0390r);
        flutterJNI.setLocalizationPlugin(c0109a);
        flutterJNI.setDeferredComponentManager(m745e.m749a());
        if (!flutterJNI.isAttached()) {
            m1623f();
        }
        this.f457b = new FlutterRenderer(flutterJNI);
        this.f473r = c0390r;
        c0390r.m1343g0();
        this.f459d = new C0317c(context.getApplicationContext(), this, c0632d, c0324d);
        c0109a.m2096d(context.getResources().getConfiguration());
        if (z && c0632d.m678e()) {
            C0808a.m236a(this);
        }
        C0146h.m2028c(context, this);
    }

    /* renamed from: f */
    private void m1623f() {
        C0576b.m737f("FlutterEngine", "Attaching to JNI.");
        this.f456a.attachToNative();
        if (!m1605x()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    /* renamed from: x */
    private boolean m1605x() {
        return this.f456a.isAttached();
    }

    @Override // p012e0.C0146h.InterfaceC0147a
    /* renamed from: a */
    public void mo1628a(float f, float f2, float f3) {
        this.f456a.updateDisplayMetrics(0, f, f2, f3);
    }

    /* renamed from: e */
    public void m1624e(InterfaceC0315b interfaceC0315b) {
        this.f474s.add(interfaceC0315b);
    }

    /* renamed from: g */
    public void m1622g() {
        C0576b.m737f("FlutterEngine", "Destroying.");
        for (InterfaceC0315b interfaceC0315b : this.f474s) {
            interfaceC0315b.mo1575b();
        }
        this.f459d.m1598l();
        this.f473r.m1339i0();
        this.f458c.m725n();
        this.f456a.removeEngineLifecycleListener(this.f475t);
        this.f456a.setDeferredComponentManager(null);
        this.f456a.detachFromNativeAndReleaseResources();
        if (C0572a.m745e().m749a() != null) {
            C0572a.m745e().m749a().m696d();
            this.f462g.m162c(null);
        }
    }

    /* renamed from: h */
    public C0839a m1621h() {
        return this.f461f;
    }

    /* renamed from: i */
    public InterfaceC0660b m1620i() {
        return this.f459d;
    }

    /* renamed from: j */
    public C0579a m1619j() {
        return this.f458c;
    }

    /* renamed from: k */
    public C0851f m1618k() {
        return this.f463h;
    }

    /* renamed from: l */
    public C0109a m1617l() {
        return this.f460e;
    }

    /* renamed from: m */
    public C0857h m1616m() {
        return this.f465j;
    }

    /* renamed from: n */
    public C0860i m1615n() {
        return this.f466k;
    }

    /* renamed from: o */
    public C0862j m1614o() {
        return this.f468m;
    }

    /* renamed from: p */
    public C0390r m1613p() {
        return this.f473r;
    }

    /* renamed from: q */
    public InterfaceC0651b m1612q() {
        return this.f459d;
    }

    /* renamed from: r */
    public FlutterRenderer m1611r() {
        return this.f457b;
    }

    /* renamed from: s */
    public C0885m m1610s() {
        return this.f467l;
    }

    /* renamed from: t */
    public C0888n m1609t() {
        return this.f469n;
    }

    /* renamed from: u */
    public C0894o m1608u() {
        return this.f470o;
    }

    /* renamed from: v */
    public C0897p m1607v() {
        return this.f471p;
    }

    /* renamed from: w */
    public C0898q m1606w() {
        return this.f472q;
    }

    /* renamed from: y */
    public C0313a m1604y(Context context, C0579a.C0581b c0581b, String str, List<String> list, C0390r c0390r, boolean z, boolean z2) {
        if (m1605x()) {
            return new C0313a(context, null, this.f456a.spawn(c0581b.f1189c, c0581b.f1188b, str, list), c0390r, null, z, z2);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }
}