package p001a0;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: a0.f */
/* loaded from: classes.dex */
public final class C0028f implements InterfaceC0031i<Object> {

    /* renamed from: a */
    public static final C0028f f36a = new C0028f();

    private C0028f() {
    }

    @Override // p001a0.InterfaceC0031i
    /* renamed from: a */
    public Object mo2243a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(C0048t.f56b.mo2243a(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // p001a0.InterfaceC0031i
    /* renamed from: b */
    public ByteBuffer mo2242b(Object obj) {
        C0048t c0048t;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object m2275a = C0030h.m2275a(obj);
        if (m2275a instanceof String) {
            c0048t = C0048t.f56b;
            obj2 = JSONObject.quote((String) m2275a);
        } else {
            c0048t = C0048t.f56b;
            obj2 = m2275a.toString();
        }
        return c0048t.mo2242b(obj2);
    }
}