package androidx.window.embedding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.jvm.internal.C0465i;
import p016g0.C0188j;
import p016g0.C0195q;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class EmbeddingAdapter {
    /* renamed from: a */
    public static /* synthetic */ boolean m2149a(Set set, Activity activity) {
        return m2307translateActivityPredicates$lambda6(set, activity);
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m2148b(SplitRule splitRule, WindowMetrics windowMetrics) {
        return m2309translateParentMetricsPredicate$lambda4(splitRule, windowMetrics);
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m2147c(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        return m2305translateActivityIntentPredicates$lambda3(embeddingAdapter, set, pair);
    }

    private final <F, S> F component1(Pair<F, S> pair) {
        C0465i.m1048e(pair, "<this>");
        return (F) pair.first;
    }

    private final <F, S> S component2(Pair<F, S> pair) {
        C0465i.m1048e(pair, "<this>");
        return (S) pair.second;
    }

    /* renamed from: d */
    public static /* synthetic */ boolean m2146d(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        return m2306translateActivityPairPredicates$lambda1(embeddingAdapter, set, pair);
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m2145e(Set set, Intent intent) {
        return m2308translateIntentPredicates$lambda8(set, intent);
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        boolean z;
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        C0465i.m1049d(primaryActivityStack, "splitInfo.primaryActivityStack");
        boolean z2 = false;
        try {
            z = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z = false;
        }
        List activities = primaryActivityStack.getActivities();
        C0465i.m1049d(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, z);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        C0465i.m1049d(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        try {
            z2 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        C0465i.m1049d(activities2, "secondaryActivityStack.activities");
        return new SplitInfo(activityStack, new ActivityStack(activities2, z2), splitInfo.getSplitRatio());
    }

    /* renamed from: translateActivityIntentPredicates$lambda-3 */
    public static final boolean m2305translateActivityIntentPredicates$lambda3(EmbeddingAdapter this$0, Set splitPairFilters, Pair pair) {
        C0465i.m1048e(this$0, "this$0");
        C0465i.m1048e(splitPairFilters, "$splitPairFilters");
        C0465i.m1049d(pair, "(first, second)");
        Activity activity = (Activity) this$0.component1(pair);
        Intent intent = (Intent) this$0.component2(pair);
        if ((splitPairFilters instanceof Collection) && splitPairFilters.isEmpty()) {
            return false;
        }
        Iterator it = splitPairFilters.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: translateActivityPairPredicates$lambda-1 */
    public static final boolean m2306translateActivityPairPredicates$lambda1(EmbeddingAdapter this$0, Set splitPairFilters, Pair pair) {
        C0465i.m1048e(this$0, "this$0");
        C0465i.m1048e(splitPairFilters, "$splitPairFilters");
        C0465i.m1049d(pair, "(first, second)");
        Activity activity = (Activity) this$0.component1(pair);
        Activity activity2 = (Activity) this$0.component2(pair);
        if ((splitPairFilters instanceof Collection) && splitPairFilters.isEmpty()) {
            return false;
        }
        Iterator it = splitPairFilters.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityPair(activity, activity2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: translateActivityPredicates$lambda-6 */
    public static final boolean m2307translateActivityPredicates$lambda6(Set activityFilters, Activity activity) {
        C0465i.m1048e(activityFilters, "$activityFilters");
        if ((activityFilters instanceof Collection) && activityFilters.isEmpty()) {
            return false;
        }
        Iterator it = activityFilters.iterator();
        while (it.hasNext()) {
            C0465i.m1049d(activity, "activity");
            if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: translateIntentPredicates$lambda-8 */
    public static final boolean m2308translateIntentPredicates$lambda8(Set activityFilters, Intent intent) {
        C0465i.m1048e(activityFilters, "$activityFilters");
        if ((activityFilters instanceof Collection) && activityFilters.isEmpty()) {
            return false;
        }
        Iterator it = activityFilters.iterator();
        while (it.hasNext()) {
            C0465i.m1049d(intent, "intent");
            if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: translateParentMetricsPredicate$lambda-4 */
    public static final boolean m2309translateParentMetricsPredicate$lambda4(SplitRule splitRule, WindowMetrics windowMetrics) {
        C0465i.m1048e(splitRule, "$splitRule");
        C0465i.m1049d(windowMetrics, "windowMetrics");
        return splitRule.checkParentMetrics(windowMetrics);
    }

    public final List<SplitInfo> translate(List<? extends androidx.window.extensions.embedding.SplitInfo> splitInfoList) {
        int m1958g;
        C0465i.m1048e(splitInfoList, "splitInfoList");
        m1958g = C0188j.m1958g(splitInfoList, 10);
        ArrayList arrayList = new ArrayList(m1958g);
        for (androidx.window.extensions.embedding.SplitInfo splitInfo : splitInfoList) {
            arrayList.add(translate(splitInfo));
        }
        return arrayList;
    }

    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(Set<? extends EmbeddingRule> rules) {
        int m1958g;
        Set<androidx.window.extensions.embedding.EmbeddingRule> m1945t;
        androidx.window.extensions.embedding.SplitPairRule build;
        String str;
        C0465i.m1048e(rules, "rules");
        m1958g = C0188j.m1958g(rules, 10);
        ArrayList arrayList = new ArrayList(m1958g);
        for (EmbeddingRule embeddingRule : rules) {
            if (embeddingRule instanceof SplitPairRule) {
                SplitPairRule splitPairRule = (SplitPairRule) embeddingRule;
                build = new SplitPairRule.Builder(translateActivityPairPredicates(splitPairRule.getFilters()), translateActivityIntentPredicates(splitPairRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPairRule.getSplitRatio()).setLayoutDirection(splitPairRule.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(splitPairRule.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(splitPairRule.getFinishSecondaryWithPrimary()).setShouldClearTop(splitPairRule.getClearTop()).build();
                str = "SplitPairRuleBuilder(\n  …                 .build()";
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) embeddingRule;
                build = new SplitPlaceholderRule.Builder(splitPlaceholderRule.getPlaceholderIntent(), translateActivityPredicates(splitPlaceholderRule.getFilters()), translateIntentPredicates(splitPlaceholderRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPlaceholderRule.getSplitRatio()).setLayoutDirection(splitPlaceholderRule.getLayoutDirection()).build();
                str = "SplitPlaceholderRuleBuil…                 .build()";
            } else if (!(embeddingRule instanceof ActivityRule)) {
                throw new IllegalArgumentException("Unsupported rule type");
            } else {
                ActivityRule activityRule = (ActivityRule) embeddingRule;
                build = new ActivityRule.Builder(translateActivityPredicates(activityRule.getFilters()), translateIntentPredicates(activityRule.getFilters())).setShouldAlwaysExpand(activityRule.getAlwaysExpand()).build();
                str = "ActivityRuleBuilder(\n   …                 .build()";
            }
            C0465i.m1049d(build, str);
            arrayList.add((androidx.window.extensions.embedding.EmbeddingRule) build);
        }
        m1945t = C0195q.m1945t(arrayList);
        return m1945t;
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(final Set<SplitPairFilter> splitPairFilters) {
        C0465i.m1048e(splitPairFilters, "splitPairFilters");
        return new Predicate() { // from class: androidx.window.embedding.b
            {
                EmbeddingAdapter.this = this;
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return EmbeddingAdapter.m2147c(EmbeddingAdapter.this, splitPairFilters, (Pair) obj);
            }
        };
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(final Set<SplitPairFilter> splitPairFilters) {
        C0465i.m1048e(splitPairFilters, "splitPairFilters");
        return new Predicate() { // from class: androidx.window.embedding.c
            {
                EmbeddingAdapter.this = this;
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return EmbeddingAdapter.m2146d(EmbeddingAdapter.this, splitPairFilters, (Pair) obj);
            }
        };
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Activity> translateActivityPredicates(final Set<ActivityFilter> activityFilters) {
        C0465i.m1048e(activityFilters, "activityFilters");
        return new Predicate() { // from class: androidx.window.embedding.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return EmbeddingAdapter.m2149a(activityFilters, (Activity) obj);
            }
        };
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Intent> translateIntentPredicates(final Set<ActivityFilter> activityFilters) {
        C0465i.m1048e(activityFilters, "activityFilters");
        return new Predicate() { // from class: androidx.window.embedding.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return EmbeddingAdapter.m2145e(activityFilters, (Intent) obj);
            }
        };
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<WindowMetrics> translateParentMetricsPredicate(final SplitRule splitRule) {
        C0465i.m1048e(splitRule, "splitRule");
        return new Predicate() { // from class: androidx.window.embedding.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return EmbeddingAdapter.m2148b(splitRule, (WindowMetrics) obj);
            }
        };
    }
}