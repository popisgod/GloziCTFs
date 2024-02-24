package p040s0;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: s0.f */
/* loaded from: classes.dex */
public class C0647f extends C0646e {
    /* renamed from: a */
    public static int m645a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    /* renamed from: b */
    public static long m644b(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    /* renamed from: c */
    public static int m643c(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    /* renamed from: d */
    public static long m642d(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    /* renamed from: e */
    public static int m641e(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    /* renamed from: f */
    public static C0640a m640f(int i, int i2) {
        return C0640a.f1262g.m659a(i, i2, -1);
    }

    /* renamed from: g */
    public static C0643c m639g(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? C0643c.f1270h.m653a() : new C0643c(i, i2 - 1);
    }
}