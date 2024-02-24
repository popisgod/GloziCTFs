package p009d;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: d.b */
/* loaded from: classes.dex */
public final class C0123b {

    /* renamed from: c */
    private static final Object f190c = new Object();

    /* renamed from: d */
    private static Set<String> f191d = new HashSet();

    /* renamed from: e */
    private static final Object f192e = new Object();

    /* renamed from: a */
    private final Context f193a;

    /* renamed from: b */
    private final NotificationManager f194b;

    private C0123b(Context context) {
        this.f193a = context;
        this.f194b = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: b */
    public static C0123b m2079b(Context context) {
        return new C0123b(context);
    }

    /* renamed from: a */
    public boolean m2080a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return this.f194b.areNotificationsEnabled();
        }
        if (i >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f193a.getSystemService("appops");
            ApplicationInfo applicationInfo = this.f193a.getApplicationInfo();
            String packageName = this.f193a.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                return true;
            }
        }
        return true;
    }
}