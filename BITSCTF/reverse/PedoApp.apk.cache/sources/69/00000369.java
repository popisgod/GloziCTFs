package p048w0;

import java.util.Objects;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p020i0.AbstractC0240a;
import p020i0.InterfaceC0249g;
import p046v0.C0692n;

/* renamed from: w0.j0 */
/* loaded from: classes.dex */
public final class C0742j0 extends AbstractC0240a implements InterfaceC0720e2<String> {

    /* renamed from: e */
    public static final C0743a f1332e = new C0743a(null);

    /* renamed from: d */
    private final long f1333d;

    /* renamed from: w0.j0$a */
    /* loaded from: classes.dex */
    public static final class C0743a implements InterfaceC0249g.InterfaceC0254c<C0742j0> {
        private C0743a() {
        }

        public /* synthetic */ C0743a(C0461e c0461e) {
            this();
        }
    }

    public C0742j0(long j) {
        super(f1332e);
        this.f1333d = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0742j0) && this.f1333d == ((C0742j0) obj).f1333d;
    }

    public int hashCode() {
        return C0738i0.m452a(this.f1333d);
    }

    /* renamed from: o */
    public final long m449o() {
        return this.f1333d;
    }

    @Override // p048w0.InterfaceC0720e2
    /* renamed from: p */
    public void mo450e(InterfaceC0249g interfaceC0249g, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // p048w0.InterfaceC0720e2
    /* renamed from: q */
    public String mo451c(InterfaceC0249g interfaceC0249g) {
        int m549F;
        String m445o;
        C0749k0 c0749k0 = (C0749k0) interfaceC0249g.get(C0749k0.f1336e);
        String str = "coroutine";
        if (c0749k0 != null && (m445o = c0749k0.m445o()) != null) {
            str = m445o;
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        m549F = C0692n.m549F(name, " @", 0, false, 6, null);
        if (m549F < 0) {
            m549F = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + m549F + 10);
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String substring = name.substring(0, m549F);
        C0465i.m1049d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(m449o());
        C0169q c0169q = C0169q.f235a;
        String sb2 = sb.toString();
        C0465i.m1049d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    public String toString() {
        return "CoroutineId(" + this.f1333d + ')';
    }
}