package p048w0;

import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p034p0.InterfaceC0611l;

/* renamed from: w0.z */
/* loaded from: classes.dex */
public final class C0800z {

    /* renamed from: a */
    public final Object f1406a;

    /* renamed from: b */
    public final InterfaceC0611l<Throwable, C0169q> f1407b;

    /* JADX WARN: Multi-variable type inference failed */
    public C0800z(Object obj, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l) {
        this.f1406a = obj;
        this.f1407b = interfaceC0611l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0800z) {
            C0800z c0800z = (C0800z) obj;
            return C0465i.m1052a(this.f1406a, c0800z.f1406a) && C0465i.m1052a(this.f1407b, c0800z.f1407b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f1406a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f1407b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f1406a + ", onCancellation=" + this.f1407b + ')';
    }
}