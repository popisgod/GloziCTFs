package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p020i0.InterfaceC0249g;
import p048w0.AbstractC0725f1;

/* renamed from: kotlinx.coroutines.scheduling.e */
/* loaded from: classes.dex */
final class ExecutorC0529e extends AbstractC0725f1 implements InterfaceC0534j, Executor {

    /* renamed from: k */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1092k = AtomicIntegerFieldUpdater.newUpdater(ExecutorC0529e.class, "inFlightTasks");

    /* renamed from: f */
    private final C0527c f1093f;

    /* renamed from: g */
    private final int f1094g;

    /* renamed from: h */
    private final String f1095h;

    /* renamed from: i */
    private final int f1096i;

    /* renamed from: j */
    private final ConcurrentLinkedQueue<Runnable> f1097j = new ConcurrentLinkedQueue<>();
    private volatile /* synthetic */ int inFlightTasks = 0;

    public ExecutorC0529e(C0527c c0527c, int i, String str, int i2) {
        this.f1093f = c0527c;
        this.f1094g = i;
        this.f1095h = str;
        this.f1096i = i2;
    }

    /* renamed from: q */
    private final void m833q(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1092k;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f1094g) {
                this.f1093f.m834r(runnable, this, z);
                return;
            }
            this.f1097j.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f1094g) {
                return;
            }
            runnable = this.f1097j.poll();
        } while (runnable != null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m833q(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.InterfaceC0534j
    /* renamed from: g */
    public int mo831g() {
        return this.f1096i;
    }

    @Override // kotlinx.coroutines.scheduling.InterfaceC0534j
    /* renamed from: k */
    public void mo830k() {
        Runnable poll = this.f1097j.poll();
        if (poll != null) {
            this.f1093f.m834r(poll, this, true);
            return;
        }
        f1092k.decrementAndGet(this);
        Runnable poll2 = this.f1097j.poll();
        if (poll2 == null) {
            return;
        }
        m833q(poll2, true);
    }

    @Override // p048w0.AbstractC0722f0
    /* renamed from: o */
    public void mo242o(InterfaceC0249g interfaceC0249g, Runnable runnable) {
        m833q(runnable, false);
    }

    @Override // p048w0.AbstractC0722f0
    public String toString() {
        String str = this.f1095h;
        if (str == null) {
            return super.toString() + "[dispatcher = " + this.f1093f + ']';
        }
        return str;
    }
}