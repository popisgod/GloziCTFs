package p004b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: b.a */
/* loaded from: classes.dex */
public class C0099a<K, V> extends C0108d<K, V> implements Map<K, V> {

    /* renamed from: k */
    AbstractC0102c<K, V> f150k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.a$a */
    /* loaded from: classes.dex */
    public class C0100a extends AbstractC0102c<K, V> {
        C0100a() {
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: a */
        protected void mo2131a() {
            C0099a.this.clear();
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: b */
        protected Object mo2130b(int i, int i2) {
            return C0099a.this.f175e[(i << 1) + i2];
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: c */
        protected Map<K, V> mo2129c() {
            return C0099a.this;
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: d */
        protected int mo2128d() {
            return C0099a.this.f176f;
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: e */
        protected int mo2127e(Object obj) {
            return C0099a.this.m2106f(obj);
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: f */
        protected int mo2126f(Object obj) {
            return C0099a.this.m2104h(obj);
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: g */
        protected void mo2125g(K k, V v) {
            C0099a.this.put(k, v);
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: h */
        protected void mo2124h(int i) {
            C0099a.this.m2102j(i);
        }

        @Override // p004b.AbstractC0102c
        /* renamed from: i */
        protected V mo2123i(int i, V v) {
            return C0099a.this.m2101k(i, v);
        }
    }

    /* renamed from: m */
    private AbstractC0102c<K, V> m2134m() {
        if (this.f150k == null) {
            this.f150k = new C0100a();
        }
        return this.f150k;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m2134m().m2120l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m2134m().m2119m();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m2109c(this.f176f + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m2134m().m2118n();
    }
}