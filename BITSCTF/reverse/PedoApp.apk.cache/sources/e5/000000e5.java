package p009d;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.C0061a;
import java.util.Arrays;

/* renamed from: d.a */
/* loaded from: classes.dex */
public class C0118a extends C0061a {

    /* renamed from: c */
    private static InterfaceC0121c f186c;

    /* renamed from: d.a$a */
    /* loaded from: classes.dex */
    class RunnableC0119a implements Runnable {

        /* renamed from: d */
        final /* synthetic */ String[] f187d;

        /* renamed from: e */
        final /* synthetic */ Activity f188e;

        /* renamed from: f */
        final /* synthetic */ int f189f;

        RunnableC0119a(String[] strArr, Activity activity, int i) {
            this.f187d = strArr;
            this.f188e = activity;
            this.f189f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f187d.length];
            PackageManager packageManager = this.f188e.getPackageManager();
            String packageName = this.f188e.getPackageName();
            int length = this.f187d.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f187d[i], packageName);
            }
            ((InterfaceC0120b) this.f188e).m2083a(this.f189f, this.f187d, iArr);
        }
    }

    /* renamed from: d.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0120b {
        /* renamed from: a */
        void m2083a(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: d.a$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0121c {
        /* renamed from: a */
        boolean m2082a(Activity activity, String[] strArr, int i);
    }

    /* renamed from: d.a$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0122d {
        /* renamed from: a */
        void m2081a(int i);
    }

    /* renamed from: c */
    public static void m2085c(Activity activity, String[] strArr, int i) {
        InterfaceC0121c interfaceC0121c = f186c;
        if (interfaceC0121c == null || !interfaceC0121c.m2082a(activity, strArr, i)) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof InterfaceC0122d) {
                    ((InterfaceC0122d) activity).m2081a(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof InterfaceC0120b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0119a(strArr, activity, i));
            }
        }
    }

    /* renamed from: d */
    public static boolean m2084d(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}