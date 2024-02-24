package p016g0;

import java.util.Collections;
import java.util.Map;
import kotlin.jvm.internal.C0465i;
import p014f0.C0160j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g0.y */
/* loaded from: classes.dex */
public class C0203y extends C0202x {
    /* renamed from: a */
    public static int m1926a(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m1925b(C0160j<? extends K, ? extends V> pair) {
        C0465i.m1048e(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.m2012c(), pair.m2011d());
        C0465i.m1049d(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    /* renamed from: c */
    public static final <K, V> Map<K, V> m1924c(Map<? extends K, ? extends V> map) {
        C0465i.m1048e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C0465i.m1049d(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}