package p010d0;

import java.util.ArrayList;
import p001a0.C0008a;
import p001a0.C0045r;
import p001a0.InterfaceC0016c;
import p001a0.InterfaceC0031i;
import p010d0.C0124a;

/* renamed from: d0.i */
/* loaded from: classes.dex */
public final /* synthetic */ class C0135i {
    /* renamed from: a */
    public static /* synthetic */ void m2077a(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        m2066l(interfaceC0126b, obj, interfaceC0014e);
    }

    /* renamed from: b */
    public static /* synthetic */ void m2076b(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        m2063o(interfaceC0126b, obj, interfaceC0014e);
    }

    /* renamed from: c */
    public static /* synthetic */ void m2075c(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        m2064n(interfaceC0126b, obj, interfaceC0014e);
    }

    /* renamed from: d */
    public static /* synthetic */ void m2074d(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        m2069i(interfaceC0126b, obj, interfaceC0014e);
    }

    /* renamed from: e */
    public static /* synthetic */ void m2073e(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        m2067k(interfaceC0126b, obj, interfaceC0014e);
    }

    /* renamed from: f */
    public static /* synthetic */ void m2072f(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        m2065m(interfaceC0126b, obj, interfaceC0014e);
    }

    /* renamed from: g */
    public static /* synthetic */ void m2071g(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        m2068j(interfaceC0126b, obj, interfaceC0014e);
    }

    /* renamed from: h */
    public static InterfaceC0031i<Object> m2070h() {
        return new C0045r();
    }

    /* renamed from: i */
    public static /* synthetic */ void m2069i(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, interfaceC0126b.mo2059c());
        } catch (Throwable th) {
            arrayList = C0124a.m2078a(th);
        }
        interfaceC0014e.mo56a(arrayList);
    }

    /* renamed from: j */
    public static /* synthetic */ void m2068j(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, interfaceC0126b.mo2056f());
        } catch (Throwable th) {
            arrayList = C0124a.m2078a(th);
        }
        interfaceC0014e.mo56a(arrayList);
    }

    /* renamed from: k */
    public static /* synthetic */ void m2067k(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, interfaceC0126b.mo2057e());
        } catch (Throwable th) {
            arrayList = C0124a.m2078a(th);
        }
        interfaceC0014e.mo56a(arrayList);
    }

    /* renamed from: l */
    public static /* synthetic */ void m2066l(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, interfaceC0126b.mo2058d());
        } catch (Throwable th) {
            arrayList = C0124a.m2078a(th);
        }
        interfaceC0014e.mo56a(arrayList);
    }

    /* renamed from: m */
    public static /* synthetic */ void m2065m(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, interfaceC0126b.mo2060b());
        } catch (Throwable th) {
            arrayList = C0124a.m2078a(th);
        }
        interfaceC0014e.mo56a(arrayList);
    }

    /* renamed from: n */
    public static /* synthetic */ void m2064n(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, interfaceC0126b.mo2055h());
        } catch (Throwable th) {
            arrayList = C0124a.m2078a(th);
        }
        interfaceC0014e.mo56a(arrayList);
    }

    /* renamed from: o */
    public static /* synthetic */ void m2063o(C0124a.InterfaceC0126b interfaceC0126b, Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, interfaceC0126b.mo2061a(arrayList2.get(0) == null ? null : C0124a.EnumC0127c.values()[((Integer) arrayList2.get(0)).intValue()]));
        } catch (Throwable th) {
            arrayList = C0124a.m2078a(th);
        }
        interfaceC0014e.mo56a(arrayList);
    }

    /* renamed from: p */
    public static void m2062p(InterfaceC0016c interfaceC0016c, final C0124a.InterfaceC0126b interfaceC0126b) {
        C0008a c0008a = new C0008a(interfaceC0016c, "dev.flutter.pigeon.PathProviderApi.getTemporaryPath", m2070h(), interfaceC0016c.mo720b());
        if (interfaceC0126b != null) {
            c0008a.m2288e(new C0008a.InterfaceC0013d() { // from class: d0.e
                @Override // p001a0.C0008a.InterfaceC0013d
                /* renamed from: a */
                public final void mo170a(Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
                    C0135i.m2074d(C0124a.InterfaceC0126b.this, obj, interfaceC0014e);
                }
            });
        } else {
            c0008a.m2288e(null);
        }
        C0008a c0008a2 = new C0008a(interfaceC0016c, "dev.flutter.pigeon.PathProviderApi.getApplicationSupportPath", m2070h(), interfaceC0016c.mo720b());
        if (interfaceC0126b != null) {
            c0008a2.m2288e(new C0008a.InterfaceC0013d() { // from class: d0.h
                @Override // p001a0.C0008a.InterfaceC0013d
                /* renamed from: a */
                public final void mo170a(Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
                    C0135i.m2071g(C0124a.InterfaceC0126b.this, obj, interfaceC0014e);
                }
            });
        } else {
            c0008a2.m2288e(null);
        }
        C0008a c0008a3 = new C0008a(interfaceC0016c, "dev.flutter.pigeon.PathProviderApi.getApplicationDocumentsPath", m2070h(), interfaceC0016c.mo720b());
        if (interfaceC0126b != null) {
            c0008a3.m2288e(new C0008a.InterfaceC0013d() { // from class: d0.f
                @Override // p001a0.C0008a.InterfaceC0013d
                /* renamed from: a */
                public final void mo170a(Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
                    C0135i.m2073e(C0124a.InterfaceC0126b.this, obj, interfaceC0014e);
                }
            });
        } else {
            c0008a3.m2288e(null);
        }
        C0008a c0008a4 = new C0008a(interfaceC0016c, "dev.flutter.pigeon.PathProviderApi.getApplicationCachePath", m2070h(), interfaceC0016c.mo720b());
        if (interfaceC0126b != null) {
            c0008a4.m2288e(new C0008a.InterfaceC0013d() { // from class: d0.b
                @Override // p001a0.C0008a.InterfaceC0013d
                /* renamed from: a */
                public final void mo170a(Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
                    C0135i.m2077a(C0124a.InterfaceC0126b.this, obj, interfaceC0014e);
                }
            });
        } else {
            c0008a4.m2288e(null);
        }
        C0008a c0008a5 = new C0008a(interfaceC0016c, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePath", m2070h(), interfaceC0016c.mo720b());
        if (interfaceC0126b != null) {
            c0008a5.m2288e(new C0008a.InterfaceC0013d() { // from class: d0.g
                @Override // p001a0.C0008a.InterfaceC0013d
                /* renamed from: a */
                public final void mo170a(Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
                    C0135i.m2072f(C0124a.InterfaceC0126b.this, obj, interfaceC0014e);
                }
            });
        } else {
            c0008a5.m2288e(null);
        }
        C0008a c0008a6 = new C0008a(interfaceC0016c, "dev.flutter.pigeon.PathProviderApi.getExternalCachePaths", m2070h(), interfaceC0016c.mo720b());
        if (interfaceC0126b != null) {
            c0008a6.m2288e(new C0008a.InterfaceC0013d() { // from class: d0.d
                @Override // p001a0.C0008a.InterfaceC0013d
                /* renamed from: a */
                public final void mo170a(Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
                    C0135i.m2075c(C0124a.InterfaceC0126b.this, obj, interfaceC0014e);
                }
            });
        } else {
            c0008a6.m2288e(null);
        }
        C0008a c0008a7 = new C0008a(interfaceC0016c, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePaths", m2070h(), interfaceC0016c.mo720b());
        if (interfaceC0126b != null) {
            c0008a7.m2288e(new C0008a.InterfaceC0013d() { // from class: d0.c
                @Override // p001a0.C0008a.InterfaceC0013d
                /* renamed from: a */
                public final void mo170a(Object obj, C0008a.InterfaceC0014e interfaceC0014e) {
                    C0135i.m2076b(C0124a.InterfaceC0126b.this, obj, interfaceC0014e);
                }
            });
        } else {
            c0008a7.m2288e(null);
        }
    }
}