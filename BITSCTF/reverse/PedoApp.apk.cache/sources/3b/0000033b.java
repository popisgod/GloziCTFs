package p046v0;

import kotlin.jvm.internal.C0465i;
import p040s0.C0647f;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: v0.p */
/* loaded from: classes.dex */
public class C0696p extends C0695o {
    /* renamed from: b0 */
    public static final String m514b0(String str, int i) {
        int m643c;
        C0465i.m1048e(str, "<this>");
        if (i >= 0) {
            m643c = C0647f.m643c(i, str.length());
            String substring = str.substring(m643c);
            C0465i.m1049d(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}