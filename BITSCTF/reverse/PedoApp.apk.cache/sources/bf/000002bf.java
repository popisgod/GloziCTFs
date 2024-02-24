package p031o;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p035q.InterfaceC0623a;
import p037r.C0632d;

/* renamed from: o.a */
/* loaded from: classes.dex */
public final class C0572a {

    /* renamed from: e */
    private static C0572a f1166e;

    /* renamed from: f */
    private static boolean f1167f;

    /* renamed from: a */
    private C0632d f1168a;

    /* renamed from: b */
    private InterfaceC0623a f1169b;

    /* renamed from: c */
    private FlutterJNI.C0312c f1170c;

    /* renamed from: d */
    private ExecutorService f1171d;

    /* renamed from: o.a$b */
    /* loaded from: classes.dex */
    public static final class C0574b {

        /* renamed from: a */
        private C0632d f1172a;

        /* renamed from: b */
        private InterfaceC0623a f1173b;

        /* renamed from: c */
        private FlutterJNI.C0312c f1174c;

        /* renamed from: d */
        private ExecutorService f1175d;

        /* renamed from: o.a$b$a */
        /* loaded from: classes.dex */
        public class ThreadFactoryC0575a implements ThreadFactory {

            /* renamed from: a */
            private int f1176a;

            private ThreadFactoryC0575a() {
                C0574b.this = r1;
                this.f1176a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i = this.f1176a;
                this.f1176a = i + 1;
                sb.append(i);
                thread.setName(sb.toString());
                return thread;
            }
        }

        /* renamed from: b */
        private void m743b() {
            if (this.f1174c == null) {
                this.f1174c = new FlutterJNI.C0312c();
            }
            if (this.f1175d == null) {
                this.f1175d = Executors.newCachedThreadPool(new ThreadFactoryC0575a());
            }
            if (this.f1172a == null) {
                this.f1172a = new C0632d(this.f1174c.m1629a(), this.f1175d);
            }
        }

        /* renamed from: a */
        public C0572a m744a() {
            m743b();
            return new C0572a(this.f1172a, this.f1173b, this.f1174c, this.f1175d);
        }
    }

    private C0572a(C0632d c0632d, InterfaceC0623a interfaceC0623a, FlutterJNI.C0312c c0312c, ExecutorService executorService) {
        this.f1168a = c0632d;
        this.f1169b = interfaceC0623a;
        this.f1170c = c0312c;
        this.f1171d = executorService;
    }

    /* renamed from: e */
    public static C0572a m745e() {
        f1167f = true;
        if (f1166e == null) {
            f1166e = new C0574b().m744a();
        }
        return f1166e;
    }

    /* renamed from: a */
    public InterfaceC0623a m749a() {
        return this.f1169b;
    }

    /* renamed from: b */
    public ExecutorService m748b() {
        return this.f1171d;
    }

    /* renamed from: c */
    public C0632d m747c() {
        return this.f1168a;
    }

    /* renamed from: d */
    public FlutterJNI.C0312c m746d() {
        return this.f1170c;
    }
}