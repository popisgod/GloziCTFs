package p027m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import kotlin.jvm.internal.C0465i;
import p001a0.C0021d;

/* renamed from: m.b */
/* loaded from: classes.dex */
public final class C0562b {

    /* renamed from: m.b$a */
    /* loaded from: classes.dex */
    public static final class C0563a implements SensorEventListener {

        /* renamed from: a */
        final /* synthetic */ C0021d.InterfaceC0023b f1142a;

        C0563a(C0021d.InterfaceC0023b interfaceC0023b) {
            this.f1142a = interfaceC0023b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            C0465i.m1048e(sensor, "sensor");
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            C0465i.m1048e(event, "event");
            this.f1142a.mo2277b(Integer.valueOf((int) event.values[0]));
        }
    }

    /* renamed from: a */
    public static final SensorEventListener m764a(C0021d.InterfaceC0023b events) {
        C0465i.m1048e(events, "events");
        return new C0563a(events);
    }
}