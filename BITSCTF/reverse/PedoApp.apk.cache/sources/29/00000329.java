package p046v0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C0465i;
import p014f0.C0160j;
import p034p0.InterfaceC0615p;
import p040s0.C0643c;
import p040s0.C0647f;
import p044u0.InterfaceC0664b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: v0.c */
/* loaded from: classes.dex */
public final class C0678c implements InterfaceC0664b<C0643c> {

    /* renamed from: a */
    private final CharSequence f1290a;

    /* renamed from: b */
    private final int f1291b;

    /* renamed from: c */
    private final int f1292c;

    /* renamed from: d */
    private final InterfaceC0615p<CharSequence, Integer, C0160j<Integer, Integer>> f1293d;

    /* renamed from: v0.c$a */
    /* loaded from: classes.dex */
    public static final class C0679a implements Iterator<C0643c> {

        /* renamed from: d */
        private int f1294d = -1;

        /* renamed from: e */
        private int f1295e;

        /* renamed from: f */
        private int f1296f;

        /* renamed from: g */
        private C0643c f1297g;

        /* renamed from: h */
        private int f1298h;

        C0679a() {
            int m641e;
            m641e = C0647f.m641e(C0678c.this.f1291b, 0, C0678c.this.f1290a.length());
            this.f1295e = m641e;
            this.f1296f = m641e;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f1299i.f1292c) goto L15;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void m590a() {
            /*
                r6 = this;
                int r0 = r6.f1296f
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f1294d = r1
                r0 = 0
                r6.f1297g = r0
                goto L99
            Lc:
                v0.c r0 = p046v0.C0678c.this
                int r0 = p046v0.C0678c.m592c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f1298h
                int r0 = r0 + r3
                r6.f1298h = r0
                v0.c r4 = p046v0.C0678c.this
                int r4 = p046v0.C0678c.m592c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f1296f
                v0.c r4 = p046v0.C0678c.this
                java.lang.CharSequence r4 = p046v0.C0678c.m593b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                s0.c r0 = new s0.c
                int r1 = r6.f1295e
                v0.c r4 = p046v0.C0678c.this
                java.lang.CharSequence r4 = p046v0.C0678c.m593b(r4)
                int r4 = p046v0.C0692n.m522u(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f1297g = r0
            L44:
                r6.f1296f = r2
                goto L97
            L47:
                v0.c r0 = p046v0.C0678c.this
                p0.p r0 = p046v0.C0678c.m594a(r0)
                v0.c r4 = p046v0.C0678c.this
                java.lang.CharSequence r4 = p046v0.C0678c.m593b(r4)
                int r5 = r6.f1296f
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                f0.j r0 = (p014f0.C0160j) r0
                if (r0 != 0) goto L73
                s0.c r0 = new s0.c
                int r1 = r6.f1295e
                v0.c r4 = p046v0.C0678c.this
                java.lang.CharSequence r4 = p046v0.C0678c.m593b(r4)
                int r4 = p046v0.C0692n.m522u(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.m2014a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.m2013b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f1295e
                s0.c r4 = p040s0.C0645d.m646g(r4, r2)
                r6.f1297g = r4
                int r2 = r2 + r0
                r6.f1295e = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f1294d = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p046v0.C0678c.C0679a.m590a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public C0643c next() {
            if (this.f1294d == -1) {
                m590a();
            }
            if (this.f1294d != 0) {
                C0643c c0643c = this.f1297g;
                C0465i.m1050c(c0643c, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f1297g = null;
                this.f1294d = -1;
                return c0643c;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1294d == -1) {
                m590a();
            }
            return this.f1294d == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0678c(CharSequence input, int i, int i2, InterfaceC0615p<? super CharSequence, ? super Integer, C0160j<Integer, Integer>> getNextMatch) {
        C0465i.m1048e(input, "input");
        C0465i.m1048e(getNextMatch, "getNextMatch");
        this.f1290a = input;
        this.f1291b = i;
        this.f1292c = i2;
        this.f1293d = getNextMatch;
    }

    @Override // p044u0.InterfaceC0664b
    public Iterator<C0643c> iterator() {
        return new C0679a();
    }
}