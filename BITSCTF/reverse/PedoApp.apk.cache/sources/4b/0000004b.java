package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.AbstractC0080a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC0080a abstractC0080a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f87a = abstractC0080a.m2172p(iconCompat.f87a, 1);
        iconCompat.f89c = abstractC0080a.m2175j(iconCompat.f89c, 2);
        iconCompat.f90d = abstractC0080a.m2171r(iconCompat.f90d, 3);
        iconCompat.f91e = abstractC0080a.m2172p(iconCompat.f91e, 4);
        iconCompat.f92f = abstractC0080a.m2172p(iconCompat.f92f, 5);
        iconCompat.f93g = (ColorStateList) abstractC0080a.m2171r(iconCompat.f93g, 6);
        iconCompat.f95i = abstractC0080a.m2170t(iconCompat.f95i, 7);
        iconCompat.f96j = abstractC0080a.m2170t(iconCompat.f96j, 8);
        iconCompat.m2221c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC0080a abstractC0080a) {
        abstractC0080a.m2167x(true, true);
        iconCompat.m2220d(abstractC0080a.m2177f());
        int i = iconCompat.f87a;
        if (-1 != i) {
            abstractC0080a.m2187F(i, 1);
        }
        byte[] bArr = iconCompat.f89c;
        if (bArr != null) {
            abstractC0080a.m2189B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f90d;
        if (parcelable != null) {
            abstractC0080a.m2186H(parcelable, 3);
        }
        int i2 = iconCompat.f91e;
        if (i2 != 0) {
            abstractC0080a.m2187F(i2, 4);
        }
        int i3 = iconCompat.f92f;
        if (i3 != 0) {
            abstractC0080a.m2187F(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.f93g;
        if (colorStateList != null) {
            abstractC0080a.m2186H(colorStateList, 6);
        }
        String str = iconCompat.f95i;
        if (str != null) {
            abstractC0080a.m2185J(str, 7);
        }
        String str2 = iconCompat.f96j;
        if (str2 != null) {
            abstractC0080a.m2185J(str2, 8);
        }
    }
}