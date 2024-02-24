package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.C0465i;

/* renamed from: kotlin.coroutines.jvm.internal.g */
/* loaded from: classes.dex */
public final class C0449g {
    /* renamed from: a */
    private static final void m1066a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    /* renamed from: b */
    private static final InterfaceC0448f m1065b(AbstractC0443a abstractC0443a) {
        return (InterfaceC0448f) abstractC0443a.getClass().getAnnotation(InterfaceC0448f.class);
    }

    /* renamed from: c */
    private static final int m1064c(AbstractC0443a abstractC0443a) {
        try {
            Field declaredField = abstractC0443a.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC0443a);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: d */
    public static final StackTraceElement m1063d(AbstractC0443a abstractC0443a) {
        String str;
        C0465i.m1048e(abstractC0443a, "<this>");
        InterfaceC0448f m1065b = m1065b(abstractC0443a);
        if (m1065b == null) {
            return null;
        }
        m1066a(1, m1065b.m1067v());
        int m1064c = m1064c(abstractC0443a);
        int i = m1064c < 0 ? -1 : m1065b.m1069l()[m1064c];
        String m1058b = C0451i.f967a.m1058b(abstractC0443a);
        if (m1058b == null) {
            str = m1065b.m1071c();
        } else {
            str = m1058b + '/' + m1065b.m1071c();
        }
        return new StackTraceElement(str, m1065b.m1068m(), m1065b.m1070f(), i);
    }
}