package p040s0;

import kotlin.jvm.internal.C0461e;
import p016g0.AbstractC0200v;
import p024k0.C0442c;

/* renamed from: s0.a */
/* loaded from: classes.dex */
public class C0640a implements Iterable<Integer> {

    /* renamed from: g */
    public static final C0641a f1262g = new C0641a(null);

    /* renamed from: d */
    private final int f1263d;

    /* renamed from: e */
    private final int f1264e;

    /* renamed from: f */
    private final int f1265f;

    /* renamed from: s0.a$a */
    /* loaded from: classes.dex */
    public static final class C0641a {
        private C0641a() {
        }

        public /* synthetic */ C0641a(C0461e c0461e) {
            this();
        }

        /* renamed from: a */
        public final C0640a m659a(int i, int i2, int i3) {
            return new C0640a(i, i2, i3);
        }
    }

    public C0640a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f1263d = i;
        this.f1264e = C0442c.m1074b(i, i2, i3);
        this.f1265f = i3;
    }

    /* renamed from: a */
    public final int m663a() {
        return this.f1263d;
    }

    /* renamed from: b */
    public final int m662b() {
        return this.f1264e;
    }

    /* renamed from: c */
    public final int m661c() {
        return this.f1265f;
    }

    @Override // java.lang.Iterable
    /* renamed from: d */
    public AbstractC0200v iterator() {
        return new C0642b(this.f1263d, this.f1264e, this.f1265f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0640a) {
            if (!isEmpty() || !((C0640a) obj).isEmpty()) {
                C0640a c0640a = (C0640a) obj;
                if (this.f1263d != c0640a.f1263d || this.f1264e != c0640a.f1264e || this.f1265f != c0640a.f1265f) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f1263d * 31) + this.f1264e) * 31) + this.f1265f;
    }

    public boolean isEmpty() {
        if (this.f1265f > 0) {
            if (this.f1263d > this.f1264e) {
                return true;
            }
        } else if (this.f1263d < this.f1264e) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f1265f > 0) {
            sb = new StringBuilder();
            sb.append(this.f1263d);
            sb.append("..");
            sb.append(this.f1264e);
            sb.append(" step ");
            i = this.f1265f;
        } else {
            sb = new StringBuilder();
            sb.append(this.f1263d);
            sb.append(" downTo ");
            sb.append(this.f1264e);
            sb.append(" step ");
            i = -this.f1265f;
        }
        sb.append(i);
        return sb.toString();
    }
}