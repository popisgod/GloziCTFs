package p048w0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.C0461e;

/* renamed from: w0.y */
/* loaded from: classes.dex */
public class C0797y {

    /* renamed from: b */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1403b = AtomicIntegerFieldUpdater.newUpdater(C0797y.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a */
    public final Throwable f1404a;

    public C0797y(Throwable th, boolean z) {
        this.f1404a = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ C0797y(Throwable th, boolean z, int i, C0461e c0461e) {
        this(th, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: a */
    public final boolean m260a() {
        return this._handled;
    }

    /* renamed from: b */
    public final boolean m259b() {
        return f1403b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return C0771q0.m392a(this) + '[' + this.f1404a + ']';
    }
}