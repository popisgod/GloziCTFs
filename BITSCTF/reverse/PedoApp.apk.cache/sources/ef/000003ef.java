package p053z;

import androidx.window.C0082R;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p001a0.C0032j;
import p001a0.C0033k;
import p001a0.C0047s;
import p031o.C0576b;
import p033p.C0579a;
import p053z.C0876l;

/* renamed from: z.l */
/* loaded from: classes.dex */
public class C0876l {

    /* renamed from: a */
    private final C0033k f1545a;

    /* renamed from: b */
    private InterfaceC0884g f1546b;

    /* renamed from: c */
    private final C0033k.InterfaceC0037c f1547c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z.l$a */
    /* loaded from: classes.dex */
    public class C0877a implements C0033k.InterfaceC0037c {
        C0877a() {
            C0876l.this = r1;
        }

        /* renamed from: b */
        public static /* synthetic */ void m96b(C0033k.InterfaceC0038d interfaceC0038d, C0879c c0879c) {
            m92f(interfaceC0038d, c0879c);
        }

        /* renamed from: c */
        private void m95c(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            try {
                C0876l.this.f1546b.mo85a(((Integer) c0032j.m2274a()).intValue());
                interfaceC0038d.mo65b(null);
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", C0876l.m99c(e), null);
            }
        }

        /* renamed from: d */
        private void m94d(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            Map map = (Map) c0032j.m2274a();
            boolean z = true;
            boolean z2 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z2) {
                    C0876l.this.f1546b.mo81e(new C0880d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), C0880d.EnumC0881a.HYBRID_ONLY, wrap));
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z = false;
                    }
                    long mo77i = C0876l.this.f1546b.mo77i(new C0880d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z ? C0880d.EnumC0881a.TEXTURE_WITH_HYBRID_FALLBACK : C0880d.EnumC0881a.TEXTURE_WITH_VIRTUAL_FALLBACK, wrap));
                    if (mo77i != -2) {
                        interfaceC0038d.mo65b(Long.valueOf(mo77i));
                        return;
                    } else if (!z) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
                interfaceC0038d.mo65b(null);
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", C0876l.m99c(e), null);
            }
        }

        /* renamed from: e */
        private void m93e(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            try {
                C0876l.this.f1546b.mo83c(((Integer) ((Map) c0032j.m2274a()).get("id")).intValue());
                interfaceC0038d.mo65b(null);
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", C0876l.m99c(e), null);
            }
        }

        /* renamed from: f */
        public static /* synthetic */ void m92f(C0033k.InterfaceC0038d interfaceC0038d, C0879c c0879c) {
            if (c0879c == null) {
                interfaceC0038d.mo66a("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(c0879c.f1549a));
            hashMap.put("height", Double.valueOf(c0879c.f1550b));
            interfaceC0038d.mo65b(hashMap);
        }

        /* renamed from: g */
        private void m91g(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            Map map = (Map) c0032j.m2274a();
            try {
                C0876l.this.f1546b.mo79g(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                interfaceC0038d.mo65b(null);
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", C0876l.m99c(e), null);
            }
        }

        /* renamed from: h */
        private void m90h(C0032j c0032j, final C0033k.InterfaceC0038d interfaceC0038d) {
            Map map = (Map) c0032j.m2274a();
            try {
                C0876l.this.f1546b.mo84b(new C0882e(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new InterfaceC0878b() { // from class: z.k
                    @Override // p053z.C0876l.InterfaceC0878b
                    /* renamed from: a */
                    public final void mo86a(C0876l.C0879c c0879c) {
                        C0876l.C0877a.m96b(C0033k.InterfaceC0038d.this, c0879c);
                    }
                });
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", C0876l.m99c(e), null);
            }
        }

        /* renamed from: i */
        private void m89i(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            Map map = (Map) c0032j.m2274a();
            try {
                C0876l.this.f1546b.mo78h(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                interfaceC0038d.mo65b(null);
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", C0876l.m99c(e), null);
            }
        }

        /* renamed from: j */
        private void m88j(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            try {
                C0876l.this.f1546b.mo82d(((Boolean) c0032j.m2274a()).booleanValue());
                interfaceC0038d.mo65b(null);
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", C0876l.m99c(e), null);
            }
        }

        /* renamed from: k */
        private void m87k(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            C0033k.InterfaceC0038d interfaceC0038d2;
            List list = (List) c0032j.m2274a();
            try {
                C0876l.this.f1546b.mo80f(new C0883f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                interfaceC0038d2 = interfaceC0038d;
                try {
                    interfaceC0038d2.mo65b(null);
                } catch (IllegalStateException e) {
                    e = e;
                    interfaceC0038d2.mo66a("error", C0876l.m99c(e), null);
                }
            } catch (IllegalStateException e2) {
                e = e2;
                interfaceC0038d2 = interfaceC0038d;
            }
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            if (C0876l.this.f1546b == null) {
                return;
            }
            C0576b.m737f("PlatformViewsChannel", "Received '" + c0032j.f38a + "' message.");
            String str = c0032j.f38a;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1019779949:
                    if (str.equals("offset")) {
                        c = 1;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c = 2;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c = 3;
                        break;
                    }
                    break;
                case -308988850:
                    if (str.equals("synchronizeToNativeViewHierarchy")) {
                        c = 4;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c = 5;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m94d(c0032j, interfaceC0038d);
                    return;
                case 1:
                    m91g(c0032j, interfaceC0038d);
                    return;
                case 2:
                    m90h(c0032j, interfaceC0038d);
                    return;
                case 3:
                    m95c(c0032j, interfaceC0038d);
                    return;
                case 4:
                    m88j(c0032j, interfaceC0038d);
                    return;
                case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                    m87k(c0032j, interfaceC0038d);
                    return;
                case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                    m89i(c0032j, interfaceC0038d);
                    return;
                case 7:
                    m93e(c0032j, interfaceC0038d);
                    return;
                default:
                    interfaceC0038d.mo64c();
                    return;
            }
        }
    }

    /* renamed from: z.l$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0878b {
        /* renamed from: a */
        void mo86a(C0879c c0879c);
    }

    /* renamed from: z.l$c */
    /* loaded from: classes.dex */
    public static class C0879c {

        /* renamed from: a */
        public final int f1549a;

        /* renamed from: b */
        public final int f1550b;

        public C0879c(int i, int i2) {
            this.f1549a = i;
            this.f1550b = i2;
        }
    }

    /* renamed from: z.l$d */
    /* loaded from: classes.dex */
    public static class C0880d {

        /* renamed from: a */
        public final int f1551a;

        /* renamed from: b */
        public final String f1552b;

        /* renamed from: c */
        public final double f1553c;

        /* renamed from: d */
        public final double f1554d;

        /* renamed from: e */
        public final double f1555e;

        /* renamed from: f */
        public final double f1556f;

        /* renamed from: g */
        public final int f1557g;

        /* renamed from: h */
        public final EnumC0881a f1558h;

        /* renamed from: i */
        public final ByteBuffer f1559i;

        /* renamed from: z.l$d$a */
        /* loaded from: classes.dex */
        public enum EnumC0881a {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public C0880d(int i, String str, double d, double d2, double d3, double d4, int i2, EnumC0881a enumC0881a, ByteBuffer byteBuffer) {
            this.f1551a = i;
            this.f1552b = str;
            this.f1555e = d;
            this.f1556f = d2;
            this.f1553c = d3;
            this.f1554d = d4;
            this.f1557g = i2;
            this.f1558h = enumC0881a;
            this.f1559i = byteBuffer;
        }
    }

    /* renamed from: z.l$e */
    /* loaded from: classes.dex */
    public static class C0882e {

        /* renamed from: a */
        public final int f1564a;

        /* renamed from: b */
        public final double f1565b;

        /* renamed from: c */
        public final double f1566c;

        public C0882e(int i, double d, double d2) {
            this.f1564a = i;
            this.f1565b = d;
            this.f1566c = d2;
        }
    }

    /* renamed from: z.l$f */
    /* loaded from: classes.dex */
    public static class C0883f {

        /* renamed from: a */
        public final int f1567a;

        /* renamed from: b */
        public final Number f1568b;

        /* renamed from: c */
        public final Number f1569c;

        /* renamed from: d */
        public final int f1570d;

        /* renamed from: e */
        public final int f1571e;

        /* renamed from: f */
        public final Object f1572f;

        /* renamed from: g */
        public final Object f1573g;

        /* renamed from: h */
        public final int f1574h;

        /* renamed from: i */
        public final int f1575i;

        /* renamed from: j */
        public final float f1576j;

        /* renamed from: k */
        public final float f1577k;

        /* renamed from: l */
        public final int f1578l;

        /* renamed from: m */
        public final int f1579m;

        /* renamed from: n */
        public final int f1580n;

        /* renamed from: o */
        public final int f1581o;

        /* renamed from: p */
        public final long f1582p;

        public C0883f(int i, Number number, Number number2, int i2, int i3, Object obj, Object obj2, int i4, int i5, float f, float f2, int i6, int i7, int i8, int i9, long j) {
            this.f1567a = i;
            this.f1568b = number;
            this.f1569c = number2;
            this.f1570d = i2;
            this.f1571e = i3;
            this.f1572f = obj;
            this.f1573g = obj2;
            this.f1574h = i4;
            this.f1575i = i5;
            this.f1576j = f;
            this.f1577k = f2;
            this.f1578l = i6;
            this.f1579m = i7;
            this.f1580n = i8;
            this.f1581o = i9;
            this.f1582p = j;
        }
    }

    /* renamed from: z.l$g */
    /* loaded from: classes.dex */
    public interface InterfaceC0884g {
        /* renamed from: a */
        void mo85a(int i);

        /* renamed from: b */
        void mo84b(C0882e c0882e, InterfaceC0878b interfaceC0878b);

        /* renamed from: c */
        void mo83c(int i);

        /* renamed from: d */
        void mo82d(boolean z);

        /* renamed from: e */
        void mo81e(C0880d c0880d);

        /* renamed from: f */
        void mo80f(C0883f c0883f);

        /* renamed from: g */
        void mo79g(int i, double d, double d2);

        /* renamed from: h */
        void mo78h(int i, int i2);

        /* renamed from: i */
        long mo77i(C0880d c0880d);
    }

    public C0876l(C0579a c0579a) {
        C0877a c0877a = new C0877a();
        this.f1547c = c0877a;
        C0033k c0033k = new C0033k(c0579a, "flutter/platform_views", C0047s.f53b);
        this.f1545a = c0033k;
        c0033k.m2269e(c0877a);
    }

    /* renamed from: c */
    public static String m99c(Exception exc) {
        return C0576b.m739d(exc);
    }

    /* renamed from: d */
    public void m98d(int i) {
        C0033k c0033k = this.f1545a;
        if (c0033k == null) {
            return;
        }
        c0033k.m2271c("viewFocused", Integer.valueOf(i));
    }

    /* renamed from: e */
    public void m97e(InterfaceC0884g interfaceC0884g) {
        this.f1546b = interfaceC0884g;
    }
}