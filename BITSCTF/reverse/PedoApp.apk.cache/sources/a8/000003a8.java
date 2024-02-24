package p050x0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p020i0.InterfaceC0249g;
import p048w0.C0778s1;
import p048w0.C0792w0;

/* renamed from: x0.a */
/* loaded from: classes.dex */
public final class C0805a extends AbstractC0806b {
    private volatile C0805a _immediate;

    /* renamed from: e */
    private final Handler f1411e;

    /* renamed from: f */
    private final String f1412f;

    /* renamed from: g */
    private final boolean f1413g;

    /* renamed from: h */
    private final C0805a f1414h;

    public C0805a(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ C0805a(Handler handler, String str, int i, C0461e c0461e) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    private C0805a(Handler handler, String str, boolean z) {
        super(null);
        this.f1411e = handler;
        this.f1412f = str;
        this.f1413g = z;
        this._immediate = z ? this : null;
        C0805a c0805a = this._immediate;
        if (c0805a == null) {
            c0805a = new C0805a(handler, str, true);
            this._immediate = c0805a;
            C0169q c0169q = C0169q.f235a;
        }
        this.f1414h = c0805a;
    }

    /* renamed from: s */
    private final void m239s(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        C0778s1.m378c(interfaceC0249g, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C0792w0.m275b().mo242o(interfaceC0249g, runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0805a) && ((C0805a) obj).f1411e == this.f1411e;
    }

    public int hashCode() {
        return System.identityHashCode(this.f1411e);
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: o */
    public void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        if (this.f1411e.post(runnable)) {
            return;
        }
        m239s(interfaceC0249g, runnable);
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: p */
    public boolean mo241p(InterfaceC0249g interfaceC0249g) {
        return (this.f1413g && C0465i.m1052a(Looper.myLooper(), this.f1411e.getLooper())) ? false : true;
    }

    @Override // p048w0.AbstractC0799y1
    /* renamed from: t */
    public C0805a mo240q() {
        return this.f1414h;
    }

    @Override // p048w0.AbstractC0799y1, p048w0.AbstractC0722f0
    public String toString() {
        String m258r = m258r();
        if (m258r == null) {
            String str = this.f1412f;
            if (str == null) {
                str = this.f1411e.toString();
            }
            return this.f1413g ? C0465i.m1043j(str, ".immediate") : str;
        }
        return m258r;
    }
}