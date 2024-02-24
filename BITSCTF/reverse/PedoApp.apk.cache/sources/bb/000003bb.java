package p052y0;

import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;

/* renamed from: y0.i */
/* loaded from: classes.dex */
public final class C0824i<T> {

    /* renamed from: a */
    public static final C0826b f1447a = new C0826b(null);

    /* renamed from: b */
    private static final C0827c f1448b = new C0827c();

    /* renamed from: y0.i$a */
    /* loaded from: classes.dex */
    public static final class C0825a extends C0827c {

        /* renamed from: a */
        public final Throwable f1449a;

        public C0825a(Throwable th) {
            this.f1449a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0825a) && C0465i.m1052a(this.f1449a, ((C0825a) obj).f1449a);
        }

        public int hashCode() {
            Throwable th = this.f1449a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // p052y0.C0824i.C0827c
        public String toString() {
            return "Closed(" + this.f1449a + ')';
        }
    }

    /* renamed from: y0.i$b */
    /* loaded from: classes.dex */
    public static final class C0826b {
        private C0826b() {
        }

        public /* synthetic */ C0826b(C0461e c0461e) {
            this();
        }

        /* renamed from: a */
        public final <E> Object m201a(Throwable th) {
            return C0824i.m202b(new C0825a(th));
        }

        /* renamed from: b */
        public final <E> Object m200b() {
            return C0824i.m202b(C0824i.f1448b);
        }

        /* renamed from: c */
        public final <E> Object m199c(E e) {
            return C0824i.m202b(e);
        }
    }

    /* renamed from: y0.i$c */
    /* loaded from: classes.dex */
    public static class C0827c {
        public String toString() {
            return "Failed";
        }
    }

    /* renamed from: b */
    public static <T> Object m202b(Object obj) {
        return obj;
    }
}