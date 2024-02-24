package p001a0;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: a0.g */
/* loaded from: classes.dex */
public final class C0029g implements InterfaceC0039l {

    /* renamed from: a */
    public static final C0029g f37a = new C0029g();

    private C0029g() {
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: a */
    public ByteBuffer mo2249a(String str, String str2, Object obj, String str3) {
        return C0028f.f36a.mo2242b(new JSONArray().put(str).put(C0030h.m2275a(str2)).put(C0030h.m2275a(obj)).put(C0030h.m2275a(str3)));
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: b */
    public ByteBuffer mo2248b(C0032j c0032j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", c0032j.f38a);
            jSONObject.put("args", C0030h.m2275a(c0032j.f39b));
            return C0028f.f36a.mo2242b(jSONObject);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: c */
    public ByteBuffer mo2247c(String str, String str2, Object obj) {
        return C0028f.f36a.mo2242b(new JSONArray().put(str).put(C0030h.m2275a(str2)).put(C0030h.m2275a(obj)));
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: d */
    public ByteBuffer mo2246d(Object obj) {
        return C0028f.f36a.mo2242b(new JSONArray().put(C0030h.m2275a(obj)));
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: e */
    public C0032j mo2245e(ByteBuffer byteBuffer) {
        try {
            Object mo2243a = C0028f.f36a.mo2243a(byteBuffer);
            if (mo2243a instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) mo2243a;
                Object obj = jSONObject.get("method");
                Object m2276g = m2276g(jSONObject.opt("args"));
                if (obj instanceof String) {
                    return new C0032j((String) obj, m2276g);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + mo2243a);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // p001a0.InterfaceC0039l
    /* renamed from: f */
    public Object mo2244f(ByteBuffer byteBuffer) {
        try {
            Object mo2243a = C0028f.f36a.mo2243a(byteBuffer);
            if (mo2243a instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) mo2243a;
                if (jSONArray.length() == 1) {
                    return m2276g(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object m2276g = m2276g(jSONArray.opt(1));
                    Object m2276g2 = m2276g(jSONArray.opt(2));
                    if ((obj instanceof String) && (m2276g == null || (m2276g instanceof String))) {
                        throw new C0027e((String) obj, (String) m2276g, m2276g2);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + mo2243a);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    /* renamed from: g */
    Object m2276g(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}