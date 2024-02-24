package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.lifecycle.c */
/* loaded from: classes.dex */
public abstract class AbstractC0066c {

    /* renamed from: a */
    AtomicReference<Object> f104a = new AtomicReference<>();

    /* renamed from: androidx.lifecycle.c$a */
    /* loaded from: classes.dex */
    public enum EnumC0067a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* renamed from: androidx.lifecycle.c$b */
    /* loaded from: classes.dex */
    public enum EnumC0068b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public boolean m2210a(EnumC0068b enumC0068b) {
            return compareTo(enumC0068b) >= 0;
        }
    }

    /* renamed from: a */
    public abstract EnumC0068b mo2209a();

    /* renamed from: b */
    public abstract void mo2208b(InterfaceC0070e interfaceC0070e);
}