package p017h;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p007c.C0113a;
import p017h.C0214d;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: h.c */
/* loaded from: classes.dex */
public class C0207c {

    /* renamed from: a */
    private static final AtomicInteger f241a = new AtomicInteger(1);

    /* renamed from: b */
    private static WeakHashMap<View, Object> f242b = null;

    /* renamed from: c */
    private static boolean f243c = false;

    /* renamed from: d */
    private static final int[] f244d = {C0113a.accessibility_custom_action_0, C0113a.accessibility_custom_action_1, C0113a.accessibility_custom_action_2, C0113a.accessibility_custom_action_3, C0113a.accessibility_custom_action_4, C0113a.accessibility_custom_action_5, C0113a.accessibility_custom_action_6, C0113a.accessibility_custom_action_7, C0113a.accessibility_custom_action_8, C0113a.accessibility_custom_action_9, C0113a.accessibility_custom_action_10, C0113a.accessibility_custom_action_11, C0113a.accessibility_custom_action_12, C0113a.accessibility_custom_action_13, C0113a.accessibility_custom_action_14, C0113a.accessibility_custom_action_15, C0113a.accessibility_custom_action_16, C0113a.accessibility_custom_action_17, C0113a.accessibility_custom_action_18, C0113a.accessibility_custom_action_19, C0113a.accessibility_custom_action_20, C0113a.accessibility_custom_action_21, C0113a.accessibility_custom_action_22, C0113a.accessibility_custom_action_23, C0113a.accessibility_custom_action_24, C0113a.accessibility_custom_action_25, C0113a.accessibility_custom_action_26, C0113a.accessibility_custom_action_27, C0113a.accessibility_custom_action_28, C0113a.accessibility_custom_action_29, C0113a.accessibility_custom_action_30, C0113a.accessibility_custom_action_31};

    /* renamed from: e */
    private static final InterfaceC0206b f245e = new C0208a();

    /* renamed from: f */
    private static ViewTreeObserver$OnGlobalLayoutListenerC0210c f246f = new ViewTreeObserver$OnGlobalLayoutListenerC0210c();

    /* renamed from: h.c$a */
    /* loaded from: classes.dex */
    class C0208a implements InterfaceC0206b {
        C0208a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h.c$b */
    /* loaded from: classes.dex */
    public class C0209b extends AbstractC0211d<CharSequence> {
        C0209b(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // p017h.C0207c.AbstractC0211d
        /* renamed from: e */
        public CharSequence mo1900c(View view) {
            return view.getAccessibilityPaneTitle();
        }
    }

    /* renamed from: h.c$c */
    /* loaded from: classes.dex */
    static class ViewTreeObserver$OnGlobalLayoutListenerC0210c implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        private WeakHashMap<View, Boolean> f247a = new WeakHashMap<>();

        ViewTreeObserver$OnGlobalLayoutListenerC0210c() {
        }

        /* renamed from: a */
        private void m1904a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                C0207c.m1909e(view, z2 ? 16 : 32);
                this.f247a.put(view, Boolean.valueOf(z2));
            }
        }

        /* renamed from: b */
        private void m1903b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f247a.entrySet()) {
                    m1904a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            m1903b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h.c$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0211d<T> {

        /* renamed from: a */
        private final int f248a;

        /* renamed from: b */
        private final Class<T> f249b;

        /* renamed from: c */
        private final int f250c;

        /* renamed from: d */
        private final int f251d;

        AbstractC0211d(int i, Class<T> cls, int i2, int i3) {
            this.f248a = i;
            this.f249b = cls;
            this.f251d = i2;
            this.f250c = i3;
        }

        /* renamed from: a */
        private boolean m1902a() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* renamed from: b */
        private boolean m1901b() {
            return Build.VERSION.SDK_INT >= this.f250c;
        }

        /* renamed from: c */
        abstract T mo1900c(View view);

        /* renamed from: d */
        T m1899d(View view) {
            if (m1901b()) {
                return mo1900c(view);
            }
            if (m1902a()) {
                T t = (T) view.getTag(this.f248a);
                if (this.f249b.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }
    }

    /* renamed from: h.c$e */
    /* loaded from: classes.dex */
    private static class C0212e {
        /* renamed from: a */
        public static C0214d m1898a(View view) {
            return C0214d.C0215a.m1882a(view);
        }
    }

    /* renamed from: h.c$f */
    /* loaded from: classes.dex */
    private static class C0213f {
        /* renamed from: a */
        public static C0214d m1897a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C0214d m1884m = C0214d.m1884m(rootWindowInsets);
            m1884m.m1886k(m1884m);
            m1884m.m1893d(view.getRootView());
            return m1884m;
        }
    }

    /* renamed from: a */
    public static int m1913a(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* renamed from: b */
    public static CharSequence m1912b(View view) {
        return m1908f().m1899d(view);
    }

    /* renamed from: c */
    public static int m1911c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    /* renamed from: d */
    public static C0214d m1910d(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return C0213f.m1897a(view);
        }
        if (i >= 21) {
            return C0212e.m1898a(view);
        }
        return null;
    }

    /* renamed from: e */
    static void m1909e(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = m1912b(view) != null && view.getVisibility() == 0;
            if (m1913a(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(m1912b(view));
                    m1906h(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(m1912b(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    /* renamed from: f */
    private static AbstractC0211d<CharSequence> m1908f() {
        return new C0209b(C0113a.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    /* renamed from: g */
    public static void m1907g(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            if (i2 < 16) {
                return;
            }
            if (i == 4) {
                i = 2;
            }
        }
        view.setImportantForAccessibility(i);
    }

    /* renamed from: h */
    private static void m1906h(View view) {
        if (m1911c(view) == 0) {
            m1907g(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (m1911c((View) parent) == 4) {
                m1907g(view, 2);
                return;
            }
        }
    }
}