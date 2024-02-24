package p053z;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p001a0.C0029g;
import p001a0.C0032j;
import p001a0.C0033k;
import p031o.C0576b;
import p033p.C0579a;

/* renamed from: z.g */
/* loaded from: classes.dex */
public class C0854g {

    /* renamed from: a */
    public final C0033k f1483a;

    /* renamed from: b */
    private InterfaceC0856b f1484b;

    /* renamed from: c */
    public final C0033k.InterfaceC0037c f1485c;

    /* renamed from: z.g$a */
    /* loaded from: classes.dex */
    class C0855a implements C0033k.InterfaceC0037c {
        C0855a() {
        }

        @Override // p001a0.C0033k.InterfaceC0037c
        /* renamed from: a */
        public void mo24a(C0032j c0032j, C0033k.InterfaceC0038d interfaceC0038d) {
            if (C0854g.this.f1484b == null) {
                return;
            }
            String str = c0032j.f38a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                interfaceC0038d.mo64c();
                return;
            }
            JSONObject jSONObject = (JSONObject) c0032j.m2274a();
            try {
                interfaceC0038d.mo65b(C0854g.this.f1484b.mo142a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e) {
                interfaceC0038d.mo66a("error", e.getMessage(), null);
            }
        }
    }

    /* renamed from: z.g$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0856b {
        /* renamed from: a */
        String mo142a(String str, String str2);
    }

    public C0854g(C0579a c0579a) {
        C0855a c0855a = new C0855a();
        this.f1485c = c0855a;
        C0033k c0033k = new C0033k(c0579a, "flutter/localization", C0029g.f37a);
        this.f1483a = c0033k;
        c0033k.m2269e(c0855a);
    }

    /* renamed from: b */
    public void m144b(List<Locale> list) {
        C0576b.m737f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            C0576b.m737f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.f1483a.m2271c("setLocale", arrayList);
    }

    /* renamed from: c */
    public void m143c(InterfaceC0856b interfaceC0856b) {
        this.f1484b = interfaceC0856b;
    }
}