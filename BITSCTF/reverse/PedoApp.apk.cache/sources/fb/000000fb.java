package p012e0;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* renamed from: e0.b */
/* loaded from: classes.dex */
public final class C0140b {
    /* renamed from: a */
    public static String m2040a(Context context) {
        File cacheDir;
        if (Build.VERSION.SDK_INT < 21 || (cacheDir = context.getCodeCacheDir()) == null) {
            cacheDir = context.getCacheDir();
        }
        if (cacheDir == null) {
            cacheDir = new File(m2039b(context), "cache");
        }
        return cacheDir.getPath();
    }

    /* renamed from: b */
    private static String m2039b(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? context.getDataDir().getPath() : context.getApplicationInfo().dataDir;
    }

    /* renamed from: c */
    public static String m2038c(Context context) {
        File dir = context.getDir("flutter", 0);
        if (dir == null) {
            dir = new File(m2039b(context), "app_flutter");
        }
        return dir.getPath();
    }

    /* renamed from: d */
    public static String m2037d(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(m2039b(context), "files");
        }
        return filesDir.getPath();
    }
}