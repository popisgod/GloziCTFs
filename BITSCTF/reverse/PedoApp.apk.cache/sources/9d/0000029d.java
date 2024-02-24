package p025l;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/* renamed from: l.a */
/* loaded from: classes.dex */
final class C0538a {

    @FunctionalInterface
    /* renamed from: l.a$a */
    /* loaded from: classes.dex */
    interface InterfaceC0539a {
        /* renamed from: a */
        void mo815a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m816a(Context context, InterfaceC0539a interfaceC0539a, InterfaceC0540b interfaceC0540b) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            interfaceC0540b.mo814a("PermissionHandler.AppSettingsManager", "Android context cannot be null.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            context.startActivity(intent);
            interfaceC0539a.mo815a(true);
        } catch (Exception unused) {
            interfaceC0539a.mo815a(false);
        }
    }
}