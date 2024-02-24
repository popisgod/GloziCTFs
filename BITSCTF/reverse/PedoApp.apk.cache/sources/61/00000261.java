package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p048w0.C0768p0;

/* renamed from: kotlinx.coroutines.internal.d */
/* loaded from: classes.dex */
public abstract class AbstractC0478d<T> extends AbstractC0516v {

    /* renamed from: a */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f994a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0478d.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = C0474b.f991a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.AbstractC0516v
    /* renamed from: a */
    public AbstractC0478d<?> mo894a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.AbstractC0516v
    /* renamed from: c */
    public final Object mo892c(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == C0474b.f991a) {
            obj2 = m1000e(mo223g(obj));
        }
        mo927d(obj, obj2);
        return obj2;
    }

    /* renamed from: d */
    public abstract void mo927d(T t, Object obj);

    /* renamed from: e */
    public final Object m1000e(Object obj) {
        if (C0768p0.m398a()) {
            if (!(obj != C0474b.f991a)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        Object obj3 = C0474b.f991a;
        return obj2 != obj3 ? obj2 : C0476c.m1006a(f994a, this, obj3, obj) ? obj : this._consensus;
    }

    /* renamed from: f */
    public long m999f() {
        return 0L;
    }

    /* renamed from: g */
    public abstract Object mo223g(T t);
}