package p052y0;

import kotlinx.coroutines.internal.C0504o;
import kotlinx.coroutines.internal.C0520z;
import p048w0.C0755m;
import p048w0.C0771q0;

/* renamed from: y0.j */
/* loaded from: classes.dex */
public final class C0828j<E> extends AbstractC0837s implements InterfaceC0835q<E> {

    /* renamed from: g */
    public final Throwable f1450g;

    @Override // p052y0.AbstractC0837s
    /* renamed from: A */
    public C0520z mo182A(C0504o.C0506b c0506b) {
        return C0755m.f1345a;
    }

    @Override // p052y0.InterfaceC0835q
    /* renamed from: C */
    public C0828j<E> mo186e() {
        return this;
    }

    @Override // p052y0.AbstractC0837s
    /* renamed from: D */
    public C0828j<E> mo179z() {
        return this;
    }

    /* renamed from: E */
    public final Throwable m196E() {
        Throwable th = this.f1450g;
        return th == null ? new C0829k("Channel was closed") : th;
    }

    /* renamed from: F */
    public final Throwable m195F() {
        Throwable th = this.f1450g;
        return th == null ? new C0830l("Channel was closed") : th;
    }

    @Override // p052y0.InterfaceC0835q
    /* renamed from: d */
    public void mo187d(E e) {
    }

    @Override // p052y0.InterfaceC0835q
    /* renamed from: h */
    public C0520z mo185h(E e, C0504o.C0506b c0506b) {
        return C0755m.f1345a;
    }

    @Override // kotlinx.coroutines.internal.C0504o
    public String toString() {
        return "Closed@" + C0771q0.m391b(this) + '[' + this.f1450g + ']';
    }

    @Override // p052y0.AbstractC0837s
    /* renamed from: y */
    public void mo180y() {
    }
}