package p015g;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: g.b */
/* loaded from: classes.dex */
public class C0171b {
    /* renamed from: a */
    public static boolean m2002a(Object obj, Object obj2) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.equals(obj, obj2) : obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    public static int m2001b(Object... objArr) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(objArr) : Arrays.hashCode(objArr);
    }
}