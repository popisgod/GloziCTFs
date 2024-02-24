package p044u0;

import java.util.Iterator;
import kotlin.jvm.internal.C0465i;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: u0.f */
/* loaded from: classes.dex */
public class C0668f extends C0667e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: u0.f$a */
    /* loaded from: classes.dex */
    public static final class C0669a<T> implements InterfaceC0664b<T> {

        /* renamed from: a */
        final /* synthetic */ Iterator f1285a;

        public C0669a(Iterator it) {
            this.f1285a = it;
        }

        @Override // p044u0.InterfaceC0664b
        public Iterator<T> iterator() {
            return this.f1285a;
        }
    }

    /* renamed from: a */
    public static <T> InterfaceC0664b<T> m608a(Iterator<? extends T> it) {
        C0465i.m1048e(it, "<this>");
        return m607b(new C0669a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static final <T> InterfaceC0664b<T> m607b(InterfaceC0664b<? extends T> interfaceC0664b) {
        C0465i.m1048e(interfaceC0664b, "<this>");
        return interfaceC0664b instanceof C0663a ? interfaceC0664b : new C0663a(interfaceC0664b);
    }
}