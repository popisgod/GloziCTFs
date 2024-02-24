package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.flutter.embedding.android.t */
/* loaded from: classes.dex */
public final class C0305t {

    /* renamed from: c */
    private static C0305t f442c;

    /* renamed from: a */
    private final LongSparseArray<MotionEvent> f443a = new LongSparseArray<>();

    /* renamed from: b */
    private final PriorityQueue<Long> f444b = new PriorityQueue<>();

    /* renamed from: io.flutter.embedding.android.t$a */
    /* loaded from: classes.dex */
    public static class C0306a {

        /* renamed from: b */
        private static final AtomicLong f445b = new AtomicLong(0);

        /* renamed from: a */
        private final long f446a;

        private C0306a(long j) {
            this.f446a = j;
        }

        /* renamed from: b */
        public static C0306a m1635b() {
            return m1634c(f445b.incrementAndGet());
        }

        /* renamed from: c */
        public static C0306a m1634c(long j) {
            return new C0306a(j);
        }

        /* renamed from: d */
        public long m1633d() {
            return this.f446a;
        }
    }

    private C0305t() {
    }

    /* renamed from: a */
    public static C0305t m1639a() {
        if (f442c == null) {
            f442c = new C0305t();
        }
        return f442c;
    }

    /* renamed from: b */
    public MotionEvent m1638b(C0306a c0306a) {
        while (!this.f444b.isEmpty() && this.f444b.peek().longValue() < c0306a.f446a) {
            this.f443a.remove(this.f444b.poll().longValue());
        }
        if (!this.f444b.isEmpty() && this.f444b.peek().longValue() == c0306a.f446a) {
            this.f444b.poll();
        }
        MotionEvent motionEvent = this.f443a.get(c0306a.f446a);
        this.f443a.remove(c0306a.f446a);
        return motionEvent;
    }

    /* renamed from: c */
    public C0306a m1637c(MotionEvent motionEvent) {
        C0306a m1635b = C0306a.m1635b();
        this.f443a.put(m1635b.f446a, MotionEvent.obtain(motionEvent));
        this.f444b.add(Long.valueOf(m1635b.f446a));
        return m1635b;
    }
}