package p048w0;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: w0.y0 */
/* loaded from: classes.dex */
public final class C0798y0 implements InterfaceC0744j1 {

    /* renamed from: d */
    private final boolean f1405d;

    public C0798y0(boolean z) {
        this.f1405d = z;
    }

    @Override // p048w0.InterfaceC0744j1
    /* renamed from: a */
    public boolean mo247a() {
        return this.f1405d;
    }

    @Override // p048w0.InterfaceC0744j1
    /* renamed from: c */
    public C0802z1 mo246c() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(mo247a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}