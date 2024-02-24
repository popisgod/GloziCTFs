package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0465i;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p016g0.C0181e;
import p018h0.C0236b;
import p032o0.C0577a;
import p034p0.InterfaceC0611l;
import p048w0.InterfaceC0714d0;

/* renamed from: kotlinx.coroutines.internal.i */
/* loaded from: classes.dex */
public final class C0491i {

    /* renamed from: a */
    private static final int f1016a = m963d(Throwable.class, -1);

    /* renamed from: b */
    private static final ReentrantReadWriteLock f1017b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private static final WeakHashMap<Class<? extends Throwable>, InterfaceC0611l<Throwable, Throwable>> f1018c = new WeakHashMap<>();

    /* renamed from: kotlinx.coroutines.internal.i$a */
    /* loaded from: classes.dex */
    public static final class C0492a extends AbstractC0466j implements InterfaceC0611l<Throwable, Throwable> {

        /* renamed from: d */
        final /* synthetic */ Constructor f1019d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0492a(Constructor constructor) {
            super(1);
            this.f1019d = constructor;
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object m2010a;
            Object newInstance;
            try {
                C0161k.C0162a c0162a = C0161k.f229d;
                newInstance = this.f1019d.newInstance(th.getMessage(), th);
            } catch (Throwable th2) {
                C0161k.C0162a c0162a2 = C0161k.f229d;
                m2010a = C0161k.m2010a(C0164l.m2006a(th2));
            }
            if (newInstance != null) {
                m2010a = C0161k.m2010a((Throwable) newInstance);
                if (C0161k.m2008c(m2010a)) {
                    m2010a = null;
                }
                return (Throwable) m2010a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* renamed from: kotlinx.coroutines.internal.i$b */
    /* loaded from: classes.dex */
    public static final class C0493b extends AbstractC0466j implements InterfaceC0611l<Throwable, Throwable> {

        /* renamed from: d */
        final /* synthetic */ Constructor f1020d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0493b(Constructor constructor) {
            super(1);
            this.f1020d = constructor;
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object m2010a;
            Object newInstance;
            try {
                C0161k.C0162a c0162a = C0161k.f229d;
                newInstance = this.f1020d.newInstance(th);
            } catch (Throwable th2) {
                C0161k.C0162a c0162a2 = C0161k.f229d;
                m2010a = C0161k.m2010a(C0164l.m2006a(th2));
            }
            if (newInstance != null) {
                m2010a = C0161k.m2010a((Throwable) newInstance);
                if (C0161k.m2008c(m2010a)) {
                    m2010a = null;
                }
                return (Throwable) m2010a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* renamed from: kotlinx.coroutines.internal.i$c */
    /* loaded from: classes.dex */
    public static final class C0494c extends AbstractC0466j implements InterfaceC0611l<Throwable, Throwable> {

        /* renamed from: d */
        final /* synthetic */ Constructor f1021d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0494c(Constructor constructor) {
            super(1);
            this.f1021d = constructor;
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object m2010a;
            Object newInstance;
            try {
                C0161k.C0162a c0162a = C0161k.f229d;
                newInstance = this.f1021d.newInstance(th.getMessage());
            } catch (Throwable th2) {
                C0161k.C0162a c0162a2 = C0161k.f229d;
                m2010a = C0161k.m2010a(C0164l.m2006a(th2));
            }
            if (newInstance != null) {
                Throwable th3 = (Throwable) newInstance;
                th3.initCause(th);
                m2010a = C0161k.m2010a(th3);
                if (C0161k.m2008c(m2010a)) {
                    m2010a = null;
                }
                return (Throwable) m2010a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* renamed from: kotlinx.coroutines.internal.i$d */
    /* loaded from: classes.dex */
    public static final class C0495d extends AbstractC0466j implements InterfaceC0611l<Throwable, Throwable> {

        /* renamed from: d */
        final /* synthetic */ Constructor f1022d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0495d(Constructor constructor) {
            super(1);
            this.f1022d = constructor;
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final Throwable invoke(Throwable th) {
            Object m2010a;
            Object newInstance;
            try {
                C0161k.C0162a c0162a = C0161k.f229d;
                newInstance = this.f1022d.newInstance(new Object[0]);
            } catch (Throwable th2) {
                C0161k.C0162a c0162a2 = C0161k.f229d;
                m2010a = C0161k.m2010a(C0164l.m2006a(th2));
            }
            if (newInstance != null) {
                Throwable th3 = (Throwable) newInstance;
                th3.initCause(th);
                m2010a = C0161k.m2010a(th3);
                if (C0161k.m2008c(m2010a)) {
                    m2010a = null;
                }
                return (Throwable) m2010a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    /* renamed from: kotlinx.coroutines.internal.i$e */
    /* loaded from: classes.dex */
    public static final class C0496e<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m1833a;
            m1833a = C0236b.m1833a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            return m1833a;
        }
    }

    /* renamed from: kotlinx.coroutines.internal.i$f */
    /* loaded from: classes.dex */
    static final class C0497f extends AbstractC0466j implements InterfaceC0611l {

        /* renamed from: d */
        public static final C0497f f1023d = new C0497f();

        C0497f() {
            super(1);
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    /* renamed from: kotlinx.coroutines.internal.i$g */
    /* loaded from: classes.dex */
    static final class C0498g extends AbstractC0466j implements InterfaceC0611l {

        /* renamed from: d */
        public static final C0498g f1024d = new C0498g();

        C0498g() {
            super(1);
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final Void invoke(Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private static final InterfaceC0611l<Throwable, Throwable> m966a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && C0465i.m1052a(parameterTypes[0], String.class) && C0465i.m1052a(parameterTypes[1], Throwable.class)) {
                    return new C0492a(constructor);
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (C0465i.m1052a(cls, Throwable.class)) {
                return new C0493b(constructor);
            }
            if (C0465i.m1052a(cls, String.class)) {
                return new C0494c(constructor);
            }
            return null;
        }
        return new C0495d(constructor);
    }

    /* renamed from: b */
    private static final int m965b(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m964c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m965b(cls, i);
    }

    /* renamed from: d */
    private static final int m963d(Class<?> cls, int i) {
        Integer m2010a;
        C0577a.m733b(cls);
        try {
            C0161k.C0162a c0162a = C0161k.f229d;
            m2010a = C0161k.m2010a(Integer.valueOf(m964c(cls, 0, 1, null)));
        } catch (Throwable th) {
            C0161k.C0162a c0162a2 = C0161k.f229d;
            m2010a = C0161k.m2010a(C0164l.m2006a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (C0161k.m2008c(m2010a)) {
            m2010a = valueOf;
        }
        return ((Number) m2010a).intValue();
    }

    /* renamed from: e */
    public static final <E extends Throwable> E m962e(E e) {
        Object m2010a;
        List m1981j;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e instanceof InterfaceC0714d0) {
            try {
                C0161k.C0162a c0162a = C0161k.f229d;
                m2010a = C0161k.m2010a(((InterfaceC0714d0) e).mo394a());
            } catch (Throwable th) {
                C0161k.C0162a c0162a2 = C0161k.f229d;
                m2010a = C0161k.m2010a(C0164l.m2006a(th));
            }
            return (E) (C0161k.m2008c(m2010a) ? null : m2010a);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f1017b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            InterfaceC0611l<Throwable, Throwable> interfaceC0611l = f1018c.get(e.getClass());
            if (interfaceC0611l == null) {
                int i = 0;
                if (f1016a != m963d(e.getClass(), 0)) {
                    readLock = reentrantReadWriteLock.readLock();
                    readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                    for (int i2 = 0; i2 < readHoldCount; i2++) {
                        readLock.unlock();
                    }
                    writeLock = reentrantReadWriteLock.writeLock();
                    writeLock.lock();
                    try {
                        f1018c.put(e.getClass(), C0497f.f1023d);
                        C0169q c0169q = C0169q.f235a;
                        return null;
                    } finally {
                        while (i < readHoldCount) {
                            readLock.lock();
                            i++;
                        }
                        writeLock.unlock();
                    }
                }
                m1981j = C0181e.m1981j(e.getClass().getConstructors(), new C0496e());
                Iterator it = m1981j.iterator();
                InterfaceC0611l<Throwable, Throwable> interfaceC0611l2 = null;
                while (it.hasNext() && (interfaceC0611l2 = m966a((Constructor) it.next())) == null) {
                }
                ReentrantReadWriteLock reentrantReadWriteLock2 = f1017b;
                readLock = reentrantReadWriteLock2.readLock();
                readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
                for (int i3 = 0; i3 < readHoldCount; i3++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock2.writeLock();
                writeLock.lock();
                try {
                    f1018c.put(e.getClass(), interfaceC0611l2 == null ? C0498g.f1024d : interfaceC0611l2);
                    C0169q c0169q2 = C0169q.f235a;
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                    if (interfaceC0611l2 == null) {
                        return null;
                    }
                    return (E) interfaceC0611l2.invoke(e);
                } finally {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            return (E) interfaceC0611l.invoke(e);
        } finally {
            readLock2.unlock();
        }
    }
}