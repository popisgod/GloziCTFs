package androidx.savedstate;

import android.annotation.SuppressLint;
import androidx.lifecycle.AbstractC0066c;
import androidx.lifecycle.InterfaceC0069d;
import androidx.lifecycle.InterfaceC0071f;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements InterfaceC0069d {

    /* renamed from: a */
    private final InterfaceC0078b f124a;

    @Override // androidx.lifecycle.InterfaceC0069d
    /* renamed from: g */
    public void mo2193g(InterfaceC0071f interfaceC0071f, AbstractC0066c.EnumC0067a enumC0067a) {
        if (enumC0067a != AbstractC0066c.EnumC0067a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0071f.mo1748f().mo2208b(this);
        this.f124a.m2192l();
        throw null;
    }
}