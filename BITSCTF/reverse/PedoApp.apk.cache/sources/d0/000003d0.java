package p053z;

import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p001a0.C0008a;
import p001a0.C0028f;
import p001a0.InterfaceC0016c;
import p031o.C0576b;
import p053z.C0845d;

/* renamed from: z.d */
/* loaded from: classes.dex */
public class C0845d {

    /* renamed from: a */
    public final C0008a<Object> f1464a;

    /* renamed from: z.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0846a {
        /* renamed from: a */
        void mo156a(boolean z);
    }

    /* renamed from: z.d$b */
    /* loaded from: classes.dex */
    public static class C0847b {

        /* renamed from: a */
        public final KeyEvent f1465a;

        /* renamed from: b */
        public final Character f1466b;

        public C0847b(KeyEvent keyEvent, Character ch) {
            this.f1465a = keyEvent;
            this.f1466b = ch;
        }
    }

    public C0845d(InterfaceC0016c interfaceC0016c) {
        this.f1464a = new C0008a<>(interfaceC0016c, "flutter/keyevent", C0028f.f36a);
    }

    /* renamed from: a */
    public static /* synthetic */ void m161a(InterfaceC0846a interfaceC0846a, Object obj) {
        m158d(interfaceC0846a, obj);
    }

    /* renamed from: b */
    private static C0008a.InterfaceC0014e<Object> m160b(final InterfaceC0846a interfaceC0846a) {
        return new C0008a.InterfaceC0014e() { // from class: z.c
            @Override // p001a0.C0008a.InterfaceC0014e
            /* renamed from: a */
            public final void mo56a(Object obj) {
                C0845d.m161a(C0845d.InterfaceC0846a.this, obj);
            }
        };
    }

    /* renamed from: c */
    private Map<String, Object> m159c(C0847b c0847b, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", z ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(c0847b.f1465a.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(c0847b.f1465a.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(c0847b.f1465a.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(c0847b.f1465a.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(c0847b.f1465a.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(c0847b.f1465a.getMetaState()));
        Character ch = c0847b.f1466b;
        if (ch != null) {
            hashMap.put("character", ch.toString());
        }
        hashMap.put("source", Integer.valueOf(c0847b.f1465a.getSource()));
        hashMap.put("deviceId", Integer.valueOf(c0847b.f1465a.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(c0847b.f1465a.getRepeatCount()));
        return hashMap;
    }

    /* renamed from: d */
    public static /* synthetic */ void m158d(InterfaceC0846a interfaceC0846a, Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e) {
                C0576b.m741b("KeyEventChannel", "Unable to unpack JSON message: " + e);
            }
        }
        interfaceC0846a.mo156a(z);
    }

    /* renamed from: e */
    public void m157e(C0847b c0847b, boolean z, InterfaceC0846a interfaceC0846a) {
        this.f1464a.m2289d(m159c(c0847b, z), m160b(interfaceC0846a));
    }
}