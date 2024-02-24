package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.C0461e;
import kotlin.jvm.internal.C0465i;
import p014f0.C0157g;
import p014f0.InterfaceC0155e;
import p046v0.C0691m;

/* loaded from: classes.dex */
public final class Version implements Comparable<Version> {
    private static final Version CURRENT;
    public static final Companion Companion = new Companion(null);
    private static final Version UNKNOWN = new Version(0, 0, 0, "");
    private static final Version VERSION_0_1 = new Version(0, 1, 0, "");
    private static final Version VERSION_1_0;
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";
    private final InterfaceC0155e bigInteger$delegate;
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C0461e c0461e) {
            this();
        }

        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        public final Version parse(String str) {
            boolean m558l;
            if (str != null) {
                m558l = C0691m.m558l(str);
                if (!m558l) {
                    Matcher matcher = Pattern.compile(Version.VERSION_PATTERN_STRING).matcher(str);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
                        if (valueOf == null) {
                            return null;
                        }
                        int intValue = valueOf.intValue();
                        String group2 = matcher.group(2);
                        Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
                        if (valueOf2 == null) {
                            return null;
                        }
                        int intValue2 = valueOf2.intValue();
                        String group3 = matcher.group(3);
                        Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
                        if (valueOf3 == null) {
                            return null;
                        }
                        int intValue3 = valueOf3.intValue();
                        String description = matcher.group(4) != null ? matcher.group(4) : "";
                        C0465i.m1049d(description, "description");
                        return new Version(intValue, intValue2, intValue3, description, null);
                    }
                    return null;
                }
            }
            return null;
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        VERSION_1_0 = version;
        CURRENT = version;
    }

    private Version(int i, int i2, int i3, String str) {
        InterfaceC0155e m2015a;
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        this.description = str;
        m2015a = C0157g.m2015a(new Version$bigInteger$2(this));
        this.bigInteger$delegate = m2015a;
    }

    public /* synthetic */ Version(int i, int i2, int i3, String str, C0461e c0461e) {
        this(i, i2, i3, str);
    }

    private final BigInteger getBigInteger() {
        Object value = this.bigInteger$delegate.getValue();
        C0465i.m1049d(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public static final Version parse(String str) {
        return Companion.parse(str);
    }

    @Override // java.lang.Comparable
    public int compareTo(Version other) {
        C0465i.m1048e(other, "other");
        return getBigInteger().compareTo(other.getBigInteger());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Version) {
            Version version = (Version) obj;
            return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return ((((527 + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    public String toString() {
        boolean m558l;
        m558l = C0691m.m558l(this.description);
        String m1043j = m558l ^ true ? C0465i.m1043j("-", this.description) : "";
        return this.major + '.' + this.minor + '.' + this.patch + m1043j;
    }
}