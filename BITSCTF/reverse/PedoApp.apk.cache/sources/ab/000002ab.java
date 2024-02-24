package p025l;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.core.content.C0061a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import p001a0.InterfaceC0040m;
import p001a0.InterfaceC0043p;
import p009d.C0118a;
import p009d.C0123b;

/* renamed from: l.n */
/* loaded from: classes.dex */
final class C0552n implements InterfaceC0040m, InterfaceC0043p {

    /* renamed from: a */
    private final Context f1133a;

    /* renamed from: b */
    private InterfaceC0554b f1134b;

    /* renamed from: c */
    private Activity f1135c;

    /* renamed from: d */
    private int f1136d;

    /* renamed from: e */
    private Map<Integer, Integer> f1137e;

    @FunctionalInterface
    /* renamed from: l.n$a */
    /* loaded from: classes.dex */
    interface InterfaceC0553a {
        /* renamed from: a */
        void mo788a(int i);
    }

    @FunctionalInterface
    /* renamed from: l.n$b */
    /* loaded from: classes.dex */
    interface InterfaceC0554b {
        /* renamed from: a */
        void mo787a(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    /* renamed from: l.n$c */
    /* loaded from: classes.dex */
    interface InterfaceC0555c {
        /* renamed from: a */
        void mo786a(boolean z);
    }

    public C0552n(Context context) {
        this.f1133a = context;
    }

    /* renamed from: b */
    private int m798b() {
        List<String> m783c = C0556o.m783c(this.f1133a, 21);
        if (m783c == null || m783c.isEmpty()) {
            Log.d("permissions_handler", "Bluetooth permission missing in manifest");
            return 0;
        }
        return 1;
    }

    /* renamed from: d */
    private int m796d() {
        if (Build.VERSION.SDK_INT < 33) {
            return C0123b.m2079b(this.f1133a).m2080a() ? 1 : 0;
        } else if (this.f1133a.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            return 1;
        } else {
            return C0556o.m784b(this.f1135c, "android.permission.POST_NOTIFICATIONS");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    private int m794f(int i) {
        int i2;
        int i3;
        if (i == 17) {
            return m796d();
        }
        if (i == 21) {
            return m798b();
        }
        if ((i == 30 || i == 28 || i == 29) && Build.VERSION.SDK_INT < 31) {
            return m798b();
        }
        if ((i == 37 || i == 0) && !m793g()) {
            return 0;
        }
        List<String> m783c = C0556o.m783c(this.f1133a, i);
        if (m783c == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i);
            return 1;
        } else if (m783c.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + m783c + i);
            if (i != 16 || Build.VERSION.SDK_INT >= 23) {
                if (i != 22 || Build.VERSION.SDK_INT >= 30) {
                    return Build.VERSION.SDK_INT < 23 ? 1 : 0;
                }
                return 2;
            }
            return 2;
        } else {
            if (this.f1133a.getApplicationInfo().targetSdkVersion >= 23) {
                HashSet hashSet = new HashSet();
                for (String str : m783c) {
                    if (i == 16) {
                        String packageName = this.f1133a.getPackageName();
                        PowerManager powerManager = (PowerManager) this.f1133a.getSystemService("power");
                        if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                            i2 = 0;
                            hashSet.add(i2);
                        }
                        i2 = 1;
                        hashSet.add(i2);
                    } else {
                        if (i == 22) {
                            if (Build.VERSION.SDK_INT < 30) {
                                hashSet.add(2);
                            }
                            i3 = Environment.isExternalStorageManager();
                        } else if (i == 23) {
                            i3 = Settings.canDrawOverlays(this.f1133a);
                        } else {
                            if (i == 24) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    i3 = this.f1133a.getPackageManager().canRequestPackageInstalls();
                                }
                            } else if (i == 27) {
                                i3 = ((NotificationManager) this.f1133a.getSystemService("notification")).isNotificationPolicyAccessGranted();
                            } else if (i == 34) {
                                if (Build.VERSION.SDK_INT >= 31) {
                                    i3 = ((AlarmManager) this.f1133a.getSystemService("alarm")).canScheduleExactAlarms();
                                }
                                i2 = 1;
                            } else if (C0061a.m2226a(this.f1133a, str) != 0) {
                                i3 = C0556o.m784b(this.f1135c, str);
                            }
                            hashSet.add(i2);
                        }
                        i2 = Integer.valueOf(i3);
                        hashSet.add(i2);
                    }
                }
                if (!hashSet.isEmpty()) {
                    return C0556o.m776j(hashSet).intValue();
                }
            }
            return 1;
        }
    }

    /* renamed from: g */
    private boolean m793g() {
        List<String> m783c = C0556o.m783c(this.f1133a, 37);
        boolean z = m783c != null && m783c.contains("android.permission.WRITE_CALENDAR");
        boolean z2 = m783c != null && m783c.contains("android.permission.READ_CALENDAR");
        if (z && z2) {
            return true;
        }
        if (!z) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z2) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    /* renamed from: h */
    private void m792h(String str, int i) {
        if (this.f1135c == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.f1135c.getPackageName()));
        }
        this.f1135c.startActivityForResult(intent, i);
        this.f1136d++;
    }

    @Override // p001a0.InterfaceC0043p
    /* renamed from: a */
    public boolean mo799a(int i, String[] strArr, int[] iArr) {
        int m779g;
        Map<Integer, Integer> map;
        int i2;
        Integer valueOf;
        if (i != 24) {
            this.f1136d = 0;
            return false;
        } else if (this.f1137e == null) {
            return false;
        } else {
            if (strArr.length == 0 && iArr.length == 0) {
                Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
                return false;
            }
            List asList = Arrays.asList(strArr);
            int indexOf = asList.indexOf("android.permission.WRITE_CALENDAR");
            if (indexOf >= 0) {
                int m775k = C0556o.m775k(this.f1135c, "android.permission.WRITE_CALENDAR", iArr[indexOf]);
                this.f1137e.put(36, Integer.valueOf(m775k));
                int indexOf2 = asList.indexOf("android.permission.READ_CALENDAR");
                if (indexOf2 >= 0) {
                    int intValue = C0556o.m777i(Integer.valueOf(m775k), Integer.valueOf(C0556o.m775k(this.f1135c, "android.permission.READ_CALENDAR", iArr[indexOf2]))).intValue();
                    this.f1137e.put(37, Integer.valueOf(intValue));
                    this.f1137e.put(0, Integer.valueOf(intValue));
                }
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR") && (m779g = C0556o.m779g(str)) != 20) {
                    int i4 = iArr[i3];
                    if (m779g == 8) {
                        valueOf = C0556o.m777i(this.f1137e.get(8), Integer.valueOf(C0556o.m775k(this.f1135c, str, i4)));
                        map = this.f1137e;
                        i2 = 8;
                    } else if (m779g == 7) {
                        if (!this.f1137e.containsKey(7)) {
                            this.f1137e.put(7, Integer.valueOf(C0556o.m775k(this.f1135c, str, i4)));
                        }
                        if (!this.f1137e.containsKey(14)) {
                            this.f1137e.put(14, Integer.valueOf(C0556o.m775k(this.f1135c, str, i4)));
                        }
                    } else if (m779g == 4) {
                        int m775k2 = C0556o.m775k(this.f1135c, str, i4);
                        if (!this.f1137e.containsKey(4)) {
                            map = this.f1137e;
                            i2 = 4;
                            valueOf = Integer.valueOf(m775k2);
                        }
                    } else if (m779g == 3) {
                        int m775k3 = C0556o.m775k(this.f1135c, str, i4);
                        if (Build.VERSION.SDK_INT < 29 && !this.f1137e.containsKey(4)) {
                            this.f1137e.put(4, Integer.valueOf(m775k3));
                        }
                        if (!this.f1137e.containsKey(5)) {
                            this.f1137e.put(5, Integer.valueOf(m775k3));
                        }
                        this.f1137e.put(Integer.valueOf(m779g), Integer.valueOf(m775k3));
                    } else if (!this.f1137e.containsKey(Integer.valueOf(m779g))) {
                        this.f1137e.put(Integer.valueOf(m779g), Integer.valueOf(C0556o.m775k(this.f1135c, str, i4)));
                    }
                    map.put(i2, valueOf);
                }
            }
            int length = this.f1136d - iArr.length;
            this.f1136d = length;
            InterfaceC0554b interfaceC0554b = this.f1134b;
            if (interfaceC0554b == null || length != 0) {
                return true;
            }
            interfaceC0554b.mo787a(this.f1137e);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v4 */
    @Override // p001a0.InterfaceC0040m
    /* renamed from: c */
    public boolean mo797c(int i, int i2, Intent intent) {
        char canScheduleExactAlarms;
        Activity activity = this.f1135c;
        char c = 0;
        c = 0;
        if (activity == null) {
            return false;
        }
        int i3 = 23;
        if (i == 209) {
            if (Build.VERSION.SDK_INT >= 23) {
                String packageName = this.f1133a.getPackageName();
                PowerManager powerManager = (PowerManager) this.f1133a.getSystemService("power");
                if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                    c = 1;
                }
            } else {
                c = 2;
            }
            i3 = 16;
            canScheduleExactAlarms = c;
        } else if (i == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            i3 = 22;
            canScheduleExactAlarms = Environment.isExternalStorageManager();
        } else if (i == 211) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            canScheduleExactAlarms = Settings.canDrawOverlays(activity);
        } else if (i == 212) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            i3 = 24;
            canScheduleExactAlarms = activity.getPackageManager().canRequestPackageInstalls();
        } else if (i == 213) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            i3 = 27;
            canScheduleExactAlarms = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
        } else if (i != 214) {
            return false;
        } else {
            i3 = 34;
            canScheduleExactAlarms = Build.VERSION.SDK_INT >= 31 ? ((AlarmManager) activity.getSystemService("alarm")).canScheduleExactAlarms() : (char) 1;
        }
        this.f1137e.put(Integer.valueOf(i3), Integer.valueOf(canScheduleExactAlarms));
        int i4 = this.f1136d - 1;
        this.f1136d = i4;
        InterfaceC0554b interfaceC0554b = this.f1134b;
        if (interfaceC0554b != null && i4 == 0) {
            interfaceC0554b.mo787a(this.f1137e);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m795e(int i, InterfaceC0553a interfaceC0553a) {
        interfaceC0553a.mo788a(m794f(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m791i(List<Integer> list, InterfaceC0554b interfaceC0554b, InterfaceC0540b interfaceC0540b) {
        Map<Integer, Integer> map;
        int i;
        Map<Integer, Integer> map2;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        if (this.f1136d > 0) {
            str2 = "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).";
        } else if (this.f1135c != null) {
            this.f1134b = interfaceC0554b;
            this.f1137e = new HashMap();
            this.f1136d = 0;
            ArrayList arrayList = new ArrayList();
            for (Integer num : list) {
                if (m794f(num.intValue()) != 1) {
                    List<String> m783c = C0556o.m783c(this.f1135c, num.intValue());
                    if (m783c != null && !m783c.isEmpty()) {
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 >= 23 && num.intValue() == 16) {
                            i4 = 209;
                            str = "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";
                        } else if (i5 >= 30 && num.intValue() == 22) {
                            i4 = 210;
                            str = "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION";
                        } else if (i5 >= 23 && num.intValue() == 23) {
                            i4 = 211;
                            str = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
                        } else if (i5 >= 26 && num.intValue() == 24) {
                            i4 = 212;
                            str = "android.settings.MANAGE_UNKNOWN_APP_SOURCES";
                        } else if (i5 >= 23 && num.intValue() == 27) {
                            i4 = 213;
                            str = "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS";
                        } else if (i5 < 31 || num.intValue() != 34) {
                            if (num.intValue() != 37 && num.intValue() != 0) {
                                arrayList.addAll(m783c);
                                i3 = this.f1136d + m783c.size();
                            } else if (m793g()) {
                                arrayList.add("android.permission.WRITE_CALENDAR");
                                arrayList.add("android.permission.READ_CALENDAR");
                                i3 = this.f1136d + 2;
                            } else {
                                map = this.f1137e;
                                i = 0;
                            }
                            this.f1136d = i3;
                        } else {
                            i4 = 214;
                            str = "android.settings.REQUEST_SCHEDULE_EXACT_ALARM";
                        }
                        m792h(str, i4);
                    } else if (!this.f1137e.containsKey(num)) {
                        if (num.intValue() != 16 || Build.VERSION.SDK_INT >= 23) {
                            map2 = this.f1137e;
                            i2 = 0;
                        } else {
                            map2 = this.f1137e;
                            i2 = 2;
                        }
                        map2.put(num, i2);
                        if (num.intValue() == 22 && Build.VERSION.SDK_INT < 30) {
                            map = this.f1137e;
                            i = 2;
                        }
                        map = this.f1137e;
                        i = 0;
                    }
                    map.put(num, i);
                } else if (!this.f1137e.containsKey(num)) {
                    map = this.f1137e;
                    i = 1;
                    map.put(num, i);
                }
            }
            if (arrayList.size() > 0) {
                C0118a.m2085c(this.f1135c, (String[]) arrayList.toArray(new String[0]), 24);
            }
            InterfaceC0554b interfaceC0554b2 = this.f1134b;
            if (interfaceC0554b2 == null || this.f1136d != 0) {
                return;
            }
            interfaceC0554b2.mo787a(this.f1137e);
            return;
        } else {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            str2 = "Unable to detect current Android Activity.";
        }
        interfaceC0540b.mo814a("PermissionHandler.PermissionManager", str2);
    }

    /* renamed from: j */
    public void m790j(Activity activity) {
        this.f1135c = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m789k(int i, InterfaceC0555c interfaceC0555c, InterfaceC0540b interfaceC0540b) {
        Activity activity = this.f1135c;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            interfaceC0540b.mo814a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> m783c = C0556o.m783c(activity, i);
        if (m783c == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i);
            interfaceC0555c.mo786a(false);
        } else if (!m783c.isEmpty()) {
            interfaceC0555c.mo786a(C0118a.m2084d(this.f1135c, m783c.get(0)));
        } else {
            Log.d("permissions_handler", "No permissions found in manifest for: " + i + " no need to show request rationale");
            interfaceC0555c.mo786a(false);
        }
    }
}