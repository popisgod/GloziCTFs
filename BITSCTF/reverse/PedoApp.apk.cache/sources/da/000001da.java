package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.C0291r;
import io.flutter.plugin.editing.C0349c;
import io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback;
import io.flutter.plugin.platform.C0390r;
import java.util.HashMap;
import p019i.C0239a;
import p031o.C0576b;
import p053z.C0898q;

/* renamed from: io.flutter.plugin.editing.f */
/* loaded from: classes.dex */
public class C0354f implements C0349c.InterfaceC0351b {

    /* renamed from: a */
    private final View f624a;

    /* renamed from: b */
    private final InputMethodManager f625b;

    /* renamed from: c */
    private final AutofillManager f626c;

    /* renamed from: d */
    private final C0898q f627d;

    /* renamed from: e */
    private C0358d f628e = new C0358d(C0358d.EnumC0359a.NO_TARGET, 0);

    /* renamed from: f */
    private C0898q.C0900b f629f;

    /* renamed from: g */
    private SparseArray<C0898q.C0900b> f630g;

    /* renamed from: h */
    private C0349c f631h;

    /* renamed from: i */
    private boolean f632i;

    /* renamed from: j */
    private InputConnection f633j;

    /* renamed from: k */
    private C0390r f634k;

    /* renamed from: l */
    private Rect f635l;

    /* renamed from: m */
    private ImeSyncDeferringInsetsCallback f636m;

    /* renamed from: n */
    private C0898q.C0904e f637n;

    /* renamed from: o */
    private boolean f638o;

    /* renamed from: io.flutter.plugin.editing.f$a */
    /* loaded from: classes.dex */
    class C0355a implements ImeSyncDeferringInsetsCallback.InterfaceC0344b {
        C0355a() {
        }

        @Override // io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback.InterfaceC0344b
        /* renamed from: a */
        public void mo1452a(boolean z) {
            if (z) {
                return;
            }
            C0354f.this.m1453z();
        }
    }

    /* renamed from: io.flutter.plugin.editing.f$b */
    /* loaded from: classes.dex */
    class C0356b implements C0898q.InterfaceC0905f {
        C0356b() {
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: a */
        public void mo14a(String str, Bundle bundle) {
            C0354f.this.m1485C(str, bundle);
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: b */
        public void mo13b() {
            C0354f.this.m1455x();
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: c */
        public void mo12c() {
            C0354f.this.m1466m();
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: d */
        public void mo11d() {
            C0354f c0354f = C0354f.this;
            c0354f.m1481G(c0354f.f624a);
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: e */
        public void mo10e(C0898q.C0904e c0904e) {
            C0354f c0354f = C0354f.this;
            c0354f.m1482F(c0354f.f624a, c0904e);
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: f */
        public void mo9f(int i, C0898q.C0900b c0900b) {
            C0354f.this.m1483E(i, c0900b);
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: g */
        public void mo8g(int i, boolean z) {
            C0354f.this.m1484D(i, z);
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: h */
        public void mo7h(double d, double d2, double[] dArr) {
            C0354f.this.m1486B(d, d2, dArr);
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: i */
        public void mo6i(boolean z) {
            if (Build.VERSION.SDK_INT < 26 || C0354f.this.f626c == null) {
                return;
            }
            if (z) {
                C0354f.this.f626c.commit();
            } else {
                C0354f.this.f626c.cancel();
            }
        }

        @Override // p053z.C0898q.InterfaceC0905f
        /* renamed from: j */
        public void mo5j() {
            if (C0354f.this.f628e.f645a == C0358d.EnumC0359a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                C0354f.this.m1454y();
                return;
            }
            C0354f c0354f = C0354f.this;
            c0354f.m1460s(c0354f.f624a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.editing.f$c */
    /* loaded from: classes.dex */
    public class C0357c implements InterfaceC0360e {

        /* renamed from: a */
        final /* synthetic */ boolean f641a;

        /* renamed from: b */
        final /* synthetic */ double[] f642b;

        /* renamed from: c */
        final /* synthetic */ double[] f643c;

        C0357c(boolean z, double[] dArr, double[] dArr2) {
            this.f641a = z;
            this.f642b = dArr;
            this.f643c = dArr2;
        }

        @Override // io.flutter.plugin.editing.C0354f.InterfaceC0360e
        /* renamed from: a */
        public void mo1451a(double d, double d2) {
            double d3 = 1.0d;
            if (!this.f641a) {
                double[] dArr = this.f642b;
                d3 = 1.0d / (((dArr[3] * d) + (dArr[7] * d2)) + dArr[15]);
            }
            double[] dArr2 = this.f642b;
            double d4 = ((dArr2[0] * d) + (dArr2[4] * d2) + dArr2[12]) * d3;
            double d5 = ((dArr2[1] * d) + (dArr2[5] * d2) + dArr2[13]) * d3;
            double[] dArr3 = this.f643c;
            if (d4 < dArr3[0]) {
                dArr3[0] = d4;
            } else if (d4 > dArr3[1]) {
                dArr3[1] = d4;
            }
            if (d5 < dArr3[2]) {
                dArr3[2] = d5;
            } else if (d5 > dArr3[3]) {
                dArr3[3] = d5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.plugin.editing.f$d */
    /* loaded from: classes.dex */
    public static class C0358d {

        /* renamed from: a */
        EnumC0359a f645a;

        /* renamed from: b */
        int f646b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.flutter.plugin.editing.f$d$a */
        /* loaded from: classes.dex */
        public enum EnumC0359a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public C0358d(EnumC0359a enumC0359a, int i) {
            this.f645a = enumC0359a;
            this.f646b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.plugin.editing.f$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0360e {
        /* renamed from: a */
        void mo1451a(double d, double d2);
    }

    @SuppressLint({"NewApi"})
    public C0354f(View view, C0898q c0898q, C0390r c0390r) {
        this.f624a = view;
        this.f631h = new C0349c(null, view);
        this.f625b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i = Build.VERSION.SDK_INT;
        this.f626c = i >= 26 ? (AutofillManager) view.getContext().getSystemService(AutofillManager.class) : null;
        if (i >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.f636m = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
            this.f636m.setImeVisibleListener(new C0355a());
        }
        this.f627d = c0898q;
        c0898q.m29o(new C0356b());
        c0898q.m32l();
        this.f634k = c0390r;
        c0390r.m1379D(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m1486B(double d, double d2, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d3 = dArr[12] / dArr[15];
        dArr2[1] = d3;
        dArr2[0] = d3;
        double d4 = dArr[13] / dArr[15];
        dArr2[3] = d4;
        dArr2[2] = d4;
        C0357c c0357c = new C0357c(z, dArr, dArr2);
        c0357c.mo1451a(d, 0.0d);
        c0357c.mo1451a(d, d2);
        c0357c.mo1451a(0.0d, d2);
        Float valueOf = Float.valueOf(this.f624a.getContext().getResources().getDisplayMetrics().density);
        double d5 = dArr2[0];
        double floatValue = valueOf.floatValue();
        Double.isNaN(floatValue);
        double d6 = dArr2[2];
        double floatValue2 = valueOf.floatValue();
        Double.isNaN(floatValue2);
        double d7 = dArr2[1];
        double floatValue3 = valueOf.floatValue();
        Double.isNaN(floatValue3);
        double d8 = dArr2[3];
        double floatValue4 = valueOf.floatValue();
        Double.isNaN(floatValue4);
        this.f635l = new Rect((int) (d5 * floatValue), (int) (d6 * floatValue2), (int) Math.ceil(d7 * floatValue3), (int) Math.ceil(d8 * floatValue4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m1484D(int i, boolean z) {
        if (!z) {
            this.f628e = new C0358d(C0358d.EnumC0359a.PHYSICAL_DISPLAY_PLATFORM_VIEW, i);
            this.f633j = null;
            return;
        }
        this.f624a.requestFocus();
        this.f628e = new C0358d(C0358d.EnumC0359a.VIRTUAL_DISPLAY_PLATFORM_VIEW, i);
        this.f625b.restartInput(this.f624a);
        this.f632i = false;
    }

    /* renamed from: I */
    private void m1479I(C0898q.C0900b c0900b) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (c0900b == null || c0900b.f1628j == null) {
            this.f630g = null;
            return;
        }
        C0898q.C0900b[] c0900bArr = c0900b.f1630l;
        SparseArray<C0898q.C0900b> sparseArray = new SparseArray<>();
        this.f630g = sparseArray;
        if (c0900bArr == null) {
            sparseArray.put(c0900b.f1628j.f1631a.hashCode(), c0900b);
            return;
        }
        for (C0898q.C0900b c0900b2 : c0900bArr) {
            C0898q.C0900b.C0901a c0901a = c0900b2.f1628j;
            if (c0901a != null) {
                this.f630g.put(c0901a.f1631a.hashCode(), c0900b2);
                this.f626c.notifyValueChanged(this.f624a, c0901a.f1631a.hashCode(), AutofillValue.forText(c0901a.f1633c.f1644a));
            }
        }
    }

    /* renamed from: k */
    private boolean m1468k() {
        C0898q.C0902c c0902c;
        C0898q.C0900b c0900b = this.f629f;
        return c0900b == null || (c0902c = c0900b.f1625g) == null || c0902c.f1635a != C0898q.EnumC0906g.NONE;
    }

    /* renamed from: n */
    private static boolean m1465n(C0898q.C0904e c0904e, C0898q.C0904e c0904e2) {
        int i = c0904e.f1648e - c0904e.f1647d;
        if (i != c0904e2.f1648e - c0904e2.f1647d) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (c0904e.f1644a.charAt(c0904e.f1647d + i2) != c0904e2.f1644a.charAt(c0904e2.f1647d + i2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m1460s(View view) {
        m1454y();
        this.f625b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    /* renamed from: t */
    private static int m1459t(C0898q.C0902c c0902c, boolean z, boolean z2, boolean z3, boolean z4, C0898q.EnumC0903d enumC0903d) {
        C0898q.EnumC0906g enumC0906g = c0902c.f1635a;
        if (enumC0906g == C0898q.EnumC0906g.DATETIME) {
            return 4;
        }
        if (enumC0906g == C0898q.EnumC0906g.NUMBER) {
            int i = c0902c.f1636b ? 4098 : 2;
            return c0902c.f1637c ? i | 8192 : i;
        } else if (enumC0906g == C0898q.EnumC0906g.PHONE) {
            return 3;
        } else {
            if (enumC0906g == C0898q.EnumC0906g.NONE) {
                return 0;
            }
            int i2 = 1;
            if (enumC0906g == C0898q.EnumC0906g.MULTILINE) {
                i2 = 131073;
            } else if (enumC0906g == C0898q.EnumC0906g.EMAIL_ADDRESS) {
                i2 = 33;
            } else if (enumC0906g == C0898q.EnumC0906g.URL) {
                i2 = 17;
            } else if (enumC0906g == C0898q.EnumC0906g.VISIBLE_PASSWORD) {
                i2 = 145;
            } else if (enumC0906g == C0898q.EnumC0906g.NAME) {
                i2 = 97;
            } else if (enumC0906g == C0898q.EnumC0906g.POSTAL_ADDRESS) {
                i2 = 113;
            }
            if (z) {
                i2 = i2 | 524288 | 128;
            } else {
                if (z2) {
                    i2 |= 32768;
                }
                if (!z3) {
                    i2 = i2 | 524288 | 144;
                }
            }
            return enumC0903d == C0898q.EnumC0903d.CHARACTERS ? i2 | 4096 : enumC0903d == C0898q.EnumC0903d.WORDS ? i2 | 8192 : enumC0903d == C0898q.EnumC0903d.SENTENCES ? i2 | 16384 : i2;
        }
    }

    /* renamed from: v */
    private boolean m1457v() {
        return this.f630g != null;
    }

    /* renamed from: w */
    private void m1456w(String str) {
        if (Build.VERSION.SDK_INT < 26 || this.f626c == null || !m1457v()) {
            return;
        }
        this.f626c.notifyValueChanged(this.f624a, this.f629f.f1628j.f1631a.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m1455x() {
        if (Build.VERSION.SDK_INT < 26 || this.f626c == null || !m1457v()) {
            return;
        }
        String str = this.f629f.f1628j.f1631a;
        int[] iArr = new int[2];
        this.f624a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.f635l);
        rect.offset(iArr[0], iArr[1]);
        this.f626c.notifyViewEntered(this.f624a, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m1454y() {
        C0898q.C0900b c0900b;
        if (Build.VERSION.SDK_INT < 26 || this.f626c == null || (c0900b = this.f629f) == null || c0900b.f1628j == null || !m1457v()) {
            return;
        }
        this.f626c.notifyViewExited(this.f624a, this.f629f.f1628j.f1631a.hashCode());
    }

    /* renamed from: A */
    public void m1487A(ViewStructure viewStructure, int i) {
        ViewStructure viewStructure2;
        CharSequence charSequence;
        Rect rect;
        if (Build.VERSION.SDK_INT < 26 || !m1457v()) {
            return;
        }
        String str = this.f629f.f1628j.f1631a;
        AutofillId autofillId = viewStructure.getAutofillId();
        for (int i2 = 0; i2 < this.f630g.size(); i2++) {
            int keyAt = this.f630g.keyAt(i2);
            C0898q.C0900b.C0901a c0901a = this.f630g.valueAt(i2).f1628j;
            if (c0901a != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i2);
                newChild.setAutofillId(autofillId, keyAt);
                String[] strArr = c0901a.f1632b;
                if (strArr.length > 0) {
                    newChild.setAutofillHints(strArr);
                }
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                String str2 = c0901a.f1634d;
                if (str2 != null) {
                    newChild.setHint(str2);
                }
                if (str.hashCode() != keyAt || (rect = this.f635l) == null) {
                    viewStructure2 = newChild;
                    viewStructure2.setDimens(0, 0, 0, 0, 1, 1);
                    charSequence = c0901a.f1633c.f1644a;
                } else {
                    viewStructure2 = newChild;
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.f635l.height());
                    charSequence = this.f631h;
                }
                viewStructure2.setAutofillValue(AutofillValue.forText(charSequence));
            }
        }
    }

    /* renamed from: C */
    public void m1485C(String str, Bundle bundle) {
        this.f625b.sendAppPrivateCommand(this.f624a, str, bundle);
    }

    /* renamed from: E */
    void m1483E(int i, C0898q.C0900b c0900b) {
        m1454y();
        this.f629f = c0900b;
        this.f628e = m1468k() ? new C0358d(C0358d.EnumC0359a.FRAMEWORK_CLIENT, i) : new C0358d(C0358d.EnumC0359a.NO_TARGET, i);
        this.f631h.m1494l(this);
        C0898q.C0900b.C0901a c0901a = c0900b.f1628j;
        this.f631h = new C0349c(c0901a != null ? c0901a.f1633c : null, this.f624a);
        m1479I(c0900b);
        this.f632i = true;
        m1480H();
        this.f635l = null;
        this.f631h.m1505a(this);
    }

    /* renamed from: F */
    void m1482F(View view, C0898q.C0904e c0904e) {
        C0898q.C0904e c0904e2;
        if (!this.f632i && (c0904e2 = this.f637n) != null && c0904e2.m16b()) {
            boolean m1465n = m1465n(this.f637n, c0904e);
            this.f632i = m1465n;
            if (m1465n) {
                C0576b.m738e("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.f637n = c0904e;
        this.f631h.m1492n(c0904e);
        if (this.f632i) {
            this.f625b.restartInput(view);
            this.f632i = false;
        }
    }

    /* renamed from: G */
    void m1481G(View view) {
        if (!m1468k()) {
            m1460s(view);
            return;
        }
        view.requestFocus();
        this.f625b.showSoftInput(view, 0);
    }

    /* renamed from: H */
    public void m1480H() {
        if (this.f628e.f645a == C0358d.EnumC0359a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f638o = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r7 == r1.f1648e) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    @Override // io.flutter.plugin.editing.C0349c.InterfaceC0351b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1478a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.c r9 = r8.f631h
            java.lang.String r9 = r9.toString()
            r8.m1456w(r9)
        Lb:
            io.flutter.plugin.editing.c r9 = r8.f631h
            int r9 = r9.m1497i()
            io.flutter.plugin.editing.c r10 = r8.f631h
            int r10 = r10.m1498h()
            io.flutter.plugin.editing.c r11 = r8.f631h
            int r11 = r11.m1499g()
            io.flutter.plugin.editing.c r0 = r8.f631h
            int r7 = r0.m1500f()
            io.flutter.plugin.editing.c r0 = r8.f631h
            java.util.ArrayList r0 = r0.m1501e()
            z.q$e r1 = r8.f637n
            if (r1 == 0) goto L52
            io.flutter.plugin.editing.c r1 = r8.f631h
            java.lang.String r1 = r1.toString()
            z.q$e r2 = r8.f637n
            java.lang.String r2 = r2.f1644a
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L50
            z.q$e r1 = r8.f637n
            int r2 = r1.f1645b
            if (r9 != r2) goto L50
            int r2 = r1.f1646c
            if (r10 != r2) goto L50
            int r2 = r1.f1647d
            if (r11 != r2) goto L50
            int r1 = r1.f1648e
            if (r7 != r1) goto L50
            goto L52
        L50:
            r1 = 0
            goto L53
        L52:
            r1 = 1
        L53:
            if (r1 != 0) goto Lac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send EditingState to flutter: "
            r1.append(r2)
            io.flutter.plugin.editing.c r2 = r8.f631h
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TextInputPlugin"
            p031o.C0576b.m737f(r2, r1)
            z.q$b r1 = r8.f629f
            boolean r1 = r1.f1623e
            if (r1 == 0) goto L86
            z.q r1 = r8.f627d
            io.flutter.plugin.editing.f$d r2 = r8.f628e
            int r2 = r2.f646b
            r1.m26r(r2, r0)
            io.flutter.plugin.editing.c r0 = r8.f631h
            r0.m1503c()
            goto L99
        L86:
            z.q r0 = r8.f627d
            io.flutter.plugin.editing.f$d r1 = r8.f628e
            int r1 = r1.f646b
            io.flutter.plugin.editing.c r2 = r8.f631h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.m27q(r1, r2, r3, r4, r5, r6)
        L99:
            z.q$e r6 = new z.q$e
            io.flutter.plugin.editing.c r0 = r8.f631h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.f637n = r6
            goto Lb1
        Lac:
            io.flutter.plugin.editing.c r9 = r8.f631h
            r9.m1503c()
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.C0354f.mo1478a(boolean, boolean, boolean):void");
    }

    /* renamed from: j */
    public void m1469j(SparseArray<AutofillValue> sparseArray) {
        C0898q.C0900b c0900b;
        C0898q.C0900b.C0901a c0901a;
        C0898q.C0900b.C0901a c0901a2;
        if (Build.VERSION.SDK_INT < 26 || (c0900b = this.f629f) == null || this.f630g == null || (c0901a = c0900b.f1628j) == null) {
            return;
        }
        HashMap<String, C0898q.C0904e> hashMap = new HashMap<>();
        for (int i = 0; i < sparseArray.size(); i++) {
            C0898q.C0900b c0900b2 = this.f630g.get(sparseArray.keyAt(i));
            if (c0900b2 != null && (c0901a2 = c0900b2.f1628j) != null) {
                String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                C0898q.C0904e c0904e = new C0898q.C0904e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                if (c0901a2.f1631a.equals(c0901a.f1631a)) {
                    this.f631h.m1492n(c0904e);
                } else {
                    hashMap.put(c0901a2.f1631a, c0904e);
                }
            }
        }
        this.f627d.m25s(this.f628e.f646b, hashMap);
    }

    /* renamed from: l */
    public void m1467l(int i) {
        C0358d c0358d = this.f628e;
        C0358d.EnumC0359a enumC0359a = c0358d.f645a;
        if ((enumC0359a == C0358d.EnumC0359a.VIRTUAL_DISPLAY_PLATFORM_VIEW || enumC0359a == C0358d.EnumC0359a.PHYSICAL_DISPLAY_PLATFORM_VIEW) && c0358d.f646b == i) {
            this.f628e = new C0358d(C0358d.EnumC0359a.NO_TARGET, 0);
            m1454y();
            this.f625b.hideSoftInputFromWindow(this.f624a.getApplicationWindowToken(), 0);
            this.f625b.restartInput(this.f624a);
            this.f632i = false;
        }
    }

    /* renamed from: m */
    void m1466m() {
        if (this.f628e.f645a == C0358d.EnumC0359a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            return;
        }
        this.f631h.m1494l(this);
        m1454y();
        this.f629f = null;
        m1479I(null);
        this.f628e = new C0358d(C0358d.EnumC0359a.NO_TARGET, 0);
        m1480H();
        this.f635l = null;
    }

    /* renamed from: o */
    public InputConnection m1464o(View view, C0291r c0291r, EditorInfo editorInfo) {
        C0358d c0358d = this.f628e;
        C0358d.EnumC0359a enumC0359a = c0358d.f645a;
        if (enumC0359a == C0358d.EnumC0359a.NO_TARGET) {
            this.f633j = null;
            return null;
        } else if (enumC0359a == C0358d.EnumC0359a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        } else {
            if (enumC0359a == C0358d.EnumC0359a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
                if (this.f638o) {
                    return this.f633j;
                }
                InputConnection onCreateInputConnection = this.f634k.mo1352c(c0358d.f646b).onCreateInputConnection(editorInfo);
                this.f633j = onCreateInputConnection;
                return onCreateInputConnection;
            }
            C0898q.C0900b c0900b = this.f629f;
            int m1459t = m1459t(c0900b.f1625g, c0900b.f1619a, c0900b.f1620b, c0900b.f1621c, c0900b.f1622d, c0900b.f1624f);
            editorInfo.inputType = m1459t;
            editorInfo.imeOptions = 33554432;
            if (Build.VERSION.SDK_INT >= 26 && !this.f629f.f1622d) {
                editorInfo.imeOptions = 33554432 | 16777216;
            }
            Integer num = this.f629f.f1626h;
            int intValue = num == null ? (m1459t & 131072) != 0 ? 1 : 6 : num.intValue();
            C0898q.C0900b c0900b2 = this.f629f;
            String str = c0900b2.f1627i;
            if (str != null) {
                editorInfo.actionLabel = str;
                editorInfo.actionId = intValue;
            }
            editorInfo.imeOptions = intValue | editorInfo.imeOptions;
            String[] strArr = c0900b2.f1629k;
            if (strArr != null) {
                C0239a.m1832a(editorInfo, strArr);
            }
            C0347b c0347b = new C0347b(view, this.f628e.f646b, this.f627d, c0291r, this.f631h, editorInfo);
            editorInfo.initialSelStart = this.f631h.m1497i();
            editorInfo.initialSelEnd = this.f631h.m1498h();
            this.f633j = c0347b;
            return c0347b;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: p */
    public void m1463p() {
        this.f634k.m1366Q();
        this.f627d.m29o(null);
        m1454y();
        this.f631h.m1494l(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f636m;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* renamed from: q */
    public InputMethodManager m1462q() {
        return this.f625b;
    }

    /* renamed from: r */
    public boolean m1461r(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!m1462q().isAcceptingText() || (inputConnection = this.f633j) == null) {
            return false;
        }
        return inputConnection instanceof C0347b ? ((C0347b) inputConnection).m1509f(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    /* renamed from: u */
    public void m1458u() {
        if (this.f628e.f645a == C0358d.EnumC0359a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f638o = true;
        }
    }

    /* renamed from: z */
    public void m1453z() {
        this.f627d.m35i(this.f628e.f646b);
    }
}