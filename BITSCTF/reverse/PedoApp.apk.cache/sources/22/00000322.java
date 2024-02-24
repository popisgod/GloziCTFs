package p044u0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.C0465i;
import p016g0.C0187i;
import p034p0.InterfaceC0611l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: u0.h */
/* loaded from: classes.dex */
public class C0671h extends C0670g {
    /* renamed from: c */
    public static <T, R> InterfaceC0664b<R> m606c(InterfaceC0664b<? extends T> interfaceC0664b, InterfaceC0611l<? super T, ? extends R> transform) {
        C0465i.m1048e(interfaceC0664b, "<this>");
        C0465i.m1048e(transform, "transform");
        return new C0672i(interfaceC0664b, transform);
    }

    /* renamed from: d */
    public static final <T, C extends Collection<? super T>> C m605d(InterfaceC0664b<? extends T> interfaceC0664b, C destination) {
        C0465i.m1048e(interfaceC0664b, "<this>");
        C0465i.m1048e(destination, "destination");
        for (T t : interfaceC0664b) {
            destination.add(t);
        }
        return destination;
    }

    /* renamed from: e */
    public static <T> List<T> m604e(InterfaceC0664b<? extends T> interfaceC0664b) {
        List<T> m1960e;
        C0465i.m1048e(interfaceC0664b, "<this>");
        m1960e = C0187i.m1960e(m603f(interfaceC0664b));
        return m1960e;
    }

    /* renamed from: f */
    public static final <T> List<T> m603f(InterfaceC0664b<? extends T> interfaceC0664b) {
        C0465i.m1048e(interfaceC0664b, "<this>");
        return (List) m605d(interfaceC0664b, new ArrayList());
    }
}