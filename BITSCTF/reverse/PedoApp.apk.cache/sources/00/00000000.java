package p000a;

import java.util.HashMap;
import p000a.C0001b;

/* renamed from: a.a */
/* loaded from: classes.dex */
public class C0000a<K, V> extends C0001b<K, V> {

    /* renamed from: h */
    private HashMap<K, C0001b.C0004c<K, V>> f0h = new HashMap<>();

    @Override // p000a.C0001b
    /* renamed from: c */
    protected C0001b.C0004c<K, V> mo2302c(K k) {
        return this.f0h.get(k);
    }

    public boolean contains(K k) {
        return this.f0h.containsKey(k);
    }

    @Override // p000a.C0001b
    /* renamed from: f */
    public V mo2299f(K k) {
        V v = (V) super.mo2299f(k);
        this.f0h.remove(k);
        return v;
    }
}