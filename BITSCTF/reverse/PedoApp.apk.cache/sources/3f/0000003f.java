package androidx.activity;

import androidx.lifecycle.AbstractC0066c;
import androidx.lifecycle.InterfaceC0069d;
import androidx.lifecycle.InterfaceC0071f;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements InterfaceC0069d, InterfaceC0058a {

        /* renamed from: a */
        private final AbstractC0066c f76a;

        /* renamed from: b */
        private InterfaceC0058a f77b;

        @Override // androidx.activity.InterfaceC0058a
        public void cancel() {
            this.f76a.mo2208b(this);
            throw null;
        }

        @Override // androidx.lifecycle.InterfaceC0069d
        /* renamed from: g */
        public void mo2193g(InterfaceC0071f interfaceC0071f, AbstractC0066c.EnumC0067a enumC0067a) {
            if (enumC0067a == AbstractC0066c.EnumC0067a.ON_START) {
                throw null;
            }
            if (enumC0067a != AbstractC0066c.EnumC0067a.ON_STOP) {
                if (enumC0067a == AbstractC0066c.EnumC0067a.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            }
            InterfaceC0058a interfaceC0058a = this.f77b;
            if (interfaceC0058a != null) {
                interfaceC0058a.cancel();
            }
        }
    }
}