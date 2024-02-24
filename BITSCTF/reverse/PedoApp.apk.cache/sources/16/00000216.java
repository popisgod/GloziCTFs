package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.plugin.platform.InterfaceC0384l;
import io.flutter.view.C0408c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p012e0.C0146h;
import p012e0.InterfaceC0142d;
import p031o.C0576b;
import p053z.C0839a;

/* renamed from: io.flutter.view.c */
/* loaded from: classes.dex */
public class C0408c extends AccessibilityNodeProvider {

    /* renamed from: a */
    private final View f775a;

    /* renamed from: b */
    private final C0839a f776b;

    /* renamed from: c */
    private final AccessibilityManager f777c;

    /* renamed from: d */
    private final AccessibilityViewEmbedder f778d;

    /* renamed from: e */
    private final InterfaceC0384l f779e;

    /* renamed from: f */
    private final ContentResolver f780f;

    /* renamed from: g */
    private final Map<Integer, C0420l> f781g;

    /* renamed from: h */
    private final Map<Integer, C0416h> f782h;

    /* renamed from: i */
    private C0420l f783i;

    /* renamed from: j */
    private Integer f784j;

    /* renamed from: k */
    private Integer f785k;

    /* renamed from: l */
    private int f786l;

    /* renamed from: m */
    private C0420l f787m;

    /* renamed from: n */
    private C0420l f788n;

    /* renamed from: o */
    private C0420l f789o;

    /* renamed from: p */
    private final List<Integer> f790p;

    /* renamed from: q */
    private int f791q;

    /* renamed from: r */
    private Integer f792r;

    /* renamed from: s */
    private InterfaceC0419k f793s;

    /* renamed from: t */
    private boolean f794t;

    /* renamed from: u */
    private boolean f795u;

    /* renamed from: v */
    private final C0839a.InterfaceC0841b f796v;

    /* renamed from: w */
    private final AccessibilityManager.AccessibilityStateChangeListener f797w;
    @TargetApi(19)

    /* renamed from: x */
    private final AccessibilityManager.TouchExplorationStateChangeListener f798x;

    /* renamed from: y */
    private final ContentObserver f799y;

    /* renamed from: z */
    private static final int f774z = ((EnumC0415g.SCROLL_RIGHT.f838d | EnumC0415g.SCROLL_LEFT.f838d) | EnumC0415g.SCROLL_UP.f838d) | EnumC0415g.SCROLL_DOWN.f838d;

    /* renamed from: A */
    private static final int f771A = ((((((((((EnumC0417i.HAS_CHECKED_STATE.f873d | EnumC0417i.IS_CHECKED.f873d) | EnumC0417i.IS_SELECTED.f873d) | EnumC0417i.IS_TEXT_FIELD.f873d) | EnumC0417i.IS_FOCUSED.f873d) | EnumC0417i.HAS_ENABLED_STATE.f873d) | EnumC0417i.IS_ENABLED.f873d) | EnumC0417i.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f873d) | EnumC0417i.HAS_TOGGLED_STATE.f873d) | EnumC0417i.IS_TOGGLED.f873d) | EnumC0417i.IS_FOCUSABLE.f873d) | EnumC0417i.IS_SLIDER.f873d;

    /* renamed from: B */
    private static int f772B = 267386881;

    /* renamed from: C */
    static int f773C = (EnumC0415g.DID_GAIN_ACCESSIBILITY_FOCUS.f838d & EnumC0415g.DID_LOSE_ACCESSIBILITY_FOCUS.f838d) & EnumC0415g.SHOW_ON_SCREEN.f838d;

    /* renamed from: io.flutter.view.c$a */
    /* loaded from: classes.dex */
    public class C0409a implements C0839a.InterfaceC0841b {
        C0409a() {
            C0408c.this = r1;
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.InterfaceC0310a
        /* renamed from: a */
        public void mo1203a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            C0408c.this.m1227d0(byteBuffer, strArr, byteBufferArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.InterfaceC0310a
        /* renamed from: b */
        public void mo1202b(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            C0408c.this.m1229c0(byteBuffer, strArr);
        }

        @Override // p053z.C0839a.InterfaceC0841b
        /* renamed from: c */
        public void mo169c(String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            AccessibilityEvent m1252I = C0408c.this.m1252I(0, 32);
            m1252I.getText().add(str);
            C0408c.this.m1240U(m1252I);
        }

        @Override // p053z.C0839a.InterfaceC0841b
        /* renamed from: d */
        public void mo168d(int i) {
            C0408c.this.m1241T(i, 8);
        }

        @Override // p053z.C0839a.InterfaceC0841b
        /* renamed from: e */
        public void mo167e(int i) {
            C0408c.this.m1241T(i, 2);
        }

        @Override // p053z.C0839a.InterfaceC0841b
        /* renamed from: f */
        public void mo166f(int i) {
            C0408c.this.m1241T(i, 1);
        }

        @Override // p053z.C0839a.InterfaceC0841b
        /* renamed from: g */
        public void mo165g(String str) {
            C0408c.this.f775a.announceForAccessibility(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.view.c$b */
    /* loaded from: classes.dex */
    public class accessibilityAccessibilityManager$AccessibilityStateChangeListenerC0410b implements AccessibilityManager.AccessibilityStateChangeListener {
        accessibilityAccessibilityManager$AccessibilityStateChangeListenerC0410b() {
            C0408c.this = r1;
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            if (C0408c.this.f795u) {
                return;
            }
            C0408c c0408c = C0408c.this;
            if (z) {
                c0408c.f776b.m171g(C0408c.this.f796v);
                C0408c.this.f776b.m173e();
            } else {
                c0408c.m1236Y(false);
                C0408c.this.f776b.m171g(null);
                C0408c.this.f776b.m174d();
            }
            if (C0408c.this.f793s != null) {
                C0408c.this.f793s.mo1191a(z, C0408c.this.f777c.isTouchExplorationEnabled());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.view.c$c */
    /* loaded from: classes.dex */
    public class C0411c extends ContentObserver {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0411c(Handler handler) {
            super(handler);
            C0408c.this = r1;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            if (C0408c.this.f795u) {
                return;
            }
            String string = Build.VERSION.SDK_INT < 17 ? null : Settings.Global.getString(C0408c.this.f780f, "transition_animation_scale");
            if (string != null && string.equals("0")) {
                C0408c.m1224f(C0408c.this, EnumC0414f.DISABLE_ANIMATIONS.f814d);
            } else {
                C0408c.m1226e(C0408c.this, EnumC0414f.DISABLE_ANIMATIONS.f814d ^ (-1));
            }
            C0408c.this.m1239V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.view.c$d */
    /* loaded from: classes.dex */
    public class accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0412d implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a */
        final /* synthetic */ AccessibilityManager f803a;

        accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0412d(AccessibilityManager accessibilityManager) {
            C0408c.this = r1;
            this.f803a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            if (C0408c.this.f795u) {
                return;
            }
            if (!z) {
                C0408c.this.m1236Y(false);
                C0408c.this.m1247N();
            }
            if (C0408c.this.f793s != null) {
                C0408c.this.f793s.mo1191a(this.f803a.isEnabled(), z);
            }
        }
    }

    /* renamed from: io.flutter.view.c$e */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0413e {

        /* renamed from: a */
        static final /* synthetic */ int[] f805a;

        static {
            int[] iArr = new int[EnumC0423o.values().length];
            f805a = iArr;
            try {
                iArr[EnumC0423o.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f805a[EnumC0423o.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: io.flutter.view.c$f */
    /* loaded from: classes.dex */
    public enum EnumC0414f {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);
        

        /* renamed from: d */
        final int f814d;

        EnumC0414f(int i) {
            this.f814d = i;
        }
    }

    /* renamed from: io.flutter.view.c$g */
    /* loaded from: classes.dex */
    public enum EnumC0415g {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);
        

        /* renamed from: d */
        public final int f838d;

        EnumC0415g(int i) {
            this.f838d = i;
        }
    }

    /* renamed from: io.flutter.view.c$h */
    /* loaded from: classes.dex */
    public static class C0416h {

        /* renamed from: a */
        private int f839a = -1;

        /* renamed from: b */
        private int f840b = -1;

        /* renamed from: c */
        private int f841c = -1;

        /* renamed from: d */
        private String f842d;

        /* renamed from: e */
        private String f843e;

        C0416h() {
        }
    }

    /* renamed from: io.flutter.view.c$i */
    /* loaded from: classes.dex */
    public enum EnumC0417i {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728);
        

        /* renamed from: d */
        final int f873d;

        EnumC0417i(int i) {
            this.f873d = i;
        }
    }

    /* renamed from: io.flutter.view.c$j */
    /* loaded from: classes.dex */
    public static class C0418j extends C0422n {

        /* renamed from: d */
        String f874d;

        private C0418j() {
            super(null);
        }

        /* synthetic */ C0418j(C0409a c0409a) {
            this();
        }
    }

    /* renamed from: io.flutter.view.c$k */
    /* loaded from: classes.dex */
    public interface InterfaceC0419k {
        /* renamed from: a */
        void mo1191a(boolean z, boolean z2);
    }

    /* renamed from: io.flutter.view.c$l */
    /* loaded from: classes.dex */
    public static class C0420l {

        /* renamed from: A */
        private EnumC0424p f875A;

        /* renamed from: C */
        private int f877C;

        /* renamed from: D */
        private int f878D;

        /* renamed from: E */
        private int f879E;

        /* renamed from: F */
        private int f880F;

        /* renamed from: G */
        private float f881G;

        /* renamed from: H */
        private float f882H;

        /* renamed from: I */
        private float f883I;

        /* renamed from: J */
        private String f884J;

        /* renamed from: K */
        private String f885K;

        /* renamed from: L */
        private float f886L;

        /* renamed from: M */
        private float f887M;

        /* renamed from: N */
        private float f888N;

        /* renamed from: O */
        private float f889O;

        /* renamed from: P */
        private float[] f890P;

        /* renamed from: Q */
        private C0420l f891Q;

        /* renamed from: T */
        private List<C0416h> f894T;

        /* renamed from: U */
        private C0416h f895U;

        /* renamed from: V */
        private C0416h f896V;

        /* renamed from: X */
        private float[] f898X;

        /* renamed from: Z */
        private float[] f900Z;

        /* renamed from: a */
        final C0408c f901a;

        /* renamed from: a0 */
        private Rect f902a0;

        /* renamed from: c */
        private int f904c;

        /* renamed from: d */
        private int f905d;

        /* renamed from: e */
        private int f906e;

        /* renamed from: f */
        private int f907f;

        /* renamed from: g */
        private int f908g;

        /* renamed from: h */
        private int f909h;

        /* renamed from: i */
        private int f910i;

        /* renamed from: j */
        private int f911j;

        /* renamed from: k */
        private int f912k;

        /* renamed from: l */
        private float f913l;

        /* renamed from: m */
        private float f914m;

        /* renamed from: n */
        private float f915n;

        /* renamed from: o */
        private String f916o;

        /* renamed from: p */
        private List<C0422n> f917p;

        /* renamed from: q */
        private String f918q;

        /* renamed from: r */
        private List<C0422n> f919r;

        /* renamed from: s */
        private String f920s;

        /* renamed from: t */
        private List<C0422n> f921t;

        /* renamed from: u */
        private String f922u;

        /* renamed from: v */
        private List<C0422n> f923v;

        /* renamed from: w */
        private String f924w;

        /* renamed from: x */
        private List<C0422n> f925x;

        /* renamed from: y */
        private String f926y;

        /* renamed from: b */
        private int f903b = -1;

        /* renamed from: z */
        private int f927z = -1;

        /* renamed from: B */
        private boolean f876B = false;

        /* renamed from: R */
        private List<C0420l> f892R = new ArrayList();

        /* renamed from: S */
        private List<C0420l> f893S = new ArrayList();

        /* renamed from: W */
        private boolean f897W = true;

        /* renamed from: Y */
        private boolean f899Y = true;

        C0420l(C0408c c0408c) {
            this.f901a = c0408c;
        }

        /* renamed from: A0 */
        private float m1189A0(float f, float f2, float f3, float f4) {
            return Math.min(f, Math.min(f2, Math.min(f3, f4)));
        }

        /* renamed from: B0 */
        public static boolean m1187B0(C0420l c0420l, InterfaceC0142d<C0420l> interfaceC0142d) {
            return (c0420l == null || c0420l.m1138k0(interfaceC0142d) == null) ? false : true;
        }

        /* renamed from: C0 */
        private void m1185C0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f = fArr[3];
            fArr[0] = fArr[0] / f;
            fArr[1] = fArr[1] / f;
            fArr[2] = fArr[2] / f;
            fArr[3] = 0.0f;
        }

        /* renamed from: D0 */
        public void m1183D0(float[] fArr, Set<C0420l> set, boolean z) {
            set.add(this);
            if (this.f899Y) {
                z = true;
            }
            if (z) {
                if (this.f900Z == null) {
                    this.f900Z = new float[16];
                }
                if (this.f890P == null) {
                    this.f890P = new float[16];
                }
                Matrix.multiplyMM(this.f900Z, 0, fArr, 0, this.f890P, 0);
                float[] fArr2 = {this.f886L, this.f887M, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                m1185C0(fArr3, this.f900Z, fArr2);
                fArr2[0] = this.f888N;
                fArr2[1] = this.f887M;
                m1185C0(fArr4, this.f900Z, fArr2);
                fArr2[0] = this.f888N;
                fArr2[1] = this.f889O;
                m1185C0(fArr5, this.f900Z, fArr2);
                fArr2[0] = this.f886L;
                fArr2[1] = this.f889O;
                m1185C0(fArr6, this.f900Z, fArr2);
                if (this.f902a0 == null) {
                    this.f902a0 = new Rect();
                }
                this.f902a0.set(Math.round(m1189A0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(m1189A0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(m1108z0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(m1108z0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.f899Y = false;
            }
            int i = -1;
            for (C0420l c0420l : this.f892R) {
                c0420l.f927z = i;
                i = c0420l.f903b;
                c0420l.m1183D0(this.f900Z, set, z);
            }
        }

        /* renamed from: E0 */
        public void m1181E0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.f876B = true;
            this.f884J = this.f918q;
            this.f885K = this.f916o;
            this.f877C = this.f904c;
            this.f878D = this.f905d;
            this.f879E = this.f908g;
            this.f880F = this.f909h;
            this.f881G = this.f913l;
            this.f882H = this.f914m;
            this.f883I = this.f915n;
            this.f904c = byteBuffer.getInt();
            this.f905d = byteBuffer.getInt();
            this.f906e = byteBuffer.getInt();
            this.f907f = byteBuffer.getInt();
            this.f908g = byteBuffer.getInt();
            this.f909h = byteBuffer.getInt();
            this.f910i = byteBuffer.getInt();
            this.f911j = byteBuffer.getInt();
            this.f912k = byteBuffer.getInt();
            this.f913l = byteBuffer.getFloat();
            this.f914m = byteBuffer.getFloat();
            this.f915n = byteBuffer.getFloat();
            int i = byteBuffer.getInt();
            this.f916o = i == -1 ? null : strArr[i];
            this.f917p = m1128p0(byteBuffer, byteBufferArr);
            int i2 = byteBuffer.getInt();
            this.f918q = i2 == -1 ? null : strArr[i2];
            this.f919r = m1128p0(byteBuffer, byteBufferArr);
            int i3 = byteBuffer.getInt();
            this.f920s = i3 == -1 ? null : strArr[i3];
            this.f921t = m1128p0(byteBuffer, byteBufferArr);
            int i4 = byteBuffer.getInt();
            this.f922u = i4 == -1 ? null : strArr[i4];
            this.f923v = m1128p0(byteBuffer, byteBufferArr);
            int i5 = byteBuffer.getInt();
            this.f924w = i5 == -1 ? null : strArr[i5];
            this.f925x = m1128p0(byteBuffer, byteBufferArr);
            int i6 = byteBuffer.getInt();
            this.f926y = i6 == -1 ? null : strArr[i6];
            this.f875A = EnumC0424p.m1107a(byteBuffer.getInt());
            this.f886L = byteBuffer.getFloat();
            this.f887M = byteBuffer.getFloat();
            this.f888N = byteBuffer.getFloat();
            this.f889O = byteBuffer.getFloat();
            if (this.f890P == null) {
                this.f890P = new float[16];
            }
            for (int i7 = 0; i7 < 16; i7++) {
                this.f890P[i7] = byteBuffer.getFloat();
            }
            this.f897W = true;
            this.f899Y = true;
            int i8 = byteBuffer.getInt();
            this.f892R.clear();
            this.f893S.clear();
            for (int i9 = 0; i9 < i8; i9++) {
                C0420l m1204z = this.f901a.m1204z(byteBuffer.getInt());
                m1204z.f891Q = this;
                this.f892R.add(m1204z);
            }
            for (int i10 = 0; i10 < i8; i10++) {
                C0420l m1204z2 = this.f901a.m1204z(byteBuffer.getInt());
                m1204z2.f891Q = this;
                this.f893S.add(m1204z2);
            }
            int i11 = byteBuffer.getInt();
            if (i11 == 0) {
                this.f894T = null;
                return;
            }
            List<C0416h> list = this.f894T;
            if (list == null) {
                this.f894T = new ArrayList(i11);
            } else {
                list.clear();
            }
            for (int i12 = 0; i12 < i11; i12++) {
                C0416h m1205y = this.f901a.m1205y(byteBuffer.getInt());
                if (m1205y.f841c == EnumC0415g.TAP.f838d) {
                    this.f895U = m1205y;
                } else if (m1205y.f841c == EnumC0415g.LONG_PRESS.f838d) {
                    this.f896V = m1205y;
                } else {
                    this.f894T.add(m1205y);
                }
                this.f894T.add(m1205y);
            }
        }

        /* renamed from: f0 */
        public void m1148f0(List<C0420l> list) {
            if (m1114w0(EnumC0417i.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (C0420l c0420l : this.f892R) {
                c0420l.m1148f0(list);
            }
        }

        @TargetApi(21)
        /* renamed from: g0 */
        private SpannableString m1146g0(String str, List<C0422n> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (C0422n c0422n : list) {
                    int i = C0413e.f805a[c0422n.f930c.ordinal()];
                    if (i == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), c0422n.f928a, c0422n.f929b, 0);
                    } else if (i == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((C0418j) c0422n).f874d)), c0422n.f928a, c0422n.f929b, 0);
                    }
                }
            }
            return spannableString;
        }

        /* renamed from: h0 */
        public boolean m1144h0() {
            String str;
            String str2 = this.f916o;
            if (str2 == null && this.f885K == null) {
                return false;
            }
            return str2 == null || (str = this.f885K) == null || !str2.equals(str);
        }

        /* renamed from: i0 */
        public boolean m1142i0() {
            return (Float.isNaN(this.f913l) || Float.isNaN(this.f881G) || this.f881G == this.f913l) ? false : true;
        }

        /* renamed from: j0 */
        private void m1140j0() {
            if (this.f897W) {
                this.f897W = false;
                if (this.f898X == null) {
                    this.f898X = new float[16];
                }
                if (Matrix.invertM(this.f898X, 0, this.f890P, 0)) {
                    return;
                }
                Arrays.fill(this.f898X, 0.0f);
            }
        }

        /* renamed from: k0 */
        private C0420l m1138k0(InterfaceC0142d<C0420l> interfaceC0142d) {
            for (C0420l c0420l = this.f891Q; c0420l != null; c0420l = c0420l.f891Q) {
                if (interfaceC0142d.test(c0420l)) {
                    return c0420l;
                }
            }
            return null;
        }

        /* renamed from: l0 */
        public Rect m1136l0() {
            return this.f902a0;
        }

        /* renamed from: m */
        static /* synthetic */ int m1135m(C0420l c0420l, int i) {
            int i2 = c0420l.f909h + i;
            c0420l.f909h = i2;
            return i2;
        }

        /* renamed from: m0 */
        private CharSequence m1134m0() {
            return Build.VERSION.SDK_INT < 21 ? this.f924w : m1146g0(this.f924w, this.f925x);
        }

        /* renamed from: n */
        static /* synthetic */ int m1133n(C0420l c0420l, int i) {
            int i2 = c0420l.f909h - i;
            c0420l.f909h = i2;
            return i2;
        }

        /* renamed from: n0 */
        private CharSequence m1132n0() {
            return Build.VERSION.SDK_INT < 21 ? this.f916o : m1146g0(this.f916o, this.f917p);
        }

        /* renamed from: o0 */
        public String m1130o0() {
            String str;
            if (!m1114w0(EnumC0417i.NAMES_ROUTE) || (str = this.f916o) == null || str.isEmpty()) {
                for (C0420l c0420l : this.f892R) {
                    String m1130o0 = c0420l.m1130o0();
                    if (m1130o0 != null && !m1130o0.isEmpty()) {
                        return m1130o0;
                    }
                }
                return null;
            }
            return this.f916o;
        }

        /* renamed from: p0 */
        private List<C0422n> m1128p0(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i = byteBuffer.getInt();
            if (i == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = byteBuffer.getInt();
                int i4 = byteBuffer.getInt();
                EnumC0423o enumC0423o = EnumC0423o.values()[byteBuffer.getInt()];
                int i5 = C0413e.f805a[enumC0423o.ordinal()];
                if (i5 == 1) {
                    byteBuffer.getInt();
                    C0421m c0421m = new C0421m(null);
                    c0421m.f928a = i3;
                    c0421m.f929b = i4;
                    c0421m.f930c = enumC0423o;
                    arrayList.add(c0421m);
                } else if (i5 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    C0418j c0418j = new C0418j(null);
                    c0418j.f928a = i3;
                    c0418j.f929b = i4;
                    c0418j.f930c = enumC0423o;
                    c0418j.f874d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(c0418j);
                }
            }
            return arrayList;
        }

        /* renamed from: q0 */
        public CharSequence m1126q0() {
            CharSequence[] charSequenceArr = {m1132n0(), m1134m0()};
            CharSequence charSequence = null;
            for (int i = 0; i < 2; i++) {
                CharSequence charSequence2 = charSequenceArr[i];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* renamed from: r0 */
        public CharSequence m1124r0() {
            return Build.VERSION.SDK_INT < 21 ? this.f918q : m1146g0(this.f918q, this.f919r);
        }

        /* renamed from: s0 */
        public CharSequence m1122s0() {
            CharSequence[] charSequenceArr = {m1124r0(), m1132n0(), m1134m0()};
            CharSequence charSequence = null;
            for (int i = 0; i < 3; i++) {
                CharSequence charSequence2 = charSequenceArr[i];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* renamed from: t0 */
        public boolean m1120t0(EnumC0415g enumC0415g) {
            return (enumC0415g.f838d & this.f878D) != 0;
        }

        /* renamed from: u0 */
        public boolean m1118u0(EnumC0417i enumC0417i) {
            return (enumC0417i.f873d & this.f877C) != 0;
        }

        /* renamed from: v0 */
        public boolean m1116v0(EnumC0415g enumC0415g) {
            return (enumC0415g.f838d & this.f905d) != 0;
        }

        /* renamed from: w0 */
        public boolean m1114w0(EnumC0417i enumC0417i) {
            return (enumC0417i.f873d & this.f904c) != 0;
        }

        /* renamed from: x0 */
        public C0420l m1112x0(float[] fArr, boolean z) {
            float f = fArr[3];
            boolean z2 = false;
            float f2 = fArr[0] / f;
            float f3 = fArr[1] / f;
            if (f2 < this.f886L || f2 >= this.f888N || f3 < this.f887M || f3 >= this.f889O) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (C0420l c0420l : this.f893S) {
                if (!c0420l.m1114w0(EnumC0417i.IS_HIDDEN)) {
                    c0420l.m1140j0();
                    Matrix.multiplyMV(fArr2, 0, c0420l.f898X, 0, fArr, 0);
                    C0420l m1112x0 = c0420l.m1112x0(fArr2, z);
                    if (m1112x0 != null) {
                        return m1112x0;
                    }
                }
            }
            if (z && this.f910i != -1) {
                z2 = true;
            }
            if (m1110y0() || z2) {
                return this;
            }
            return null;
        }

        /* renamed from: y0 */
        public boolean m1110y0() {
            String str;
            String str2;
            String str3;
            if (m1114w0(EnumC0417i.SCOPES_ROUTE)) {
                return false;
            }
            return (!m1114w0(EnumC0417i.IS_FOCUSABLE) && (this.f905d & (C0408c.f774z ^ (-1))) == 0 && (this.f904c & C0408c.f771A) == 0 && ((str = this.f916o) == null || str.isEmpty()) && (((str2 = this.f918q) == null || str2.isEmpty()) && ((str3 = this.f924w) == null || str3.isEmpty()))) ? false : true;
        }

        /* renamed from: z0 */
        private float m1108z0(float f, float f2, float f3, float f4) {
            return Math.max(f, Math.max(f2, Math.max(f3, f4)));
        }
    }

    /* renamed from: io.flutter.view.c$m */
    /* loaded from: classes.dex */
    public static class C0421m extends C0422n {
        private C0421m() {
            super(null);
        }

        /* synthetic */ C0421m(C0409a c0409a) {
            this();
        }
    }

    /* renamed from: io.flutter.view.c$n */
    /* loaded from: classes.dex */
    public static class C0422n {

        /* renamed from: a */
        int f928a;

        /* renamed from: b */
        int f929b;

        /* renamed from: c */
        EnumC0423o f930c;

        private C0422n() {
        }

        /* synthetic */ C0422n(C0409a c0409a) {
            this();
        }
    }

    /* renamed from: io.flutter.view.c$o */
    /* loaded from: classes.dex */
    public enum EnumC0423o {
        SPELLOUT,
        LOCALE
    }

    /* renamed from: io.flutter.view.c$p */
    /* loaded from: classes.dex */
    public enum EnumC0424p {
        UNKNOWN,
        LTR,
        RTL;

        /* renamed from: a */
        public static EnumC0424p m1107a(int i) {
            return i != 1 ? i != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public C0408c(View view, C0839a c0839a, AccessibilityManager accessibilityManager, ContentResolver contentResolver, InterfaceC0384l interfaceC0384l) {
        this(view, c0839a, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), interfaceC0384l);
    }

    public C0408c(View view, C0839a c0839a, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, InterfaceC0384l interfaceC0384l) {
        this.f781g = new HashMap();
        this.f782h = new HashMap();
        this.f786l = 0;
        this.f790p = new ArrayList();
        this.f791q = 0;
        this.f792r = 0;
        this.f794t = false;
        this.f795u = false;
        this.f796v = new C0409a();
        accessibilityAccessibilityManager$AccessibilityStateChangeListenerC0410b accessibilityaccessibilitymanager_accessibilitystatechangelistenerc0410b = new accessibilityAccessibilityManager$AccessibilityStateChangeListenerC0410b();
        this.f797w = accessibilityaccessibilitymanager_accessibilitystatechangelistenerc0410b;
        C0411c c0411c = new C0411c(new Handler());
        this.f799y = c0411c;
        this.f775a = view;
        this.f776b = c0839a;
        this.f777c = accessibilityManager;
        this.f780f = contentResolver;
        this.f778d = accessibilityViewEmbedder;
        this.f779e = interfaceC0384l;
        accessibilityaccessibilitymanager_accessibilitystatechangelistenerc0410b.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityaccessibilitymanager_accessibilitystatechangelistenerc0410b);
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0412d accessibilityaccessibilitymanager_touchexplorationstatechangelistenerc0412d = new accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0412d(accessibilityManager);
            this.f798x = accessibilityaccessibilitymanager_touchexplorationstatechangelistenerc0412d;
            accessibilityaccessibilitymanager_touchexplorationstatechangelistenerc0412d.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
            accessibilityManager.addTouchExplorationStateChangeListener(accessibilityaccessibilitymanager_touchexplorationstatechangelistenerc0412d);
        } else {
            this.f798x = null;
        }
        if (i >= 17) {
            c0411c.onChange(false);
            contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, c0411c);
        }
        if (i >= 31) {
            m1235Z();
        }
        interfaceC0384l.mo1354b(this);
    }

    /* renamed from: A */
    private C0420l m1260A() {
        return this.f781g.get(0);
    }

    /* renamed from: B */
    private void m1259B(float f, float f2, boolean z) {
        C0420l m1112x0;
        if (this.f781g.isEmpty() || (m1112x0 = m1260A().m1112x0(new float[]{f, f2, 0.0f, 1.0f}, z)) == this.f789o) {
            return;
        }
        if (m1112x0 != null) {
            m1241T(m1112x0.f903b, 128);
        }
        C0420l c0420l = this.f789o;
        if (c0420l != null) {
            m1241T(c0420l.f903b, 256);
        }
        this.f789o = m1112x0;
    }

    /* renamed from: D */
    private boolean m1257D(C0420l c0420l) {
        if (c0420l.m1114w0(EnumC0417i.SCOPES_ROUTE)) {
            return false;
        }
        return (c0420l.m1122s0() == null && (c0420l.f905d & (f773C ^ (-1))) == 0) ? false : true;
    }

    /* renamed from: F */
    public static /* synthetic */ boolean m1255F(C0420l c0420l, C0420l c0420l2) {
        return c0420l2 == c0420l;
    }

    /* renamed from: G */
    public static /* synthetic */ boolean m1254G(C0420l c0420l) {
        return c0420l.m1114w0(EnumC0417i.HAS_IMPLICIT_SCROLLING);
    }

    /* renamed from: I */
    public AccessibilityEvent m1252I(int i, int i2) {
        AccessibilityEvent m1253H = m1253H(i2);
        m1253H.setPackageName(this.f775a.getContext().getPackageName());
        m1253H.setSource(this.f775a, i);
        return m1253H;
    }

    /* renamed from: N */
    public void m1247N() {
        C0420l c0420l = this.f789o;
        if (c0420l != null) {
            m1241T(c0420l.f903b, 256);
            this.f789o = null;
        }
    }

    /* renamed from: O */
    private void m1246O(C0420l c0420l) {
        String m1130o0 = c0420l.m1130o0();
        if (m1130o0 == null) {
            m1130o0 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            m1237X(m1130o0);
            return;
        }
        AccessibilityEvent m1252I = m1252I(c0420l.f903b, 32);
        m1252I.getText().add(m1130o0);
        m1240U(m1252I);
    }

    @TargetApi(18)
    /* renamed from: P */
    private boolean m1245P(C0420l c0420l, int i, Bundle bundle, boolean z) {
        int i2 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z2 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i3 = c0420l.f908g;
        int i4 = c0420l.f909h;
        m1243R(c0420l, i2, z, z2);
        if (i3 != c0420l.f908g || i4 != c0420l.f909h) {
            String str = c0420l.f918q != null ? c0420l.f918q : "";
            AccessibilityEvent m1252I = m1252I(c0420l.f903b, 8192);
            m1252I.getText().add(str);
            m1252I.setFromIndex(c0420l.f908g);
            m1252I.setToIndex(c0420l.f909h);
            m1252I.setItemCount(str.length());
            m1240U(m1252I);
        }
        if (i2 == 1) {
            if (z) {
                EnumC0415g enumC0415g = EnumC0415g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (c0420l.m1116v0(enumC0415g)) {
                    this.f776b.m175c(i, enumC0415g, Boolean.valueOf(z2));
                    return true;
                }
            }
            if (z) {
                return false;
            }
            EnumC0415g enumC0415g2 = EnumC0415g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (c0420l.m1116v0(enumC0415g2)) {
                this.f776b.m175c(i, enumC0415g2, Boolean.valueOf(z2));
                return true;
            }
            return false;
        } else if (i2 != 2) {
            return i2 == 4 || i2 == 8 || i2 == 16;
        } else {
            if (z) {
                EnumC0415g enumC0415g3 = EnumC0415g.MOVE_CURSOR_FORWARD_BY_WORD;
                if (c0420l.m1116v0(enumC0415g3)) {
                    this.f776b.m175c(i, enumC0415g3, Boolean.valueOf(z2));
                    return true;
                }
            }
            if (z) {
                return false;
            }
            EnumC0415g enumC0415g4 = EnumC0415g.MOVE_CURSOR_BACKWARD_BY_WORD;
            if (c0420l.m1116v0(enumC0415g4)) {
                this.f776b.m175c(i, enumC0415g4, Boolean.valueOf(z2));
                return true;
            }
            return false;
        }
    }

    @TargetApi(21)
    /* renamed from: Q */
    private boolean m1244Q(C0420l c0420l, int i, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.f776b.m175c(i, EnumC0415g.SET_TEXT, string);
        c0420l.f918q = string;
        c0420l.f919r = null;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00e6, code lost:
        if (r5.find() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0022, code lost:
        if (r6 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0024, code lost:
        r5 = r4.f918q.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x002c, code lost:
        r4.f909h = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0031, code lost:
        r4.f909h = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0060, code lost:
        if (r5.find() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0062, code lost:
        io.flutter.view.C0408c.C0420l.m1135m(r4, r5.start(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x008d, code lost:
        if (r5.find() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x008f, code lost:
        r5 = r5.start(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00c1, code lost:
        if (r5.find() != false) goto L29;
     */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1243R(io.flutter.view.C0408c.C0420l r4, int r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            int r0 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            if (r0 < 0) goto L111
            int r0 = io.flutter.view.C0408c.C0420l.m1143i(r4)
            if (r0 >= 0) goto Le
            goto L111
        Le:
            r0 = 1
            if (r5 == r0) goto Le9
            r1 = 2
            r2 = 0
            if (r5 == r1) goto L94
            r1 = 4
            if (r5 == r1) goto L36
            r0 = 8
            if (r5 == r0) goto L22
            r0 = 16
            if (r5 == r0) goto L22
            goto L108
        L22:
            if (r6 == 0) goto L31
        L24:
            java.lang.String r5 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r5 = r5.length()
        L2c:
            io.flutter.view.C0408c.C0420l.m1137l(r4, r5)
            goto L108
        L31:
            io.flutter.view.C0408c.C0420l.m1137l(r4, r2)
            goto L108
        L36:
            if (r6 == 0) goto L6b
            int r5 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            java.lang.String r1 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto L6b
            java.lang.String r5 = "(?!^)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r1 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
        L62:
            int r5 = r5.start(r0)
            io.flutter.view.C0408c.C0420l.m1135m(r4, r5)
            goto L108
        L6b:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r1 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L31
        L8f:
            int r5 = r5.start(r0)
            goto L2c
        L94:
            if (r6 == 0) goto Lc4
            int r5 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            java.lang.String r1 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lc4
            java.lang.String r5 = "\\p{L}(\\b)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r1 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            r5.find()
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
            goto L62
        Lc4:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\b)\\p{L}"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r1 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L108
            goto L8f
        Le9:
            if (r6 == 0) goto Lfd
            int r5 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            java.lang.String r1 = io.flutter.view.C0408c.C0420l.m1127q(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lfd
            io.flutter.view.C0408c.C0420l.m1135m(r4, r0)
            goto L108
        Lfd:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            if (r5 <= 0) goto L108
            io.flutter.view.C0408c.C0420l.m1133n(r4, r0)
        L108:
            if (r7 != 0) goto L111
            int r5 = io.flutter.view.C0408c.C0420l.m1139k(r4)
            io.flutter.view.C0408c.C0420l.m1141j(r4, r5)
        L111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.C0408c.m1243R(io.flutter.view.c$l, int, boolean, boolean):void");
    }

    /* renamed from: U */
    public void m1240U(AccessibilityEvent accessibilityEvent) {
        if (this.f777c.isEnabled()) {
            this.f775a.getParent().requestSendAccessibilityEvent(this.f775a, accessibilityEvent);
        }
    }

    /* renamed from: V */
    public void m1239V() {
        this.f776b.m172f(this.f786l);
    }

    /* renamed from: W */
    private void m1238W(int i) {
        AccessibilityEvent m1252I = m1252I(i, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            m1252I.setContentChangeTypes(1);
        }
        m1240U(m1252I);
    }

    @TargetApi(28)
    /* renamed from: X */
    private void m1237X(String str) {
        this.f775a.setAccessibilityPaneTitle(str);
    }

    /* renamed from: Y */
    public void m1236Y(boolean z) {
        if (this.f794t == z) {
            return;
        }
        this.f794t = z;
        this.f786l = z ? this.f786l | EnumC0414f.ACCESSIBLE_NAVIGATION.f814d : this.f786l & (EnumC0414f.ACCESSIBLE_NAVIGATION.f814d ^ (-1));
        m1239V();
    }

    @TargetApi(31)
    /* renamed from: Z */
    private void m1235Z() {
        View view = this.f775a;
        if (view == null || view.getResources() == null) {
            return;
        }
        int i = this.f775a.getResources().getConfiguration().fontWeightAdjustment;
        this.f786l = i != Integer.MAX_VALUE && i >= 300 ? this.f786l | EnumC0414f.BOLD_TEXT.f814d : this.f786l & EnumC0414f.BOLD_TEXT.f814d;
        m1239V();
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m1234a(C0420l c0420l) {
        return m1254G(c0420l);
    }

    /* renamed from: b */
    public static /* synthetic */ boolean m1232b(C0420l c0420l, C0420l c0420l2) {
        return m1255F(c0420l, c0420l2);
    }

    /* renamed from: b0 */
    private boolean m1231b0(final C0420l c0420l) {
        return c0420l.f911j > 0 && (C0420l.m1187B0(this.f783i, new InterfaceC0142d() { // from class: io.flutter.view.a
            @Override // p012e0.InterfaceC0142d
            public final boolean test(Object obj) {
                return C0408c.m1232b(C0408c.C0420l.this, (C0408c.C0420l) obj);
            }
        }) || !C0420l.m1187B0(this.f783i, new InterfaceC0142d() { // from class: io.flutter.view.b
            @Override // p012e0.InterfaceC0142d
            public final boolean test(Object obj) {
                return C0408c.m1234a((C0408c.C0420l) obj);
            }
        }));
    }

    /* renamed from: e */
    static /* synthetic */ int m1226e(C0408c c0408c, int i) {
        int i2 = i & c0408c.f786l;
        c0408c.f786l = i2;
        return i2;
    }

    @TargetApi(19)
    /* renamed from: e0 */
    private void m1225e0(C0420l c0420l) {
        View mo1352c;
        Integer num;
        c0420l.f891Q = null;
        if (c0420l.f910i != -1 && (num = this.f784j) != null && this.f778d.platformViewOfNode(num.intValue()) == this.f779e.mo1352c(c0420l.f910i)) {
            m1241T(this.f784j.intValue(), 65536);
            this.f784j = null;
        }
        if (c0420l.f910i != -1 && (mo1352c = this.f779e.mo1352c(c0420l.f910i)) != null) {
            mo1352c.setImportantForAccessibility(4);
        }
        C0420l c0420l2 = this.f783i;
        if (c0420l2 == c0420l) {
            m1241T(c0420l2.f903b, 65536);
            this.f783i = null;
        }
        if (this.f787m == c0420l) {
            this.f787m = null;
        }
        if (this.f789o == c0420l) {
            this.f789o = null;
        }
    }

    /* renamed from: f */
    static /* synthetic */ int m1224f(C0408c c0408c, int i) {
        int i2 = i | c0408c.f786l;
        c0408c.f786l = i2;
        return i2;
    }

    /* renamed from: u */
    private AccessibilityEvent m1209u(int i, String str, String str2) {
        AccessibilityEvent m1252I = m1252I(i, 16);
        m1252I.setBeforeText(str);
        m1252I.getText().add(str2);
        int i2 = 0;
        while (i2 < str.length() && i2 < str2.length() && str.charAt(i2) == str2.charAt(i2)) {
            i2++;
        }
        if (i2 < str.length() || i2 < str2.length()) {
            m1252I.setFromIndex(i2);
            int length = str.length() - 1;
            int length2 = str2.length() - 1;
            while (length >= i2 && length2 >= i2 && str.charAt(length) == str2.charAt(length2)) {
                length--;
                length2--;
            }
            m1252I.setRemovedCount((length - i2) + 1);
            m1252I.setAddedCount((length2 - i2) + 1);
            return m1252I;
        }
        return null;
    }

    @TargetApi(28)
    /* renamed from: v */
    private boolean m1208v() {
        Activity m2025f = C0146h.m2025f(this.f775a.getContext());
        if (m2025f == null || m2025f.getWindow() == null) {
            return false;
        }
        int i = m2025f.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i == 2 || i == 0;
    }

    /* renamed from: x */
    private Rect m1206x(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f775a.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* renamed from: y */
    public C0416h m1205y(int i) {
        C0416h c0416h = this.f782h.get(Integer.valueOf(i));
        if (c0416h == null) {
            C0416h c0416h2 = new C0416h();
            c0416h2.f840b = i;
            c0416h2.f839a = f772B + i;
            this.f782h.put(Integer.valueOf(i), c0416h2);
            return c0416h2;
        }
        return c0416h;
    }

    /* renamed from: z */
    public C0420l m1204z(int i) {
        C0420l c0420l = this.f781g.get(Integer.valueOf(i));
        if (c0420l == null) {
            C0420l c0420l2 = new C0420l(this);
            c0420l2.f903b = i;
            this.f781g.put(Integer.valueOf(i), c0420l2);
            return c0420l2;
        }
        return c0420l;
    }

    /* renamed from: C */
    public boolean m1258C() {
        return this.f777c.isEnabled();
    }

    /* renamed from: E */
    public boolean m1256E() {
        return this.f777c.isTouchExplorationEnabled();
    }

    /* renamed from: H */
    public AccessibilityEvent m1253H(int i) {
        return AccessibilityEvent.obtain(i);
    }

    /* renamed from: J */
    public AccessibilityNodeInfo m1251J(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    /* renamed from: K */
    public AccessibilityNodeInfo m1250K(View view, int i) {
        return AccessibilityNodeInfo.obtain(view, i);
    }

    /* renamed from: L */
    public boolean m1249L(MotionEvent motionEvent) {
        return m1248M(motionEvent, false);
    }

    /* renamed from: M */
    public boolean m1248M(MotionEvent motionEvent, boolean z) {
        if (this.f777c.isTouchExplorationEnabled() && !this.f781g.isEmpty()) {
            C0420l m1112x0 = m1260A().m1112x0(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z);
            if (m1112x0 != null && m1112x0.f910i != -1) {
                if (z) {
                    return false;
                }
                return this.f778d.onAccessibilityHoverEvent(m1112x0.f903b, motionEvent);
            }
            if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                m1259B(motionEvent.getX(), motionEvent.getY(), z);
            } else if (motionEvent.getAction() != 10) {
                C0576b.m742a("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            } else {
                m1247N();
            }
            return true;
        }
        return false;
    }

    /* renamed from: S */
    public void m1242S() {
        this.f795u = true;
        this.f779e.mo1356a();
        m1233a0(null);
        this.f777c.removeAccessibilityStateChangeListener(this.f797w);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f777c.removeTouchExplorationStateChangeListener(this.f798x);
        }
        this.f780f.unregisterContentObserver(this.f799y);
        this.f776b.m171g(null);
    }

    /* renamed from: T */
    public void m1241T(int i, int i2) {
        if (this.f777c.isEnabled()) {
            m1240U(m1252I(i, i2));
        }
    }

    /* renamed from: a0 */
    public void m1233a0(InterfaceC0419k interfaceC0419k) {
        this.f793s = interfaceC0419k;
    }

    /* renamed from: c0 */
    void m1229c0(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            C0416h m1205y = m1205y(byteBuffer.getInt());
            m1205y.f841c = byteBuffer.getInt();
            int i = byteBuffer.getInt();
            String str = null;
            m1205y.f842d = i == -1 ? null : strArr[i];
            int i2 = byteBuffer.getInt();
            if (i2 != -1) {
                str = strArr[i2];
            }
            m1205y.f843e = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:522:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:536:0x0474 A[LOOP:0: B:534:0x046e->B:536:0x0474, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0499  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r17) {
        /*
            Method dump skipped, instructions count: 1235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.C0408c.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* renamed from: d0 */
    void m1227d0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        C0420l c0420l;
        C0420l c0420l2;
        float f;
        float f2;
        WindowInsets rootWindowInsets;
        Integer valueOf;
        View mo1352c;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            C0420l m1204z = m1204z(byteBuffer.getInt());
            m1204z.m1181E0(byteBuffer, strArr, byteBufferArr);
            if (!m1204z.m1114w0(EnumC0417i.IS_HIDDEN)) {
                if (m1204z.m1114w0(EnumC0417i.IS_FOCUSED)) {
                    this.f787m = m1204z;
                }
                if (m1204z.f876B) {
                    arrayList.add(m1204z);
                }
                if (m1204z.f910i != -1 && !this.f779e.mo1350d(m1204z.f910i) && (mo1352c = this.f779e.mo1352c(m1204z.f910i)) != null) {
                    mo1352c.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        C0420l m1260A = m1260A();
        ArrayList<C0420l> arrayList2 = new ArrayList();
        if (m1260A != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                if ((i >= 28 ? m1208v() : true) && (rootWindowInsets = this.f775a.getRootWindowInsets()) != null) {
                    if (!this.f792r.equals(Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft()))) {
                        m1260A.f899Y = true;
                        m1260A.f897W = true;
                    }
                    this.f792r = Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft());
                    Matrix.translateM(fArr, 0, valueOf.intValue(), 0.0f, 0.0f);
                }
            }
            m1260A.m1183D0(fArr, hashSet, false);
            m1260A.m1148f0(arrayList2);
        }
        C0420l c0420l3 = null;
        for (C0420l c0420l4 : arrayList2) {
            if (!this.f790p.contains(Integer.valueOf(c0420l4.f903b))) {
                c0420l3 = c0420l4;
            }
        }
        if (c0420l3 == null && arrayList2.size() > 0) {
            c0420l3 = (C0420l) arrayList2.get(arrayList2.size() - 1);
        }
        if (c0420l3 != null && (c0420l3.f903b != this.f791q || arrayList2.size() != this.f790p.size())) {
            this.f791q = c0420l3.f903b;
            m1246O(c0420l3);
        }
        this.f790p.clear();
        for (C0420l c0420l5 : arrayList2) {
            this.f790p.add(Integer.valueOf(c0420l5.f903b));
        }
        Iterator<Map.Entry<Integer, C0420l>> it = this.f781g.entrySet().iterator();
        while (it.hasNext()) {
            C0420l value = it.next().getValue();
            if (!hashSet.contains(value)) {
                m1225e0(value);
                it.remove();
            }
        }
        m1238W(0);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C0420l c0420l6 = (C0420l) it2.next();
            if (c0420l6.m1142i0()) {
                AccessibilityEvent m1252I = m1252I(c0420l6.f903b, 4096);
                float f3 = c0420l6.f913l;
                float f4 = c0420l6.f914m;
                if (Float.isInfinite(c0420l6.f914m)) {
                    if (f3 > 70000.0f) {
                        f3 = 70000.0f;
                    }
                    f4 = 100000.0f;
                }
                if (Float.isInfinite(c0420l6.f915n)) {
                    f = f4 + 100000.0f;
                    if (f3 < -70000.0f) {
                        f3 = -70000.0f;
                    }
                    f2 = f3 + 100000.0f;
                } else {
                    f = f4 - c0420l6.f915n;
                    f2 = f3 - c0420l6.f915n;
                }
                if (c0420l6.m1120t0(EnumC0415g.SCROLL_UP) || c0420l6.m1120t0(EnumC0415g.SCROLL_DOWN)) {
                    m1252I.setScrollY((int) f2);
                    m1252I.setMaxScrollY((int) f);
                } else if (c0420l6.m1120t0(EnumC0415g.SCROLL_LEFT) || c0420l6.m1120t0(EnumC0415g.SCROLL_RIGHT)) {
                    m1252I.setScrollX((int) f2);
                    m1252I.setMaxScrollX((int) f);
                }
                if (c0420l6.f911j > 0) {
                    m1252I.setItemCount(c0420l6.f911j);
                    m1252I.setFromIndex(c0420l6.f912k);
                    int i2 = 0;
                    for (C0420l c0420l7 : c0420l6.f893S) {
                        if (!c0420l7.m1114w0(EnumC0417i.IS_HIDDEN)) {
                            i2++;
                        }
                    }
                    m1252I.setToIndex((c0420l6.f912k + i2) - 1);
                }
                m1240U(m1252I);
            }
            if (c0420l6.m1114w0(EnumC0417i.IS_LIVE_REGION) && c0420l6.m1144h0()) {
                m1238W(c0420l6.f903b);
            }
            C0420l c0420l8 = this.f783i;
            if (c0420l8 != null && c0420l8.f903b == c0420l6.f903b) {
                EnumC0417i enumC0417i = EnumC0417i.IS_SELECTED;
                if (!c0420l6.m1118u0(enumC0417i) && c0420l6.m1114w0(enumC0417i)) {
                    AccessibilityEvent m1252I2 = m1252I(c0420l6.f903b, 4);
                    m1252I2.getText().add(c0420l6.f916o);
                    m1240U(m1252I2);
                }
            }
            C0420l c0420l9 = this.f787m;
            if (c0420l9 != null && c0420l9.f903b == c0420l6.f903b && ((c0420l2 = this.f788n) == null || c0420l2.f903b != this.f787m.f903b)) {
                this.f788n = this.f787m;
                m1240U(m1252I(c0420l6.f903b, 8));
            } else if (this.f787m == null) {
                this.f788n = null;
            }
            C0420l c0420l10 = this.f787m;
            if (c0420l10 != null && c0420l10.f903b == c0420l6.f903b) {
                EnumC0417i enumC0417i2 = EnumC0417i.IS_TEXT_FIELD;
                if (c0420l6.m1118u0(enumC0417i2) && c0420l6.m1114w0(enumC0417i2) && ((c0420l = this.f783i) == null || c0420l.f903b == this.f787m.f903b)) {
                    String str = c0420l6.f884J != null ? c0420l6.f884J : "";
                    String str2 = c0420l6.f918q != null ? c0420l6.f918q : "";
                    AccessibilityEvent m1209u = m1209u(c0420l6.f903b, str, str2);
                    if (m1209u != null) {
                        m1240U(m1209u);
                    }
                    if (c0420l6.f879E != c0420l6.f908g || c0420l6.f880F != c0420l6.f909h) {
                        AccessibilityEvent m1252I3 = m1252I(c0420l6.f903b, 8192);
                        m1252I3.getText().add(str2);
                        m1252I3.setFromIndex(c0420l6.f908g);
                        m1252I3.setToIndex(c0420l6.f909h);
                        m1252I3.setItemCount(str2.length());
                        m1240U(m1252I3);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0016, code lost:
        if (r2 != null) goto L11;
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.accessibility.AccessibilityNodeInfo findFocus(int r2) {
        /*
            r1 = this;
            r0 = 1
            if (r2 == r0) goto L7
            r0 = 2
            if (r2 == r0) goto L1d
            goto L27
        L7:
            io.flutter.view.c$l r2 = r1.f787m
            if (r2 == 0) goto L14
        Lb:
            int r2 = io.flutter.view.C0408c.C0420l.m1159a(r2)
        Lf:
            android.view.accessibility.AccessibilityNodeInfo r2 = r1.createAccessibilityNodeInfo(r2)
            return r2
        L14:
            java.lang.Integer r2 = r1.f785k
            if (r2 == 0) goto L1d
        L18:
            int r2 = r2.intValue()
            goto Lf
        L1d:
            io.flutter.view.c$l r2 = r1.f783i
            if (r2 == 0) goto L22
            goto Lb
        L22:
            java.lang.Integer r2 = r1.f784j
            if (r2 == 0) goto L27
            goto L18
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.C0408c.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        int i3;
        if (i >= 65536) {
            boolean performAction = this.f778d.performAction(i, i2, bundle);
            if (performAction && i2 == 128) {
                this.f784j = null;
            }
            return performAction;
        }
        C0420l c0420l = this.f781g.get(Integer.valueOf(i));
        boolean z = false;
        if (c0420l == null) {
            return false;
        }
        switch (i2) {
            case 16:
                this.f776b.m176b(i, EnumC0415g.TAP);
                return true;
            case 32:
                this.f776b.m176b(i, EnumC0415g.LONG_PRESS);
                return true;
            case 64:
                if (this.f783i == null) {
                    this.f775a.invalidate();
                }
                this.f783i = c0420l;
                this.f776b.m176b(i, EnumC0415g.DID_GAIN_ACCESSIBILITY_FOCUS);
                m1241T(i, 32768);
                if (c0420l.m1116v0(EnumC0415g.INCREASE) || c0420l.m1116v0(EnumC0415g.DECREASE)) {
                    m1241T(i, 4);
                }
                return true;
            case 128:
                C0420l c0420l2 = this.f783i;
                if (c0420l2 != null && c0420l2.f903b == i) {
                    this.f783i = null;
                }
                Integer num = this.f784j;
                if (num != null && num.intValue() == i) {
                    this.f784j = null;
                }
                this.f776b.m176b(i, EnumC0415g.DID_LOSE_ACCESSIBILITY_FOCUS);
                m1241T(i, 65536);
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return m1245P(c0420l, i, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return m1245P(c0420l, i, bundle, false);
            case 4096:
                EnumC0415g enumC0415g = EnumC0415g.SCROLL_UP;
                if (!c0420l.m1116v0(enumC0415g)) {
                    enumC0415g = EnumC0415g.SCROLL_LEFT;
                    if (!c0420l.m1116v0(enumC0415g)) {
                        enumC0415g = EnumC0415g.INCREASE;
                        if (!c0420l.m1116v0(enumC0415g)) {
                            return false;
                        }
                        c0420l.f918q = c0420l.f920s;
                        c0420l.f919r = c0420l.f921t;
                        m1241T(i, 4);
                    }
                }
                this.f776b.m176b(i, enumC0415g);
                return true;
            case 8192:
                EnumC0415g enumC0415g2 = EnumC0415g.SCROLL_DOWN;
                if (!c0420l.m1116v0(enumC0415g2)) {
                    enumC0415g2 = EnumC0415g.SCROLL_RIGHT;
                    if (!c0420l.m1116v0(enumC0415g2)) {
                        enumC0415g2 = EnumC0415g.DECREASE;
                        if (!c0420l.m1116v0(enumC0415g2)) {
                            return false;
                        }
                        c0420l.f918q = c0420l.f922u;
                        c0420l.f919r = c0420l.f923v;
                        m1241T(i, 4);
                    }
                }
                this.f776b.m176b(i, enumC0415g2);
                return true;
            case 16384:
                this.f776b.m176b(i, EnumC0415g.COPY);
                return true;
            case 32768:
                this.f776b.m176b(i, EnumC0415g.PASTE);
                return true;
            case 65536:
                this.f776b.m176b(i, EnumC0415g.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z = true;
                }
                if (z) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i3 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    hashMap.put("base", Integer.valueOf(c0420l.f909h));
                    i3 = c0420l.f909h;
                }
                hashMap.put("extent", Integer.valueOf(i3));
                this.f776b.m175c(i, EnumC0415g.SET_SELECTION, hashMap);
                C0420l c0420l3 = this.f781g.get(Integer.valueOf(i));
                c0420l3.f908g = ((Integer) hashMap.get("base")).intValue();
                c0420l3.f909h = ((Integer) hashMap.get("extent")).intValue();
                return true;
            case 1048576:
                this.f776b.m176b(i, EnumC0415g.DISMISS);
                return true;
            case 2097152:
                if (Build.VERSION.SDK_INT < 21) {
                    return false;
                }
                return m1244Q(c0420l, i, bundle);
            case 16908342:
                this.f776b.m176b(i, EnumC0415g.SHOW_ON_SCREEN);
                return true;
            default:
                C0416h c0416h = this.f782h.get(Integer.valueOf(i2 - f772B));
                if (c0416h != null) {
                    this.f776b.m175c(i, EnumC0415g.CUSTOM_ACTION, Integer.valueOf(c0416h.f840b));
                    return true;
                }
                return false;
        }
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: w */
    public boolean m1207w(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (this.f778d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) && (recordFlutterId = this.f778d.getRecordFlutterId(view, accessibilityEvent)) != null) {
            int eventType = accessibilityEvent.getEventType();
            if (eventType == 8) {
                this.f785k = recordFlutterId;
                this.f787m = null;
                return true;
            } else if (eventType == 128) {
                this.f789o = null;
                return true;
            } else if (eventType == 32768) {
                this.f784j = recordFlutterId;
                this.f783i = null;
                return true;
            } else if (eventType != 65536) {
                return true;
            } else {
                this.f785k = null;
                this.f784j = null;
                return true;
            }
        }
        return false;
    }
}