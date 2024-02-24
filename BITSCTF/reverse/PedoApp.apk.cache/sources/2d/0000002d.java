package p001a0;

import androidx.window.C0082R;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: a0.r */
/* loaded from: classes.dex */
public class C0045r implements InterfaceC0031i<Object> {

    /* renamed from: a */
    public static final C0045r f50a = new C0045r();

    /* renamed from: b */
    private static final boolean f51b;

    /* renamed from: c */
    private static final Charset f52c;

    /* renamed from: a0.r$a */
    /* loaded from: classes.dex */
    static final class C0046a extends ByteArrayOutputStream {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public byte[] m2250a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        f51b = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        f52c = Charset.forName("UTF8");
    }

    /* renamed from: c */
    protected static final void m2264c(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position() % i;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i) - position);
        }
    }

    /* renamed from: d */
    protected static final byte[] m2263d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[m2262e(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: e */
    protected static final int m2262e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            int i = byteBuffer.get() & 255;
            return i < 254 ? i : i == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* renamed from: h */
    protected static final void m2259h(ByteArrayOutputStream byteArrayOutputStream, int i) {
        int size = byteArrayOutputStream.size() % i;
        if (size != 0) {
            for (int i2 = 0; i2 < i - size; i2++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    /* renamed from: i */
    protected static final void m2258i(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        m2252o(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    /* renamed from: j */
    protected static final void m2257j(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (f51b) {
            byteArrayOutputStream.write(i);
            i >>>= 8;
        } else {
            byteArrayOutputStream.write(i >>> 8);
        }
        byteArrayOutputStream.write(i);
    }

    /* renamed from: k */
    protected static final void m2256k(ByteArrayOutputStream byteArrayOutputStream, double d) {
        m2253n(byteArrayOutputStream, Double.doubleToLongBits(d));
    }

    /* renamed from: l */
    protected static final void m2255l(ByteArrayOutputStream byteArrayOutputStream, float f) {
        m2254m(byteArrayOutputStream, Float.floatToIntBits(f));
    }

    /* renamed from: m */
    protected static final void m2254m(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (f51b) {
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i >>> 8);
            byteArrayOutputStream.write(i >>> 16);
            i >>>= 24;
        } else {
            byteArrayOutputStream.write(i >>> 24);
            byteArrayOutputStream.write(i >>> 16);
            byteArrayOutputStream.write(i >>> 8);
        }
        byteArrayOutputStream.write(i);
    }

    /* renamed from: n */
    protected static final void m2253n(ByteArrayOutputStream byteArrayOutputStream, long j) {
        if (f51b) {
            byteArrayOutputStream.write((byte) j);
            byteArrayOutputStream.write((byte) (j >>> 8));
            byteArrayOutputStream.write((byte) (j >>> 16));
            byteArrayOutputStream.write((byte) (j >>> 24));
            byteArrayOutputStream.write((byte) (j >>> 32));
            byteArrayOutputStream.write((byte) (j >>> 40));
            byteArrayOutputStream.write((byte) (j >>> 48));
            j >>>= 56;
        } else {
            byteArrayOutputStream.write((byte) (j >>> 56));
            byteArrayOutputStream.write((byte) (j >>> 48));
            byteArrayOutputStream.write((byte) (j >>> 40));
            byteArrayOutputStream.write((byte) (j >>> 32));
            byteArrayOutputStream.write((byte) (j >>> 24));
            byteArrayOutputStream.write((byte) (j >>> 16));
            byteArrayOutputStream.write((byte) (j >>> 8));
        }
        byteArrayOutputStream.write((byte) j);
    }

    /* renamed from: o */
    protected static final void m2252o(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (i < 254) {
            byteArrayOutputStream.write(i);
        } else if (i <= 65535) {
            byteArrayOutputStream.write(254);
            m2257j(byteArrayOutputStream, i);
        } else {
            byteArrayOutputStream.write(255);
            m2254m(byteArrayOutputStream, i);
        }
    }

    @Override // p001a0.InterfaceC0031i
    /* renamed from: a */
    public Object mo2243a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object m2261f = m2261f(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return m2261f;
    }

    @Override // p001a0.InterfaceC0031i
    /* renamed from: b */
    public ByteBuffer mo2242b(Object obj) {
        if (obj == null) {
            return null;
        }
        C0046a c0046a = new C0046a();
        m2251p(c0046a, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c0046a.size());
        allocateDirect.put(c0046a.m2250a(), 0, c0046a.size());
        return allocateDirect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final Object m2261f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return m2260g(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Map, java.util.HashMap] */
    /* renamed from: g */
    protected Object m2260g(byte b, ByteBuffer byteBuffer) {
        int m2262e;
        int m2262e2;
        long[] jArr;
        ?? arrayList;
        int[] iArr;
        int i = 0;
        switch (b) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                return new BigInteger(new String(m2263d(byteBuffer), f52c), 16);
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                m2264c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                return new String(m2263d(byteBuffer), f52c);
            case 8:
                return m2263d(byteBuffer);
            case 9:
                m2262e = m2262e(byteBuffer);
                int[] iArr2 = new int[m2262e];
                m2264c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr2);
                iArr = iArr2;
                byteBuffer.position(byteBuffer.position() + (m2262e * 4));
                return iArr;
            case 10:
                m2262e2 = m2262e(byteBuffer);
                long[] jArr2 = new long[m2262e2];
                m2264c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr2);
                jArr = jArr2;
                byteBuffer.position(byteBuffer.position() + (m2262e2 * 8));
                return jArr;
            case 11:
                m2262e2 = m2262e(byteBuffer);
                double[] dArr = new double[m2262e2];
                m2264c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr);
                jArr = dArr;
                byteBuffer.position(byteBuffer.position() + (m2262e2 * 8));
                return jArr;
            case 12:
                int m2262e3 = m2262e(byteBuffer);
                arrayList = new ArrayList(m2262e3);
                while (i < m2262e3) {
                    arrayList.add(m2261f(byteBuffer));
                    i++;
                }
                return arrayList;
            case 13:
                int m2262e4 = m2262e(byteBuffer);
                arrayList = new HashMap();
                while (i < m2262e4) {
                    arrayList.put(m2261f(byteBuffer), m2261f(byteBuffer));
                    i++;
                }
                return arrayList;
            case 14:
                m2262e = m2262e(byteBuffer);
                float[] fArr = new float[m2262e];
                m2264c(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr);
                iArr = fArr;
                byteBuffer.position(byteBuffer.position() + (m2262e * 4));
                return iArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public void m2251p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i = 0;
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
        } else if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
        } else if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                m2254m(byteArrayOutputStream, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                m2253n(byteArrayOutputStream, ((Long) obj).longValue());
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                m2259h(byteArrayOutputStream, 8);
                m2256k(byteArrayOutputStream, ((Number) obj).doubleValue());
            } else if (!(obj instanceof BigInteger)) {
                throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
            } else {
                byteArrayOutputStream.write(5);
                m2258i(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(f52c));
            }
        } else if (obj instanceof CharSequence) {
            byteArrayOutputStream.write(7);
            m2258i(byteArrayOutputStream, obj.toString().getBytes(f52c));
        } else if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            m2258i(byteArrayOutputStream, (byte[]) obj);
        } else if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            m2252o(byteArrayOutputStream, iArr.length);
            m2259h(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i < length) {
                m2254m(byteArrayOutputStream, iArr[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            m2252o(byteArrayOutputStream, jArr.length);
            m2259h(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i < length2) {
                m2253n(byteArrayOutputStream, jArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            m2252o(byteArrayOutputStream, dArr.length);
            m2259h(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i < length3) {
                m2256k(byteArrayOutputStream, dArr[i]);
                i++;
            }
        } else if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List<Object> list = (List) obj;
            m2252o(byteArrayOutputStream, list.size());
            for (Object obj2 : list) {
                m2251p(byteArrayOutputStream, obj2);
            }
        } else if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            m2252o(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                m2251p(byteArrayOutputStream, entry.getKey());
                m2251p(byteArrayOutputStream, entry.getValue());
            }
        } else if (!(obj instanceof float[])) {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        } else {
            byteArrayOutputStream.write(14);
            float[] fArr = (float[]) obj;
            m2252o(byteArrayOutputStream, fArr.length);
            m2259h(byteArrayOutputStream, 4);
            int length4 = fArr.length;
            while (i < length4) {
                m2255l(byteArrayOutputStream, fArr[i]);
                i++;
            }
        }
    }
}