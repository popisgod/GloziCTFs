package p053z;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import p001a0.C0008a;
import p001a0.C0028f;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.n */
/* loaded from: classes.dex */
public class C0888n {

    /* renamed from: b */
    private static final C0889a f1593b = new C0889a();

    /* renamed from: a */
    public final C0008a<Object> f1594a;

    /* renamed from: z.n$a */
    /* loaded from: classes.dex */
    public static class C0889a {

        /* renamed from: a */
        private final ConcurrentLinkedQueue<C0891b> f1595a = new ConcurrentLinkedQueue<>();

        /* renamed from: b */
        private C0891b f1596b;

        /* renamed from: c */
        private C0891b f1597c;

        /* renamed from: z.n$a$a */
        /* loaded from: classes.dex */
        public class C0890a implements C0008a.InterfaceC0014e {

            /* renamed from: a */
            final /* synthetic */ C0891b f1598a;

            C0890a(C0891b c0891b) {
                C0889a.this = r1;
                this.f1598a = c0891b;
            }

            @Override // p001a0.C0008a.InterfaceC0014e
            /* renamed from: a */
            public void mo56a(Object obj) {
                C0889a.this.f1595a.remove(this.f1598a);
                if (C0889a.this.f1595a.isEmpty()) {
                    return;
                }
                C0576b.m741b("SettingsChannel", "The queue becomes empty after removing config generation " + String.valueOf(this.f1598a.f1601a));
            }
        }

        /* renamed from: z.n$a$b */
        /* loaded from: classes.dex */
        public static class C0891b {

            /* renamed from: c */
            private static int f1600c = Integer.MIN_VALUE;

            /* renamed from: a */
            public final int f1601a;

            /* renamed from: b */
            private final DisplayMetrics f1602b;

            public C0891b(DisplayMetrics displayMetrics) {
                int i = f1600c;
                f1600c = i + 1;
                this.f1601a = i;
                this.f1602b = displayMetrics;
            }
        }

        /* renamed from: b */
        public C0008a.InterfaceC0014e m58b(C0891b c0891b) {
            this.f1595a.add(c0891b);
            C0891b c0891b2 = this.f1597c;
            this.f1597c = c0891b;
            if (c0891b2 == null) {
                return null;
            }
            return new C0890a(c0891b2);
        }

        /* renamed from: c */
        public C0891b m57c(int i) {
            C0891b c0891b;
            StringBuilder sb;
            String valueOf;
            if (this.f1596b == null) {
                this.f1596b = this.f1595a.poll();
            }
            while (true) {
                c0891b = this.f1596b;
                if (c0891b == null || c0891b.f1601a >= i) {
                    break;
                }
                this.f1596b = this.f1595a.poll();
            }
            if (c0891b == null) {
                sb = new StringBuilder();
                sb.append("Cannot find config with generation: ");
                sb.append(String.valueOf(i));
                valueOf = ", after exhausting the queue.";
            } else if (c0891b.f1601a == i) {
                return c0891b;
            } else {
                sb = new StringBuilder();
                sb.append("Cannot find config with generation: ");
                sb.append(String.valueOf(i));
                sb.append(", the oldest config is now: ");
                valueOf = String.valueOf(this.f1596b.f1601a);
            }
            sb.append(valueOf);
            C0576b.m741b("SettingsChannel", sb.toString());
            return null;
        }
    }

    /* renamed from: z.n$b */
    /* loaded from: classes.dex */
    public static class C0892b {

        /* renamed from: a */
        private final C0008a<Object> f1603a;

        /* renamed from: b */
        private Map<String, Object> f1604b = new HashMap();

        /* renamed from: c */
        private DisplayMetrics f1605c;

        C0892b(C0008a<Object> c0008a) {
            this.f1603a = c0008a;
        }

        /* renamed from: a */
        public void m54a() {
            C0576b.m737f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f1604b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f1604b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f1604b.get("platformBrightness"));
            DisplayMetrics displayMetrics = this.f1605c;
            if (!C0888n.m61c() || displayMetrics == null) {
                this.f1603a.m2290c(this.f1604b);
                return;
            }
            C0889a.C0891b c0891b = new C0889a.C0891b(displayMetrics);
            C0008a.InterfaceC0014e<Object> m58b = C0888n.f1593b.m58b(c0891b);
            this.f1604b.put("configurationId", Integer.valueOf(c0891b.f1601a));
            this.f1603a.m2289d(this.f1604b, m58b);
        }

        /* renamed from: b */
        public C0892b m53b(boolean z) {
            this.f1604b.put("brieflyShowPassword", Boolean.valueOf(z));
            return this;
        }

        /* renamed from: c */
        public C0892b m52c(DisplayMetrics displayMetrics) {
            this.f1605c = displayMetrics;
            return this;
        }

        /* renamed from: d */
        public C0892b m51d(boolean z) {
            this.f1604b.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z));
            return this;
        }

        /* renamed from: e */
        public C0892b m50e(EnumC0893c enumC0893c) {
            this.f1604b.put("platformBrightness", enumC0893c.f1609d);
            return this;
        }

        /* renamed from: f */
        public C0892b m49f(float f) {
            this.f1604b.put("textScaleFactor", Float.valueOf(f));
            return this;
        }

        /* renamed from: g */
        public C0892b m48g(boolean z) {
            this.f1604b.put("alwaysUse24HourFormat", Boolean.valueOf(z));
            return this;
        }
    }

    /* renamed from: z.n$c */
    /* loaded from: classes.dex */
    public enum EnumC0893c {
        light("light"),
        dark("dark");
        

        /* renamed from: d */
        public String f1609d;

        EnumC0893c(String str) {
            this.f1609d = str;
        }
    }

    public C0888n(C0579a c0579a) {
        this.f1594a = new C0008a<>(c0579a, "flutter/settings", C0028f.f36a);
    }

    /* renamed from: b */
    public static DisplayMetrics m62b(int i) {
        C0889a.C0891b m57c = f1593b.m57c(i);
        if (m57c == null) {
            return null;
        }
        return m57c.f1602b;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    /* renamed from: c */
    public static boolean m61c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    /* renamed from: d */
    public C0892b m60d() {
        return new C0892b(this.f1594a);
    }
}