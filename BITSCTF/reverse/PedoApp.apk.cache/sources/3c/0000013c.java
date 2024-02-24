package p017h;

import android.os.Build;
import android.view.DisplayCutout;
import p015g.C0171b;

/* renamed from: h.a */
/* loaded from: classes.dex */
public final class C0205a {

    /* renamed from: a */
    private final Object f240a;

    private C0205a(Object obj) {
        this.f240a = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static C0205a m1914e(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0205a(obj);
    }

    /* renamed from: a */
    public int m1918a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f240a).getSafeInsetBottom();
        }
        return 0;
    }

    /* renamed from: b */
    public int m1917b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f240a).getSafeInsetLeft();
        }
        return 0;
    }

    /* renamed from: c */
    public int m1916c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f240a).getSafeInsetRight();
        }
        return 0;
    }

    /* renamed from: d */
    public int m1915d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f240a).getSafeInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0205a.class != obj.getClass()) {
            return false;
        }
        return C0171b.m2002a(this.f240a, ((C0205a) obj).f240a);
    }

    public int hashCode() {
        Object obj = this.f240a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f240a + "}";
    }
}