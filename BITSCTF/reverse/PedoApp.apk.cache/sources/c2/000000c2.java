package androidx.window.layout;

import android.app.Activity;
import kotlin.coroutines.jvm.internal.AbstractC0454k;
import kotlin.coroutines.jvm.internal.InterfaceC0448f;
import kotlin.jvm.internal.C0465i;
import p014f0.C0169q;
import p020i0.InterfaceC0244d;
import p034p0.InterfaceC0615p;
import p052y0.InterfaceC0820f;
import p054z0.InterfaceC0910c;

@InterfaceC0448f(m1071c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", m1070f = "WindowInfoTrackerImpl.kt", m1069l = {54, 55}, m1068m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends AbstractC0454k implements InterfaceC0615p<InterfaceC0910c<? super WindowLayoutInfo>, InterfaceC0244d<? super C0169q>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, InterfaceC0244d<? super WindowInfoTrackerImpl$windowLayoutInfo$1> interfaceC0244d) {
        super(2, interfaceC0244d);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    /* renamed from: a */
    public static /* synthetic */ void m2141a(InterfaceC0820f interfaceC0820f, WindowLayoutInfo windowLayoutInfo) {
        m2312invokeSuspend$lambda0(interfaceC0820f, windowLayoutInfo);
    }

    /* renamed from: invokeSuspend$lambda-0 */
    public static final void m2312invokeSuspend$lambda0(InterfaceC0820f interfaceC0820f, WindowLayoutInfo info) {
        C0465i.m1049d(info, "info");
        interfaceC0820f.mo178a(info);
    }

    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
    public final InterfaceC0244d<C0169q> create(Object obj, InterfaceC0244d<?> interfaceC0244d) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, interfaceC0244d);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // p034p0.InterfaceC0615p
    public final Object invoke(InterfaceC0910c<? super WindowLayoutInfo> interfaceC0910c, InterfaceC0244d<? super C0169q> interfaceC0244d) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(interfaceC0910c, interfaceC0244d)).invokeSuspend(C0169q.f235a);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x007b A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #1 {all -> 0x009e, blocks: (B:56:0x0061, B:60:0x0073, B:62:0x007b), top: B:76:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0092  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0090 -> B:76:0x0061). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.AbstractC0443a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = p022j0.C0433b.m1080c()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r9.L$2
            y0.g r1 = (p052y0.InterfaceC0822g) r1
            java.lang.Object r4 = r9.L$1
            g.a r4 = (p015g.InterfaceC0170a) r4
            java.lang.Object r5 = r9.L$0
            z0.c r5 = (p054z0.InterfaceC0910c) r5
            p014f0.C0164l.m2005b(r10)     // Catch: java.lang.Throwable -> La0
            r10 = r5
            goto L60
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            java.lang.Object r1 = r9.L$2
            y0.g r1 = (p052y0.InterfaceC0822g) r1
            java.lang.Object r4 = r9.L$1
            g.a r4 = (p015g.InterfaceC0170a) r4
            java.lang.Object r5 = r9.L$0
            z0.c r5 = (p054z0.InterfaceC0910c) r5
            p014f0.C0164l.m2005b(r10)     // Catch: java.lang.Throwable -> La0
            r6 = r5
            r5 = r9
            goto L73
        L39:
            p014f0.C0164l.m2005b(r10)
            java.lang.Object r10 = r9.L$0
            z0.c r10 = (p054z0.InterfaceC0910c) r10
            r1 = 10
            y0.e r4 = p052y0.EnumC0819e.DROP_OLDEST
            r5 = 4
            r6 = 0
            y0.f r1 = p052y0.C0823h.m204b(r1, r4, r6, r5, r6)
            androidx.window.layout.c r4 = new androidx.window.layout.c
            r4.<init>()
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.WindowBackend r5 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r5)
            android.app.Activity r6 = r9.$activity
            androidx.window.layout.d r7 = new java.util.concurrent.Executor() { // from class: androidx.window.layout.d
                static {
                    /*
                        androidx.window.layout.d r0 = new androidx.window.layout.d
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:androidx.window.layout.d) androidx.window.layout.d.d androidx.window.layout.d
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.ExecutorC0097d.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.ExecutorC0097d.<init>():void");
                }

                @Override // java.util.concurrent.Executor
                public final void execute(java.lang.Runnable r1) {
                    /*
                        r0 = this;
                        r1.run()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.ExecutorC0097d.execute(java.lang.Runnable):void");
                }
            }
            r5.registerLayoutChangeCallback(r6, r7, r4)
            y0.g r1 = r1.iterator()     // Catch: java.lang.Throwable -> La0
        L60:
            r5 = r9
        L61:
            r5.L$0 = r10     // Catch: java.lang.Throwable -> L9e
            r5.L$1 = r4     // Catch: java.lang.Throwable -> L9e
            r5.L$2 = r1     // Catch: java.lang.Throwable -> L9e
            r5.label = r3     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r6 = r1.mo206a(r5)     // Catch: java.lang.Throwable -> L9e
            if (r6 != r0) goto L70
            return r0
        L70:
            r8 = r6
            r6 = r10
            r10 = r8
        L73:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L9e
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L9e
            if (r10 == 0) goto L92
            java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L9e
            androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch: java.lang.Throwable -> L9e
            r5.L$0 = r6     // Catch: java.lang.Throwable -> L9e
            r5.L$1 = r4     // Catch: java.lang.Throwable -> L9e
            r5.L$2 = r1     // Catch: java.lang.Throwable -> L9e
            r5.label = r2     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r10 = r6.emit(r10, r5)     // Catch: java.lang.Throwable -> L9e
            if (r10 != r0) goto L90
            return r0
        L90:
            r10 = r6
            goto L61
        L92:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r5.this$0
            androidx.window.layout.WindowBackend r10 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r10)
            r10.unregisterLayoutChangeCallback(r4)
            f0.q r10 = p014f0.C0169q.f235a
            return r10
        L9e:
            r10 = move-exception
            goto La2
        La0:
            r10 = move-exception
            r5 = r9
        La2:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r5.this$0
            androidx.window.layout.WindowBackend r0 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r0)
            r0.unregisterLayoutChangeCallback(r4)
            goto Lad
        Lac:
            throw r10
        Lad:
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}