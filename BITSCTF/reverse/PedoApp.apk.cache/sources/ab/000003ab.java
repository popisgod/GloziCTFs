package p051y;

import io.flutter.embedding.engine.C0313a;
import io.flutter.plugins.GeneratedPluginRegistrant;
import p031o.C0576b;

/* renamed from: y.a */
/* loaded from: classes.dex */
public class C0808a {
    /* renamed from: a */
    public static void m236a(C0313a c0313a) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", C0313a.class).invoke(null, c0313a);
        } catch (Exception e) {
            C0576b.m741b("GeneratedPluginsRegister", "Tried to automatically register plugins with FlutterEngine (" + c0313a + ") but could not find or invoke the GeneratedPluginRegistrant.");
            C0576b.m740c("GeneratedPluginsRegister", "Received exception while registering", e);
        }
    }
}