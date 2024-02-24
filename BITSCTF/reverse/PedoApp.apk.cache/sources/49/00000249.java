package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p014f0.C0160j;
import p014f0.C0166n;
import p014f0.InterfaceC0153c;
import p016g0.C0187i;
import p016g0.C0188j;
import p016g0.C0203y;
import p016g0.C0204z;
import p032o0.C0577a;
import p034p0.InterfaceC0600a;
import p034p0.InterfaceC0601b;
import p034p0.InterfaceC0602c;
import p034p0.InterfaceC0603d;
import p034p0.InterfaceC0604e;
import p034p0.InterfaceC0605f;
import p034p0.InterfaceC0606g;
import p034p0.InterfaceC0607h;
import p034p0.InterfaceC0608i;
import p034p0.InterfaceC0609j;
import p034p0.InterfaceC0610k;
import p034p0.InterfaceC0611l;
import p034p0.InterfaceC0612m;
import p034p0.InterfaceC0613n;
import p034p0.InterfaceC0614o;
import p034p0.InterfaceC0615p;
import p034p0.InterfaceC0616q;
import p034p0.InterfaceC0617r;
import p034p0.InterfaceC0618s;
import p034p0.InterfaceC0619t;
import p034p0.InterfaceC0620u;
import p034p0.InterfaceC0621v;
import p034p0.InterfaceC0622w;
import p042t0.InterfaceC0654c;
import p046v0.C0692n;

/* renamed from: kotlin.jvm.internal.c */
/* loaded from: classes.dex */
public final class C0458c implements InterfaceC0654c<Object>, InterfaceC0457b {

    /* renamed from: e */
    public static final C0459a f974e = new C0459a(null);

    /* renamed from: f */
    private static final Map<Class<? extends InterfaceC0153c<?>>, Integer> f975f;

    /* renamed from: g */
    private static final HashMap<String, String> f976g;

    /* renamed from: h */
    private static final HashMap<String, String> f977h;

    /* renamed from: i */
    private static final HashMap<String, String> f978i;

    /* renamed from: j */
    private static final Map<String, String> f979j;

    /* renamed from: d */
    private final Class<?> f980d;

    /* renamed from: kotlin.jvm.internal.c$a */
    /* loaded from: classes.dex */
    public static final class C0459a {
        private C0459a() {
        }

        public /* synthetic */ C0459a(C0461e c0461e) {
            this();
        }

        /* renamed from: a */
        public final String m1055a(Class<?> jClass) {
            String str;
            Method enclosingMethod;
            String m536S;
            String m535T;
            String m535T2;
            C0465i.m1048e(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    if (jClass.getEnclosingMethod() != null) {
                        C0465i.m1049d(name, "name");
                        m535T2 = C0692n.m535T(name, enclosingMethod.getName() + '$', null, 2, null);
                        if (m535T2 != null) {
                            return m535T2;
                        }
                    }
                    Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                    C0465i.m1049d(name, "name");
                    if (enclosingConstructor == null) {
                        m536S = C0692n.m536S(name, '$', null, 2, null);
                        return m536S;
                    }
                    m535T = C0692n.m535T(name, enclosingConstructor.getName() + '$', null, 2, null);
                    return m535T;
                } else if (!jClass.isArray()) {
                    String str3 = (String) C0458c.f979j.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                } else {
                    Class<?> componentType = jClass.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) C0458c.f979j.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                }
            }
            return str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List m1961d;
        int m1958g;
        Map<Class<? extends InterfaceC0153c<?>>, Integer> m1920g;
        int m1926a;
        String m533V;
        String m533V2;
        int i = 0;
        m1961d = C0187i.m1961d(InterfaceC0600a.class, InterfaceC0611l.class, InterfaceC0615p.class, InterfaceC0616q.class, InterfaceC0617r.class, InterfaceC0618s.class, InterfaceC0619t.class, InterfaceC0620u.class, InterfaceC0621v.class, InterfaceC0622w.class, InterfaceC0601b.class, InterfaceC0602c.class, InterfaceC0603d.class, InterfaceC0604e.class, InterfaceC0605f.class, InterfaceC0606g.class, InterfaceC0607h.class, InterfaceC0608i.class, InterfaceC0609j.class, InterfaceC0610k.class, InterfaceC0612m.class, InterfaceC0613n.class, InterfaceC0614o.class);
        m1958g = C0188j.m1958g(m1961d, 10);
        ArrayList arrayList = new ArrayList(m1958g);
        for (Object obj : m1961d) {
            int i2 = i + 1;
            if (i < 0) {
                C0187i.m1959f();
            }
            arrayList.add(C0166n.m2003a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        m1920g = C0204z.m1920g(arrayList);
        f975f = m1920g;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f976g = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f977h = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        C0465i.m1049d(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            C0465i.m1049d(kotlinName, "kotlinName");
            m533V2 = C0692n.m533V(kotlinName, '.', null, 2, null);
            sb.append(m533V2);
            sb.append("CompanionObject");
            C0160j m2003a = C0166n.m2003a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(m2003a.m2012c(), m2003a.m2011d());
        }
        for (Map.Entry<Class<? extends InterfaceC0153c<?>>, Integer> entry : f975f.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        f978i = hashMap3;
        m1926a = C0203y.m1926a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(m1926a);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            m533V = C0692n.m533V((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, m533V);
        }
        f979j = linkedHashMap;
    }

    public C0458c(Class<?> jClass) {
        C0465i.m1048e(jClass, "jClass");
        this.f980d = jClass;
    }

    @Override // p042t0.InterfaceC0654c
    /* renamed from: a */
    public String mo633a() {
        return f974e.m1055a(mo1037b());
    }

    @Override // kotlin.jvm.internal.InterfaceC0457b
    /* renamed from: b */
    public Class<?> mo1037b() {
        return this.f980d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0458c) && C0465i.m1052a(C0577a.m734a(this), C0577a.m734a((InterfaceC0654c) obj));
    }

    public int hashCode() {
        return C0577a.m734a(this).hashCode();
    }

    public String toString() {
        return mo1037b().toString() + " (Kotlin reflection is not available)";
    }
}