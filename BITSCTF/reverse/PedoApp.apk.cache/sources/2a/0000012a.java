package p016g0;

import java.util.List;
import kotlin.jvm.internal.C0465i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g0.i */
/* loaded from: classes.dex */
public class C0187i extends C0186h {
    /* renamed from: b */
    public static <T> List<T> m1963b() {
        return C0197s.f237d;
    }

    /* renamed from: c */
    public static <T> int m1962c(List<? extends T> list) {
        C0465i.m1048e(list, "<this>");
        return list.size() - 1;
    }

    /* renamed from: d */
    public static <T> List<T> m1961d(T... elements) {
        List<T> m1963b;
        List<T> m1991a;
        C0465i.m1048e(elements, "elements");
        if (elements.length > 0) {
            m1991a = C0179d.m1991a(elements);
            return m1991a;
        }
        m1963b = m1963b();
        return m1963b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public static <T> List<T> m1960e(List<? extends T> list) {
        List<T> m1963b;
        C0465i.m1048e(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : C0186h.m1964a(list.get(0));
        }
        m1963b = m1963b();
        return m1963b;
    }

    /* renamed from: f */
    public static void m1959f() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}