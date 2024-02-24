package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import io.flutter.view.C0408c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.flutter.plugin.platform.a */
/* loaded from: classes.dex */
public class C0367a {

    /* renamed from: a */
    private C0408c f665a;

    /* renamed from: a */
    public boolean m1436a(MotionEvent motionEvent, boolean z) {
        C0408c c0408c = this.f665a;
        if (c0408c == null) {
            return false;
        }
        return c0408c.m1248M(motionEvent, z);
    }

    /* renamed from: b */
    public boolean m1435b(View view, View view2, AccessibilityEvent accessibilityEvent) {
        C0408c c0408c = this.f665a;
        if (c0408c == null) {
            return false;
        }
        return c0408c.m1207w(view, view2, accessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m1434c(C0408c c0408c) {
        this.f665a = c0408c;
    }
}