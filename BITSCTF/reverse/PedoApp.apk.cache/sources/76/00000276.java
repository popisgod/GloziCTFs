package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.jvm.internal.C0465i;
import p014f0.C0152b;
import p016g0.C0188j;
import p016g0.C0192n;
import p016g0.C0195q;
import p030n0.C0571a;
import p046v0.C0691m;
import p046v0.C0692n;

/* renamed from: kotlinx.coroutines.internal.j */
/* loaded from: classes.dex */
public final class C0499j {

    /* renamed from: a */
    public static final C0499j f1025a = new C0499j();

    private C0499j() {
    }

    /* renamed from: a */
    private final <S> S m955a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    /* renamed from: b */
    private final <S> List<S> m954b(Class<S> cls, ClassLoader classLoader) {
        List<S> m1948q;
        try {
            return m952d(cls, classLoader);
        } catch (Throwable unused) {
            m1948q = C0195q.m1948q(ServiceLoader.load(cls, classLoader));
            return m1948q;
        }
    }

    /* renamed from: e */
    private final List<String> m951e(URL url) {
        boolean m555o;
        String m535T;
        String m530Y;
        String m535T2;
        String url2 = url.toString();
        m555o = C0691m.m555o(url2, "jar", false, 2, null);
        if (!m555o) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> m950f = f1025a.m950f(bufferedReader);
                C0571a.m750a(bufferedReader, null);
                return m950f;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C0571a.m750a(bufferedReader, th);
                    throw th2;
                }
            }
        }
        m535T = C0692n.m535T(url2, "jar:file:", null, 2, null);
        m530Y = C0692n.m530Y(m535T, '!', null, 2, null);
        m535T2 = C0692n.m535T(url2, "!/", null, 2, null);
        JarFile jarFile = new JarFile(m530Y, false);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(m535T2)), "UTF-8"));
            List<String> m950f2 = f1025a.m950f(bufferedReader2);
            C0571a.m750a(bufferedReader2, null);
            jarFile.close();
            return m950f2;
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                try {
                    jarFile.close();
                    throw th4;
                } catch (Throwable th5) {
                    C0152b.m2017a(th3, th5);
                    throw th3;
                }
            }
        }
    }

    /* renamed from: f */
    private final List<String> m950f(BufferedReader bufferedReader) {
        List<String> m1948q;
        String m529Z;
        CharSequence m528a0;
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                m1948q = C0195q.m1948q(linkedHashSet);
                return m1948q;
            }
            m529Z = C0692n.m529Z(readLine, "#", null, 2, null);
            Objects.requireNonNull(m529Z, "null cannot be cast to non-null type kotlin.CharSequence");
            m528a0 = C0692n.m528a0(m529Z);
            String obj = m528a0.toString();
            int i = 0;
            while (true) {
                if (i >= obj.length()) {
                    z = true;
                    break;
                }
                char charAt = obj.charAt(i);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new IllegalArgumentException(C0465i.m1043j("Illegal service provider class name: ", obj).toString());
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    /* renamed from: c */
    public final List<MainDispatcherFactory> m953c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (C0500k.m949a()) {
            try {
                ArrayList arrayList = new ArrayList(2);
                MainDispatcherFactory mainDispatcherFactory2 = null;
                try {
                    mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException unused) {
                    mainDispatcherFactory = null;
                }
                if (mainDispatcherFactory != null) {
                    arrayList.add(mainDispatcherFactory);
                }
                try {
                    mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException unused2) {
                }
                if (mainDispatcherFactory2 == null) {
                    return arrayList;
                }
                arrayList.add(mainDispatcherFactory2);
                return arrayList;
            } catch (Throwable unused3) {
                return m954b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
            }
        }
        return m954b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    }

    /* renamed from: d */
    public final <S> List<S> m952d(Class<S> cls, ClassLoader classLoader) {
        Set<String> m1945t;
        int m1958g;
        ArrayList<URL> list = Collections.list(classLoader.getResources(C0465i.m1043j("META-INF/services/", cls.getName())));
        C0465i.m1049d(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            C0192n.m1957h(arrayList, f1025a.m951e(url));
        }
        m1945t = C0195q.m1945t(arrayList);
        if (!m1945t.isEmpty()) {
            m1958g = C0188j.m1958g(m1945t, 10);
            ArrayList arrayList2 = new ArrayList(m1958g);
            for (String str : m1945t) {
                arrayList2.add(f1025a.m955a(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}