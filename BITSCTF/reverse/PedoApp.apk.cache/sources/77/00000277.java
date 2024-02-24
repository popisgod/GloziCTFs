package kotlinx.coroutines.internal;

import p014f0.C0161k;
import p014f0.C0164l;

/* renamed from: kotlinx.coroutines.internal.k */
/* loaded from: classes.dex */
public final class C0500k {

    /* renamed from: a */
    private static final boolean f1026a;

    static {
        Object m2010a;
        try {
            C0161k.C0162a c0162a = C0161k.f229d;
            m2010a = C0161k.m2010a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            C0161k.C0162a c0162a2 = C0161k.f229d;
            m2010a = C0161k.m2010a(C0164l.m2006a(th));
        }
        f1026a = C0161k.m2007d(m2010a);
    }

    /* renamed from: a */
    public static final boolean m949a() {
        return f1026a;
    }
}