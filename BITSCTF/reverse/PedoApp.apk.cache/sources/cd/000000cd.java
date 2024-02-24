package androidx.window.layout;

import android.content.Context;
import androidx.window.layout.WindowInfoTracker;

/* renamed from: androidx.window.layout.b */
/* loaded from: classes.dex */
public final /* synthetic */ class C0095b {
    static {
        WindowInfoTracker.Companion companion = WindowInfoTracker.Companion;
    }

    /* renamed from: a */
    public static WindowInfoTracker m2140a(Context context) {
        return WindowInfoTracker.Companion.getOrCreate(context);
    }

    /* renamed from: b */
    public static void m2139b(WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        WindowInfoTracker.Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    /* renamed from: c */
    public static void m2138c() {
        WindowInfoTracker.Companion.reset();
    }
}