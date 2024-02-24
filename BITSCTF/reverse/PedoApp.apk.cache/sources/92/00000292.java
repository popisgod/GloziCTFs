package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.C0461e;
import p020i0.InterfaceC0249g;
import p048w0.AbstractC0725f1;
import p048w0.RunnableC0774r0;

/* renamed from: kotlinx.coroutines.scheduling.c */
/* loaded from: classes.dex */
public class C0527c extends AbstractC0725f1 {

    /* renamed from: f */
    private final int f1087f;

    /* renamed from: g */
    private final int f1088g;

    /* renamed from: h */
    private final long f1089h;

    /* renamed from: i */
    private final String f1090i;

    /* renamed from: j */
    private ExecutorC0521a f1091j;

    public C0527c(int i, int i2, long j, String str) {
        this.f1087f = i;
        this.f1088g = i2;
        this.f1089h = j;
        this.f1090i = str;
        this.f1091j = m835q();
    }

    public C0527c(int i, int i2, String str) {
        this(i, i2, C0536l.f1108e, str);
    }

    public /* synthetic */ C0527c(int i, int i2, String str, int i3, C0461e c0461e) {
        this((i3 & 1) != 0 ? C0536l.f1106c : i, (i3 & 2) != 0 ? C0536l.f1107d : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    /* renamed from: q */
    private final ExecutorC0521a m835q() {
        return new ExecutorC0521a(this.f1087f, this.f1088g, this.f1089h, this.f1090i);
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: o */
    public void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        try {
            ExecutorC0521a.m871f(this.f1091j, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            RunnableC0774r0.f1365j.mo242o(interfaceC0249g, runnable);
        }
    }

    /* renamed from: r */
    public final void m834r(Runnable runnable, InterfaceC0534j interfaceC0534j, boolean z) {
        try {
            this.f1091j.m872e(runnable, interfaceC0534j, z);
        } catch (RejectedExecutionException unused) {
            RunnableC0774r0.f1365j.m505G(this.f1091j.m874c(runnable, interfaceC0534j));
        }
    }
}