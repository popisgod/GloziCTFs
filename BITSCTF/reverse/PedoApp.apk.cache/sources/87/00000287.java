package kotlinx.coroutines.internal;

import p048w0.C0771q0;

/* renamed from: kotlinx.coroutines.internal.v */
/* loaded from: classes.dex */
public abstract class AbstractC0516v {
    /* renamed from: a */
    public abstract AbstractC0478d<?> mo894a();

    /* renamed from: b */
    public final boolean m893b(AbstractC0516v abstractC0516v) {
        AbstractC0478d<?> mo894a;
        AbstractC0478d<?> mo894a2 = mo894a();
        return (mo894a2 == null || (mo894a = abstractC0516v.mo894a()) == null || mo894a2.m999f() >= mo894a.m999f()) ? false : true;
    }

    /* renamed from: c */
    public abstract Object mo892c(Object obj);

    public String toString() {
        return C0771q0.m392a(this) + '@' + C0771q0.m391b(this);
    }
}