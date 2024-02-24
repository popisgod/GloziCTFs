package androidx.lifecycle;

import androidx.lifecycle.AbstractC0066c;
import androidx.window.C0082R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p000a.C0000a;
import p000a.C0001b;

/* renamed from: androidx.lifecycle.g */
/* loaded from: classes.dex */
public class C0072g extends AbstractC0066c {

    /* renamed from: d */
    private final WeakReference<InterfaceC0071f> f113d;

    /* renamed from: b */
    private C0000a<InterfaceC0070e, C0074b> f111b = new C0000a<>();

    /* renamed from: e */
    private int f114e = 0;

    /* renamed from: f */
    private boolean f115f = false;

    /* renamed from: g */
    private boolean f116g = false;

    /* renamed from: h */
    private ArrayList<AbstractC0066c.EnumC0068b> f117h = new ArrayList<>();

    /* renamed from: c */
    private AbstractC0066c.EnumC0068b f112c = AbstractC0066c.EnumC0068b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.g$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0073a {

        /* renamed from: a */
        static final /* synthetic */ int[] f118a;

        /* renamed from: b */
        static final /* synthetic */ int[] f119b;

        static {
            int[] iArr = new int[AbstractC0066c.EnumC0068b.values().length];
            f119b = iArr;
            try {
                iArr[AbstractC0066c.EnumC0068b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119b[AbstractC0066c.EnumC0068b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119b[AbstractC0066c.EnumC0068b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119b[AbstractC0066c.EnumC0068b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f119b[AbstractC0066c.EnumC0068b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[AbstractC0066c.EnumC0067a.values().length];
            f118a = iArr2;
            try {
                iArr2[AbstractC0066c.EnumC0067a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f118a[AbstractC0066c.EnumC0067a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f118a[AbstractC0066c.EnumC0067a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f118a[AbstractC0066c.EnumC0067a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f118a[AbstractC0066c.EnumC0067a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f118a[AbstractC0066c.EnumC0067a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f118a[AbstractC0066c.EnumC0067a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.g$b */
    /* loaded from: classes.dex */
    public static class C0074b {

        /* renamed from: a */
        AbstractC0066c.EnumC0068b f120a;

        /* renamed from: b */
        InterfaceC0069d f121b;

        /* renamed from: a */
        void m2195a(InterfaceC0071f interfaceC0071f, AbstractC0066c.EnumC0067a enumC0067a) {
            AbstractC0066c.EnumC0068b m2204f = C0072g.m2204f(enumC0067a);
            this.f120a = C0072g.m2201i(this.f120a, m2204f);
            this.f121b.mo2193g(interfaceC0071f, enumC0067a);
            this.f120a = m2204f;
        }
    }

    public C0072g(InterfaceC0071f interfaceC0071f) {
        this.f113d = new WeakReference<>(interfaceC0071f);
    }

    /* renamed from: c */
    private void m2207c(InterfaceC0071f interfaceC0071f) {
        Iterator<Map.Entry<InterfaceC0070e, C0074b>> m2304a = this.f111b.m2304a();
        while (m2304a.hasNext() && !this.f116g) {
            Map.Entry<InterfaceC0070e, C0074b> next = m2304a.next();
            C0074b value = next.getValue();
            while (value.f120a.compareTo(this.f112c) > 0 && !this.f116g && this.f111b.contains(next.getKey())) {
                AbstractC0066c.EnumC0067a m2206d = m2206d(value.f120a);
                m2198l(m2204f(m2206d));
                value.m2195a(interfaceC0071f, m2206d);
                m2199k();
            }
        }
    }

    /* renamed from: d */
    private static AbstractC0066c.EnumC0067a m2206d(AbstractC0066c.EnumC0068b enumC0068b) {
        int i = C0073a.f119b[enumC0068b.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + enumC0068b);
                        }
                        throw new IllegalArgumentException();
                    }
                    return AbstractC0066c.EnumC0067a.ON_PAUSE;
                }
                return AbstractC0066c.EnumC0067a.ON_STOP;
            }
            return AbstractC0066c.EnumC0067a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    private void m2205e(InterfaceC0071f interfaceC0071f) {
        C0001b<InterfaceC0070e, C0074b>.C0005d m2301d = this.f111b.m2301d();
        while (m2301d.hasNext() && !this.f116g) {
            Map.Entry next = m2301d.next();
            C0074b c0074b = (C0074b) next.getValue();
            while (c0074b.f120a.compareTo(this.f112c) < 0 && !this.f116g && this.f111b.contains(next.getKey())) {
                m2198l(c0074b.f120a);
                c0074b.m2195a(interfaceC0071f, m2196n(c0074b.f120a));
                m2199k();
            }
        }
    }

    /* renamed from: f */
    static AbstractC0066c.EnumC0068b m2204f(AbstractC0066c.EnumC0067a enumC0067a) {
        switch (C0073a.f118a[enumC0067a.ordinal()]) {
            case 1:
            case 2:
                return AbstractC0066c.EnumC0068b.CREATED;
            case 3:
            case 4:
                return AbstractC0066c.EnumC0068b.STARTED;
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                return AbstractC0066c.EnumC0068b.RESUMED;
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                return AbstractC0066c.EnumC0068b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + enumC0067a);
        }
    }

    /* renamed from: h */
    private boolean m2202h() {
        if (this.f111b.size() == 0) {
            return true;
        }
        AbstractC0066c.EnumC0068b enumC0068b = this.f111b.m2303b().getValue().f120a;
        AbstractC0066c.EnumC0068b enumC0068b2 = this.f111b.m2300e().getValue().f120a;
        return enumC0068b == enumC0068b2 && this.f112c == enumC0068b2;
    }

    /* renamed from: i */
    static AbstractC0066c.EnumC0068b m2201i(AbstractC0066c.EnumC0068b enumC0068b, AbstractC0066c.EnumC0068b enumC0068b2) {
        return (enumC0068b2 == null || enumC0068b2.compareTo(enumC0068b) >= 0) ? enumC0068b : enumC0068b2;
    }

    /* renamed from: j */
    private void m2200j(AbstractC0066c.EnumC0068b enumC0068b) {
        if (this.f112c == enumC0068b) {
            return;
        }
        this.f112c = enumC0068b;
        if (this.f115f || this.f114e != 0) {
            this.f116g = true;
            return;
        }
        this.f115f = true;
        m2197m();
        this.f115f = false;
    }

    /* renamed from: k */
    private void m2199k() {
        ArrayList<AbstractC0066c.EnumC0068b> arrayList = this.f117h;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: l */
    private void m2198l(AbstractC0066c.EnumC0068b enumC0068b) {
        this.f117h.add(enumC0068b);
    }

    /* renamed from: m */
    private void m2197m() {
        InterfaceC0071f interfaceC0071f = this.f113d.get();
        if (interfaceC0071f == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean m2202h = m2202h();
            this.f116g = false;
            if (m2202h) {
                return;
            }
            if (this.f112c.compareTo(this.f111b.m2303b().getValue().f120a) < 0) {
                m2207c(interfaceC0071f);
            }
            Map.Entry<InterfaceC0070e, C0074b> m2300e = this.f111b.m2300e();
            if (!this.f116g && m2300e != null && this.f112c.compareTo(m2300e.getValue().f120a) > 0) {
                m2205e(interfaceC0071f);
            }
        }
    }

    /* renamed from: n */
    private static AbstractC0066c.EnumC0067a m2196n(AbstractC0066c.EnumC0068b enumC0068b) {
        int i = C0073a.f119b[enumC0068b.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return AbstractC0066c.EnumC0067a.ON_START;
            }
            if (i == 3) {
                return AbstractC0066c.EnumC0067a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + enumC0068b);
            }
        }
        return AbstractC0066c.EnumC0067a.ON_CREATE;
    }

    @Override // androidx.lifecycle.AbstractC0066c
    /* renamed from: a */
    public AbstractC0066c.EnumC0068b mo2209a() {
        return this.f112c;
    }

    @Override // androidx.lifecycle.AbstractC0066c
    /* renamed from: b */
    public void mo2208b(InterfaceC0070e interfaceC0070e) {
        this.f111b.mo2299f(interfaceC0070e);
    }

    /* renamed from: g */
    public void m2203g(AbstractC0066c.EnumC0067a enumC0067a) {
        m2200j(m2204f(enumC0067a));
    }
}