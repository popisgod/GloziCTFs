package p010d0;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: d0.a */
/* loaded from: classes.dex */
public class C0124a {

    /* renamed from: d0.a$a */
    /* loaded from: classes.dex */
    public static class C0125a extends RuntimeException {

        /* renamed from: d */
        public final String f195d;

        /* renamed from: e */
        public final Object f196e;
    }

    /* renamed from: d0.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0126b {
        /* renamed from: a */
        List<String> mo2061a(EnumC0127c enumC0127c);

        /* renamed from: b */
        String mo2060b();

        /* renamed from: c */
        String mo2059c();

        /* renamed from: d */
        String mo2058d();

        /* renamed from: e */
        String mo2057e();

        /* renamed from: f */
        String mo2056f();

        /* renamed from: h */
        List<String> mo2055h();
    }

    /* renamed from: d0.a$c */
    /* loaded from: classes.dex */
    public enum EnumC0127c {
        ROOT(0),
        MUSIC(1),
        PODCASTS(2),
        RINGTONES(3),
        ALARMS(4),
        NOTIFICATIONS(5),
        PICTURES(6),
        MOVIES(7),
        DOWNLOADS(8),
        DCIM(9),
        DOCUMENTS(10);
        

        /* renamed from: d */
        final int f209d;

        EnumC0127c(int i) {
            this.f209d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static ArrayList<Object> m2078a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof C0125a) {
            C0125a c0125a = (C0125a) th;
            arrayList.add(c0125a.f195d);
            arrayList.add(c0125a.getMessage());
            obj = c0125a.f196e;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}