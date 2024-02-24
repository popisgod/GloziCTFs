package p030n0;

import java.io.Closeable;
import p014f0.C0152b;

/* renamed from: n0.a */
/* loaded from: classes.dex */
public final class C0571a {
    /* renamed from: a */
    public static final void m750a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                C0152b.m2017a(th, th2);
            }
        }
    }
}