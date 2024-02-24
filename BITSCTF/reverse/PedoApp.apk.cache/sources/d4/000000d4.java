package p004b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: b.c */
/* loaded from: classes.dex */
public abstract class AbstractC0102c<K, V> {

    /* renamed from: a */
    AbstractC0102c<K, V>.C0104b f155a;

    /* renamed from: b */
    AbstractC0102c<K, V>.C0105c f156b;

    /* renamed from: c */
    AbstractC0102c<K, V>.C0107e f157c;

    /* renamed from: b.c$a */
    /* loaded from: classes.dex */
    final class C0103a<T> implements Iterator<T> {

        /* renamed from: d */
        final int f158d;

        /* renamed from: e */
        int f159e;

        /* renamed from: f */
        int f160f;

        /* renamed from: g */
        boolean f161g = false;

        C0103a(int i) {
            this.f158d = i;
            this.f159e = AbstractC0102c.this.mo2128d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f160f < this.f159e;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) AbstractC0102c.this.mo2130b(this.f160f, this.f158d);
                this.f160f++;
                this.f161g = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f161g) {
                throw new IllegalStateException();
            }
            int i = this.f160f - 1;
            this.f160f = i;
            this.f159e--;
            this.f161g = false;
            AbstractC0102c.this.mo2124h(i);
        }
    }

    /* renamed from: b.c$b */
    /* loaded from: classes.dex */
    final class C0104b implements Set<Map.Entry<K, V>> {
        C0104b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int mo2128d = AbstractC0102c.this.mo2128d();
            for (Map.Entry<K, V> entry : collection) {
                AbstractC0102c.this.mo2125g(entry.getKey(), entry.getValue());
            }
            return mo2128d != AbstractC0102c.this.mo2128d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0102c.this.mo2131a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int mo2127e = AbstractC0102c.this.mo2127e(entry.getKey());
                if (mo2127e < 0) {
                    return false;
                }
                return C0101b.m2132b(AbstractC0102c.this.mo2130b(mo2127e, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0102c.m2121k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int mo2128d = AbstractC0102c.this.mo2128d() - 1; mo2128d >= 0; mo2128d--) {
                Object mo2130b = AbstractC0102c.this.mo2130b(mo2128d, 0);
                Object mo2130b2 = AbstractC0102c.this.mo2130b(mo2128d, 1);
                i += (mo2130b == null ? 0 : mo2130b.hashCode()) ^ (mo2130b2 == null ? 0 : mo2130b2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0102c.this.mo2128d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0106d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0102c.this.mo2128d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: b.c$c */
    /* loaded from: classes.dex */
    final class C0105c implements Set<K> {
        C0105c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0102c.this.mo2131a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0102c.this.mo2127e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return AbstractC0102c.m2122j(AbstractC0102c.this.mo2129c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0102c.m2121k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int mo2128d = AbstractC0102c.this.mo2128d() - 1; mo2128d >= 0; mo2128d--) {
                Object mo2130b = AbstractC0102c.this.mo2130b(mo2128d, 0);
                i += mo2130b == null ? 0 : mo2130b.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0102c.this.mo2128d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new C0103a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int mo2127e = AbstractC0102c.this.mo2127e(obj);
            if (mo2127e >= 0) {
                AbstractC0102c.this.mo2124h(mo2127e);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return AbstractC0102c.m2117o(AbstractC0102c.this.mo2129c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return AbstractC0102c.m2116p(AbstractC0102c.this.mo2129c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0102c.this.mo2128d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC0102c.this.m2115q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0102c.this.m2114r(tArr, 0);
        }
    }

    /* renamed from: b.c$d */
    /* loaded from: classes.dex */
    final class C0106d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: d */
        int f165d;

        /* renamed from: f */
        boolean f167f = false;

        /* renamed from: e */
        int f166e = -1;

        C0106d() {
            this.f165d = AbstractC0102c.this.mo2128d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f166e++;
                this.f167f = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f167f) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return C0101b.m2132b(entry.getKey(), AbstractC0102c.this.mo2130b(this.f166e, 0)) && C0101b.m2132b(entry.getValue(), AbstractC0102c.this.mo2130b(this.f166e, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f167f) {
                return (K) AbstractC0102c.this.mo2130b(this.f166e, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f167f) {
                return (V) AbstractC0102c.this.mo2130b(this.f166e, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f166e < this.f165d;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f167f) {
                Object mo2130b = AbstractC0102c.this.mo2130b(this.f166e, 0);
                Object mo2130b2 = AbstractC0102c.this.mo2130b(this.f166e, 1);
                return (mo2130b == null ? 0 : mo2130b.hashCode()) ^ (mo2130b2 != null ? mo2130b2.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f167f) {
                throw new IllegalStateException();
            }
            AbstractC0102c.this.mo2124h(this.f166e);
            this.f166e--;
            this.f165d--;
            this.f167f = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f167f) {
                return (V) AbstractC0102c.this.mo2123i(this.f166e, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: b.c$e */
    /* loaded from: classes.dex */
    final class C0107e implements Collection<V> {
        C0107e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC0102c.this.mo2131a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0102c.this.mo2126f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC0102c.this.mo2128d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new C0103a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int mo2126f = AbstractC0102c.this.mo2126f(obj);
            if (mo2126f >= 0) {
                AbstractC0102c.this.mo2124h(mo2126f);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int mo2128d = AbstractC0102c.this.mo2128d();
            int i = 0;
            boolean z = false;
            while (i < mo2128d) {
                if (collection.contains(AbstractC0102c.this.mo2130b(i, 1))) {
                    AbstractC0102c.this.mo2124h(i);
                    i--;
                    mo2128d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int mo2128d = AbstractC0102c.this.mo2128d();
            int i = 0;
            boolean z = false;
            while (i < mo2128d) {
                if (!collection.contains(AbstractC0102c.this.mo2130b(i, 1))) {
                    AbstractC0102c.this.mo2124h(i);
                    i--;
                    mo2128d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC0102c.this.mo2128d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC0102c.this.m2115q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0102c.this.m2114r(tArr, 1);
        }
    }

    /* renamed from: j */
    public static <K, V> boolean m2122j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public static <T> boolean m2121k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: o */
    public static <K, V> boolean m2117o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: p */
    public static <K, V> boolean m2116p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: a */
    protected abstract void mo2131a();

    /* renamed from: b */
    protected abstract Object mo2130b(int i, int i2);

    /* renamed from: c */
    protected abstract Map<K, V> mo2129c();

    /* renamed from: d */
    protected abstract int mo2128d();

    /* renamed from: e */
    protected abstract int mo2127e(Object obj);

    /* renamed from: f */
    protected abstract int mo2126f(Object obj);

    /* renamed from: g */
    protected abstract void mo2125g(K k, V v);

    /* renamed from: h */
    protected abstract void mo2124h(int i);

    /* renamed from: i */
    protected abstract V mo2123i(int i, V v);

    /* renamed from: l */
    public Set<Map.Entry<K, V>> m2120l() {
        if (this.f155a == null) {
            this.f155a = new C0104b();
        }
        return this.f155a;
    }

    /* renamed from: m */
    public Set<K> m2119m() {
        if (this.f156b == null) {
            this.f156b = new C0105c();
        }
        return this.f156b;
    }

    /* renamed from: n */
    public Collection<V> m2118n() {
        if (this.f157c == null) {
            this.f157c = new C0107e();
        }
        return this.f157c;
    }

    /* renamed from: q */
    public Object[] m2115q(int i) {
        int mo2128d = mo2128d();
        Object[] objArr = new Object[mo2128d];
        for (int i2 = 0; i2 < mo2128d; i2++) {
            objArr[i2] = mo2130b(i2, i);
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: r */
    public <T> T[] m2114r(T[] tArr, int i) {
        int mo2128d = mo2128d();
        if (tArr.length < mo2128d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), mo2128d));
        }
        for (int i2 = 0; i2 < mo2128d; i2++) {
            tArr[i2] = mo2130b(i2, i);
        }
        if (tArr.length > mo2128d) {
            tArr[mo2128d] = null;
        }
        return tArr;
    }
}