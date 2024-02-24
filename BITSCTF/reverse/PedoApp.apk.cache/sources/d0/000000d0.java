package androidx.window.layout;

import androidx.window.core.ExperimentalWindowApi;
import androidx.window.layout.WindowMetricsCalculator;

/* renamed from: androidx.window.layout.e */
/* loaded from: classes.dex */
public final /* synthetic */ class C0098e {
    static {
        WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.Companion;
    }

    /* renamed from: a */
    public static WindowMetricsCalculator m2137a() {
        return WindowMetricsCalculator.Companion.getOrCreate();
    }

    @ExperimentalWindowApi
    /* renamed from: b */
    public static void m2136b(WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator) {
        WindowMetricsCalculator.Companion.overrideDecorator(windowMetricsCalculatorDecorator);
    }

    @ExperimentalWindowApi
    /* renamed from: c */
    public static void m2135c() {
        WindowMetricsCalculator.Companion.reset();
    }
}