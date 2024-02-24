package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: kotlinx.coroutines.internal.b0 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0475b0 {

    /* renamed from: a */
    private static final int f993a = Runtime.getRuntime().availableProcessors();

    /* renamed from: a */
    public static final int m1008a() {
        return f993a;
    }

    /* renamed from: b */
    public static final String m1007b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}