package p014f0;

import java.io.Serializable;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p034p0.InterfaceC0600a;

/* renamed from: f0.m */
/* loaded from: classes.dex */
final class C0165m<T> implements InterfaceC0155e<T>, Serializable {

    /* renamed from: d */
    private InterfaceC0600a<? extends T> f231d;

    /* renamed from: e */
    private volatile Object f232e;

    /* renamed from: f */
    private final Object f233f;

    public C0165m(InterfaceC0600a<? extends T> initializer, Object obj) {
        C0465i.m1048e(initializer, "initializer");
        this.f231d = initializer;
        this.f232e = C0167o.f234a;
        this.f233f = obj == null ? this : obj;
    }

    public /* synthetic */ C0165m(InterfaceC0600a interfaceC0600a, Object obj, int i, C0461e c0461e) {
        this(interfaceC0600a, (i & 2) != 0 ? null : obj);
    }

    /* renamed from: a */
    public boolean m2004a() {
        return this.f232e != C0167o.f234a;
    }

    @Override // p014f0.InterfaceC0155e
    public T getValue() {
        T t;
        T t2 = (T) this.f232e;
        C0167o c0167o = C0167o.f234a;
        if (t2 != c0167o) {
            return t2;
        }
        synchronized (this.f233f) {
            t = (T) this.f232e;
            if (t == c0167o) {
                InterfaceC0600a<? extends T> interfaceC0600a = this.f231d;
                C0465i.m1051b(interfaceC0600a);
                t = interfaceC0600a.invoke();
                this.f232e = t;
                this.f231d = null;
            }
        }
        return t;
    }

    public String toString() {
        return m2004a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}