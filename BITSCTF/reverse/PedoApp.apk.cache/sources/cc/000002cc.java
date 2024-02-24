package p033p;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p001a0.C0015b;
import p001a0.InterfaceC0016c;
import p012e0.C0143e;
import p031o.C0572a;
import p031o.C0576b;
import p033p.C0585c;

/* renamed from: p.c */
/* loaded from: classes.dex */
public class C0585c implements InterfaceC0016c, InterfaceC0598f {

    /* renamed from: a */
    private final FlutterJNI f1197a;

    /* renamed from: b */
    private final Map<String, C0591f> f1198b;

    /* renamed from: c */
    private Map<String, List<C0587b>> f1199c;

    /* renamed from: d */
    private final Object f1200d;

    /* renamed from: e */
    private final AtomicBoolean f1201e;

    /* renamed from: f */
    private final Map<Integer, InterfaceC0016c.InterfaceC0018b> f1202f;

    /* renamed from: g */
    private int f1203g;

    /* renamed from: h */
    private final InterfaceC0589d f1204h;

    /* renamed from: i */
    private WeakHashMap<InterfaceC0016c.InterfaceC0019c, InterfaceC0589d> f1205i;

    /* renamed from: j */
    private InterfaceC0594i f1206j;

    /* renamed from: p.c$b */
    /* loaded from: classes.dex */
    public static class C0587b {

        /* renamed from: a */
        public final ByteBuffer f1207a;

        /* renamed from: b */
        int f1208b;

        /* renamed from: c */
        long f1209c;

        C0587b(ByteBuffer byteBuffer, int i, long j) {
            this.f1207a = byteBuffer;
            this.f1208b = i;
            this.f1209c = j;
        }
    }

    /* renamed from: p.c$c */
    /* loaded from: classes.dex */
    static class C0588c implements InterfaceC0589d {

        /* renamed from: a */
        private final ExecutorService f1210a;

        C0588c(ExecutorService executorService) {
            this.f1210a = executorService;
        }

        @Override // p033p.C0585c.InterfaceC0589d
        /* renamed from: a */
        public void mo701a(Runnable runnable) {
            this.f1210a.execute(runnable);
        }
    }

    /* renamed from: p.c$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0589d {
        /* renamed from: a */
        void mo701a(Runnable runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p.c$e */
    /* loaded from: classes.dex */
    public static class C0590e implements InterfaceC0594i {

        /* renamed from: a */
        ExecutorService f1211a = C0572a.m745e().m748b();

        C0590e() {
        }

        @Override // p033p.C0585c.InterfaceC0594i
        /* renamed from: a */
        public InterfaceC0589d mo704a(InterfaceC0016c.C0020d c0020d) {
            return c0020d.m2286a() ? new C0593h(this.f1211a) : new C0588c(this.f1211a);
        }
    }

    /* renamed from: p.c$f */
    /* loaded from: classes.dex */
    public static class C0591f {

        /* renamed from: a */
        public final InterfaceC0016c.InterfaceC0017a f1212a;

        /* renamed from: b */
        public final InterfaceC0589d f1213b;

        C0591f(InterfaceC0016c.InterfaceC0017a interfaceC0017a, InterfaceC0589d interfaceC0589d) {
            this.f1212a = interfaceC0017a;
            this.f1213b = interfaceC0589d;
        }
    }

    /* renamed from: p.c$g */
    /* loaded from: classes.dex */
    public static class C0592g implements InterfaceC0016c.InterfaceC0018b {

        /* renamed from: a */
        private final FlutterJNI f1214a;

        /* renamed from: b */
        private final int f1215b;

        /* renamed from: c */
        private final AtomicBoolean f1216c = new AtomicBoolean(false);

        C0592g(FlutterJNI flutterJNI, int i) {
            this.f1214a = flutterJNI;
            this.f1215b = i;
        }

        @Override // p001a0.InterfaceC0016c.InterfaceC0018b
        /* renamed from: a */
        public void mo710a(ByteBuffer byteBuffer) {
            if (this.f1216c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f1214a.invokePlatformMessageEmptyResponseCallback(this.f1215b);
            } else {
                this.f1214a.invokePlatformMessageResponseCallback(this.f1215b, byteBuffer, byteBuffer.position());
            }
        }
    }

    /* renamed from: p.c$h */
    /* loaded from: classes.dex */
    public static class C0593h implements InterfaceC0589d {

        /* renamed from: a */
        private final ExecutorService f1217a;

        /* renamed from: b */
        private final ConcurrentLinkedQueue<Runnable> f1218b = new ConcurrentLinkedQueue<>();

        /* renamed from: c */
        private final AtomicBoolean f1219c = new AtomicBoolean(false);

        C0593h(ExecutorService executorService) {
            this.f1217a = executorService;
        }

        /* renamed from: b */
        public static /* synthetic */ void m709b(C0593h c0593h) {
            c0593h.m706e();
        }

        /* renamed from: c */
        public static /* synthetic */ void m708c(C0593h c0593h) {
            c0593h.m705f();
        }

        /* renamed from: d */
        public void m705f() {
            if (this.f1219c.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.f1218b.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.f1219c.set(false);
                    if (!this.f1218b.isEmpty()) {
                        this.f1217a.execute(new Runnable() { // from class: p.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                C0585c.C0593h.m708c(C0585c.C0593h.this);
                            }
                        });
                    }
                }
            }
        }

        @Override // p033p.C0585c.InterfaceC0589d
        /* renamed from: a */
        public void mo701a(Runnable runnable) {
            this.f1218b.add(runnable);
            this.f1217a.execute(new Runnable() { // from class: p.d
                @Override // java.lang.Runnable
                public final void run() {
                    C0585c.C0593h.m709b(C0585c.C0593h.this);
                }
            });
        }
    }

    /* renamed from: p.c$i */
    /* loaded from: classes.dex */
    public interface InterfaceC0594i {
        /* renamed from: a */
        InterfaceC0589d mo704a(InterfaceC0016c.C0020d c0020d);
    }

    /* renamed from: p.c$j */
    /* loaded from: classes.dex */
    public static class C0595j implements InterfaceC0016c.InterfaceC0019c {
        private C0595j() {
        }
    }

    public C0585c(FlutterJNI flutterJNI) {
        this(flutterJNI, new C0590e());
    }

    C0585c(FlutterJNI flutterJNI, InterfaceC0594i interfaceC0594i) {
        this.f1198b = new HashMap();
        this.f1199c = new HashMap();
        this.f1200d = new Object();
        this.f1201e = new AtomicBoolean(false);
        this.f1202f = new HashMap();
        this.f1203g = 1;
        this.f1204h = new C0599g();
        this.f1205i = new WeakHashMap<>();
        this.f1197a = flutterJNI;
        this.f1206j = interfaceC0594i;
    }

    /* renamed from: i */
    public static /* synthetic */ void m715i(C0585c c0585c, String str, int i, C0591f c0591f, ByteBuffer byteBuffer, long j) {
        c0585c.m711m(str, i, c0591f, byteBuffer, j);
    }

    /* renamed from: j */
    private void m714j(final String str, final C0591f c0591f, final ByteBuffer byteBuffer, final int i, final long j) {
        InterfaceC0589d interfaceC0589d = c0591f != null ? c0591f.f1213b : null;
        C0143e.m2034b("PlatformChannel ScheduleHandler on " + str, i);
        Runnable runnable = new Runnable() { // from class: p.b
            @Override // java.lang.Runnable
            public final void run() {
                C0585c.m715i(C0585c.this, str, i, c0591f, byteBuffer, j);
            }
        };
        if (interfaceC0589d == null) {
            interfaceC0589d = this.f1204h;
        }
        interfaceC0589d.mo701a(runnable);
    }

    /* renamed from: k */
    private static void m713k(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    /* renamed from: l */
    private void m712l(C0591f c0591f, ByteBuffer byteBuffer, int i) {
        if (c0591f != null) {
            try {
                C0576b.m737f("DartMessenger", "Deferring to registered handler to process message.");
                c0591f.f1212a.mo724a(byteBuffer, new C0592g(this.f1197a, i));
                return;
            } catch (Error e) {
                m713k(e);
                return;
            } catch (Exception e2) {
                C0576b.m740c("DartMessenger", "Uncaught exception in binary message listener", e2);
            }
        } else {
            C0576b.m737f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f1197a.invokePlatformMessageEmptyResponseCallback(i);
    }

    /* renamed from: m */
    public /* synthetic */ void m711m(String str, int i, C0591f c0591f, ByteBuffer byteBuffer, long j) {
        C0143e.m2031e("PlatformChannel ScheduleHandler on " + str, i);
        C0143e.m2035a("DartMessenger#handleMessageFromDart on " + str);
        try {
            m712l(c0591f, byteBuffer, i);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.f1197a.cleanupMessageData(j);
            C0143e.m2032d();
        }
    }

    @Override // p001a0.InterfaceC0016c
    /* renamed from: a */
    public InterfaceC0016c.InterfaceC0019c mo721a(InterfaceC0016c.C0020d c0020d) {
        InterfaceC0589d mo704a = this.f1206j.mo704a(c0020d);
        C0595j c0595j = new C0595j();
        this.f1205i.put(c0595j, mo704a);
        return c0595j;
    }

    @Override // p001a0.InterfaceC0016c
    /* renamed from: b */
    public /* synthetic */ InterfaceC0016c.InterfaceC0019c mo720b() {
        return C0015b.m2287a(this);
    }

    @Override // p001a0.InterfaceC0016c
    /* renamed from: c */
    public void mo719c(String str, ByteBuffer byteBuffer, InterfaceC0016c.InterfaceC0018b interfaceC0018b) {
        C0143e.m2035a("DartMessenger#send on " + str);
        try {
            C0576b.m737f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i = this.f1203g;
            this.f1203g = i + 1;
            if (interfaceC0018b != null) {
                this.f1202f.put(Integer.valueOf(i), interfaceC0018b);
            }
            if (byteBuffer == null) {
                this.f1197a.dispatchEmptyPlatformMessage(str, i);
            } else {
                this.f1197a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
            }
        } finally {
            C0143e.m2032d();
        }
    }

    @Override // p001a0.InterfaceC0016c
    /* renamed from: d */
    public void mo718d(String str, InterfaceC0016c.InterfaceC0017a interfaceC0017a, InterfaceC0016c.InterfaceC0019c interfaceC0019c) {
        if (interfaceC0017a == null) {
            C0576b.m737f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f1200d) {
                this.f1198b.remove(str);
            }
            return;
        }
        InterfaceC0589d interfaceC0589d = null;
        if (interfaceC0019c != null && (interfaceC0589d = this.f1205i.get(interfaceC0019c)) == null) {
            throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
        }
        C0576b.m737f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f1200d) {
            this.f1198b.put(str, new C0591f(interfaceC0017a, interfaceC0589d));
            List<C0587b> remove = this.f1199c.remove(str);
            if (remove == null) {
                return;
            }
            for (C0587b c0587b : remove) {
                m714j(str, this.f1198b.get(str), c0587b.f1207a, c0587b.f1208b, c0587b.f1209c);
            }
        }
    }

    @Override // p033p.InterfaceC0598f
    /* renamed from: e */
    public void mo703e(String str, ByteBuffer byteBuffer, int i, long j) {
        C0591f c0591f;
        boolean z;
        C0576b.m737f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f1200d) {
            c0591f = this.f1198b.get(str);
            z = this.f1201e.get() && c0591f == null;
            if (z) {
                if (!this.f1199c.containsKey(str)) {
                    this.f1199c.put(str, new LinkedList());
                }
                this.f1199c.get(str).add(new C0587b(byteBuffer, i, j));
            }
        }
        if (z) {
            return;
        }
        m714j(str, c0591f, byteBuffer, i, j);
    }

    @Override // p001a0.InterfaceC0016c
    /* renamed from: f */
    public void mo717f(String str, ByteBuffer byteBuffer) {
        C0576b.m737f("DartMessenger", "Sending message over channel '" + str + "'");
        mo719c(str, byteBuffer, null);
    }

    @Override // p001a0.InterfaceC0016c
    /* renamed from: g */
    public void mo716g(String str, InterfaceC0016c.InterfaceC0017a interfaceC0017a) {
        mo718d(str, interfaceC0017a, null);
    }

    @Override // p033p.InterfaceC0598f
    /* renamed from: h */
    public void mo702h(int i, ByteBuffer byteBuffer) {
        C0576b.m737f("DartMessenger", "Received message reply from Dart.");
        InterfaceC0016c.InterfaceC0018b remove = this.f1202f.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                C0576b.m737f("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.mo710a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e) {
                m713k(e);
            } catch (Exception e2) {
                C0576b.m740c("DartMessenger", "Uncaught exception in binary message reply handler", e2);
            }
        }
    }
}