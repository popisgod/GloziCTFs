package androidx.window.java.layout;

import kotlin.coroutines.jvm.internal.AbstractC0454k;
import kotlin.coroutines.jvm.internal.InterfaceC0448f;
import p014f0.C0164l;
import p014f0.C0169q;
import p015g.InterfaceC0170a;
import p020i0.InterfaceC0244d;
import p022j0.C0437d;
import p034p0.InterfaceC0615p;
import p048w0.InterfaceC0753l0;
import p054z0.InterfaceC0909b;
import p054z0.InterfaceC0910c;

/* JADX INFO: Access modifiers changed from: package-private */
@InterfaceC0448f(m1071c = "androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1", m1070f = "WindowInfoTrackerCallbackAdapter.kt", m1069l = {96}, m1068m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WindowInfoTrackerCallbackAdapter$addListener$1$1 extends AbstractC0454k implements InterfaceC0615p<InterfaceC0753l0, InterfaceC0244d<? super C0169q>, Object> {
    final /* synthetic */ InterfaceC0170a<T> $consumer;
    final /* synthetic */ InterfaceC0909b<T> $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WindowInfoTrackerCallbackAdapter$addListener$1$1(InterfaceC0909b<? extends T> interfaceC0909b, InterfaceC0170a<T> interfaceC0170a, InterfaceC0244d<? super WindowInfoTrackerCallbackAdapter$addListener$1$1> interfaceC0244d) {
        super(2, interfaceC0244d);
        this.$flow = interfaceC0909b;
        this.$consumer = interfaceC0170a;
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
    public final InterfaceC0244d<C0169q> create(Object obj, InterfaceC0244d<?> interfaceC0244d) {
        return new WindowInfoTrackerCallbackAdapter$addListener$1$1(this.$flow, this.$consumer, interfaceC0244d);
    }

    @Override // p034p0.InterfaceC0615p
    public final Object invoke(InterfaceC0753l0 interfaceC0753l0, InterfaceC0244d<? super C0169q> interfaceC0244d) {
        return ((WindowInfoTrackerCallbackAdapter$addListener$1$1) create(interfaceC0753l0, interfaceC0244d)).invokeSuspend(C0169q.f235a);
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
    public final Object invokeSuspend(Object obj) {
        Object m1077c;
        m1077c = C0437d.m1077c();
        int i = this.label;
        if (i == 0) {
            C0164l.m2005b(obj);
            InterfaceC0909b<T> interfaceC0909b = this.$flow;
            final InterfaceC0170a<T> interfaceC0170a = this.$consumer;
            Object obj2 = new InterfaceC0910c<T>() { // from class: androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1
                @Override // p054z0.InterfaceC0910c
                public Object emit(T t, InterfaceC0244d<? super C0169q> interfaceC0244d) {
                    interfaceC0170a.accept(t);
                    return C0169q.f235a;
                }
            };
            this.label = 1;
            if (interfaceC0909b.mo3a(obj2, this) == m1077c) {
                return m1077c;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            C0164l.m2005b(obj);
        }
        return C0169q.f235a;
    }
}