package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import androidx.core.content.C0061a;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import io.flutter.embedding.android.C0265f;
import io.flutter.embedding.android.C0291r;
import io.flutter.embedding.engine.C0313a;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.InterfaceC0341a;
import io.flutter.embedding.engine.renderer.InterfaceC0342b;
import io.flutter.plugin.editing.C0354f;
import io.flutter.plugin.editing.textserviceSpellCheckerSession$SpellCheckerSessionListenerC0352d;
import io.flutter.view.C0408c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p001a0.InterfaceC0016c;
import p005b0.C0109a;
import p008c0.C0114a;
import p012e0.C0146h;
import p015g.InterfaceC0170a;
import p031o.C0576b;

/* renamed from: io.flutter.embedding.android.j */
/* loaded from: classes.dex */
public class C0274j extends FrameLayout implements C0114a.InterfaceC0117c, C0291r.InterfaceC0298e {

    /* renamed from: a */
    private C0268g f359a;

    /* renamed from: b */
    private C0271h f360b;

    /* renamed from: c */
    private C0265f f361c;

    /* renamed from: d */
    InterfaceC0342b f362d;

    /* renamed from: e */
    private InterfaceC0342b f363e;

    /* renamed from: f */
    private final Set<InterfaceC0341a> f364f;

    /* renamed from: g */
    private boolean f365g;

    /* renamed from: h */
    private C0313a f366h;

    /* renamed from: i */
    private final Set<InterfaceC0280f> f367i;

    /* renamed from: j */
    private C0114a f368j;

    /* renamed from: k */
    private C0354f f369k;

    /* renamed from: l */
    private textserviceSpellCheckerSession$SpellCheckerSessionListenerC0352d f370l;

    /* renamed from: m */
    private C0109a f371m;

    /* renamed from: n */
    private C0291r f372n;

    /* renamed from: o */
    private C0256a f373o;

    /* renamed from: p */
    private C0408c f374p;

    /* renamed from: q */
    private TextServicesManager f375q;

    /* renamed from: r */
    private C0309w f376r;

    /* renamed from: s */
    private final FlutterRenderer.C0340g f377s;

    /* renamed from: t */
    private final C0408c.InterfaceC0419k f378t;

    /* renamed from: u */
    private final ContentObserver f379u;

    /* renamed from: v */
    private final InterfaceC0341a f380v;

    /* renamed from: w */
    private final InterfaceC0170a<WindowLayoutInfo> f381w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.android.j$a */
    /* loaded from: classes.dex */
    public class C0275a implements C0408c.InterfaceC0419k {
        C0275a() {
            C0274j.this = r1;
        }

        @Override // io.flutter.view.C0408c.InterfaceC0419k
        /* renamed from: a */
        public void mo1191a(boolean z, boolean z2) {
            C0274j.this.m1674z(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.android.j$b */
    /* loaded from: classes.dex */
    public class C0276b extends ContentObserver {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0276b(Handler handler) {
            super(handler);
            C0274j.this = r1;
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (C0274j.this.f366h == null) {
                return;
            }
            C0576b.m737f("FlutterView", "System settings changed. Sending user settings to Flutter.");
            C0274j.this.m1699B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.android.j$c */
    /* loaded from: classes.dex */
    public class C0277c implements InterfaceC0341a {
        C0277c() {
            C0274j.this = r1;
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: d */
        public void mo1527d() {
            C0274j.this.f365g = true;
            for (InterfaceC0341a interfaceC0341a : C0274j.this.f364f) {
                interfaceC0341a.mo1527d();
            }
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: g */
        public void mo1526g() {
            C0274j.this.f365g = false;
            for (InterfaceC0341a interfaceC0341a : C0274j.this.f364f) {
                interfaceC0341a.mo1526g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.android.j$d */
    /* loaded from: classes.dex */
    public class C0278d implements InterfaceC0170a<WindowLayoutInfo> {
        C0278d() {
            C0274j.this = r1;
        }

        @Override // p015g.InterfaceC0170a
        /* renamed from: a */
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            C0274j.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
        }
    }

    /* renamed from: io.flutter.embedding.android.j$e */
    /* loaded from: classes.dex */
    public class C0279e implements InterfaceC0341a {

        /* renamed from: a */
        final /* synthetic */ FlutterRenderer f386a;

        /* renamed from: b */
        final /* synthetic */ Runnable f387b;

        C0279e(FlutterRenderer flutterRenderer, Runnable runnable) {
            C0274j.this = r1;
            this.f386a = flutterRenderer;
            this.f387b = runnable;
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: d */
        public void mo1527d() {
            this.f386a.m1539t(this);
            this.f387b.run();
            C0274j c0274j = C0274j.this;
            if ((c0274j.f362d instanceof C0265f) || c0274j.f361c == null) {
                return;
            }
            C0274j.this.f361c.mo1523c();
            C0274j.this.m1676x();
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: g */
        public void mo1526g() {
        }
    }

    /* renamed from: io.flutter.embedding.android.j$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0280f {
        /* renamed from: a */
        void m1672a(C0313a c0313a);

        /* renamed from: b */
        void m1671b();
    }

    /* renamed from: io.flutter.embedding.android.j$g */
    /* loaded from: classes.dex */
    public enum EnumC0281g {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    private C0274j(Context context, AttributeSet attributeSet, C0268g c0268g) {
        super(context, attributeSet);
        this.f364f = new HashSet();
        this.f367i = new HashSet();
        this.f377s = new FlutterRenderer.C0340g();
        this.f378t = new C0275a();
        this.f379u = new C0276b(new Handler(Looper.getMainLooper()));
        this.f380v = new C0277c();
        this.f381w = new C0278d();
        this.f359a = c0268g;
        this.f362d = c0268g;
        m1679u();
    }

    private C0274j(Context context, AttributeSet attributeSet, C0271h c0271h) {
        super(context, attributeSet);
        this.f364f = new HashSet();
        this.f367i = new HashSet();
        this.f377s = new FlutterRenderer.C0340g();
        this.f378t = new C0275a();
        this.f379u = new C0276b(new Handler(Looper.getMainLooper()));
        this.f380v = new C0277c();
        this.f381w = new C0278d();
        this.f360b = c0271h;
        this.f362d = c0271h;
        m1679u();
    }

    public C0274j(Context context, C0268g c0268g) {
        this(context, (AttributeSet) null, c0268g);
    }

    public C0274j(Context context, C0271h c0271h) {
        this(context, (AttributeSet) null, c0271h);
    }

    /* renamed from: C */
    private void m1698C() {
        if (!m1678v()) {
            C0576b.m736g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f377s.f565a = getResources().getDisplayMetrics().density;
        this.f377s.f580p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f366h.m1611r().m1537v(this.f377s);
    }

    /* renamed from: d */
    public static /* synthetic */ boolean m1696d(SpellCheckerInfo spellCheckerInfo) {
        return m1677w(spellCheckerInfo);
    }

    /* renamed from: o */
    private EnumC0281g m1685o() {
        Context context = getContext();
        int i = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i == 2) {
            if (rotation == 1) {
                return EnumC0281g.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? EnumC0281g.LEFT : EnumC0281g.RIGHT;
            } else if (rotation == 0 || rotation == 2) {
                return EnumC0281g.BOTH;
            }
        }
        return EnumC0281g.NONE;
    }

    @TargetApi(20)
    /* renamed from: t */
    private int m1680t(WindowInsets windowInsets) {
        double height = getRootView().getHeight();
        Double.isNaN(height);
        if (windowInsets.getSystemWindowInsetBottom() < height * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    /* renamed from: u */
    private void m1679u() {
        View view;
        C0576b.m737f("FlutterView", "Initializing FlutterView");
        if (this.f359a != null) {
            C0576b.m737f("FlutterView", "Internally using a FlutterSurfaceView.");
            view = this.f359a;
        } else if (this.f360b != null) {
            C0576b.m737f("FlutterView", "Internally using a FlutterTextureView.");
            view = this.f360b;
        } else {
            C0576b.m737f("FlutterView", "Internally using a FlutterImageView.");
            view = this.f361c;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
    }

    /* renamed from: w */
    public static /* synthetic */ boolean m1677w(SpellCheckerInfo spellCheckerInfo) {
        return spellCheckerInfo.getPackageName().equals("com.google.android.inputmethod.latin");
    }

    /* renamed from: x */
    public void m1676x() {
        C0265f c0265f = this.f361c;
        if (c0265f != null) {
            c0265f.m1727f();
            removeView(this.f361c);
            this.f361c = null;
        }
    }

    /* renamed from: z */
    public void m1674z(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f366h.m1611r().m1545n() && !z && !z2) {
            z3 = true;
        }
        setWillNotDraw(z3);
    }

    /* renamed from: A */
    public void m1700A(Runnable runnable) {
        if (this.f361c == null) {
            C0576b.m737f("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        InterfaceC0342b interfaceC0342b = this.f363e;
        if (interfaceC0342b == null) {
            C0576b.m737f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f362d = interfaceC0342b;
        this.f363e = null;
        FlutterRenderer m1611r = this.f366h.m1611r();
        if (this.f366h != null && m1611r != null) {
            this.f362d.mo1525a(m1611r);
            m1611r.m1550i(new C0279e(m1611r, runnable));
            return;
        }
        this.f361c.mo1523c();
        m1676x();
        runnable.run();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x003c, code lost:
        if (r3 != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079  */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m1699B() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 0
            r2 = 1
            r3 = 32
            if (r0 != r3) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1a
            z.n$c r0 = p053z.C0888n.EnumC0893c.dark
            goto L1c
        L1a:
            z.n$c r0 = p053z.C0888n.EnumC0893c.light
        L1c:
            android.view.textservice.TextServicesManager r3 = r6.f375q
            if (r3 == 0) goto L40
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L3e
            java.util.List r3 = r3.getEnabledSpellCheckerInfos()
            java.util.stream.Stream r3 = r3.stream()
            io.flutter.embedding.android.i r4 = new java.util.function.Predicate() { // from class: io.flutter.embedding.android.i
                static {
                    /*
                        io.flutter.embedding.android.i r0 = new io.flutter.embedding.android.i
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:io.flutter.embedding.android.i) io.flutter.embedding.android.i.a io.flutter.embedding.android.i
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.C0273i.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.C0273i.<init>():void");
                }

                @Override // java.util.function.Predicate
                public final boolean test(java.lang.Object r1) {
                    /*
                        r0 = this;
                        android.view.textservice.SpellCheckerInfo r1 = (android.view.textservice.SpellCheckerInfo) r1
                        boolean r1 = io.flutter.embedding.android.C0274j.m1696d(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.C0273i.test(java.lang.Object):boolean");
                }
            }
            boolean r3 = r3.anyMatch(r4)
            android.view.textservice.TextServicesManager r4 = r6.f375q
            boolean r4 = r4.isSpellCheckerEnabled()
            if (r4 == 0) goto L40
            if (r3 == 0) goto L40
        L3e:
            r3 = 1
            goto L41
        L40:
            r3 = 0
        L41:
            io.flutter.embedding.engine.a r4 = r6.f366h
            z.n r4 = r4.m1609t()
            z.n$b r4 = r4.m60d()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            z.n$b r4 = r4.m49f(r5)
            android.content.res.Resources r5 = r6.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            z.n$b r4 = r4.m52c(r5)
            z.n$b r3 = r4.m51d(r3)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r2)
            if (r4 != r2) goto L7a
            r1 = 1
        L7a:
            z.n$b r1 = r3.m53b(r1)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            z.n$b r1 = r1.m48g(r2)
            z.n$b r0 = r1.m50e(r0)
            r0.m54a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.C0274j.m1699B():void");
    }

    @Override // io.flutter.embedding.android.C0291r.InterfaceC0298e
    /* renamed from: a */
    public boolean mo1642a(KeyEvent keyEvent) {
        return this.f369k.m1461r(keyEvent);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f369k.m1469j(sparseArray);
    }

    @Override // p008c0.C0114a.InterfaceC0117c
    @TargetApi(24)
    /* renamed from: b */
    public PointerIcon mo1697b(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    @Override // io.flutter.embedding.android.C0291r.InterfaceC0298e
    /* renamed from: c */
    public void mo1641c(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        C0313a c0313a = this.f366h;
        return c0313a != null ? c0313a.m1613p().m1376G(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (m1678v() && this.f372n.mo1506a(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT <= 19) {
            FlutterRenderer.C0340g c0340g = this.f377s;
            c0340g.f568d = rect.top;
            c0340g.f569e = rect.right;
            c0340g.f570f = 0;
            c0340g.f571g = rect.left;
            c0340g.f572h = 0;
            c0340g.f573i = 0;
            c0340g.f574j = rect.bottom;
            c0340g.f575k = 0;
            C0576b.m737f("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f377s.f568d + ", Left: " + this.f377s.f571g + ", Right: " + this.f377s.f569e + "\nKeyboard insets: Bottom: " + this.f377s.f574j + ", Left: " + this.f377s.f575k + ", Right: " + this.f377s.f573i);
            m1698C();
            return true;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        C0408c c0408c = this.f374p;
        if (c0408c == null || !c0408c.m1258C()) {
            return null;
        }
        return this.f374p;
    }

    public C0313a getAttachedFlutterEngine() {
        return this.f366h;
    }

    @Override // io.flutter.embedding.android.C0291r.InterfaceC0298e
    public InterfaceC0016c getBinaryMessenger() {
        return this.f366h.m1619j();
    }

    public C0265f getCurrentImageSurface() {
        return this.f361c;
    }

    /* renamed from: k */
    public boolean m1689k() {
        C0265f c0265f = this.f361c;
        if (c0265f != null) {
            return c0265f.m1729d();
        }
        return false;
    }

    /* renamed from: l */
    public void m1688l(InterfaceC0341a interfaceC0341a) {
        this.f364f.add(interfaceC0341a);
    }

    /* renamed from: m */
    public void m1687m(C0265f c0265f) {
        C0313a c0313a = this.f366h;
        if (c0313a != null) {
            c0265f.mo1525a(c0313a.m1611r());
        }
    }

    /* renamed from: n */
    public void m1686n(C0313a c0313a) {
        C0576b.m737f("FlutterView", "Attaching to a FlutterEngine: " + c0313a);
        if (m1678v()) {
            if (c0313a == this.f366h) {
                C0576b.m737f("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                C0576b.m737f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                m1681s();
            }
        }
        this.f366h = c0313a;
        FlutterRenderer m1611r = c0313a.m1611r();
        this.f365g = m1611r.m1546m();
        this.f362d.mo1525a(m1611r);
        m1611r.m1550i(this.f380v);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f368j = new C0114a(this, this.f366h.m1616m());
        }
        this.f369k = new C0354f(this, this.f366h.m1606w(), this.f366h.m1613p());
        try {
            TextServicesManager textServicesManager = (TextServicesManager) getContext().getSystemService("textservices");
            this.f375q = textServicesManager;
            this.f370l = new textserviceSpellCheckerSession$SpellCheckerSessionListenerC0352d(textServicesManager, this.f366h.m1608u());
        } catch (Exception unused) {
            C0576b.m741b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
        }
        this.f371m = this.f366h.m1617l();
        this.f372n = new C0291r(this);
        this.f373o = new C0256a(this.f366h.m1611r(), false);
        C0408c c0408c = new C0408c(this, c0313a.m1621h(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f366h.m1613p());
        this.f374p = c0408c;
        c0408c.m1233a0(this.f378t);
        m1674z(this.f374p.m1258C(), this.f374p.m1256E());
        this.f366h.m1613p().mo1354b(this.f374p);
        this.f366h.m1613p().m1378E(this.f366h.m1611r());
        this.f369k.m1462q().restartInput(this);
        m1699B();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.f379u);
        m1698C();
        c0313a.m1613p().m1377F(this);
        for (InterfaceC0280f interfaceC0280f : this.f367i) {
            interfaceC0280f.m1672a(c0313a);
        }
        if (this.f365g) {
            this.f380v.mo1527d();
        }
    }

    @Override // android.view.View
    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i = Build.VERSION.SDK_INT;
        if (i == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            FlutterRenderer.C0340g c0340g = this.f377s;
            c0340g.f576l = systemGestureInsets.top;
            c0340g.f577m = systemGestureInsets.right;
            c0340g.f578n = systemGestureInsets.bottom;
            c0340g.f579o = systemGestureInsets.left;
        }
        boolean z = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z2 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i >= 30) {
            int navigationBars = z2 ? 0 | WindowInsets.Type.navigationBars() : 0;
            if (z) {
                navigationBars |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(navigationBars);
            FlutterRenderer.C0340g c0340g2 = this.f377s;
            c0340g2.f568d = insets.top;
            c0340g2.f569e = insets.right;
            c0340g2.f570f = insets.bottom;
            c0340g2.f571g = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            FlutterRenderer.C0340g c0340g3 = this.f377s;
            c0340g3.f572h = insets2.top;
            c0340g3.f573i = insets2.right;
            c0340g3.f574j = insets2.bottom;
            c0340g3.f575k = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            FlutterRenderer.C0340g c0340g4 = this.f377s;
            c0340g4.f576l = insets3.top;
            c0340g4.f577m = insets3.right;
            c0340g4.f578n = insets3.bottom;
            c0340g4.f579o = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.C0340g c0340g5 = this.f377s;
                c0340g5.f568d = Math.max(Math.max(c0340g5.f568d, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.C0340g c0340g6 = this.f377s;
                c0340g6.f569e = Math.max(Math.max(c0340g6.f569e, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.C0340g c0340g7 = this.f377s;
                c0340g7.f570f = Math.max(Math.max(c0340g7.f570f, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.C0340g c0340g8 = this.f377s;
                c0340g8.f571g = Math.max(Math.max(c0340g8.f571g, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            EnumC0281g enumC0281g = EnumC0281g.NONE;
            if (!z2) {
                enumC0281g = m1685o();
            }
            this.f377s.f568d = z ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f377s.f569e = (enumC0281g == EnumC0281g.RIGHT || enumC0281g == EnumC0281g.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f377s.f570f = (z2 && m1680t(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.f377s.f571g = (enumC0281g == EnumC0281g.LEFT || enumC0281g == EnumC0281g.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            FlutterRenderer.C0340g c0340g9 = this.f377s;
            c0340g9.f572h = 0;
            c0340g9.f573i = 0;
            c0340g9.f574j = m1680t(windowInsets);
            this.f377s.f575k = 0;
        }
        C0576b.m737f("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f377s.f568d + ", Left: " + this.f377s.f571g + ", Right: " + this.f377s.f569e + "\nKeyboard insets: Bottom: " + this.f377s.f574j + ", Left: " + this.f377s.f575k + ", Right: " + this.f377s.f573i + "System Gesture Insets - Left: " + this.f377s.f579o + ", Top: " + this.f377s.f576l + ", Right: " + this.f377s.f577m + ", Bottom: " + this.f377s.f574j);
        m1698C();
        return onApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f376r = m1682r();
        Activity m2025f = C0146h.m2025f(getContext());
        C0309w c0309w = this.f376r;
        if (c0309w == null || m2025f == null) {
            return;
        }
        c0309w.m1632a(m2025f, C0061a.m2225b(getContext()), this.f381w);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f366h != null) {
            C0576b.m737f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.f371m.m2096d(configuration);
            m1699B();
            C0146h.m2028c(getContext(), this.f366h);
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !m1678v() ? super.onCreateInputConnection(editorInfo) : this.f369k.m1464o(this, this.f372n, editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        C0309w c0309w = this.f376r;
        if (c0309w != null) {
            c0309w.m1631b(this.f381w);
        }
        this.f376r = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (m1678v() && this.f373o.m1807j(motionEvent, getContext())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !m1678v() ? super.onHoverEvent(motionEvent) : this.f374p.m1249L(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f369k.m1487A(viewStructure, i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        C0576b.m737f("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        FlutterRenderer.C0340g c0340g = this.f377s;
        c0340g.f566b = i;
        c0340g.f567c = i2;
        m1698C();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m1678v()) {
            if (Build.VERSION.SDK_INT >= 21) {
                requestUnbufferedDispatch(motionEvent);
            }
            return this.f373o.m1806k(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: p */
    public void m1684p() {
        this.f362d.mo1524b();
        C0265f c0265f = this.f361c;
        if (c0265f == null) {
            C0265f m1683q = m1683q();
            this.f361c = m1683q;
            addView(m1683q);
        } else {
            c0265f.m1723j(getWidth(), getHeight());
        }
        this.f363e = this.f362d;
        C0265f c0265f2 = this.f361c;
        this.f362d = c0265f2;
        C0313a c0313a = this.f366h;
        if (c0313a != null) {
            c0265f2.mo1525a(c0313a.m1611r());
        }
    }

    /* renamed from: q */
    public C0265f m1683q() {
        return new C0265f(getContext(), getWidth(), getHeight(), C0265f.EnumC0267b.background);
    }

    /* renamed from: r */
    protected C0309w m1682r() {
        try {
            return new C0309w(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    /* renamed from: s */
    public void m1681s() {
        C0576b.m737f("FlutterView", "Detaching from a FlutterEngine: " + this.f366h);
        if (!m1678v()) {
            C0576b.m737f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (InterfaceC0280f interfaceC0280f : this.f367i) {
            interfaceC0280f.m1671b();
        }
        getContext().getContentResolver().unregisterContentObserver(this.f379u);
        this.f366h.m1613p().m1367P();
        this.f366h.m1613p().mo1356a();
        this.f374p.m1242S();
        this.f374p = null;
        this.f369k.m1462q().restartInput(this);
        this.f369k.m1463p();
        this.f372n.m1648d();
        textserviceSpellCheckerSession$SpellCheckerSessionListenerC0352d textservicespellcheckersession_spellcheckersessionlistenerc0352d = this.f370l;
        if (textservicespellcheckersession_spellcheckersessionlistenerc0352d != null) {
            textservicespellcheckersession_spellcheckersessionlistenerc0352d.m1491b();
        }
        C0114a c0114a = this.f368j;
        if (c0114a != null) {
            c0114a.m2087c();
        }
        FlutterRenderer m1611r = this.f366h.m1611r();
        this.f365g = false;
        m1611r.m1539t(this.f380v);
        m1611r.m1535x();
        m1611r.m1538u(false);
        InterfaceC0342b interfaceC0342b = this.f363e;
        if (interfaceC0342b != null && this.f362d == this.f361c) {
            this.f362d = interfaceC0342b;
        }
        this.f362d.mo1523c();
        m1676x();
        this.f363e = null;
        this.f366h = null;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        InterfaceC0342b interfaceC0342b = this.f362d;
        if (interfaceC0342b instanceof C0268g) {
            ((C0268g) interfaceC0342b).setVisibility(i);
        }
    }

    @TargetApi(28)
    protected void setWindowInfoListenerDisplayFeatures(WindowLayoutInfo windowLayoutInfo) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        List<DisplayFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (DisplayFeature displayFeature : displayFeatures) {
            C0576b.m737f("FlutterView", "WindowInfoTracker Display Feature reported with bounds = " + displayFeature.getBounds().toString() + " and type = " + displayFeature.getClass().getSimpleName());
            if (displayFeature instanceof FoldingFeature) {
                FoldingFeature foldingFeature = (FoldingFeature) displayFeature;
                arrayList.add(new FlutterRenderer.C0333b(displayFeature.getBounds(), foldingFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL ? FlutterRenderer.EnumC0335d.HINGE : FlutterRenderer.EnumC0335d.FOLD, foldingFeature.getState() == FoldingFeature.State.FLAT ? FlutterRenderer.EnumC0334c.POSTURE_FLAT : foldingFeature.getState() == FoldingFeature.State.HALF_OPENED ? FlutterRenderer.EnumC0334c.POSTURE_HALF_OPENED : FlutterRenderer.EnumC0334c.UNKNOWN));
            } else {
                arrayList.add(new FlutterRenderer.C0333b(displayFeature.getBounds(), FlutterRenderer.EnumC0335d.UNKNOWN, FlutterRenderer.EnumC0334c.UNKNOWN));
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getRootWindowInsets()) != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
            for (Rect rect : displayCutout.getBoundingRects()) {
                C0576b.m737f("FlutterView", "DisplayCutout area reported with bounds = " + rect.toString());
                arrayList.add(new FlutterRenderer.C0333b(rect, FlutterRenderer.EnumC0335d.CUTOUT));
            }
        }
        this.f377s.f581q = arrayList;
        m1698C();
    }

    /* renamed from: v */
    public boolean m1678v() {
        C0313a c0313a = this.f366h;
        return c0313a != null && c0313a.m1611r() == this.f362d.getAttachedRenderer();
    }

    /* renamed from: y */
    public void m1675y(InterfaceC0341a interfaceC0341a) {
        this.f364f.remove(interfaceC0341a);
    }
}