package p048w0;

import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p020i0.AbstractC0240a;
import p020i0.InterfaceC0249g;

/* renamed from: w0.k0 */
/* loaded from: classes.dex */
public final class C0749k0 extends AbstractC0240a {

    /* renamed from: e */
    public static final C0750a f1336e = new C0750a(null);

    /* renamed from: d */
    private final String f1337d;

    /* renamed from: w0.k0$a */
    /* loaded from: classes.dex */
    public static final class C0750a implements InterfaceC0249g.InterfaceC0254c<C0749k0> {
        private C0750a() {
        }

        public /* synthetic */ C0750a(C0461e c0461e) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0749k0) && C0465i.m1052a(this.f1337d, ((C0749k0) obj).f1337d);
    }

    public int hashCode() {
        return this.f1337d.hashCode();
    }

    /* renamed from: o */
    public final String m445o() {
        return this.f1337d;
    }

    public String toString() {
        return "CoroutineName(" + this.f1337d + ')';
    }
}