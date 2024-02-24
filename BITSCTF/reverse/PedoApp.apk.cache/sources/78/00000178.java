package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.InterfaceC0342b;
import java.nio.ByteBuffer;
import java.util.Locale;
import p031o.C0576b;

@TargetApi(19)
/* renamed from: io.flutter.embedding.android.f */
/* loaded from: classes.dex */
public class C0265f extends View implements InterfaceC0342b {

    /* renamed from: a */
    private ImageReader f332a;

    /* renamed from: b */
    private Image f333b;

    /* renamed from: c */
    private Bitmap f334c;

    /* renamed from: d */
    private FlutterRenderer f335d;

    /* renamed from: e */
    private EnumC0267b f336e;

    /* renamed from: f */
    private boolean f337f;

    /* renamed from: io.flutter.embedding.android.f$a */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0266a {

        /* renamed from: a */
        static final /* synthetic */ int[] f338a;

        static {
            int[] iArr = new int[EnumC0267b.values().length];
            f338a = iArr;
            try {
                iArr[EnumC0267b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f338a[EnumC0267b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: io.flutter.embedding.android.f$b */
    /* loaded from: classes.dex */
    public enum EnumC0267b {
        background,
        overlay
    }

    public C0265f(Context context, int i, int i2, EnumC0267b enumC0267b) {
        this(context, m1726g(i, i2), enumC0267b);
    }

    C0265f(Context context, ImageReader imageReader, EnumC0267b enumC0267b) {
        super(context, null);
        this.f337f = false;
        this.f332a = imageReader;
        this.f336e = enumC0267b;
        m1725h();
    }

    /* renamed from: e */
    private void m1728e() {
        Image image = this.f333b;
        if (image != null) {
            image.close();
            this.f333b = null;
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(19)
    /* renamed from: g */
    private static ImageReader m1726g(int i, int i2) {
        int i3;
        int i4;
        if (i <= 0) {
            m1724i("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i));
            i3 = 1;
        } else {
            i3 = i;
        }
        if (i2 <= 0) {
            m1724i("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i2));
            i4 = 1;
        } else {
            i4 = i2;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i3, i4, 1, 3, 768L) : ImageReader.newInstance(i3, i4, 1, 3);
    }

    /* renamed from: h */
    private void m1725h() {
        setAlpha(0.0f);
    }

    /* renamed from: i */
    private static void m1724i(String str, Object... objArr) {
        C0576b.m736g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    @TargetApi(29)
    /* renamed from: k */
    private void m1722k() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f333b.getHardwareBuffer();
            this.f334c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f333b.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f333b.getHeight();
        Bitmap bitmap = this.f334c;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f334c.getHeight() != height) {
            this.f334c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f334c.copyPixelsFromBuffer(buffer);
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: a */
    public void mo1525a(FlutterRenderer flutterRenderer) {
        if (C0266a.f338a[this.f336e.ordinal()] == 1) {
            flutterRenderer.m1533z(this.f332a.getSurface());
            flutterRenderer.m1556c(true);
        }
        setAlpha(1.0f);
        this.f335d = flutterRenderer;
        this.f337f = true;
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: b */
    public void mo1524b() {
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    /* renamed from: c */
    public void mo1523c() {
        if (this.f337f) {
            setAlpha(0.0f);
            m1729d();
            this.f334c = null;
            m1728e();
            invalidate();
            this.f337f = false;
            if (this.f336e == EnumC0267b.background) {
                this.f335d.m1556c(false);
            }
        }
    }

    @TargetApi(19)
    /* renamed from: d */
    public boolean m1729d() {
        if (this.f337f) {
            Image acquireLatestImage = this.f332a.acquireLatestImage();
            if (acquireLatestImage != null) {
                m1728e();
                this.f333b = acquireLatestImage;
                invalidate();
            }
            return acquireLatestImage != null;
        }
        return false;
    }

    /* renamed from: f */
    public void m1727f() {
        this.f332a.close();
    }

    @Override // io.flutter.embedding.engine.renderer.InterfaceC0342b
    public FlutterRenderer getAttachedRenderer() {
        return this.f335d;
    }

    public ImageReader getImageReader() {
        return this.f332a;
    }

    public Surface getSurface() {
        return this.f332a.getSurface();
    }

    /* renamed from: j */
    public void m1723j(int i, int i2) {
        if (this.f335d == null) {
            return;
        }
        if (i == this.f332a.getWidth() && i2 == this.f332a.getHeight()) {
            return;
        }
        m1728e();
        m1727f();
        this.f332a = m1726g(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f333b != null) {
            m1722k();
        }
        Bitmap bitmap = this.f334c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == this.f332a.getWidth() && i2 == this.f332a.getHeight()) && this.f336e == EnumC0267b.background && this.f337f) {
            m1723j(i, i2);
            this.f335d.m1533z(this.f332a.getSurface());
        }
    }
}