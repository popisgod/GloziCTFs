package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0066c;
import io.flutter.embedding.android.InterfaceC0257b;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p001a0.InterfaceC0040m;
import p001a0.InterfaceC0041n;
import p001a0.InterfaceC0043p;
import p001a0.InterfaceC0044q;
import p012e0.C0143e;
import p031o.C0576b;
import p037r.C0632d;
import p041t.InterfaceC0648a;
import p041t.InterfaceC0651b;
import p043u.InterfaceC0659a;
import p043u.InterfaceC0660b;
import p043u.InterfaceC0661c;
import p045v.InterfaceC0674a;
import p045v.InterfaceC0675b;
import p047w.InterfaceC0697a;
import p047w.InterfaceC0698b;
import p049x.InterfaceC0803a;
import p049x.InterfaceC0804b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.flutter.embedding.engine.c */
/* loaded from: classes.dex */
public class C0317c implements InterfaceC0651b, InterfaceC0660b {

    /* renamed from: b */
    private final C0313a f480b;

    /* renamed from: c */
    private final InterfaceC0648a.C0650b f481c;

    /* renamed from: e */
    private InterfaceC0257b<Activity> f483e;

    /* renamed from: f */
    private C0320c f484f;

    /* renamed from: i */
    private Service f487i;

    /* renamed from: j */
    private C0323f f488j;

    /* renamed from: l */
    private BroadcastReceiver f490l;

    /* renamed from: m */
    private C0321d f491m;

    /* renamed from: o */
    private ContentProvider f493o;

    /* renamed from: p */
    private C0322e f494p;

    /* renamed from: a */
    private final Map<Class<? extends InterfaceC0648a>, InterfaceC0648a> f479a = new HashMap();

    /* renamed from: d */
    private final Map<Class<? extends InterfaceC0648a>, InterfaceC0659a> f482d = new HashMap();

    /* renamed from: g */
    private boolean f485g = false;

    /* renamed from: h */
    private final Map<Class<? extends InterfaceC0648a>, InterfaceC0803a> f486h = new HashMap();

    /* renamed from: k */
    private final Map<Class<? extends InterfaceC0648a>, InterfaceC0674a> f489k = new HashMap();

    /* renamed from: n */
    private final Map<Class<? extends InterfaceC0648a>, InterfaceC0697a> f492n = new HashMap();

    /* renamed from: io.flutter.embedding.engine.c$b */
    /* loaded from: classes.dex */
    private static class C0319b implements InterfaceC0648a.InterfaceC0649a {

        /* renamed from: a */
        final C0632d f495a;

        private C0319b(C0632d c0632d) {
            this.f495a = c0632d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.embedding.engine.c$c */
    /* loaded from: classes.dex */
    public static class C0320c implements InterfaceC0661c {

        /* renamed from: a */
        private final Activity f496a;

        /* renamed from: b */
        private final HiddenLifecycleReference f497b;

        /* renamed from: c */
        private final Set<InterfaceC0043p> f498c = new HashSet();

        /* renamed from: d */
        private final Set<InterfaceC0040m> f499d = new HashSet();

        /* renamed from: e */
        private final Set<InterfaceC0041n> f500e = new HashSet();

        /* renamed from: f */
        private final Set<InterfaceC0044q> f501f = new HashSet();

        /* renamed from: g */
        private final Set<Object> f502g = new HashSet();

        /* renamed from: h */
        private final Set<InterfaceC0661c.InterfaceC0662a> f503h = new HashSet();

        public C0320c(Activity activity, AbstractC0066c abstractC0066c) {
            this.f496a = activity;
            this.f497b = new HiddenLifecycleReference(abstractC0066c);
        }

        @Override // p043u.InterfaceC0661c
        /* renamed from: a */
        public Activity mo618a() {
            return this.f496a;
        }

        @Override // p043u.InterfaceC0661c
        /* renamed from: b */
        public void mo617b(InterfaceC0040m interfaceC0040m) {
            this.f499d.add(interfaceC0040m);
        }

        @Override // p043u.InterfaceC0661c
        /* renamed from: c */
        public void mo616c(InterfaceC0043p interfaceC0043p) {
            this.f498c.add(interfaceC0043p);
        }

        @Override // p043u.InterfaceC0661c
        /* renamed from: d */
        public void mo615d(InterfaceC0040m interfaceC0040m) {
            this.f499d.remove(interfaceC0040m);
        }

        @Override // p043u.InterfaceC0661c
        /* renamed from: e */
        public void mo614e(InterfaceC0043p interfaceC0043p) {
            this.f498c.remove(interfaceC0043p);
        }

        /* renamed from: f */
        boolean m1584f(int i, int i2, Intent intent) {
            boolean z;
            Iterator it = new HashSet(this.f499d).iterator();
            while (true) {
                while (it.hasNext()) {
                    z = ((InterfaceC0040m) it.next()).mo797c(i, i2, intent) || z;
                }
                return z;
            }
        }

        /* renamed from: g */
        void m1583g(Intent intent) {
            for (InterfaceC0041n interfaceC0041n : this.f500e) {
                interfaceC0041n.m2268d(intent);
            }
        }

        /* renamed from: h */
        boolean m1582h(int i, String[] strArr, int[] iArr) {
            boolean z;
            while (true) {
                for (InterfaceC0043p interfaceC0043p : this.f498c) {
                    z = interfaceC0043p.mo799a(i, strArr, iArr) || z;
                }
                return z;
            }
        }

        /* renamed from: i */
        void m1581i(Bundle bundle) {
            for (InterfaceC0661c.InterfaceC0662a interfaceC0662a : this.f503h) {
                interfaceC0662a.m613b(bundle);
            }
        }

        /* renamed from: j */
        void m1580j(Bundle bundle) {
            for (InterfaceC0661c.InterfaceC0662a interfaceC0662a : this.f503h) {
                interfaceC0662a.m612e(bundle);
            }
        }

        /* renamed from: k */
        void m1579k() {
            for (InterfaceC0044q interfaceC0044q : this.f501f) {
                interfaceC0044q.m2265f();
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.c$d */
    /* loaded from: classes.dex */
    private static class C0321d implements InterfaceC0675b {
    }

    /* renamed from: io.flutter.embedding.engine.c$e */
    /* loaded from: classes.dex */
    private static class C0322e implements InterfaceC0698b {
    }

    /* renamed from: io.flutter.embedding.engine.c$f */
    /* loaded from: classes.dex */
    private static class C0323f implements InterfaceC0804b {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0317c(Context context, C0313a c0313a, C0632d c0632d, C0324d c0324d) {
        this.f480b = c0313a;
        this.f481c = new InterfaceC0648a.C0650b(context, c0313a, c0313a.m1619j(), c0313a.m1611r(), c0313a.m1613p().m1360W(), new C0319b(c0632d), c0324d);
    }

    /* renamed from: k */
    private void m1599k(Activity activity, AbstractC0066c abstractC0066c) {
        this.f484f = new C0320c(activity, abstractC0066c);
        this.f480b.m1613p().m1319s0(activity.getIntent() != null ? activity.getIntent().getBooleanExtra("enable-software-rendering", false) : false);
        this.f480b.m1613p().m1380C(activity, this.f480b.m1611r(), this.f480b.m1619j());
        for (InterfaceC0659a interfaceC0659a : this.f482d.values()) {
            if (this.f485g) {
                interfaceC0659a.mo631a(this.f484f);
            } else {
                interfaceC0659a.mo629c(this.f484f);
            }
        }
        this.f485g = false;
    }

    /* renamed from: m */
    private void m1597m() {
        this.f480b.m1613p().m1368O();
        this.f483e = null;
        this.f484f = null;
    }

    /* renamed from: n */
    private void m1596n() {
        if (m1591s()) {
            mo620h();
        } else if (m1588v()) {
            m1593q();
        } else if (m1590t()) {
            m1595o();
        } else if (m1589u()) {
            m1594p();
        }
    }

    /* renamed from: s */
    private boolean m1591s() {
        return this.f483e != null;
    }

    /* renamed from: t */
    private boolean m1590t() {
        return this.f490l != null;
    }

    /* renamed from: u */
    private boolean m1589u() {
        return this.f493o != null;
    }

    /* renamed from: v */
    private boolean m1588v() {
        return this.f487i != null;
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: a */
    public boolean mo627a(int i, String[] strArr, int[] iArr) {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
        try {
            return this.f484f.m1582h(i, strArr, iArr);
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: b */
    public void mo626b(Bundle bundle) {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#onRestoreInstanceState");
        try {
            this.f484f.m1581i(bundle);
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: c */
    public boolean mo625c(int i, int i2, Intent intent) {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#onActivityResult");
        try {
            return this.f484f.m1584f(i, i2, intent);
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: d */
    public void mo624d(Intent intent) {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#onNewIntent");
        try {
            this.f484f.m1583g(intent);
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: e */
    public void mo623e(Bundle bundle) {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#onSaveInstanceState");
        try {
            this.f484f.m1580j(bundle);
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: f */
    public void mo622f() {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#onUserLeaveHint");
        try {
            this.f484f.m1579k();
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: g */
    public void mo621g(InterfaceC0257b<Activity> interfaceC0257b, AbstractC0066c abstractC0066c) {
        C0143e.m2035a("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            InterfaceC0257b<Activity> interfaceC0257b2 = this.f483e;
            if (interfaceC0257b2 != null) {
                interfaceC0257b2.mo1781b();
            }
            m1596n();
            this.f483e = interfaceC0257b;
            m1599k(interfaceC0257b.mo1780c(), abstractC0066c);
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: h */
    public void mo620h() {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            for (InterfaceC0659a interfaceC0659a : this.f482d.values()) {
                interfaceC0659a.mo630b();
            }
            m1597m();
        } finally {
            C0143e.m2032d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p041t.InterfaceC0651b
    /* renamed from: i */
    public void mo634i(InterfaceC0648a interfaceC0648a) {
        C0143e.m2035a("FlutterEngineConnectionRegistry#add " + interfaceC0648a.getClass().getSimpleName());
        try {
            if (m1592r(interfaceC0648a.getClass())) {
                C0576b.m736g("FlutterEngineCxnRegstry", "Attempted to register plugin (" + interfaceC0648a + ") but it was already registered with this FlutterEngine (" + this.f480b + ").");
                return;
            }
            C0576b.m737f("FlutterEngineCxnRegstry", "Adding plugin: " + interfaceC0648a);
            this.f479a.put(interfaceC0648a.getClass(), interfaceC0648a);
            interfaceC0648a.mo637i(this.f481c);
            if (interfaceC0648a instanceof InterfaceC0659a) {
                InterfaceC0659a interfaceC0659a = (InterfaceC0659a) interfaceC0648a;
                this.f482d.put(interfaceC0648a.getClass(), interfaceC0659a);
                if (m1591s()) {
                    interfaceC0659a.mo629c(this.f484f);
                }
            }
            if (interfaceC0648a instanceof InterfaceC0803a) {
                InterfaceC0803a interfaceC0803a = (InterfaceC0803a) interfaceC0648a;
                this.f486h.put(interfaceC0648a.getClass(), interfaceC0803a);
                if (m1588v()) {
                    interfaceC0803a.m244a(this.f488j);
                }
            }
            if (interfaceC0648a instanceof InterfaceC0674a) {
                InterfaceC0674a interfaceC0674a = (InterfaceC0674a) interfaceC0648a;
                this.f489k.put(interfaceC0648a.getClass(), interfaceC0674a);
                if (m1590t()) {
                    interfaceC0674a.m600a(this.f491m);
                }
            }
            if (interfaceC0648a instanceof InterfaceC0697a) {
                InterfaceC0697a interfaceC0697a = (InterfaceC0697a) interfaceC0648a;
                this.f492n.put(interfaceC0648a.getClass(), interfaceC0697a);
                if (m1589u()) {
                    interfaceC0697a.m513a(this.f494p);
                }
            }
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p043u.InterfaceC0660b
    /* renamed from: j */
    public void mo619j() {
        if (!m1591s()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
        try {
            this.f485g = true;
            for (InterfaceC0659a interfaceC0659a : this.f482d.values()) {
                interfaceC0659a.mo628d();
            }
            m1597m();
        } finally {
            C0143e.m2032d();
        }
    }

    /* renamed from: l */
    public void m1598l() {
        C0576b.m737f("FlutterEngineCxnRegstry", "Destroying.");
        m1596n();
        m1585y();
    }

    /* renamed from: o */
    public void m1595o() {
        if (!m1590t()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
        try {
            for (InterfaceC0674a interfaceC0674a : this.f489k.values()) {
                interfaceC0674a.m599b();
            }
        } finally {
            C0143e.m2032d();
        }
    }

    /* renamed from: p */
    public void m1594p() {
        if (!m1589u()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#detachFromContentProvider");
        try {
            for (InterfaceC0697a interfaceC0697a : this.f492n.values()) {
                interfaceC0697a.m512b();
            }
        } finally {
            C0143e.m2032d();
        }
    }

    /* renamed from: q */
    public void m1593q() {
        if (!m1588v()) {
            C0576b.m741b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#detachFromService");
        try {
            for (InterfaceC0803a interfaceC0803a : this.f486h.values()) {
                interfaceC0803a.m243b();
            }
            this.f487i = null;
        } finally {
            C0143e.m2032d();
        }
    }

    /* renamed from: r */
    public boolean m1592r(Class<? extends InterfaceC0648a> cls) {
        return this.f479a.containsKey(cls);
    }

    /* renamed from: w */
    public void m1587w(Class<? extends InterfaceC0648a> cls) {
        InterfaceC0648a interfaceC0648a = this.f479a.get(cls);
        if (interfaceC0648a == null) {
            return;
        }
        C0143e.m2035a("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
        try {
            if (interfaceC0648a instanceof InterfaceC0659a) {
                if (m1591s()) {
                    ((InterfaceC0659a) interfaceC0648a).mo630b();
                }
                this.f482d.remove(cls);
            }
            if (interfaceC0648a instanceof InterfaceC0803a) {
                if (m1588v()) {
                    ((InterfaceC0803a) interfaceC0648a).m243b();
                }
                this.f486h.remove(cls);
            }
            if (interfaceC0648a instanceof InterfaceC0674a) {
                if (m1590t()) {
                    ((InterfaceC0674a) interfaceC0648a).m599b();
                }
                this.f489k.remove(cls);
            }
            if (interfaceC0648a instanceof InterfaceC0697a) {
                if (m1589u()) {
                    ((InterfaceC0697a) interfaceC0648a).m512b();
                }
                this.f492n.remove(cls);
            }
            interfaceC0648a.mo638g(this.f481c);
            this.f479a.remove(cls);
        } finally {
            C0143e.m2032d();
        }
    }

    /* renamed from: x */
    public void m1586x(Set<Class<? extends InterfaceC0648a>> set) {
        for (Class<? extends InterfaceC0648a> cls : set) {
            m1587w(cls);
        }
    }

    /* renamed from: y */
    public void m1585y() {
        m1586x(new HashSet(this.f479a.keySet()));
        this.f479a.clear();
    }
}