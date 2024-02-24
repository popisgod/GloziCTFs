package p044u0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.C0465i;

/* renamed from: u0.a */
/* loaded from: classes.dex */
public final class C0663a<T> implements InterfaceC0664b<T> {

    /* renamed from: a */
    private final AtomicReference<InterfaceC0664b<T>> f1284a;

    public C0663a(InterfaceC0664b<? extends T> sequence) {
        C0465i.m1048e(sequence, "sequence");
        this.f1284a = new AtomicReference<>(sequence);
    }

    @Override // p044u0.InterfaceC0664b
    public Iterator<T> iterator() {
        InterfaceC0664b<T> andSet = this.f1284a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}