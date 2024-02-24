package p016g0;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.C0465i;
import p014f0.C0160j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g0.z */
/* loaded from: classes.dex */
public class C0204z extends C0203y {
    /* renamed from: d */
    public static final <K, V> Map<K, V> m1923d() {
        C0198t c0198t = C0198t.f238d;
        C0465i.m1050c(c0198t, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c0198t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public static final <K, V> Map<K, V> m1922e(Map<K, ? extends V> map) {
        C0465i.m1048e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : C0203y.m1924c(map) : m1923d();
    }

    /* renamed from: f */
    public static final <K, V> void m1921f(Map<? super K, ? super V> map, Iterable<? extends C0160j<? extends K, ? extends V>> pairs) {
        C0465i.m1048e(map, "<this>");
        C0465i.m1048e(pairs, "pairs");
        for (C0160j<? extends K, ? extends V> c0160j : pairs) {
            map.put((K) c0160j.m2014a(), (V) c0160j.m2013b());
        }
    }

    /* renamed from: g */
    public static <K, V> Map<K, V> m1920g(Iterable<? extends C0160j<? extends K, ? extends V>> iterable) {
        C0465i.m1048e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return m1919h(iterable, new LinkedHashMap(C0201w.m1928a(collection.size())));
                }
                return C0203y.m1925b(iterable instanceof List ? (C0160j<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            return m1923d();
        }
        return m1922e(m1919h(iterable, new LinkedHashMap()));
    }

    /* renamed from: h */
    public static final <K, V, M extends Map<? super K, ? super V>> M m1919h(Iterable<? extends C0160j<? extends K, ? extends V>> iterable, M destination) {
        C0465i.m1048e(iterable, "<this>");
        C0465i.m1048e(destination, "destination");
        m1921f(destination, iterable);
        return destination;
    }
}