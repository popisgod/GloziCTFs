package kotlinx.coroutines.internal;

import kotlin.jvm.internal.C0465i;
import p020i0.InterfaceC0249g;
import p048w0.InterfaceC0720e2;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: kotlinx.coroutines.internal.g0 */
/* loaded from: classes.dex */
public final class C0488g0 {

    /* renamed from: a */
    public final InterfaceC0249g f1010a;

    /* renamed from: b */
    private final Object[] f1011b;

    /* renamed from: c */
    private final InterfaceC0720e2<Object>[] f1012c;

    /* renamed from: d */
    private int f1013d;

    public C0488g0(InterfaceC0249g interfaceC0249g, int i) {
        this.f1010a = interfaceC0249g;
        this.f1011b = new Object[i];
        this.f1012c = new InterfaceC0720e2[i];
    }

    /* renamed from: a */
    public final void m971a(InterfaceC0720e2<?> interfaceC0720e2, Object obj) {
        Object[] objArr = this.f1011b;
        int i = this.f1013d;
        objArr[i] = obj;
        InterfaceC0720e2<Object>[] interfaceC0720e2Arr = this.f1012c;
        this.f1013d = i + 1;
        interfaceC0720e2Arr[i] = interfaceC0720e2;
    }

    /* renamed from: b */
    public final void m970b(InterfaceC0249g interfaceC0249g) {
        int length = this.f1012c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            InterfaceC0720e2<Object> interfaceC0720e2 = this.f1012c[length];
            C0465i.m1051b(interfaceC0720e2);
            interfaceC0720e2.mo450e(interfaceC0249g, this.f1011b[length]);
            if (i < 0) {
                return;
            }
            length = i;
        }
    }
}