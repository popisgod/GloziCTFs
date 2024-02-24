package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.InterfaceC0341a;
import io.flutter.embedding.engine.renderer.InterfaceC0342b;
import p031o.C0576b;

/* renamed from: io.flutter.embedding.android.g */
/* loaded from: classes.dex */
public class C0268g extends SurfaceView implements InterfaceC0342b {

    /* renamed from: a */
    private final boolean f342a;

    /* renamed from: b */
    private boolean f343b;

    /* renamed from: c */
    private boolean f344c;

    /* renamed from: d */
    private boolean f345d;

    /* renamed from: e */
    private FlutterRenderer f346e;

    /* renamed from: f */
    private final SurfaceHolder.Callback f347f;

    /* renamed from: g */
    private final InterfaceC0341a f348g;

    /* renamed from: io.flutter.embedding.android.g$a */
    /* loaded from: classes.dex */
    class SurfaceHolder$CallbackC0269a implements SurfaceHolder.Callback {
        SurfaceHolder$CallbackC0269a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            C0576b.m737f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (C0268g.this.f345d) {
                C0268g.this.m1715j(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            C0576b.m737f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            C0268g.this.f343b = true;
            if (C0268g.this.f345d) {
                C0268g.this.m1714k();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            C0576b.m737f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            C0268g.this.f343b = false;
            if (C0268g.this.f345d) {
                C0268g.this.m1713l();
            }
        }
    }

    /* renamed from: io.flutter.embedding.android.g$b */
    /* loaded from: classes.dex */
    class C0270b implements InterfaceC0341a {
        C0270b() {
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: d */
        public void mo1527d() {
            C0576b.m737f("FlutterSurfaceView", "onFlutterUiDisplayed()");
            C0268g.this.setAlpha(1.0f);
            if (C0268g.this.f346e != null) {
                C0268g.this.f346e.m1539t(this);
            }
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: g */
        public void mo1526g() {
        }
    }

    private C0268g(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.f343b = false;
        this.f344c = false;
        this.f345d = false;
        this.f347f = new SurfaceHolder$CallbackC0269a();
        this.f348g = new C0270b();
        this.f342a = z;
        m1712m();
    }

    public C0268g(Context context, boolean z) {
        this(context, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m1715j(int i, int i2) {
        if (this.f346e == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        C0576b.m737f("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.f346e.m1534y(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m1714k() {
        if (this.f346e == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f346e.m1536w(getHolder().getSurface(), this.f344c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m1713l() {
        FlutterRenderer flutterRenderer = this.f346e;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.m1535x();
    }

    /* renamed from: m */
    private void m1712m() {
        if (this.f342a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f347f);
        setAlpha(0.0f);
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: a */
    public void mo1525a(FlutterRenderer flutterRenderer) {
        C0576b.m737f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f346e != null) {
            C0576b.m737f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f346e.m1535x();
            this.f346e.m1539t(this.f348g);
        }
        this.f346e = flutterRenderer;
        this.f345d = true;
        flutterRenderer.m1550i(this.f348g);
        if (this.f343b) {
            C0576b.m737f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m1714k();
        }
        this.f344c = false;
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: b */
    public void mo1524b() {
        if (this.f346e == null) {
            C0576b.m736g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f346e = null;
        this.f344c = true;
        this.f345d = false;
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: c */
    public void mo1523c() {
        if (this.f346e == null) {
            C0576b.m736g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            C0576b.m737f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            m1713l();
        }
        setAlpha(0.0f);
        this.f346e.m1539t(this.f348g);
        this.f346e = null;
        this.f345d = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    public FlutterRenderer getAttachedRenderer() {
        return this.f346e;
    }
}