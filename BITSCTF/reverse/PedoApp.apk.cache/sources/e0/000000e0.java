package p008c0;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import java.util.HashMap;
import p053z.C0857h;

@TargetApi(24)
/* renamed from: c0.a */
/* loaded from: classes.dex */
public class C0114a {

    /* renamed from: c */
    private static HashMap<String, Integer> f181c;

    /* renamed from: a */
    private final InterfaceC0117c f182a;

    /* renamed from: b */
    private final C0857h f183b;

    /* renamed from: c0.a$a */
    /* loaded from: classes.dex */
    class C0115a implements C0857h.InterfaceC0859b {
        C0115a() {
        }

        @Override // p053z.C0857h.InterfaceC0859b
        /* renamed from: a */
        public void mo139a(String str) {
            C0114a.this.f182a.setPointerIcon(C0114a.this.m2086d(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c0.a$b */
    /* loaded from: classes.dex */
    public class C0116b extends HashMap<String, Integer> {
        C0116b() {
            put("alias", 1010);
            put("allScroll", 1013);
            put("basic", 1000);
            put("cell", 1006);
            put("click", 1002);
            put("contextMenu", 1001);
            put("copy", 1011);
            put("forbidden", 1012);
            put("grab", 1020);
            put("grabbing", 1021);
            put("help", 1003);
            put("move", 1013);
            put("none", 0);
            put("noDrop", 1012);
            put("precise", 1007);
            put("text", 1008);
            put("resizeColumn", 1014);
            put("resizeDown", 1015);
            put("resizeUpLeft", 1016);
            put("resizeDownRight", 1017);
            put("resizeLeft", 1014);
            put("resizeLeftRight", 1014);
            put("resizeRight", 1014);
            put("resizeRow", 1015);
            put("resizeUp", 1015);
            put("resizeUpDown", 1015);
            put("resizeUpLeft", 1017);
            put("resizeUpRight", 1016);
            put("resizeUpLeftDownRight", 1017);
            put("resizeUpRightDownLeft", 1016);
            put("verticalText", 1009);
            put("wait", 1004);
            put("zoomIn", 1018);
            put("zoomOut", 1019);
        }
    }

    /* renamed from: c0.a$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0117c {
        /* renamed from: b */
        PointerIcon mo1697b(int i);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public C0114a(InterfaceC0117c interfaceC0117c, C0857h c0857h) {
        this.f182a = interfaceC0117c;
        this.f183b = c0857h;
        c0857h.m140b(new C0115a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public PointerIcon m2086d(String str) {
        if (f181c == null) {
            f181c = new C0116b();
        }
        return this.f182a.mo1697b(f181c.getOrDefault(str, 1000).intValue());
    }

    /* renamed from: c */
    public void m2087c() {
        this.f183b.m140b(null);
    }
}