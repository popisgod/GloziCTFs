package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;
import p031o.C0576b;

/* renamed from: io.flutter.plugin.editing.e */
/* loaded from: classes.dex */
public final class C0353e {

    /* renamed from: a */
    private CharSequence f616a;

    /* renamed from: b */
    private CharSequence f617b;

    /* renamed from: c */
    private int f618c;

    /* renamed from: d */
    private int f619d;

    /* renamed from: e */
    private int f620e;

    /* renamed from: f */
    private int f621f;

    /* renamed from: g */
    private int f622g;

    /* renamed from: h */
    private int f623h;

    public C0353e(CharSequence charSequence, int i, int i2, int i3, int i4) {
        this.f620e = i;
        this.f621f = i2;
        this.f622g = i3;
        this.f623h = i4;
        m1489a(charSequence, "", -1, -1);
    }

    public C0353e(CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, int i4, int i5, int i6) {
        this.f620e = i3;
        this.f621f = i4;
        this.f622g = i5;
        this.f623h = i6;
        m1489a(charSequence, charSequence2.toString(), i, i2);
    }

    /* renamed from: a */
    private void m1489a(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        this.f616a = charSequence;
        this.f617b = charSequence2;
        this.f618c = i;
        this.f619d = i2;
    }

    /* renamed from: b */
    public JSONObject m1488b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f616a.toString());
            jSONObject.put("deltaText", this.f617b.toString());
            jSONObject.put("deltaStart", this.f618c);
            jSONObject.put("deltaEnd", this.f619d);
            jSONObject.put("selectionBase", this.f620e);
            jSONObject.put("selectionExtent", this.f621f);
            jSONObject.put("composingBase", this.f622g);
            jSONObject.put("composingExtent", this.f623h);
        } catch (JSONException e) {
            C0576b.m741b("TextEditingDelta", "unable to create JSONObject: " + e);
        }
        return jSONObject;
    }
}