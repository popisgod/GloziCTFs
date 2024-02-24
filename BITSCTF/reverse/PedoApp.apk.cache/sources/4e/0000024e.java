package kotlin.jvm.internal;

import p042t0.InterfaceC0653b;
import p042t0.InterfaceC0656e;

/* renamed from: kotlin.jvm.internal.g */
/* loaded from: classes.dex */
public class C0463g extends AbstractC0455a implements InterfaceC0462f, InterfaceC0656e {
    private final int arity;
    private final int flags;

    public C0463g(int i) {
        this(i, AbstractC0455a.NO_RECEIVER, null, null, null, 0);
    }

    public C0463g(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    public C0463g(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }

    @Override // kotlin.jvm.internal.AbstractC0455a
    protected InterfaceC0653b computeReflected() {
        return C0468l.m1036a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0463g) {
            C0463g c0463g = (C0463g) obj;
            return getName().equals(c0463g.getName()) && getSignature().equals(c0463g.getSignature()) && this.flags == c0463g.flags && this.arity == c0463g.arity && C0465i.m1052a(getBoundReceiver(), c0463g.getBoundReceiver()) && C0465i.m1052a(getOwner(), c0463g.getOwner());
        } else if (obj instanceof InterfaceC0656e) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // kotlin.jvm.internal.InterfaceC0462f
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.AbstractC0455a
    public InterfaceC0656e getReflected() {
        return (InterfaceC0656e) super.getReflected();
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // p042t0.InterfaceC0656e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // p042t0.InterfaceC0656e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // p042t0.InterfaceC0656e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // p042t0.InterfaceC0656e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.AbstractC0455a, p042t0.InterfaceC0653b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        InterfaceC0653b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}