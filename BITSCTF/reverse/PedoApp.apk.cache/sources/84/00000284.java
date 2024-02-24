package kotlinx.coroutines.internal;

import kotlin.jvm.internal.C0465i;
import p014f0.C0154d;
import p020i0.InterfaceC0249g;
import p048w0.AbstractC0799y1;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: kotlinx.coroutines.internal.t */
/* loaded from: classes.dex */
public final class C0513t extends AbstractC0799y1 {

    /* renamed from: e */
    private final Throwable f1048e;

    /* renamed from: f */
    private final String f1049f;

    public C0513t(Throwable th, String str) {
        this.f1048e = th;
        this.f1049f = str;
    }

    /* renamed from: t */
    private final Void m900t() {
        String m1043j;
        if (this.f1048e == null) {
            C0512s.m903c();
            throw new C0154d();
        }
        String str = this.f1049f;
        String str2 = "";
        if (str != null && (m1043j = C0465i.m1043j(". ", str)) != null) {
            str2 = m1043j;
        }
        throw new IllegalStateException(C0465i.m1043j("Module with the Main dispatcher had failed to initialize", str2), this.f1048e);
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: p */
    public boolean mo241p(InterfaceC0249g interfaceC0249g) {
        m900t();
        throw new C0154d();
    }

    @Override // p048w0.AbstractC0799y1
    /* renamed from: q */
    public AbstractC0799y1 mo240q() {
        return this;
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: s */
    public Void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        m900t();
        throw new C0154d();
    }

    @Override // p048w0.AbstractC0799y1, p048w0.AbstractC0722f0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.f1048e;
        sb.append(th != null ? C0465i.m1043j(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }
}