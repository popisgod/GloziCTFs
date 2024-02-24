package p048w0;

import java.util.concurrent.Executor;

/* renamed from: w0.h1 */
/* loaded from: classes.dex */
public final class C0735h1 {
    /* renamed from: a */
    public static final AbstractC0722f0 m455a(Executor executor) {
        ExecutorC0786v0 executorC0786v0 = executor instanceof ExecutorC0786v0 ? (ExecutorC0786v0) executor : null;
        return executorC0786v0 == null ? new C0731g1(executor) : executorC0786v0.f1376d;
    }
}