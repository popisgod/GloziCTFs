package p027m;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Objects;
import kotlin.jvm.internal.C0465i;
import p001a0.C0021d;
import p041t.InterfaceC0648a;

/* renamed from: m.c */
/* loaded from: classes.dex */
public final class C0564c implements C0021d.InterfaceC0026d {

    /* renamed from: a */
    private SensorEventListener f1143a;

    /* renamed from: b */
    private SensorManager f1144b;

    /* renamed from: c */
    private Sensor f1145c;

    /* renamed from: d */
    private Context f1146d;

    /* renamed from: e */
    private String f1147e;

    /* renamed from: f */
    private InterfaceC0648a.C0650b f1148f;

    public C0564c() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0564c(InterfaceC0648a.C0650b flutterPluginBinding, int i) {
        this();
        C0465i.m1048e(flutterPluginBinding, "flutterPluginBinding");
        Context m636a = flutterPluginBinding.m636a();
        C0465i.m1049d(m636a, "flutterPluginBinding.applicationContext");
        this.f1146d = m636a;
        this.f1147e = i == 19 ? "StepCount" : "StepDetection";
        if (m636a == null) {
            C0465i.m1038o("context");
            m636a = null;
        }
        Object systemService = m636a.getSystemService("sensor");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.f1144b = sensorManager;
        C0465i.m1051b(sensorManager);
        this.f1145c = sensorManager.getDefaultSensor(i);
        this.f1148f = flutterPluginBinding;
    }

    @Override // p001a0.C0021d.InterfaceC0026d
    /* renamed from: a */
    public void mo756a(Object obj, C0021d.InterfaceC0023b interfaceC0023b) {
        Sensor sensor = this.f1145c;
        C0465i.m1051b(interfaceC0023b);
        if (sensor != null) {
            this.f1143a = C0562b.m764a(interfaceC0023b);
            SensorManager sensorManager = this.f1144b;
            C0465i.m1051b(sensorManager);
            sensorManager.registerListener(this.f1143a, this.f1145c, 0);
            return;
        }
        String str = this.f1147e;
        String str2 = null;
        if (str == null) {
            C0465i.m1038o("sensorName");
            str = null;
        }
        String m1043j = C0465i.m1043j(str, " not available");
        String str3 = this.f1147e;
        if (str3 == null) {
            C0465i.m1038o("sensorName");
        } else {
            str2 = str3;
        }
        interfaceC0023b.mo2278a("1", m1043j, C0465i.m1043j(str2, " is not available on this device"));
    }

    @Override // p001a0.C0021d.InterfaceC0026d
    /* renamed from: b */
    public void mo755b(Object obj) {
        SensorManager sensorManager = this.f1144b;
        C0465i.m1051b(sensorManager);
        sensorManager.unregisterListener(this.f1143a);
    }
}