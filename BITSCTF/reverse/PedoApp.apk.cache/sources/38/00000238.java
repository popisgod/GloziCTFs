package p024k0;

/* renamed from: k0.c */
/* loaded from: classes.dex */
public final class C0442c {
    /* renamed from: a */
    private static final int m1075a(int i, int i2, int i3) {
        return m1073c(m1073c(i, i3) - m1073c(i2, i3), i3);
    }

    /* renamed from: b */
    public static final int m1074b(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - m1075a(i2, i, i3);
        } else if (i3 < 0) {
            return i <= i2 ? i2 : i2 + m1075a(i, i2, -i3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    /* renamed from: c */
    private static final int m1073c(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }
}