package p053z;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.C0408c;
import java.util.HashMap;
import p001a0.C0008a;
import p001a0.C0045r;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.a */
/* loaded from: classes.dex */
public class C0839a {

    /* renamed from: a */
    public final C0008a<Object> f1453a;

    /* renamed from: b */
    public final FlutterJNI f1454b;

    /* renamed from: c */
    private InterfaceC0841b f1455c;

    /* renamed from: d */
    public final C0008a.InterfaceC0013d<Object> f1456d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z.a$a */
    /* loaded from: classes.dex */
    public class C0840a implements C0008a.InterfaceC0013d<Object> {
        C0840a() {
            C0839a.this = r1;
        }

        @Override // p001a0.C0008a.InterfaceC0013d
        /* renamed from: a */
        public void mo170a(Object obj, C0008a.InterfaceC0014e<Object> interfaceC0014e) {
            if (C0839a.this.f1455c == null) {
                interfaceC0014e.mo56a(null);
                return;
            }
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            HashMap hashMap2 = (HashMap) hashMap.get("data");
            C0576b.m737f("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1140076541:
                    if (str.equals("tooltip")) {
                        c = 0;
                        break;
                    }
                    break;
                case -649620375:
                    if (str.equals("announce")) {
                        c = 1;
                        break;
                    }
                    break;
                case 114595:
                    if (str.equals("tap")) {
                        c = 2;
                        break;
                    }
                    break;
                case 97604824:
                    if (str.equals("focus")) {
                        c = 3;
                        break;
                    }
                    break;
                case 114203431:
                    if (str.equals("longPress")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        C0839a.this.f1455c.mo169c(str2);
                        break;
                    }
                    break;
                case 1:
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        C0839a.this.f1455c.mo165g(str3);
                        break;
                    }
                    break;
                case 2:
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        C0839a.this.f1455c.mo166f(num.intValue());
                        break;
                    }
                    break;
                case 3:
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        C0839a.this.f1455c.mo168d(num2.intValue());
                        break;
                    }
                    break;
                case 4:
                    Integer num3 = (Integer) hashMap.get("nodeId");
                    if (num3 != null) {
                        C0839a.this.f1455c.mo167e(num3.intValue());
                        break;
                    }
                    break;
            }
            interfaceC0014e.mo56a(null);
        }
    }

    /* renamed from: z.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0841b extends FlutterJNI.InterfaceC0310a {
        /* renamed from: c */
        void mo169c(String str);

        /* renamed from: d */
        void mo168d(int i);

        /* renamed from: e */
        void mo167e(int i);

        /* renamed from: f */
        void mo166f(int i);

        /* renamed from: g */
        void mo165g(String str);
    }

    public C0839a(C0579a c0579a, FlutterJNI flutterJNI) {
        C0840a c0840a = new C0840a();
        this.f1456d = c0840a;
        C0008a<Object> c0008a = new C0008a<>(c0579a, "flutter/accessibility", C0045r.f50a);
        this.f1453a = c0008a;
        c0008a.m2288e(c0840a);
        this.f1454b = flutterJNI;
    }

    /* renamed from: b */
    public void m176b(int i, C0408c.EnumC0415g enumC0415g) {
        this.f1454b.dispatchSemanticsAction(i, enumC0415g);
    }

    /* renamed from: c */
    public void m175c(int i, C0408c.EnumC0415g enumC0415g, Object obj) {
        this.f1454b.dispatchSemanticsAction(i, enumC0415g, obj);
    }

    /* renamed from: d */
    public void m174d() {
        this.f1454b.setSemanticsEnabled(false);
    }

    /* renamed from: e */
    public void m173e() {
        this.f1454b.setSemanticsEnabled(true);
    }

    /* renamed from: f */
    public void m172f(int i) {
        this.f1454b.setAccessibilityFeatures(i);
    }

    /* renamed from: g */
    public void m171g(InterfaceC0841b interfaceC0841b) {
        this.f1455c = interfaceC0841b;
        this.f1454b.setAccessibilityDelegate(interfaceC0841b);
    }
}