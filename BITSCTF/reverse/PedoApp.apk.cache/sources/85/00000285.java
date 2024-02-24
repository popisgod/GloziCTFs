package kotlinx.coroutines.internal;

import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0465i;
import p014f0.C0152b;
import p014f0.C0169q;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0611l;
import p048w0.C0734h0;

/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* renamed from: kotlinx.coroutines.internal.u */
/* loaded from: classes.dex */
public final class C0514u {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: kotlinx.coroutines.internal.u$a */
    /* loaded from: classes.dex */
    public static final class C0515a extends AbstractC0466j implements InterfaceC0611l<Throwable, C0169q> {

        /* renamed from: d */
        final /* synthetic */ InterfaceC0611l<E, C0169q> f1050d;

        /* renamed from: e */
        final /* synthetic */ E f1051e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC0249g f1052f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0515a(InterfaceC0611l<? super E, C0169q> interfaceC0611l, E e, InterfaceC0249g interfaceC0249g) {
            super(1);
            this.f1050d = interfaceC0611l;
            this.f1051e = e;
            this.f1052f = interfaceC0249g;
        }

        /* renamed from: a */
        public final void m895a(Throwable th) {
            C0514u.m898b(this.f1050d, this.f1051e, this.f1052f);
        }

        @Override // p034p0.InterfaceC0611l
        public /* bridge */ /* synthetic */ C0169q invoke(Throwable th) {
            m895a(th);
            return C0169q.f235a;
        }
    }

    /* renamed from: a */
    public static final <E> InterfaceC0611l<Throwable, C0169q> m899a(InterfaceC0611l<? super E, C0169q> interfaceC0611l, E e, InterfaceC0249g interfaceC0249g) {
        return new C0515a(interfaceC0611l, e, interfaceC0249g);
    }

    /* renamed from: b */
    public static final <E> void m898b(InterfaceC0611l<? super E, C0169q> interfaceC0611l, E e, InterfaceC0249g interfaceC0249g) {
        C0490h0 m897c = m897c(interfaceC0611l, e, null);
        if (m897c == null) {
            return;
        }
        C0734h0.m457a(interfaceC0249g, m897c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public static final <E> C0490h0 m897c(InterfaceC0611l<? super E, C0169q> interfaceC0611l, E e, C0490h0 c0490h0) {
        try {
            interfaceC0611l.invoke(e);
        } catch (Throwable th) {
            if (c0490h0 == null || c0490h0.getCause() == th) {
                return new C0490h0(C0465i.m1043j("Exception in undelivered element handler for ", e), th);
            }
            C0152b.m2017a(c0490h0, th);
        }
        return c0490h0;
    }

    /* renamed from: d */
    public static /* synthetic */ C0490h0 m896d(InterfaceC0611l interfaceC0611l, Object obj, C0490h0 c0490h0, int i, Object obj2) {
        if ((i & 2) != 0) {
            c0490h0 = null;
        }
        return m897c(interfaceC0611l, obj, c0490h0);
    }
}