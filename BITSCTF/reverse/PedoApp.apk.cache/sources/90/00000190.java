package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.C0284m;
import io.flutter.embedding.android.C0291r;
import io.flutter.embedding.android.C0299s;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p001a0.InterfaceC0016c;

/* renamed from: io.flutter.embedding.android.q */
/* loaded from: classes.dex */
public class C0289q implements C0291r.InterfaceC0296d {

    /* renamed from: a */
    private final InterfaceC0016c f416a;

    /* renamed from: b */
    private final HashMap<Long, Long> f417b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<Long, C0299s.C0304e> f418c = new HashMap<>();

    /* renamed from: d */
    private final C0291r.C0293b f419d = new C0291r.C0293b();

    /* renamed from: io.flutter.embedding.android.q$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0290a {

        /* renamed from: a */
        static final /* synthetic */ int[] f420a;

        static {
            int[] iArr = new int[C0284m.EnumC0285a.values().length];
            f420a = iArr;
            try {
                iArr[C0284m.EnumC0285a.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f420a[C0284m.EnumC0285a.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f420a[C0284m.EnumC0285a.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C0289q(InterfaceC0016c interfaceC0016c) {
        C0299s.C0304e[] m1640a;
        this.f416a = interfaceC0016c;
        for (C0299s.C0304e c0304e : C0299s.m1640a()) {
            this.f418c.put(Long.valueOf(c0304e.f440c), c0304e);
        }
    }

    /* renamed from: b */
    public static /* synthetic */ void m1666b(C0289q c0289q, C0299s.C0302c c0302c, KeyEvent keyEvent) {
        c0289q.m1655m(c0302c, keyEvent);
    }

    /* renamed from: d */
    public static /* synthetic */ void m1664d(C0289q c0289q, C0299s.C0302c c0302c, long j, KeyEvent keyEvent) {
        c0289q.m1656l(c0302c, j, keyEvent);
    }

    /* renamed from: e */
    private static C0284m.EnumC0285a m1663e(KeyEvent keyEvent) {
        boolean z = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z ? C0284m.EnumC0285a.kRepeat : C0284m.EnumC0285a.kDown;
        } else if (action == 1) {
            return C0284m.EnumC0285a.kUp;
        } else {
            throw new AssertionError("Unexpected event type");
        }
    }

    /* renamed from: f */
    private Long m1662f(KeyEvent keyEvent) {
        Long l = C0299s.f432b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l != null ? l : Long.valueOf(m1658j(keyEvent.getKeyCode(), 73014444032L));
    }

    /* renamed from: g */
    private Long m1661g(KeyEvent keyEvent) {
        int scanCode;
        long scanCode2 = keyEvent.getScanCode();
        if (scanCode2 == 0) {
            scanCode = keyEvent.getKeyCode();
        } else {
            Long l = C0299s.f431a.get(Long.valueOf(scanCode2));
            if (l != null) {
                return l;
            }
            scanCode = keyEvent.getScanCode();
        }
        return Long.valueOf(m1658j(scanCode, 73014444032L));
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0119 A[LOOP:2: B:121:0x0113->B:123:0x0119, LOOP_END] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m1659i(android.view.KeyEvent r18, io.flutter.embedding.android.C0291r.InterfaceC0296d.InterfaceC0297a r19) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.C0289q.m1659i(android.view.KeyEvent, io.flutter.embedding.android.r$d$a):boolean");
    }

    /* renamed from: j */
    private static long m1658j(long j, long j2) {
        return (j & 4294967295L) | j2;
    }

    /* renamed from: k */
    public static /* synthetic */ void m1657k(C0291r.InterfaceC0296d.InterfaceC0297a interfaceC0297a, ByteBuffer byteBuffer) {
        Boolean bool = Boolean.FALSE;
        byteBuffer.rewind();
        if (byteBuffer.capacity() != 0) {
            bool = Boolean.valueOf(byteBuffer.get() != 0);
        }
        interfaceC0297a.mo1643a(bool.booleanValue());
    }

    /* renamed from: l */
    public /* synthetic */ void m1656l(C0299s.C0302c c0302c, long j, KeyEvent keyEvent) {
        m1651q(false, Long.valueOf(c0302c.f435b), Long.valueOf(j), keyEvent.getEventTime());
    }

    /* renamed from: m */
    public /* synthetic */ void m1655m(C0299s.C0302c c0302c, KeyEvent keyEvent) {
        m1651q(false, Long.valueOf(c0302c.f435b), Long.valueOf(c0302c.f434a), keyEvent.getEventTime());
    }

    /* renamed from: n */
    private void m1654n(C0284m c0284m, final C0291r.InterfaceC0296d.InterfaceC0297a interfaceC0297a) {
        this.f416a.mo719c("flutter/keydata", c0284m.m1668a(), interfaceC0297a == null ? null : new InterfaceC0016c.InterfaceC0018b() { // from class: io.flutter.embedding.android.n
            @Override // p001a0.InterfaceC0016c.InterfaceC0018b
            /* renamed from: a */
            public final void mo710a(ByteBuffer byteBuffer) {
                C0289q.m1657k(C0291r.InterfaceC0296d.InterfaceC0297a.this, byteBuffer);
            }
        });
    }

    /* renamed from: q */
    private void m1651q(boolean z, Long l, Long l2, long j) {
        C0284m c0284m = new C0284m();
        c0284m.f397a = j;
        c0284m.f398b = z ? C0284m.EnumC0285a.kDown : C0284m.EnumC0285a.kUp;
        c0284m.f400d = l.longValue();
        c0284m.f399c = l2.longValue();
        c0284m.f402f = null;
        c0284m.f401e = true;
        if (l2.longValue() != 0 && l.longValue() != 0) {
            if (!z) {
                l = null;
            }
            m1650r(l2, l);
        }
        m1654n(c0284m, null);
    }

    @Override // io.flutter.embedding.android.C0291r.InterfaceC0296d
    /* renamed from: a */
    public void mo1644a(KeyEvent keyEvent, C0291r.InterfaceC0296d.InterfaceC0297a interfaceC0297a) {
        if (m1659i(keyEvent, interfaceC0297a)) {
            return;
        }
        m1651q(true, 0L, 0L, 0L);
        interfaceC0297a.mo1643a(true);
    }

    /* renamed from: h */
    public Map<Long, Long> m1660h() {
        return Collections.unmodifiableMap(this.f417b);
    }

    /* renamed from: o */
    void m1653o(C0299s.C0303d c0303d, boolean z, long j, final long j2, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        C0299s.C0302c[] c0302cArr = c0303d.f437b;
        boolean[] zArr = new boolean[c0302cArr.length];
        Boolean[] boolArr = new Boolean[c0302cArr.length];
        boolean z2 = false;
        int i = 0;
        while (true) {
            C0299s.C0302c[] c0302cArr2 = c0303d.f437b;
            boolean z3 = true;
            if (i >= c0302cArr2.length) {
                break;
            }
            final C0299s.C0302c c0302c = c0302cArr2[i];
            zArr[i] = this.f417b.containsKey(Long.valueOf(c0302c.f434a));
            if (c0302c.f435b == j) {
                int i2 = C0290a.f420a[m1663e(keyEvent).ordinal()];
                if (i2 == 1) {
                    boolArr[i] = Boolean.FALSE;
                    if (!z) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.o
                            @Override // java.lang.Runnable
                            public final void run() {
                                C0289q.m1664d(C0289q.this, c0302c, j2, keyEvent);
                            }
                        });
                    }
                } else if (i2 == 2) {
                    boolArr[i] = Boolean.valueOf(zArr[i]);
                } else if (i2 == 3) {
                    if (!z) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.p
                            @Override // java.lang.Runnable
                            public final void run() {
                                C0289q.m1666b(C0289q.this, c0302c, keyEvent);
                            }
                        });
                    }
                    boolArr[i] = Boolean.valueOf(zArr[i]);
                }
                z2 = true;
            } else {
                if (!z2 && !zArr[i]) {
                    z3 = false;
                }
                z2 = z3;
            }
            i++;
        }
        if (z) {
            for (int i3 = 0; i3 < c0303d.f437b.length; i3++) {
                if (boolArr[i3] == null) {
                    if (z2) {
                        boolArr[i3] = Boolean.valueOf(zArr[i3]);
                    } else {
                        boolArr[i3] = Boolean.TRUE;
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i4 = 0; i4 < c0303d.f437b.length; i4++) {
                if (boolArr[i4] == null) {
                    boolArr[i4] = Boolean.FALSE;
                }
            }
        }
        for (int i5 = 0; i5 < c0303d.f437b.length; i5++) {
            if (zArr[i5] != boolArr[i5].booleanValue()) {
                C0299s.C0302c c0302c2 = c0303d.f437b[i5];
                m1651q(boolArr[i5].booleanValue(), Long.valueOf(c0302c2.f435b), Long.valueOf(c0302c2.f434a), keyEvent.getEventTime());
            }
        }
    }

    /* renamed from: p */
    void m1652p(C0299s.C0304e c0304e, boolean z, long j, KeyEvent keyEvent) {
        if (c0304e.f440c == j || c0304e.f441d == z) {
            return;
        }
        boolean z2 = !this.f417b.containsKey(Long.valueOf(c0304e.f439b));
        if (z2) {
            c0304e.f441d = !c0304e.f441d;
        }
        m1651q(z2, Long.valueOf(c0304e.f440c), Long.valueOf(c0304e.f439b), keyEvent.getEventTime());
        if (!z2) {
            c0304e.f441d = !c0304e.f441d;
        }
        m1651q(!z2, Long.valueOf(c0304e.f440c), Long.valueOf(c0304e.f439b), keyEvent.getEventTime());
    }

    /* renamed from: r */
    void m1650r(Long l, Long l2) {
        if (l2 != null) {
            if (this.f417b.put(l, l2) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.f417b.remove(l) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}