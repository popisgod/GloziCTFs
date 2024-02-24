package p046v0;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.C0465i;
import p016g0.AbstractC0200v;
import p040s0.C0643c;

/* renamed from: v0.m */
/* loaded from: classes.dex */
public class C0691m extends C0690l {
    /* renamed from: j */
    public static final boolean m560j(String str, String suffix, boolean z) {
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(suffix, "suffix");
        return !z ? str.endsWith(suffix) : m557m(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    /* renamed from: k */
    public static /* synthetic */ boolean m559k(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m560j(str, str2, z);
    }

    /* renamed from: l */
    public static boolean m558l(CharSequence charSequence) {
        boolean z;
        C0465i.m1048e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            C0643c m523t = C0692n.m523t(charSequence);
            if (!(m523t instanceof Collection) || !((Collection) m523t).isEmpty()) {
                Iterator<Integer> it = m523t.iterator();
                while (it.hasNext()) {
                    if (!C0676a.m596c(charSequence.charAt(((AbstractC0200v) it).mo658a()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: m */
    public static final boolean m557m(String str, int i, String other, int i2, int i3, boolean z) {
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(other, "other");
        return !z ? str.regionMatches(i, other, i2, i3) : str.regionMatches(z, i, other, i2, i3);
    }

    /* renamed from: n */
    public static final boolean m556n(String str, String prefix, boolean z) {
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(prefix, "prefix");
        return !z ? str.startsWith(prefix) : m557m(str, 0, prefix, 0, prefix.length(), z);
    }

    /* renamed from: o */
    public static /* synthetic */ boolean m555o(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m556n(str, str2, z);
    }
}