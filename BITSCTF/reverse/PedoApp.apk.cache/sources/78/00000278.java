package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C0461e;
import p048w0.C0768p0;

/* renamed from: kotlinx.coroutines.internal.l */
/* loaded from: classes.dex */
public final class C0501l<E> {
    /* renamed from: a */
    public static <E> Object m948a(Object obj) {
        return obj;
    }

    /* renamed from: b */
    public static /* synthetic */ Object m947b(Object obj, int i, C0461e c0461e) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m948a(obj);
    }

    /* renamed from: c */
    public static final Object m946c(Object obj, E e) {
        if (!C0768p0.m398a() || (!(e instanceof List))) {
            if (obj == null) {
                return m948a(e);
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(e);
                return m948a(obj);
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            return m948a(arrayList);
        }
        throw new AssertionError();
    }
}