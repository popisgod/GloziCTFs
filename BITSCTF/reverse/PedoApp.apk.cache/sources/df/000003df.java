package p053z;

import java.util.HashMap;
import p001a0.C0029g;
import p001a0.C0032j;
import p001a0.C0033k;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.i */
/* loaded from: classes.dex */
public class C0860i {

    /* renamed from: a */
    public final C0033k f1491a;

    /* renamed from: b */
    private final C0033k.InterfaceC0037c f1492b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z.i$a */
    /* loaded from: classes.dex */
    public class C0861a implements C0033k.InterfaceC0037c {
        C0861a() {
            C0860i.this = r1;
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            interfaceC0038d.mo65b(null);
        }
    }

    public C0860i(C0579a c0579a) {
        C0861a c0861a = new C0861a();
        this.f1492b = c0861a;
        C0033k c0033k = new C0033k(c0579a, "flutter/navigation", C0029g.f37a);
        this.f1491a = c0033k;
        c0033k.m2269e(c0861a);
    }

    /* renamed from: a */
    public void m138a() {
        C0576b.m737f("NavigationChannel", "Sending message to pop route.");
        this.f1491a.m2271c("popRoute", null);
    }

    /* renamed from: b */
    public void m137b(String str) {
        C0576b.m737f("NavigationChannel", "Sending message to push route information '" + str + "'");
        HashMap hashMap = new HashMap();
        hashMap.put("location", str);
        this.f1491a.m2271c("pushRouteInformation", hashMap);
    }

    /* renamed from: c */
    public void m136c(String str) {
        C0576b.m737f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f1491a.m2271c("setInitialRoute", str);
    }
}