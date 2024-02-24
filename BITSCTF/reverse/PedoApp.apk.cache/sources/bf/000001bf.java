package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Keep;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import p031o.C0576b;

/* loaded from: classes.dex */
public class FlutterRenderer implements TextureRegistry {

    /* renamed from: a */
    private final FlutterJNI f529a;

    /* renamed from: c */
    private Surface f531c;

    /* renamed from: h */
    private final InterfaceC0341a f536h;

    /* renamed from: b */
    private final AtomicLong f530b = new AtomicLong(0);

    /* renamed from: d */
    private boolean f532d = false;

    /* renamed from: e */
    private int f533e = 0;

    /* renamed from: f */
    private Handler f534f = new Handler();

    /* renamed from: g */
    private final Set<WeakReference<TextureRegistry.InterfaceC0404b>> f535g = new HashSet();

    @Keep
    /* loaded from: classes.dex */
    final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry {
        private static final String TAG = "ImageTextureRegistryEntry";

        /* renamed from: id */
        private final long f537id;
        private Image image;
        private boolean released;

        ImageTextureRegistryEntry(long j) {
            this.f537id = j;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public Image acquireLatestImage() {
            Image image;
            synchronized (this) {
                image = this.image;
                this.image = null;
            }
            return image;
        }

        @TargetApi(19)
        protected void finalize() {
            try {
                if (this.released) {
                    return;
                }
                Image image = this.image;
                if (image != null) {
                    image.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer.this.f534f.post(new RunnableC0339f(this.f537id, FlutterRenderer.this.f529a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        /* renamed from: id */
        public long mo1266id() {
            return this.f537id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        @TargetApi(19)
        public void pushImage(Image image) {
            Image image2;
            synchronized (this) {
                image2 = this.image;
                this.image = image;
            }
            if (image2 != null) {
                image2.close();
            }
            if (image != null) {
                FlutterRenderer.this.m1544o(this.f537id);
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        @TargetApi(19)
        public void release() {
            if (this.released) {
                return;
            }
            this.released = true;
            Image image = this.image;
            if (image != null) {
                image.close();
                this.image = null;
            }
            FlutterRenderer.this.m1557A(this.f537id);
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$a */
    /* loaded from: classes.dex */
    class C0332a implements InterfaceC0341a {
        C0332a() {
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: d */
        public void mo1527d() {
            FlutterRenderer.this.f532d = true;
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: g */
        public void mo1526g() {
            FlutterRenderer.this.f532d = false;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$b */
    /* loaded from: classes.dex */
    public static final class C0333b {

        /* renamed from: a */
        public final Rect f539a;

        /* renamed from: b */
        public final EnumC0335d f540b;

        /* renamed from: c */
        public final EnumC0334c f541c;

        public C0333b(Rect rect, EnumC0335d enumC0335d) {
            this.f539a = rect;
            this.f540b = enumC0335d;
            this.f541c = EnumC0334c.UNKNOWN;
        }

        public C0333b(Rect rect, EnumC0335d enumC0335d, EnumC0334c enumC0334c) {
            this.f539a = rect;
            this.f540b = enumC0335d;
            this.f541c = enumC0334c;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$c */
    /* loaded from: classes.dex */
    public enum EnumC0334c {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);
        

        /* renamed from: d */
        public final int f546d;

        EnumC0334c(int i) {
            this.f546d = i;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$d */
    /* loaded from: classes.dex */
    public enum EnumC0335d {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);
        

        /* renamed from: d */
        public final int f552d;

        EnumC0335d(int i) {
            this.f552d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$e */
    /* loaded from: classes.dex */
    public final class C0336e implements TextureRegistry.InterfaceC0405c, TextureRegistry.InterfaceC0404b {

        /* renamed from: a */
        private final long f553a;

        /* renamed from: b */
        private final SurfaceTextureWrapper f554b;

        /* renamed from: c */
        private boolean f555c;

        /* renamed from: d */
        private TextureRegistry.InterfaceC0404b f556d;

        /* renamed from: e */
        private TextureRegistry.InterfaceC0403a f557e;

        /* renamed from: f */
        private final Runnable f558f;

        /* renamed from: g */
        private SurfaceTexture.OnFrameAvailableListener f559g;

        /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$e$a */
        /* loaded from: classes.dex */
        class RunnableC0337a implements Runnable {
            RunnableC0337a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0336e.this.f557e != null) {
                    C0336e.this.f557e.mo1265a();
                }
            }
        }

        /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$e$b */
        /* loaded from: classes.dex */
        class C0338b implements SurfaceTexture.OnFrameAvailableListener {
            C0338b() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (C0336e.this.f555c || !FlutterRenderer.this.f529a.isAttached()) {
                    return;
                }
                C0336e c0336e = C0336e.this;
                FlutterRenderer.this.m1544o(c0336e.f553a);
            }
        }

        C0336e(long j, SurfaceTexture surfaceTexture) {
            RunnableC0337a runnableC0337a = new RunnableC0337a();
            this.f558f = runnableC0337a;
            this.f559g = new C0338b();
            this.f553a = j;
            this.f554b = new SurfaceTextureWrapper(surfaceTexture, runnableC0337a);
            if (Build.VERSION.SDK_INT >= 21) {
                mo1262c().setOnFrameAvailableListener(this.f559g, new Handler());
            } else {
                mo1262c().setOnFrameAvailableListener(this.f559g);
            }
        }

        @Override // io.flutter.view.TextureRegistry.InterfaceC0405c
        /* renamed from: a */
        public void mo1264a(TextureRegistry.InterfaceC0404b interfaceC0404b) {
            this.f556d = interfaceC0404b;
        }

        @Override // io.flutter.view.TextureRegistry.InterfaceC0405c
        /* renamed from: b */
        public void mo1263b(TextureRegistry.InterfaceC0403a interfaceC0403a) {
            this.f557e = interfaceC0403a;
        }

        @Override // io.flutter.view.TextureRegistry.InterfaceC0405c
        /* renamed from: c */
        public SurfaceTexture mo1262c() {
            return this.f554b.surfaceTexture();
        }

        protected void finalize() {
            try {
                if (this.f555c) {
                    return;
                }
                FlutterRenderer.this.f534f.post(new RunnableC0339f(this.f553a, FlutterRenderer.this.f529a));
            } finally {
                super.finalize();
            }
        }

        /* renamed from: g */
        public SurfaceTextureWrapper m1529g() {
            return this.f554b;
        }

        @Override // io.flutter.view.TextureRegistry.InterfaceC0405c
        /* renamed from: id */
        public long mo1261id() {
            return this.f553a;
        }

        @Override // io.flutter.view.TextureRegistry.InterfaceC0404b
        public void onTrimMemory(int i) {
            TextureRegistry.InterfaceC0404b interfaceC0404b = this.f556d;
            if (interfaceC0404b != null) {
                interfaceC0404b.onTrimMemory(i);
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$f */
    /* loaded from: classes.dex */
    static final class RunnableC0339f implements Runnable {

        /* renamed from: d */
        private final long f563d;

        /* renamed from: e */
        private final FlutterJNI f564e;

        RunnableC0339f(long j, FlutterJNI flutterJNI) {
            this.f563d = j;
            this.f564e = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f564e.isAttached()) {
                C0576b.m737f("FlutterRenderer", "Releasing a Texture (" + this.f563d + ").");
                this.f564e.unregisterTexture(this.f563d);
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$g */
    /* loaded from: classes.dex */
    public static final class C0340g {

        /* renamed from: a */
        public float f565a = 1.0f;

        /* renamed from: b */
        public int f566b = 0;

        /* renamed from: c */
        public int f567c = 0;

        /* renamed from: d */
        public int f568d = 0;

        /* renamed from: e */
        public int f569e = 0;

        /* renamed from: f */
        public int f570f = 0;

        /* renamed from: g */
        public int f571g = 0;

        /* renamed from: h */
        public int f572h = 0;

        /* renamed from: i */
        public int f573i = 0;

        /* renamed from: j */
        public int f574j = 0;

        /* renamed from: k */
        public int f575k = 0;

        /* renamed from: l */
        public int f576l = 0;

        /* renamed from: m */
        public int f577m = 0;

        /* renamed from: n */
        public int f578n = 0;

        /* renamed from: o */
        public int f579o = 0;

        /* renamed from: p */
        public int f580p = -1;

        /* renamed from: q */
        public List<C0333b> f581q = new ArrayList();

        /* renamed from: a */
        boolean m1528a() {
            return this.f566b > 0 && this.f567c > 0 && this.f565a > 0.0f;
        }
    }

    public FlutterRenderer(FlutterJNI flutterJNI) {
        C0332a c0332a = new C0332a();
        this.f536h = c0332a;
        this.f529a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(c0332a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m1557A(long j) {
        this.f529a.unregisterTexture(j);
    }

    /* renamed from: k */
    private void m1548k() {
        Iterator<WeakReference<TextureRegistry.InterfaceC0404b>> it = this.f535g.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m1544o(long j) {
        this.f529a.markTextureFrameAvailable(j);
    }

    /* renamed from: q */
    private void m1542q(long j, TextureRegistry.ImageTextureEntry imageTextureEntry) {
        this.f529a.registerImageTexture(j, imageTextureEntry);
    }

    /* renamed from: s */
    private void m1540s(long j, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f529a.registerTexture(j, surfaceTextureWrapper);
    }

    @Override // io.flutter.view.TextureRegistry
    /* renamed from: a */
    public TextureRegistry.ImageTextureEntry mo1268a() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.f530b.getAndIncrement());
        C0576b.m737f("FlutterRenderer", "New ImageTextureEntry ID: " + imageTextureRegistryEntry.mo1266id());
        m1542q(imageTextureRegistryEntry.mo1266id(), imageTextureRegistryEntry);
        return imageTextureRegistryEntry;
    }

    @Override // io.flutter.view.TextureRegistry
    /* renamed from: b */
    public TextureRegistry.InterfaceC0405c mo1267b() {
        C0576b.m737f("FlutterRenderer", "Creating a SurfaceTexture.");
        return m1541r(new SurfaceTexture(0));
    }

    /* renamed from: c */
    public void m1556c(boolean z) {
        this.f533e = z ? this.f533e + 1 : this.f533e - 1;
        this.f529a.SetIsRenderingToImageView(this.f533e > 0);
    }

    /* renamed from: i */
    public void m1550i(InterfaceC0341a interfaceC0341a) {
        this.f529a.addIsDisplayingFlutterUiListener(interfaceC0341a);
        if (this.f532d) {
            interfaceC0341a.mo1527d();
        }
    }

    /* renamed from: j */
    void m1549j(TextureRegistry.InterfaceC0404b interfaceC0404b) {
        m1548k();
        this.f535g.add(new WeakReference<>(interfaceC0404b));
    }

    /* renamed from: l */
    public void m1547l(ByteBuffer byteBuffer, int i) {
        this.f529a.dispatchPointerDataPacket(byteBuffer, i);
    }

    /* renamed from: m */
    public boolean m1546m() {
        return this.f532d;
    }

    /* renamed from: n */
    public boolean m1545n() {
        return this.f529a.getIsSoftwareRenderingEnabled();
    }

    /* renamed from: p */
    public void m1543p(int i) {
        Iterator<WeakReference<TextureRegistry.InterfaceC0404b>> it = this.f535g.iterator();
        while (it.hasNext()) {
            TextureRegistry.InterfaceC0404b interfaceC0404b = it.next().get();
            if (interfaceC0404b != null) {
                interfaceC0404b.onTrimMemory(i);
            } else {
                it.remove();
            }
        }
    }

    /* renamed from: r */
    public TextureRegistry.InterfaceC0405c m1541r(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        C0336e c0336e = new C0336e(this.f530b.getAndIncrement(), surfaceTexture);
        C0576b.m737f("FlutterRenderer", "New SurfaceTexture ID: " + c0336e.mo1261id());
        m1540s(c0336e.mo1261id(), c0336e.m1529g());
        m1549j(c0336e);
        return c0336e;
    }

    /* renamed from: t */
    public void m1539t(InterfaceC0341a interfaceC0341a) {
        this.f529a.removeIsDisplayingFlutterUiListener(interfaceC0341a);
    }

    /* renamed from: u */
    public void m1538u(boolean z) {
        this.f529a.setSemanticsEnabled(z);
    }

    /* renamed from: v */
    public void m1537v(C0340g c0340g) {
        if (c0340g.m1528a()) {
            C0576b.m737f("FlutterRenderer", "Setting viewport metrics\nSize: " + c0340g.f566b + " x " + c0340g.f567c + "\nPadding - L: " + c0340g.f571g + ", T: " + c0340g.f568d + ", R: " + c0340g.f569e + ", B: " + c0340g.f570f + "\nInsets - L: " + c0340g.f575k + ", T: " + c0340g.f572h + ", R: " + c0340g.f573i + ", B: " + c0340g.f574j + "\nSystem Gesture Insets - L: " + c0340g.f579o + ", T: " + c0340g.f576l + ", R: " + c0340g.f577m + ", B: " + c0340g.f577m + "\nDisplay Features: " + c0340g.f581q.size());
            int[] iArr = new int[c0340g.f581q.size() * 4];
            int[] iArr2 = new int[c0340g.f581q.size()];
            int[] iArr3 = new int[c0340g.f581q.size()];
            for (int i = 0; i < c0340g.f581q.size(); i++) {
                C0333b c0333b = c0340g.f581q.get(i);
                int i2 = i * 4;
                Rect rect = c0333b.f539a;
                iArr[i2] = rect.left;
                iArr[i2 + 1] = rect.top;
                iArr[i2 + 2] = rect.right;
                iArr[i2 + 3] = rect.bottom;
                iArr2[i] = c0333b.f540b.f552d;
                iArr3[i] = c0333b.f541c.f546d;
            }
            this.f529a.setViewportMetrics(c0340g.f565a, c0340g.f566b, c0340g.f567c, c0340g.f568d, c0340g.f569e, c0340g.f570f, c0340g.f571g, c0340g.f572h, c0340g.f573i, c0340g.f574j, c0340g.f575k, c0340g.f576l, c0340g.f577m, c0340g.f578n, c0340g.f579o, c0340g.f580p, iArr, iArr2, iArr3);
        }
    }

    /* renamed from: w */
    public void m1536w(Surface surface, boolean z) {
        if (this.f531c != null && !z) {
            m1535x();
        }
        this.f531c = surface;
        this.f529a.onSurfaceCreated(surface);
    }

    /* renamed from: x */
    public void m1535x() {
        if (this.f531c != null) {
            this.f529a.onSurfaceDestroyed();
            if (this.f532d) {
                this.f536h.mo1526g();
            }
            this.f532d = false;
            this.f531c = null;
        }
    }

    /* renamed from: y */
    public void m1534y(int i, int i2) {
        this.f529a.onSurfaceChanged(i, i2);
    }

    /* renamed from: z */
    public void m1533z(Surface surface) {
        this.f531c = surface;
        this.f529a.onSurfaceWindowChanged(surface);
    }
}