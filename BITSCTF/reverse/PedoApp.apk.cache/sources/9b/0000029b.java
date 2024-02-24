package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.C0473a0;
import kotlinx.coroutines.internal.C0477c0;
import p040s0.C0647f;

/* renamed from: kotlinx.coroutines.scheduling.l */
/* loaded from: classes.dex */
public final class C0536l {

    /* renamed from: a */
    public static final long f1104a;

    /* renamed from: b */
    public static final int f1105b;

    /* renamed from: c */
    public static final int f1106c;

    /* renamed from: d */
    public static final int f1107d;

    /* renamed from: e */
    public static final long f1108e;

    /* renamed from: f */
    public static AbstractC0532h f1109f;

    static {
        long m1001e;
        int m1002d;
        int m645a;
        int m1002d2;
        int m641e;
        int m1002d3;
        long m1001e2;
        m1001e = C0477c0.m1001e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f1104a = m1001e;
        m1002d = C0477c0.m1002d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f1105b = m1002d;
        m645a = C0647f.m645a(C0473a0.m1015a(), 2);
        m1002d2 = C0477c0.m1002d("kotlinx.coroutines.scheduler.core.pool.size", m645a, 1, 0, 8, null);
        f1106c = m1002d2;
        m641e = C0647f.m641e(C0473a0.m1015a() * 128, m1002d2, 2097150);
        m1002d3 = C0477c0.m1002d("kotlinx.coroutines.scheduler.max.pool.size", m641e, 0, 2097150, 4, null);
        f1107d = m1002d3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        m1001e2 = C0477c0.m1001e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f1108e = timeUnit.toNanos(m1001e2);
        f1109f = C0530f.f1098a;
    }
}