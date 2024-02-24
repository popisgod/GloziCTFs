package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.lifecycle.AbstractC0066c;
import io.flutter.embedding.engine.C0313a;
import io.flutter.embedding.engine.C0316b;
import io.flutter.embedding.engine.C0324d;
import io.flutter.embedding.engine.C0327e;
import io.flutter.embedding.engine.C0329g;
import io.flutter.embedding.engine.renderer.InterfaceC0341a;
import io.flutter.plugin.platform.C0371d;
import java.util.Arrays;
import java.util.List;
import p031o.C0572a;
import p031o.C0576b;
import p033p.C0579a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.flutter.embedding.android.d */
/* loaded from: classes.dex */
public class C0260d implements InterfaceC0257b<Activity> {

    /* renamed from: a */
    private InterfaceC0263c f314a;

    /* renamed from: b */
    private C0313a f315b;

    /* renamed from: c */
    C0274j f316c;

    /* renamed from: d */
    private C0371d f317d;

    /* renamed from: e */
    ViewTreeObserver.OnPreDrawListener f318e;

    /* renamed from: f */
    private boolean f319f;

    /* renamed from: g */
    private boolean f320g;

    /* renamed from: h */
    private boolean f321h;

    /* renamed from: i */
    private boolean f322i;

    /* renamed from: j */
    private Integer f323j;

    /* renamed from: k */
    private C0324d f324k;

    /* renamed from: l */
    private final InterfaceC0341a f325l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.android.d$a */
    /* loaded from: classes.dex */
    public class C0261a implements InterfaceC0341a {
        C0261a() {
            C0260d.this = r1;
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: d */
        public void mo1527d() {
            C0260d.this.f314a.mo1749d();
            C0260d.this.f320g = true;
            C0260d.this.f321h = true;
        }

        @Override // io.flutter.embedding.engine.renderer.InterfaceC0341a
        /* renamed from: g */
        public void mo1526g() {
            C0260d.this.f314a.mo1747g();
            C0260d.this.f320g = false;
        }
    }

    /* renamed from: io.flutter.embedding.android.d$b */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnPreDrawListenerC0262b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        final /* synthetic */ C0274j f327a;

        ViewTreeObserver$OnPreDrawListenerC0262b(C0274j c0274j) {
            C0260d.this = r1;
            this.f327a = c0274j;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (C0260d.this.f320g && C0260d.this.f318e != null) {
                this.f327a.getViewTreeObserver().removeOnPreDrawListener(this);
                C0260d.this.f318e = null;
            }
            return C0260d.this.f320g;
        }
    }

    /* renamed from: io.flutter.embedding.android.d$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0263c extends C0371d.InterfaceC0375d {
        /* renamed from: A */
        String mo1756A();

        /* renamed from: B */
        void mo1755B(C0313a c0313a);

        /* renamed from: C */
        String mo1754C();

        /* renamed from: D */
        C0371d mo1753D(Activity activity, C0313a c0313a);

        /* renamed from: E */
        void mo1752E(C0268g c0268g);

        /* renamed from: a */
        Activity mo1751a();

        /* renamed from: b */
        void mo1750b();

        /* renamed from: d */
        void mo1749d();

        /* renamed from: f */
        AbstractC0066c mo1748f();

        /* renamed from: g */
        void mo1747g();

        Context getContext();

        /* renamed from: h */
        String mo1746h();

        /* renamed from: i */
        String mo1745i();

        /* renamed from: j */
        C0329g mo1744j();

        /* renamed from: m */
        String mo1743m();

        /* renamed from: n */
        List<String> mo1742n();

        /* renamed from: o */
        C0313a mo1741o(Context context);

        /* renamed from: p */
        boolean mo1740p();

        /* renamed from: q */
        EnumC0307u mo1739q();

        /* renamed from: r */
        boolean mo1738r();

        /* renamed from: s */
        boolean mo1737s();

        /* renamed from: t */
        boolean mo1736t();

        /* renamed from: u */
        EnumC0308v mo1735u();

        /* renamed from: v */
        boolean mo1734v();

        /* renamed from: w */
        void mo1733w(C0271h c0271h);

        /* renamed from: x */
        String mo1732x();

        /* renamed from: y */
        void mo1731y(C0313a c0313a);

        /* renamed from: z */
        boolean mo1730z();
    }

    public C0260d(InterfaceC0263c interfaceC0263c) {
        this(interfaceC0263c, null);
    }

    C0260d(InterfaceC0263c interfaceC0263c, C0324d c0324d) {
        this.f325l = new C0261a();
        this.f314a = interfaceC0263c;
        this.f321h = false;
        this.f324k = c0324d;
    }

    /* renamed from: g */
    private C0324d.C0326b m1776g(C0324d.C0326b c0326b) {
        String mo1743m = this.f314a.mo1743m();
        if (mo1743m == null || mo1743m.isEmpty()) {
            mo1743m = C0572a.m745e().m747c().m676g();
        }
        C0579a.C0581b c0581b = new C0579a.C0581b(mo1743m, this.f314a.mo1756A());
        String mo1745i = this.f314a.mo1745i();
        if (mo1745i == null && (mo1745i = m1768o(this.f314a.mo1751a().getIntent())) == null) {
            mo1745i = "/";
        }
        return c0326b.m1566i(c0581b).m1564k(mo1745i).m1565j(this.f314a.mo1742n());
    }

    /* renamed from: h */
    private void m1775h(C0274j c0274j) {
        if (this.f314a.mo1739q() != EnumC0307u.surface) {
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
        if (this.f318e != null) {
            c0274j.getViewTreeObserver().removeOnPreDrawListener(this.f318e);
        }
        this.f318e = new ViewTreeObserver$OnPreDrawListenerC0262b(c0274j);
        c0274j.getViewTreeObserver().addOnPreDrawListener(this.f318e);
    }

    /* renamed from: i */
    private void m1774i() {
        String str;
        if (this.f314a.mo1732x() == null && !this.f315b.m1619j().m728k()) {
            String mo1745i = this.f314a.mo1745i();
            if (mo1745i == null && (mo1745i = m1768o(this.f314a.mo1751a().getIntent())) == null) {
                mo1745i = "/";
            }
            String mo1754C = this.f314a.mo1754C();
            if (("Executing Dart entrypoint: " + this.f314a.mo1756A() + ", library uri: " + mo1754C) == null) {
                str = "\"\"";
            } else {
                str = mo1754C + ", and sending initial route: " + mo1745i;
            }
            C0576b.m737f("FlutterActivityAndFragmentDelegate", str);
            this.f315b.m1615n().m136c(mo1745i);
            String mo1743m = this.f314a.mo1743m();
            if (mo1743m == null || mo1743m.isEmpty()) {
                mo1743m = C0572a.m745e().m747c().m676g();
            }
            this.f315b.m1619j().m729j(mo1754C == null ? new C0579a.C0581b(mo1743m, this.f314a.mo1756A()) : new C0579a.C0581b(mo1743m, mo1754C, this.f314a.mo1756A()), this.f314a.mo1742n());
        }
    }

    /* renamed from: j */
    private void m1773j() {
        if (this.f314a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    /* renamed from: o */
    private String m1768o(Intent intent) {
        Uri data;
        if (!this.f314a.mo1736t() || (data = intent.getData()) == null) {
            return null;
        }
        return data.toString();
    }

    /* renamed from: A */
    public void m1792A() {
        C0313a c0313a;
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onResume()");
        m1773j();
        if (!this.f314a.mo1734v() || (c0313a = this.f315b) == null) {
            return;
        }
        c0313a.m1618k().m148e();
    }

    /* renamed from: B */
    public void m1791B(Bundle bundle) {
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        m1773j();
        if (this.f314a.mo1730z()) {
            bundle.putByteArray("framework", this.f315b.m1610s().m69h());
        }
        if (this.f314a.mo1740p()) {
            Bundle bundle2 = new Bundle();
            this.f315b.m1620i().mo623e(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    /* renamed from: C */
    public void m1790C() {
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onStart()");
        m1773j();
        m1774i();
        Integer num = this.f323j;
        if (num != null) {
            this.f316c.setVisibility(num.intValue());
        }
    }

    /* renamed from: D */
    public void m1789D() {
        C0313a c0313a;
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onStop()");
        m1773j();
        if (this.f314a.mo1734v() && (c0313a = this.f315b) != null) {
            c0313a.m1618k().m149d();
        }
        this.f323j = Integer.valueOf(this.f316c.getVisibility());
        this.f316c.setVisibility(8);
    }

    /* renamed from: E */
    public void m1788E(int i) {
        m1773j();
        C0313a c0313a = this.f315b;
        if (c0313a != null) {
            if (this.f321h && i >= 10) {
                c0313a.m1619j().m727l();
                this.f315b.m1607v().m44a();
            }
            this.f315b.m1611r().m1543p(i);
        }
    }

    /* renamed from: F */
    public void m1787F() {
        m1773j();
        if (this.f315b == null) {
            C0576b.m736g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
        this.f315b.m1620i().mo622f();
    }

    /* renamed from: G */
    public void m1786G(boolean z) {
        C0313a c0313a;
        m1773j();
        StringBuilder sb = new StringBuilder();
        sb.append("Received onWindowFocusChanged: ");
        sb.append(z ? "true" : "false");
        C0576b.m737f("FlutterActivityAndFragmentDelegate", sb.toString());
        if (!this.f314a.mo1734v() || (c0313a = this.f315b) == null) {
            return;
        }
        if (z) {
            c0313a.m1618k().m152a();
        } else {
            c0313a.m1618k().m147f();
        }
    }

    /* renamed from: H */
    public void m1785H() {
        this.f314a = null;
        this.f315b = null;
        this.f316c = null;
        this.f317d = null;
    }

    /* renamed from: I */
    void m1784I() {
        C0324d c0324d;
        C0324d.C0326b m1563l;
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String mo1732x = this.f314a.mo1732x();
        if (mo1732x != null) {
            C0313a m1603a = C0316b.m1602b().m1603a(mo1732x);
            this.f315b = m1603a;
            this.f319f = true;
            if (m1603a != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + mo1732x + "'");
        }
        InterfaceC0263c interfaceC0263c = this.f314a;
        C0313a mo1741o = interfaceC0263c.mo1741o(interfaceC0263c.getContext());
        this.f315b = mo1741o;
        if (mo1741o != null) {
            this.f319f = true;
            return;
        }
        String mo1746h = this.f314a.mo1746h();
        if (mo1746h != null) {
            c0324d = C0327e.m1561b().m1562a(mo1746h);
            if (c0324d == null) {
                throw new IllegalStateException("The requested cached FlutterEngineGroup did not exist in the FlutterEngineGroupCache: '" + mo1746h + "'");
            }
            m1563l = new C0324d.C0326b(this.f314a.getContext());
        } else {
            C0576b.m737f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
            c0324d = this.f324k;
            if (c0324d == null) {
                c0324d = new C0324d(this.f314a.getContext(), this.f314a.mo1744j().m1559b());
            }
            m1563l = new C0324d.C0326b(this.f314a.getContext()).m1567h(false).m1563l(this.f314a.mo1730z());
        }
        this.f315b = c0324d.m1578a(m1776g(m1563l));
        this.f319f = false;
    }

    /* renamed from: J */
    void m1783J() {
        C0371d c0371d = this.f317d;
        if (c0371d != null) {
            c0371d.m1426C();
        }
    }

    @Override // io.flutter.embedding.android.InterfaceC0257b
    /* renamed from: b */
    public void mo1781b() {
        if (!this.f314a.mo1738r()) {
            this.f314a.mo1750b();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f314a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    @Override // io.flutter.embedding.android.InterfaceC0257b
    /* renamed from: k */
    public Activity mo1780c() {
        Activity mo1751a = this.f314a.mo1751a();
        if (mo1751a != null) {
            return mo1751a;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* renamed from: l */
    public C0313a m1771l() {
        return this.f315b;
    }

    /* renamed from: m */
    public boolean m1770m() {
        return this.f322i;
    }

    /* renamed from: n */
    public boolean m1769n() {
        return this.f319f;
    }

    /* renamed from: p */
    public void m1767p(int i, int i2, Intent intent) {
        m1773j();
        if (this.f315b == null) {
            C0576b.m736g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
        this.f315b.m1620i().mo625c(i, i2, intent);
    }

    /* renamed from: q */
    public void m1766q(Context context) {
        m1773j();
        if (this.f315b == null) {
            m1784I();
        }
        if (this.f314a.mo1740p()) {
            C0576b.m737f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f315b.m1620i().mo621g(this, this.f314a.mo1748f());
        }
        InterfaceC0263c interfaceC0263c = this.f314a;
        this.f317d = interfaceC0263c.mo1753D(interfaceC0263c.mo1751a(), this.f315b);
        this.f314a.mo1731y(this.f315b);
        this.f322i = true;
    }

    /* renamed from: r */
    public void m1765r() {
        m1773j();
        if (this.f315b == null) {
            C0576b.m736g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
            return;
        }
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
        this.f315b.m1615n().m138a();
    }

    /* renamed from: s */
    public View m1764s(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        C0274j c0274j;
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        m1773j();
        if (this.f314a.mo1739q() == EnumC0307u.surface) {
            C0268g c0268g = new C0268g(this.f314a.getContext(), this.f314a.mo1735u() == EnumC0308v.transparent);
            this.f314a.mo1752E(c0268g);
            c0274j = new C0274j(this.f314a.getContext(), c0268g);
        } else {
            C0271h c0271h = new C0271h(this.f314a.getContext());
            c0271h.setOpaque(this.f314a.mo1735u() == EnumC0308v.opaque);
            this.f314a.mo1733w(c0271h);
            c0274j = new C0274j(this.f314a.getContext(), c0271h);
        }
        this.f316c = c0274j;
        this.f316c.m1688l(this.f325l);
        if (this.f314a.mo1737s()) {
            C0576b.m737f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
            this.f316c.m1686n(this.f315b);
        }
        this.f316c.setId(i);
        if (z) {
            m1775h(this.f316c);
        }
        return this.f316c;
    }

    /* renamed from: t */
    public void m1763t() {
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        m1773j();
        if (this.f318e != null) {
            this.f316c.getViewTreeObserver().removeOnPreDrawListener(this.f318e);
            this.f318e = null;
        }
        C0274j c0274j = this.f316c;
        if (c0274j != null) {
            c0274j.m1681s();
            this.f316c.m1675y(this.f325l);
        }
    }

    /* renamed from: u */
    public void m1762u() {
        C0313a c0313a;
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onDetach()");
        m1773j();
        this.f314a.mo1755B(this.f315b);
        if (this.f314a.mo1740p()) {
            C0576b.m737f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f314a.mo1751a().isChangingConfigurations()) {
                this.f315b.m1620i().mo619j();
            } else {
                this.f315b.m1620i().mo620h();
            }
        }
        C0371d c0371d = this.f317d;
        if (c0371d != null) {
            c0371d.m1409p();
            this.f317d = null;
        }
        if (this.f314a.mo1734v() && (c0313a = this.f315b) != null) {
            c0313a.m1618k().m151b();
        }
        if (this.f314a.mo1738r()) {
            this.f315b.m1622g();
            if (this.f314a.mo1732x() != null) {
                C0316b.m1602b().m1600d(this.f314a.mo1732x());
            }
            this.f315b = null;
        }
        this.f322i = false;
    }

    /* renamed from: v */
    public void m1761v(Intent intent) {
        m1773j();
        if (this.f315b == null) {
            C0576b.m736g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRouteInformation message.");
        this.f315b.m1620i().mo624d(intent);
        String m1768o = m1768o(intent);
        if (m1768o == null || m1768o.isEmpty()) {
            return;
        }
        this.f315b.m1615n().m137b(m1768o);
    }

    /* renamed from: w */
    public void m1760w() {
        C0313a c0313a;
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onPause()");
        m1773j();
        if (!this.f314a.mo1734v() || (c0313a = this.f315b) == null) {
            return;
        }
        c0313a.m1618k().m150c();
    }

    /* renamed from: x */
    public void m1759x() {
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onPostResume()");
        m1773j();
        if (this.f315b != null) {
            m1783J();
        } else {
            C0576b.m736g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    /* renamed from: y */
    public void m1758y(int i, String[] strArr, int[] iArr) {
        m1773j();
        if (this.f315b == null) {
            C0576b.m736g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f315b.m1620i().mo627a(i, strArr, iArr);
    }

    /* renamed from: z */
    public void m1757z(Bundle bundle) {
        Bundle bundle2;
        C0576b.m737f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        m1773j();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f314a.mo1730z()) {
            this.f315b.m1610s().m67j(bArr);
        }
        if (this.f314a.mo1740p()) {
            this.f315b.m1620i().mo626b(bundle2);
        }
    }
}