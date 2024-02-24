package p011e;

import android.graphics.Insets;
import android.graphics.Rect;

/* renamed from: e.a */
/* loaded from: classes.dex */
public final class C0138a {

    /* renamed from: e */
    public static final C0138a f219e = new C0138a(0, 0, 0, 0);

    /* renamed from: a */
    public final int f220a;

    /* renamed from: b */
    public final int f221b;

    /* renamed from: c */
    public final int f222c;

    /* renamed from: d */
    public final int f223d;

    private C0138a(int i, int i2, int i3, int i4) {
        this.f220a = i;
        this.f221b = i2;
        this.f222c = i3;
        this.f223d = i4;
    }

    /* renamed from: a */
    public static C0138a m2046a(C0138a c0138a, C0138a c0138a2) {
        return m2045b(Math.max(c0138a.f220a, c0138a2.f220a), Math.max(c0138a.f221b, c0138a2.f221b), Math.max(c0138a.f222c, c0138a2.f222c), Math.max(c0138a.f223d, c0138a2.f223d));
    }

    /* renamed from: b */
    public static C0138a m2045b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f219e : new C0138a(i, i2, i3, i4);
    }

    /* renamed from: c */
    public static C0138a m2044c(Rect rect) {
        return m2045b(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: d */
    public static C0138a m2043d(Insets insets) {
        return m2045b(insets.left, insets.top, insets.right, insets.bottom);
    }

    /* renamed from: e */
    public Insets m2042e() {
        return Insets.of(this.f220a, this.f221b, this.f222c, this.f223d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0138a.class != obj.getClass()) {
            return false;
        }
        C0138a c0138a = (C0138a) obj;
        return this.f223d == c0138a.f223d && this.f220a == c0138a.f220a && this.f222c == c0138a.f222c && this.f221b == c0138a.f221b;
    }

    public int hashCode() {
        return (((((this.f220a * 31) + this.f221b) * 31) + this.f222c) * 31) + this.f223d;
    }

    public String toString() {
        return "Insets{left=" + this.f220a + ", top=" + this.f221b + ", right=" + this.f222c + ", bottom=" + this.f223d + '}';
    }
}