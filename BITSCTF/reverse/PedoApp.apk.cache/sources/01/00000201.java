package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.view.TextureRegistry;
import java.util.concurrent.atomic.AtomicLong;
import p031o.C0576b;

@TargetApi(26)
/* renamed from: io.flutter.plugin.platform.s */
/* loaded from: classes.dex */
public class C0392s implements InterfaceC0381j {

    /* renamed from: b */
    private final TextureRegistry.InterfaceC0405c f736b;

    /* renamed from: c */
    private SurfaceTexture f737c;

    /* renamed from: d */
    private Surface f738d;

    /* renamed from: g */
    private final TextureRegistry.InterfaceC0403a f741g;

    /* renamed from: h */
    private boolean f742h;

    /* renamed from: i */
    private final TextureRegistry.InterfaceC0404b f743i;

    /* renamed from: a */
    private final AtomicLong f735a = new AtomicLong(0);

    /* renamed from: e */
    private int f739e = 0;

    /* renamed from: f */
    private int f740f = 0;

    /* renamed from: io.flutter.plugin.platform.s$a */
    /* loaded from: classes.dex */
    class C0393a implements TextureRegistry.InterfaceC0403a {
        C0393a() {
        }

        @Override // io.flutter.view.TextureRegistry.InterfaceC0403a
        /* renamed from: a */
        public void mo1265a() {
            if (Build.VERSION.SDK_INT == 29) {
                C0392s.this.f735a.decrementAndGet();
            }
        }
    }

    /* renamed from: io.flutter.plugin.platform.s$b */
    /* loaded from: classes.dex */
    class C0394b implements TextureRegistry.InterfaceC0404b {
        C0394b() {
        }

        @Override // io.flutter.view.TextureRegistry.InterfaceC0404b
        public void onTrimMemory(int i) {
            if (i != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            C0392s.this.f742h = true;
        }
    }

    public C0392s(TextureRegistry.InterfaceC0405c interfaceC0405c) {
        C0393a c0393a = new C0393a();
        this.f741g = c0393a;
        this.f742h = false;
        C0394b c0394b = new C0394b();
        this.f743i = c0394b;
        if (Build.VERSION.SDK_INT < 23) {
            throw new UnsupportedOperationException("Platform views cannot be displayed below API level 23You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
        }
        this.f736b = interfaceC0405c;
        this.f737c = interfaceC0405c.mo1262c();
        interfaceC0405c.mo1263b(c0393a);
        interfaceC0405c.mo1264a(c0394b);
        m1293k();
    }

    /* renamed from: k */
    private void m1293k() {
        int i;
        int i2 = this.f739e;
        if (i2 > 0 && (i = this.f740f) > 0) {
            this.f737c.setDefaultBufferSize(i2, i);
        }
        Surface surface = this.f738d;
        if (surface != null) {
            surface.release();
            this.f738d = null;
        }
        this.f738d = m1294j();
        Canvas mo1302b = mo1302b();
        try {
            mo1302b.drawColor(0, PorterDuff.Mode.CLEAR);
        } finally {
            mo1299e(mo1302b);
        }
    }

    /* renamed from: l */
    private void m1292l() {
        if (Build.VERSION.SDK_INT == 29) {
            this.f735a.incrementAndGet();
        }
    }

    /* renamed from: m */
    private void m1291m() {
        if (this.f742h) {
            Surface surface = this.f738d;
            if (surface != null) {
                surface.release();
                this.f738d = null;
            }
            this.f738d = m1294j();
            this.f742h = false;
        }
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: a */
    public long mo1303a() {
        return this.f736b.mo1261id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: b */
    public Canvas mo1302b() {
        m1291m();
        if (Build.VERSION.SDK_INT != 29 || this.f735a.get() <= 0) {
            SurfaceTexture surfaceTexture = this.f737c;
            if (surfaceTexture == null || surfaceTexture.isReleased()) {
                C0576b.m741b("SurfaceTexturePlatformViewRenderTarget", "Invalid RenderTarget: null or already released SurfaceTexture");
                return null;
            }
            m1292l();
            return this.f738d.lockHardwareCanvas();
        }
        return null;
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: c */
    public void mo1301c(int i, int i2) {
        this.f739e = i;
        this.f740f = i2;
        SurfaceTexture surfaceTexture = this.f737c;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: d */
    public Surface mo1300d() {
        m1291m();
        return this.f738d;
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: e */
    public void mo1299e(Canvas canvas) {
        this.f738d.unlockCanvasAndPost(canvas);
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: f */
    public int mo1298f() {
        return this.f739e;
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: g */
    public int mo1297g() {
        return this.f740f;
    }

    /* renamed from: j */
    protected Surface m1294j() {
        return new Surface(this.f737c);
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    public void release() {
        this.f737c = null;
        Surface surface = this.f738d;
        if (surface != null) {
            surface.release();
            this.f738d = null;
        }
    }
}