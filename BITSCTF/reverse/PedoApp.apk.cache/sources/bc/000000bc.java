package androidx.window.layout;

import android.app.Activity;
import java.util.concurrent.Executor;
import p015g.InterfaceC0170a;

/* loaded from: classes.dex */
public interface WindowBackend {
    void registerLayoutChangeCallback(Activity activity, Executor executor, InterfaceC0170a<WindowLayoutInfo> interfaceC0170a);

    void unregisterLayoutChangeCallback(InterfaceC0170a<WindowLayoutInfo> interfaceC0170a);
}