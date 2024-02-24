package p053z;

import android.os.Bundle;
import androidx.window.C0082R;
import io.flutter.plugin.editing.C0353e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001a0.C0029g;
import p001a0.C0032j;
import p001a0.C0033k;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.q */
/* loaded from: classes.dex */
public class C0898q {

    /* renamed from: a */
    public final C0033k f1615a;

    /* renamed from: b */
    private InterfaceC0905f f1616b;

    /* renamed from: c */
    final C0033k.InterfaceC0037c f1617c;

    /* renamed from: z.q$a */
    /* loaded from: classes.dex */
    class C0899a implements C0033k.InterfaceC0037c {
        C0899a() {
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            String message;
            Bundle bundle;
            if (C0898q.this.f1616b == null) {
                return;
            }
            String str = c0032j.f38a;
            Object obj = c0032j.f39b;
            C0576b.m737f("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c = 1;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c = 3;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c = 4;
                        break;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            try {
                switch (c) {
                    case 0:
                        JSONObject jSONObject = (JSONObject) obj;
                        C0898q.this.f1616b.mo8g(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        interfaceC0038d.mo65b(null);
                        return;
                    case 1:
                        C0898q.this.f1616b.mo10e(C0904e.m17a((JSONObject) obj));
                        interfaceC0038d.mo65b(null);
                        return;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            C0898q.this.f1616b.mo9f(jSONArray.getInt(0), C0900b.m23a(jSONArray.getJSONObject(1)));
                            interfaceC0038d.mo65b(null);
                            return;
                        } catch (NoSuchFieldException | JSONException e) {
                            message = e.getMessage();
                            interfaceC0038d.mo66a("error", message, null);
                            return;
                        }
                    case 3:
                        C0898q.this.f1616b.mo5j();
                        break;
                    case 4:
                        C0898q.this.f1616b.mo11d();
                        break;
                    case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        C0898q.this.f1616b.mo14a(string, bundle);
                        interfaceC0038d.mo65b(null);
                        return;
                    case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d = jSONObject3.getDouble("width");
                        double d2 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i = 0; i < 16; i++) {
                            dArr[i] = jSONArray2.getDouble(i);
                        }
                        C0898q.this.f1616b.mo7h(d, d2, dArr);
                        interfaceC0038d.mo65b(null);
                        return;
                    case 7:
                        C0898q.this.f1616b.mo6i(((Boolean) obj).booleanValue());
                        break;
                    case '\b':
                        C0898q.this.f1616b.mo12c();
                        break;
                    case '\t':
                        C0898q.this.f1616b.mo13b();
                        break;
                    default:
                        interfaceC0038d.mo64c();
                        return;
                }
                interfaceC0038d.mo65b(null);
            } catch (JSONException e2) {
                message = e2.getMessage();
            }
        }
    }

    /* renamed from: z.q$b */
    /* loaded from: classes.dex */
    public static class C0900b {

        /* renamed from: a */
        public final boolean f1619a;

        /* renamed from: b */
        public final boolean f1620b;

        /* renamed from: c */
        public final boolean f1621c;

        /* renamed from: d */
        public final boolean f1622d;

        /* renamed from: e */
        public final boolean f1623e;

        /* renamed from: f */
        public final EnumC0903d f1624f;

        /* renamed from: g */
        public final C0902c f1625g;

        /* renamed from: h */
        public final Integer f1626h;

        /* renamed from: i */
        public final String f1627i;

        /* renamed from: j */
        public final C0901a f1628j;

        /* renamed from: k */
        public final String[] f1629k;

        /* renamed from: l */
        public final C0900b[] f1630l;

        /* renamed from: z.q$b$a */
        /* loaded from: classes.dex */
        public static class C0901a {

            /* renamed from: a */
            public final String f1631a;

            /* renamed from: b */
            public final String[] f1632b;

            /* renamed from: c */
            public final C0904e f1633c;

            /* renamed from: d */
            public final String f1634d;

            public C0901a(String str, String[] strArr, String str2, C0904e c0904e) {
                this.f1631a = str;
                this.f1632b = strArr;
                this.f1634d = str2;
                this.f1633c = c0904e;
            }

            /* renamed from: a */
            public static C0901a m21a(JSONObject jSONObject) {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = m20b(jSONArray.getString(i));
                }
                return new C0901a(string, strArr, string2, C0904e.m17a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00a3, code lost:
                if (r16.equals("familyName") == false) goto L7;
             */
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static java.lang.String m20b(java.lang.String r16) {
                /*
                    Method dump skipped, instructions count: 802
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: p053z.C0898q.C0900b.C0901a.m20b(java.lang.String):java.lang.String");
            }
        }

        public C0900b(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, EnumC0903d enumC0903d, C0902c c0902c, Integer num, String str, C0901a c0901a, String[] strArr, C0900b[] c0900bArr) {
            this.f1619a = z;
            this.f1620b = z2;
            this.f1621c = z3;
            this.f1622d = z4;
            this.f1623e = z5;
            this.f1624f = enumC0903d;
            this.f1625g = c0902c;
            this.f1626h = num;
            this.f1627i = str;
            this.f1628j = c0901a;
            this.f1629k = strArr;
            this.f1630l = c0900bArr;
        }

        /* renamed from: a */
        public static C0900b m23a(JSONObject jSONObject) {
            C0900b[] c0900bArr;
            String string = jSONObject.getString("inputAction");
            if (string != null) {
                if (jSONObject.isNull("fields")) {
                    c0900bArr = null;
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("fields");
                    int length = jSONArray.length();
                    C0900b[] c0900bArr2 = new C0900b[length];
                    for (int i = 0; i < length; i++) {
                        c0900bArr2[i] = m23a(jSONArray.getJSONObject(i));
                    }
                    c0900bArr = c0900bArr2;
                }
                Integer m22b = m22b(string);
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
                if (jSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        arrayList.add(jSONArray2.optString(i2));
                    }
                }
                return new C0900b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), EnumC0903d.m18a(jSONObject.getString("textCapitalization")), C0902c.m19a(jSONObject.getJSONObject("inputType")), m22b, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : C0901a.m21a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), c0900bArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
            if (r12.equals("TextInputAction.done") == false) goto L3;
         */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.lang.Integer m22b(java.lang.String r12) {
            /*
                r12.hashCode()
                int r0 = r12.hashCode()
                r1 = 7
                r2 = 6
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 0
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                r11 = -1
                switch(r0) {
                    case -810971940: goto L75;
                    case -737377923: goto L6c;
                    case -737089298: goto L61;
                    case -737080013: goto L56;
                    case -736940669: goto L4b;
                    case 469250275: goto L40;
                    case 1241689507: goto L35;
                    case 1539450297: goto L2a;
                    case 2110497650: goto L1e;
                    default: goto L1b;
                }
            L1b:
                r7 = -1
                goto L7f
            L1e:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L27
                goto L1b
            L27:
                r7 = 8
                goto L7f
            L2a:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L33
                goto L1b
            L33:
                r7 = 7
                goto L7f
            L35:
                java.lang.String r0 = "TextInputAction.go"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L3e
                goto L1b
            L3e:
                r7 = 6
                goto L7f
            L40:
                java.lang.String r0 = "TextInputAction.search"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L49
                goto L1b
            L49:
                r7 = 5
                goto L7f
            L4b:
                java.lang.String r0 = "TextInputAction.send"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L54
                goto L1b
            L54:
                r7 = 4
                goto L7f
            L56:
                java.lang.String r0 = "TextInputAction.none"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L5f
                goto L1b
            L5f:
                r7 = 3
                goto L7f
            L61:
                java.lang.String r0 = "TextInputAction.next"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L6a
                goto L1b
            L6a:
                r7 = 2
                goto L7f
            L6c:
                java.lang.String r0 = "TextInputAction.done"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7f
                goto L1b
            L75:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7e
                goto L1b
            L7e:
                r7 = 0
            L7f:
                switch(r7) {
                    case 0: goto La3;
                    case 1: goto L9e;
                    case 2: goto L99;
                    case 3: goto L98;
                    case 4: goto L93;
                    case 5: goto L8e;
                    case 6: goto L89;
                    case 7: goto L88;
                    case 8: goto L83;
                    default: goto L82;
                }
            L82:
                return r10
            L83:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L88:
                return r8
            L89:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
                return r12
            L8e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L93:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L98:
                return r8
            L99:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L9e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            La3:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: p053z.C0898q.C0900b.m22b(java.lang.String):java.lang.Integer");
        }
    }

    /* renamed from: z.q$c */
    /* loaded from: classes.dex */
    public static class C0902c {

        /* renamed from: a */
        public final EnumC0906g f1635a;

        /* renamed from: b */
        public final boolean f1636b;

        /* renamed from: c */
        public final boolean f1637c;

        public C0902c(EnumC0906g enumC0906g, boolean z, boolean z2) {
            this.f1635a = enumC0906g;
            this.f1636b = z;
            this.f1637c = z2;
        }

        /* renamed from: a */
        public static C0902c m19a(JSONObject jSONObject) {
            return new C0902c(EnumC0906g.m4a(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    /* renamed from: z.q$d */
    /* loaded from: classes.dex */
    public enum EnumC0903d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        

        /* renamed from: d */
        private final String f1643d;

        EnumC0903d(String str) {
            this.f1643d = str;
        }

        /* renamed from: a */
        static EnumC0903d m18a(String str) {
            EnumC0903d[] values;
            for (EnumC0903d enumC0903d : values()) {
                if (enumC0903d.f1643d.equals(str)) {
                    return enumC0903d;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    /* renamed from: z.q$e */
    /* loaded from: classes.dex */
    public static class C0904e {

        /* renamed from: a */
        public final String f1644a;

        /* renamed from: b */
        public final int f1645b;

        /* renamed from: c */
        public final int f1646c;

        /* renamed from: d */
        public final int f1647d;

        /* renamed from: e */
        public final int f1648e;

        public C0904e(String str, int i, int i2, int i3, int i4) {
            if (!(i == -1 && i2 == -1) && (i < 0 || i2 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i) + ", " + String.valueOf(i2) + ")");
            } else if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i3 > i4)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i3) + ", " + String.valueOf(i4) + ")");
            } else if (i4 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i3));
            } else if (i > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i));
            } else if (i2 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i2));
            } else {
                this.f1644a = str;
                this.f1645b = i;
                this.f1646c = i2;
                this.f1647d = i3;
                this.f1648e = i4;
            }
        }

        /* renamed from: a */
        public static C0904e m17a(JSONObject jSONObject) {
            return new C0904e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        /* renamed from: b */
        public boolean m16b() {
            int i = this.f1647d;
            return i >= 0 && this.f1648e > i;
        }

        /* renamed from: c */
        public boolean m15c() {
            return this.f1645b >= 0;
        }
    }

    /* renamed from: z.q$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0905f {
        /* renamed from: a */
        void mo14a(String str, Bundle bundle);

        /* renamed from: b */
        void mo13b();

        /* renamed from: c */
        void mo12c();

        /* renamed from: d */
        void mo11d();

        /* renamed from: e */
        void mo10e(C0904e c0904e);

        /* renamed from: f */
        void mo9f(int i, C0900b c0900b);

        /* renamed from: g */
        void mo8g(int i, boolean z);

        /* renamed from: h */
        void mo7h(double d, double d2, double[] dArr);

        /* renamed from: i */
        void mo6i(boolean z);

        /* renamed from: j */
        void mo5j();
    }

    /* renamed from: z.q$g */
    /* loaded from: classes.dex */
    public enum EnumC0906g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");
        

        /* renamed from: d */
        private final String f1661d;

        EnumC0906g(String str) {
            this.f1661d = str;
        }

        /* renamed from: a */
        static EnumC0906g m4a(String str) {
            EnumC0906g[] values;
            for (EnumC0906g enumC0906g : values()) {
                if (enumC0906g.f1661d.equals(str)) {
                    return enumC0906g;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public C0898q(C0579a c0579a) {
        C0899a c0899a = new C0899a();
        this.f1617c = c0899a;
        C0033k c0033k = new C0033k(c0579a, "flutter/textinput", C0029g.f37a);
        this.f1615a = c0033k;
        c0033k.m2269e(c0899a);
    }

    /* renamed from: c */
    private static HashMap<Object, Object> m41c(ArrayList<C0353e> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<C0353e> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m1488b());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    /* renamed from: d */
    private static HashMap<Object, Object> m40d(String str, int i, int i2, int i3, int i4) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i));
        hashMap.put("selectionExtent", Integer.valueOf(i2));
        hashMap.put("composingBase", Integer.valueOf(i3));
        hashMap.put("composingExtent", Integer.valueOf(i4));
        return hashMap;
    }

    /* renamed from: b */
    public void m42b(int i, Map<String, Object> map) {
        C0576b.m737f("TextInputChannel", "Sending 'commitContent' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.commitContent", map));
    }

    /* renamed from: e */
    public void m39e(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'done' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.done"));
    }

    /* renamed from: f */
    public void m38f(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'go' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.go"));
    }

    /* renamed from: g */
    public void m37g(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'newline' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.newline"));
    }

    /* renamed from: h */
    public void m36h(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'next' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.next"));
    }

    /* renamed from: i */
    public void m35i(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'onConnectionClosed' message.");
        this.f1615a.m2271c("TextInputClient.onConnectionClosed", Arrays.asList(Integer.valueOf(i), "TextInputClient.onConnectionClosed"));
    }

    /* renamed from: j */
    public void m34j(int i, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.f1615a.m2271c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i), hashMap));
    }

    /* renamed from: k */
    public void m33k(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'previous' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.previous"));
    }

    /* renamed from: l */
    public void m32l() {
        this.f1615a.m2271c("TextInputClient.requestExistingInputState", null);
    }

    /* renamed from: m */
    public void m31m(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'search' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.search"));
    }

    /* renamed from: n */
    public void m30n(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'send' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.send"));
    }

    /* renamed from: o */
    public void m29o(InterfaceC0905f interfaceC0905f) {
        this.f1616b = interfaceC0905f;
    }

    /* renamed from: p */
    public void m28p(int i) {
        C0576b.m737f("TextInputChannel", "Sending 'unspecified' message.");
        this.f1615a.m2271c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.unspecified"));
    }

    /* renamed from: q */
    public void m27q(int i, String str, int i2, int i3, int i4, int i5) {
        C0576b.m737f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i2 + "\nSelection end: " + i3 + "\nComposing start: " + i4 + "\nComposing end: " + i5);
        this.f1615a.m2271c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i), m40d(str, i2, i3, i4, i5)));
    }

    /* renamed from: r */
    public void m26r(int i, ArrayList<C0353e> arrayList) {
        C0576b.m737f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f1615a.m2271c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i), m41c(arrayList)));
    }

    /* renamed from: s */
    public void m25s(int i, HashMap<String, C0904e> hashMap) {
        C0576b.m737f("TextInputChannel", "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, C0904e> entry : hashMap.entrySet()) {
            C0904e value = entry.getValue();
            hashMap2.put(entry.getKey(), m40d(value.f1644a, value.f1645b, value.f1646c, -1, -1));
        }
        this.f1615a.m2271c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i), hashMap2));
    }
}