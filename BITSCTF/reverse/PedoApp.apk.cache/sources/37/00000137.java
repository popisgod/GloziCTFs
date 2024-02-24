package p016g0;

import java.util.Iterator;

/* renamed from: g0.v */
/* loaded from: classes.dex */
public abstract class AbstractC0200v implements Iterator<Integer> {
    /* renamed from: a */
    public abstract int mo658a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(mo658a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}