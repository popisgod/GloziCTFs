package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Limit.kt */
@Metadata(m24k = 3, m23mv = {1, 6, 0}, m21xi = 176)
@DebugMetadata(m14c = "kotlinx.coroutines.flow.FlowKt__LimitKt", m13f = "Limit.kt", m12i = {0}, m11l = {136}, m10m = "collectWhile", m9n = {"collector"}, m8s = {"L$0"})
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FlowKt__LimitKt$collectWhile$1(Continuation<? super FlowKt__LimitKt$collectWhile$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Limit.collectWhile(null, null, this);
    }
}