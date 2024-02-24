package p004b;

/* renamed from: b.b */
/* loaded from: classes.dex */
class C0101b {

    /* renamed from: a */
    static final int[] f152a = new int[0];

    /* renamed from: b */
    static final long[] f153b = new long[0];

    /* renamed from: c */
    static final Object[] f154c = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m2133a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ (-1);
    }

    /* renamed from: b */
    public static boolean m2132b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}