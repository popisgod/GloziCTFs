package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.embedding.engine.e */
/* loaded from: classes.dex */
public class C0327e {

    /* renamed from: b */
    private static volatile C0327e f514b;

    /* renamed from: a */
    private final Map<String, C0324d> f515a = new HashMap();

    C0327e() {
    }

    /* renamed from: b */
    public static C0327e m1561b() {
        if (f514b == null) {
            synchronized (C0327e.class) {
                if (f514b == null) {
                    f514b = new C0327e();
                }
            }
        }
        return f514b;
    }

    /* renamed from: a */
    public C0324d m1562a(String str) {
        return this.f515a.get(str);
    }
}