package p044u0;

import java.util.Iterator;
import kotlin.jvm.internal.C0465i;
import p034p0.InterfaceC0611l;

/* renamed from: u0.i */
/* loaded from: classes.dex */
public final class C0672i<T, R> implements InterfaceC0664b<R> {

    /* renamed from: a */
    private final InterfaceC0664b<T> f1286a;

    /* renamed from: b */
    private final InterfaceC0611l<T, R> f1287b;

    /* renamed from: u0.i$a */
    /* loaded from: classes.dex */
    public static final class C0673a implements Iterator<R> {

        /* renamed from: d */
        private final Iterator<T> f1288d;

        /* renamed from: e */
        final /* synthetic */ C0672i<T, R> f1289e;

        C0673a(C0672i<T, R> c0672i) {
            this.f1289e = c0672i;
            this.f1288d = ((C0672i) c0672i).f1286a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1288d.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((C0672i) this.f1289e).f1287b.invoke(this.f1288d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0672i(InterfaceC0664b<? extends T> sequence, InterfaceC0611l<? super T, ? extends R> transformer) {
        C0465i.m1048e(sequence, "sequence");
        C0465i.m1048e(transformer, "transformer");
        this.f1286a = sequence;
        this.f1287b = transformer;
    }

    @Override // p044u0.InterfaceC0664b
    public Iterator<R> iterator() {
        return new C0673a(this);
    }
}