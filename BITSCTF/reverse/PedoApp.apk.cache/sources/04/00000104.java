package p013f;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import p015g.C0172c;

/* renamed from: f.a */
/* loaded from: classes.dex */
public final class C0149a {

    /* renamed from: f.a$a */
    /* loaded from: classes.dex */
    private static class ExecutorC0150a implements Executor {

        /* renamed from: d */
        private final Handler f226d;

        ExecutorC0150a(Handler handler) {
            this.f226d = (Handler) C0172c.m2000a(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f226d.post((Runnable) C0172c.m2000a(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f226d + " is shutting down");
        }
    }

    /* renamed from: a */
    public static Executor m2019a(Handler handler) {
        return new ExecutorC0150a(handler);
    }
}