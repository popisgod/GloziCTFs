package p040s0;

import kotlin.jvm.internal.C0461e;

/* renamed from: s0.c */
/* loaded from: classes.dex */
public final class C0643c extends C0640a {

    /* renamed from: h */
    public static final C0644a f1270h = new C0644a(null);

    /* renamed from: i */
    private static final C0643c f1271i = new C0643c(1, 0);

    /* renamed from: s0.c$a */
    /* loaded from: classes.dex */
    public static final class C0644a {
        private C0644a() {
        }

        public /* synthetic */ C0644a(C0461e c0461e) {
            this();
        }

        /* renamed from: a */
        public final C0643c m653a() {
            return C0643c.f1271i;
        }
    }

    public C0643c(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // p040s0.C0640a
    public boolean equals(Object obj) {
        if (obj instanceof C0643c) {
            if (!isEmpty() || !((C0643c) obj).isEmpty()) {
                C0643c c0643c = (C0643c) obj;
                if (m663a() != c0643c.m663a() || m662b() != c0643c.m662b()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m656f(int i) {
        return m663a() <= i && i <= m662b();
    }

    /* renamed from: g */
    public Integer m655g() {
        return Integer.valueOf(m662b());
    }

    /* renamed from: h */
    public Integer m654h() {
        return Integer.valueOf(m663a());
    }

    @Override // p040s0.C0640a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m663a() * 31) + m662b();
    }

    @Override // p040s0.C0640a
    public boolean isEmpty() {
        return m663a() > m662b();
    }

    @Override // p040s0.C0640a
    public String toString() {
        return m663a() + ".." + m662b();
    }
}