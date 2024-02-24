package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.C0256a;
import io.flutter.embedding.android.C0274j;
import io.flutter.embedding.android.C0305t;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.editing.C0354f;
import io.flutter.plugin.platform.C0390r;
import io.flutter.view.C0408c;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import p012e0.C0146h;
import p031o.C0576b;
import p033p.C0579a;
import p039s.C0638a;
import p053z.C0876l;

/* renamed from: io.flutter.plugin.platform.r */
/* loaded from: classes.dex */
public class C0390r implements InterfaceC0384l {

    /* renamed from: w */
    private static Class[] f710w = {SurfaceView.class};

    /* renamed from: x */
    private static boolean f711x = false;

    /* renamed from: b */
    private C0256a f713b;

    /* renamed from: c */
    private Context f714c;

    /* renamed from: d */
    private C0274j f715d;

    /* renamed from: e */
    private TextureRegistry f716e;

    /* renamed from: f */
    private C0354f f717f;

    /* renamed from: g */
    private C0876l f718g;

    /* renamed from: o */
    private int f726o = 0;

    /* renamed from: p */
    private boolean f727p = false;

    /* renamed from: q */
    private boolean f728q = true;

    /* renamed from: u */
    private boolean f732u = false;

    /* renamed from: v */
    private final C0876l.InterfaceC0884g f733v = new C0391a();

    /* renamed from: a */
    private final C0380i f712a = new C0380i();

    /* renamed from: i */
    final HashMap<Integer, C0395t> f720i = new HashMap<>();

    /* renamed from: h */
    private final C0367a f719h = new C0367a();

    /* renamed from: j */
    final HashMap<Context, View> f721j = new HashMap<>();

    /* renamed from: m */
    private final SparseArray<C0370c> f724m = new SparseArray<>();

    /* renamed from: r */
    private final HashSet<Integer> f729r = new HashSet<>();

    /* renamed from: s */
    private final HashSet<Integer> f730s = new HashSet<>();

    /* renamed from: n */
    private final SparseArray<C0382k> f725n = new SparseArray<>();

    /* renamed from: k */
    private final SparseArray<InterfaceC0377f> f722k = new SparseArray<>();

    /* renamed from: l */
    private final SparseArray<C0638a> f723l = new SparseArray<>();

    /* renamed from: t */
    private final C0305t f731t = C0305t.m1639a();

    /* renamed from: io.flutter.plugin.platform.r$a */
    /* loaded from: classes.dex */
    public class C0391a implements C0876l.InterfaceC0884g {
        C0391a() {
            C0390r.this = r1;
        }

        /* renamed from: k */
        public /* synthetic */ void m1304k(C0395t c0395t, float f, C0876l.InterfaceC0878b interfaceC0878b) {
            C0390r.this.m1309x0(c0395t);
            if (C0390r.this.f714c != null) {
                f = C0390r.this.m1361V();
            }
            interfaceC0878b.mo86a(new C0876l.C0879c(C0390r.this.m1315u0(c0395t.m1286e(), f), C0390r.this.m1315u0(c0395t.m1287d(), f)));
        }

        @Override // p053z.C0876l.InterfaceC0884g
        /* renamed from: a */
        public void mo85a(int i) {
            View m1389g;
            StringBuilder sb;
            String str;
            if (C0390r.this.mo1350d(i)) {
                m1389g = C0390r.this.f720i.get(Integer.valueOf(i)).m1285f();
            } else {
                InterfaceC0377f interfaceC0377f = (InterfaceC0377f) C0390r.this.f722k.get(i);
                if (interfaceC0377f == null) {
                    sb = new StringBuilder();
                    str = "Clearing focus on an unknown view with id: ";
                    sb.append(str);
                    sb.append(i);
                    C0576b.m741b("PlatformViewsController", sb.toString());
                }
                m1389g = interfaceC0377f.m1389g();
            }
            if (m1389g != null) {
                m1389g.clearFocus();
                return;
            }
            sb = new StringBuilder();
            str = "Clearing focus on a null view with id: ";
            sb.append(str);
            sb.append(i);
            C0576b.m741b("PlatformViewsController", sb.toString());
        }

        @Override // p053z.C0876l.InterfaceC0884g
        /* renamed from: b */
        public void mo84b(C0876l.C0882e c0882e, final C0876l.InterfaceC0878b interfaceC0878b) {
            int m1311w0 = C0390r.this.m1311w0(c0882e.f1565b);
            int m1311w02 = C0390r.this.m1311w0(c0882e.f1566c);
            int i = c0882e.f1564a;
            if (C0390r.this.mo1350d(i)) {
                final float m1361V = C0390r.this.m1361V();
                final C0395t c0395t = C0390r.this.f720i.get(Integer.valueOf(i));
                C0390r.this.m1349d0(c0395t);
                c0395t.m1282i(m1311w0, m1311w02, new Runnable() { // from class: io.flutter.plugin.platform.q
                    {
                        C0390r.C0391a.this = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C0390r.C0391a.this.m1304k(c0395t, m1361V, interfaceC0878b);
                    }
                });
                return;
            }
            InterfaceC0377f interfaceC0377f = (InterfaceC0377f) C0390r.this.f722k.get(i);
            C0382k c0382k = (C0382k) C0390r.this.f725n.get(i);
            if (interfaceC0377f == null || c0382k == null) {
                C0576b.m741b("PlatformViewsController", "Resizing unknown platform view with id: " + i);
                return;
            }
            if (m1311w0 > c0382k.getRenderTargetWidth() || m1311w02 > c0382k.getRenderTargetHeight()) {
                c0382k.m1384b(m1311w0, m1311w02);
            }
            ViewGroup.LayoutParams layoutParams = c0382k.getLayoutParams();
            layoutParams.width = m1311w0;
            layoutParams.height = m1311w02;
            c0382k.setLayoutParams(layoutParams);
            View m1389g = interfaceC0377f.m1389g();
            if (m1389g != null) {
                ViewGroup.LayoutParams layoutParams2 = m1389g.getLayoutParams();
                layoutParams2.width = m1311w0;
                layoutParams2.height = m1311w02;
                m1389g.setLayoutParams(layoutParams2);
            }
            interfaceC0878b.mo86a(new C0876l.C0879c(C0390r.this.m1317t0(c0382k.getRenderTargetWidth()), C0390r.this.m1317t0(c0382k.getRenderTargetHeight())));
        }

        @Override // p053z.C0876l.InterfaceC0884g
        /* renamed from: c */
        public void mo83c(int i) {
            InterfaceC0377f interfaceC0377f = (InterfaceC0377f) C0390r.this.f722k.get(i);
            if (interfaceC0377f == null) {
                C0576b.m741b("PlatformViewsController", "Disposing unknown platform view with id: " + i);
                return;
            }
            if (interfaceC0377f.m1389g() != null) {
                View m1389g = interfaceC0377f.m1389g();
                ViewGroup viewGroup = (ViewGroup) m1389g.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(m1389g);
                }
            }
            C0390r.this.f722k.remove(i);
            try {
                interfaceC0377f.m1394b();
            } catch (RuntimeException e) {
                C0576b.m740c("PlatformViewsController", "Disposing platform view threw an exception", e);
            }
            if (C0390r.this.mo1350d(i)) {
                C0395t c0395t = C0390r.this.f720i.get(Integer.valueOf(i));
                View m1285f = c0395t.m1285f();
                if (m1285f != null) {
                    C0390r.this.f721j.remove(m1285f.getContext());
                }
                c0395t.m1288c();
                C0390r.this.f720i.remove(Integer.valueOf(i));
                return;
            }
            C0382k c0382k = (C0382k) C0390r.this.f725n.get(i);
            if (c0382k != null) {
                c0382k.removeAllViews();
                c0382k.m1385a();
                c0382k.m1383c();
                ViewGroup viewGroup2 = (ViewGroup) c0382k.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(c0382k);
                }
                C0390r.this.f725n.remove(i);
                return;
            }
            C0638a c0638a = (C0638a) C0390r.this.f723l.get(i);
            if (c0638a != null) {
                c0638a.removeAllViews();
                c0638a.m664b();
                ViewGroup viewGroup3 = (ViewGroup) c0638a.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(c0638a);
                }
                C0390r.this.f723l.remove(i);
            }
        }

        @Override // p053z.C0876l.InterfaceC0884g
        /* renamed from: d */
        public void mo82d(boolean z) {
            C0390r.this.f728q = z;
        }

        @Override // p053z.C0876l.InterfaceC0884g
        @TargetApi(19)
        /* renamed from: e */
        public void mo81e(C0876l.C0880d c0880d) {
            C0390r.this.m1364S(19);
            C0390r.this.m1363T(c0880d);
            C0390r.this.m1375H(C0390r.this.m1370M(c0880d, false), c0880d);
        }

        @Override // p053z.C0876l.InterfaceC0884g
        /* renamed from: f */
        public void mo80f(C0876l.C0883f c0883f) {
            int i = c0883f.f1567a;
            float f = C0390r.this.f714c.getResources().getDisplayMetrics().density;
            if (C0390r.this.mo1350d(i)) {
                C0390r.this.f720i.get(Integer.valueOf(i)).m1289b(C0390r.this.m1313v0(f, c0883f, true));
                return;
            }
            InterfaceC0377f interfaceC0377f = (InterfaceC0377f) C0390r.this.f722k.get(i);
            if (interfaceC0377f == null) {
                C0576b.m741b("PlatformViewsController", "Sending touch to an unknown view with id: " + i);
                return;
            }
            View m1389g = interfaceC0377f.m1389g();
            if (m1389g != null) {
                m1389g.dispatchTouchEvent(C0390r.this.m1313v0(f, c0883f, false));
                return;
            }
            C0576b.m741b("PlatformViewsController", "Sending touch to a null view with id: " + i);
        }

        @Override // p053z.C0876l.InterfaceC0884g
        /* renamed from: g */
        public void mo79g(int i, double d, double d2) {
            if (C0390r.this.mo1350d(i)) {
                return;
            }
            C0382k c0382k = (C0382k) C0390r.this.f725n.get(i);
            if (c0382k == null) {
                C0576b.m741b("PlatformViewsController", "Setting offset for unknown platform view with id: " + i);
                return;
            }
            int m1311w0 = C0390r.this.m1311w0(d);
            int m1311w02 = C0390r.this.m1311w0(d2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0382k.getLayoutParams();
            layoutParams.topMargin = m1311w0;
            layoutParams.leftMargin = m1311w02;
            c0382k.setLayoutParams(layoutParams);
        }

        @Override // p053z.C0876l.InterfaceC0884g
        @TargetApi(17)
        /* renamed from: h */
        public void mo78h(int i, int i2) {
            View m1389g;
            StringBuilder sb;
            String str;
            if (!C0390r.m1307y0(i2)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + ")");
            }
            if (C0390r.this.mo1350d(i)) {
                m1389g = C0390r.this.f720i.get(Integer.valueOf(i)).m1285f();
            } else {
                InterfaceC0377f interfaceC0377f = (InterfaceC0377f) C0390r.this.f722k.get(i);
                if (interfaceC0377f == null) {
                    sb = new StringBuilder();
                    str = "Setting direction to an unknown view with id: ";
                    sb.append(str);
                    sb.append(i);
                    C0576b.m741b("PlatformViewsController", sb.toString());
                }
                m1389g = interfaceC0377f.m1389g();
            }
            if (m1389g != null) {
                m1389g.setLayoutDirection(i2);
                return;
            }
            sb = new StringBuilder();
            str = "Setting direction to a null view with id: ";
            sb.append(str);
            sb.append(i);
            C0576b.m741b("PlatformViewsController", sb.toString());
        }

        @Override // p053z.C0876l.InterfaceC0884g
        @TargetApi(20)
        /* renamed from: i */
        public long mo77i(C0876l.C0880d c0880d) {
            C0390r.this.m1363T(c0880d);
            int i = c0880d.f1551a;
            if (C0390r.this.f725n.get(i) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i);
            } else if (C0390r.this.f716e == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i);
            } else if (C0390r.this.f715d == null) {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i);
            } else {
                boolean z = true;
                InterfaceC0377f m1370M = C0390r.this.m1370M(c0880d, true);
                View m1389g = m1370M.m1389g();
                if (m1389g.getParent() == null) {
                    if (!((Build.VERSION.SDK_INT < 23 || C0146h.m2024g(m1389g, C0390r.f710w)) ? false : false)) {
                        if (c0880d.f1558h == C0876l.C0880d.EnumC0881a.TEXTURE_WITH_HYBRID_FALLBACK) {
                            C0390r.this.m1375H(m1370M, c0880d);
                            return -2L;
                        } else if (!C0390r.this.f732u) {
                            return C0390r.this.m1373J(m1370M, c0880d);
                        }
                    }
                    return C0390r.this.m1374I(m1370M, c0880d);
                }
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    /* renamed from: H */
    public void m1375H(InterfaceC0377f interfaceC0377f, C0876l.C0880d c0880d) {
        m1364S(19);
        C0576b.m738e("PlatformViewsController", "Using hybrid composition for platform view: " + c0880d.f1551a);
    }

    /* renamed from: J */
    public long m1373J(InterfaceC0377f interfaceC0377f, final C0876l.C0880d c0880d) {
        m1364S(20);
        C0576b.m738e("PlatformViewsController", "Hosting view in a virtual display for platform view: " + c0880d.f1551a);
        InterfaceC0381j m1347e0 = m1347e0(this.f716e);
        C0395t m1290a = C0395t.m1290a(this.f714c, this.f719h, interfaceC0377f, m1347e0, m1311w0(c0880d.f1553c), m1311w0(c0880d.f1554d), c0880d.f1551a, null, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.n
            {
                C0390r.this = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C0390r.this.m1355a0(c0880d, view, z);
            }
        });
        if (m1290a != null) {
            this.f720i.put(Integer.valueOf(c0880d.f1551a), m1290a);
            View m1389g = interfaceC0377f.m1389g();
            this.f721j.put(m1389g.getContext(), m1389g);
            return m1347e0.mo1303a();
        }
        throw new IllegalStateException("Failed creating virtual display for a " + c0880d.f1552b + " with id: " + c0880d.f1551a);
    }

    /* renamed from: R */
    private void m1365R() {
        while (this.f722k.size() > 0) {
            this.f733v.mo83c(this.f722k.keyAt(0));
        }
    }

    /* renamed from: S */
    public void m1364S(int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= i) {
            return;
        }
        throw new IllegalStateException("Trying to use platform views with API " + i2 + ", required API level is: " + i);
    }

    /* renamed from: T */
    public void m1363T(C0876l.C0880d c0880d) {
        if (m1307y0(c0880d.f1557g)) {
            return;
        }
        throw new IllegalStateException("Trying to create a view with unknown direction value: " + c0880d.f1557g + "(view id: " + c0880d.f1551a + ")");
    }

    /* renamed from: U */
    private void m1362U(boolean z) {
        for (int i = 0; i < this.f724m.size(); i++) {
            int keyAt = this.f724m.keyAt(i);
            C0370c valueAt = this.f724m.valueAt(i);
            if (this.f729r.contains(Integer.valueOf(keyAt))) {
                this.f715d.m1687m(valueAt);
                z &= valueAt.m1729d();
            } else {
                if (!this.f727p) {
                    valueAt.mo1523c();
                }
                valueAt.setVisibility(8);
                this.f715d.removeView(valueAt);
            }
        }
        for (int i2 = 0; i2 < this.f723l.size(); i2++) {
            int keyAt2 = this.f723l.keyAt(i2);
            C0638a c0638a = this.f723l.get(keyAt2);
            if (!this.f730s.contains(Integer.valueOf(keyAt2)) || (!z && this.f728q)) {
                c0638a.setVisibility(8);
            } else {
                c0638a.setVisibility(0);
            }
        }
    }

    /* renamed from: V */
    public float m1361V() {
        return this.f714c.getResources().getDisplayMetrics().density;
    }

    /* renamed from: Y */
    private void m1358Y() {
        if (!this.f728q || this.f727p) {
            return;
        }
        this.f715d.m1684p();
        this.f727p = true;
    }

    /* renamed from: Z */
    public /* synthetic */ void m1357Z(C0876l.C0880d c0880d, View view, boolean z) {
        if (z) {
            this.f718g.m98d(c0880d.f1551a);
            return;
        }
        C0354f c0354f = this.f717f;
        if (c0354f != null) {
            c0354f.m1467l(c0880d.f1551a);
        }
    }

    /* renamed from: a0 */
    public /* synthetic */ void m1355a0(C0876l.C0880d c0880d, View view, boolean z) {
        if (z) {
            this.f718g.m98d(c0880d.f1551a);
        }
    }

    /* renamed from: b0 */
    public /* synthetic */ void m1353b0(int i, View view, boolean z) {
        if (z) {
            this.f718g.m98d(i);
            return;
        }
        C0354f c0354f = this.f717f;
        if (c0354f != null) {
            c0354f.m1467l(i);
        }
    }

    /* renamed from: c0 */
    public /* synthetic */ void m1351c0() {
        m1362U(false);
    }

    /* renamed from: d0 */
    public void m1349d0(C0395t c0395t) {
        C0354f c0354f = this.f717f;
        if (c0354f == null) {
            return;
        }
        c0354f.m1458u();
        c0395t.m1284g();
    }

    /* renamed from: e0 */
    private static InterfaceC0381j m1347e0(TextureRegistry textureRegistry) {
        return (!f711x || Build.VERSION.SDK_INT < 29) ? new C0392s(textureRegistry.mo1267b()) : new C0368b(textureRegistry.mo1268a());
    }

    /* renamed from: f0 */
    private void m1345f0(InterfaceC0377f interfaceC0377f) {
        C0274j c0274j = this.f715d;
        if (c0274j == null) {
            C0576b.m738e("PlatformViewsController", "null flutterView");
        } else {
            interfaceC0377f.m1391e(c0274j);
        }
    }

    /* renamed from: n0 */
    private static MotionEvent.PointerCoords m1329n0(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    /* renamed from: o0 */
    private static List<MotionEvent.PointerCoords> m1327o0(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(m1329n0(obj2, f));
        }
        return arrayList;
    }

    /* renamed from: p0 */
    private static MotionEvent.PointerProperties m1325p0(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    /* renamed from: q0 */
    private static List<MotionEvent.PointerProperties> m1323q0(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(m1325p0(obj2));
        }
        return arrayList;
    }

    /* renamed from: r0 */
    private void m1321r0() {
        if (this.f715d == null) {
            C0576b.m741b("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i = 0; i < this.f724m.size(); i++) {
            this.f715d.removeView(this.f724m.valueAt(i));
        }
        this.f724m.clear();
    }

    /* renamed from: t0 */
    public int m1317t0(double d) {
        return m1315u0(d, m1361V());
    }

    /* renamed from: u0 */
    public int m1315u0(double d, float f) {
        double d2 = f;
        Double.isNaN(d2);
        return (int) Math.round(d / d2);
    }

    /* renamed from: w0 */
    public int m1311w0(double d) {
        double m1361V = m1361V();
        Double.isNaN(m1361V);
        return (int) Math.round(d * m1361V);
    }

    /* renamed from: x0 */
    public void m1309x0(C0395t c0395t) {
        C0354f c0354f = this.f717f;
        if (c0354f == null) {
            return;
        }
        c0354f.m1480H();
        c0395t.m1283h();
    }

    /* renamed from: y0 */
    public static boolean m1307y0(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: C */
    public void m1380C(Context context, TextureRegistry textureRegistry, C0579a c0579a) {
        if (this.f714c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.f714c = context;
        this.f716e = textureRegistry;
        C0876l c0876l = new C0876l(c0579a);
        this.f718g = c0876l;
        c0876l.m97e(this.f733v);
    }

    /* renamed from: D */
    public void m1379D(C0354f c0354f) {
        this.f717f = c0354f;
    }

    /* renamed from: E */
    public void m1378E(FlutterRenderer flutterRenderer) {
        this.f713b = new C0256a(flutterRenderer, true);
    }

    /* renamed from: F */
    public void m1377F(C0274j c0274j) {
        this.f715d = c0274j;
        for (int i = 0; i < this.f725n.size(); i++) {
            this.f715d.addView(this.f725n.valueAt(i));
        }
        for (int i2 = 0; i2 < this.f723l.size(); i2++) {
            this.f715d.addView(this.f723l.valueAt(i2));
        }
        for (int i3 = 0; i3 < this.f722k.size(); i3++) {
            this.f722k.valueAt(i3).m1391e(this.f715d);
        }
    }

    /* renamed from: G */
    public boolean m1376G(View view) {
        if (view != null && this.f721j.containsKey(view.getContext())) {
            View view2 = this.f721j.get(view.getContext());
            if (view2 == view) {
                return true;
            }
            return view2.checkInputConnectionProxy(view);
        }
        return false;
    }

    @TargetApi(23)
    /* renamed from: I */
    public long m1374I(InterfaceC0377f interfaceC0377f, final C0876l.C0880d c0880d) {
        C0382k c0382k;
        long j;
        m1364S(23);
        C0576b.m738e("PlatformViewsController", "Hosting view in view hierarchy for platform view: " + c0880d.f1551a);
        int m1311w0 = m1311w0(c0880d.f1553c);
        int m1311w02 = m1311w0(c0880d.f1554d);
        if (this.f732u) {
            c0382k = new C0382k(this.f714c);
            j = -1;
        } else {
            InterfaceC0381j m1347e0 = m1347e0(this.f716e);
            C0382k c0382k2 = new C0382k(this.f714c, m1347e0);
            long mo1303a = m1347e0.mo1303a();
            c0382k = c0382k2;
            j = mo1303a;
        }
        c0382k.setTouchProcessor(this.f713b);
        c0382k.m1384b(m1311w0, m1311w02);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m1311w0, m1311w02);
        int m1311w03 = m1311w0(c0880d.f1555e);
        int m1311w04 = m1311w0(c0880d.f1556f);
        layoutParams.topMargin = m1311w03;
        layoutParams.leftMargin = m1311w04;
        c0382k.setLayoutParams(layoutParams);
        View m1389g = interfaceC0377f.m1389g();
        m1389g.setLayoutParams(new FrameLayout.LayoutParams(m1311w0, m1311w02));
        m1389g.setImportantForAccessibility(4);
        c0382k.addView(m1389g);
        c0382k.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.o
            {
                C0390r.this = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C0390r.this.m1357Z(c0880d, view, z);
            }
        });
        this.f715d.addView(c0382k);
        this.f725n.append(c0880d.f1551a, c0382k);
        m1345f0(interfaceC0377f);
        return j;
    }

    @TargetApi(19)
    /* renamed from: K */
    public FlutterOverlaySurface m1372K() {
        return m1371L(new C0370c(this.f715d.getContext(), this.f715d.getWidth(), this.f715d.getHeight(), this.f719h));
    }

    @TargetApi(19)
    /* renamed from: L */
    public FlutterOverlaySurface m1371L(C0370c c0370c) {
        int i = this.f726o;
        this.f726o = i + 1;
        this.f724m.put(i, c0370c);
        return new FlutterOverlaySurface(i, c0370c.getSurface());
    }

    @TargetApi(19)
    /* renamed from: M */
    public InterfaceC0377f m1370M(C0876l.C0880d c0880d, boolean z) {
        AbstractC0378g m1386a = this.f712a.m1386a(c0880d.f1552b);
        if (m1386a == null) {
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + c0880d.f1552b);
        }
        InterfaceC0377f m1388a = m1386a.m1388a(z ? new MutableContextWrapper(this.f714c) : this.f714c, c0880d.f1551a, c0880d.f1559i != null ? m1386a.m1387b().mo2243a(c0880d.f1559i) : null);
        View m1389g = m1388a.m1389g();
        if (m1389g != null) {
            m1389g.setLayoutDirection(c0880d.f1557g);
            this.f722k.put(c0880d.f1551a, m1388a);
            m1345f0(m1388a);
            return m1388a;
        }
        throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
    }

    /* renamed from: N */
    public void m1369N() {
        for (int i = 0; i < this.f724m.size(); i++) {
            C0370c valueAt = this.f724m.valueAt(i);
            valueAt.mo1523c();
            valueAt.m1727f();
        }
    }

    /* renamed from: O */
    public void m1368O() {
        C0876l c0876l = this.f718g;
        if (c0876l != null) {
            c0876l.m97e(null);
        }
        m1369N();
        this.f718g = null;
        this.f714c = null;
        this.f716e = null;
    }

    /* renamed from: P */
    public void m1367P() {
        for (int i = 0; i < this.f725n.size(); i++) {
            this.f715d.removeView(this.f725n.valueAt(i));
        }
        for (int i2 = 0; i2 < this.f723l.size(); i2++) {
            this.f715d.removeView(this.f723l.valueAt(i2));
        }
        m1369N();
        m1321r0();
        this.f715d = null;
        this.f727p = false;
        for (int i3 = 0; i3 < this.f722k.size(); i3++) {
            this.f722k.valueAt(i3).m1390f();
        }
    }

    /* renamed from: Q */
    public void m1366Q() {
        this.f717f = null;
    }

    /* renamed from: W */
    public InterfaceC0379h m1360W() {
        return this.f712a;
    }

    @TargetApi(19)
    /* renamed from: X */
    void m1359X(final int i) {
        InterfaceC0377f interfaceC0377f = this.f722k.get(i);
        if (interfaceC0377f == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.f723l.get(i) != null) {
            return;
        }
        View m1389g = interfaceC0377f.m1389g();
        if (m1389g == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (m1389g.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.f714c;
        C0638a c0638a = new C0638a(context, context.getResources().getDisplayMetrics().density, this.f713b);
        c0638a.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.m
            {
                C0390r.this = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C0390r.this.m1353b0(i, view, z);
            }
        });
        this.f723l.put(i, c0638a);
        m1389g.setImportantForAccessibility(4);
        c0638a.addView(m1389g);
        this.f715d.addView(c0638a);
    }

    @Override // io.flutter.plugin.platform.InterfaceC0384l
    /* renamed from: a */
    public void mo1356a() {
        this.f719h.m1434c(null);
    }

    @Override // io.flutter.plugin.platform.InterfaceC0384l
    /* renamed from: b */
    public void mo1354b(C0408c c0408c) {
        this.f719h.m1434c(c0408c);
    }

    @Override // io.flutter.plugin.platform.InterfaceC0384l
    /* renamed from: c */
    public View mo1352c(int i) {
        if (mo1350d(i)) {
            return this.f720i.get(Integer.valueOf(i)).m1285f();
        }
        InterfaceC0377f interfaceC0377f = this.f722k.get(i);
        if (interfaceC0377f == null) {
            return null;
        }
        return interfaceC0377f.m1389g();
    }

    @Override // io.flutter.plugin.platform.InterfaceC0384l
    /* renamed from: d */
    public boolean mo1350d(int i) {
        return this.f720i.containsKey(Integer.valueOf(i));
    }

    /* renamed from: g0 */
    public void m1343g0() {
    }

    /* renamed from: h0 */
    public void m1341h0() {
        this.f729r.clear();
        this.f730s.clear();
    }

    /* renamed from: i0 */
    public void m1339i0() {
        m1365R();
    }

    /* renamed from: j0 */
    public void m1337j0(int i, int i2, int i3, int i4, int i5) {
        if (this.f724m.get(i) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i + ") doesn't exist");
        }
        m1358Y();
        C0370c c0370c = this.f724m.get(i);
        if (c0370c.getParent() == null) {
            this.f715d.addView(c0370c);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        c0370c.setLayoutParams(layoutParams);
        c0370c.setVisibility(0);
        c0370c.bringToFront();
        this.f729r.add(Integer.valueOf(i));
    }

    /* renamed from: k0 */
    public void m1335k0(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        m1358Y();
        m1359X(i);
        C0638a c0638a = this.f723l.get(i);
        c0638a.m665a(flutterMutatorsStack, i2, i3, i4, i5);
        c0638a.setVisibility(0);
        c0638a.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        View m1389g = this.f722k.get(i).m1389g();
        if (m1389g != null) {
            m1389g.setLayoutParams(layoutParams);
            m1389g.bringToFront();
        }
        this.f730s.add(Integer.valueOf(i));
    }

    /* renamed from: l0 */
    public void m1333l0() {
        boolean z = false;
        if (this.f727p && this.f730s.isEmpty()) {
            this.f727p = false;
            this.f715d.m1700A(new Runnable() { // from class: io.flutter.plugin.platform.p
                {
                    C0390r.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C0390r.this.m1351c0();
                }
            });
            return;
        }
        if (this.f727p && this.f715d.m1689k()) {
            z = true;
        }
        m1362U(z);
    }

    /* renamed from: m0 */
    public void m1331m0() {
        m1365R();
    }

    /* renamed from: s0 */
    public void m1319s0(boolean z) {
        this.f732u = z;
    }

    /* renamed from: v0 */
    public MotionEvent m1313v0(float f, C0876l.C0883f c0883f, boolean z) {
        MotionEvent m1638b = this.f731t.m1638b(C0305t.C0306a.m1634c(c0883f.f1582p));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) m1323q0(c0883f.f1572f).toArray(new MotionEvent.PointerProperties[c0883f.f1571e]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) m1327o0(c0883f.f1573g, f).toArray(new MotionEvent.PointerCoords[c0883f.f1571e]);
        return (z || m1638b == null) ? MotionEvent.obtain(c0883f.f1568b.longValue(), c0883f.f1569c.longValue(), c0883f.f1570d, c0883f.f1571e, pointerPropertiesArr, pointerCoordsArr, c0883f.f1574h, c0883f.f1575i, c0883f.f1576j, c0883f.f1577k, c0883f.f1578l, c0883f.f1579m, c0883f.f1580n, c0883f.f1581o) : MotionEvent.obtain(m1638b.getDownTime(), m1638b.getEventTime(), c0883f.f1570d, c0883f.f1571e, pointerPropertiesArr, pointerCoordsArr, m1638b.getMetaState(), m1638b.getButtonState(), m1638b.getXPrecision(), m1638b.getYPrecision(), m1638b.getDeviceId(), m1638b.getEdgeFlags(), m1638b.getSource(), m1638b.getFlags());
    }
}