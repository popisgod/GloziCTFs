package p046v0;

import kotlin.jvm.internal.C0465i;
import p034p0.InterfaceC0611l;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: v0.e */
/* loaded from: classes.dex */
public class C0681e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* renamed from: a */
    public static <T> void m571a(Appendable appendable, T t, InterfaceC0611l<? super T, ? extends CharSequence> interfaceC0611l) {
        CharSequence valueOf;
        C0465i.m1048e(appendable, "<this>");
        if (interfaceC0611l != null) {
            t = (T) interfaceC0611l.invoke(t);
        } else {
            if (!(t == 0 ? true : t instanceof CharSequence)) {
                if (t instanceof Character) {
                    appendable.append(((Character) t).charValue());
                    return;
                }
                valueOf = String.valueOf((Object) t);
                appendable.append(valueOf);
            }
        }
        valueOf = (CharSequence) t;
        appendable.append(valueOf);
    }
}