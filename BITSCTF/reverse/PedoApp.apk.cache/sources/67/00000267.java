package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.InterfaceC0486f0;
import p048w0.C0768p0;

/* renamed from: kotlinx.coroutines.internal.e0 */
/* loaded from: classes.dex */
public class C0484e0<T extends InterfaceC0486f0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a */
    private T[] f1003a;

    /* renamed from: f */
    private final T[] m986f() {
        T[] tArr = this.f1003a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new InterfaceC0486f0[4];
            this.f1003a = tArr2;
            return tArr2;
        } else if (m989c() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, m989c() * 2);
            C0465i.m1049d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((InterfaceC0486f0[]) copyOf);
            this.f1003a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    /* renamed from: j */
    private final void m982j(int i) {
        this._size = i;
    }

    /* renamed from: k */
    private final void m981k(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= m989c()) {
                return;
            }
            T[] tArr = this.f1003a;
            C0465i.m1051b(tArr);
            int i3 = i2 + 1;
            if (i3 < m989c()) {
                T t = tArr[i3];
                C0465i.m1051b(t);
                T t2 = tArr[i2];
                C0465i.m1051b(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            C0465i.m1051b(t3);
            T t4 = tArr[i2];
            C0465i.m1051b(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m979m(i, i2);
            i = i2;
        }
    }

    /* renamed from: l */
    private final void m980l(int i) {
        while (i > 0) {
            T[] tArr = this.f1003a;
            C0465i.m1051b(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            C0465i.m1051b(t);
            T t2 = tArr[i];
            C0465i.m1051b(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m979m(i, i2);
            i = i2;
        }
    }

    /* renamed from: m */
    private final void m979m(int i, int i2) {
        T[] tArr = this.f1003a;
        C0465i.m1051b(tArr);
        T t = tArr[i2];
        C0465i.m1051b(t);
        T t2 = tArr[i];
        C0465i.m1051b(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.mo493c(i);
        t2.mo493c(i2);
    }

    /* renamed from: a */
    public final void m991a(T t) {
        if (C0768p0.m398a()) {
            if (!(t.mo494a() == null)) {
                throw new AssertionError();
            }
        }
        t.mo492d(this);
        T[] m986f = m986f();
        int m989c = m989c();
        m982j(m989c + 1);
        m986f[m989c] = t;
        t.mo493c(m989c);
        m980l(m989c);
    }

    /* renamed from: b */
    public final T m990b() {
        T[] tArr = this.f1003a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    /* renamed from: c */
    public final int m989c() {
        return this._size;
    }

    /* renamed from: d */
    public final boolean m988d() {
        return m989c() == 0;
    }

    /* renamed from: e */
    public final T m987e() {
        T m990b;
        synchronized (this) {
            m990b = m990b();
        }
        return m990b;
    }

    /* renamed from: g */
    public final boolean m985g(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.mo494a() == null) {
                z = false;
            } else {
                int mo491e = t.mo491e();
                if (C0768p0.m398a()) {
                    if (!(mo491e >= 0)) {
                        throw new AssertionError();
                    }
                }
                m984h(mo491e);
            }
        }
        return z;
    }

    /* renamed from: h */
    public final T m984h(int i) {
        if (C0768p0.m398a()) {
            if (!(m989c() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f1003a;
        C0465i.m1051b(tArr);
        m982j(m989c() - 1);
        if (i < m989c()) {
            m979m(i, m989c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                C0465i.m1051b(t);
                T t2 = tArr[i2];
                C0465i.m1051b(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m979m(i, i2);
                    m980l(i2);
                }
            }
            m981k(i);
        }
        T t3 = tArr[m989c()];
        C0465i.m1051b(t3);
        if (C0768p0.m398a()) {
            if (!(t3.mo494a() == this)) {
                throw new AssertionError();
            }
        }
        t3.mo492d(null);
        t3.mo493c(-1);
        tArr[m989c()] = null;
        return t3;
    }

    /* renamed from: i */
    public final T m983i() {
        T m984h;
        synchronized (this) {
            m984h = m989c() > 0 ? m984h(0) : null;
        }
        return m984h;
    }
}