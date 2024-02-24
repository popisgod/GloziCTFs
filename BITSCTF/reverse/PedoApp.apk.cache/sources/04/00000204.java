package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(20)
/* renamed from: io.flutter.plugin.platform.t */
/* loaded from: classes.dex */
public class C0395t {

    /* renamed from: a */
    SingleViewPresentation f746a;

    /* renamed from: b */
    private final Context f747b;

    /* renamed from: c */
    private final C0367a f748c;

    /* renamed from: d */
    private final int f749d;

    /* renamed from: e */
    private final int f750e;

    /* renamed from: f */
    private final InterfaceC0381j f751f;

    /* renamed from: g */
    private final View.OnFocusChangeListener f752g;

    /* renamed from: h */
    private VirtualDisplay f753h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.t$a */
    /* loaded from: classes.dex */
    public class View$OnAttachStateChangeListenerC0396a implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f754a;

        /* renamed from: b */
        final /* synthetic */ Runnable f755b;

        /* renamed from: io.flutter.plugin.platform.t$a$a */
        /* loaded from: classes.dex */
        class RunnableC0397a implements Runnable {
            RunnableC0397a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View$OnAttachStateChangeListenerC0396a view$OnAttachStateChangeListenerC0396a = View$OnAttachStateChangeListenerC0396a.this;
                view$OnAttachStateChangeListenerC0396a.f754a.postDelayed(view$OnAttachStateChangeListenerC0396a.f755b, 128L);
            }
        }

        View$OnAttachStateChangeListenerC0396a(View view, Runnable runnable) {
            this.f754a = view;
            this.f755b = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewTreeObserver$OnDrawListenerC0398b.m1281a(this.f754a, new RunnableC0397a());
            this.f754a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: io.flutter.plugin.platform.t$b */
    /* loaded from: classes.dex */
    static class ViewTreeObserver$OnDrawListenerC0398b implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a */
        final View f758a;

        /* renamed from: b */
        Runnable f759b;

        /* renamed from: io.flutter.plugin.platform.t$b$a */
        /* loaded from: classes.dex */
        class RunnableC0399a implements Runnable {
            RunnableC0399a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver$OnDrawListenerC0398b.this.f758a.getViewTreeObserver().removeOnDrawListener(ViewTreeObserver$OnDrawListenerC0398b.this);
            }
        }

        ViewTreeObserver$OnDrawListenerC0398b(View view, Runnable runnable) {
            this.f758a = view;
            this.f759b = runnable;
        }

        /* renamed from: a */
        static void m1281a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver$OnDrawListenerC0398b(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f759b;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f759b = null;
            this.f758a.post(new RunnableC0399a());
        }
    }

    private C0395t(Context context, C0367a c0367a, VirtualDisplay virtualDisplay, InterfaceC0377f interfaceC0377f, InterfaceC0381j interfaceC0381j, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        this.f747b = context;
        this.f748c = c0367a;
        this.f751f = interfaceC0381j;
        this.f752g = onFocusChangeListener;
        this.f750e = i;
        this.f753h = virtualDisplay;
        this.f749d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f753h.getDisplay(), interfaceC0377f, c0367a, i, onFocusChangeListener);
        this.f746a = singleViewPresentation;
        singleViewPresentation.show();
    }

    /* renamed from: a */
    public static C0395t m1290a(Context context, C0367a c0367a, InterfaceC0377f interfaceC0377f, InterfaceC0381j interfaceC0381j, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        interfaceC0381j.mo1301c(i, i2);
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd#" + i3, i, i2, displayMetrics.densityDpi, interfaceC0381j.mo1300d(), 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new C0395t(context, c0367a, createVirtualDisplay, interfaceC0377f, interfaceC0381j, onFocusChangeListener, i3, obj);
    }

    /* renamed from: b */
    public void m1289b(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f746a;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: c */
    public void m1288c() {
        this.f746a.cancel();
        this.f746a.detachState();
        this.f753h.release();
        this.f751f.release();
    }

    /* renamed from: d */
    public int m1287d() {
        InterfaceC0381j interfaceC0381j = this.f751f;
        if (interfaceC0381j != null) {
            return interfaceC0381j.mo1297g();
        }
        return 0;
    }

    /* renamed from: e */
    public int m1286e() {
        InterfaceC0381j interfaceC0381j = this.f751f;
        if (interfaceC0381j != null) {
            return interfaceC0381j.mo1298f();
        }
        return 0;
    }

    /* renamed from: f */
    public View m1285f() {
        SingleViewPresentation singleViewPresentation = this.f746a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().m1389g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m1284g() {
        SingleViewPresentation singleViewPresentation = this.f746a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f746a.getView().m1392d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m1283h() {
        SingleViewPresentation singleViewPresentation = this.f746a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f746a.getView().m1393c();
    }

    /* renamed from: i */
    public void m1282i(int i, int i2, Runnable runnable) {
        boolean isFocused = m1285f().isFocused();
        SingleViewPresentation.C0365e detachState = this.f746a.detachState();
        this.f753h.setSurface(null);
        this.f753h.release();
        DisplayManager displayManager = (DisplayManager) this.f747b.getSystemService("display");
        this.f751f.mo1301c(i, i2);
        this.f753h = displayManager.createVirtualDisplay("flutter-vd#" + this.f750e, i, i2, this.f749d, this.f751f.mo1300d(), 0);
        View m1285f = m1285f();
        m1285f.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC0396a(m1285f, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f747b, this.f753h.getDisplay(), this.f748c, detachState, this.f752g, isFocused);
        singleViewPresentation.show();
        this.f746a.cancel();
        this.f746a = singleViewPresentation;
    }
}