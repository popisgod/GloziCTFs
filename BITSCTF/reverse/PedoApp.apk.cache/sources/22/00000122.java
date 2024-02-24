package p016g0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.C0465i;

/* renamed from: g0.d */
/* loaded from: classes.dex */
public class C0179d extends C0177c {
    /* renamed from: a */
    public static <T> List<T> m1991a(T[] tArr) {
        C0465i.m1048e(tArr, "<this>");
        List<T> m1978a = C0183f.m1978a(tArr);
        C0465i.m1049d(m1978a, "asList(this)");
        return m1978a;
    }

    /* renamed from: b */
    public static final <T> T[] m1990b(T[] tArr, T[] destination, int i, int i2, int i3) {
        C0465i.m1048e(tArr, "<this>");
        C0465i.m1048e(destination, "destination");
        System.arraycopy(tArr, i2, destination, i, i3 - i2);
        return destination;
    }

    /* renamed from: c */
    public static /* synthetic */ Object[] m1989c(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return m1990b(objArr, objArr2, i, i2, i3);
    }

    /* renamed from: d */
    public static <T> void m1988d(T[] tArr, T t, int i, int i2) {
        C0465i.m1048e(tArr, "<this>");
        Arrays.fill(tArr, i, i2, t);
    }

    /* renamed from: e */
    public static /* synthetic */ void m1987e(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        m1988d(objArr, obj, i, i2);
    }

    /* renamed from: f */
    public static final <T> void m1986f(T[] tArr, Comparator<? super T> comparator) {
        C0465i.m1048e(tArr, "<this>");
        C0465i.m1048e(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}