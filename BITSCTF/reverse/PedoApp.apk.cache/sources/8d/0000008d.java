package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.window.C0082R;
import androidx.window.core.ExperimentalWindowApi;
import java.util.Set;
import kotlin.jvm.internal.C0465i;
import p016g0.C0182e0;
import p046v0.C0692n;

@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitRuleParser {
    private final ComponentName buildClassName(String str, CharSequence charSequence) {
        int m517z;
        int m517z2;
        if (charSequence != null) {
            if (!(charSequence.length() == 0)) {
                String obj = charSequence.toString();
                if (obj.charAt(0) == '.') {
                    return new ComponentName(str, C0465i.m1043j(str, obj));
                }
                m517z = C0692n.m517z(obj, '/', 0, false, 6, null);
                if (m517z > 0) {
                    str = obj.substring(0, m517z);
                    C0465i.m1049d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    obj = obj.substring(m517z + 1);
                    C0465i.m1049d(obj, "(this as java.lang.String).substring(startIndex)");
                }
                if (!C0465i.m1052a(obj, "*")) {
                    m517z2 = C0692n.m517z(obj, '.', 0, false, 6, null);
                    if (m517z2 < 0) {
                        return new ComponentName(str, str + '.' + obj);
                    }
                }
                return new ComponentName(str, obj);
            }
        }
        throw new IllegalArgumentException("Activity name must not be null");
    }

    private final ActivityFilter parseActivityFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, C0082R.styleable.ActivityFilter, 0, 0);
        String string = obtainStyledAttributes.getString(C0082R.styleable.ActivityFilter_activityName);
        String string2 = obtainStyledAttributes.getString(C0082R.styleable.ActivityFilter_activityAction);
        String packageName = context.getApplicationContext().getPackageName();
        C0465i.m1049d(packageName, "packageName");
        return new ActivityFilter(buildClassName(packageName, string), string2);
    }

    private final ActivityRule parseSplitActivityRule(Context context, XmlResourceParser xmlResourceParser) {
        Set m1980b;
        boolean z = context.getTheme().obtainStyledAttributes(xmlResourceParser, C0082R.styleable.ActivityRule, 0, 0).getBoolean(C0082R.styleable.ActivityRule_alwaysExpand, false);
        m1980b = C0182e0.m1980b();
        return new ActivityRule(m1980b, z);
    }

    private final SplitPairFilter parseSplitPairFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, C0082R.styleable.SplitPairFilter, 0, 0);
        String string = obtainStyledAttributes.getString(C0082R.styleable.SplitPairFilter_primaryActivityName);
        String string2 = obtainStyledAttributes.getString(C0082R.styleable.SplitPairFilter_secondaryActivityName);
        String string3 = obtainStyledAttributes.getString(C0082R.styleable.SplitPairFilter_secondaryActivityAction);
        String packageName = context.getApplicationContext().getPackageName();
        C0465i.m1049d(packageName, "packageName");
        return new SplitPairFilter(buildClassName(packageName, string), buildClassName(packageName, string2), string3);
    }

    private final SplitPairRule parseSplitPairRule(Context context, XmlResourceParser xmlResourceParser) {
        Set m1980b;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, C0082R.styleable.SplitPairRule, 0, 0);
        float f = obtainStyledAttributes.getFloat(C0082R.styleable.SplitPairRule_splitRatio, 0.0f);
        int dimension = (int) obtainStyledAttributes.getDimension(C0082R.styleable.SplitPairRule_splitMinWidth, 0.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(C0082R.styleable.SplitPairRule_splitMinSmallestWidth, 0.0f);
        int i = obtainStyledAttributes.getInt(C0082R.styleable.SplitPairRule_splitLayoutDirection, 3);
        boolean z = obtainStyledAttributes.getBoolean(C0082R.styleable.SplitPairRule_finishPrimaryWithSecondary, false);
        boolean z2 = obtainStyledAttributes.getBoolean(C0082R.styleable.SplitPairRule_finishSecondaryWithPrimary, true);
        boolean z3 = obtainStyledAttributes.getBoolean(C0082R.styleable.SplitPairRule_clearTop, false);
        m1980b = C0182e0.m1980b();
        return new SplitPairRule(m1980b, z, z2, z3, dimension, dimension2, f, i);
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context context, XmlResourceParser xmlResourceParser) {
        Set m1980b;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, C0082R.styleable.SplitPlaceholderRule, 0, 0);
        String string = obtainStyledAttributes.getString(C0082R.styleable.SplitPlaceholderRule_placeholderActivityName);
        float f = obtainStyledAttributes.getFloat(C0082R.styleable.SplitPlaceholderRule_splitRatio, 0.0f);
        int dimension = (int) obtainStyledAttributes.getDimension(C0082R.styleable.SplitPlaceholderRule_splitMinWidth, 0.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(C0082R.styleable.SplitPlaceholderRule_splitMinSmallestWidth, 0.0f);
        int i = obtainStyledAttributes.getInt(C0082R.styleable.SplitPlaceholderRule_splitLayoutDirection, 3);
        String packageName = context.getApplicationContext().getPackageName();
        C0465i.m1049d(packageName, "packageName");
        ComponentName buildClassName = buildClassName(packageName, string);
        m1980b = C0182e0.m1980b();
        Intent component = new Intent().setComponent(buildClassName);
        C0465i.m1049d(component, "Intent().setComponent(pl…eholderActivityClassName)");
        return new SplitPlaceholderRule(m1980b, component, dimension, dimension2, f, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e5, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Set<androidx.window.embedding.EmbeddingRule> parseSplitXml(android.content.Context r9, int r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitRuleParser.parseSplitXml(android.content.Context, int):java.util.Set");
    }

    public final Set<EmbeddingRule> parseSplitRules$window_release(Context context, int i) {
        C0465i.m1048e(context, "context");
        return parseSplitXml(context, i);
    }
}