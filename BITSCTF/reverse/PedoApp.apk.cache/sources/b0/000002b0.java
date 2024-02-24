package p025l;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

/* renamed from: l.p */
/* loaded from: classes.dex */
final class C0557p {

    @FunctionalInterface
    /* renamed from: l.p$a */
    /* loaded from: classes.dex */
    interface InterfaceC0558a {
        /* renamed from: a */
        void mo767a(int i);
    }

    /* renamed from: b */
    private List<ResolveInfo> m772b(PackageManager packageManager) {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:123123"));
        return Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(intent, 0);
    }

    /* renamed from: c */
    private boolean m771c(Context context) {
        return (Build.VERSION.SDK_INT < 18 ? BluetoothAdapter.getDefaultAdapter() : ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter()).isEnabled();
    }

    /* renamed from: d */
    private static boolean m770d(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return false;
        }
        return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
    }

    /* renamed from: e */
    private boolean m769e(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return i >= 19 ? m768f(context) : m770d(context);
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
        if (locationManager == null) {
            return false;
        }
        return locationManager.isLocationEnabled();
    }

    /* renamed from: f */
    private static boolean m768f(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m773a(int i, Context context, InterfaceC0558a interfaceC0558a, InterfaceC0540b interfaceC0540b) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            interfaceC0540b.mo814a("PermissionHandler.ServiceManager", "Android context cannot be null.");
        } else if (i == 3 || i == 4 || i == 5) {
            interfaceC0558a.mo767a(m769e(context) ? 1 : 0);
        } else if (i == 21) {
            interfaceC0558a.mo767a(m771c(context) ? 1 : 0);
        } else {
            if (i != 8) {
                if (i == 16) {
                    interfaceC0558a.mo767a(Build.VERSION.SDK_INT < 23 ? 2 : 1);
                    return;
                } else {
                    interfaceC0558a.mo767a(2);
                    return;
                }
            }
            PackageManager packageManager = context.getPackageManager();
            if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
                interfaceC0558a.mo767a(2);
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
                interfaceC0558a.mo767a(2);
            } else if (m772b(packageManager).isEmpty()) {
                interfaceC0558a.mo767a(2);
            } else if (telephonyManager.getSimState() != 5) {
                interfaceC0558a.mo767a(0);
            } else {
                interfaceC0558a.mo767a(1);
            }
        }
    }
}