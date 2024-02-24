package p027m;

import kotlin.jvm.internal.C0465i;
import p001a0.C0021d;
import p041t.InterfaceC0648a;

/* renamed from: m.a */
/* loaded from: classes.dex */
public final class C0561a implements InterfaceC0648a {

    /* renamed from: a */
    private C0021d f1140a;

    /* renamed from: b */
    private C0021d f1141b;

    @Override // p041t.InterfaceC0648a
    /* renamed from: g */
    public void mo638g(InterfaceC0648a.C0650b binding) {
        C0465i.m1048e(binding, "binding");
        C0021d c0021d = this.f1140a;
        if (c0021d == null) {
            C0465i.m1038o("stepDetectionChannel");
            c0021d = null;
        }
        c0021d.m2282d(null);
        C0021d c0021d2 = this.f1141b;
        if (c0021d2 == null) {
            C0465i.m1038o("stepCountChannel");
            c0021d2 = null;
        }
        c0021d2.m2282d(null);
    }

    @Override // p041t.InterfaceC0648a
    /* renamed from: i */
    public void mo637i(InterfaceC0648a.C0650b flutterPluginBinding) {
        C0465i.m1048e(flutterPluginBinding, "flutterPluginBinding");
        this.f1140a = new C0021d(flutterPluginBinding.m635b(), "step_detection");
        this.f1141b = new C0021d(flutterPluginBinding.m635b(), "step_count");
        C0564c c0564c = new C0564c(flutterPluginBinding, 18);
        C0564c c0564c2 = new C0564c(flutterPluginBinding, 19);
        C0021d c0021d = this.f1140a;
        C0021d c0021d2 = null;
        if (c0021d == null) {
            C0465i.m1038o("stepDetectionChannel");
            c0021d = null;
        }
        c0021d.m2282d(c0564c);
        C0021d c0021d3 = this.f1141b;
        if (c0021d3 == null) {
            C0465i.m1038o("stepCountChannel");
        } else {
            c0021d2 = c0021d3;
        }
        c0021d2.m2282d(c0564c2);
    }
}