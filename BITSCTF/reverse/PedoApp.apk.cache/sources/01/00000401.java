package p053z;

import java.util.ArrayList;
import p001a0.C0032j;
import p001a0.C0033k;
import p001a0.C0047s;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.o */
/* loaded from: classes.dex */
public class C0894o {

    /* renamed from: a */
    public final C0033k f1610a;

    /* renamed from: b */
    private InterfaceC0896b f1611b;

    /* renamed from: c */
    public final C0033k.InterfaceC0037c f1612c;

    /* renamed from: z.o$a */
    /* loaded from: classes.dex */
    class C0895a implements C0033k.InterfaceC0037c {
        C0895a() {
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            if (C0894o.this.f1611b == null) {
                C0576b.m737f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = c0032j.f38a;
            Object obj = c0032j.f39b;
            C0576b.m737f("SpellCheckChannel", "Received '" + str + "' message.");
            str.hashCode();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                interfaceC0038d.mo64c();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                C0894o.this.f1611b.mo45a((String) arrayList.get(0), (String) arrayList.get(1), interfaceC0038d);
            } catch (IllegalStateException e) {
                interfaceC0038d.mo66a("error", e.getMessage(), null);
            }
        }
    }

    /* renamed from: z.o$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0896b {
        /* renamed from: a */
        void mo45a(String str, String str2, C0033k.InterfaceC0038d interfaceC0038d);
    }

    public C0894o(C0579a c0579a) {
        C0895a c0895a = new C0895a();
        this.f1612c = c0895a;
        C0033k c0033k = new C0033k(c0579a, "flutter/spellcheck", C0047s.f53b);
        this.f1610a = c0033k;
        c0033k.m2269e(c0895a);
    }

    /* renamed from: b */
    public void m46b(InterfaceC0896b interfaceC0896b) {
        this.f1611b = interfaceC0896b;
    }
}