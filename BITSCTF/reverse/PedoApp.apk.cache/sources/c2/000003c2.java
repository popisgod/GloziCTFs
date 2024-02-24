package p052y0;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.C0490h0;
import kotlinx.coroutines.internal.C0514u;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0169q;
import p034p0.InterfaceC0611l;
import p048w0.C0755m;
import p048w0.C0768p0;

/* renamed from: y0.m */
/* loaded from: classes.dex */
public class C0831m<E> extends AbstractC0809a<E> {

    /* renamed from: e */
    private final ReentrantLock f1451e;

    /* renamed from: f */
    private Object f1452f;

    public C0831m(InterfaceC0611l<? super E, C0169q> interfaceC0611l) {
        super(interfaceC0611l);
        this.f1451e = new ReentrantLock();
        this.f1452f = C0814b.f1424a;
    }

    /* renamed from: x */
    private final C0490h0 m191x(Object obj) {
        InterfaceC0611l<E, C0169q> interfaceC0611l;
        Object obj2 = this.f1452f;
        C0490h0 c0490h0 = null;
        if (obj2 != C0814b.f1424a && (interfaceC0611l = this.f1431b) != null) {
            c0490h0 = C0514u.m896d(interfaceC0611l, obj2, null, 2, null);
        }
        this.f1452f = obj;
        return c0490h0;
    }

    @Override // p052y0.AbstractC0815c
    /* renamed from: c */
    protected String mo194c() {
        return "(value=" + this.f1452f + ')';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p052y0.AbstractC0815c
    /* renamed from: i */
    public Object mo190i(E e) {
        InterfaceC0835q<E> mo213l;
        C0520z mo185h;
        ReentrantLock reentrantLock = this.f1451e;
        reentrantLock.lock();
        try {
            C0828j<?> m220d = m220d();
            if (m220d == null) {
                if (this.f1452f == C0814b.f1424a) {
                    do {
                        mo213l = mo213l();
                        if (mo213l != null) {
                            if (mo213l instanceof C0828j) {
                                return mo213l;
                            }
                            mo185h = mo213l.mo185h(e, null);
                        }
                    } while (mo185h == null);
                    if (C0768p0.m398a()) {
                        if (!(mo185h == C0755m.f1345a)) {
                            throw new AssertionError();
                        }
                    }
                    C0169q c0169q = C0169q.f235a;
                    reentrantLock.unlock();
                    mo213l.mo187d(e);
                    return mo213l.mo186e();
                }
                C0490h0 m191x = m191x(e);
                if (m191x == null) {
                    return C0814b.f1425b;
                }
                throw m191x;
            }
            return m220d;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p052y0.AbstractC0809a
    /* renamed from: q */
    public boolean mo193q(AbstractC0833o<? super E> abstractC0833o) {
        ReentrantLock reentrantLock = this.f1451e;
        reentrantLock.lock();
        try {
            return super.mo193q(abstractC0833o);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p052y0.AbstractC0809a
    /* renamed from: r */
    protected final boolean mo184r() {
        return false;
    }

    @Override // p052y0.AbstractC0809a
    /* renamed from: s */
    protected final boolean mo183s() {
        return this.f1452f == C0814b.f1424a;
    }

    @Override // p052y0.AbstractC0809a
    /* renamed from: v */
    protected Object mo192v() {
        ReentrantLock reentrantLock = this.f1451e;
        reentrantLock.lock();
        try {
            Object obj = this.f1452f;
            C0520z c0520z = C0814b.f1424a;
            if (obj != c0520z) {
                this.f1452f = c0520z;
                C0169q c0169q = C0169q.f235a;
                return obj;
            }
            Object m220d = m220d();
            if (m220d == null) {
                m220d = C0814b.f1427d;
            }
            return m220d;
        } finally {
            reentrantLock.unlock();
        }
    }
}