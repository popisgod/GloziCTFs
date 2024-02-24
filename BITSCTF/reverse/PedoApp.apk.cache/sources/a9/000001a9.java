package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class FlutterOverlaySurface {

    /* renamed from: id */
    private final int f455id;
    private final Surface surface;

    public FlutterOverlaySurface(int i, Surface surface) {
        this.f455id = i;
        this.surface = surface;
    }

    public int getId() {
        return this.f455id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}