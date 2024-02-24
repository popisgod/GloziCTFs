package p052y0;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0520z;
import p014f0.C0159i;
import p014f0.C0169q;
import p016g0.C0179d;
import p034p0.InterfaceC0611l;
import p048w0.C0755m;
import p048w0.C0768p0;

/* renamed from: y0.d */
/* loaded from: classes.dex */
public class C0817d<E> extends AbstractC0809a<E> {

    /* renamed from: e */
    private final int f1434e;

    /* renamed from: f */
    private final EnumC0819e f1435f;

    /* renamed from: g */
    private final ReentrantLock f1436g;

    /* renamed from: h */
    private Object[] f1437h;

    /* renamed from: i */
    private int f1438i;
    private volatile /* synthetic */ int size;

    /* renamed from: y0.d$a */
    /* loaded from: classes.dex */
    public /* synthetic */ class C0818a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1439a;

        static {
            int[] iArr = new int[EnumC0819e.values().length];
            iArr[EnumC0819e.SUSPEND.ordinal()] = 1;
            iArr[EnumC0819e.DROP_LATEST.ordinal()] = 2;
            iArr[EnumC0819e.DROP_OLDEST.ordinal()] = 3;
            f1439a = iArr;
        }
    }

    public C0817d(int i, EnumC0819e enumC0819e, InterfaceC0611l<? super E, C0169q> interfaceC0611l) {
        super(interfaceC0611l);
        this.f1434e = i;
        this.f1435f = enumC0819e;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.f1436g = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        C0179d.m1987e(objArr, C0814b.f1424a, 0, 0, 6, null);
        C0169q c0169q = C0169q.f235a;
        this.f1437h = objArr;
        this.size = 0;
    }

    /* renamed from: x */
    private final void m211x(int i, E e) {
        if (i < this.f1434e) {
            m210y(i);
            Object[] objArr = this.f1437h;
            objArr[(this.f1438i + i) % objArr.length] = e;
            return;
        }
        if (C0768p0.m398a()) {
            if (!(this.f1435f == EnumC0819e.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.f1437h;
        int i2 = this.f1438i;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e;
        this.f1438i = (i2 + 1) % objArr2.length;
    }

    /* renamed from: y */
    private final void m210y(int i) {
        Object[] objArr = this.f1437h;
        if (i >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f1434e);
            Object[] objArr2 = new Object[min];
            if (i > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    Object[] objArr3 = this.f1437h;
                    objArr2[i2] = objArr3[(this.f1438i + i2) % objArr3.length];
                    if (i3 >= i) {
                        break;
                    }
                    i2 = i3;
                }
            }
            C0179d.m1988d(objArr2, C0814b.f1424a, i, min);
            this.f1437h = objArr2;
            this.f1438i = 0;
        }
    }

    /* renamed from: z */
    private final C0520z m209z(int i) {
        if (i < this.f1434e) {
            this.size = i + 1;
            return null;
        }
        int i2 = C0818a.f1439a[this.f1435f.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return null;
                }
                throw new C0159i();
            }
            return C0814b.f1425b;
        }
        return C0814b.f1426c;
    }

    @Override // p052y0.AbstractC0815c
    /* renamed from: c */
    protected String mo194c() {
        return "(buffer:capacity=" + this.f1434e + ",size=" + this.size + ')';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p052y0.AbstractC0815c
    /* renamed from: i */
    public Object mo190i(E e) {
        InterfaceC0835q<E> mo213l;
        C0520z mo185h;
        ReentrantLock reentrantLock = this.f1436g;
        reentrantLock.lock();
        try {
            int i = this.size;
            C0828j<?> m220d = m220d();
            if (m220d == null) {
                C0520z m209z = m209z(i);
                if (m209z == null) {
                    if (i == 0) {
                        do {
                            mo213l = mo213l();
                            if (mo213l != null) {
                                if (mo213l instanceof C0828j) {
                                    this.size = i;
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
                        this.size = i;
                        C0169q c0169q = C0169q.f235a;
                        reentrantLock.unlock();
                        mo213l.mo187d(e);
                        return mo213l.mo186e();
                    }
                    m211x(i, e);
                    return C0814b.f1425b;
                }
                return m209z;
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
        ReentrantLock reentrantLock = this.f1436g;
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
        return this.size == 0;
    }

    @Override // p052y0.AbstractC0809a
    /* renamed from: v */
    protected Object mo192v() {
        ReentrantLock reentrantLock = this.f1436g;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object m220d = m220d();
                if (m220d == null) {
                    m220d = C0814b.f1427d;
                }
                return m220d;
            }
            Object[] objArr = this.f1437h;
            int i2 = this.f1438i;
            Object obj = objArr[i2];
            AbstractC0837s abstractC0837s = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object obj2 = C0814b.f1427d;
            if (i == this.f1434e) {
                AbstractC0837s abstractC0837s2 = null;
                while (true) {
                    AbstractC0837s m212m = m212m();
                    if (m212m == null) {
                        abstractC0837s = abstractC0837s2;
                        break;
                    }
                    C0520z mo182A = m212m.mo182A(null);
                    if (mo182A != null) {
                        if (C0768p0.m398a()) {
                            if (!(mo182A == C0755m.f1345a)) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = m212m.mo179z();
                        abstractC0837s = m212m;
                        r6 = true;
                    } else {
                        m212m.m181B();
                        abstractC0837s2 = m212m;
                    }
                }
            }
            if (obj2 != C0814b.f1427d && !(obj2 instanceof C0828j)) {
                this.size = i;
                Object[] objArr2 = this.f1437h;
                objArr2[(this.f1438i + i) % objArr2.length] = obj2;
            }
            this.f1438i = (this.f1438i + 1) % this.f1437h.length;
            C0169q c0169q = C0169q.f235a;
            if (r6) {
                C0465i.m1051b(abstractC0837s);
                abstractC0837s.mo180y();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}