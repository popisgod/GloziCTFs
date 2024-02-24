package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.embedding.engine.b */
/* loaded from: classes.dex */
public class C0316b {

    /* renamed from: b */
    private static C0316b f477b;

    /* renamed from: a */
    private final Map<String, C0313a> f478a = new HashMap();

    C0316b() {
    }

    /* renamed from: b */
    public static C0316b m1602b() {
        if (f477b == null) {
            f477b = new C0316b();
        }
        return f477b;
    }

    /* renamed from: a */
    public C0313a m1603a(String str) {
        return this.f478a.get(str);
    }

    /* renamed from: c */
    public void m1601c(String str, C0313a c0313a) {
        if (c0313a != null) {
            this.f478a.put(str, c0313a);
        } else {
            this.f478a.remove(str);
        }
    }

    /* renamed from: d */
    public void m1600d(String str) {
        m1601c(str, null);
    }
}