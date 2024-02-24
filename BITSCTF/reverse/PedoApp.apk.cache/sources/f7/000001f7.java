package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.android.C0256a;
import p012e0.C0146h;
import p031o.C0576b;

@TargetApi(23)
/* renamed from: io.flutter.plugin.platform.k */
/* loaded from: classes.dex */
public class C0382k extends FrameLayout {

    /* renamed from: a */
    private int f690a;

    /* renamed from: b */
    private int f691b;

    /* renamed from: c */
    private int f692c;

    /* renamed from: d */
    private int f693d;

    /* renamed from: e */
    private C0256a f694e;

    /* renamed from: f */
    private InterfaceC0381j f695f;

    /* renamed from: g */
    private ViewTreeObserver.OnGlobalFocusChangeListener f696g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.k$a */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalFocusChangeListenerC0383a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a */
        final /* synthetic */ View.OnFocusChangeListener f697a;

        ViewTreeObserver$OnGlobalFocusChangeListenerC0383a(View.OnFocusChangeListener onFocusChangeListener) {
            this.f697a = onFocusChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f697a;
            C0382k c0382k = C0382k.this;
            onFocusChangeListener.onFocusChange(c0382k, C0146h.m2027d(c0382k));
        }
    }

    public C0382k(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public C0382k(Context context, InterfaceC0381j interfaceC0381j) {
        this(context);
        this.f695f = interfaceC0381j;
    }

    /* renamed from: a */
    public void m1385a() {
        InterfaceC0381j interfaceC0381j = this.f695f;
        if (interfaceC0381j != null) {
            interfaceC0381j.release();
            this.f695f = null;
        }
    }

    /* renamed from: b */
    public void m1384b(int i, int i2) {
        InterfaceC0381j interfaceC0381j = this.f695f;
        if (interfaceC0381j != null) {
            interfaceC0381j.mo1301c(i, i2);
        }
    }

    /* renamed from: c */
    public void m1383c() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f696g) == null) {
            return;
        }
        this.f696g = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void draw(Canvas canvas) {
        InterfaceC0381j interfaceC0381j = this.f695f;
        if (interfaceC0381j == null) {
            super.draw(canvas);
            C0576b.m741b("PlatformViewWrapper", "Platform view cannot be composed without a RenderTarget.");
            return;
        }
        Canvas mo1302b = interfaceC0381j.mo1302b();
        if (mo1302b == null) {
            invalidate();
            return;
        }
        try {
            mo1302b.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(mo1302b);
        } finally {
            this.f695f.mo1299e(mo1302b);
        }
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener getActiveFocusListener() {
        return this.f696g;
    }

    public int getRenderTargetHeight() {
        InterfaceC0381j interfaceC0381j = this.f695f;
        if (interfaceC0381j != null) {
            return interfaceC0381j.mo1297g();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        InterfaceC0381j interfaceC0381j = this.f695f;
        if (interfaceC0381j != null) {
            return interfaceC0381j.mo1298f();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @SuppressLint({"NewApi"})
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        float f;
        if (this.f694e == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i2 = this.f692c;
            this.f690a = i2;
            i = this.f693d;
            this.f691b = i;
            f = i2;
        } else if (action == 2) {
            matrix.postTranslate(this.f690a, this.f691b);
            this.f690a = this.f692c;
            this.f691b = this.f693d;
            return this.f694e.m1805l(motionEvent, matrix);
        } else {
            f = this.f692c;
            i = this.f693d;
        }
        matrix.postTranslate(f, i);
        return this.f694e.m1805l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        this.f692c = layoutParams.leftMargin;
        this.f693d = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        m1383c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f696g == null) {
            ViewTreeObserver$OnGlobalFocusChangeListenerC0383a viewTreeObserver$OnGlobalFocusChangeListenerC0383a = new ViewTreeObserver$OnGlobalFocusChangeListenerC0383a(onFocusChangeListener);
            this.f696g = viewTreeObserver$OnGlobalFocusChangeListenerC0383a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserver$OnGlobalFocusChangeListenerC0383a);
        }
    }

    public void setTouchProcessor(C0256a c0256a) {
        this.f694e = c0256a;
    }
}