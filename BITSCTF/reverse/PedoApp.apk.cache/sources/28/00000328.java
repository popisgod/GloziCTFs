package p046v0;

/* renamed from: v0.b */
/* loaded from: classes.dex */
class C0677b extends C0676a {
    /* renamed from: d */
    public static final boolean m595d(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c);
            char upperCase2 = Character.toUpperCase(c2);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }
}