package p053z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p001a0.C0029g;
import p001a0.C0033k;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.j */
/* loaded from: classes.dex */
public class C0862j {

    /* renamed from: a */
    public final C0033k f1494a;

    /* renamed from: b */
    private InterfaceC0870h f1495b;

    /* renamed from: c */
    final C0033k.InterfaceC0037c f1496c;

    /* renamed from: z.j$a */
    /* loaded from: classes.dex */
    class C0863a implements C0033k.InterfaceC0037c {
        C0863a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x012b A[Catch: JSONException -> 0x0234, TryCatch #9 {JSONException -> 0x0234, blocks: (B:6:0x002c, B:7:0x0030, B:53:0x00cf, B:54:0x00d4, B:55:0x00ed, B:56:0x00fc, B:57:0x0101, B:59:0x0105, B:63:0x011f, B:65:0x012b, B:61:0x010a, B:66:0x0138, B:67:0x0142, B:76:0x0174, B:77:0x017f, B:105:0x0200, B:110:0x021a, B:74:0x016b, B:75:0x016f, B:84:0x01a3, B:91:0x01c1, B:96:0x01dd, B:103:0x01fa, B:108:0x0214, B:113:0x022e, B:9:0x0035, B:12:0x0040, B:15:0x004b, B:18:0x0057, B:21:0x0063, B:24:0x006d, B:27:0x0078, B:30:0x0082, B:33:0x008c, B:36:0x0096, B:39:0x00a0, B:42:0x00aa, B:45:0x00b5, B:48:0x00c0, B:93:0x01c6), top: B:124:0x002c, inners: #0, #3, #6, #12 }] */
        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo24a(p001a0.C0032j r6, p001a0.C0033k.InterfaceC0038d r7) {
            /*
                Method dump skipped, instructions count: 680
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p053z.C0862j.C0863a.mo24a(a0.j, a0.k$d):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z.j$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0864b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1498a;

        /* renamed from: b */
        static final /* synthetic */ int[] f1499b;

        /* renamed from: c */
        static final /* synthetic */ int[] f1500c;

        static {
            int[] iArr = new int[EnumC0873k.values().length];
            f1500c = iArr;
            try {
                iArr[EnumC0873k.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1500c[EnumC0873k.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1500c[EnumC0873k.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1500c[EnumC0873k.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EnumC0874l.values().length];
            f1499b = iArr2;
            try {
                iArr2[EnumC0874l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1499b[EnumC0874l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[EnumC0868f.values().length];
            f1498a = iArr3;
            try {
                iArr3[EnumC0868f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1498a[EnumC0868f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1498a[EnumC0868f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1498a[EnumC0868f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: z.j$c */
    /* loaded from: classes.dex */
    public static class C0865c {

        /* renamed from: a */
        public final int f1501a;

        /* renamed from: b */
        public final String f1502b;

        public C0865c(int i, String str) {
            this.f1501a = i;
            this.f1502b = str;
        }
    }

    /* renamed from: z.j$d */
    /* loaded from: classes.dex */
    public enum EnumC0866d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        

        /* renamed from: d */
        private String f1506d;

        EnumC0866d(String str) {
            this.f1506d = str;
        }

        /* renamed from: a */
        static EnumC0866d m122a(String str) {
            EnumC0866d[] values;
            for (EnumC0866d enumC0866d : values()) {
                if (enumC0866d.f1506d.equals(str)) {
                    return enumC0866d;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    /* renamed from: z.j$e */
    /* loaded from: classes.dex */
    public enum EnumC0867e {
        PLAIN_TEXT("text/plain");
        

        /* renamed from: d */
        private String f1509d;

        EnumC0867e(String str) {
            this.f1509d = str;
        }

        /* renamed from: a */
        static EnumC0867e m121a(String str) {
            EnumC0867e[] values;
            for (EnumC0867e enumC0867e : values()) {
                if (enumC0867e.f1509d.equals(str)) {
                    return enumC0867e;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    /* renamed from: z.j$f */
    /* loaded from: classes.dex */
    public enum EnumC0868f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        

        /* renamed from: d */
        private String f1515d;

        EnumC0868f(String str) {
            this.f1515d = str;
        }

        /* renamed from: a */
        static EnumC0868f m120a(String str) {
            EnumC0868f[] values;
            for (EnumC0868f enumC0868f : values()) {
                if (enumC0868f.f1515d.equals(str)) {
                    return enumC0868f;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    /* renamed from: z.j$g */
    /* loaded from: classes.dex */
    public enum EnumC0869g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        

        /* renamed from: d */
        private final String f1522d;

        EnumC0869g(String str) {
            this.f1522d = str;
        }

        /* renamed from: a */
        static EnumC0869g m119a(String str) {
            EnumC0869g[] values;
            for (EnumC0869g enumC0869g : values()) {
                String str2 = enumC0869g.f1522d;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return enumC0869g;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    /* renamed from: z.j$h */
    /* loaded from: classes.dex */
    public interface InterfaceC0870h {
        /* renamed from: a */
        void mo118a(EnumC0873k enumC0873k);

        /* renamed from: b */
        void mo117b();

        /* renamed from: c */
        void mo116c();

        /* renamed from: d */
        CharSequence mo115d(EnumC0867e enumC0867e);

        /* renamed from: e */
        void mo114e(boolean z);

        /* renamed from: f */
        void mo113f(int i);

        /* renamed from: g */
        void mo112g(C0872j c0872j);

        /* renamed from: h */
        void mo111h(List<EnumC0874l> list);

        /* renamed from: i */
        void mo110i(EnumC0871i enumC0871i);

        /* renamed from: j */
        void mo109j();

        /* renamed from: k */
        void mo108k(String str);

        /* renamed from: l */
        void mo107l(C0865c c0865c);

        /* renamed from: m */
        boolean mo106m();

        /* renamed from: n */
        void mo105n(EnumC0869g enumC0869g);
    }

    /* renamed from: z.j$i */
    /* loaded from: classes.dex */
    public enum EnumC0871i {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");
        

        /* renamed from: d */
        private final String f1526d;

        EnumC0871i(String str) {
            this.f1526d = str;
        }

        /* renamed from: a */
        static EnumC0871i m104a(String str) {
            EnumC0871i[] values;
            for (EnumC0871i enumC0871i : values()) {
                if (enumC0871i.f1526d.equals(str)) {
                    return enumC0871i;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    /* renamed from: z.j$j */
    /* loaded from: classes.dex */
    public static class C0872j {

        /* renamed from: a */
        public final Integer f1527a;

        /* renamed from: b */
        public final EnumC0866d f1528b;

        /* renamed from: c */
        public final Boolean f1529c;

        /* renamed from: d */
        public final Integer f1530d;

        /* renamed from: e */
        public final EnumC0866d f1531e;

        /* renamed from: f */
        public final Integer f1532f;

        /* renamed from: g */
        public final Boolean f1533g;

        public C0872j(Integer num, EnumC0866d enumC0866d, Boolean bool, Integer num2, EnumC0866d enumC0866d2, Integer num3, Boolean bool2) {
            this.f1527a = num;
            this.f1528b = enumC0866d;
            this.f1529c = bool;
            this.f1530d = num2;
            this.f1531e = enumC0866d2;
            this.f1532f = num3;
            this.f1533g = bool2;
        }
    }

    /* renamed from: z.j$k */
    /* loaded from: classes.dex */
    public enum EnumC0873k {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");
        

        /* renamed from: d */
        private String f1539d;

        EnumC0873k(String str) {
            this.f1539d = str;
        }

        /* renamed from: a */
        static EnumC0873k m103a(String str) {
            EnumC0873k[] values;
            for (EnumC0873k enumC0873k : values()) {
                if (enumC0873k.f1539d.equals(str)) {
                    return enumC0873k;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    /* renamed from: z.j$l */
    /* loaded from: classes.dex */
    public enum EnumC0874l {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        

        /* renamed from: d */
        private String f1543d;

        EnumC0874l(String str) {
            this.f1543d = str;
        }

        /* renamed from: a */
        static EnumC0874l m102a(String str) {
            EnumC0874l[] values;
            for (EnumC0874l enumC0874l : values()) {
                if (enumC0874l.f1543d.equals(str)) {
                    return enumC0874l;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public C0862j(C0579a c0579a) {
        C0863a c0863a = new C0863a();
        this.f1496c = c0863a;
        C0033k c0033k = new C0033k(c0579a, "flutter/platform", C0029g.f37a);
        this.f1494a = c0033k;
        c0033k.m2269e(c0863a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public C0865c m129g(JSONObject jSONObject) {
        int i = jSONObject.getInt("primaryColor");
        if (i != 0) {
            i |= -16777216;
        }
        return new C0865c(i, jSONObject.getString("label"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0053 A[RETURN] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m128h(org.json.JSONArray r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L38
            java.lang.String r4 = r10.getString(r1)
            z.j$f r4 = p053z.C0862j.EnumC0868f.m120a(r4)
            int[] r8 = p053z.C0862j.C0864b.f1498a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L30
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L2a
            if (r4 == r5) goto L27
            goto L32
        L27:
            r2 = r2 | 8
            goto L32
        L2a:
            r2 = r2 | 2
            goto L32
        L2d:
            r2 = r2 | 4
            goto L32
        L30:
            r2 = r2 | 1
        L32:
            if (r3 != 0) goto L35
            r3 = r2
        L35:
            int r1 = r1 + 1
            goto L4
        L38:
            if (r2 == 0) goto L57
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L56;
                case 3: goto L4d;
                case 4: goto L4c;
                case 5: goto L4a;
                case 6: goto L4d;
                case 7: goto L4d;
                case 8: goto L49;
                case 9: goto L4d;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L4d;
                case 15: goto L42;
                default: goto L41;
            }
        L41:
            goto L53
        L42:
            r10 = 13
            return r10
        L45:
            return r6
        L46:
            r10 = 11
            return r10
        L49:
            return r1
        L4a:
            r10 = 12
        L4c:
            return r10
        L4d:
            if (r3 == r6) goto L56
            if (r3 == r5) goto L55
            if (r3 == r1) goto L54
        L53:
            return r7
        L54:
            return r1
        L55:
            return r10
        L56:
            return r0
        L57:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p053z.C0862j.m128h(org.json.JSONArray):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0872j m127i(JSONObject jSONObject) {
        return new C0872j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? EnumC0866d.m122a(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? EnumC0866d.m122a(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public EnumC0873k m126j(String str) {
        int i = C0864b.f1500c[EnumC0873k.m103a(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? EnumC0873k.EDGE_TO_EDGE : EnumC0873k.EDGE_TO_EDGE : EnumC0873k.IMMERSIVE_STICKY : EnumC0873k.IMMERSIVE : EnumC0873k.LEAN_BACK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public List<EnumC0874l> m125k(JSONArray jSONArray) {
        EnumC0874l enumC0874l;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = C0864b.f1499b[EnumC0874l.m102a(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                enumC0874l = EnumC0874l.TOP_OVERLAYS;
            } else if (i2 == 2) {
                enumC0874l = EnumC0874l.BOTTOM_OVERLAYS;
            }
            arrayList.add(enumC0874l);
        }
        return arrayList;
    }

    /* renamed from: l */
    public void m124l(InterfaceC0870h interfaceC0870h) {
        this.f1495b = interfaceC0870h;
    }

    /* renamed from: m */
    public void m123m(boolean z) {
        C0576b.m737f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.f1494a.m2271c("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z)));
    }
}