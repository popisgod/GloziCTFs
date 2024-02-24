package p039s;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.android.C0256a;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import p012e0.C0146h;

@TargetApi(19)
/* renamed from: s.a */
/* loaded from: classes.dex */
public class C0638a extends FrameLayout {

    /* renamed from: a */
    private FlutterMutatorsStack f1251a;

    /* renamed from: b */
    private float f1252b;

    /* renamed from: c */
    private int f1253c;

    /* renamed from: d */
    private int f1254d;

    /* renamed from: e */
    private int f1255e;

    /* renamed from: f */
    private int f1256f;

    /* renamed from: g */
    private final C0256a f1257g;

    /* renamed from: h */
    ViewTreeObserver.OnGlobalFocusChangeListener f1258h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s.a$a */
    /* loaded from: classes.dex */
    public class ViewTreeObserver$OnGlobalFocusChangeListenerC0639a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a */
        final /* synthetic */ View.OnFocusChangeListener f1259a;

        /* renamed from: b */
        final /* synthetic */ View f1260b;

        ViewTreeObserver$OnGlobalFocusChangeListenerC0639a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f1259a = onFocusChangeListener;
            this.f1260b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f1259a;
            View view3 = this.f1260b;
            onFocusChangeListener.onFocusChange(view3, C0146h.m2027d(view3));
        }
    }

    public C0638a(Context context, float f, C0256a c0256a) {
        super(context, null);
        this.f1252b = f;
        this.f1257g = c0256a;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f1251a.getFinalMatrix());
        float f = this.f1252b;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate(-this.f1253c, -this.f1254d);
        return matrix;
    }

    /* renamed from: a */
    public void m665a(FlutterMutatorsStack flutterMutatorsStack, int i, int i2, int i3, int i4) {
        this.f1251a = flutterMutatorsStack;
        this.f1253c = i;
        this.f1254d = i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    /* renamed from: b */
    public void m664b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f1258h) == null) {
            return;
        }
        this.f1258h = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.f1251a.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset(-this.f1253c, -this.f1254d);
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
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
        if (this.f1257g == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i2 = this.f1253c;
            this.f1255e = i2;
            i = this.f1254d;
            this.f1256f = i;
            f = i2;
        } else if (action == 2) {
            matrix.postTranslate(this.f1255e, this.f1256f);
            this.f1255e = this.f1253c;
            this.f1256f = this.f1254d;
            return this.f1257g.m1805l(motionEvent, matrix);
        } else {
            f = this.f1253c;
            i = this.f1254d;
        }
        matrix.postTranslate(f, i);
        return this.f1257g.m1805l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        m664b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f1258h == null) {
            ViewTreeObserver$OnGlobalFocusChangeListenerC0639a viewTreeObserver$OnGlobalFocusChangeListenerC0639a = new ViewTreeObserver$OnGlobalFocusChangeListenerC0639a(onFocusChangeListener, this);
            this.f1258h = viewTreeObserver$OnGlobalFocusChangeListenerC0639a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserver$OnGlobalFocusChangeListenerC0639a);
        }
    }
}