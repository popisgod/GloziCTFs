package p046v0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0465i;
import p014f0.C0160j;
import p014f0.C0166n;
import p016g0.AbstractC0200v;
import p016g0.C0179d;
import p016g0.C0181e;
import p016g0.C0195q;
import p034p0.InterfaceC0611l;
import p034p0.InterfaceC0615p;
import p040s0.C0640a;
import p040s0.C0643c;
import p040s0.C0647f;
import p044u0.C0671h;
import p044u0.InterfaceC0664b;

/* renamed from: v0.n */
/* loaded from: classes.dex */
public class C0692n extends C0691m {

    /* renamed from: v0.n$a */
    /* loaded from: classes.dex */
    public static final class C0693a extends AbstractC0466j implements InterfaceC0615p<CharSequence, Integer, C0160j<? extends Integer, ? extends Integer>> {

        /* renamed from: d */
        final /* synthetic */ List<String> f1302d;

        /* renamed from: e */
        final /* synthetic */ boolean f1303e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0693a(List<String> list, boolean z) {
            super(2);
            this.f1302d = list;
            this.f1303e = z;
        }

        /* renamed from: a */
        public final C0160j<Integer, Integer> m516a(CharSequence $receiver, int i) {
            C0465i.m1048e($receiver, "$this$$receiver");
            C0160j m524s = C0692n.m524s($receiver, this.f1302d, i, this.f1303e, false);
            if (m524s != null) {
                return C0166n.m2003a(m524s.m2012c(), Integer.valueOf(((String) m524s.m2011d()).length()));
            }
            return null;
        }

        @Override // p034p0.InterfaceC0615p
        public /* bridge */ /* synthetic */ C0160j<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return m516a(charSequence, num.intValue());
        }
    }

    /* renamed from: v0.n$b */
    /* loaded from: classes.dex */
    public static final class C0694b extends AbstractC0466j implements InterfaceC0611l<C0643c, String> {

        /* renamed from: d */
        final /* synthetic */ CharSequence f1304d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0694b(CharSequence charSequence) {
            super(1);
            this.f1304d = charSequence;
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final String invoke(C0643c it) {
            C0465i.m1048e(it, "it");
            return C0692n.m539P(this.f1304d, it);
        }
    }

    /* renamed from: A */
    public static /* synthetic */ int m554A(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m520w(charSequence, str, i, z);
    }

    /* renamed from: B */
    public static final int m553B(CharSequence charSequence, char[] chars, int i, boolean z) {
        int m645a;
        boolean z2;
        char m1984g;
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            m1984g = C0181e.m1984g(chars);
            return ((String) charSequence).indexOf(m1984g, i);
        }
        m645a = C0647f.m645a(i, 0);
        AbstractC0200v it = new C0643c(m645a, m522u(charSequence)).iterator();
        while (it.hasNext()) {
            int mo658a = it.mo658a();
            char charAt = charSequence.charAt(mo658a);
            int length = chars.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    continue;
                    break;
                } else if (C0677b.m595d(chars[i2], charAt, z)) {
                    z2 = true;
                    continue;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return mo658a;
            }
        }
        return -1;
    }

    /* renamed from: C */
    public static final int m552C(CharSequence charSequence, char c, int i, boolean z) {
        C0465i.m1048e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? m548G(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    /* renamed from: D */
    public static final int m551D(CharSequence charSequence, String string, int i, boolean z) {
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(string, "string");
        return (z || !(charSequence instanceof String)) ? m519x(charSequence, string, i, 0, z, true) : ((String) charSequence).lastIndexOf(string, i);
    }

    /* renamed from: E */
    public static /* synthetic */ int m550E(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m522u(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m552C(charSequence, c, i, z);
    }

    /* renamed from: F */
    public static /* synthetic */ int m549F(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m522u(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m551D(charSequence, str, i, z);
    }

    /* renamed from: G */
    public static final int m548G(CharSequence charSequence, char[] chars, int i, boolean z) {
        int m643c;
        char m1984g;
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            m1984g = C0181e.m1984g(chars);
            return ((String) charSequence).lastIndexOf(m1984g, i);
        }
        for (m643c = C0647f.m643c(i, m522u(charSequence)); -1 < m643c; m643c--) {
            char charAt = charSequence.charAt(m643c);
            int length = chars.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (C0677b.m595d(chars[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return m643c;
            }
        }
        return -1;
    }

    /* renamed from: H */
    public static final InterfaceC0664b<String> m547H(CharSequence charSequence) {
        C0465i.m1048e(charSequence, "<this>");
        return m540O(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    /* renamed from: I */
    public static final List<String> m546I(CharSequence charSequence) {
        List<String> m604e;
        C0465i.m1048e(charSequence, "<this>");
        m604e = C0671h.m604e(m547H(charSequence));
        return m604e;
    }

    /* renamed from: J */
    private static final InterfaceC0664b<C0643c> m545J(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        List m1991a;
        m542M(i2);
        m1991a = C0179d.m1991a(strArr);
        return new C0678c(charSequence, i, i2, new C0693a(m1991a, z));
    }

    /* renamed from: K */
    static /* synthetic */ InterfaceC0664b m544K(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m545J(charSequence, strArr, i, z, i2);
    }

    /* renamed from: L */
    public static final boolean m543L(CharSequence charSequence, int i, CharSequence other, int i2, int i3, boolean z) {
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(other, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C0677b.m595d(charSequence.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: M */
    public static final void m542M(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    /* renamed from: N */
    public static final InterfaceC0664b<String> m541N(CharSequence charSequence, String[] delimiters, boolean z, int i) {
        InterfaceC0664b<String> m606c;
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(delimiters, "delimiters");
        m606c = C0671h.m606c(m544K(charSequence, delimiters, 0, z, i, 2, null), new C0694b(charSequence));
        return m606c;
    }

    /* renamed from: O */
    public static /* synthetic */ InterfaceC0664b m540O(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m541N(charSequence, strArr, z, i);
    }

    /* renamed from: P */
    public static final String m539P(CharSequence charSequence, C0643c range) {
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(range, "range");
        return charSequence.subSequence(range.m654h().intValue(), range.m655g().intValue() + 1).toString();
    }

    /* renamed from: Q */
    public static final String m538Q(String str, char c, String missingDelimiterValue) {
        int m517z;
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(missingDelimiterValue, "missingDelimiterValue");
        m517z = m517z(str, c, 0, false, 6, null);
        if (m517z == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(m517z + 1, str.length());
        C0465i.m1049d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: R */
    public static final String m537R(String str, String delimiter, String missingDelimiterValue) {
        int m554A;
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(delimiter, "delimiter");
        C0465i.m1048e(missingDelimiterValue, "missingDelimiterValue");
        m554A = m554A(str, delimiter, 0, false, 6, null);
        if (m554A == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(m554A + delimiter.length(), str.length());
        C0465i.m1049d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: S */
    public static /* synthetic */ String m536S(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m538Q(str, c, str2);
    }

    /* renamed from: T */
    public static /* synthetic */ String m535T(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m537R(str, str2, str3);
    }

    /* renamed from: U */
    public static final String m534U(String str, char c, String missingDelimiterValue) {
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(missingDelimiterValue, "missingDelimiterValue");
        int m550E = m550E(str, c, 0, false, 6, null);
        if (m550E == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(m550E + 1, str.length());
        C0465i.m1049d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: V */
    public static /* synthetic */ String m533V(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m534U(str, c, str2);
    }

    /* renamed from: W */
    public static final String m532W(String str, char c, String missingDelimiterValue) {
        int m517z;
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(missingDelimiterValue, "missingDelimiterValue");
        m517z = m517z(str, c, 0, false, 6, null);
        if (m517z == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, m517z);
        C0465i.m1049d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: X */
    public static final String m531X(String str, String delimiter, String missingDelimiterValue) {
        int m554A;
        C0465i.m1048e(str, "<this>");
        C0465i.m1048e(delimiter, "delimiter");
        C0465i.m1048e(missingDelimiterValue, "missingDelimiterValue");
        m554A = m554A(str, delimiter, 0, false, 6, null);
        if (m554A == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, m554A);
        C0465i.m1049d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: Y */
    public static /* synthetic */ String m530Y(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m532W(str, c, str2);
    }

    /* renamed from: Z */
    public static /* synthetic */ String m529Z(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m531X(str, str2, str3);
    }

    /* renamed from: a0 */
    public static CharSequence m528a0(CharSequence charSequence) {
        C0465i.m1048e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean m596c = C0676a.m596c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!m596c) {
                    break;
                }
                length--;
            } else if (m596c) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    /* renamed from: q */
    public static final boolean m526q(CharSequence charSequence, CharSequence other, boolean z) {
        int m554A;
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(other, "other");
        if (other instanceof String) {
            m554A = m554A(charSequence, (String) other, 0, z, 2, null);
            if (m554A >= 0) {
                return true;
            }
        } else if (m518y(charSequence, other, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: r */
    public static /* synthetic */ boolean m525r(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m526q(charSequence, charSequence2, z);
    }

    /* renamed from: s */
    public static final C0160j<Integer, String> m524s(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        int m643c;
        C0640a m640f;
        int m663a;
        Object obj;
        String str;
        Object obj2;
        int m645a;
        Object m1951n;
        if (!z && collection.size() == 1) {
            m1951n = C0195q.m1951n(collection);
            String str2 = (String) m1951n;
            int m554A = !z2 ? m554A(charSequence, str2, i, false, 4, null) : m549F(charSequence, str2, i, false, 4, null);
            if (m554A < 0) {
                return null;
            }
            return C0166n.m2003a(Integer.valueOf(m554A), str2);
        }
        if (z2) {
            m643c = C0647f.m643c(i, m522u(charSequence));
            m640f = C0647f.m640f(m643c, 0);
        } else {
            m645a = C0647f.m645a(i, 0);
            m640f = new C0643c(m645a, charSequence.length());
        }
        if (charSequence instanceof String) {
            m663a = m640f.m663a();
            int m662b = m640f.m662b();
            int m661c = m640f.m661c();
            if ((m661c > 0 && m663a <= m662b) || (m661c < 0 && m662b <= m663a)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str3 = (String) obj2;
                        if (C0691m.m557m(str3, 0, (String) charSequence, m663a, str3.length(), z)) {
                            break;
                        }
                    }
                    str = (String) obj2;
                    if (str == null) {
                        if (m663a == m662b) {
                            break;
                        }
                        m663a += m661c;
                    } else {
                        break;
                    }
                }
                return C0166n.m2003a(Integer.valueOf(m663a), str);
            }
            return null;
        }
        m663a = m640f.m663a();
        int m662b2 = m640f.m662b();
        int m661c2 = m640f.m661c();
        if ((m661c2 > 0 && m663a <= m662b2) || (m661c2 < 0 && m662b2 <= m663a)) {
            while (true) {
                Iterator<T> it2 = collection.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    String str4 = (String) obj;
                    if (m543L(str4, 0, charSequence, m663a, str4.length(), z)) {
                        break;
                    }
                }
                str = (String) obj;
                if (str == null) {
                    if (m663a == m662b2) {
                        break;
                    }
                    m663a += m661c2;
                } else {
                    break;
                }
            }
            return C0166n.m2003a(Integer.valueOf(m663a), str);
        }
        return null;
    }

    /* renamed from: t */
    public static final C0643c m523t(CharSequence charSequence) {
        C0465i.m1048e(charSequence, "<this>");
        return new C0643c(0, charSequence.length() - 1);
    }

    /* renamed from: u */
    public static final int m522u(CharSequence charSequence) {
        C0465i.m1048e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    /* renamed from: v */
    public static final int m521v(CharSequence charSequence, char c, int i, boolean z) {
        C0465i.m1048e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? m553B(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    /* renamed from: w */
    public static final int m520w(CharSequence charSequence, String string, int i, boolean z) {
        C0465i.m1048e(charSequence, "<this>");
        C0465i.m1048e(string, "string");
        return (z || !(charSequence instanceof String)) ? m518y(charSequence, string, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(string, i);
    }

    /* renamed from: x */
    private static final int m519x(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        int m643c;
        int m645a;
        C0640a m640f;
        int m645a2;
        int m643c2;
        if (z2) {
            m643c = C0647f.m643c(i, m522u(charSequence));
            m645a = C0647f.m645a(i2, 0);
            m640f = C0647f.m640f(m643c, m645a);
        } else {
            m645a2 = C0647f.m645a(i, 0);
            m643c2 = C0647f.m643c(i2, charSequence.length());
            m640f = new C0643c(m645a2, m643c2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int m663a = m640f.m663a();
            int m662b = m640f.m662b();
            int m661c = m640f.m661c();
            if ((m661c <= 0 || m663a > m662b) && (m661c >= 0 || m662b > m663a)) {
                return -1;
            }
            while (!C0691m.m557m((String) charSequence2, 0, (String) charSequence, m663a, charSequence2.length(), z)) {
                if (m663a == m662b) {
                    return -1;
                }
                m663a += m661c;
            }
            return m663a;
        }
        int m663a2 = m640f.m663a();
        int m662b2 = m640f.m662b();
        int m661c2 = m640f.m661c();
        if ((m661c2 <= 0 || m663a2 > m662b2) && (m661c2 >= 0 || m662b2 > m663a2)) {
            return -1;
        }
        while (!m543L(charSequence2, 0, charSequence, m663a2, charSequence2.length(), z)) {
            if (m663a2 == m662b2) {
                return -1;
            }
            m663a2 += m661c2;
        }
        return m663a2;
    }

    /* renamed from: y */
    static /* synthetic */ int m518y(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return m519x(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    /* renamed from: z */
    public static /* synthetic */ int m517z(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m521v(charSequence, c, i, z);
    }
}