package io.flutter.embedding.android;

import android.app.Activity;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowLayoutInfo;
import java.util.concurrent.Executor;
import p015g.InterfaceC0170a;

/* renamed from: io.flutter.embedding.android.w */
/* loaded from: classes.dex */
public class C0309w {

    /* renamed from: a */
    final WindowInfoTrackerCallbackAdapter f454a;

    public C0309w(WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter) {
        this.f454a = windowInfoTrackerCallbackAdapter;
    }

    /* renamed from: a */
    public void m1632a(Activity activity, Executor executor, InterfaceC0170a<WindowLayoutInfo> interfaceC0170a) {
        this.f454a.addWindowLayoutInfoListener(activity, executor, interfaceC0170a);
    }

    /* renamed from: b */
    public void m1631b(InterfaceC0170a<WindowLayoutInfo> interfaceC0170a) {
        this.f454a.removeWindowLayoutInfoListener(interfaceC0170a);
    }
}