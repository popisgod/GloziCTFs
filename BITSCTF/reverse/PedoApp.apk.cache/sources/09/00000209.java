package io.flutter.plugins;

import androidx.annotation.Keep;
import io.flutter.embedding.engine.C0313a;
import p010d0.C0136j;
import p025l.C0551m;
import p027m.C0561a;
import p029n.C0567b;
import p031o.C0576b;

@Keep
/* loaded from: classes.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(C0313a c0313a) {
        try {
            c0313a.m1612q().mo634i(new C0136j());
        } catch (Exception e) {
            C0576b.m740c(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e);
        }
        try {
            c0313a.m1612q().mo634i(new C0561a());
        } catch (Exception e2) {
            C0576b.m740c(TAG, "Error registering plugin pedometer, com.example.pedometer.PedometerPlugin", e2);
        }
        try {
            c0313a.m1612q().mo634i(new C0551m());
        } catch (Exception e3) {
            C0576b.m740c(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e3);
        }
        try {
            c0313a.m1612q().mo634i(new C0567b());
        } catch (Exception e4) {
            C0576b.m740c(TAG, "Error registering plugin sensors_plus, dev.fluttercommunity.plus.sensors.SensorsPlugin", e4);
        }
    }
}