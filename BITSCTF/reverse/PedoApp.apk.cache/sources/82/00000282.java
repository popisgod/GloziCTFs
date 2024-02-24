package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import p044u0.C0668f;
import p044u0.C0671h;
import p044u0.InterfaceC0664b;
import p048w0.AbstractC0799y1;

/* renamed from: kotlinx.coroutines.internal.r */
/* loaded from: classes.dex */
public final class C0511r {

    /* renamed from: a */
    public static final C0511r f1044a;

    /* renamed from: b */
    private static final boolean f1045b;

    /* renamed from: c */
    public static final AbstractC0799y1 f1046c;

    static {
        C0511r c0511r = new C0511r();
        f1044a = c0511r;
        f1045b = C0473a0.m1011e("kotlinx.coroutines.fast.service.loader", true);
        f1046c = c0511r.m906a();
    }

    private C0511r() {
    }

    /* renamed from: a */
    private final AbstractC0799y1 m906a() {
        InterfaceC0664b m608a;
        List<MainDispatcherFactory> m604e;
        Object next;
        try {
            if (f1045b) {
                m604e = C0499j.f1025a.m953c();
            } else {
                m608a = C0668f.m608a(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                m604e = C0671h.m604e(m608a);
            }
            Iterator<T> it = m604e.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return mainDispatcherFactory == null ? C0512s.m904b(null, null, 3, null) : C0512s.m902d(mainDispatcherFactory, m604e);
        } catch (Throwable th) {
            return C0512s.m904b(th, null, 2, null);
        }
    }
}