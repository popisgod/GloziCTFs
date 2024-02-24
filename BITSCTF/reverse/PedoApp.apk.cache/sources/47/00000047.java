package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.AbstractC0080a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0080a abstractC0080a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f78a = (IconCompat) abstractC0080a.m2168v(remoteActionCompat.f78a, 1);
        remoteActionCompat.f79b = abstractC0080a.m2174l(remoteActionCompat.f79b, 2);
        remoteActionCompat.f80c = abstractC0080a.m2174l(remoteActionCompat.f80c, 3);
        remoteActionCompat.f81d = (PendingIntent) abstractC0080a.m2171r(remoteActionCompat.f81d, 4);
        remoteActionCompat.f82e = abstractC0080a.m2176h(remoteActionCompat.f82e, 5);
        remoteActionCompat.f83f = abstractC0080a.m2176h(remoteActionCompat.f83f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0080a abstractC0080a) {
        abstractC0080a.m2167x(false, false);
        abstractC0080a.m2182M(remoteActionCompat.f78a, 1);
        abstractC0080a.m2188D(remoteActionCompat.f79b, 2);
        abstractC0080a.m2188D(remoteActionCompat.f80c, 3);
        abstractC0080a.m2186H(remoteActionCompat.f81d, 4);
        abstractC0080a.m2166z(remoteActionCompat.f82e, 5);
        abstractC0080a.m2166z(remoteActionCompat.f83f, 6);
    }
}