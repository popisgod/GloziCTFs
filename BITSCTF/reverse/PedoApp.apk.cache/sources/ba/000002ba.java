package p029n;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.Objects;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p001a0.C0021d;
import p001a0.C0032j;
import p001a0.C0033k;
import p001a0.InterfaceC0016c;
import p041t.InterfaceC0648a;

/* renamed from: n.b */
/* loaded from: classes.dex */
public final class C0567b implements InterfaceC0648a {

    /* renamed from: j */
    public static final C0568a f1150j = new C0568a(null);

    /* renamed from: a */
    private C0033k f1151a;

    /* renamed from: b */
    private C0021d f1152b;

    /* renamed from: c */
    private C0021d f1153c;

    /* renamed from: d */
    private C0021d f1154d;

    /* renamed from: e */
    private C0021d f1155e;

    /* renamed from: f */
    private C0569c f1156f;

    /* renamed from: g */
    private C0569c f1157g;

    /* renamed from: h */
    private C0569c f1158h;

    /* renamed from: i */
    private C0569c f1159i;

    /* renamed from: n.b$a */
    /* loaded from: classes.dex */
    public static final class C0568a {
        private C0568a() {
        }

        public /* synthetic */ C0568a(C0461e c0461e) {
            this();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m762a(C0567b c0567b, C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
        m759d(c0567b, c0032j, interfaceC0038d);
    }

    /* renamed from: b */
    private final void m761b(Context context, InterfaceC0016c interfaceC0016c) {
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.f1152b = new C0021d(interfaceC0016c, "dev.fluttercommunity.plus/sensors/accelerometer");
        this.f1156f = new C0569c(sensorManager, 1);
        C0021d c0021d = this.f1152b;
        C0569c c0569c = null;
        if (c0021d == null) {
            C0465i.m1038o("accelerometerChannel");
            c0021d = null;
        }
        C0569c c0569c2 = this.f1156f;
        if (c0569c2 == null) {
            C0465i.m1038o("accelerometerStreamHandler");
            c0569c2 = null;
        }
        c0021d.m2282d(c0569c2);
        this.f1153c = new C0021d(interfaceC0016c, "dev.fluttercommunity.plus/sensors/user_accel");
        this.f1157g = new C0569c(sensorManager, 10);
        C0021d c0021d2 = this.f1153c;
        if (c0021d2 == null) {
            C0465i.m1038o("userAccelChannel");
            c0021d2 = null;
        }
        C0569c c0569c3 = this.f1157g;
        if (c0569c3 == null) {
            C0465i.m1038o("userAccelStreamHandler");
            c0569c3 = null;
        }
        c0021d2.m2282d(c0569c3);
        this.f1154d = new C0021d(interfaceC0016c, "dev.fluttercommunity.plus/sensors/gyroscope");
        this.f1158h = new C0569c(sensorManager, 4);
        C0021d c0021d3 = this.f1154d;
        if (c0021d3 == null) {
            C0465i.m1038o("gyroscopeChannel");
            c0021d3 = null;
        }
        C0569c c0569c4 = this.f1158h;
        if (c0569c4 == null) {
            C0465i.m1038o("gyroscopeStreamHandler");
            c0569c4 = null;
        }
        c0021d3.m2282d(c0569c4);
        this.f1155e = new C0021d(interfaceC0016c, "dev.fluttercommunity.plus/sensors/magnetometer");
        this.f1159i = new C0569c(sensorManager, 2);
        C0021d c0021d4 = this.f1155e;
        if (c0021d4 == null) {
            C0465i.m1038o("magnetometerChannel");
            c0021d4 = null;
        }
        C0569c c0569c5 = this.f1159i;
        if (c0569c5 == null) {
            C0465i.m1038o("magnetometerStreamHandler");
        } else {
            c0569c = c0569c5;
        }
        c0021d4.m2282d(c0569c);
    }

    /* renamed from: c */
    private final void m760c(InterfaceC0016c interfaceC0016c) {
        C0033k c0033k = new C0033k(interfaceC0016c, "dev.fluttercommunity.plus/sensors/method");
        this.f1151a = c0033k;
        c0033k.m2269e(new C0033k.InterfaceC0037c() { // from class: n.a
            {
                C0567b.this = this;
            }

            @Override // p001a0.C0033k.InterfaceC0037c
            /* renamed from: a */
            public final void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
                C0567b.m762a(C0567b.this, c0032j, interfaceC0038d);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0078  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m759d(p029n.C0567b r3, p001a0.C0032j r4, p001a0.C0033k.InterfaceC0038d r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.C0465i.m1048e(r3, r0)
            java.lang.String r0 = "call"
            kotlin.jvm.internal.C0465i.m1048e(r4, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.C0465i.m1048e(r5, r0)
            java.lang.String r0 = r4.f38a
            r1 = 0
            if (r0 == 0) goto L5e
            int r2 = r0.hashCode()
            switch(r2) {
                case -1748473046: goto L4c;
                case -1203963890: goto L3c;
                case -521809110: goto L2c;
                case 1134117419: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L5e
        L1c:
            java.lang.String r2 = "setGyroscopeSamplingPeriod"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L25
            goto L5e
        L25:
            n.c r3 = r3.f1158h
            if (r3 != 0) goto L5f
            java.lang.String r3 = "gyroscopeStreamHandler"
            goto L5b
        L2c:
            java.lang.String r2 = "setUserAccelerometerSamplingPeriod"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L35
            goto L5e
        L35:
            n.c r3 = r3.f1157g
            if (r3 != 0) goto L5f
            java.lang.String r3 = "userAccelStreamHandler"
            goto L5b
        L3c:
            java.lang.String r2 = "setMagnetometerSamplingPeriod"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L45
            goto L5e
        L45:
            n.c r3 = r3.f1159i
            if (r3 != 0) goto L5f
            java.lang.String r3 = "magnetometerStreamHandler"
            goto L5b
        L4c:
            java.lang.String r2 = "setAccelerationSamplingPeriod"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L55
            goto L5e
        L55:
            n.c r3 = r3.f1156f
            if (r3 != 0) goto L5f
            java.lang.String r3 = "accelerometerStreamHandler"
        L5b:
            kotlin.jvm.internal.C0465i.m1038o(r3)
        L5e:
            r3 = r1
        L5f:
            if (r3 != 0) goto L62
            goto L72
        L62:
            java.lang.Object r4 = r4.f39b
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Int"
            java.util.Objects.requireNonNull(r4, r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r3.m752e(r4)
        L72:
            if (r3 == 0) goto L78
            r5.mo65b(r1)
            goto L7b
        L78:
            r5.mo64c()
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p029n.C0567b.m759d(n.b, a0.j, a0.k$d):void");
    }

    /* renamed from: e */
    private final void m758e() {
        C0021d c0021d = this.f1152b;
        if (c0021d == null) {
            C0465i.m1038o("accelerometerChannel");
            c0021d = null;
        }
        c0021d.m2282d(null);
        C0021d c0021d2 = this.f1153c;
        if (c0021d2 == null) {
            C0465i.m1038o("userAccelChannel");
            c0021d2 = null;
        }
        c0021d2.m2282d(null);
        C0021d c0021d3 = this.f1154d;
        if (c0021d3 == null) {
            C0465i.m1038o("gyroscopeChannel");
            c0021d3 = null;
        }
        c0021d3.m2282d(null);
        C0021d c0021d4 = this.f1155e;
        if (c0021d4 == null) {
            C0465i.m1038o("magnetometerChannel");
            c0021d4 = null;
        }
        c0021d4.m2282d(null);
        C0569c c0569c = this.f1156f;
        if (c0569c == null) {
            C0465i.m1038o("accelerometerStreamHandler");
            c0569c = null;
        }
        c0569c.mo755b(null);
        C0569c c0569c2 = this.f1157g;
        if (c0569c2 == null) {
            C0465i.m1038o("userAccelStreamHandler");
            c0569c2 = null;
        }
        c0569c2.mo755b(null);
        C0569c c0569c3 = this.f1158h;
        if (c0569c3 == null) {
            C0465i.m1038o("gyroscopeStreamHandler");
            c0569c3 = null;
        }
        c0569c3.mo755b(null);
        C0569c c0569c4 = this.f1159i;
        if (c0569c4 == null) {
            C0465i.m1038o("magnetometerStreamHandler");
            c0569c4 = null;
        }
        c0569c4.mo755b(null);
    }

    /* renamed from: f */
    private final void m757f() {
        C0033k c0033k = this.f1151a;
        if (c0033k == null) {
            C0465i.m1038o("methodChannel");
            c0033k = null;
        }
        c0033k.m2269e(null);
    }

    @Override // p041t.InterfaceC0648a
    /* renamed from: g */
    public void mo638g(InterfaceC0648a.C0650b binding) {
        C0465i.m1048e(binding, "binding");
        m757f();
        m758e();
    }

    @Override // p041t.InterfaceC0648a
    /* renamed from: i */
    public void mo637i(InterfaceC0648a.C0650b binding) {
        C0465i.m1048e(binding, "binding");
        InterfaceC0016c m635b = binding.m635b();
        C0465i.m1049d(m635b, "binding.binaryMessenger");
        m760c(m635b);
        Context m636a = binding.m636a();
        C0465i.m1049d(m636a, "binding.applicationContext");
        InterfaceC0016c m635b2 = binding.m635b();
        C0465i.m1049d(m635b2, "binding.binaryMessenger");
        m761b(m636a, m635b2);
    }
}