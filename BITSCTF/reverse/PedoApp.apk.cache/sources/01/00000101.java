package p012e0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.window.layout.C0098e;
import androidx.window.layout.WindowMetrics;

/* renamed from: e0.h */
/* loaded from: classes.dex */
public final class C0146h {

    /* renamed from: e0.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0147a {
        /* renamed from: a */
        void mo1628a(float f, float f2, float f3);
    }

    /* renamed from: e0.h$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0148b {
        /* renamed from: a */
        boolean mo2020a(View view);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m2030a(View view) {
        return view.hasFocus();
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m2029b(Class[] clsArr, View view) {
        return m2022i(clsArr, view);
    }

    /* renamed from: c */
    public static void m2028c(Context context, InterfaceC0147a interfaceC0147a) {
        Activity m2025f = m2025f(context);
        if (m2025f != null) {
            WindowMetrics computeMaximumWindowMetrics = C0098e.m2137a().computeMaximumWindowMetrics(m2025f);
            interfaceC0147a.mo1628a(computeMaximumWindowMetrics.getBounds().width(), computeMaximumWindowMetrics.getBounds().height(), context.getResources().getDisplayMetrics().density);
        }
    }

    /* renamed from: d */
    public static boolean m2027d(View view) {
        return m2021j(view, new InterfaceC0148b() { // from class: e0.g
            @Override // p012e0.C0146h.InterfaceC0148b
            /* renamed from: a */
            public final boolean mo2020a(View view2) {
                return C0146h.m2030a(view2);
            }
        });
    }

    /* renamed from: e */
    public static int m2026e(int i) {
        return Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : i;
    }

    /* renamed from: f */
    public static Activity m2025f(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m2025f(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: g */
    public static boolean m2024g(View view, final Class<? extends View>[] clsArr) {
        return m2021j(view, new InterfaceC0148b() { // from class: e0.f
            @Override // p012e0.C0146h.InterfaceC0148b
            /* renamed from: a */
            public final boolean mo2020a(View view2) {
                return C0146h.m2029b(clsArr, view2);
            }
        });
    }

    /* renamed from: i */
    public static /* synthetic */ boolean m2022i(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    public static boolean m2021j(View view, InterfaceC0148b interfaceC0148b) {
        if (view == null) {
            return false;
        }
        if (interfaceC0148b.mo2020a(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (m2021j(viewGroup.getChildAt(i), interfaceC0148b)) {
                    return true;
                }
            }
        }
        return false;
    }
}