package kotlin.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;

@Metadata(m26d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m25d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, m24k = 2, m23mv = {1, 8, 0}, m21xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: kotlin.internal.UProgressionUtilKt */
/* loaded from: classes.dex */
public final class UProgressionUtil {
    /* renamed from: differenceModulo-WZ9TVnA */
    private static final int m1392differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int compare;
        int m17m = UByte$$ExternalSyntheticBackport0.m17m(i, i3);
        int m17m2 = UByte$$ExternalSyntheticBackport0.m17m(i2, i3);
        compare = Integer.compare(m17m ^ Integer.MIN_VALUE, m17m2 ^ Integer.MIN_VALUE);
        int m273constructorimpl = UInt.m273constructorimpl(m17m - m17m2);
        return compare >= 0 ? m273constructorimpl : UInt.m273constructorimpl(m273constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE */
    private static final long m1393differenceModulosambcqE(long j, long j2, long j3) {
        int compare;
        long m15m = UByte$$ExternalSyntheticBackport0.m15m(j, j3);
        long m15m2 = UByte$$ExternalSyntheticBackport0.m15m(j2, j3);
        compare = Long.compare(m15m ^ Long.MIN_VALUE, m15m2 ^ Long.MIN_VALUE);
        long m352constructorimpl = ULong.m352constructorimpl(m15m - m15m2);
        return compare >= 0 ? m352constructorimpl : ULong.m352constructorimpl(m352constructorimpl + j3);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs */
    public static final int m1395getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        int compare;
        int compare2;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            return compare2 >= 0 ? i2 : UInt.m273constructorimpl(i2 - m1392differenceModuloWZ9TVnA(i2, i, UInt.m273constructorimpl(i3)));
        } else if (i3 < 0) {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            return compare <= 0 ? i2 : UInt.m273constructorimpl(i2 + m1392differenceModuloWZ9TVnA(i, i2, UInt.m273constructorimpl(-i3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    /* renamed from: getProgressionLastElement-7ftBX0g */
    public static final long m1394getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        int compare;
        int compare2;
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 >= 0 ? j2 : ULong.m352constructorimpl(j2 - m1393differenceModulosambcqE(j2, j, ULong.m352constructorimpl(j3)));
        } else if (i < 0) {
            compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare <= 0 ? j2 : ULong.m352constructorimpl(j2 + m1393differenceModulosambcqE(j, j2, ULong.m352constructorimpl(-j3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}