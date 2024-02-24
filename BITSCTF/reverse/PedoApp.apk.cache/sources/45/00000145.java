package p017h;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import p011e.C0138a;
import p015g.C0171b;
import p015g.C0172c;

/* renamed from: h.d */
/* loaded from: classes.dex */
public class C0214d {

    /* renamed from: b */
    public static final C0214d f252b;

    /* renamed from: a */
    private final C0226l f253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h.d$a */
    /* loaded from: classes.dex */
    public static class C0215a {

        /* renamed from: a */
        private static Field f254a;

        /* renamed from: b */
        private static Field f255b;

        /* renamed from: c */
        private static Field f256c;

        /* renamed from: d */
        private static boolean f257d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f254a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f255b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f256c = declaredField3;
                declaredField3.setAccessible(true);
                f257d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        /* renamed from: a */
        public static C0214d m1882a(View view) {
            if (f257d && view.isAttachedToWindow()) {
                try {
                    Object obj = f254a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f255b.get(obj);
                        Rect rect2 = (Rect) f256c.get(obj);
                        if (rect != null && rect2 != null) {
                            C0214d m1881a = new C0216b().m1880b(C0138a.m2044c(rect)).m1879c(C0138a.m2044c(rect2)).m1881a();
                            m1881a.m1886k(m1881a);
                            m1881a.m1893d(view.getRootView());
                            return m1881a;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    /* renamed from: h.d$b */
    /* loaded from: classes.dex */
    public static final class C0216b {

        /* renamed from: a */
        private final C0220f f258a;

        public C0216b() {
            int i = Build.VERSION.SDK_INT;
            this.f258a = i >= 30 ? new C0219e() : i >= 29 ? new C0218d() : i >= 20 ? new C0217c() : new C0220f();
        }

        /* renamed from: a */
        public C0214d m1881a() {
            return this.f258a.mo1876b();
        }

        @Deprecated
        /* renamed from: b */
        public C0216b m1880b(C0138a c0138a) {
            this.f258a.mo1874d(c0138a);
            return this;
        }

        @Deprecated
        /* renamed from: c */
        public C0216b m1879c(C0138a c0138a) {
            this.f258a.mo1872f(c0138a);
            return this;
        }
    }

    /* renamed from: h.d$c */
    /* loaded from: classes.dex */
    private static class C0217c extends C0220f {

        /* renamed from: e */
        private static Field f259e = null;

        /* renamed from: f */
        private static boolean f260f = false;

        /* renamed from: g */
        private static Constructor<WindowInsets> f261g = null;

        /* renamed from: h */
        private static boolean f262h = false;

        /* renamed from: c */
        private WindowInsets f263c = m1878h();

        /* renamed from: d */
        private C0138a f264d;

        C0217c() {
        }

        /* renamed from: h */
        private static WindowInsets m1878h() {
            if (!f260f) {
                try {
                    f259e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                f260f = true;
            }
            Field field = f259e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!f262h) {
                try {
                    f261g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                f262h = true;
            }
            Constructor<WindowInsets> constructor = f261g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: b */
        C0214d mo1876b() {
            m1877a();
            C0214d m1884m = C0214d.m1884m(this.f263c);
            m1884m.m1888i(this.f267b);
            m1884m.m1885l(this.f264d);
            return m1884m;
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: d */
        void mo1874d(C0138a c0138a) {
            this.f264d = c0138a;
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: f */
        void mo1872f(C0138a c0138a) {
            WindowInsets windowInsets = this.f263c;
            if (windowInsets != null) {
                this.f263c = windowInsets.replaceSystemWindowInsets(c0138a.f220a, c0138a.f221b, c0138a.f222c, c0138a.f223d);
            }
        }
    }

    /* renamed from: h.d$d */
    /* loaded from: classes.dex */
    private static class C0218d extends C0220f {

        /* renamed from: c */
        final WindowInsets.Builder f265c = new WindowInsets.Builder();

        C0218d() {
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: b */
        C0214d mo1876b() {
            m1877a();
            C0214d m1884m = C0214d.m1884m(this.f265c.build());
            m1884m.m1888i(this.f267b);
            return m1884m;
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: c */
        void mo1875c(C0138a c0138a) {
            this.f265c.setMandatorySystemGestureInsets(c0138a.m2042e());
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: d */
        void mo1874d(C0138a c0138a) {
            this.f265c.setStableInsets(c0138a.m2042e());
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: e */
        void mo1873e(C0138a c0138a) {
            this.f265c.setSystemGestureInsets(c0138a.m2042e());
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: f */
        void mo1872f(C0138a c0138a) {
            this.f265c.setSystemWindowInsets(c0138a.m2042e());
        }

        @Override // p017h.C0214d.C0220f
        /* renamed from: g */
        void mo1871g(C0138a c0138a) {
            this.f265c.setTappableElementInsets(c0138a.m2042e());
        }
    }

    /* renamed from: h.d$e */
    /* loaded from: classes.dex */
    private static class C0219e extends C0218d {
        C0219e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h.d$f */
    /* loaded from: classes.dex */
    public static class C0220f {

        /* renamed from: a */
        private final C0214d f266a;

        /* renamed from: b */
        C0138a[] f267b;

        C0220f() {
            this(new C0214d((C0214d) null));
        }

        C0220f(C0214d c0214d) {
            this.f266a = c0214d;
        }

        /* renamed from: a */
        protected final void m1877a() {
            C0138a[] c0138aArr = this.f267b;
            if (c0138aArr != null) {
                C0138a c0138a = c0138aArr[C0227m.m1844b(1)];
                C0138a c0138a2 = this.f267b[C0227m.m1844b(2)];
                if (c0138a2 == null) {
                    c0138a2 = this.f266a.m1891f(2);
                }
                if (c0138a == null) {
                    c0138a = this.f266a.m1891f(1);
                }
                mo1872f(C0138a.m2046a(c0138a, c0138a2));
                C0138a c0138a3 = this.f267b[C0227m.m1844b(16)];
                if (c0138a3 != null) {
                    mo1873e(c0138a3);
                }
                C0138a c0138a4 = this.f267b[C0227m.m1844b(32)];
                if (c0138a4 != null) {
                    mo1875c(c0138a4);
                }
                C0138a c0138a5 = this.f267b[C0227m.m1844b(64)];
                if (c0138a5 != null) {
                    mo1871g(c0138a5);
                }
            }
        }

        /* renamed from: b */
        C0214d mo1876b() {
            m1877a();
            return this.f266a;
        }

        /* renamed from: c */
        void mo1875c(C0138a c0138a) {
        }

        /* renamed from: d */
        void mo1874d(C0138a c0138a) {
        }

        /* renamed from: e */
        void mo1873e(C0138a c0138a) {
        }

        /* renamed from: f */
        void mo1872f(C0138a c0138a) {
        }

        /* renamed from: g */
        void mo1871g(C0138a c0138a) {
        }
    }

    /* renamed from: h.d$g */
    /* loaded from: classes.dex */
    private static class C0221g extends C0226l {

        /* renamed from: h */
        private static boolean f268h = false;

        /* renamed from: i */
        private static Method f269i;

        /* renamed from: j */
        private static Class<?> f270j;

        /* renamed from: k */
        private static Class<?> f271k;

        /* renamed from: l */
        private static Field f272l;

        /* renamed from: m */
        private static Field f273m;

        /* renamed from: c */
        final WindowInsets f274c;

        /* renamed from: d */
        private C0138a[] f275d;

        /* renamed from: e */
        private C0138a f276e;

        /* renamed from: f */
        private C0214d f277f;

        /* renamed from: g */
        C0138a f278g;

        C0221g(C0214d c0214d, WindowInsets windowInsets) {
            super(c0214d);
            this.f276e = null;
            this.f274c = windowInsets;
        }

        C0221g(C0214d c0214d, C0221g c0221g) {
            this(c0214d, new WindowInsets(c0221g.f274c));
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: t */
        private C0138a m1870t(int i, boolean z) {
            C0138a c0138a = C0138a.f219e;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    c0138a = C0138a.m2046a(c0138a, m1869u(i2, z));
                }
            }
            return c0138a;
        }

        /* renamed from: v */
        private C0138a m1868v() {
            C0214d c0214d = this.f277f;
            return c0214d != null ? c0214d.m1890g() : C0138a.f219e;
        }

        /* renamed from: w */
        private C0138a m1867w(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f268h) {
                    m1865y();
                }
                Method method = f269i;
                if (method != null && f271k != null && f272l != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f272l.get(f273m.get(invoke));
                        if (rect != null) {
                            return C0138a.m2044c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        /* renamed from: y */
        private static void m1865y() {
            try {
                f269i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f270j = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f271k = cls;
                f272l = cls.getDeclaredField("mVisibleInsets");
                f273m = f270j.getDeclaredField("mAttachInfo");
                f272l.setAccessible(true);
                f273m.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            f268h = true;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: d */
        void mo1861d(View view) {
            C0138a m1867w = m1867w(view);
            if (m1867w == null) {
                m1867w = C0138a.f219e;
            }
            mo1848q(m1867w);
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: e */
        void mo1860e(C0214d c0214d) {
            c0214d.m1886k(this.f277f);
            c0214d.m1887j(this.f278g);
        }

        @Override // p017h.C0214d.C0226l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f278g, ((C0221g) obj).f278g);
            }
            return false;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: g */
        public C0138a mo1858g(int i) {
            return m1870t(i, false);
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: k */
        final C0138a mo1854k() {
            if (this.f276e == null) {
                this.f276e = C0138a.m2045b(this.f274c.getSystemWindowInsetLeft(), this.f274c.getSystemWindowInsetTop(), this.f274c.getSystemWindowInsetRight(), this.f274c.getSystemWindowInsetBottom());
            }
            return this.f276e;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: n */
        boolean mo1851n() {
            return this.f274c.isRound();
        }

        @Override // p017h.C0214d.C0226l
        @SuppressLint({"WrongConstant"})
        /* renamed from: o */
        boolean mo1850o(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0 && !m1866x(i2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: p */
        public void mo1849p(C0138a[] c0138aArr) {
            this.f275d = c0138aArr;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: q */
        void mo1848q(C0138a c0138a) {
            this.f278g = c0138a;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: r */
        void mo1847r(C0214d c0214d) {
            this.f277f = c0214d;
        }

        /* renamed from: u */
        protected C0138a m1869u(int i, boolean z) {
            C0138a m1890g;
            int i2;
            if (i == 1) {
                return z ? C0138a.m2045b(0, Math.max(m1868v().f221b, mo1854k().f221b), 0, 0) : C0138a.m2045b(0, mo1854k().f221b, 0, 0);
            }
            if (i == 2) {
                if (z) {
                    C0138a m1868v = m1868v();
                    C0138a mo1856i = mo1856i();
                    return C0138a.m2045b(Math.max(m1868v.f220a, mo1856i.f220a), 0, Math.max(m1868v.f222c, mo1856i.f222c), Math.max(m1868v.f223d, mo1856i.f223d));
                }
                C0138a mo1854k = mo1854k();
                C0214d c0214d = this.f277f;
                m1890g = c0214d != null ? c0214d.m1890g() : null;
                int i3 = mo1854k.f223d;
                if (m1890g != null) {
                    i3 = Math.min(i3, m1890g.f223d);
                }
                return C0138a.m2045b(mo1854k.f220a, 0, mo1854k.f222c, i3);
            } else if (i != 8) {
                if (i != 16) {
                    if (i != 32) {
                        if (i != 64) {
                            if (i != 128) {
                                return C0138a.f219e;
                            }
                            C0214d c0214d2 = this.f277f;
                            C0205a m1892e = c0214d2 != null ? c0214d2.m1892e() : mo1859f();
                            return m1892e != null ? C0138a.m2045b(m1892e.m1917b(), m1892e.m1915d(), m1892e.m1916c(), m1892e.m1918a()) : C0138a.f219e;
                        }
                        return mo1853l();
                    }
                    return mo1857h();
                }
                return mo1855j();
            } else {
                C0138a[] c0138aArr = this.f275d;
                m1890g = c0138aArr != null ? c0138aArr[C0227m.m1844b(8)] : null;
                if (m1890g != null) {
                    return m1890g;
                }
                C0138a mo1854k2 = mo1854k();
                C0138a m1868v2 = m1868v();
                int i4 = mo1854k2.f223d;
                if (i4 > m1868v2.f223d) {
                    return C0138a.m2045b(0, 0, 0, i4);
                }
                C0138a c0138a = this.f278g;
                return (c0138a == null || c0138a.equals(C0138a.f219e) || (i2 = this.f278g.f223d) <= m1868v2.f223d) ? C0138a.f219e : C0138a.m2045b(0, 0, 0, i2);
            }
        }

        /* renamed from: x */
        protected boolean m1866x(int i) {
            if (i != 1 && i != 2) {
                if (i == 4) {
                    return false;
                }
                if (i != 8 && i != 128) {
                    return true;
                }
            }
            return !m1869u(i, false).equals(C0138a.f219e);
        }
    }

    /* renamed from: h.d$h */
    /* loaded from: classes.dex */
    private static class C0222h extends C0221g {

        /* renamed from: n */
        private C0138a f279n;

        C0222h(C0214d c0214d, WindowInsets windowInsets) {
            super(c0214d, windowInsets);
            this.f279n = null;
        }

        C0222h(C0214d c0214d, C0222h c0222h) {
            super(c0214d, c0222h);
            this.f279n = null;
            this.f279n = c0222h.f279n;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: b */
        C0214d mo1863b() {
            return C0214d.m1884m(this.f274c.consumeStableInsets());
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: c */
        C0214d mo1862c() {
            return C0214d.m1884m(this.f274c.consumeSystemWindowInsets());
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: i */
        final C0138a mo1856i() {
            if (this.f279n == null) {
                this.f279n = C0138a.m2045b(this.f274c.getStableInsetLeft(), this.f274c.getStableInsetTop(), this.f274c.getStableInsetRight(), this.f274c.getStableInsetBottom());
            }
            return this.f279n;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: m */
        boolean mo1852m() {
            return this.f274c.isConsumed();
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: s */
        public void mo1846s(C0138a c0138a) {
            this.f279n = c0138a;
        }
    }

    /* renamed from: h.d$i */
    /* loaded from: classes.dex */
    private static class C0223i extends C0222h {
        C0223i(C0214d c0214d, WindowInsets windowInsets) {
            super(c0214d, windowInsets);
        }

        C0223i(C0214d c0214d, C0223i c0223i) {
            super(c0214d, c0223i);
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: a */
        C0214d mo1864a() {
            return C0214d.m1884m(this.f274c.consumeDisplayCutout());
        }

        @Override // p017h.C0214d.C0221g, p017h.C0214d.C0226l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0223i) {
                C0223i c0223i = (C0223i) obj;
                return Objects.equals(this.f274c, c0223i.f274c) && Objects.equals(this.f278g, c0223i.f278g);
            }
            return false;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: f */
        C0205a mo1859f() {
            return C0205a.m1914e(this.f274c.getDisplayCutout());
        }

        @Override // p017h.C0214d.C0226l
        public int hashCode() {
            return this.f274c.hashCode();
        }
    }

    /* renamed from: h.d$j */
    /* loaded from: classes.dex */
    private static class C0224j extends C0223i {

        /* renamed from: o */
        private C0138a f280o;

        /* renamed from: p */
        private C0138a f281p;

        /* renamed from: q */
        private C0138a f282q;

        C0224j(C0214d c0214d, WindowInsets windowInsets) {
            super(c0214d, windowInsets);
            this.f280o = null;
            this.f281p = null;
            this.f282q = null;
        }

        C0224j(C0214d c0214d, C0224j c0224j) {
            super(c0214d, c0224j);
            this.f280o = null;
            this.f281p = null;
            this.f282q = null;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: h */
        C0138a mo1857h() {
            if (this.f281p == null) {
                this.f281p = C0138a.m2043d(this.f274c.getMandatorySystemGestureInsets());
            }
            return this.f281p;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: j */
        C0138a mo1855j() {
            if (this.f280o == null) {
                this.f280o = C0138a.m2043d(this.f274c.getSystemGestureInsets());
            }
            return this.f280o;
        }

        @Override // p017h.C0214d.C0226l
        /* renamed from: l */
        C0138a mo1853l() {
            if (this.f282q == null) {
                this.f282q = C0138a.m2043d(this.f274c.getTappableElementInsets());
            }
            return this.f282q;
        }

        @Override // p017h.C0214d.C0222h, p017h.C0214d.C0226l
        /* renamed from: s */
        public void mo1846s(C0138a c0138a) {
        }
    }

    /* renamed from: h.d$k */
    /* loaded from: classes.dex */
    private static class C0225k extends C0224j {

        /* renamed from: r */
        static final C0214d f283r = C0214d.m1884m(WindowInsets.CONSUMED);

        C0225k(C0214d c0214d, WindowInsets windowInsets) {
            super(c0214d, windowInsets);
        }

        C0225k(C0214d c0214d, C0225k c0225k) {
            super(c0214d, c0225k);
        }

        @Override // p017h.C0214d.C0221g, p017h.C0214d.C0226l
        /* renamed from: d */
        final void mo1861d(View view) {
        }

        @Override // p017h.C0214d.C0221g, p017h.C0214d.C0226l
        /* renamed from: g */
        public C0138a mo1858g(int i) {
            return C0138a.m2043d(this.f274c.getInsets(C0228n.m1843a(i)));
        }

        @Override // p017h.C0214d.C0221g, p017h.C0214d.C0226l
        /* renamed from: o */
        public boolean mo1850o(int i) {
            return this.f274c.isVisible(C0228n.m1843a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h.d$l */
    /* loaded from: classes.dex */
    public static class C0226l {

        /* renamed from: b */
        static final C0214d f284b = new C0216b().m1881a().m1896a().m1895b().m1894c();

        /* renamed from: a */
        final C0214d f285a;

        C0226l(C0214d c0214d) {
            this.f285a = c0214d;
        }

        /* renamed from: a */
        C0214d mo1864a() {
            return this.f285a;
        }

        /* renamed from: b */
        C0214d mo1863b() {
            return this.f285a;
        }

        /* renamed from: c */
        C0214d mo1862c() {
            return this.f285a;
        }

        /* renamed from: d */
        void mo1861d(View view) {
        }

        /* renamed from: e */
        void mo1860e(C0214d c0214d) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0226l) {
                C0226l c0226l = (C0226l) obj;
                return mo1851n() == c0226l.mo1851n() && mo1852m() == c0226l.mo1852m() && C0171b.m2002a(mo1854k(), c0226l.mo1854k()) && C0171b.m2002a(mo1856i(), c0226l.mo1856i()) && C0171b.m2002a(mo1859f(), c0226l.mo1859f());
            }
            return false;
        }

        /* renamed from: f */
        C0205a mo1859f() {
            return null;
        }

        /* renamed from: g */
        C0138a mo1858g(int i) {
            return C0138a.f219e;
        }

        /* renamed from: h */
        C0138a mo1857h() {
            return mo1854k();
        }

        public int hashCode() {
            return C0171b.m2001b(Boolean.valueOf(mo1851n()), Boolean.valueOf(mo1852m()), mo1854k(), mo1856i(), mo1859f());
        }

        /* renamed from: i */
        C0138a mo1856i() {
            return C0138a.f219e;
        }

        /* renamed from: j */
        C0138a mo1855j() {
            return mo1854k();
        }

        /* renamed from: k */
        C0138a mo1854k() {
            return C0138a.f219e;
        }

        /* renamed from: l */
        C0138a mo1853l() {
            return mo1854k();
        }

        /* renamed from: m */
        boolean mo1852m() {
            return false;
        }

        /* renamed from: n */
        boolean mo1851n() {
            return false;
        }

        /* renamed from: o */
        boolean mo1850o(int i) {
            return true;
        }

        /* renamed from: p */
        public void mo1849p(C0138a[] c0138aArr) {
        }

        /* renamed from: q */
        void mo1848q(C0138a c0138a) {
        }

        /* renamed from: r */
        void mo1847r(C0214d c0214d) {
        }

        /* renamed from: s */
        public void mo1846s(C0138a c0138a) {
        }
    }

    /* renamed from: h.d$m */
    /* loaded from: classes.dex */
    public static final class C0227m {
        /* renamed from: a */
        public static int m1845a() {
            return 8;
        }

        /* renamed from: b */
        static int m1844b(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32) {
                                    if (i != 64) {
                                        if (i != 128) {
                                            if (i == 256) {
                                                return 8;
                                            }
                                            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: h.d$n */
    /* loaded from: classes.dex */
    private static final class C0228n {
        /* renamed from: a */
        static int m1843a(int i) {
            int statusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= statusBars;
                }
            }
            return i2;
        }
    }

    static {
        f252b = Build.VERSION.SDK_INT >= 30 ? C0225k.f283r : C0226l.f284b;
    }

    private C0214d(WindowInsets windowInsets) {
        C0226l c0221g;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            c0221g = new C0225k(this, windowInsets);
        } else if (i >= 29) {
            c0221g = new C0224j(this, windowInsets);
        } else if (i >= 28) {
            c0221g = new C0223i(this, windowInsets);
        } else if (i >= 21) {
            c0221g = new C0222h(this, windowInsets);
        } else if (i < 20) {
            this.f253a = new C0226l(this);
            return;
        } else {
            c0221g = new C0221g(this, windowInsets);
        }
        this.f253a = c0221g;
    }

    public C0214d(C0214d c0214d) {
        if (c0214d == null) {
            this.f253a = new C0226l(this);
            return;
        }
        C0226l c0226l = c0214d.f253a;
        int i = Build.VERSION.SDK_INT;
        this.f253a = (i < 30 || !(c0226l instanceof C0225k)) ? (i < 29 || !(c0226l instanceof C0224j)) ? (i < 28 || !(c0226l instanceof C0223i)) ? (i < 21 || !(c0226l instanceof C0222h)) ? (i < 20 || !(c0226l instanceof C0221g)) ? new C0226l(this) : new C0221g(this, (C0221g) c0226l) : new C0222h(this, (C0222h) c0226l) : new C0223i(this, (C0223i) c0226l) : new C0224j(this, (C0224j) c0226l) : new C0225k(this, (C0225k) c0226l);
        c0226l.mo1860e(this);
    }

    /* renamed from: m */
    public static C0214d m1884m(WindowInsets windowInsets) {
        return m1883n(windowInsets, null);
    }

    /* renamed from: n */
    public static C0214d m1883n(WindowInsets windowInsets, View view) {
        C0214d c0214d = new C0214d((WindowInsets) C0172c.m2000a(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            c0214d.m1886k(C0207c.m1910d(view));
            c0214d.m1893d(view.getRootView());
        }
        return c0214d;
    }

    @Deprecated
    /* renamed from: a */
    public C0214d m1896a() {
        return this.f253a.mo1864a();
    }

    @Deprecated
    /* renamed from: b */
    public C0214d m1895b() {
        return this.f253a.mo1863b();
    }

    @Deprecated
    /* renamed from: c */
    public C0214d m1894c() {
        return this.f253a.mo1862c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m1893d(View view) {
        this.f253a.mo1861d(view);
    }

    /* renamed from: e */
    public C0205a m1892e() {
        return this.f253a.mo1859f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0214d) {
            return C0171b.m2002a(this.f253a, ((C0214d) obj).f253a);
        }
        return false;
    }

    /* renamed from: f */
    public C0138a m1891f(int i) {
        return this.f253a.mo1858g(i);
    }

    @Deprecated
    /* renamed from: g */
    public C0138a m1890g() {
        return this.f253a.mo1856i();
    }

    /* renamed from: h */
    public boolean m1889h(int i) {
        return this.f253a.mo1850o(i);
    }

    public int hashCode() {
        C0226l c0226l = this.f253a;
        if (c0226l == null) {
            return 0;
        }
        return c0226l.hashCode();
    }

    /* renamed from: i */
    void m1888i(C0138a[] c0138aArr) {
        this.f253a.mo1849p(c0138aArr);
    }

    /* renamed from: j */
    void m1887j(C0138a c0138a) {
        this.f253a.mo1848q(c0138a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m1886k(C0214d c0214d) {
        this.f253a.mo1847r(c0214d);
    }

    /* renamed from: l */
    void m1885l(C0138a c0138a) {
        this.f253a.mo1846s(c0138a);
    }
}