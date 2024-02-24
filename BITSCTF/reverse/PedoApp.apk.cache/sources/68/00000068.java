package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p004b.C0099a;
import p023k.InterfaceC0438a;

/* renamed from: androidx.versionedparcelable.a */
/* loaded from: classes.dex */
public abstract class AbstractC0080a {

    /* renamed from: a */
    protected final C0099a<String, Method> f126a;

    /* renamed from: b */
    protected final C0099a<String, Method> f127b;

    /* renamed from: c */
    protected final C0099a<String, Class> f128c;

    public AbstractC0080a(C0099a<String, Method> c0099a, C0099a<String, Method> c0099a2, C0099a<String, Class> c0099a3) {
        this.f126a = c0099a;
        this.f127b = c0099a2;
        this.f128c = c0099a3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: N */
    private void m2181N(InterfaceC0438a interfaceC0438a) {
        try {
            mo2161I(m2180c(interfaceC0438a.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(interfaceC0438a.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* renamed from: c */
    private Class m2180c(Class<? extends InterfaceC0438a> cls) {
        Class cls2 = this.f128c.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f128c.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    /* renamed from: d */
    private Method m2179d(String str) {
        Method method = this.f126a.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, AbstractC0080a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0080a.class);
            this.f126a.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    /* renamed from: e */
    private Method m2178e(Class cls) {
        Method method = this.f127b.get(cls.getName());
        if (method == null) {
            Class m2180c = m2180c(cls);
            System.currentTimeMillis();
            Method declaredMethod = m2180c.getDeclaredMethod("write", cls, AbstractC0080a.class);
            this.f127b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    /* renamed from: A */
    protected abstract void mo2165A(byte[] bArr);

    /* renamed from: B */
    public void m2189B(byte[] bArr, int i) {
        mo2151w(i);
        mo2165A(bArr);
    }

    /* renamed from: C */
    protected abstract void mo2164C(CharSequence charSequence);

    /* renamed from: D */
    public void m2188D(CharSequence charSequence, int i) {
        mo2151w(i);
        mo2164C(charSequence);
    }

    /* renamed from: E */
    protected abstract void mo2163E(int i);

    /* renamed from: F */
    public void m2187F(int i, int i2) {
        mo2151w(i2);
        mo2163E(i);
    }

    /* renamed from: G */
    protected abstract void mo2162G(Parcelable parcelable);

    /* renamed from: H */
    public void m2186H(Parcelable parcelable, int i) {
        mo2151w(i);
        mo2162G(parcelable);
    }

    /* renamed from: I */
    protected abstract void mo2161I(String str);

    /* renamed from: J */
    public void m2185J(String str, int i) {
        mo2151w(i);
        mo2161I(str);
    }

    /* renamed from: K */
    protected <T extends InterfaceC0438a> void m2184K(T t, AbstractC0080a abstractC0080a) {
        try {
            m2178e(t.getClass()).invoke(null, t, abstractC0080a);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L */
    public void m2183L(InterfaceC0438a interfaceC0438a) {
        if (interfaceC0438a == null) {
            mo2161I(null);
            return;
        }
        m2181N(interfaceC0438a);
        AbstractC0080a mo2159b = mo2159b();
        m2184K(interfaceC0438a, mo2159b);
        mo2159b.mo2160a();
    }

    /* renamed from: M */
    public void m2182M(InterfaceC0438a interfaceC0438a, int i) {
        mo2151w(i);
        m2183L(interfaceC0438a);
    }

    /* renamed from: a */
    protected abstract void mo2160a();

    /* renamed from: b */
    protected abstract AbstractC0080a mo2159b();

    /* renamed from: f */
    public boolean m2177f() {
        return false;
    }

    /* renamed from: g */
    protected abstract boolean mo2158g();

    /* renamed from: h */
    public boolean m2176h(boolean z, int i) {
        return !mo2155m(i) ? z : mo2158g();
    }

    /* renamed from: i */
    protected abstract byte[] mo2157i();

    /* renamed from: j */
    public byte[] m2175j(byte[] bArr, int i) {
        return !mo2155m(i) ? bArr : mo2157i();
    }

    /* renamed from: k */
    protected abstract CharSequence mo2156k();

    /* renamed from: l */
    public CharSequence m2174l(CharSequence charSequence, int i) {
        return !mo2155m(i) ? charSequence : mo2156k();
    }

    /* renamed from: m */
    protected abstract boolean mo2155m(int i);

    /* renamed from: n */
    protected <T extends InterfaceC0438a> T m2173n(String str, AbstractC0080a abstractC0080a) {
        try {
            return (T) m2179d(str).invoke(null, abstractC0080a);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: o */
    protected abstract int mo2154o();

    /* renamed from: p */
    public int m2172p(int i, int i2) {
        return !mo2155m(i2) ? i : mo2154o();
    }

    /* renamed from: q */
    protected abstract <T extends Parcelable> T mo2153q();

    /* renamed from: r */
    public <T extends Parcelable> T m2171r(T t, int i) {
        return !mo2155m(i) ? t : (T) mo2153q();
    }

    /* renamed from: s */
    protected abstract String mo2152s();

    /* renamed from: t */
    public String m2170t(String str, int i) {
        return !mo2155m(i) ? str : mo2152s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public <T extends InterfaceC0438a> T m2169u() {
        String mo2152s = mo2152s();
        if (mo2152s == null) {
            return null;
        }
        return (T) m2173n(mo2152s, mo2159b());
    }

    /* renamed from: v */
    public <T extends InterfaceC0438a> T m2168v(T t, int i) {
        return !mo2155m(i) ? t : (T) m2169u();
    }

    /* renamed from: w */
    protected abstract void mo2151w(int i);

    /* renamed from: x */
    public void m2167x(boolean z, boolean z2) {
    }

    /* renamed from: y */
    protected abstract void mo2150y(boolean z);

    /* renamed from: z */
    public void m2166z(boolean z, int i) {
        mo2151w(i);
        mo2150y(z);
    }
}