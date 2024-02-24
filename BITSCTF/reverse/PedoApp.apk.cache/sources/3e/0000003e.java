package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.AbstractC0066c;
import androidx.lifecycle.InterfaceC0069d;
import androidx.lifecycle.InterfaceC0071f;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements InterfaceC0069d {

    /* renamed from: b */
    private static int f71b;

    /* renamed from: c */
    private static Field f72c;

    /* renamed from: d */
    private static Field f73d;

    /* renamed from: e */
    private static Field f74e;

    /* renamed from: a */
    private Activity f75a;

    /* renamed from: h */
    private static void m2230h() {
        try {
            f71b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f73d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f74e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f72c = declaredField3;
            declaredField3.setAccessible(true);
            f71b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.InterfaceC0069d
    /* renamed from: g */
    public void mo2193g(InterfaceC0071f interfaceC0071f, AbstractC0066c.EnumC0067a enumC0067a) {
        if (enumC0067a != AbstractC0066c.EnumC0067a.ON_DESTROY) {
            return;
        }
        if (f71b == 0) {
            m2230h();
        }
        if (f71b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f75a.getSystemService("input_method");
            try {
                Object obj = f72c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f73d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f74e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}