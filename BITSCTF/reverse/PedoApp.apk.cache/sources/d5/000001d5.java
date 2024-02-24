package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;
import p031o.C0576b;
import p053z.C0898q;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: io.flutter.plugin.editing.c */
/* loaded from: classes.dex */
public class C0349c extends SpannableStringBuilder {

    /* renamed from: d */
    private int f598d = 0;

    /* renamed from: e */
    private int f599e = 0;

    /* renamed from: f */
    private ArrayList<InterfaceC0351b> f600f = new ArrayList<>();

    /* renamed from: g */
    private ArrayList<InterfaceC0351b> f601g = new ArrayList<>();

    /* renamed from: h */
    private ArrayList<C0353e> f602h = new ArrayList<>();

    /* renamed from: i */
    private String f603i;

    /* renamed from: j */
    private String f604j;

    /* renamed from: k */
    private int f605k;

    /* renamed from: l */
    private int f606l;

    /* renamed from: m */
    private int f607m;

    /* renamed from: n */
    private int f608n;

    /* renamed from: o */
    private BaseInputConnection f609o;

    /* renamed from: io.flutter.plugin.editing.c$a */
    /* loaded from: classes.dex */
    class C0350a extends BaseInputConnection {

        /* renamed from: a */
        final /* synthetic */ Editable f610a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0350a(View view, boolean z, Editable editable) {
            super(view, z);
            this.f610a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f610a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.editing.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0351b {
        /* renamed from: a */
        void mo1478a(boolean z, boolean z2, boolean z3);
    }

    public C0349c(C0898q.C0904e c0904e, View view) {
        this.f609o = new C0350a(view, true, this);
        if (c0904e != null) {
            m1492n(c0904e);
        }
    }

    /* renamed from: j */
    private void m1496j(InterfaceC0351b interfaceC0351b, boolean z, boolean z2, boolean z3) {
        this.f599e++;
        interfaceC0351b.mo1478a(z, z2, z3);
        this.f599e--;
    }

    /* renamed from: k */
    private void m1495k(boolean z, boolean z2, boolean z3) {
        if (z || z2 || z3) {
            Iterator<InterfaceC0351b> it = this.f600f.iterator();
            while (it.hasNext()) {
                m1496j(it.next(), z, z2, z3);
            }
        }
    }

    /* renamed from: a */
    public void m1505a(InterfaceC0351b interfaceC0351b) {
        ArrayList<InterfaceC0351b> arrayList;
        if (this.f599e > 0) {
            C0576b.m741b("ListenableEditingState", "adding a listener " + interfaceC0351b.toString() + " in a listener callback");
        }
        if (this.f598d > 0) {
            C0576b.m736g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.f601g;
        } else {
            arrayList = this.f600f;
        }
        arrayList.add(interfaceC0351b);
    }

    /* renamed from: b */
    public void m1504b() {
        this.f598d++;
        if (this.f599e > 0) {
            C0576b.m741b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f598d != 1 || this.f600f.isEmpty()) {
            return;
        }
        this.f604j = toString();
        this.f605k = m1497i();
        this.f606l = m1498h();
        this.f607m = m1499g();
        this.f608n = m1500f();
    }

    /* renamed from: c */
    public void m1503c() {
        this.f602h.clear();
    }

    /* renamed from: d */
    public void m1502d() {
        int i = this.f598d;
        if (i == 0) {
            C0576b.m741b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i == 1) {
            Iterator<InterfaceC0351b> it = this.f601g.iterator();
            while (it.hasNext()) {
                m1496j(it.next(), true, true, true);
            }
            if (!this.f600f.isEmpty()) {
                C0576b.m737f("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.f600f.size()) + " listener(s)");
                boolean z = false;
                m1495k(!toString().equals(this.f604j), (this.f605k == m1497i() && this.f606l == m1498h()) ? false : true, (this.f607m == m1499g() && this.f608n == m1500f()) ? true : true);
            }
        }
        this.f600f.addAll(this.f601g);
        this.f601g.clear();
        this.f598d--;
    }

    /* renamed from: e */
    public ArrayList<C0353e> m1501e() {
        ArrayList<C0353e> arrayList = new ArrayList<>(this.f602h);
        this.f602h.clear();
        return arrayList;
    }

    /* renamed from: f */
    public final int m1500f() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    /* renamed from: g */
    public final int m1499g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    /* renamed from: h */
    public final int m1498h() {
        return Selection.getSelectionEnd(this);
    }

    /* renamed from: i */
    public final int m1497i() {
        return Selection.getSelectionStart(this);
    }

    /* renamed from: l */
    public void m1494l(InterfaceC0351b interfaceC0351b) {
        if (this.f599e > 0) {
            C0576b.m741b("ListenableEditingState", "removing a listener " + interfaceC0351b.toString() + " in a listener callback");
        }
        this.f600f.remove(interfaceC0351b);
        if (this.f598d > 0) {
            this.f601g.remove(interfaceC0351b);
        }
    }

    /* renamed from: m */
    public void m1493m(int i, int i2) {
        if (i < 0 || i >= i2) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f609o.setComposingRegion(i, i2);
        }
    }

    /* renamed from: n */
    public void m1492n(C0898q.C0904e c0904e) {
        m1504b();
        replace(0, length(), (CharSequence) c0904e.f1644a);
        if (c0904e.m15c()) {
            Selection.setSelection(this, c0904e.f1645b, c0904e.f1646c);
        } else {
            Selection.removeSelection(this);
        }
        m1493m(c0904e.f1647d, c0904e.f1648e);
        m1503c();
        m1502d();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        boolean z;
        boolean z2;
        if (this.f599e > 0) {
            C0576b.m741b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String c0349c = toString();
        int i5 = i2 - i;
        boolean z3 = i5 != i4 - i3;
        for (int i6 = 0; i6 < i5 && !z3; i6++) {
            z3 |= charAt(i + i6) != charSequence.charAt(i3 + i6);
        }
        if (z3) {
            this.f603i = null;
        }
        int m1497i = m1497i();
        int m1498h = m1498h();
        int m1499g = m1499g();
        int m1500f = m1500f();
        SpannableStringBuilder replace = super.replace(i, i2, charSequence, i3, i4);
        boolean z4 = z3;
        this.f602h.add(new C0353e(c0349c, i, i2, charSequence, m1497i(), m1498h(), m1499g(), m1500f()));
        if (this.f598d > 0) {
            return replace;
        }
        boolean z5 = (m1497i() == m1497i && m1498h() == m1498h) ? false : true;
        if (m1499g() == m1499g && m1500f() == m1500f) {
            z = z4;
            z2 = false;
        } else {
            z = z4;
            z2 = true;
        }
        m1495k(z, z5, z2);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        super.setSpan(obj, i, i2, i3);
        this.f602h.add(new C0353e(toString(), m1497i(), m1498h(), m1499g(), m1500f()));
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.f603i;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f603i = spannableStringBuilder;
        return spannableStringBuilder;
    }
}