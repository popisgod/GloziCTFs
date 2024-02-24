package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.InterfaceC0059b;
import io.flutter.plugin.platform.C0371d;
import java.io.FileNotFoundException;
import java.util.List;
import p017h.C0229e;
import p031o.C0576b;
import p053z.C0862j;

/* renamed from: io.flutter.plugin.platform.d */
/* loaded from: classes.dex */
public class C0371d {

    /* renamed from: a */
    private final Activity f674a;

    /* renamed from: b */
    private final C0862j f675b;

    /* renamed from: c */
    private final InterfaceC0375d f676c;

    /* renamed from: d */
    private C0862j.C0872j f677d;

    /* renamed from: e */
    private int f678e;

    /* renamed from: f */
    final C0862j.InterfaceC0870h f679f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.d$a */
    /* loaded from: classes.dex */
    public class C0372a implements C0862j.InterfaceC0870h {
        C0372a() {
            C0371d.this = r1;
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: a */
        public void mo118a(C0862j.EnumC0873k enumC0873k) {
            C0371d.this.m1400y(enumC0873k);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: b */
        public void mo117b() {
            C0371d.this.m1401x();
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: c */
        public void mo116c() {
            C0371d.this.m1406s();
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: d */
        public CharSequence mo115d(C0862j.EnumC0867e enumC0867e) {
            return C0371d.this.m1408q(enumC0867e);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: e */
        public void mo114e(boolean z) {
            C0371d.this.m1403v(z);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: f */
        public void mo113f(int i) {
            C0371d.this.m1428A(i);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: g */
        public void mo112g(C0862j.C0872j c0872j) {
            C0371d.this.m1427B(c0872j);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: h */
        public void mo111h(List<C0862j.EnumC0874l> list) {
            C0371d.this.m1399z(list);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: i */
        public void mo110i(C0862j.EnumC0871i enumC0871i) {
            C0371d.this.m1407r(enumC0871i);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: j */
        public void mo109j() {
            C0371d.this.m1405t();
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: k */
        public void mo108k(String str) {
            C0371d.this.m1404u(str);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: l */
        public void mo107l(C0862j.C0865c c0865c) {
            C0371d.this.m1402w(c0865c);
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: m */
        public boolean mo106m() {
            return C0371d.this.m1410o();
        }

        @Override // p053z.C0862j.InterfaceC0870h
        /* renamed from: n */
        public void mo105n(C0862j.EnumC0869g enumC0869g) {
            C0371d.this.m1425D(enumC0869g);
        }
    }

    /* renamed from: io.flutter.plugin.platform.d$b */
    /* loaded from: classes.dex */
    public class View$OnSystemUiVisibilityChangeListenerC0373b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f681a;

        View$OnSystemUiVisibilityChangeListenerC0373b(View view) {
            C0371d.this = r1;
            this.f681a = view;
        }

        /* renamed from: a */
        public static /* synthetic */ void m1398a(View$OnSystemUiVisibilityChangeListenerC0373b view$OnSystemUiVisibilityChangeListenerC0373b, int i) {
            view$OnSystemUiVisibilityChangeListenerC0373b.m1397b(i);
        }

        /* renamed from: b */
        public /* synthetic */ void m1397b(int i) {
            C0862j c0862j;
            boolean z;
            if ((i & 4) == 0) {
                c0862j = C0371d.this.f675b;
                z = true;
            } else {
                c0862j = C0371d.this.f675b;
                z = false;
            }
            c0862j.m123m(z);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(final int i) {
            this.f681a.post(new Runnable() { // from class: io.flutter.plugin.platform.e
                @Override // java.lang.Runnable
                public final void run() {
                    C0371d.View$OnSystemUiVisibilityChangeListenerC0373b.m1398a(C0371d.View$OnSystemUiVisibilityChangeListenerC0373b.this, i);
                }
            });
        }
    }

    /* renamed from: io.flutter.plugin.platform.d$c */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0374c {

        /* renamed from: a */
        static final /* synthetic */ int[] f683a;

        /* renamed from: b */
        static final /* synthetic */ int[] f684b;

        /* renamed from: c */
        static final /* synthetic */ int[] f685c;

        static {
            int[] iArr = new int[C0862j.EnumC0866d.values().length];
            f685c = iArr;
            try {
                iArr[C0862j.EnumC0866d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f685c[C0862j.EnumC0866d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[C0862j.EnumC0874l.values().length];
            f684b = iArr2;
            try {
                iArr2[C0862j.EnumC0874l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f684b[C0862j.EnumC0874l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[C0862j.EnumC0869g.values().length];
            f683a = iArr3;
            try {
                iArr3[C0862j.EnumC0869g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f683a[C0862j.EnumC0869g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f683a[C0862j.EnumC0869g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f683a[C0862j.EnumC0869g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f683a[C0862j.EnumC0869g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* renamed from: io.flutter.plugin.platform.d$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0375d {
        /* renamed from: c */
        boolean mo1396c();

        /* renamed from: e */
        void mo1395e(boolean z);
    }

    public C0371d(Activity activity, C0862j c0862j, InterfaceC0375d interfaceC0375d) {
        C0372a c0372a = new C0372a();
        this.f679f = c0372a;
        this.f674a = activity;
        this.f675b = c0862j;
        c0862j.m124l(c0372a);
        this.f676c = interfaceC0375d;
        this.f678e = 1280;
    }

    /* renamed from: A */
    public void m1428A(int i) {
        this.f674a.setRequestedOrientation(i);
    }

    @TargetApi(21)
    /* renamed from: B */
    public void m1427B(C0862j.C0872j c0872j) {
        Window window = this.f674a.getWindow();
        C0229e c0229e = new C0229e(window, window.getDecorView());
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        if (i >= 23) {
            C0862j.EnumC0866d enumC0866d = c0872j.f1528b;
            if (enumC0866d != null) {
                int i2 = C0374c.f685c[enumC0866d.ordinal()];
                if (i2 == 1) {
                    c0229e.m1841b(true);
                } else if (i2 == 2) {
                    c0229e.m1841b(false);
                }
            }
            Integer num = c0872j.f1527a;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        Boolean bool = c0872j.f1529c;
        if (bool != null && i >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i >= 26) {
            C0862j.EnumC0866d enumC0866d2 = c0872j.f1531e;
            if (enumC0866d2 != null) {
                int i3 = C0374c.f685c[enumC0866d2.ordinal()];
                if (i3 == 1) {
                    c0229e.m1842a(true);
                } else if (i3 == 2) {
                    c0229e.m1842a(false);
                }
            }
            Integer num2 = c0872j.f1530d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = c0872j.f1532f;
        if (num3 != null && i >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = c0872j.f1533g;
        if (bool2 != null && i >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f677d = c0872j;
    }

    /* renamed from: o */
    public boolean m1410o() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f674a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* renamed from: q */
    public CharSequence m1408q(C0862j.EnumC0867e enumC0867e) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f674a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip()) {
            try {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip == null) {
                    return null;
                }
                if (enumC0867e != null && enumC0867e != C0862j.EnumC0867e.PLAIN_TEXT) {
                    return null;
                }
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                if (itemAt.getUri() != null) {
                    this.f674a.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
                }
                return itemAt.coerceToText(this.f674a);
            } catch (FileNotFoundException unused) {
                return null;
            } catch (SecurityException e) {
                C0576b.m735h("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e);
                return null;
            }
        }
        return null;
    }

    /* renamed from: r */
    public void m1407r(C0862j.EnumC0871i enumC0871i) {
        if (enumC0871i == C0862j.EnumC0871i.CLICK) {
            this.f674a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* renamed from: s */
    public void m1406s() {
        InterfaceC0375d interfaceC0375d = this.f676c;
        if (interfaceC0375d == null || !interfaceC0375d.mo1396c()) {
            Activity activity = this.f674a;
            if (activity instanceof InterfaceC0059b) {
                ((InterfaceC0059b) activity).m2229k();
                throw null;
            } else {
                activity.finish();
            }
        }
    }

    /* renamed from: t */
    public void m1405t() {
        m1426C();
    }

    /* renamed from: u */
    public void m1404u(String str) {
        ((ClipboardManager) this.f674a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* renamed from: v */
    public void m1403v(boolean z) {
        this.f676c.mo1395e(z);
    }

    /* renamed from: w */
    public void m1402w(C0862j.C0865c c0865c) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return;
        }
        if (i < 28 && i > 21) {
            this.f674a.setTaskDescription(new ActivityManager.TaskDescription(c0865c.f1502b, (Bitmap) null, c0865c.f1501a));
        }
        if (i >= 28) {
            this.f674a.setTaskDescription(new ActivityManager.TaskDescription(c0865c.f1502b, 0, c0865c.f1501a));
        }
    }

    /* renamed from: x */
    public void m1401x() {
        View decorView = this.f674a.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View$OnSystemUiVisibilityChangeListenerC0373b(decorView));
    }

    /* renamed from: y */
    public void m1400y(C0862j.EnumC0873k enumC0873k) {
        int i;
        if (enumC0873k == C0862j.EnumC0873k.LEAN_BACK) {
            i = 1798;
        } else if (enumC0873k == C0862j.EnumC0873k.IMMERSIVE && Build.VERSION.SDK_INT >= 19) {
            i = 3846;
        } else if (enumC0873k == C0862j.EnumC0873k.IMMERSIVE_STICKY && Build.VERSION.SDK_INT >= 19) {
            i = 5894;
        } else if (enumC0873k != C0862j.EnumC0873k.EDGE_TO_EDGE || Build.VERSION.SDK_INT < 29) {
            return;
        } else {
            i = 1792;
        }
        this.f678e = i;
        m1426C();
    }

    /* renamed from: z */
    public void m1399z(List<C0862j.EnumC0874l> list) {
        int i = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = C0374c.f684b[list.get(i2).ordinal()];
            if (i3 == 1) {
                i &= -5;
            } else if (i3 == 2) {
                i = i & (-513) & (-3);
            }
        }
        this.f678e = i;
        m1426C();
    }

    /* renamed from: C */
    public void m1426C() {
        this.f674a.getWindow().getDecorView().setSystemUiVisibility(this.f678e);
        C0862j.C0872j c0872j = this.f677d;
        if (c0872j != null) {
            m1427B(c0872j);
        }
    }

    /* renamed from: D */
    void m1425D(C0862j.EnumC0869g enumC0869g) {
        int i;
        View decorView = this.f674a.getWindow().getDecorView();
        int i2 = C0374c.f683a[enumC0869g.ordinal()];
        int i3 = 1;
        if (i2 != 1) {
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    i3 = 4;
                    if (i2 != 4) {
                        if (i2 != 5 || Build.VERSION.SDK_INT < 21) {
                            return;
                        }
                    } else if (Build.VERSION.SDK_INT < 23) {
                        return;
                    } else {
                        i = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i3);
            return;
        }
        i = 0;
        decorView.performHapticFeedback(i);
    }

    /* renamed from: p */
    public void m1409p() {
        this.f675b.m124l(null);
    }
}