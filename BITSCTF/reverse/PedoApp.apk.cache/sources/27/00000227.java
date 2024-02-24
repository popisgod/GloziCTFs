package io.flutter.view;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* renamed from: io.flutter.view.d */
/* loaded from: classes.dex */
public class C0425d {

    /* renamed from: e */
    private static C0425d f938e;

    /* renamed from: f */
    private static C0427b f939f;

    /* renamed from: b */
    private FlutterJNI f941b;

    /* renamed from: a */
    private long f940a = -1;

    /* renamed from: c */
    private Choreographer$FrameCallbackC0428c f942c = new Choreographer$FrameCallbackC0428c(0);

    /* renamed from: d */
    private final FlutterJNI.InterfaceC0311b f943d = new C0426a();

    /* renamed from: io.flutter.view.d$a */
    /* loaded from: classes.dex */
    class C0426a implements FlutterJNI.InterfaceC0311b {
        C0426a() {
        }

        /* renamed from: b */
        private Choreographer.FrameCallback m1097b(long j) {
            if (C0425d.this.f942c != null) {
                C0425d.this.f942c.f947a = j;
                Choreographer$FrameCallbackC0428c choreographer$FrameCallbackC0428c = C0425d.this.f942c;
                C0425d.this.f942c = null;
                return choreographer$FrameCallbackC0428c;
            }
            return new Choreographer$FrameCallbackC0428c(j);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.InterfaceC0311b
        /* renamed from: a */
        public void mo1098a(long j) {
            Choreographer.getInstance().postFrameCallback(m1097b(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(17)
    /* renamed from: io.flutter.view.d$b */
    /* loaded from: classes.dex */
    public class C0427b implements DisplayManager.DisplayListener {

        /* renamed from: a */
        private DisplayManager f945a;

        C0427b(DisplayManager displayManager) {
            this.f945a = displayManager;
        }

        /* renamed from: a */
        void m1096a() {
            this.f945a.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                float refreshRate = this.f945a.getDisplay(0).getRefreshRate();
                C0425d c0425d = C0425d.this;
                double d = refreshRate;
                Double.isNaN(d);
                c0425d.f940a = (long) (1.0E9d / d);
                C0425d.this.f941b.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.view.d$c */
    /* loaded from: classes.dex */
    public class Choreographer$FrameCallbackC0428c implements Choreographer.FrameCallback {

        /* renamed from: a */
        private long f947a;

        Choreographer$FrameCallbackC0428c(long j) {
            this.f947a = j;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            long nanoTime = System.nanoTime() - j;
            C0425d.this.f941b.onVsync(nanoTime < 0 ? 0L : nanoTime, C0425d.this.f940a, this.f947a);
            C0425d.this.f942c = this;
        }
    }

    private C0425d(FlutterJNI flutterJNI) {
        this.f941b = flutterJNI;
    }

    /* renamed from: f */
    public static C0425d m1101f(float f, FlutterJNI flutterJNI) {
        if (f938e == null) {
            f938e = new C0425d(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(f);
        C0425d c0425d = f938e;
        double d = f;
        Double.isNaN(d);
        c0425d.f940a = (long) (1.0E9d / d);
        return c0425d;
    }

    @TargetApi(17)
    /* renamed from: g */
    public static C0425d m1100g(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f938e == null) {
            f938e = new C0425d(flutterJNI);
        }
        if (f939f == null) {
            C0425d c0425d = f938e;
            Objects.requireNonNull(c0425d);
            C0427b c0427b = new C0427b(displayManager);
            f939f = c0427b;
            c0427b.m1096a();
        }
        if (f938e.f940a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            C0425d c0425d2 = f938e;
            double d = refreshRate;
            Double.isNaN(d);
            c0425d2.f940a = (long) (1.0E9d / d);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f938e;
    }

    /* renamed from: h */
    public void m1099h() {
        this.f941b.setAsyncWaitForVsyncDelegate(this.f943d);
    }
}