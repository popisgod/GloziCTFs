package p016g0;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.C0465i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: g0.n */
/* loaded from: classes.dex */
public class C0192n extends C0191m {
    /* renamed from: h */
    public static <T> boolean m1957h(Collection<? super T> collection, Iterable<? extends T> elements) {
        C0465i.m1048e(collection, "<this>");
        C0465i.m1048e(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        boolean z = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }
}