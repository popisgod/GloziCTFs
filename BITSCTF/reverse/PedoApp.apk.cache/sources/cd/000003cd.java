package p053z;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p001a0.C0032j;
import p001a0.C0033k;
import p001a0.C0047s;
import p031o.C0572a;
import p031o.C0576b;
import p033p.C0579a;
import p035q.InterfaceC0623a;

/* renamed from: z.b */
/* loaded from: classes.dex */
public class C0842b {

    /* renamed from: a */
    private final C0033k f1458a;

    /* renamed from: b */
    private InterfaceC0623a f1459b;

    /* renamed from: c */
    private Map<String, List<C0033k.InterfaceC0038d>> f1460c;

    /* renamed from: d */
    final C0033k.InterfaceC0037c f1461d;

    /* renamed from: z.b$a */
    /* loaded from: classes.dex */
    class C0843a implements C0033k.InterfaceC0037c {
        C0843a() {
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            String str;
            if (C0842b.this.f1459b == null) {
                return;
            }
            String str2 = c0032j.f38a;
            Map map = (Map) c0032j.m2274a();
            C0576b.m737f("DeferredComponentChannel", "Received '" + str2 + "' message.");
            int intValue = ((Integer) map.get("loadingUnitId")).intValue();
            String str3 = (String) map.get("componentName");
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1004447972:
                    if (str2.equals("uninstallDeferredComponent")) {
                        c = 0;
                        break;
                    }
                    break;
                case 399701758:
                    if (str2.equals("getDeferredComponentInstallState")) {
                        c = 1;
                        break;
                    }
                    break;
                case 520962947:
                    if (str2.equals("installDeferredComponent")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    C0842b.this.f1459b.m697c(intValue, str3);
                    str = null;
                    break;
                case 1:
                    str = C0842b.this.f1459b.m699a(intValue, str3);
                    break;
                case 2:
                    C0842b.this.f1459b.m698b(intValue, str3);
                    if (!C0842b.this.f1460c.containsKey(str3)) {
                        C0842b.this.f1460c.put(str3, new ArrayList());
                    }
                    ((List) C0842b.this.f1460c.get(str3)).add(interfaceC0038d);
                    return;
                default:
                    interfaceC0038d.mo64c();
                    return;
            }
            interfaceC0038d.mo65b(str);
        }
    }

    public C0842b(C0579a c0579a) {
        C0843a c0843a = new C0843a();
        this.f1461d = c0843a;
        C0033k c0033k = new C0033k(c0579a, "flutter/deferredcomponent", C0047s.f53b);
        this.f1458a = c0033k;
        c0033k.m2269e(c0843a);
        this.f1459b = C0572a.m745e().m749a();
        this.f1460c = new HashMap();
    }

    /* renamed from: c */
    public void m162c(InterfaceC0623a interfaceC0623a) {
        this.f1459b = interfaceC0623a;
    }
}