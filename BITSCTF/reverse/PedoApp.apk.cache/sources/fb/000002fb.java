package p037r;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.C0425d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import p012e0.C0140b;
import p012e0.C0143e;
import p031o.C0572a;
import p031o.C0576b;
import p037r.C0632d;

/* renamed from: r.d */
/* loaded from: classes.dex */
public class C0632d {

    /* renamed from: a */
    private boolean f1238a;

    /* renamed from: b */
    private C0635c f1239b;

    /* renamed from: c */
    private long f1240c;

    /* renamed from: d */
    private C0630b f1241d;

    /* renamed from: e */
    private FlutterJNI f1242e;

    /* renamed from: f */
    private ExecutorService f1243f;

    /* renamed from: g */
    Future<C0634b> f1244g;

    /* renamed from: r.d$a */
    /* loaded from: classes.dex */
    public class CallableC0633a implements Callable<C0634b> {

        /* renamed from: a */
        final /* synthetic */ Context f1245a;

        CallableC0633a(Context context) {
            C0632d.this = r1;
            this.f1245a = context;
        }

        /* renamed from: a */
        public static /* synthetic */ void m670a(CallableC0633a callableC0633a) {
            callableC0633a.m668c();
        }

        /* renamed from: c */
        public /* synthetic */ void m668c() {
            C0632d.this.f1242e.prefetchDefaultFontManager();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b */
        public C0634b call() {
            C0143e.m2035a("FlutterLoader initTask");
            try {
                C0632d.this.m675h(this.f1245a);
                C0632d.this.f1242e.loadLibrary();
                C0632d.this.f1242e.updateRefreshRate();
                C0632d.this.f1243f.execute(new Runnable() { // from class: r.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0632d.CallableC0633a.m670a(C0632d.CallableC0633a.this);
                    }
                });
                return new C0634b(C0140b.m2037d(this.f1245a), C0140b.m2040a(this.f1245a), C0140b.m2038c(this.f1245a), null);
            } finally {
                C0143e.m2032d();
            }
        }
    }

    /* renamed from: r.d$b */
    /* loaded from: classes.dex */
    public static class C0634b {

        /* renamed from: a */
        final String f1247a;

        /* renamed from: b */
        final String f1248b;

        /* renamed from: c */
        final String f1249c;

        private C0634b(String str, String str2, String str3) {
            this.f1247a = str;
            this.f1248b = str2;
            this.f1249c = str3;
        }

        /* synthetic */ C0634b(String str, String str2, String str3, CallableC0633a callableC0633a) {
            this(str, str2, str3);
        }
    }

    /* renamed from: r.d$c */
    /* loaded from: classes.dex */
    public static class C0635c {

        /* renamed from: a */
        private String f1250a;

        /* renamed from: a */
        public String m667a() {
            return this.f1250a;
        }
    }

    public C0632d() {
        this(C0572a.m745e().m746d().m1629a());
    }

    public C0632d(FlutterJNI flutterJNI) {
        this(flutterJNI, C0572a.m745e().m748b());
    }

    public C0632d(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f1238a = false;
        this.f1242e = flutterJNI;
        this.f1243f = executorService;
    }

    /* renamed from: d */
    private static boolean m679d() {
        return false;
    }

    /* renamed from: h */
    public C0636e m675h(Context context) {
        return null;
    }

    /* renamed from: j */
    private static boolean m673j(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }

    /* renamed from: e */
    public boolean m678e() {
        return this.f1241d.f1236g;
    }

    /* renamed from: f */
    public void m677f(Context context, String[] strArr) {
        if (this.f1238a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f1239b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        C0143e.m2035a("FlutterLoader#ensureInitializationComplete");
        try {
            try {
                C0634b c0634b = this.f1244g.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                StringBuilder sb = new StringBuilder();
                sb.append("--icu-native-lib-path=");
                sb.append(this.f1241d.f1235f);
                String str = File.separator;
                sb.append(str);
                sb.append("libflutter.so");
                arrayList.add(sb.toString());
                if (strArr != null) {
                    Collections.addAll(arrayList, strArr);
                }
                arrayList.add("--aot-shared-library-name=" + this.f1241d.f1230a);
                arrayList.add("--aot-shared-library-name=" + this.f1241d.f1235f + str + this.f1241d.f1230a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--cache-dir-path=");
                sb2.append(c0634b.f1248b);
                arrayList.add(sb2.toString());
                if (this.f1241d.f1234e != null) {
                    arrayList.add("--domain-network-policy=" + this.f1241d.f1234e);
                }
                if (this.f1239b.m667a() != null) {
                    arrayList.add("--log-tag=" + this.f1239b.m667a());
                }
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int i = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
                if (i == 0) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    double d = memoryInfo.totalMem;
                    Double.isNaN(d);
                    i = (int) ((d / 1000000.0d) / 2.0d);
                }
                arrayList.add("--old-gen-heap-size=" + i);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 12 * 4));
                arrayList.add("--prefetched-default-font-manager");
                if (bundle != null) {
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableImpeller", false)) {
                        arrayList.add("--enable-impeller");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", m679d())) {
                        arrayList.add("--enable-vulkan-validation");
                    }
                    String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                    if (string != null) {
                        arrayList.add("--impeller-backend=" + string);
                    }
                }
                arrayList.add("--leak-vm=" + (m673j(bundle) ? "true" : "false"));
                this.f1242e.init(context, (String[]) arrayList.toArray(new String[0]), null, c0634b.f1247a, c0634b.f1248b, SystemClock.uptimeMillis() - this.f1240c);
                this.f1238a = true;
            } catch (Exception e) {
                C0576b.m740c("FlutterLoader", "Flutter initialization failed.", e);
                throw new RuntimeException(e);
            }
        } finally {
            C0143e.m2032d();
        }
    }

    /* renamed from: g */
    public String m676g() {
        return this.f1241d.f1233d;
    }

    /* renamed from: i */
    public boolean m674i() {
        return this.f1238a;
    }

    /* renamed from: k */
    public void m672k(Context context) {
        m671l(context, new C0635c());
    }

    /* renamed from: l */
    public void m671l(Context context, C0635c c0635c) {
        if (this.f1239b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        C0143e.m2035a("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f1239b = c0635c;
            this.f1240c = SystemClock.uptimeMillis();
            this.f1241d = C0629a.m686e(applicationContext);
            (Build.VERSION.SDK_INT >= 17 ? C0425d.m1100g((DisplayManager) applicationContext.getSystemService("display"), this.f1242e) : C0425d.m1101f(((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getRefreshRate(), this.f1242e)).m1099h();
            this.f1244g = this.f1243f.submit(new CallableC0633a(applicationContext));
        } finally {
            C0143e.m2032d();
        }
    }
}