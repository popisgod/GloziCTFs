package p016g0;

import java.util.Set;
import kotlin.jvm.internal.C0465i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g0.e0 */
/* loaded from: classes.dex */
public class C0182e0 extends C0180d0 {
    /* renamed from: b */
    public static <T> Set<T> m1980b() {
        return C0199u.f239d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public static final <T> Set<T> m1979c(Set<? extends T> set) {
        C0465i.m1048e(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : C0180d0.m1985a(set.iterator().next()) : C0178c0.m1992b();
    }
}