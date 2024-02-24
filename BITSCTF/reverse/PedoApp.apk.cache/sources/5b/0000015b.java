package p018h0;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: h0.b */
/* loaded from: classes.dex */
public class C0236b {
    /* renamed from: a */
    public static <T extends Comparable<?>> int m1833a(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }
}