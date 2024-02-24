package kotlinx.coroutines.internal;

import java.util.Objects;
import p016g0.C0179d;

/* renamed from: kotlinx.coroutines.internal.a */
/* loaded from: classes.dex */
public class C0472a<T> {

    /* renamed from: a */
    private Object[] f988a = new Object[16];

    /* renamed from: b */
    private int f989b;

    /* renamed from: c */
    private int f990c;

    /* renamed from: b */
    private final void m1018b() {
        Object[] objArr = this.f988a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        C0179d.m1989c(objArr, objArr2, 0, this.f989b, 0, 10, null);
        Object[] objArr3 = this.f988a;
        int length2 = objArr3.length;
        int i = this.f989b;
        C0179d.m1989c(objArr3, objArr2, length2 - i, 0, i, 4, null);
        this.f988a = objArr2;
        this.f989b = 0;
        this.f990c = length;
    }

    /* renamed from: a */
    public final void m1019a(T t) {
        Object[] objArr = this.f988a;
        int i = this.f990c;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.f990c = length;
        if (length == this.f989b) {
            m1018b();
        }
    }

    /* renamed from: c */
    public final boolean m1017c() {
        return this.f989b == this.f990c;
    }

    /* renamed from: d */
    public final T m1016d() {
        int i = this.f989b;
        if (i == this.f990c) {
            return null;
        }
        Object[] objArr = this.f988a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.f989b = (i + 1) & (objArr.length - 1);
        Objects.requireNonNull(t, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
        return t;
    }
}