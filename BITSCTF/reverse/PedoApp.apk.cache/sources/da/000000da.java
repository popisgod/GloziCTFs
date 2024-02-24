package p004b;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: b.d */
/* loaded from: classes.dex */
public class C0108d<K, V> {

    /* renamed from: g */
    static Object[] f170g;

    /* renamed from: h */
    static int f171h;

    /* renamed from: i */
    static Object[] f172i;

    /* renamed from: j */
    static int f173j;

    /* renamed from: d */
    int[] f174d = C0101b.f152a;

    /* renamed from: e */
    Object[] f175e = C0101b.f154c;

    /* renamed from: f */
    int f176f = 0;

    /* renamed from: a */
    private void m2111a(int i) {
        if (i == 8) {
            synchronized (C0108d.class) {
                Object[] objArr = f172i;
                if (objArr != null) {
                    this.f175e = objArr;
                    f172i = (Object[]) objArr[0];
                    this.f174d = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f173j--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0108d.class) {
                Object[] objArr2 = f170g;
                if (objArr2 != null) {
                    this.f175e = objArr2;
                    f170g = (Object[]) objArr2[0];
                    this.f174d = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f171h--;
                    return;
                }
            }
        }
        this.f174d = new int[i];
        this.f175e = new Object[i << 1];
    }

    /* renamed from: b */
    private static int m2110b(int[] iArr, int i, int i2) {
        try {
            return C0101b.m2133a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: d */
    private static void m2108d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0108d.class) {
                if (f173j < 10) {
                    objArr[0] = f172i;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f172i = objArr;
                    f173j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0108d.class) {
                if (f171h < 10) {
                    objArr[0] = f170g;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f170g = objArr;
                    f171h++;
                }
            }
        }
    }

    /* renamed from: c */
    public void m2109c(int i) {
        int i2 = this.f176f;
        int[] iArr = this.f174d;
        if (iArr.length < i) {
            Object[] objArr = this.f175e;
            m2111a(i);
            if (this.f176f > 0) {
                System.arraycopy(iArr, 0, this.f174d, 0, i2);
                System.arraycopy(objArr, 0, this.f175e, 0, i2 << 1);
            }
            m2108d(iArr, objArr, i2);
        }
        if (this.f176f != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.f176f;
        if (i > 0) {
            int[] iArr = this.f174d;
            Object[] objArr = this.f175e;
            this.f174d = C0101b.f152a;
            this.f175e = C0101b.f154c;
            this.f176f = 0;
            m2108d(iArr, objArr, i);
        }
        if (this.f176f > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m2106f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m2104h(obj) >= 0;
    }

    /* renamed from: e */
    int m2107e(Object obj, int i) {
        int i2 = this.f176f;
        if (i2 == 0) {
            return -1;
        }
        int m2110b = m2110b(this.f174d, i2, i);
        if (m2110b >= 0 && !obj.equals(this.f175e[m2110b << 1])) {
            int i3 = m2110b + 1;
            while (i3 < i2 && this.f174d[i3] == i) {
                if (obj.equals(this.f175e[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = m2110b - 1; i4 >= 0 && this.f174d[i4] == i; i4--) {
                if (obj.equals(this.f175e[i4 << 1])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return m2110b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0108d) {
            C0108d c0108d = (C0108d) obj;
            if (size() != c0108d.size()) {
                return false;
            }
            for (int i = 0; i < this.f176f; i++) {
                try {
                    K m2103i = m2103i(i);
                    V m2100l = m2100l(i);
                    Object obj2 = c0108d.get(m2103i);
                    if (m2100l == null) {
                        if (obj2 != null || !c0108d.containsKey(m2103i)) {
                            return false;
                        }
                    } else if (!m2100l.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f176f; i2++) {
                try {
                    K m2103i2 = m2103i(i2);
                    V m2100l2 = m2100l(i2);
                    Object obj3 = map.get(m2103i2);
                    if (m2100l2 == null) {
                        if (obj3 != null || !map.containsKey(m2103i2)) {
                            return false;
                        }
                    } else if (!m2100l2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int m2106f(Object obj) {
        return obj == null ? m2105g() : m2107e(obj, obj.hashCode());
    }

    /* renamed from: g */
    int m2105g() {
        int i = this.f176f;
        if (i == 0) {
            return -1;
        }
        int m2110b = m2110b(this.f174d, i, 0);
        if (m2110b >= 0 && this.f175e[m2110b << 1] != null) {
            int i2 = m2110b + 1;
            while (i2 < i && this.f174d[i2] == 0) {
                if (this.f175e[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = m2110b - 1; i3 >= 0 && this.f174d[i3] == 0; i3--) {
                if (this.f175e[i3 << 1] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return m2110b;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int m2106f = m2106f(obj);
        return m2106f >= 0 ? (V) this.f175e[(m2106f << 1) + 1] : v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public int m2104h(Object obj) {
        int i = this.f176f * 2;
        Object[] objArr = this.f175e;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f174d;
        Object[] objArr = this.f175e;
        int i = this.f176f;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    /* renamed from: i */
    public K m2103i(int i) {
        return (K) this.f175e[i << 1];
    }

    public boolean isEmpty() {
        return this.f176f <= 0;
    }

    /* renamed from: j */
    public V m2102j(int i) {
        Object[] objArr = this.f175e;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.f176f;
        int i4 = 0;
        if (i3 <= 1) {
            m2108d(this.f174d, objArr, i3);
            this.f174d = C0101b.f152a;
            this.f175e = C0101b.f154c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f174d;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.f175e;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.f175e;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                m2111a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.f176f) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f174d, 0, i);
                    System.arraycopy(objArr, 0, this.f175e, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.f174d, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.f175e, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 == this.f176f) {
            this.f176f = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    /* renamed from: k */
    public V m2101k(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f175e;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    /* renamed from: l */
    public V m2100l(int i) {
        return (V) this.f175e[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int m2107e;
        int i2 = this.f176f;
        if (k == null) {
            m2107e = m2105g();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            m2107e = m2107e(k, hashCode);
        }
        if (m2107e >= 0) {
            int i3 = (m2107e << 1) + 1;
            Object[] objArr = this.f175e;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = m2107e ^ (-1);
        int[] iArr = this.f174d;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.f175e;
            m2111a(i5);
            if (i2 != this.f176f) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f174d;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f175e, 0, objArr2.length);
            }
            m2108d(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f174d;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f175e;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f176f - i4) << 1);
        }
        int i7 = this.f176f;
        if (i2 == i7) {
            int[] iArr4 = this.f174d;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f175e;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.f176f = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int m2106f = m2106f(obj);
        if (m2106f >= 0) {
            return m2102j(m2106f);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int m2106f = m2106f(obj);
        if (m2106f >= 0) {
            V m2100l = m2100l(m2106f);
            if (obj2 == m2100l || (obj2 != null && obj2.equals(m2100l))) {
                m2102j(m2106f);
                return true;
            }
            return false;
        }
        return false;
    }

    public V replace(K k, V v) {
        int m2106f = m2106f(k);
        if (m2106f >= 0) {
            return m2101k(m2106f, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int m2106f = m2106f(k);
        if (m2106f >= 0) {
            V m2100l = m2100l(m2106f);
            if (m2100l == v || (v != null && v.equals(m2100l))) {
                m2101k(m2106f, v2);
                return true;
            }
            return false;
        }
        return false;
    }

    public int size() {
        return this.f176f;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f176f * 28);
        sb.append('{');
        for (int i = 0; i < this.f176f; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K m2103i = m2103i(i);
            if (m2103i != this) {
                sb.append(m2103i);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V m2100l = m2100l(i);
            if (m2100l != this) {
                sb.append(m2100l);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}