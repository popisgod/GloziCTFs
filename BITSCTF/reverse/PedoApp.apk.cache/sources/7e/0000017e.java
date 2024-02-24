package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.InterfaceC0342b;
import p031o.C0576b;

/* renamed from: io.flutter.embedding.android.h */
/* loaded from: classes.dex */
public class C0271h extends TextureView implements InterfaceC0342b {

    /* renamed from: a */
    private boolean f351a;

    /* renamed from: b */
    private boolean f352b;

    /* renamed from: c */
    private boolean f353c;

    /* renamed from: d */
    private FlutterRenderer f354d;

    /* renamed from: e */
    private Surface f355e;

    /* renamed from: f */
    private final TextureView.SurfaceTextureListener f356f;

    /* renamed from: io.flutter.embedding.android.h$a */
    /* loaded from: classes.dex */
    class TextureView$SurfaceTextureListenerC0272a implements TextureView.SurfaceTextureListener {
        TextureView$SurfaceTextureListenerC0272a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            C0576b.m737f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            C0271h.this.f351a = true;
            if (C0271h.this.f352b) {
                C0271h.this.m1703l();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            C0576b.m737f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            C0271h.this.f351a = false;
            if (C0271h.this.f352b) {
                C0271h.this.m1702m();
            }
            if (C0271h.this.f355e != null) {
                C0271h.this.f355e.release();
                C0271h.this.f355e = null;
                return true;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            C0576b.m737f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (C0271h.this.f352b) {
                C0271h.this.m1704k(i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public C0271h(Context context) {
        this(context, null);
    }

    public C0271h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f351a = false;
        this.f352b = false;
        this.f353c = false;
        this.f356f = new TextureView$SurfaceTextureListenerC0272a();
        m1701n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m1704k(int i, int i2) {
        if (this.f354d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        C0576b.m737f("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.f354d.m1534y(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m1703l() {
        if (this.f354d == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f355e;
        if (surface != null) {
            surface.release();
            this.f355e = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f355e = surface2;
        this.f354d.m1536w(surface2, this.f353c);
        this.f353c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m1702m() {
        FlutterRenderer flutterRenderer = this.f354d;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.m1535x();
        Surface surface = this.f355e;
        if (surface != null) {
            surface.release();
            this.f355e = null;
        }
    }

    /* renamed from: n */
    private void m1701n() {
        setSurfaceTextureListener(this.f356f);
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: a */
    public void mo1525a(FlutterRenderer flutterRenderer) {
        C0576b.m737f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f354d != null) {
            C0576b.m737f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f354d.m1535x();
        }
        this.f354d = flutterRenderer;
        this.f352b = true;
        if (this.f351a) {
            C0576b.m737f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m1703l();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: b */
    public void mo1524b() {
        if (this.f354d == null) {
            C0576b.m736g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f354d = null;
        this.f353c = true;
        this.f352b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: c */
    public void mo1523c() {
        if (this.f354d == null) {
            C0576b.m736g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            C0576b.m737f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            m1702m();
        }
        this.f354d = null;
        this.f352b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    public FlutterRenderer getAttachedRenderer() {
        return this.f354d;
    }

    public void setRenderSurface(Surface surface) {
        this.f355e = surface;
    }
}