package p048w0;

import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0502m;
import kotlinx.coroutines.internal.C0504o;

/* renamed from: w0.z1 */
/* loaded from: classes.dex */
public final class C0802z1 extends C0502m implements InterfaceC0744j1 {
    @Override // p048w0.InterfaceC0744j1
    /* renamed from: a */
    public boolean mo247a() {
        return true;
    }

    @Override // p048w0.InterfaceC0744j1
    /* renamed from: c */
    public C0802z1 mo246c() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.C0504o
    public String toString() {
        return C0768p0.m396c() ? m245y("Active") : super.toString();
    }

    /* renamed from: y */
    public final String m245y(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        boolean z = true;
        for (C0504o c0504o = (C0504o) m937o(); !C0465i.m1052a(c0504o, this); c0504o = c0504o.m936p()) {
            if (c0504o instanceof AbstractC0784u1) {
                AbstractC0784u1 abstractC0784u1 = (AbstractC0784u1) c0504o;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(abstractC0784u1);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        C0465i.m1049d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}