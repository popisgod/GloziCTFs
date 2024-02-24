package p025l;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p001a0.C0032j;
import p001a0.C0033k;
import p025l.C0538a;
import p025l.C0552n;
import p025l.C0557p;

/* renamed from: l.l */
/* loaded from: classes.dex */
final class C0550l implements C0033k.InterfaceC0037c {

    /* renamed from: a */
    private final Context f1124a;

    /* renamed from: b */
    private final C0538a f1125b;

    /* renamed from: c */
    private final C0552n f1126c;

    /* renamed from: d */
    private final C0557p f1127d;

    public C0550l(Context context, C0538a c0538a, C0552n c0552n, C0557p c0557p) {
        this.f1124a = context;
        this.f1125b = c0538a;
        this.f1126c = c0552n;
        this.f1127d = c0557p;
    }

    /* renamed from: b */
    public static /* synthetic */ void m813b(C0033k.InterfaceC0038d interfaceC0038d, String str, String str2) {
        interfaceC0038d.mo66a(str, str2, null);
    }

    /* renamed from: c */
    public static /* synthetic */ void m812c(C0033k.InterfaceC0038d interfaceC0038d, String str, String str2) {
        interfaceC0038d.mo66a(str, str2, null);
    }

    /* renamed from: d */
    public static /* synthetic */ void m811d(C0033k.InterfaceC0038d interfaceC0038d, String str, String str2) {
        interfaceC0038d.mo66a(str, str2, null);
    }

    /* renamed from: e */
    public static /* synthetic */ void m810e(C0033k.InterfaceC0038d interfaceC0038d, String str, String str2) {
        interfaceC0038d.mo66a(str, str2, null);
    }

    @Override // p001a0.C0033k.InterfaceC0037c
    /* renamed from: a */
    public void mo24a(C0032j c0032j, final C0033k.InterfaceC0038d interfaceC0038d) {
        String str = c0032j.f38a;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1544053025:
                if (str.equals("checkServiceStatus")) {
                    c = 0;
                    break;
                }
                break;
            case -1017315255:
                if (str.equals("shouldShowRequestPermissionRationale")) {
                    c = 1;
                    break;
                }
                break;
            case -576207927:
                if (str.equals("checkPermissionStatus")) {
                    c = 2;
                    break;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c = 3;
                    break;
                }
                break;
            case 1669188213:
                if (str.equals("requestPermissions")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                int parseInt = Integer.parseInt(c0032j.f39b.toString());
                C0557p c0557p = this.f1127d;
                Context context = this.f1124a;
                Objects.requireNonNull(interfaceC0038d);
                c0557p.m773a(parseInt, context, new C0557p.InterfaceC0558a() { // from class: l.k
                    @Override // p025l.C0557p.InterfaceC0558a
                    /* renamed from: a */
                    public final void mo767a(int i) {
                        C0033k.InterfaceC0038d.this.mo65b(Integer.valueOf(i));
                    }
                }, new InterfaceC0540b() { // from class: l.e
                    @Override // p025l.InterfaceC0540b
                    /* renamed from: a */
                    public final void mo814a(String str2, String str3) {
                        C0550l.m812c(C0033k.InterfaceC0038d.this, str2, str3);
                    }
                });
                return;
            case 1:
                int parseInt2 = Integer.parseInt(c0032j.f39b.toString());
                C0552n c0552n = this.f1126c;
                Objects.requireNonNull(interfaceC0038d);
                c0552n.m789k(parseInt2, new C0552n.InterfaceC0555c() { // from class: l.j
                    @Override // p025l.C0552n.InterfaceC0555c
                    /* renamed from: a */
                    public final void mo786a(boolean z) {
                        C0033k.InterfaceC0038d.this.mo65b(Boolean.valueOf(z));
                    }
                }, new InterfaceC0540b() { // from class: l.g
                    @Override // p025l.InterfaceC0540b
                    /* renamed from: a */
                    public final void mo814a(String str2, String str3) {
                        C0550l.m810e(C0033k.InterfaceC0038d.this, str2, str3);
                    }
                });
                return;
            case 2:
                int parseInt3 = Integer.parseInt(c0032j.f39b.toString());
                C0552n c0552n2 = this.f1126c;
                Objects.requireNonNull(interfaceC0038d);
                c0552n2.m795e(parseInt3, new C0552n.InterfaceC0553a() { // from class: l.h
                    @Override // p025l.C0552n.InterfaceC0553a
                    /* renamed from: a */
                    public final void mo788a(int i) {
                        C0033k.InterfaceC0038d.this.mo65b(Integer.valueOf(i));
                    }
                });
                return;
            case 3:
                C0538a c0538a = this.f1125b;
                Context context2 = this.f1124a;
                Objects.requireNonNull(interfaceC0038d);
                c0538a.m816a(context2, new C0538a.InterfaceC0539a() { // from class: l.c
                    @Override // p025l.C0538a.InterfaceC0539a
                    /* renamed from: a */
                    public final void mo815a(boolean z) {
                        C0033k.InterfaceC0038d.this.mo65b(Boolean.valueOf(z));
                    }
                }, new InterfaceC0540b() { // from class: l.f
                    @Override // p025l.InterfaceC0540b
                    /* renamed from: a */
                    public final void mo814a(String str2, String str3) {
                        C0550l.m811d(C0033k.InterfaceC0038d.this, str2, str3);
                    }
                });
                return;
            case 4:
                C0552n c0552n3 = this.f1126c;
                Objects.requireNonNull(interfaceC0038d);
                c0552n3.m791i((List) c0032j.m2274a(), new C0552n.InterfaceC0554b() { // from class: l.i
                    @Override // p025l.C0552n.InterfaceC0554b
                    /* renamed from: a */
                    public final void mo787a(Map map) {
                        C0033k.InterfaceC0038d.this.mo65b(map);
                    }
                }, new InterfaceC0540b() { // from class: l.d
                    @Override // p025l.InterfaceC0540b
                    /* renamed from: a */
                    public final void mo814a(String str2, String str3) {
                        C0550l.m813b(C0033k.InterfaceC0038d.this, str2, str3);
                    }
                });
                return;
            default:
                interfaceC0038d.mo64c();
                return;
        }
    }
}