package androidx.window.layout;

import kotlin.jvm.internal.C0464h;
import kotlin.jvm.internal.C0465i;
import p034p0.InterfaceC0611l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends C0464h implements InterfaceC0611l<WindowMetricsCalculator, WindowMetricsCalculator> {
    public WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    @Override // p034p0.InterfaceC0611l
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator p0) {
        C0465i.m1048e(p0, "p0");
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(p0);
    }
}