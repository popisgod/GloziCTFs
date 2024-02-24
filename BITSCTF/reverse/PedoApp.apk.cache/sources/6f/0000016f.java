package io.flutter.embedding.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.embedding.android.a */
/* loaded from: classes.dex */
public class C0256a {

    /* renamed from: f */
    private static final Matrix f302f = new Matrix();

    /* renamed from: a */
    private final FlutterRenderer f303a;

    /* renamed from: c */
    private final boolean f305c;

    /* renamed from: e */
    private int f307e;

    /* renamed from: d */
    private final Map<Integer, float[]> f306d = new HashMap();

    /* renamed from: b */
    private final C0305t f304b = C0305t.m1639a();

    public C0256a(FlutterRenderer flutterRenderer, boolean z) {
        this.f303a = flutterRenderer;
        this.f305c = z;
    }

    /* renamed from: a */
    private void m1816a(MotionEvent motionEvent, int i, int i2, int i3, Matrix matrix, ByteBuffer byteBuffer) {
        m1815b(motionEvent, i, i2, i3, matrix, byteBuffer, null);
    }

    /* renamed from: b */
    private void m1815b(MotionEvent motionEvent, int i, int i2, int i3, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        long j;
        long j2;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        InputDevice.MotionRange motionRange;
        int i4 = -1;
        if (i2 == -1) {
            return;
        }
        int pointerId = motionEvent.getPointerId(i);
        int m1811f = m1811f(motionEvent.getToolType(i));
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        if (m1811f == 1) {
            j = motionEvent.getButtonState() & 31;
            if (j == 0 && motionEvent.getSource() == 8194 && i2 == 4) {
                this.f306d.put(Integer.valueOf(pointerId), fArr);
            }
        } else {
            j = m1811f == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.f306d.containsKey(Integer.valueOf(pointerId));
        if (containsKey) {
            int m1812e = m1812e(i2);
            if (m1812e == -1) {
                return;
            }
            i4 = m1812e;
        }
        long m1633d = this.f305c ? this.f304b.m1637c(motionEvent).m1633d() : 0L;
        int i5 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        int i6 = i4;
        byteBuffer.putLong(m1633d);
        byteBuffer.putLong(motionEvent.getEventTime() * 1000);
        if (containsKey) {
            byteBuffer.putLong(i6);
            j2 = 4;
        } else {
            byteBuffer.putLong(i2);
            j2 = m1811f;
        }
        byteBuffer.putLong(j2);
        byteBuffer.putLong(i5);
        byteBuffer.putLong(pointerId);
        byteBuffer.putLong(0L);
        if (containsKey) {
            float[] fArr2 = this.f306d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr2[0]);
            d = fArr2[1];
        } else {
            byteBuffer.putDouble(fArr[0]);
            d = fArr[1];
        }
        byteBuffer.putDouble(d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(j);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d2 = 1.0d;
            d3 = 0.0d;
        } else {
            d3 = motionRange.getMin();
            d2 = motionRange.getMax();
        }
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(d2);
        if (m1811f == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i));
            d4 = 0.0d;
        } else {
            d4 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(motionEvent.getSize(i));
        byteBuffer.putDouble(motionEvent.getToolMajor(i));
        byteBuffer.putDouble(motionEvent.getToolMinor(i));
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i));
        if (m1811f == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i));
        } else {
            byteBuffer.putDouble(d4);
        }
        byteBuffer.putLong(i3);
        if (i5 == 1) {
            double d7 = 48.0d;
            if (context != null) {
                d7 = m1814c(context);
                d6 = m1810g(context);
            } else {
                d6 = 48.0d;
            }
            double d8 = -motionEvent.getAxisValue(10, i);
            Double.isNaN(d8);
            double d9 = -motionEvent.getAxisValue(9, i);
            Double.isNaN(d9);
            byteBuffer.putDouble(d7 * d8);
            byteBuffer.putDouble(d6 * d9);
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        if (containsKey) {
            float[] fArr3 = this.f306d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr[0] - fArr3[0]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d5 = 0.0d;
        } else {
            d5 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d5);
        byteBuffer.putDouble(d5);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d5);
        if (containsKey && i6 == 9) {
            this.f306d.remove(Integer.valueOf(pointerId));
        }
    }

    /* renamed from: c */
    private float m1814c(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? ViewConfiguration.get(context).getScaledHorizontalScrollFactor() : m1808i(context);
    }

    /* renamed from: d */
    private int m1813d(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 6;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return 6;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 7) {
            return 3;
        }
        if (i == 3) {
            return 0;
        }
        return i == 8 ? 3 : -1;
    }

    /* renamed from: e */
    private int m1812e(int i) {
        if (i == 4) {
            return 7;
        }
        if (i == 5) {
            return 8;
        }
        return (i == 6 || i == 0) ? 9 : -1;
    }

    /* renamed from: f */
    private int m1811f(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? 5 : 3;
                }
                return 1;
            }
            return 2;
        }
        return 0;
    }

    /* renamed from: g */
    private float m1810g(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? m1809h(context) : m1808i(context);
    }

    @TargetApi(26)
    /* renamed from: h */
    private float m1809h(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    /* renamed from: i */
    private int m1808i(Context context) {
        if (this.f307e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 48;
            }
            this.f307e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f307e;
    }

    /* renamed from: j */
    public boolean m1807j(MotionEvent motionEvent, Context context) {
        boolean z = Build.VERSION.SDK_INT >= 18 && motionEvent.isFromSource(2);
        boolean z2 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (z && z2) {
            int m1813d = m1813d(motionEvent.getActionMasked());
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 35 * 8);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            m1815b(motionEvent, motionEvent.getActionIndex(), m1813d, 0, f302f, allocateDirect, context);
            if (allocateDirect.position() % 280 == 0) {
                this.f303a.m1547l(allocateDirect, allocateDirect.position());
                return true;
            }
            throw new AssertionError("Packet position is not on field boundary.");
        }
        return false;
    }

    /* renamed from: k */
    public boolean m1806k(MotionEvent motionEvent) {
        return m1805l(motionEvent, f302f);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m1805l(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r0 * 35
            int r1 = r1 * 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            int r2 = r13.getActionMasked()
            int r3 = r13.getActionMasked()
            int r9 = r12.m1813d(r3)
            r3 = 0
            r10 = 1
            if (r2 == 0) goto L27
            r4 = 5
            if (r2 != r4) goto L25
            goto L27
        L25:
            r4 = 0
            goto L28
        L27:
            r4 = 1
        L28:
            if (r4 != 0) goto L31
            if (r2 == r10) goto L2f
            r5 = 6
            if (r2 != r5) goto L31
        L2f:
            r2 = 1
            goto L32
        L31:
            r2 = 0
        L32:
            if (r4 == 0) goto L42
        L34:
            int r4 = r13.getActionIndex()
            r6 = 0
            r2 = r12
            r3 = r13
            r5 = r9
            r7 = r14
            r8 = r1
            r2.m1816a(r3, r4, r5, r6, r7, r8)
            goto L6f
        L42:
            r11 = 0
            if (r2 == 0) goto L60
        L45:
            if (r11 >= r0) goto L34
            int r2 = r13.getActionIndex()
            if (r11 == r2) goto L5d
            int r2 = r13.getToolType(r11)
            if (r2 != r10) goto L5d
            r5 = 5
            r6 = 1
            r2 = r12
            r3 = r13
            r4 = r11
            r7 = r14
            r8 = r1
            r2.m1816a(r3, r4, r5, r6, r7, r8)
        L5d:
            int r11 = r11 + 1
            goto L45
        L60:
            if (r11 >= r0) goto L6f
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r11
            r5 = r9
            r7 = r14
            r8 = r1
            r2.m1816a(r3, r4, r5, r6, r7, r8)
            int r11 = r11 + 1
            goto L60
        L6f:
            int r13 = r1.position()
            int r13 = r13 % 280
            if (r13 != 0) goto L81
            io.flutter.embedding.engine.renderer.FlutterRenderer r13 = r12.f303a
            int r14 = r1.position()
            r13.m1547l(r1, r14)
            return r10
        L81:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r14 = "Packet position is not on field boundary"
            r13.<init>(r14)
            goto L8a
        L89:
            throw r13
        L8a:
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.C0256a.m1805l(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}