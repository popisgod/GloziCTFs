package kotlin.jvm.internal;

/* renamed from: kotlin.jvm.internal.k */
/* loaded from: classes.dex */
public final class C0467k implements InterfaceC0457b {

    /* renamed from: d */
    private final Class<?> f982d;

    /* renamed from: e */
    private final String f983e;

    public C0467k(Class<?> jClass, String moduleName) {
        C0465i.m1048e(jClass, "jClass");
        C0465i.m1048e(moduleName, "moduleName");
        this.f982d = jClass;
        this.f983e = moduleName;
    }

    @Override // kotlin.jvm.internal.InterfaceC0457b
    /* renamed from: b */
    public Class<?> mo1037b() {
        return this.f982d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0467k) && C0465i.m1052a(mo1037b(), ((C0467k) obj).mo1037b());
    }

    public int hashCode() {
        return mo1037b().hashCode();
    }

    public String toString() {
        return mo1037b().toString() + " (Kotlin reflection is not available)";
    }
}