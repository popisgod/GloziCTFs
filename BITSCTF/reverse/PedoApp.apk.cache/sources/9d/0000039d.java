package p048w0;

import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p034p0.InterfaceC0611l;

/* renamed from: w0.x */
/* loaded from: classes.dex */
final class C0794x {

    /* renamed from: a */
    public final Object f1397a;

    /* renamed from: b */
    public final AbstractC0737i f1398b;

    /* renamed from: c */
    public final InterfaceC0611l<Throwable, C0169q> f1399c;

    /* renamed from: d */
    public final Object f1400d;

    /* renamed from: e */
    public final Throwable f1401e;

    /* JADX WARN: Multi-variable type inference failed */
    public C0794x(Object obj, AbstractC0737i abstractC0737i, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l, Object obj2, Throwable th) {
        this.f1397a = obj;
        this.f1398b = abstractC0737i;
        this.f1399c = interfaceC0611l;
        this.f1400d = obj2;
        this.f1401e = th;
    }

    public /* synthetic */ C0794x(Object obj, AbstractC0737i abstractC0737i, InterfaceC0611l interfaceC0611l, Object obj2, Throwable th, int i, C0461e c0461e) {
        this(obj, (i & 2) != 0 ? null : abstractC0737i, (i & 4) != 0 ? null : interfaceC0611l, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    /* renamed from: b */
    public static /* synthetic */ C0794x m265b(C0794x c0794x, Object obj, AbstractC0737i abstractC0737i, InterfaceC0611l interfaceC0611l, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = c0794x.f1397a;
        }
        if ((i & 2) != 0) {
            abstractC0737i = c0794x.f1398b;
        }
        AbstractC0737i abstractC0737i2 = abstractC0737i;
        InterfaceC0611l<Throwable, C0169q> interfaceC0611l2 = interfaceC0611l;
        if ((i & 4) != 0) {
            interfaceC0611l2 = c0794x.f1399c;
        }
        InterfaceC0611l interfaceC0611l3 = interfaceC0611l2;
        if ((i & 8) != 0) {
            obj2 = c0794x.f1400d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = c0794x.f1401e;
        }
        return c0794x.m266a(obj, abstractC0737i2, interfaceC0611l3, obj4, th);
    }

    /* renamed from: a */
    public final C0794x m266a(Object obj, AbstractC0737i abstractC0737i, InterfaceC0611l<? super Throwable, C0169q> interfaceC0611l, Object obj2, Throwable th) {
        return new C0794x(obj, abstractC0737i, interfaceC0611l, obj2, th);
    }

    /* renamed from: c */
    public final boolean m264c() {
        return this.f1401e != null;
    }

    /* renamed from: d */
    public final void m263d(C0752l<?> c0752l, Throwable th) {
        AbstractC0737i abstractC0737i = this.f1398b;
        if (abstractC0737i != null) {
            c0752l.m428j(abstractC0737i, th);
        }
        InterfaceC0611l<Throwable, C0169q> interfaceC0611l = this.f1399c;
        if (interfaceC0611l == null) {
            return;
        }
        c0752l.m426l(interfaceC0611l, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0794x) {
            C0794x c0794x = (C0794x) obj;
            return C0465i.m1052a(this.f1397a, c0794x.f1397a) && C0465i.m1052a(this.f1398b, c0794x.f1398b) && C0465i.m1052a(this.f1399c, c0794x.f1399c) && C0465i.m1052a(this.f1400d, c0794x.f1400d) && C0465i.m1052a(this.f1401e, c0794x.f1401e);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f1397a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC0737i abstractC0737i = this.f1398b;
        int hashCode2 = (hashCode + (abstractC0737i == null ? 0 : abstractC0737i.hashCode())) * 31;
        InterfaceC0611l<Throwable, C0169q> interfaceC0611l = this.f1399c;
        int hashCode3 = (hashCode2 + (interfaceC0611l == null ? 0 : interfaceC0611l.hashCode())) * 31;
        Object obj2 = this.f1400d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f1401e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f1397a + ", cancelHandler=" + this.f1398b + ", onCancellation=" + this.f1399c + ", idempotentResume=" + this.f1400d + ", cancelCause=" + this.f1401e + ')';
    }
}