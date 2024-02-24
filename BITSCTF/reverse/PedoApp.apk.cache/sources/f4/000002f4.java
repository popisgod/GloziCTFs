package p036q0;

import java.util.Random;
import kotlin.jvm.internal.C0465i;

/* renamed from: q0.b */
/* loaded from: classes.dex */
public final class C0625b extends AbstractC0624a {

    /* renamed from: f */
    private final C0626a f1223f = new C0626a();

    /* renamed from: q0.b$a */
    /* loaded from: classes.dex */
    public static final class C0626a extends ThreadLocal<Random> {
        C0626a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // p036q0.AbstractC0624a
    /* renamed from: c */
    public Random mo666c() {
        Random random = this.f1223f.get();
        C0465i.m1049d(random, "implStorage.get()");
        return random;
    }
}