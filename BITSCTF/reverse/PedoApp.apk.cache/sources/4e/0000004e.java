package androidx.lifecycle;

import androidx.lifecycle.AbstractC0066c;
import androidx.window.C0082R;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements InterfaceC0069d {

    /* renamed from: a */
    private final InterfaceC0064a f98a;

    /* renamed from: b */
    private final InterfaceC0069d f99b;

    /* renamed from: androidx.lifecycle.FullLifecycleObserverAdapter$a */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0063a {

        /* renamed from: a */
        static final /* synthetic */ int[] f100a;

        static {
            int[] iArr = new int[AbstractC0066c.EnumC0067a.values().length];
            f100a = iArr;
            try {
                iArr[AbstractC0066c.EnumC0067a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f100a[AbstractC0066c.EnumC0067a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f100a[AbstractC0066c.EnumC0067a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f100a[AbstractC0066c.EnumC0067a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f100a[AbstractC0066c.EnumC0067a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f100a[AbstractC0066c.EnumC0067a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f100a[AbstractC0066c.EnumC0067a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0069d
    /* renamed from: g */
    public void mo2193g(InterfaceC0071f interfaceC0071f, AbstractC0066c.EnumC0067a enumC0067a) {
        switch (C0063a.f100a[enumC0067a.ordinal()]) {
            case 1:
                this.f98a.m2213e(interfaceC0071f);
                break;
            case 2:
                this.f98a.m2212f(interfaceC0071f);
                break;
            case 3:
                this.f98a.m2217a(interfaceC0071f);
                break;
            case 4:
                this.f98a.m2216b(interfaceC0071f);
                break;
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                this.f98a.m2214d(interfaceC0071f);
                break;
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                this.f98a.m2215c(interfaceC0071f);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0069d interfaceC0069d = this.f99b;
        if (interfaceC0069d != null) {
            interfaceC0069d.mo2193g(interfaceC0071f, enumC0067a);
        }
    }
}