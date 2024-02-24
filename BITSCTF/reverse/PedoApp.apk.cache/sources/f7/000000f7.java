package p010d0;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.window.C0082R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p001a0.InterfaceC0016c;
import p010d0.C0124a;
import p012e0.C0140b;
import p041t.InterfaceC0648a;

/* renamed from: d0.j */
/* loaded from: classes.dex */
public class C0136j implements InterfaceC0648a, C0124a.InterfaceC0126b {

    /* renamed from: a */
    private Context f217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d0.j$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0137a {

        /* renamed from: a */
        static final /* synthetic */ int[] f218a;

        static {
            int[] iArr = new int[C0124a.EnumC0127c.values().length];
            f218a = iArr;
            try {
                iArr[C0124a.EnumC0127c.ROOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f218a[C0124a.EnumC0127c.MUSIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f218a[C0124a.EnumC0127c.PODCASTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f218a[C0124a.EnumC0127c.RINGTONES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f218a[C0124a.EnumC0127c.ALARMS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f218a[C0124a.EnumC0127c.NOTIFICATIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f218a[C0124a.EnumC0127c.PICTURES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f218a[C0124a.EnumC0127c.MOVIES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f218a[C0124a.EnumC0127c.DOWNLOADS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f218a[C0124a.EnumC0127c.DCIM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f218a[C0124a.EnumC0127c.DOCUMENTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* renamed from: j */
    private String m2054j() {
        return C0140b.m2037d(this.f217a);
    }

    /* renamed from: k */
    private String m2053k() {
        return C0140b.m2038c(this.f217a);
    }

    /* renamed from: l */
    private List<String> m2052l() {
        File[] externalCacheDirs;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.f217a.getExternalCacheDirs()) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalCacheDir = this.f217a.getExternalCacheDir();
            if (externalCacheDir != null) {
                arrayList.add(externalCacheDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    private List<String> m2051m(C0124a.EnumC0127c enumC0127c) {
        File[] externalFilesDirs;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.f217a.getExternalFilesDirs(m2048p(enumC0127c))) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalFilesDir = this.f217a.getExternalFilesDir(m2048p(enumC0127c));
            if (externalFilesDir != null) {
                arrayList.add(externalFilesDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* renamed from: n */
    private String m2050n() {
        File externalFilesDir = this.f217a.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* renamed from: o */
    private String m2049o() {
        return this.f217a.getCacheDir().getPath();
    }

    /* renamed from: p */
    private String m2048p(C0124a.EnumC0127c enumC0127c) {
        switch (C0137a.f218a[enumC0127c.ordinal()]) {
            case 1:
                return null;
            case 2:
                return "music";
            case 3:
                return "podcasts";
            case 4:
                return "ringtones";
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                return "alarms";
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                return "notifications";
            case 7:
                return "pictures";
            case 8:
                return "movies";
            case 9:
                return "downloads";
            case 10:
                return "dcim";
            case 11:
                return "documents";
            default:
                throw new RuntimeException("Unrecognized directory: " + enumC0127c);
        }
    }

    /* renamed from: q */
    private void m2047q(InterfaceC0016c interfaceC0016c, Context context) {
        try {
            C0135i.m2062p(interfaceC0016c, this);
        } catch (Exception e) {
            Log.e("PathProviderPlugin", "Received exception while setting up PathProviderPlugin", e);
        }
        this.f217a = context;
    }

    @Override // p010d0.C0124a.InterfaceC0126b
    /* renamed from: a */
    public List<String> mo2061a(C0124a.EnumC0127c enumC0127c) {
        return m2051m(enumC0127c);
    }

    @Override // p010d0.C0124a.InterfaceC0126b
    /* renamed from: b */
    public String mo2060b() {
        return m2050n();
    }

    @Override // p010d0.C0124a.InterfaceC0126b
    /* renamed from: c */
    public String mo2059c() {
        return m2049o();
    }

    @Override // p010d0.C0124a.InterfaceC0126b
    /* renamed from: d */
    public String mo2058d() {
        return this.f217a.getCacheDir().getPath();
    }

    @Override // p010d0.C0124a.InterfaceC0126b
    /* renamed from: e */
    public String mo2057e() {
        return m2053k();
    }

    @Override // p010d0.C0124a.InterfaceC0126b
    /* renamed from: f */
    public String mo2056f() {
        return m2054j();
    }

    @Override // p041t.InterfaceC0648a
    /* renamed from: g */
    public void mo638g(InterfaceC0648a.C0650b c0650b) {
        C0135i.m2062p(c0650b.m635b(), null);
    }

    @Override // p010d0.C0124a.InterfaceC0126b
    /* renamed from: h */
    public List<String> mo2055h() {
        return m2052l();
    }

    @Override // p041t.InterfaceC0648a
    /* renamed from: i */
    public void mo637i(InterfaceC0648a.C0650b c0650b) {
        m2047q(c0650b.m635b(), c0650b.m636a());
    }
}