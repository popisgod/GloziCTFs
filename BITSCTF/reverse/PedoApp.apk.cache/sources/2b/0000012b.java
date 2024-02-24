package p016g0;

import java.util.Collection;
import kotlin.jvm.internal.C0465i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g0.j */
/* loaded from: classes.dex */
public class C0188j extends C0187i {
    /* renamed from: g */
    public static <T> int m1958g(Iterable<? extends T> iterable, int i) {
        C0465i.m1048e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}