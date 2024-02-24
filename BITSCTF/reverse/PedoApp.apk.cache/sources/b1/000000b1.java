package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p016g0.C0187i;

/* loaded from: classes.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    private ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    private final SidecarAdapter sidecarAdapter;
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C0461e c0461e) {
            this();
        }

        public final IBinder getActivityWindowToken$window_release(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.Companion.parse(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface) {
            C0465i.m1048e(callbackInterface, "callbackInterface");
            this.callbackInterface = callbackInterface;
            this.lock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo newLayout) {
            C0465i.m1048e(activity, "activity");
            C0465i.m1048e(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (C0465i.m1052a(newLayout, this.activityWindowLayoutInfo.get(activity))) {
                    return;
                }
                this.activityWindowLayoutInfo.put(activity, newLayout);
                reentrantLock.unlock();
                this.callbackInterface.onWindowLayoutChanged(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock;
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback callbackInterface) {
            C0465i.m1048e(sidecarAdapter, "sidecarAdapter");
            C0465i.m1048e(callbackInterface, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter;
            this.callbackInterface = callbackInterface;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap<>();
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            C0465i.m1048e(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, newDeviceState)) {
                    return;
                }
                this.lastDeviceState = newDeviceState;
                this.callbackInterface.onDeviceStateChanged(newDeviceState);
                C0169q c0169q = C0169q.f235a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            C0465i.m1048e(token, "token");
            C0465i.m1048e(newLayout, "newLayout");
            synchronized (this.lock) {
                if (this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(token), newLayout)) {
                    return;
                }
                this.mActivityWindowLayoutInfo.put(token, newLayout);
                this.callbackInterface.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            C0465i.m1048e(sidecarCompat, "sidecarCompat");
            C0465i.m1048e(activity, "activity");
            this.sidecarCompat = sidecarCompat;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            C0465i.m1048e(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            if (activity == null || activityWindowToken$window_release == null) {
                return;
            }
            this.sidecarCompat.register(activityWindowToken$window_release, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            C0465i.m1048e(view, "view");
        }
    }

    /* loaded from: classes.dex */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat this$0) {
            C0465i.m1048e(this$0, "this$0");
            this.this$0 = this$0;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecar;
            C0465i.m1048e(newDeviceState, "newDeviceState");
            Collection<Activity> values = this.this$0.windowListenerRegisteredContexts.values();
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : values) {
                IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (activityWindowToken$window_release != null && (sidecar = sidecarCompat.getSidecar()) != null) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = sidecarCompat.extensionCallback;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, newDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            C0465i.m1048e(windowToken, "windowToken");
            C0465i.m1048e(newLayout, "newLayout");
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(windowToken);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            SidecarDeviceState deviceState = sidecar == null ? null : sidecar.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = sidecarAdapter.translate(newLayout, deviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.this$0.extensionCallback;
            if (extensionCallbackInterface == null) {
                return;
            }
            extensionCallbackInterface.onWindowLayoutChanged(activity, translate);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(SidecarProvider.getSidecarImpl(context.getApplicationContext()), new SidecarAdapter());
        C0465i.m1048e(context, "context");
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        C0465i.m1048e(sidecarAdapter, "sidecarAdapter");
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    public static final /* synthetic */ ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p(SidecarCompat sidecarCompat) {
        return sidecarCompat.extensionCallback;
    }

    private final void registerConfigurationChangeListener(final Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            ComponentCallbacks componentCallbacks = new ComponentCallbacks() { // from class: androidx.window.layout.SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1
                {
                    SidecarCompat.this = this;
                }

                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration newConfig) {
                    C0465i.m1048e(newConfig, "newConfig");
                    ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = SidecarCompat.access$getExtensionCallback$p(SidecarCompat.this);
                    if (access$getExtensionCallback$p == null) {
                        return;
                    }
                    Activity activity2 = activity;
                    access$getExtensionCallback$p.onWindowLayoutChanged(activity2, SidecarCompat.this.getWindowLayoutInfo(activity2));
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }
            };
            this.componentCallbackMap.put(activity, componentCallbacks);
            activity.registerComponentCallbacks(componentCallbacks);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    public final WindowLayoutInfo getWindowLayoutInfo(Activity activity) {
        List m1963b;
        C0465i.m1048e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            m1963b = C0187i.m1963b();
            return new WindowLayoutInfo(m1963b);
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        SidecarAdapter sidecarAdapter = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.translate(windowLayoutInfo, deviceState);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(Activity activity) {
        C0465i.m1048e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(Activity activity) {
        SidecarInterface sidecarInterface;
        C0465i.m1048e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
        }
        unregisterComponentCallback(activity);
        boolean z = this.windowListenerRegisteredContexts.size() == 1;
        this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
        if (!z || (sidecarInterface = this.sidecar) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final void register(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        C0465i.m1048e(windowToken, "windowToken");
        C0465i.m1048e(activity, "activity");
        this.windowListenerRegisteredContexts.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback) {
        C0465i.m1048e(extensionCallback, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallback);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0020 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x002c A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0059 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0065 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0082 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x008e A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00aa A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00b6 A[Catch: all -> 0x019a, TRY_LEAVE, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x016a A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0176 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0182 A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x018e A[Catch: all -> 0x019a, TryCatch #1 {all -> 0x019a, blocks: (B:103:0x0002, B:113:0x0024, B:115:0x002c, B:119:0x0034, B:123:0x003c, B:133:0x005d, B:135:0x0065, B:145:0x0086, B:147:0x008e, B:157:0x00ae, B:159:0x00b6, B:161:0x00bc, B:167:0x00f2, B:168:0x010e, B:170:0x0112, B:172:0x0141, B:175:0x014a, B:176:0x0151, B:177:0x0152, B:178:0x0159, B:163:0x00bf, B:165:0x00ea, B:179:0x015a, B:180:0x0161, B:181:0x0162, B:182:0x0169, B:183:0x016a, B:184:0x0175, B:156:0x00aa, B:150:0x0094, B:153:0x009b, B:185:0x0176, B:186:0x0181, B:144:0x0082, B:138:0x006b, B:141:0x0072, B:187:0x0182, B:188:0x018d, B:132:0x0059, B:126:0x0042, B:129:0x0049, B:122:0x0039, B:118:0x0031, B:189:0x018e, B:190:0x0199, B:112:0x0020, B:106:0x0009, B:109:0x0010), top: B:195:0x0002, inners: #0, #2 }] */
    @Override // androidx.window.layout.ExtensionInterfaceCompat
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean validateExtensionInterface() {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }
}