package p033p;

import android.os.Handler;
import android.os.Looper;
import p012e0.C0139a;
import p033p.C0585c;

/* renamed from: p.g */
/* loaded from: classes.dex */
public class C0599g implements C0585c.InterfaceC0589d {

    /* renamed from: a */
    private final Handler f1222a = C0139a.m2041a(Looper.getMainLooper());

    @Override // p033p.C0585c.InterfaceC0589d
    /* renamed from: a */
    public void mo701a(Runnable runnable) {
        this.f1222a.post(runnable);
    }
}