package p053z;

import java.util.Locale;
import p001a0.C0008a;
import p001a0.C0048t;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.f */
/* loaded from: classes.dex */
public class C0851f {

    /* renamed from: a */
    private EnumC0853b f1472a;

    /* renamed from: b */
    private EnumC0853b f1473b;

    /* renamed from: c */
    private boolean f1474c;

    /* renamed from: d */
    private final C0008a<String> f1475d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z.f$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0852a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1476a;

        static {
            int[] iArr = new int[EnumC0853b.values().length];
            f1476a = iArr;
            try {
                iArr[EnumC0853b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1476a[EnumC0853b.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1476a[EnumC0853b.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1476a[EnumC0853b.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1476a[EnumC0853b.DETACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z.f$b */
    /* loaded from: classes.dex */
    public enum EnumC0853b {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public C0851f(C0008a<String> c0008a) {
        this.f1472a = null;
        this.f1473b = null;
        this.f1474c = true;
        this.f1475d = c0008a;
    }

    public C0851f(C0579a c0579a) {
        this(new C0008a(c0579a, "flutter/lifecycle", C0048t.f56b));
    }

    /* renamed from: g */
    private void m146g(EnumC0853b enumC0853b, boolean z) {
        EnumC0853b enumC0853b2 = this.f1472a;
        if (enumC0853b2 == enumC0853b && z == this.f1474c) {
            return;
        }
        if (enumC0853b == null && enumC0853b2 == null) {
            this.f1474c = z;
            return;
        }
        EnumC0853b enumC0853b3 = null;
        int i = C0852a.f1476a[enumC0853b.ordinal()];
        if (i == 1) {
            enumC0853b3 = z ? EnumC0853b.RESUMED : EnumC0853b.INACTIVE;
        } else if (i == 2 || i == 3 || i == 4 || i == 5) {
            enumC0853b3 = enumC0853b;
        }
        this.f1472a = enumC0853b;
        this.f1474c = z;
        if (enumC0853b3 == this.f1473b) {
            return;
        }
        String str = "AppLifecycleState." + enumC0853b3.name().toLowerCase(Locale.ROOT);
        C0576b.m737f("LifecycleChannel", "Sending " + str + " message.");
        this.f1475d.m2290c(str);
        this.f1473b = enumC0853b3;
    }

    /* renamed from: a */
    public void m152a() {
        m146g(this.f1472a, true);
    }

    /* renamed from: b */
    public void m151b() {
        m146g(EnumC0853b.DETACHED, this.f1474c);
    }

    /* renamed from: c */
    public void m150c() {
        m146g(EnumC0853b.INACTIVE, this.f1474c);
    }

    /* renamed from: d */
    public void m149d() {
        m146g(EnumC0853b.PAUSED, this.f1474c);
    }

    /* renamed from: e */
    public void m148e() {
        m146g(EnumC0853b.RESUMED, this.f1474c);
    }

    /* renamed from: f */
    public void m147f() {
        m146g(this.f1472a, false);
    }
}