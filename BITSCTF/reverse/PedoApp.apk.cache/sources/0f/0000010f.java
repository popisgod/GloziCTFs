package p014f0;

import java.io.Serializable;
import kotlin.jvm.internal.C0465i;

/* renamed from: f0.j */
/* loaded from: classes.dex */
public final class C0160j<A, B> implements Serializable {

    /* renamed from: d */
    private final A f227d;

    /* renamed from: e */
    private final B f228e;

    public C0160j(A a, B b) {
        this.f227d = a;
        this.f228e = b;
    }

    /* renamed from: a */
    public final A m2014a() {
        return this.f227d;
    }

    /* renamed from: b */
    public final B m2013b() {
        return this.f228e;
    }

    /* renamed from: c */
    public final A m2012c() {
        return this.f227d;
    }

    /* renamed from: d */
    public final B m2011d() {
        return this.f228e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0160j) {
            C0160j c0160j = (C0160j) obj;
            return C0465i.m1052a(this.f227d, c0160j.f227d) && C0465i.m1052a(this.f228e, c0160j.f228e);
        }
        return false;
    }

    public int hashCode() {
        A a = this.f227d;
        int hashCode = (a == null ? 0 : a.hashCode()) * 31;
        B b = this.f228e;
        return hashCode + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f227d + ", " + this.f228e + ')';
    }
}