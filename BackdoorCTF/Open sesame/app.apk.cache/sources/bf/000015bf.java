package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TimeSources.kt */
@Metadata(m26d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m25d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, m24k = 1, m23mv = {1, 8, 0}, m21xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    @Override // kotlin.time.AbstractLongTimeSource
    protected long read() {
        return this.reading;
    }

    public TestTimeSource() {
        super(DurationUnitJvm.NANOSECONDS);
    }

    /* renamed from: plusAssign-LRDsOJo */
    public final void m1631plusAssignLRDsOJo(long j) {
        long j2;
        long m1542toLongimpl = Duration.m1542toLongimpl(j, getUnit());
        if (m1542toLongimpl == Long.MIN_VALUE || m1542toLongimpl == Long.MAX_VALUE) {
            double m1539toDoubleimpl = this.reading + Duration.m1539toDoubleimpl(j, getUnit());
            if (m1539toDoubleimpl > 9.223372036854776E18d || m1539toDoubleimpl < -9.223372036854776E18d) {
                m1630overflowLRDsOJo(j);
            }
            j2 = (long) m1539toDoubleimpl;
        } else {
            long j3 = this.reading;
            j2 = j3 + m1542toLongimpl;
            if ((m1542toLongimpl ^ j3) >= 0 && (j3 ^ j2) < 0) {
                m1630overflowLRDsOJo(j);
            }
        }
        this.reading = j2;
    }

    /* renamed from: overflow-LRDsOJo */
    private final void m1630overflowLRDsOJo(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1545toStringimpl(j)) + '.');
    }
}