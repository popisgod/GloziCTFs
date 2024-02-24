package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.flutter.plugin.editing.a */
/* loaded from: classes.dex */
public class C0346a {

    /* renamed from: a */
    private final FlutterJNI f583a;

    public C0346a(FlutterJNI flutterJNI) {
        this.f583a = flutterJNI;
    }

    /* renamed from: a */
    public int m1522a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = length - 1;
        if (i >= i2) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i);
        int charCount = Character.charCount(codePointAt);
        int i3 = i + charCount;
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i3) == 13) {
                charCount++;
            }
            return i + charCount;
        } else if (m1516g(codePointAt)) {
            if (i3 >= i2 || !m1516g(Character.codePointAt(charSequence, i3))) {
                return i3;
            }
            int i5 = i;
            while (i5 > 0 && m1516g(Character.codePointBefore(charSequence, i))) {
                i5 -= Character.charCount(Character.codePointBefore(charSequence, i));
                i4++;
            }
            if (i4 % 2 == 0) {
                charCount += 2;
            }
            return i + charCount;
        } else {
            if (m1517f(codePointAt)) {
                charCount += Character.charCount(codePointAt);
            }
            if (codePointAt == 8419) {
                int codePointBefore = Character.codePointBefore(charSequence, i3);
                int charCount2 = i3 + Character.charCount(codePointBefore);
                if (charCount2 < length && m1514i(codePointBefore)) {
                    int codePointAt2 = Character.codePointAt(charSequence, charCount2);
                    if (m1517f(codePointAt2)) {
                        charCount += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                    }
                } else if (m1517f(codePointBefore)) {
                    charCount += Character.charCount(codePointBefore);
                }
                return i + charCount;
            }
            if (m1520c(codePointAt)) {
                boolean z = false;
                int i6 = 0;
                do {
                    if (z) {
                        charCount += Character.charCount(codePointAt) + i6 + 1;
                        z = false;
                    }
                    if (m1519d(codePointAt)) {
                        break;
                    }
                    if (i3 < length) {
                        codePointAt = Character.codePointAt(charSequence, i3);
                        i3 += Character.charCount(codePointAt);
                        if (codePointAt != 8419) {
                            if (!m1519d(codePointAt) && !m1514i(codePointAt)) {
                                if (codePointAt == 8205) {
                                    codePointAt = Character.codePointAt(charSequence, i3);
                                    i3 += Character.charCount(codePointAt);
                                    if (i3 < length && m1514i(codePointAt)) {
                                        codePointAt = Character.codePointAt(charSequence, i3);
                                        int charCount3 = Character.charCount(codePointAt);
                                        i3 += Character.charCount(codePointAt);
                                        i6 = charCount3;
                                        z = true;
                                        if (i3 < length || !z) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        z = true;
                                    }
                                }
                            } else {
                                charCount += Character.charCount(codePointAt) + 0;
                                break;
                            }
                        } else {
                            int codePointBefore2 = Character.codePointBefore(charSequence, i3);
                            int charCount4 = i3 + Character.charCount(codePointBefore2);
                            if (charCount4 < length && m1514i(codePointBefore2)) {
                                int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                                if (m1517f(codePointAt3)) {
                                    charCount += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                                }
                            } else if (m1517f(codePointBefore2)) {
                                charCount += Character.charCount(codePointBefore2);
                            }
                            return i + charCount;
                        }
                    }
                    i6 = 0;
                    if (i3 < length) {
                        break;
                    }
                } while (m1520c(codePointAt));
            }
            return i + charCount;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014c A[EDGE_INSN: B:100:0x014c->B:94:0x014c ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0144  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m1521b(java.lang.CharSequence r9, int r10) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.C0346a.m1521b(java.lang.CharSequence, int):int");
    }

    /* renamed from: c */
    public boolean m1520c(int i) {
        return this.f583a.isCodePointEmoji(i);
    }

    /* renamed from: d */
    public boolean m1519d(int i) {
        return this.f583a.isCodePointEmojiModifier(i);
    }

    /* renamed from: e */
    public boolean m1518e(int i) {
        return this.f583a.isCodePointEmojiModifierBase(i);
    }

    /* renamed from: f */
    public boolean m1517f(int i) {
        return (48 <= i && i <= 57) || i == 35 || i == 42;
    }

    /* renamed from: g */
    public boolean m1516g(int i) {
        return this.f583a.isCodePointRegionalIndicator(i);
    }

    /* renamed from: h */
    public boolean m1515h(int i) {
        return 917536 <= i && i <= 917630;
    }

    /* renamed from: i */
    public boolean m1514i(int i) {
        return this.f583a.isCodePointVariantSelector(i);
    }
}