package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedCallback;
import androidx.lifecycle.AbstractC0066c;
import androidx.lifecycle.C0072g;
import androidx.lifecycle.InterfaceC0071f;
import io.flutter.embedding.android.C0260d;
import io.flutter.embedding.engine.C0313a;
import io.flutter.embedding.engine.C0329g;
import io.flutter.plugin.platform.C0371d;
import java.util.List;
import p012e0.C0146h;
import p031o.C0576b;
import p051y.C0808a;

/* renamed from: io.flutter.embedding.android.c */
/* loaded from: classes.dex */
public class ActivityC0258c extends Activity implements C0260d.InterfaceC0263c, InterfaceC0071f {

    /* renamed from: e */
    public static final int f308e = C0146h.m2026e(61938);

    /* renamed from: a */
    private boolean f309a = false;

    /* renamed from: b */
    protected C0260d f310b;

    /* renamed from: c */
    private C0072g f311c;

    /* renamed from: d */
    private final OnBackInvokedCallback f312d;

    /* renamed from: io.flutter.embedding.android.c$a */
    /* loaded from: classes.dex */
    class C0259a implements OnBackInvokedCallback {
        C0259a() {
        }

        public void onBackInvoked() {
            ActivityC0258c.this.onBackPressed();
        }
    }

    public ActivityC0258c() {
        this.f312d = Build.VERSION.SDK_INT >= 33 ? new C0259a() : null;
        this.f311c = new C0072g(this);
    }

    /* renamed from: F */
    private void m1804F() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    /* renamed from: G */
    private void m1803G() {
        if (m1801I() == EnumC0264e.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* renamed from: H */
    private View m1802H() {
        return this.f310b.m1764s(null, null, null, f308e, mo1739q() == EnumC0307u.surface);
    }

    /* renamed from: L */
    private boolean m1798L() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: O */
    private boolean m1795O(String str) {
        StringBuilder sb;
        String str2;
        C0260d c0260d = this.f310b;
        if (c0260d == null) {
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after release.";
        } else if (c0260d.m1770m()) {
            return true;
        } else {
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after detach.";
        }
        sb.append(str2);
        C0576b.m736g("FlutterActivity", sb.toString());
        return false;
    }

    /* renamed from: P */
    private void m1794P() {
        try {
            Bundle m1799K = m1799K();
            if (m1799K != null) {
                int i = m1799K.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i != -1) {
                    setTheme(i);
                }
            } else {
                C0576b.m737f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            C0576b.m741b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: A */
    public String mo1756A() {
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle m1799K = m1799K();
            String string = m1799K != null ? m1799K.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: B */
    public void mo1755B(C0313a c0313a) {
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: C */
    public String mo1754C() {
        try {
            Bundle m1799K = m1799K();
            if (m1799K != null) {
                return m1799K.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: D */
    public C0371d mo1753D(Activity activity, C0313a c0313a) {
        return new C0371d(mo1751a(), c0313a.m1614o(), this);
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: E */
    public void mo1752E(C0268g c0268g) {
    }

    /* renamed from: I */
    protected EnumC0264e m1801I() {
        return getIntent().hasExtra("background_mode") ? EnumC0264e.valueOf(getIntent().getStringExtra("background_mode")) : EnumC0264e.opaque;
    }

    /* renamed from: J */
    protected C0313a m1800J() {
        return this.f310b.m1771l();
    }

    /* renamed from: K */
    protected Bundle m1799K() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    /* renamed from: M */
    public void m1797M() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f312d);
            this.f309a = true;
        }
    }

    /* renamed from: N */
    public void m1796N() {
        m1793Q();
        C0260d c0260d = this.f310b;
        if (c0260d != null) {
            c0260d.m1785H();
            this.f310b = null;
        }
    }

    /* renamed from: Q */
    public void m1793Q() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f312d);
            this.f309a = false;
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: a */
    public Activity mo1751a() {
        return this;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: b */
    public void mo1750b() {
        C0576b.m736g("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + m1800J() + " evicted by another attaching activity");
        C0260d c0260d = this.f310b;
        if (c0260d != null) {
            c0260d.m1763t();
            this.f310b.m1762u();
        }
    }

    @Override // io.flutter.plugin.platform.C0371d.InterfaceC0375d
    /* renamed from: c */
    public boolean mo1396c() {
        return false;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: d */
    public void mo1749d() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.plugin.platform.C0371d.InterfaceC0375d
    /* renamed from: e */
    public void mo1395e(boolean z) {
        if (z && !this.f309a) {
            m1797M();
        } else if (z || !this.f309a) {
        } else {
            m1793Q();
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c, androidx.lifecycle.InterfaceC0071f
    /* renamed from: f */
    public AbstractC0066c mo1748f() {
        return this.f311c;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: g */
    public void mo1747g() {
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    public Context getContext() {
        return this;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: h */
    public String mo1746h() {
        return getIntent().getStringExtra("cached_engine_group_id");
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: i */
    public String mo1745i() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle m1799K = m1799K();
            if (m1799K != null) {
                return m1799K.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: j */
    public C0329g mo1744j() {
        return C0329g.m1560a(getIntent());
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: m */
    public String mo1743m() {
        String dataString;
        if (m1798L() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: n */
    public List<String> mo1742n() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: o */
    public C0313a mo1741o(Context context) {
        return null;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (m1795O("onActivityResult")) {
            this.f310b.m1767p(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (m1795O("onBackPressed")) {
            this.f310b.m1765r();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        m1794P();
        super.onCreate(bundle);
        C0260d c0260d = new C0260d(this);
        this.f310b = c0260d;
        c0260d.m1766q(this);
        this.f310b.m1757z(bundle);
        this.f311c.m2203g(AbstractC0066c.EnumC0067a.ON_CREATE);
        m1803G();
        setContentView(m1802H());
        m1804F();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (m1795O("onDestroy")) {
            this.f310b.m1763t();
            this.f310b.m1762u();
        }
        m1796N();
        this.f311c.m2203g(AbstractC0066c.EnumC0067a.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (m1795O("onNewIntent")) {
            this.f310b.m1761v(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (m1795O("onPause")) {
            this.f310b.m1760w();
        }
        this.f311c.m2203g(AbstractC0066c.EnumC0067a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (m1795O("onPostResume")) {
            this.f310b.m1759x();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (m1795O("onRequestPermissionsResult")) {
            this.f310b.m1758y(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f311c.m2203g(AbstractC0066c.EnumC0067a.ON_RESUME);
        if (m1795O("onResume")) {
            this.f310b.m1792A();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (m1795O("onSaveInstanceState")) {
            this.f310b.m1791B(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f311c.m2203g(AbstractC0066c.EnumC0067a.ON_START);
        if (m1795O("onStart")) {
            this.f310b.m1790C();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (m1795O("onStop")) {
            this.f310b.m1789D();
        }
        this.f311c.m2203g(AbstractC0066c.EnumC0067a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (m1795O("onTrimMemory")) {
            this.f310b.m1788E(i);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (m1795O("onUserLeaveHint")) {
            this.f310b.m1787F();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (m1795O("onWindowFocusChanged")) {
            this.f310b.m1786G(z);
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: p */
    public boolean mo1740p() {
        return true;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: q */
    public EnumC0307u mo1739q() {
        return m1801I() == EnumC0264e.opaque ? EnumC0307u.surface : EnumC0307u.texture;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: r */
    public boolean mo1738r() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (mo1732x() != null || this.f310b.m1769n()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: s */
    public boolean mo1737s() {
        return true;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: t */
    public boolean mo1736t() {
        try {
            Bundle m1799K = m1799K();
            if (m1799K != null) {
                return m1799K.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: u */
    public EnumC0308v mo1735u() {
        return m1801I() == EnumC0264e.opaque ? EnumC0308v.opaque : EnumC0308v.transparent;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: v */
    public boolean mo1734v() {
        return true;
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: w */
    public void mo1733w(C0271h c0271h) {
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: x */
    public String mo1732x() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: y */
    public void mo1731y(C0313a c0313a) {
        if (this.f310b.m1769n()) {
            return;
        }
        C0808a.m236a(c0313a);
    }

    @Override // io.flutter.embedding.android.C0260d.InterfaceC0263c
    /* renamed from: z */
    public boolean mo1730z() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : mo1732x() == null;
    }
}