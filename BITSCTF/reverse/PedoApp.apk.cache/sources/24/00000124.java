package p016g0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C0465i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g0.e */
/* loaded from: classes.dex */
public class C0181e extends C0179d {
    /* renamed from: g */
    public static char m1984g(char[] cArr) {
        C0465i.m1048e(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* renamed from: h */
    public static <T> T m1983h(T[] tArr) {
        C0465i.m1048e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    /* renamed from: i */
    public static final <T> T[] m1982i(T[] tArr, Comparator<? super T> comparator) {
        C0465i.m1048e(tArr, "<this>");
        C0465i.m1048e(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        C0465i.m1049d(tArr2, "copyOf(this, size)");
        C0179d.m1986f(tArr2, comparator);
        return tArr2;
    }

    /* renamed from: j */
    public static <T> List<T> m1981j(T[] tArr, Comparator<? super T> comparator) {
        List<T> m1991a;
        C0465i.m1048e(tArr, "<this>");
        C0465i.m1048e(comparator, "comparator");
        m1991a = C0179d.m1991a(m1982i(tArr, comparator));
        return m1991a;
    }
}