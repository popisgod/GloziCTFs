package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import kotlin.jvm.internal.C0465i;
import p014f0.C0160j;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0166n;
import p046v0.C0691m;
import p048w0.C0768p0;
import p048w0.InterfaceC0714d0;

/* renamed from: kotlinx.coroutines.internal.y */
/* loaded from: classes.dex */
public final class C0519y {

    /* renamed from: a */
    private static final String f1055a;

    /* renamed from: b */
    private static final String f1056b;

    static {
        Object m2010a;
        Object m2010a2;
        try {
            C0161k.C0162a c0162a = C0161k.f229d;
            m2010a = C0161k.m2010a(Class.forName("kotlin.coroutines.jvm.internal.a").getCanonicalName());
        } catch (Throwable th) {
            C0161k.C0162a c0162a2 = C0161k.f229d;
            m2010a = C0161k.m2010a(C0164l.m2006a(th));
        }
        if (C0161k.m2009b(m2010a) != null) {
            m2010a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f1055a = (String) m2010a;
        try {
            C0161k.C0162a c0162a3 = C0161k.f229d;
            m2010a2 = C0161k.m2010a(C0519y.class.getCanonicalName());
        } catch (Throwable th2) {
            C0161k.C0162a c0162a4 = C0161k.f229d;
            m2010a2 = C0161k.m2010a(C0164l.m2006a(th2));
        }
        if (C0161k.m2009b(m2010a2) != null) {
            m2010a2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f1056b = (String) m2010a2;
    }

    /* renamed from: a */
    public static final /* synthetic */ Throwable m890a(Throwable th, InterfaceC0447e interfaceC0447e) {
        return m881j(th, interfaceC0447e);
    }

    /* renamed from: b */
    public static final StackTraceElement m889b(String str) {
        return new StackTraceElement(C0465i.m1043j("\b\b\b(", str), "\b", "\b", -1);
    }

    /* renamed from: c */
    private static final <E extends Throwable> C0160j<E, StackTraceElement[]> m888c(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !C0465i.m1052a(cause.getClass(), e.getClass())) {
            return C0166n.m2003a(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (m883h(stackTrace[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return z ? C0166n.m2003a(cause, stackTrace) : C0166n.m2003a(e, new StackTraceElement[0]);
    }

    /* renamed from: d */
    private static final <E extends Throwable> E m887d(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(m889b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int m884g = m884g(stackTrace, f1055a);
        int i = 0;
        if (m884g == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e2.setStackTrace((StackTraceElement[]) array);
            return e2;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + m884g];
        if (m884g > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                stackTraceElementArr[i2] = stackTrace[i2];
                if (i3 >= m884g) {
                    break;
                }
                i2 = i3;
            }
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i4 = i + 1;
            stackTraceElementArr[i + m884g] = it.next();
            i = i4;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    /* renamed from: e */
    private static final ArrayDeque<StackTraceElement> m886e(InterfaceC0447e interfaceC0447e) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = interfaceC0447e.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            interfaceC0447e = interfaceC0447e.getCallerFrame();
            if (interfaceC0447e == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = interfaceC0447e.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    /* renamed from: f */
    private static final boolean m885f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && C0465i.m1052a(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && C0465i.m1052a(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && C0465i.m1052a(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    /* renamed from: g */
    private static final int m884g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (C0465i.m1052a(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: h */
    public static final boolean m883h(StackTraceElement stackTraceElement) {
        boolean m555o;
        m555o = C0691m.m555o(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return m555o;
    }

    /* renamed from: i */
    private static final void m882i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (m883h(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i2 > length2) {
            return;
        }
        while (true) {
            int i3 = length2 - 1;
            if (m885f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            }
            length2 = i3;
        }
    }

    /* renamed from: j */
    public static final <E extends Throwable> E m881j(E e, InterfaceC0447e interfaceC0447e) {
        C0160j m888c = m888c(e);
        Throwable th = (Throwable) m888c.m2014a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m888c.m2013b();
        Throwable m878m = m878m(th);
        if (m878m == null) {
            return e;
        }
        ArrayDeque<StackTraceElement> m886e = m886e(interfaceC0447e);
        if (m886e.isEmpty()) {
            return e;
        }
        if (th != e) {
            m882i(stackTraceElementArr, m886e);
        }
        return (E) m887d(th, m878m, m886e);
    }

    /* renamed from: k */
    public static final <E extends Throwable> E m880k(E e) {
        Throwable m878m;
        return (C0768p0.m395d() && (m878m = m878m(e)) != null) ? (E) m879l(m878m) : e;
    }

    /* renamed from: l */
    private static final <E extends Throwable> E m879l(E e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int m884g = m884g(stackTrace, f1056b);
        int i = m884g + 1;
        int m884g2 = m884g(stackTrace, f1055a);
        int i2 = 0;
        int i3 = (length - m884g) - (m884g2 == -1 ? 0 : length - m884g2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i3];
        while (i2 < i3) {
            stackTraceElementArr[i2] = i2 == 0 ? m889b("Coroutine boundary") : stackTrace[(i + i2) - 1];
            i2++;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    /* renamed from: m */
    private static final <E extends Throwable> E m878m(E e) {
        E e2 = (E) C0491i.m962e(e);
        if (e2 == null) {
            return null;
        }
        if ((e instanceof InterfaceC0714d0) || C0465i.m1052a(e2.getMessage(), e.getMessage())) {
            return e2;
        }
        return null;
    }

    /* renamed from: n */
    public static final <E extends Throwable> E m877n(E e) {
        E e2 = (E) e.getCause();
        if (e2 != null && C0465i.m1052a(e2.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (m883h(stackTrace[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return e2;
            }
        }
        return e;
    }
}