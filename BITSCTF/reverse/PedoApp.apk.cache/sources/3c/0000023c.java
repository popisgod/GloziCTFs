package kotlin.coroutines.jvm.internal;

import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;

/* renamed from: kotlin.coroutines.jvm.internal.c */
/* loaded from: classes.dex */
public final class C0445c implements InterfaceC0244d<Object> {

    /* renamed from: d */
    public static final C0445c f966d = new C0445c();

    private C0445c() {
    }

    @Override // p020i0.InterfaceC0244d
    public InterfaceC0249g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // p020i0.InterfaceC0244d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}