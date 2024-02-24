package p026l0;

import kotlin.jvm.internal.C0465i;
import p024k0.C0439a;

/* renamed from: l0.a */
/* loaded from: classes.dex */
public class C0559a extends C0439a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0.a$a */
    /* loaded from: classes.dex */
    public static final class C0560a {

        /* renamed from: a */
        public static final C0560a f1138a = new C0560a();

        /* renamed from: b */
        public static final Integer f1139b;

        /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
        static {
            /*
                l0.a$a r0 = new l0.a$a
                r0.<init>()
                p026l0.C0559a.C0560a.f1138a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L1f
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L20
            L1f:
                r1 = r0
            L20:
                if (r1 == 0) goto L2e
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2a
                r2 = 1
                goto L2b
            L2a:
                r2 = 0
            L2b:
                if (r2 == 0) goto L2e
                r0 = r1
            L2e:
                p026l0.C0559a.C0560a.f1139b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p026l0.C0559a.C0560a.<clinit>():void");
        }

        private C0560a() {
        }
    }

    /* renamed from: c */
    private final boolean m765c(int i) {
        Integer num = C0560a.f1139b;
        return num == null || num.intValue() >= i;
    }

    @Override // p024k0.C0439a
    /* renamed from: a */
    public void mo766a(Throwable cause, Throwable exception) {
        C0465i.m1048e(cause, "cause");
        C0465i.m1048e(exception, "exception");
        if (m765c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.mo766a(cause, exception);
        }
    }
}