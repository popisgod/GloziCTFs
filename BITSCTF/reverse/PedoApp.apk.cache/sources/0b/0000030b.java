package p041t;

import android.content.Context;
import io.flutter.embedding.engine.C0313a;
import io.flutter.embedding.engine.C0324d;
import io.flutter.plugin.platform.InterfaceC0379h;
import io.flutter.view.TextureRegistry;
import p001a0.InterfaceC0016c;

/* renamed from: t.a */
/* loaded from: classes.dex */
public interface InterfaceC0648a {

    /* renamed from: t.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0649a {
    }

    /* renamed from: t.a$b */
    /* loaded from: classes.dex */
    public static class C0650b {

        /* renamed from: a */
        private final Context f1272a;

        /* renamed from: b */
        private final C0313a f1273b;

        /* renamed from: c */
        private final InterfaceC0016c f1274c;

        /* renamed from: d */
        private final TextureRegistry f1275d;

        /* renamed from: e */
        private final InterfaceC0379h f1276e;

        /* renamed from: f */
        private final InterfaceC0649a f1277f;

        /* renamed from: g */
        private final C0324d f1278g;

        public C0650b(Context context, C0313a c0313a, InterfaceC0016c interfaceC0016c, TextureRegistry textureRegistry, InterfaceC0379h interfaceC0379h, InterfaceC0649a interfaceC0649a, C0324d c0324d) {
            this.f1272a = context;
            this.f1273b = c0313a;
            this.f1274c = interfaceC0016c;
            this.f1275d = textureRegistry;
            this.f1276e = interfaceC0379h;
            this.f1277f = interfaceC0649a;
            this.f1278g = c0324d;
        }

        /* renamed from: a */
        public Context m636a() {
            return this.f1272a;
        }

        /* renamed from: b */
        public InterfaceC0016c m635b() {
            return this.f1274c;
        }
    }

    /* renamed from: g */
    void mo638g(C0650b c0650b);

    /* renamed from: i */
    void mo637i(C0650b c0650b);
}