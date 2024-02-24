package p048w0;

import kotlinx.coroutines.internal.C0487g;
import p020i0.InterfaceC0244d;

/* renamed from: w0.n */
/* loaded from: classes.dex */
public final class C0758n {
    /* renamed from: a */
    public static final <T> C0752l<T> m409a(InterfaceC0244d<? super T> interfaceC0244d) {
        if (interfaceC0244d instanceof C0487g) {
            C0752l<T> m977i = ((C0487g) interfaceC0244d).m977i();
            if (m977i == null || !m977i.m438G()) {
                m977i = null;
            }
            return m977i == null ? new C0752l<>(interfaceC0244d, 2) : m977i;
        }
        return new C0752l<>(interfaceC0244d, 1);
    }
}