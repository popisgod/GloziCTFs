package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.plugin.editing.C0347b;
import java.util.HashSet;
import java.util.Map;
import p001a0.InterfaceC0016c;
import p031o.C0576b;
import p053z.C0845d;
import p053z.C0848e;

/* renamed from: io.flutter.embedding.android.r */
/* loaded from: classes.dex */
public class C0291r implements C0347b.InterfaceC0348a, C0848e.InterfaceC0850b {

    /* renamed from: a */
    protected final InterfaceC0296d[] f421a;

    /* renamed from: b */
    private final HashSet<KeyEvent> f422b = new HashSet<>();

    /* renamed from: c */
    private final InterfaceC0298e f423c;

    /* renamed from: io.flutter.embedding.android.r$b */
    /* loaded from: classes.dex */
    public static class C0293b {

        /* renamed from: a */
        private int f424a = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public Character m1646a(int i) {
            char c = (char) i;
            if ((Integer.MIN_VALUE & i) != 0) {
                int i2 = i & Integer.MAX_VALUE;
                int i3 = this.f424a;
                if (i3 != 0) {
                    i2 = KeyCharacterMap.getDeadChar(i3, i2);
                }
                this.f424a = i2;
            } else {
                int i4 = this.f424a;
                if (i4 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                    if (deadChar > 0) {
                        c = (char) deadChar;
                    }
                    this.f424a = 0;
                }
            }
            return Character.valueOf(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.embedding.android.r$c */
    /* loaded from: classes.dex */
    public class C0294c {

        /* renamed from: a */
        final KeyEvent f425a;

        /* renamed from: b */
        int f426b;

        /* renamed from: c */
        boolean f427c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: io.flutter.embedding.android.r$c$a */
        /* loaded from: classes.dex */
        public class C0295a implements InterfaceC0296d.InterfaceC0297a {

            /* renamed from: a */
            boolean f429a;

            private C0295a() {
                this.f429a = false;
            }

            @Override // io.flutter.embedding.android.C0291r.InterfaceC0296d.InterfaceC0297a
            /* renamed from: a */
            public void mo1643a(boolean z) {
                if (this.f429a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f429a = true;
                C0294c c0294c = C0294c.this;
                int i = c0294c.f426b - 1;
                c0294c.f426b = i;
                boolean z2 = z | c0294c.f427c;
                c0294c.f427c = z2;
                if (i != 0 || z2) {
                    return;
                }
                C0291r.this.m1647e(c0294c.f425a);
            }
        }

        C0294c(KeyEvent keyEvent) {
            this.f426b = C0291r.this.f421a.length;
            this.f425a = keyEvent;
        }

        /* renamed from: a */
        public InterfaceC0296d.InterfaceC0297a m1645a() {
            return new C0295a();
        }
    }

    /* renamed from: io.flutter.embedding.android.r$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0296d {

        /* renamed from: io.flutter.embedding.android.r$d$a */
        /* loaded from: classes.dex */
        public interface InterfaceC0297a {
            /* renamed from: a */
            void mo1643a(boolean z);
        }

        /* renamed from: a */
        void mo1644a(KeyEvent keyEvent, InterfaceC0297a interfaceC0297a);
    }

    /* renamed from: io.flutter.embedding.android.r$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0298e {
        /* renamed from: a */
        boolean mo1642a(KeyEvent keyEvent);

        /* renamed from: c */
        void mo1641c(KeyEvent keyEvent);

        InterfaceC0016c getBinaryMessenger();
    }

    public C0291r(InterfaceC0298e interfaceC0298e) {
        this.f423c = interfaceC0298e;
        this.f421a = new InterfaceC0296d[]{new C0289q(interfaceC0298e.getBinaryMessenger()), new C0283l(new C0845d(interfaceC0298e.getBinaryMessenger()))};
        new C0848e(interfaceC0298e.getBinaryMessenger()).m154b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1647e(KeyEvent keyEvent) {
        InterfaceC0298e interfaceC0298e = this.f423c;
        if (interfaceC0298e == null || interfaceC0298e.mo1642a(keyEvent)) {
            return;
        }
        this.f422b.add(keyEvent);
        this.f423c.mo1641c(keyEvent);
        if (this.f422b.remove(keyEvent)) {
            C0576b.m736g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    @Override // io.flutter.plugin.editing.C0347b.InterfaceC0348a
    /* renamed from: a */
    public boolean mo1506a(KeyEvent keyEvent) {
        if (this.f422b.remove(keyEvent)) {
            return false;
        }
        if (this.f421a.length <= 0) {
            m1647e(keyEvent);
            return true;
        }
        C0294c c0294c = new C0294c(keyEvent);
        for (InterfaceC0296d interfaceC0296d : this.f421a) {
            interfaceC0296d.mo1644a(keyEvent, c0294c.m1645a());
        }
        return true;
    }

    @Override // p053z.C0848e.InterfaceC0850b
    /* renamed from: b */
    public Map<Long, Long> mo153b() {
        return ((C0289q) this.f421a[0]).m1660h();
    }

    /* renamed from: d */
    public void m1648d() {
        int size = this.f422b.size();
        if (size > 0) {
            C0576b.m736g("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }
}