package p029n;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import kotlin.jvm.internal.C0465i;
import p001a0.C0021d;

/* renamed from: n.c */
/* loaded from: classes.dex */
public final class C0569c implements C0021d.InterfaceC0026d {

    /* renamed from: a */
    private final SensorManager f1160a;

    /* renamed from: b */
    private final int f1161b;

    /* renamed from: c */
    private SensorEventListener f1162c;

    /* renamed from: d */
    private Sensor f1163d;

    /* renamed from: e */
    private int f1164e;

    /* renamed from: n.c$a */
    /* loaded from: classes.dex */
    public static final class C0570a implements SensorEventListener {

        /* renamed from: a */
        final /* synthetic */ C0021d.InterfaceC0023b f1165a;

        C0570a(C0021d.InterfaceC0023b interfaceC0023b) {
            this.f1165a = interfaceC0023b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            C0465i.m1048e(sensor, "sensor");
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            C0465i.m1048e(event, "event");
            float[] fArr = event.values;
            double[] dArr = new double[fArr.length];
            C0465i.m1049d(fArr, "event.values");
            int length = fArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                dArr[i2] = fArr[i];
                i++;
                i2++;
            }
            this.f1165a.mo2277b(dArr);
        }
    }

    public C0569c(SensorManager sensorManager, int i) {
        C0465i.m1048e(sensorManager, "sensorManager");
        this.f1160a = sensorManager;
        this.f1161b = i;
        this.f1164e = 200000;
    }

    /* renamed from: c */
    private final SensorEventListener m754c(C0021d.InterfaceC0023b interfaceC0023b) {
        return new C0570a(interfaceC0023b);
    }

    /* renamed from: d */
    private final String m753d(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 10 ? "Undefined" : "User Accelerometer" : "Gyroscope" : "Magnetometer" : "Accelerometer";
    }

    /* renamed from: f */
    private final void m751f() {
        SensorEventListener sensorEventListener = this.f1162c;
        if (sensorEventListener != null) {
            this.f1160a.unregisterListener(sensorEventListener);
            this.f1160a.registerListener(this.f1162c, this.f1163d, this.f1164e);
        }
    }

    @Override // p001a0.C0021d.InterfaceC0026d
    /* renamed from: a */
    public void mo756a(Object obj, C0021d.InterfaceC0023b events) {
        C0465i.m1048e(events, "events");
        Sensor defaultSensor = this.f1160a.getDefaultSensor(this.f1161b);
        this.f1163d = defaultSensor;
        if (defaultSensor != null) {
            SensorEventListener m754c = m754c(events);
            this.f1162c = m754c;
            this.f1160a.registerListener(m754c, this.f1163d, this.f1164e);
            return;
        }
        events.mo2278a("NO_SENSOR", "Sensor not found", "It seems that your device has no " + m753d(this.f1161b) + " sensor");
    }

    @Override // p001a0.C0021d.InterfaceC0026d
    /* renamed from: b */
    public void mo755b(Object obj) {
        if (this.f1163d != null) {
            this.f1160a.unregisterListener(this.f1162c);
            this.f1162c = null;
        }
    }

    /* renamed from: e */
    public final void m752e(int i) {
        this.f1164e = i;
        m751f();
    }
}