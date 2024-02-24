package p017h;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import p004b.C0108d;

/* renamed from: h.e */
/* loaded from: classes.dex */
public final class C0229e {

    /* renamed from: a */
    private final C0234e f286a;

    /* renamed from: h.e$a */
    /* loaded from: classes.dex */
    private static class C0230a extends C0234e {

        /* renamed from: a */
        protected final Window f287a;

        /* renamed from: b */
        private final View f288b;

        C0230a(Window window, View view) {
            this.f287a = window;
            this.f288b = view;
        }

        /* renamed from: c */
        protected void m1840c(int i) {
            View decorView = this.f287a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        /* renamed from: d */
        protected void m1839d(int i) {
            this.f287a.addFlags(i);
        }

        /* renamed from: e */
        protected void m1838e(int i) {
            View decorView = this.f287a.getDecorView();
            decorView.setSystemUiVisibility((i ^ (-1)) & decorView.getSystemUiVisibility());
        }

        /* renamed from: f */
        protected void m1837f(int i) {
            this.f287a.clearFlags(i);
        }
    }

    /* renamed from: h.e$b */
    /* loaded from: classes.dex */
    private static class C0231b extends C0230a {
        C0231b(Window window, View view) {
            super(window, view);
        }

        @Override // p017h.C0229e.C0234e
        /* renamed from: b */
        public void mo1835b(boolean z) {
            if (!z) {
                m1838e(8192);
                return;
            }
            m1837f(67108864);
            m1839d(Integer.MIN_VALUE);
            m1840c(8192);
        }
    }

    /* renamed from: h.e$c */
    /* loaded from: classes.dex */
    private static class C0232c extends C0231b {
        C0232c(Window window, View view) {
            super(window, view);
        }

        @Override // p017h.C0229e.C0234e
        /* renamed from: a */
        public void mo1836a(boolean z) {
            if (!z) {
                m1838e(16);
                return;
            }
            m1837f(134217728);
            m1839d(Integer.MIN_VALUE);
            m1840c(16);
        }
    }

    /* renamed from: h.e$d */
    /* loaded from: classes.dex */
    private static class C0233d extends C0234e {

        /* renamed from: a */
        final C0229e f289a;

        /* renamed from: b */
        final WindowInsetsController f290b;

        /* renamed from: c */
        private final C0108d<Object, WindowInsetsController.OnControllableInsetsChangedListener> f291c;

        C0233d(Window window, C0229e c0229e) {
            this(window.getInsetsController(), c0229e);
        }

        C0233d(WindowInsetsController windowInsetsController, C0229e c0229e) {
            this.f291c = new C0108d<>();
            this.f290b = windowInsetsController;
            this.f289a = c0229e;
        }

        @Override // p017h.C0229e.C0234e
        /* renamed from: a */
        public void mo1836a(boolean z) {
            if (z) {
                this.f290b.setSystemBarsAppearance(16, 16);
            } else {
                this.f290b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // p017h.C0229e.C0234e
        /* renamed from: b */
        public void mo1835b(boolean z) {
            if (z) {
                this.f290b.setSystemBarsAppearance(8, 8);
            } else {
                this.f290b.setSystemBarsAppearance(0, 8);
            }
        }
    }

    /* renamed from: h.e$e */
    /* loaded from: classes.dex */
    private static class C0234e {
        C0234e() {
        }

        /* renamed from: a */
        public void mo1836a(boolean z) {
        }

        /* renamed from: b */
        public void mo1835b(boolean z) {
        }
    }

    public C0229e(Window window, View view) {
        C0234e c0230a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f286a = new C0233d(window, this);
            return;
        }
        if (i >= 26) {
            c0230a = new C0232c(window, view);
        } else if (i >= 23) {
            c0230a = new C0231b(window, view);
        } else if (i < 20) {
            this.f286a = new C0234e();
            return;
        } else {
            c0230a = new C0230a(window, view);
        }
        this.f286a = c0230a;
    }

    /* renamed from: a */
    public void m1842a(boolean z) {
        this.f286a.mo1836a(z);
    }

    /* renamed from: b */
    public void m1841b(boolean z) {
        this.f286a.mo1835b(z);
    }
}