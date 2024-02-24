package p046v0;

import p040s0.C0643c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: v0.a */
/* loaded from: classes.dex */
public class C0676a {
    /* renamed from: a */
    public static final int m598a(int i) {
        if (new C0643c(2, 36).m656f(i)) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new C0643c(2, 36));
    }

    /* renamed from: b */
    public static final int m597b(char c, int i) {
        return Character.digit((int) c, i);
    }

    /* renamed from: c */
    public static final boolean m596c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}