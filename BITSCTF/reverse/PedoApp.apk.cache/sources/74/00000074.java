package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p016g0.C0195q;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    public ActivityRule(Set<ActivityFilter> filters, boolean z) {
        Set<ActivityFilter> m1945t;
        C0465i.m1048e(filters, "filters");
        this.alwaysExpand = z;
        m1945t = C0195q.m1945t(filters);
        this.filters = m1945t;
    }

    public /* synthetic */ ActivityRule(Set set, boolean z, int i, C0461e c0461e) {
        this(set, (i & 2) != 0 ? false : z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityRule) {
            ActivityRule activityRule = (ActivityRule) obj;
            return C0465i.m1052a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
        }
        return false;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + C0084a.m2143a(this.alwaysExpand);
    }

    public final ActivityRule plus$window_release(ActivityFilter filter) {
        Set m1945t;
        C0465i.m1048e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        m1945t = C0195q.m1945t(linkedHashSet);
        return new ActivityRule(m1945t, this.alwaysExpand);
    }
}