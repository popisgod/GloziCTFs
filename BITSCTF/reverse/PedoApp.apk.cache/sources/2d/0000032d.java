package p046v0;

import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0465i;
import p034p0.InterfaceC0611l;

/* renamed from: v0.f */
/* loaded from: classes.dex */
public class C0682f extends C0681e {

    /* renamed from: v0.f$a */
    /* loaded from: classes.dex */
    public static final class C0683a extends AbstractC0466j implements InterfaceC0611l<String, String> {

        /* renamed from: d */
        public static final C0683a f1300d = new C0683a();

        C0683a() {
            super(1);
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final String invoke(String line) {
            C0465i.m1048e(line, "line");
            return line;
        }
    }

    /* renamed from: v0.f$b */
    /* loaded from: classes.dex */
    public static final class C0684b extends AbstractC0466j implements InterfaceC0611l<String, String> {

        /* renamed from: d */
        final /* synthetic */ String f1301d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0684b(String str) {
            super(1);
            this.f1301d = str;
        }

        @Override // p034p0.InterfaceC0611l
        /* renamed from: a */
        public final String invoke(String line) {
            C0465i.m1048e(line, "line");
            return this.f1301d + line;
        }
    }

    /* renamed from: b */
    private static final InterfaceC0611l<String, String> m570b(String str) {
        return str.length() == 0 ? C0683a.f1300d : new C0684b(str);
    }

    /* renamed from: c */
    private static final int m569c(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!C0676a.m596c(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00ba A[SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String m568d(java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.C0465i.m1048e(r14, r0)
            java.lang.String r0 = "newIndent"
            kotlin.jvm.internal.C0465i.m1048e(r15, r0)
            java.util.List r0 = p046v0.C0692n.m546I(r14)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
        L17:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.next()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = p046v0.C0680d.m575l(r4)
            r4 = r4 ^ 1
            if (r4 == 0) goto L17
            r1.add(r3)
            goto L17
        L30:
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = p016g0.C0185g.m1972g(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L3f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L57
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            int r3 = m569c(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.add(r3)
            goto L3f
        L57:
            java.lang.Comparable r1 = p016g0.C0185g.m1968m(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r2 = 0
            if (r1 == 0) goto L65
            int r1 = r1.intValue()
            goto L66
        L65:
            r1 = 0
        L66:
            int r14 = r14.length()
            int r3 = r15.length()
            int r4 = r0.size()
            int r3 = r3 * r4
            int r14 = r14 + r3
            p0.l r15 = m570b(r15)
            int r3 = p016g0.C0185g.m1976c(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r0 = r0.iterator()
        L86:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto Lbc
            java.lang.Object r5 = r0.next()
            int r6 = r2 + 1
            if (r2 >= 0) goto L97
            p016g0.C0185g.m1973f()
        L97:
            java.lang.String r5 = (java.lang.String) r5
            if (r2 == 0) goto L9d
            if (r2 != r3) goto La5
        L9d:
            boolean r2 = p046v0.C0680d.m575l(r5)
            if (r2 == 0) goto La5
            r5 = 0
            goto Lb5
        La5:
            java.lang.String r2 = p046v0.C0696p.m514b0(r5, r1)
            if (r2 == 0) goto Lb5
            java.lang.Object r2 = r15.invoke(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto Lb4
            goto Lb5
        Lb4:
            r5 = r2
        Lb5:
            if (r5 == 0) goto Lba
            r4.add(r5)
        Lba:
            r2 = r6
            goto L86
        Lbc:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r14)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 124(0x7c, float:1.74E-43)
            r13 = 0
            java.lang.String r6 = "\n"
            java.lang.Appendable r14 = p016g0.C0185g.m1970j(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.StringBuilder r14 = (java.lang.StringBuilder) r14
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "mapIndexedNotNull { inde…\"\\n\")\n        .toString()"
            kotlin.jvm.internal.C0465i.m1049d(r14, r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p046v0.C0682f.m568d(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: e */
    public static String m567e(String str) {
        C0465i.m1048e(str, "<this>");
        return m568d(str, "");
    }
}