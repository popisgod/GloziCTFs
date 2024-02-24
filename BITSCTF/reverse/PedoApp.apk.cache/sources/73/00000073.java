package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.C0465i;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ActivityFilter(android.content.ComponentName r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r0 = "componentName"
            kotlin.jvm.internal.C0465i.m1048e(r12, r0)
            r11.<init>()
            r11.componentName = r12
            r11.intentAction = r13
            java.lang.String r13 = r12.getPackageName()
            java.lang.String r0 = "componentName.packageName"
            kotlin.jvm.internal.C0465i.m1049d(r13, r0)
            java.lang.String r12 = r12.getClassName()
            java.lang.String r0 = "componentName.className"
            kotlin.jvm.internal.C0465i.m1049d(r12, r0)
            int r0 = r13.length()
            r7 = 1
            r8 = 0
            if (r0 <= 0) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            if (r0 == 0) goto L99
            int r0 = r12.length()
            if (r0 <= 0) goto L33
            r0 = 1
            goto L34
        L33:
            r0 = 0
        L34:
            if (r0 == 0) goto L8d
            java.lang.String r0 = "*"
            r9 = 2
            r10 = 0
            boolean r1 = p046v0.C0680d.m573r(r13, r0, r8, r9, r10)
            if (r1 == 0) goto L55
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.lang.String r2 = "*"
            r1 = r13
            int r1 = p046v0.C0680d.m588A(r1, r2, r3, r4, r5, r6)
            int r13 = r13.length()
            int r13 = r13 - r7
            if (r1 != r13) goto L53
            goto L55
        L53:
            r13 = 0
            goto L56
        L55:
            r13 = 1
        L56:
            if (r13 == 0) goto L81
            boolean r13 = p046v0.C0680d.m573r(r12, r0, r8, r9, r10)
            if (r13 == 0) goto L72
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.lang.String r2 = "*"
            r1 = r12
            int r13 = p046v0.C0680d.m588A(r1, r2, r3, r4, r5, r6)
            int r12 = r12.length()
            int r12 = r12 - r7
            if (r13 != r12) goto L71
            goto L72
        L71:
            r7 = 0
        L72:
            if (r7 == 0) goto L75
            return
        L75:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Wildcard in class name is only allowed at the end."
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L81:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Wildcard in package name is only allowed at the end."
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L8d:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Activity class name must not be empty."
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L99:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Package name must not be empty"
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.ActivityFilter.<init>(android.content.ComponentName, java.lang.String):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityFilter) {
            ActivityFilter activityFilter = (ActivityFilter) obj;
            return C0465i.m1052a(this.componentName, activityFilter.componentName) && C0465i.m1052a(this.intentAction, activityFilter.intentAction);
        }
        return false;
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int hashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivity(Activity activity) {
        C0465i.m1048e(activity, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            String str = this.intentAction;
            if (str != null) {
                Intent intent = activity.getIntent();
                if (C0465i.m1052a(str, intent == null ? null : intent.getAction())) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(Intent intent) {
        C0465i.m1048e(intent, "intent");
        if (MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            String str = this.intentAction;
            return str == null || C0465i.m1052a(str, intent.getAction());
        }
        return false;
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + ((Object) this.intentAction) + ')';
    }
}