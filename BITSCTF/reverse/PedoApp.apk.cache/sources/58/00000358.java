package p048w0;

import java.io.Closeable;
import kotlin.jvm.internal.AbstractC0466j;
import kotlin.jvm.internal.C0461e;
import p020i0.AbstractC0241b;
import p020i0.InterfaceC0249g;
import p034p0.InterfaceC0611l;

/* renamed from: w0.f1 */
/* loaded from: classes.dex */
public abstract class AbstractC0725f1 extends AbstractC0722f0 implements Closeable {

    /* renamed from: e */
    public static final C0726a f1321e = new C0726a(null);

    /* renamed from: w0.f1$a */
    /* loaded from: classes.dex */
    public static final class C0726a extends AbstractC0241b<AbstractC0722f0, AbstractC0725f1> {

        /* renamed from: w0.f1$a$a */
        /* loaded from: classes.dex */
        static final class C0727a extends AbstractC0466j implements InterfaceC0611l<InterfaceC0249g.InterfaceC0252b, AbstractC0725f1> {

            /* renamed from: d */
            public static final C0727a f1322d = new C0727a();

            C0727a() {
                super(1);
            }

            @Override // p034p0.InterfaceC0611l
            /* renamed from: a */
            public final AbstractC0725f1 invoke(InterfaceC0249g.InterfaceC0252b interfaceC0252b) {
                if (interfaceC0252b instanceof AbstractC0725f1) {
                    return (AbstractC0725f1) interfaceC0252b;
                }
                return null;
            }
        }

        private C0726a() {
            super(AbstractC0722f0.f1319d, C0727a.f1322d);
        }

        public /* synthetic */ C0726a(C0461e c0461e) {
            this();
        }
    }
}