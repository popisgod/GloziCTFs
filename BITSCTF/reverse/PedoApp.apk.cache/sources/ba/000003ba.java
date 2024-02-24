package p052y0;

import p014f0.C0169q;
import p034p0.InterfaceC0611l;

/* renamed from: y0.h */
/* loaded from: classes.dex */
public final class C0823h {
    /* renamed from: a */
    public static final <E> InterfaceC0820f<E> m205a(int i, EnumC0819e enumC0819e, InterfaceC0611l<? super E, C0169q> interfaceC0611l) {
        if (i == -2) {
            return new C0817d(enumC0819e == EnumC0819e.SUSPEND ? InterfaceC0820f.f1444a.m207a() : 1, enumC0819e, interfaceC0611l);
        } else if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? (i == 1 && enumC0819e == EnumC0819e.DROP_OLDEST) ? new C0831m(interfaceC0611l) : new C0817d(i, enumC0819e, interfaceC0611l) : new C0832n(interfaceC0611l) : enumC0819e == EnumC0819e.SUSPEND ? new C0836r(interfaceC0611l) : new C0817d(1, enumC0819e, interfaceC0611l);
        } else {
            if ((enumC0819e != EnumC0819e.SUSPEND ? 0 : 1) != 0) {
                return new C0831m(interfaceC0611l);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC0820f m204b(int i, EnumC0819e enumC0819e, InterfaceC0611l interfaceC0611l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            enumC0819e = EnumC0819e.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            interfaceC0611l = null;
        }
        return m205a(i, enumC0819e, interfaceC0611l);
    }
}