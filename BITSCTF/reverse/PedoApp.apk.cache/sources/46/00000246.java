package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import p032o0.C0578b;
import p042t0.EnumC0658g;
import p042t0.InterfaceC0653b;
import p042t0.InterfaceC0655d;
import p042t0.InterfaceC0657f;

/* renamed from: kotlin.jvm.internal.a */
/* loaded from: classes.dex */
public abstract class AbstractC0455a implements InterfaceC0653b, Serializable {
    public static final Object NO_RECEIVER = C0456a.f973d;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient InterfaceC0653b reflected;
    private final String signature;

    /* renamed from: kotlin.jvm.internal.a$a */
    /* loaded from: classes.dex */
    private static class C0456a implements Serializable {

        /* renamed from: d */
        private static final C0456a f973d = new C0456a();

        private C0456a() {
        }
    }

    public AbstractC0455a() {
        this(NO_RECEIVER);
    }

    protected AbstractC0455a(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0455a(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // p042t0.InterfaceC0653b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // p042t0.InterfaceC0653b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public InterfaceC0653b compute() {
        InterfaceC0653b interfaceC0653b = this.reflected;
        if (interfaceC0653b == null) {
            InterfaceC0653b computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return interfaceC0653b;
    }

    protected abstract InterfaceC0653b computeReflected();

    @Override // p042t0.InterfaceC0652a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public InterfaceC0655d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? C0468l.m1034c(cls) : C0468l.m1035b(cls);
    }

    @Override // p042t0.InterfaceC0653b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InterfaceC0653b getReflected() {
        InterfaceC0653b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new C0578b();
    }

    @Override // p042t0.InterfaceC0653b
    public InterfaceC0657f getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // p042t0.InterfaceC0653b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // p042t0.InterfaceC0653b
    public EnumC0658g getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // p042t0.InterfaceC0653b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // p042t0.InterfaceC0653b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // p042t0.InterfaceC0653b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // p042t0.InterfaceC0653b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}