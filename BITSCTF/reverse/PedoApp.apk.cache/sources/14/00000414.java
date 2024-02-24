package p054z0;

import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p022j0.C0437d;
import p034p0.InterfaceC0615p;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: z0.f */
/* loaded from: classes.dex */
public final class C0913f<T> extends AbstractC0907a<T> {

    /* renamed from: a */
    private final InterfaceC0615p<InterfaceC0910c<? super T>, InterfaceC0244d<? super C0169q>, Object> f1666a;

    /* JADX WARN: Multi-variable type inference failed */
    public C0913f(InterfaceC0615p<? super InterfaceC0910c<? super T>, ? super InterfaceC0244d<? super C0169q>, ? extends Object> interfaceC0615p) {
        this.f1666a = interfaceC0615p;
    }

    @Override // p054z0.AbstractC0907a
    /* renamed from: b */
    public Object mo0b(InterfaceC0910c<? super T> interfaceC0910c, InterfaceC0244d<? super C0169q> interfaceC0244d) {
        Object m1077c;
        Object invoke = this.f1666a.invoke(interfaceC0910c, interfaceC0244d);
        m1077c = C0437d.m1077c();
        return invoke == m1077c ? invoke : C0169q.f235a;
    }
}