package p052y0;

import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0169q;
import p034p0.InterfaceC0611l;

/* renamed from: y0.n */
/* loaded from: classes.dex */
public class C0832n<E> extends AbstractC0809a<E> {
    public C0832n(InterfaceC0611l<? super E, C0169q> interfaceC0611l) {
        super(interfaceC0611l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p052y0.AbstractC0815c
    /* renamed from: i */
    public Object mo190i(E e) {
        InterfaceC0835q<?> m214k;
        do {
            Object mo190i = super.mo190i(e);
            C0520z c0520z = C0814b.f1425b;
            if (mo190i == c0520z) {
                return c0520z;
            }
            if (mo190i != C0814b.f1426c) {
                if (mo190i instanceof C0828j) {
                    return mo190i;
                }
                throw new IllegalStateException(C0465i.m1043j("Invalid offerInternal result ", mo190i).toString());
            }
            m214k = m214k(e);
            if (m214k == null) {
                return c0520z;
            }
        } while (!(m214k instanceof C0828j));
        return m214k;
    }

    @Override // p052y0.AbstractC0809a
    /* renamed from: r */
    protected final boolean mo184r() {
        return true;
    }

    @Override // p052y0.AbstractC0809a
    /* renamed from: s */
    protected final boolean mo183s() {
        return true;
    }
}