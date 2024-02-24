package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.jvm.internal.C0465i;
import p014f0.C0161k;
import p014f0.C0164l;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p022j0.C0437d;

/* renamed from: kotlin.coroutines.jvm.internal.a */
/* loaded from: classes.dex */
public abstract class AbstractC0443a implements InterfaceC0244d<Object>, InterfaceC0447e, Serializable {
    private final InterfaceC0244d<Object> completion;

    public AbstractC0443a(InterfaceC0244d<Object> interfaceC0244d) {
        this.completion = interfaceC0244d;
    }

    public InterfaceC0244d<C0169q> create(InterfaceC0244d<?> completion) {
        C0465i.m1048e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public InterfaceC0244d<C0169q> create(Object obj, InterfaceC0244d<?> completion) {
        C0465i.m1048e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public InterfaceC0447e getCallerFrame() {
        InterfaceC0244d<Object> interfaceC0244d = this.completion;
        if (interfaceC0244d instanceof InterfaceC0447e) {
            return (InterfaceC0447e) interfaceC0244d;
        }
        return null;
    }

    public final InterfaceC0244d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return C0449g.m1063d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p020i0.InterfaceC0244d
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object m1077c;
        InterfaceC0244d interfaceC0244d = this;
        while (true) {
            C0450h.m1061b(interfaceC0244d);
            AbstractC0443a abstractC0443a = (AbstractC0443a) interfaceC0244d;
            InterfaceC0244d interfaceC0244d2 = abstractC0443a.completion;
            C0465i.m1051b(interfaceC0244d2);
            try {
                invokeSuspend = abstractC0443a.invokeSuspend(obj);
                m1077c = C0437d.m1077c();
            } catch (Throwable th) {
                C0161k.C0162a c0162a = C0161k.f229d;
                obj = C0161k.m2010a(C0164l.m2006a(th));
            }
            if (invokeSuspend == m1077c) {
                return;
            }
            C0161k.C0162a c0162a2 = C0161k.f229d;
            obj = C0161k.m2010a(invokeSuspend);
            abstractC0443a.releaseIntercepted();
            if (!(interfaceC0244d2 instanceof AbstractC0443a)) {
                interfaceC0244d2.resumeWith(obj);
                return;
            }
            interfaceC0244d = interfaceC0244d2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}