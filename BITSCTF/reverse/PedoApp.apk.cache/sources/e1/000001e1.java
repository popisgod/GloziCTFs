package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import p031o.C0576b;

/* JADX INFO: Access modifiers changed from: package-private */
@Keep
@TargetApi(17)
/* loaded from: classes.dex */
public class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final C0367a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private C0361a rootView;
    private boolean startFocused;
    private final C0365e state;
    private int viewId;

    /* renamed from: io.flutter.plugin.platform.SingleViewPresentation$a */
    /* loaded from: classes.dex */
    private static class C0361a extends FrameLayout {

        /* renamed from: a */
        private final C0367a f652a;

        /* renamed from: b */
        private final View f653b;

        public C0361a(Context context, C0367a c0367a, View view) {
            super(context);
            this.f652a = c0367a;
            this.f653b = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f652a.m1435b(this.f653b, view, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.SingleViewPresentation$b */
    /* loaded from: classes.dex */
    public static class C0362b extends ViewGroup {

        /* renamed from: a */
        private final Rect f654a;

        /* renamed from: b */
        private final Rect f655b;

        public C0362b(Context context) {
            super(context);
            this.f654a = new Rect();
            this.f655b = new Rect();
        }

        /* renamed from: a */
        private static int m1450a(int i) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.f654a.set(i, i2, i3, i4);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f654a, layoutParams.x, layoutParams.y, this.f655b);
                Rect rect = this.f655b;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).measure(m1450a(i), m1450a(i2));
            }
            super.onMeasure(i, i2);
        }
    }

    /* renamed from: io.flutter.plugin.platform.SingleViewPresentation$c */
    /* loaded from: classes.dex */
    private static class C0363c extends ContextWrapper {

        /* renamed from: a */
        private final InputMethodManager f656a;

        C0363c(Context context) {
            this(context, null);
        }

        private C0363c(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f656a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new C0363c(super.createDisplayContext(display), this.f656a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f656a : super.getSystemService(str);
        }
    }

    /* renamed from: io.flutter.plugin.platform.SingleViewPresentation$d */
    /* loaded from: classes.dex */
    private static class C0364d extends ContextWrapper {

        /* renamed from: a */
        private final C0366f f657a;

        /* renamed from: b */
        private WindowManager f658b;

        /* renamed from: c */
        private final Context f659c;

        C0364d(Context context, C0366f c0366f, Context context2) {
            super(context);
            this.f657a = c0366f;
            this.f659c = context2;
        }

        /* renamed from: a */
        private WindowManager m1449a() {
            if (this.f658b == null) {
                this.f658b = this.f657a.m1440b();
            }
            return this.f658b;
        }

        /* renamed from: b */
        private boolean m1448b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i = 0; i < stackTrace.length && i < 11; i++) {
                if (stackTrace[i].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? m1448b() ? this.f659c.getSystemService(str) : m1449a() : super.getSystemService(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.SingleViewPresentation$e */
    /* loaded from: classes.dex */
    public static class C0365e {

        /* renamed from: a */
        private InterfaceC0377f f660a;

        /* renamed from: b */
        private C0366f f661b;

        /* renamed from: c */
        private C0362b f662c;

        C0365e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.SingleViewPresentation$f */
    /* loaded from: classes.dex */
    public static class C0366f implements InvocationHandler {

        /* renamed from: a */
        private final WindowManager f663a;

        /* renamed from: b */
        C0362b f664b;

        C0366f(WindowManager windowManager, C0362b c0362b) {
            this.f663a = windowManager;
            this.f664b = c0362b;
        }

        /* renamed from: a */
        private void m1441a(Object[] objArr) {
            C0362b c0362b = this.f664b;
            if (c0362b == null) {
                C0576b.m736g(SingleViewPresentation.TAG, "Embedded view called addView while detached from presentation");
            } else {
                c0362b.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        /* renamed from: c */
        private void m1439c(Object[] objArr) {
            C0362b c0362b = this.f664b;
            if (c0362b == null) {
                C0576b.m736g(SingleViewPresentation.TAG, "Embedded view called removeView while detached from presentation");
            } else {
                c0362b.removeView((View) objArr[0]);
            }
        }

        /* renamed from: d */
        private void m1438d(Object[] objArr) {
            if (this.f664b == null) {
                C0576b.m736g(SingleViewPresentation.TAG, "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.f664b.removeView(view);
        }

        /* renamed from: e */
        private void m1437e(Object[] objArr) {
            C0362b c0362b = this.f664b;
            if (c0362b == null) {
                C0576b.m736g(SingleViewPresentation.TAG, "Embedded view called updateViewLayout while detached from presentation");
            } else {
                c0362b.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        /* renamed from: b */
        public WindowManager m1440b() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            name.hashCode();
            char c = 65535;
            switch (name.hashCode()) {
                case -1148522778:
                    if (name.equals("addView")) {
                        c = 0;
                        break;
                    }
                    break;
                case 542766184:
                    if (name.equals("removeViewImmediate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 931413976:
                    if (name.equals("updateViewLayout")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1098630473:
                    if (name.equals("removeView")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m1441a(objArr);
                    return null;
                case 1:
                    m1438d(objArr);
                    return null;
                case 2:
                    m1437e(objArr);
                    return null;
                case 3:
                    m1439c(objArr);
                    return null;
                default:
                    try {
                        return method.invoke(this.f663a, objArr);
                    } catch (InvocationTargetException e) {
                        throw e.getCause();
                    }
            }
        }
    }

    public SingleViewPresentation(Context context, Display display, C0367a c0367a, C0365e c0365e, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new C0363c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c0367a;
        this.state = c0365e;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }

    public SingleViewPresentation(Context context, Display display, InterfaceC0377f interfaceC0377f, C0367a c0367a, int i, View.OnFocusChangeListener onFocusChangeListener) {
        super(new C0363c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c0367a;
        this.viewId = i;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        C0365e c0365e = new C0365e();
        this.state = c0365e;
        c0365e.f660a = interfaceC0377f;
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public C0365e detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        C0361a c0361a = this.rootView;
        if (c0361a != null) {
            c0361a.removeAllViews();
        }
        return this.state;
    }

    public InterfaceC0377f getView() {
        return this.state.f660a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f662c == null) {
            this.state.f662c = new C0362b(getContext());
        }
        if (this.state.f661b == null) {
            C0365e c0365e = this.state;
            c0365e.f661b = new C0366f((WindowManager) getContext().getSystemService("window"), c0365e.f662c);
        }
        this.container = new FrameLayout(getContext());
        C0364d c0364d = new C0364d(getContext(), this.state.f661b, this.outerContext);
        View m1389g = this.state.f660a.m1389g();
        if (m1389g.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) m1389g.getContext()).setBaseContext(c0364d);
        } else {
            C0576b.m736g(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(m1389g);
        C0361a c0361a = new C0361a(getContext(), this.accessibilityEventsDelegate, m1389g);
        this.rootView = c0361a;
        c0361a.addView(this.container);
        this.rootView.addView(this.state.f662c);
        m1389g.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            m1389g.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}