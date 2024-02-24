package p014f0;

import kotlin.jvm.internal.C0465i;
import p014f0.C0161k;

/* renamed from: f0.l */
/* loaded from: classes.dex */
public final class C0164l {
    /* renamed from: a */
    public static final Object m2006a(Throwable exception) {
        C0465i.m1048e(exception, "exception");
        return new C0161k.C0163b(exception);
    }

    /* renamed from: b */
    public static final void m2005b(Object obj) {
        if (obj instanceof C0161k.C0163b) {
            throw ((C0161k.C0163b) obj).f230d;
        }
    }
}