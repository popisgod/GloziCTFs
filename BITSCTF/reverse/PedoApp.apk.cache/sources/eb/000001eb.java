package io.flutter.plugin.platform;

import android.content.Context;
import android.view.MotionEvent;
import io.flutter.embedding.android.C0265f;

/* renamed from: io.flutter.plugin.platform.c */
/* loaded from: classes.dex */
public class C0370c extends C0265f {

    /* renamed from: g */
    private C0367a f673g;

    public C0370c(Context context, int i, int i2, C0367a c0367a) {
        super(context, i, i2, C0265f.EnumC0267b.overlay);
        this.f673g = c0367a;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        C0367a c0367a = this.f673g;
        if (c0367a == null || !c0367a.m1436a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}