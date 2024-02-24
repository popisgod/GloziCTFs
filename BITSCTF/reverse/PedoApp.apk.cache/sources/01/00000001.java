package p000a;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: a.b */
/* loaded from: classes.dex */
public class C0001b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: d */
    C0004c<K, V> f1d;

    /* renamed from: e */
    private C0004c<K, V> f2e;

    /* renamed from: f */
    private WeakHashMap<InterfaceC0007f<K, V>, Boolean> f3f = new WeakHashMap<>();

    /* renamed from: g */
    private int f4g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.b$a */
    /* loaded from: classes.dex */
    public static class C0002a<K, V> extends AbstractC0006e<K, V> {
        C0002a(C0004c<K, V> c0004c, C0004c<K, V> c0004c2) {
            super(c0004c, c0004c2);
        }

        @Override // p000a.C0001b.AbstractC0006e
        /* renamed from: b */
        C0004c<K, V> mo2297b(C0004c<K, V> c0004c) {
            return c0004c.f8g;
        }

        @Override // p000a.C0001b.AbstractC0006e
        /* renamed from: c */
        C0004c<K, V> mo2296c(C0004c<K, V> c0004c) {
            return c0004c.f7f;
        }
    }

    /* renamed from: a.b$b */
    /* loaded from: classes.dex */
    private static class C0003b<K, V> extends AbstractC0006e<K, V> {
        C0003b(C0004c<K, V> c0004c, C0004c<K, V> c0004c2) {
            super(c0004c, c0004c2);
        }

        @Override // p000a.C0001b.AbstractC0006e
        /* renamed from: b */
        C0004c<K, V> mo2297b(C0004c<K, V> c0004c) {
            return c0004c.f7f;
        }

        @Override // p000a.C0001b.AbstractC0006e
        /* renamed from: c */
        C0004c<K, V> mo2296c(C0004c<K, V> c0004c) {
            return c0004c.f8g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.b$c */
    /* loaded from: classes.dex */
    public static class C0004c<K, V> implements Map.Entry<K, V> {

        /* renamed from: d */
        final K f5d;

        /* renamed from: e */
        final V f6e;

        /* renamed from: f */
        C0004c<K, V> f7f;

        /* renamed from: g */
        C0004c<K, V> f8g;

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0004c) {
                C0004c c0004c = (C0004c) obj;
                return this.f5d.equals(c0004c.f5d) && this.f6e.equals(c0004c.f6e);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5d;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f6e;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f5d.hashCode() ^ this.f6e.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f5d + "=" + this.f6e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a.b$d */
    /* loaded from: classes.dex */
    public class C0005d implements Iterator<Map.Entry<K, V>>, InterfaceC0007f<K, V> {

        /* renamed from: d */
        private C0004c<K, V> f9d;

        /* renamed from: e */
        private boolean f10e = true;

        C0005d() {
        }

        @Override // p000a.C0001b.InterfaceC0007f
        /* renamed from: a */
        public void mo2293a(C0004c<K, V> c0004c) {
            C0004c<K, V> c0004c2 = this.f9d;
            if (c0004c == c0004c2) {
                C0004c<K, V> c0004c3 = c0004c2.f8g;
                this.f9d = c0004c3;
                this.f10e = c0004c3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            C0004c<K, V> c0004c;
            if (this.f10e) {
                this.f10e = false;
                c0004c = C0001b.this.f1d;
            } else {
                C0004c<K, V> c0004c2 = this.f9d;
                c0004c = c0004c2 != null ? c0004c2.f7f : null;
            }
            this.f9d = c0004c;
            return this.f9d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f10e) {
                return C0001b.this.f1d != null;
            }
            C0004c<K, V> c0004c = this.f9d;
            return (c0004c == null || c0004c.f7f == null) ? false : true;
        }
    }

    /* renamed from: a.b$e */
    /* loaded from: classes.dex */
    private static abstract class AbstractC0006e<K, V> implements Iterator<Map.Entry<K, V>>, InterfaceC0007f<K, V> {

        /* renamed from: d */
        C0004c<K, V> f12d;

        /* renamed from: e */
        C0004c<K, V> f13e;

        AbstractC0006e(C0004c<K, V> c0004c, C0004c<K, V> c0004c2) {
            this.f12d = c0004c2;
            this.f13e = c0004c;
        }

        /* renamed from: e */
        private C0004c<K, V> m2294e() {
            C0004c<K, V> c0004c = this.f13e;
            C0004c<K, V> c0004c2 = this.f12d;
            if (c0004c == c0004c2 || c0004c2 == null) {
                return null;
            }
            return mo2296c(c0004c);
        }

        @Override // p000a.C0001b.InterfaceC0007f
        /* renamed from: a */
        public void mo2293a(C0004c<K, V> c0004c) {
            if (this.f12d == c0004c && c0004c == this.f13e) {
                this.f13e = null;
                this.f12d = null;
            }
            C0004c<K, V> c0004c2 = this.f12d;
            if (c0004c2 == c0004c) {
                this.f12d = mo2297b(c0004c2);
            }
            if (this.f13e == c0004c) {
                this.f13e = m2294e();
            }
        }

        /* renamed from: b */
        abstract C0004c<K, V> mo2297b(C0004c<K, V> c0004c);

        /* renamed from: c */
        abstract C0004c<K, V> mo2296c(C0004c<K, V> c0004c);

        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry<K, V> next() {
            C0004c<K, V> c0004c = this.f13e;
            this.f13e = m2294e();
            return c0004c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13e != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.b$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0007f<K, V> {
        /* renamed from: a */
        void mo2293a(C0004c<K, V> c0004c);
    }

    /* renamed from: a */
    public Iterator<Map.Entry<K, V>> m2304a() {
        C0003b c0003b = new C0003b(this.f2e, this.f1d);
        this.f3f.put(c0003b, Boolean.FALSE);
        return c0003b;
    }

    /* renamed from: b */
    public Map.Entry<K, V> m2303b() {
        return this.f1d;
    }

    /* renamed from: c */
    protected C0004c<K, V> mo2302c(K k) {
        C0004c<K, V> c0004c = this.f1d;
        while (c0004c != null && !c0004c.f5d.equals(k)) {
            c0004c = c0004c.f7f;
        }
        return c0004c;
    }

    /* renamed from: d */
    public C0001b<K, V>.C0005d m2301d() {
        C0001b<K, V>.C0005d c0005d = new C0005d();
        this.f3f.put(c0005d, Boolean.FALSE);
        return c0005d;
    }

    /* renamed from: e */
    public Map.Entry<K, V> m2300e() {
        return this.f2e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0001b) {
            C0001b c0001b = (C0001b) obj;
            if (size() != c0001b.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = c0001b.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    /* renamed from: f */
    public V mo2299f(K k) {
        C0004c<K, V> mo2302c = mo2302c(k);
        if (mo2302c == null) {
            return null;
        }
        this.f4g--;
        if (!this.f3f.isEmpty()) {
            for (InterfaceC0007f<K, V> interfaceC0007f : this.f3f.keySet()) {
                interfaceC0007f.mo2293a(mo2302c);
            }
        }
        C0004c<K, V> c0004c = mo2302c.f8g;
        C0004c<K, V> c0004c2 = mo2302c.f7f;
        if (c0004c != null) {
            c0004c.f7f = c0004c2;
        } else {
            this.f1d = c0004c2;
        }
        C0004c<K, V> c0004c3 = mo2302c.f7f;
        if (c0004c3 != null) {
            c0004c3.f8g = c0004c;
        } else {
            this.f2e = c0004c;
        }
        mo2302c.f7f = null;
        mo2302c.f8g = null;
        return mo2302c.f6e;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        C0002a c0002a = new C0002a(this.f1d, this.f2e);
        this.f3f.put(c0002a, Boolean.FALSE);
        return c0002a;
    }

    public int size() {
        return this.f4g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}