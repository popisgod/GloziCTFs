package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.C0465i;

/* loaded from: classes.dex */
public final class ActivityCompatHelperApi24 {
    public static final ActivityCompatHelperApi24 INSTANCE = new ActivityCompatHelperApi24();

    private ActivityCompatHelperApi24() {
    }

    public final boolean isInMultiWindowMode(Activity activity) {
        C0465i.m1048e(activity, "activity");
        return activity.isInMultiWindowMode();
    }
}