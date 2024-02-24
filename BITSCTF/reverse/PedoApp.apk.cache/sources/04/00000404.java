package p053z;

import java.util.HashMap;
import p001a0.C0008a;
import p001a0.C0028f;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.p */
/* loaded from: classes.dex */
public class C0897p {

    /* renamed from: a */
    public final C0008a<Object> f1614a;

    public C0897p(C0579a c0579a) {
        this.f1614a = new C0008a<>(c0579a, "flutter/system", C0028f.f36a);
    }

    /* renamed from: a */
    public void m44a() {
        C0576b.m737f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f1614a.m2290c(hashMap);
    }
}