package p025l;

import android.app.Activity;
import android.content.Context;
import p001a0.C0033k;
import p001a0.InterfaceC0016c;
import p001a0.InterfaceC0042o;
import p041t.InterfaceC0648a;
import p043u.InterfaceC0659a;
import p043u.InterfaceC0661c;

/* renamed from: l.m */
/* loaded from: classes.dex */
public final class C0551m implements InterfaceC0648a, InterfaceC0659a {

    /* renamed from: a */
    private C0552n f1128a;

    /* renamed from: b */
    private C0033k f1129b;

    /* renamed from: c */
    private InterfaceC0042o f1130c;

    /* renamed from: d */
    private InterfaceC0661c f1131d;

    /* renamed from: e */
    private C0550l f1132e;

    /* renamed from: e */
    private void m805e() {
        InterfaceC0661c interfaceC0661c = this.f1131d;
        if (interfaceC0661c != null) {
            interfaceC0661c.mo615d(this.f1128a);
            this.f1131d.mo614e(this.f1128a);
        }
    }

    /* renamed from: f */
    private void m804f() {
        InterfaceC0042o interfaceC0042o = this.f1130c;
        if (interfaceC0042o != null) {
            interfaceC0042o.m2267b(this.f1128a);
            this.f1130c.m2266c(this.f1128a);
            return;
        }
        InterfaceC0661c interfaceC0661c = this.f1131d;
        if (interfaceC0661c != null) {
            interfaceC0661c.mo617b(this.f1128a);
            this.f1131d.mo616c(this.f1128a);
        }
    }

    /* renamed from: h */
    private void m803h(Context context, InterfaceC0016c interfaceC0016c) {
        this.f1129b = new C0033k(interfaceC0016c, "flutter.baseflow.com/permissions/methods");
        C0550l c0550l = new C0550l(context, new C0538a(), this.f1128a, new C0557p());
        this.f1132e = c0550l;
        this.f1129b.m2269e(c0550l);
    }

    /* renamed from: j */
    private void m802j(Activity activity) {
        C0552n c0552n = this.f1128a;
        if (c0552n != null) {
            c0552n.m790j(activity);
        }
    }

    /* renamed from: k */
    private void m801k() {
        this.f1129b.m2269e(null);
        this.f1129b = null;
        this.f1132e = null;
    }

    /* renamed from: l */
    private void m800l() {
        C0552n c0552n = this.f1128a;
        if (c0552n != null) {
            c0552n.m790j(null);
        }
    }

    @Override // p043u.InterfaceC0659a
    /* renamed from: a */
    public void mo631a(InterfaceC0661c interfaceC0661c) {
        mo629c(interfaceC0661c);
    }

    @Override // p043u.InterfaceC0659a
    /* renamed from: b */
    public void mo630b() {
        m800l();
        m805e();
        this.f1131d = null;
    }

    @Override // p043u.InterfaceC0659a
    /* renamed from: c */
    public void mo629c(InterfaceC0661c interfaceC0661c) {
        m802j(interfaceC0661c.mo618a());
        this.f1131d = interfaceC0661c;
        m804f();
    }

    @Override // p043u.InterfaceC0659a
    /* renamed from: d */
    public void mo628d() {
        mo630b();
    }

    @Override // p041t.InterfaceC0648a
    /* renamed from: g */
    public void mo638g(InterfaceC0648a.C0650b c0650b) {
        m801k();
    }

    @Override // p041t.InterfaceC0648a
    /* renamed from: i */
    public void mo637i(InterfaceC0648a.C0650b c0650b) {
        this.f1128a = new C0552n(c0650b.m636a());
        m803h(c0650b.m636a(), c0650b.m635b());
    }
}