package p048w0;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.C0465i;

/* renamed from: w0.p1 */
/* loaded from: classes.dex */
public final class C0769p1 extends CancellationException implements InterfaceC0714d0<C0769p1> {

    /* renamed from: d */
    public final InterfaceC0764o1 f1363d;

    public C0769p1(String str, Throwable th, InterfaceC0764o1 interfaceC0764o1) {
        super(str);
        this.f1363d = interfaceC0764o1;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // p048w0.InterfaceC0714d0
    /* renamed from: b */
    public C0769p1 mo394a() {
        if (C0768p0.m396c()) {
            String message = getMessage();
            C0465i.m1051b(message);
            return new C0769p1(message, this, this.f1363d);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C0769p1) {
                C0769p1 c0769p1 = (C0769p1) obj;
                if (!C0465i.m1052a(c0769p1.getMessage(), getMessage()) || !C0465i.m1052a(c0769p1.f1363d, this.f1363d) || !C0465i.m1052a(c0769p1.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (C0768p0.m396c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        C0465i.m1051b(message);
        int hashCode = ((message.hashCode() * 31) + this.f1363d.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f1363d;
    }
}