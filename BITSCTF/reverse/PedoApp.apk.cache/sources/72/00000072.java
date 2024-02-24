package androidx.window.core;

import java.math.BigInteger;
import kotlin.jvm.internal.AbstractC0466j;
import p034p0.InterfaceC0600a;

/* loaded from: classes.dex */
final class Version$bigInteger$2 extends AbstractC0466j implements InterfaceC0600a<BigInteger> {
    final /* synthetic */ Version this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Version$bigInteger$2(Version version) {
        super(0);
        this.this$0 = version;
    }

    @Override // p034p0.InterfaceC0600a
    public final BigInteger invoke() {
        return BigInteger.valueOf(this.this$0.getMajor()).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getMinor())).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getPatch()));
    }
}