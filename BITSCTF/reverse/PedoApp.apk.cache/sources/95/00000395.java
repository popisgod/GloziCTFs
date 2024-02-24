package p048w0;

import java.util.concurrent.Executor;
import p020i0.C0255h;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: w0.v0 */
/* loaded from: classes.dex */
public final class ExecutorC0786v0 implements Executor {

    /* renamed from: d */
    public final AbstractC0722f0 f1376d;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1376d.mo242o(C0255h.f301d, runnable);
    }

    public String toString() {
        return this.f1376d.toString();
    }
}