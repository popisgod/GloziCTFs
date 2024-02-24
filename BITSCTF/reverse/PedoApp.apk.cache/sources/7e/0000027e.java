package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: kotlinx.coroutines.internal.p */
/* loaded from: classes.dex */
public class C0507p<E> {

    /* renamed from: a */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1034a = AtomicReferenceFieldUpdater.newUpdater(C0507p.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public C0507p(boolean z) {
        this._cur = new C0508q(8, z);
    }

    /* renamed from: a */
    public final boolean m925a(E e) {
        while (true) {
            C0508q c0508q = (C0508q) this._cur;
            int m921a = c0508q.m921a(e);
            if (m921a == 0) {
                return true;
            }
            if (m921a == 1) {
                C0476c.m1006a(f1034a, this, c0508q, c0508q.m913i());
            } else if (m921a == 2) {
                return false;
            }
        }
    }

    /* renamed from: b */
    public final void m924b() {
        while (true) {
            C0508q c0508q = (C0508q) this._cur;
            if (c0508q.m918d()) {
                return;
            }
            C0476c.m1006a(f1034a, this, c0508q, c0508q.m913i());
        }
    }

    /* renamed from: c */
    public final int m923c() {
        return ((C0508q) this._cur).m916f();
    }

    /* renamed from: d */
    public final E m922d() {
        while (true) {
            C0508q c0508q = (C0508q) this._cur;
            E e = (E) c0508q.m912j();
            if (e != C0508q.f1038h) {
                return e;
            }
            C0476c.m1006a(f1034a, this, c0508q, c0508q.m913i());
        }
    }
}