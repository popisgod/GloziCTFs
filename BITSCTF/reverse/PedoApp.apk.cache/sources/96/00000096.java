package androidx.window.java.layout;

import android.app.Activity;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p015g.InterfaceC0170a;
import p048w0.C0733h;
import p048w0.C0735h1;
import p048w0.C0756m0;
import p048w0.InterfaceC0753l0;
import p048w0.InterfaceC0764o1;
import p054z0.InterfaceC0909b;

/* loaded from: classes.dex */
public final class WindowInfoTrackerCallbackAdapter implements WindowInfoTracker {
    private final Map<InterfaceC0170a<?>, InterfaceC0764o1> consumerToJobMap;
    private final ReentrantLock lock;
    private final WindowInfoTracker tracker;

    public WindowInfoTrackerCallbackAdapter(WindowInfoTracker tracker) {
        C0465i.m1048e(tracker, "tracker");
        this.tracker = tracker;
        this.lock = new ReentrantLock();
        this.consumerToJobMap = new LinkedHashMap();
    }

    private final <T> void addListener(Executor executor, InterfaceC0170a<T> interfaceC0170a, InterfaceC0909b<? extends T> interfaceC0909b) {
        InterfaceC0764o1 m458b;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.consumerToJobMap.get(interfaceC0170a) == null) {
                InterfaceC0753l0 m410a = C0756m0.m410a(C0735h1.m455a(executor));
                Map<InterfaceC0170a<?>, InterfaceC0764o1> map = this.consumerToJobMap;
                m458b = C0733h.m458b(m410a, null, null, new WindowInfoTrackerCallbackAdapter$addListener$1$1(interfaceC0909b, interfaceC0170a, null), 3, null);
                map.put(interfaceC0170a, m458b);
            }
            C0169q c0169q = C0169q.f235a;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void removeListener(InterfaceC0170a<?> interfaceC0170a) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            InterfaceC0764o1 interfaceC0764o1 = this.consumerToJobMap.get(interfaceC0170a);
            if (interfaceC0764o1 != null) {
                InterfaceC0764o1.C0765a.m404a(interfaceC0764o1, null, 1, null);
            }
            this.consumerToJobMap.remove(interfaceC0170a);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void addWindowLayoutInfoListener(Activity activity, Executor executor, InterfaceC0170a<WindowLayoutInfo> consumer) {
        C0465i.m1048e(activity, "activity");
        C0465i.m1048e(executor, "executor");
        C0465i.m1048e(consumer, "consumer");
        addListener(executor, consumer, this.tracker.windowLayoutInfo(activity));
    }

    public final void removeWindowLayoutInfoListener(InterfaceC0170a<WindowLayoutInfo> consumer) {
        C0465i.m1048e(consumer, "consumer");
        removeListener(consumer);
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public InterfaceC0909b<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        C0465i.m1048e(activity, "activity");
        return this.tracker.windowLayoutInfo(activity);
    }
}