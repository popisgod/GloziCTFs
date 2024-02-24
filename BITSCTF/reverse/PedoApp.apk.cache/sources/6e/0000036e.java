package p048w0;

import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p034p0.InterfaceC0611l;

/* renamed from: w0.k */
/* loaded from: classes.dex */
public interface InterfaceC0747k<T> extends InterfaceC0244d<T> {

    /* renamed from: w0.k$a */
    /* loaded from: classes.dex */
    public static final class C0748a {
        /* renamed from: a */
        public static /* synthetic */ Object m446a(InterfaceC0747k interfaceC0747k, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return interfaceC0747k.mo431g(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    /* renamed from: g */
    Object mo431g(T t, Object obj);

    /* renamed from: k */
    void mo427k(InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l);

    /* renamed from: o */
    Object mo423o(T t, Object obj, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l);

    /* renamed from: p */
    Object mo422p(Throwable th);

    /* renamed from: q */
    void mo421q(Object obj);

    /* renamed from: r */
    void mo420r(T t, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l);
}