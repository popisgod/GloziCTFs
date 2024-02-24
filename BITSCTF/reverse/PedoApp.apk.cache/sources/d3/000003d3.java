package p053z;

import java.util.HashMap;
import java.util.Map;
import p001a0.C0032j;
import p001a0.C0033k;
import p001a0.C0047s;
import p001a0.InterfaceC0016c;

/* renamed from: z.e */
/* loaded from: classes.dex */
public class C0848e {

    /* renamed from: a */
    public final C0033k f1467a;

    /* renamed from: b */
    private InterfaceC0850b f1468b;

    /* renamed from: c */
    public final C0033k.InterfaceC0037c f1469c;

    /* renamed from: z.e$a */
    /* loaded from: classes.dex */
    class C0849a implements C0033k.InterfaceC0037c {

        /* renamed from: a */
        Map<Long, Long> f1470a = new HashMap();

        C0849a() {
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            if (C0848e.this.f1468b != null) {
                String str = c0032j.f38a;
                str.hashCode();
                if (!str.equals("getKeyboardState")) {
                    interfaceC0038d.mo64c();
                    return;
                }
                try {
                    this.f1470a = C0848e.this.f1468b.mo153b();
                } catch (IllegalStateException e) {
                    interfaceC0038d.mo66a("error", e.getMessage(), null);
                }
            }
            interfaceC0038d.mo65b(this.f1470a);
        }
    }

    /* renamed from: z.e$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0850b {
        /* renamed from: b */
        Map<Long, Long> mo153b();
    }

    public C0848e(InterfaceC0016c interfaceC0016c) {
        C0849a c0849a = new C0849a();
        this.f1469c = c0849a;
        C0033k c0033k = new C0033k(interfaceC0016c, "flutter/keyboard", C0047s.f53b);
        this.f1467a = c0033k;
        c0033k.m2269e(c0849a);
    }

    /* renamed from: b */
    public void m154b(InterfaceC0850b interfaceC0850b) {
        this.f1468b = interfaceC0850b;
    }
}