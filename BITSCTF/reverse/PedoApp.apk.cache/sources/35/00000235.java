package p024k0;

import java.lang.reflect.Method;
import kotlin.jvm.internal.C0465i;
import p036q0.AbstractC0627c;
import p036q0.C0625b;

/* renamed from: k0.a */
/* loaded from: classes.dex */
public class C0439a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0.a$a */
    /* loaded from: classes.dex */
    public static final class C0440a {

        /* renamed from: a */
        public static final C0440a f962a = new C0440a();

        /* renamed from: b */
        public static final Method f963b;

        /* renamed from: c */
        public static final Method f964c;

        /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[LOOP:0: B:3:0x0015->B:13:0x003f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EDGE_INSN: B:24:0x0043->B:15:0x0043 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                k0.a$a r0 = new k0.a$a
                r0.<init>()
                p024k0.C0439a.C0440a.f962a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.C0465i.m1049d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L42
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.C0465i.m1052a(r7, r8)
                if (r7 == 0) goto L3b
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.jvm.internal.C0465i.m1049d(r7, r8)
                java.lang.Object r7 = p016g0.C0173a.m1994h(r7)
                boolean r7 = kotlin.jvm.internal.C0465i.m1052a(r7, r0)
                if (r7 == 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = 0
            L3c:
                if (r7 == 0) goto L3f
                goto L43
            L3f:
                int r4 = r4 + 1
                goto L15
            L42:
                r6 = r5
            L43:
                p024k0.C0439a.C0440a.f963b = r6
                int r0 = r1.length
            L46:
                if (r3 >= r0) goto L5b
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.C0465i.m1052a(r4, r6)
                if (r4 == 0) goto L58
                r5 = r2
                goto L5b
            L58:
                int r3 = r3 + 1
                goto L46
            L5b:
                p024k0.C0439a.C0440a.f964c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p024k0.C0439a.C0440a.<clinit>():void");
        }

        private C0440a() {
        }
    }

    /* renamed from: a */
    public void mo766a(Throwable cause, Throwable exception) {
        C0465i.m1048e(cause, "cause");
        C0465i.m1048e(exception, "exception");
        Method method = C0440a.f963b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    /* renamed from: b */
    public AbstractC0627c mo763b() {
        return new C0625b();
    }
}