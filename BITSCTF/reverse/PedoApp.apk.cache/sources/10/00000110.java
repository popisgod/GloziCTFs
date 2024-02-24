package p014f0;

import java.io.Serializable;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;

/* renamed from: f0.k */
/* loaded from: classes.dex */
public final class C0161k<T> implements Serializable {

    /* renamed from: d */
    public static final C0162a f229d = new C0162a(null);

    /* renamed from: f0.k$a */
    /* loaded from: classes.dex */
    public static final class C0162a {
        private C0162a() {
        }

        public /* synthetic */ C0162a(C0461e c0461e) {
            this();
        }
    }

    /* renamed from: f0.k$b */
    /* loaded from: classes.dex */
    public static final class C0163b implements Serializable {

        /* renamed from: d */
        public final Throwable f230d;

        public C0163b(Throwable exception) {
            C0465i.m1048e(exception, "exception");
            this.f230d = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0163b) && C0465i.m1052a(this.f230d, ((C0163b) obj).f230d);
        }

        public int hashCode() {
            return this.f230d.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f230d + ')';
        }
    }

    /* renamed from: a */
    public static <T> Object m2010a(Object obj) {
        return obj;
    }

    /* renamed from: b */
    public static final Throwable m2009b(Object obj) {
        if (obj instanceof C0163b) {
            return ((C0163b) obj).f230d;
        }
        return null;
    }

    /* renamed from: c */
    public static final boolean m2008c(Object obj) {
        return obj instanceof C0163b;
    }

    /* renamed from: d */
    public static final boolean m2007d(Object obj) {
        return !(obj instanceof C0163b);
    }
}