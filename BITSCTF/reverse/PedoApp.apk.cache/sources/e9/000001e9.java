package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.view.TextureRegistry;
import p031o.C0576b;

@TargetApi(29)
/* renamed from: io.flutter.plugin.platform.b */
/* loaded from: classes.dex */
public class C0368b implements InterfaceC0381j {

    /* renamed from: a */
    private TextureRegistry.ImageTextureEntry f666a;

    /* renamed from: b */
    private ImageReader f667b;

    /* renamed from: c */
    private int f668c = 0;

    /* renamed from: d */
    private int f669d = 0;

    /* renamed from: e */
    private final Handler f670e = new Handler();

    /* renamed from: f */
    private final ImageReader.OnImageAvailableListener f671f = new C0369a();

    /* renamed from: io.flutter.plugin.platform.b$a */
    /* loaded from: classes.dex */
    class C0369a implements ImageReader.OnImageAvailableListener {
        C0369a() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                image = imageReader.acquireLatestImage();
            } catch (IllegalStateException e) {
                C0576b.m741b("ImageReaderPlatformViewRenderTarget", "New image available but it could not be acquired: " + e.toString());
                image = null;
            }
            if (image == null) {
                return;
            }
            C0368b.this.f666a.pushImage(image);
        }
    }

    public C0368b(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f666a = imageTextureEntry;
    }

    /* renamed from: i */
    private void m1432i() {
        if (this.f667b != null) {
            this.f666a.pushImage(null);
            this.f667b.close();
            this.f667b = null;
        }
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: a */
    public long mo1303a() {
        return this.f666a.mo1266id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: b */
    public Canvas mo1302b() {
        return mo1300d().lockHardwareCanvas();
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: c */
    public void mo1301c(int i, int i2) {
        if (this.f667b != null && this.f668c == i && this.f669d == i2) {
            return;
        }
        m1432i();
        this.f668c = i;
        this.f669d = i2;
        this.f667b = m1431j();
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: d */
    public Surface mo1300d() {
        return this.f667b.getSurface();
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: e */
    public void mo1299e(Canvas canvas) {
        mo1300d().unlockCanvasAndPost(canvas);
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: f */
    public int mo1298f() {
        return this.f668c;
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    /* renamed from: g */
    public int mo1297g() {
        return this.f669d;
    }

    /* renamed from: j */
    protected ImageReader m1431j() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return m1429l();
        }
        if (i >= 29) {
            return m1430k();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    @TargetApi(29)
    /* renamed from: k */
    protected ImageReader m1430k() {
        ImageReader newInstance = ImageReader.newInstance(this.f668c, this.f669d, 34, 3, 256L);
        newInstance.setOnImageAvailableListener(this.f671f, this.f670e);
        return newInstance;
    }

    @TargetApi(33)
    /* renamed from: l */
    protected ImageReader m1429l() {
        ImageReader.Builder builder = new ImageReader.Builder(this.f668c, this.f669d);
        builder.setMaxImages(3);
        builder.setImageFormat(34);
        builder.setUsage(256L);
        ImageReader build = builder.build();
        build.setOnImageAvailableListener(this.f671f, this.f670e);
        return build;
    }

    @Override // io.flutter.plugin.platform.InterfaceC0381j
    public void release() {
        m1432i();
        this.f666a = null;
    }
}