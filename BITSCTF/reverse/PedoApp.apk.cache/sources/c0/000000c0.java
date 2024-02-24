package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p054z0.C0911d;
import p054z0.InterfaceC0909b;

/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    public static final Companion Companion = new Companion(null);
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C0461e c0461e) {
            this();
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        C0465i.m1048e(windowMetricsCalculator, "windowMetricsCalculator");
        C0465i.m1048e(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public InterfaceC0909b<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        C0465i.m1048e(activity, "activity");
        return C0911d.m2a(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, null));
    }
}