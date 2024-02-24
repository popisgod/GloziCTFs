package p040s0;

import java.util.NoSuchElementException;
import p016g0.AbstractC0200v;

/* renamed from: s0.b */
/* loaded from: classes.dex */
public final class C0642b extends AbstractC0200v {

    /* renamed from: d */
    private final int f1266d;

    /* renamed from: e */
    private final int f1267e;

    /* renamed from: f */
    private boolean f1268f;

    /* renamed from: g */
    private int f1269g;

    public C0642b(int i, int i2, int i3) {
        this.f1266d = i3;
        this.f1267e = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f1268f = z;
        this.f1269g = z ? i : i2;
    }

    @Override // p016g0.AbstractC0200v
    /* renamed from: a */
    public int mo658a() {
        int i = this.f1269g;
        if (i != this.f1267e) {
            this.f1269g = this.f1266d + i;
        } else if (!this.f1268f) {
            throw new NoSuchElementException();
        } else {
            this.f1268f = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1268f;
    }
}