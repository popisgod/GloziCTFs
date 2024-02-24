package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.internal.C0473a0;
import kotlinx.coroutines.internal.C0477c0;
import p040s0.C0647f;
import p048w0.AbstractC0722f0;

/* renamed from: kotlinx.coroutines.scheduling.b */
/* loaded from: classes.dex */
public final class C0526b extends C0527c {

    /* renamed from: k */
    public static final C0526b f1085k;

    /* renamed from: l */
    private static final AbstractC0722f0 f1086l;

    static {
        int m645a;
        int m1002d;
        C0526b c0526b = new C0526b();
        f1085k = c0526b;
        m645a = C0647f.m645a(64, C0473a0.m1015a());
        m1002d = C0477c0.m1002d("kotlinx.coroutines.io.parallelism", m645a, 0, 0, 12, null);
        f1086l = new ExecutorC0529e(c0526b, m1002d, "Dispatchers.IO", 1);
    }

    private C0526b() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    /* renamed from: s */
    public final AbstractC0722f0 m836s() {
        return f1086l;
    }

    @Override // p048w0.AbstractC0722f0
    public String toString() {
        return "Dispatchers.Default";
    }
}