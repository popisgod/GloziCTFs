package p016g0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.C0465i;
import p034p0.InterfaceC0611l;
import p046v0.C0681e;

/* renamed from: g0.q */
/* loaded from: classes.dex */
public class C0195q extends C0194p {
    /* renamed from: i */
    public static final <T, A extends Appendable> A m1956i(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, InterfaceC0611l<? super T, ? extends CharSequence> interfaceC0611l) {
        C0465i.m1048e(iterable, "<this>");
        C0465i.m1048e(buffer, "buffer");
        C0465i.m1048e(separator, "separator");
        C0465i.m1048e(prefix, "prefix");
        C0465i.m1048e(postfix, "postfix");
        C0465i.m1048e(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            C0681e.m571a(buffer, t, interfaceC0611l);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    /* renamed from: k */
    public static final <T> String m1954k(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, InterfaceC0611l<? super T, ? extends CharSequence> interfaceC0611l) {
        C0465i.m1048e(iterable, "<this>");
        C0465i.m1048e(separator, "separator");
        C0465i.m1048e(prefix, "prefix");
        C0465i.m1048e(postfix, "postfix");
        C0465i.m1048e(truncated, "truncated");
        String sb = ((StringBuilder) m1956i(iterable, new StringBuilder(), separator, prefix, postfix, i, truncated, interfaceC0611l)).toString();
        C0465i.m1049d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    /* renamed from: l */
    public static /* synthetic */ String m1953l(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0611l interfaceC0611l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i2 & 2) != 0 ? "" : charSequence2;
        String str2 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i2 & 32) != 0) {
            interfaceC0611l = null;
        }
        return m1954k(iterable, charSequence, str, str2, i3, charSequence5, interfaceC0611l);
    }

    /* renamed from: m */
    public static <T extends Comparable<? super T>> T m1952m(Iterable<? extends T> iterable) {
        C0465i.m1048e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    /* renamed from: n */
    public static <T> T m1951n(Iterable<? extends T> iterable) {
        C0465i.m1048e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) m1950o((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    /* renamed from: o */
    public static final <T> T m1950o(List<? extends T> list) {
        C0465i.m1048e(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* renamed from: p */
    public static final <T, C extends Collection<? super T>> C m1949p(Iterable<? extends T> iterable, C destination) {
        C0465i.m1048e(iterable, "<this>");
        C0465i.m1048e(destination, "destination");
        for (T t : iterable) {
            destination.add(t);
        }
        return destination;
    }

    /* renamed from: q */
    public static <T> List<T> m1948q(Iterable<? extends T> iterable) {
        List<T> m1960e;
        List<T> m1963b;
        C0465i.m1048e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            m1960e = C0187i.m1960e(m1947r(iterable));
            return m1960e;
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            m1963b = C0187i.m1963b();
            return m1963b;
        } else if (size != 1) {
            return m1946s(collection);
        } else {
            return C0186h.m1964a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
    }

    /* renamed from: r */
    public static final <T> List<T> m1947r(Iterable<? extends T> iterable) {
        C0465i.m1048e(iterable, "<this>");
        return iterable instanceof Collection ? m1946s((Collection) iterable) : (List) m1949p(iterable, new ArrayList());
    }

    /* renamed from: s */
    public static final <T> List<T> m1946s(Collection<? extends T> collection) {
        C0465i.m1048e(collection, "<this>");
        return new ArrayList(collection);
    }

    /* renamed from: t */
    public static <T> Set<T> m1945t(Iterable<? extends T> iterable) {
        Set<T> m1980b;
        int m1926a;
        C0465i.m1048e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                m1980b = C0182e0.m1980b();
                return m1980b;
            } else if (size == 1) {
                return C0180d0.m1985a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            } else {
                m1926a = C0203y.m1926a(collection.size());
                return (Set) m1949p(iterable, new LinkedHashSet(m1926a));
            }
        }
        return C0182e0.m1979c((Set) m1949p(iterable, new LinkedHashSet()));
    }
}