package p048w0;

import kotlin.coroutines.jvm.internal.InterfaceC0447e;
import kotlin.jvm.internal.C0465i;
import kotlinx.coroutines.internal.C0479d0;
import kotlinx.coroutines.internal.C0487g;
import kotlinx.coroutines.internal.C0519y;
import kotlinx.coroutines.scheduling.AbstractRunnableC0533i;
import kotlinx.coroutines.scheduling.InterfaceC0534j;
import p014f0.C0152b;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p020i0.InterfaceC0249g;

/* renamed from: w0.t0 */
/* loaded from: classes.dex */
public abstract class AbstractC0780t0<T> extends AbstractRunnableC0533i {

    /* renamed from: f */
    public int f1370f;

    public AbstractC0780t0(int i) {
        this.f1370f = i;
    }

    /* renamed from: a */
    public void mo375a(Object obj, Throwable th) {
    }

    /* renamed from: b */
    public abstract InterfaceC0244d<T> mo374b();

    /* renamed from: c */
    public Throwable mo373c(Object obj) {
        C0797y c0797y = obj instanceof C0797y ? (C0797y) obj : null;
        if (c0797y == null) {
            return null;
        }
        return c0797y.f1404a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public <T> T mo372d(Object obj) {
        return obj;
    }

    /* renamed from: e */
    public final void m371e(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            C0152b.m2017a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        C0465i.m1051b(th);
        C0734h0.m457a(mo374b().getContext(), new C0763o0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    /* renamed from: f */
    public abstract Object mo370f();

    @Override // java.lang.Runnable
    public final void run() {
        Object m2010a;
        Object m2010a2;
        Object m2010a3;
        if (C0768p0.m398a()) {
            if (!(this.f1370f != -1)) {
                throw new AssertionError();
            }
        }
        InterfaceC0534j interfaceC0534j = this.f1102e;
        try {
            C0487g c0487g = (C0487g) mo374b();
            InterfaceC0244d<T> interfaceC0244d = c0487g.f1007h;
            Object obj = c0487g.f1009j;
            InterfaceC0249g context = interfaceC0244d.getContext();
            Object m996c = C0479d0.m996c(context, obj);
            C0736h2<?> m473e = m996c != C0479d0.f995a ? C0718e0.m473e(interfaceC0244d, context, m996c) : null;
            InterfaceC0249g context2 = interfaceC0244d.getContext();
            Object mo370f = mo370f();
            Throwable mo373c = mo373c(mo370f);
            InterfaceC0764o1 interfaceC0764o1 = (mo373c == null && C0783u0.m363b(this.f1370f)) ? (InterfaceC0764o1) context2.get(InterfaceC0764o1.f1356c) : null;
            if (interfaceC0764o1 != null && !interfaceC0764o1.mo322a()) {
                Throwable mo307l = interfaceC0764o1.mo307l();
                mo375a(mo370f, mo307l);
                C0161k.C0162a c0162a = C0161k.f229d;
                if (C0768p0.m395d() && (interfaceC0244d instanceof InterfaceC0447e)) {
                    mo307l = C0519y.m881j(mo307l, (InterfaceC0447e) interfaceC0244d);
                }
                m2010a2 = C0161k.m2010a(C0164l.m2006a(mo307l));
            } else if (mo373c != null) {
                C0161k.C0162a c0162a2 = C0161k.f229d;
                m2010a2 = C0161k.m2010a(C0164l.m2006a(mo373c));
            } else {
                T mo372d = mo372d(mo370f);
                C0161k.C0162a c0162a3 = C0161k.f229d;
                m2010a2 = C0161k.m2010a(mo372d);
            }
            interfaceC0244d.resumeWith(m2010a2);
            C0169q c0169q = C0169q.f235a;
            if (m473e == null || m473e.m454y0()) {
                C0479d0.m998a(context, m996c);
            }
            try {
                C0161k.C0162a c0162a4 = C0161k.f229d;
                interfaceC0534j.mo830k();
                m2010a3 = C0161k.m2010a(c0169q);
            } catch (Throwable th) {
                C0161k.C0162a c0162a5 = C0161k.f229d;
                m2010a3 = C0161k.m2010a(C0164l.m2006a(th));
            }
            m371e(null, C0161k.m2009b(m2010a3));
        } catch (Throwable th2) {
            try {
                C0161k.C0162a c0162a6 = C0161k.f229d;
                interfaceC0534j.mo830k();
                m2010a = C0161k.m2010a(C0169q.f235a);
            } catch (Throwable th3) {
                C0161k.C0162a c0162a7 = C0161k.f229d;
                m2010a = C0161k.m2010a(C0164l.m2006a(th3));
            }
            m371e(th2, C0161k.m2009b(m2010a));
        }
    }
}