package io.flutter.embedding.engine;

import android.content.Context;
import io.flutter.embedding.engine.C0313a;
import io.flutter.plugin.platform.C0390r;
import java.util.ArrayList;
import java.util.List;
import p031o.C0572a;
import p033p.C0579a;
import p037r.C0632d;

/* renamed from: io.flutter.embedding.engine.d */
/* loaded from: classes.dex */
public class C0324d {

    /* renamed from: a */
    final List<C0313a> f504a = new ArrayList();

    /* renamed from: io.flutter.embedding.engine.d$a */
    /* loaded from: classes.dex */
    class C0325a implements C0313a.InterfaceC0315b {

        /* renamed from: a */
        final /* synthetic */ C0313a f505a;

        C0325a(C0313a c0313a) {
            this.f505a = c0313a;
        }

        @Override // io.flutter.embedding.engine.C0313a.InterfaceC0315b
        /* renamed from: a */
        public void mo1576a() {
        }

        @Override // io.flutter.embedding.engine.C0313a.InterfaceC0315b
        /* renamed from: b */
        public void mo1575b() {
            C0324d.this.f504a.remove(this.f505a);
        }
    }

    /* renamed from: io.flutter.embedding.engine.d$b */
    /* loaded from: classes.dex */
    public static class C0326b {

        /* renamed from: a */
        private Context f507a;

        /* renamed from: b */
        private C0579a.C0581b f508b;

        /* renamed from: c */
        private String f509c;

        /* renamed from: d */
        private List<String> f510d;

        /* renamed from: e */
        private C0390r f511e;

        /* renamed from: f */
        private boolean f512f = true;

        /* renamed from: g */
        private boolean f513g = false;

        public C0326b(Context context) {
            this.f507a = context;
        }

        /* renamed from: a */
        public boolean m1574a() {
            return this.f512f;
        }

        /* renamed from: b */
        public Context m1573b() {
            return this.f507a;
        }

        /* renamed from: c */
        public C0579a.C0581b m1572c() {
            return this.f508b;
        }

        /* renamed from: d */
        public List<String> m1571d() {
            return this.f510d;
        }

        /* renamed from: e */
        public String m1570e() {
            return this.f509c;
        }

        /* renamed from: f */
        public C0390r m1569f() {
            return this.f511e;
        }

        /* renamed from: g */
        public boolean m1568g() {
            return this.f513g;
        }

        /* renamed from: h */
        public C0326b m1567h(boolean z) {
            this.f512f = z;
            return this;
        }

        /* renamed from: i */
        public C0326b m1566i(C0579a.C0581b c0581b) {
            this.f508b = c0581b;
            return this;
        }

        /* renamed from: j */
        public C0326b m1565j(List<String> list) {
            this.f510d = list;
            return this;
        }

        /* renamed from: k */
        public C0326b m1564k(String str) {
            this.f509c = str;
            return this;
        }

        /* renamed from: l */
        public C0326b m1563l(boolean z) {
            this.f513g = z;
            return this;
        }
    }

    public C0324d(Context context, String[] strArr) {
        C0632d m747c = C0572a.m745e().m747c();
        if (m747c.m674i()) {
            return;
        }
        m747c.m672k(context.getApplicationContext());
        m747c.m677f(context.getApplicationContext(), strArr);
    }

    /* renamed from: a */
    public C0313a m1578a(C0326b c0326b) {
        C0313a m1604y;
        Context m1573b = c0326b.m1573b();
        C0579a.C0581b m1572c = c0326b.m1572c();
        String m1570e = c0326b.m1570e();
        List<String> m1571d = c0326b.m1571d();
        C0390r m1569f = c0326b.m1569f();
        if (m1569f == null) {
            m1569f = new C0390r();
        }
        C0390r c0390r = m1569f;
        boolean m1574a = c0326b.m1574a();
        boolean m1568g = c0326b.m1568g();
        C0579a.C0581b m723a = m1572c == null ? C0579a.C0581b.m723a() : m1572c;
        if (this.f504a.size() == 0) {
            m1604y = m1577b(m1573b, c0390r, m1574a, m1568g);
            if (m1570e != null) {
                m1604y.m1615n().m136c(m1570e);
            }
            m1604y.m1619j().m729j(m723a, m1571d);
        } else {
            m1604y = this.f504a.get(0).m1604y(m1573b, m723a, m1570e, m1571d, c0390r, m1574a, m1568g);
        }
        this.f504a.add(m1604y);
        m1604y.m1624e(new C0325a(m1604y));
        return m1604y;
    }

    /* renamed from: b */
    C0313a m1577b(Context context, C0390r c0390r, boolean z, boolean z2) {
        return new C0313a(context, null, null, c0390r, null, z, z2, this);
    }
}