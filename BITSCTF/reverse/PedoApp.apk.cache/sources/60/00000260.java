package kotlinx.coroutines.internal;

import p046v0.C0690l;

/* renamed from: kotlinx.coroutines.internal.c0 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0477c0 {
    /* renamed from: a */
    public static final int m1005a(String str, int i, int i2, int i3) {
        return (int) C0473a0.m1013c(str, i, i2, i3);
    }

    /* renamed from: b */
    public static final long m1004b(String str, long j, long j2, long j3) {
        Long m562h;
        String m1012d = C0473a0.m1012d(str);
        if (m1012d == null) {
            return j;
        }
        m562h = C0690l.m562h(m1012d);
        if (m562h == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + m1012d + '\'').toString());
        }
        long longValue = m562h.longValue();
        boolean z = false;
        if (j2 <= longValue && longValue <= j3) {
            z = true;
        }
        if (z) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }

    /* renamed from: c */
    public static final boolean m1003c(String str, boolean z) {
        String m1012d = C0473a0.m1012d(str);
        return m1012d == null ? z : Boolean.parseBoolean(m1012d);
    }

    /* renamed from: d */
    public static /* synthetic */ int m1002d(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return C0473a0.m1014b(str, i, i2, i3);
    }

    /* renamed from: e */
    public static /* synthetic */ long m1001e(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return C0473a0.m1013c(str, j, j4, j3);
    }
}