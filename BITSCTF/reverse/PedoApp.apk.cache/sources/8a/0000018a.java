package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.C0291r;
import p053z.C0845d;

/* renamed from: io.flutter.embedding.android.l */
/* loaded from: classes.dex */
public class C0283l implements C0291r.InterfaceC0296d {

    /* renamed from: a */
    private final C0845d f395a;

    /* renamed from: b */
    private final C0291r.C0293b f396b = new C0291r.C0293b();

    public C0283l(C0845d c0845d) {
        this.f395a = c0845d;
    }

    @Override // io.flutter.embedding.android.C0291r.InterfaceC0296d
    /* renamed from: a */
    public void mo1644a(KeyEvent keyEvent, final C0291r.InterfaceC0296d.InterfaceC0297a interfaceC0297a) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            this.f395a.m157e(new C0845d.C0847b(keyEvent, this.f396b.m1646a(keyEvent.getUnicodeChar())), action != 0, new C0845d.InterfaceC0846a() { // from class: io.flutter.embedding.android.k
                @Override // p053z.C0845d.InterfaceC0846a
                /* renamed from: a */
                public final void mo156a(boolean z) {
                    C0291r.InterfaceC0296d.InterfaceC0297a.this.mo1643a(z);
                }
            });
        } else {
            interfaceC0297a.mo1643a(false);
        }
    }
}