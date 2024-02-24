package p038r0;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.C0465i;
import p036q0.AbstractC0624a;

/* renamed from: r0.a */
/* loaded from: classes.dex */
public final class C0637a extends AbstractC0624a {
    @Override // p036q0.AbstractC0624a
    /* renamed from: c */
    public Random mo666c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        C0465i.m1049d(current, "ThreadLocalRandom.current()");
        return current;
    }
}