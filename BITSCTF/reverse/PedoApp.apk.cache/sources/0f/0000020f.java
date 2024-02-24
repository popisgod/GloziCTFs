package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import androidx.annotation.Keep;

/* loaded from: classes.dex */
public interface TextureRegistry {

    @Keep
    /* loaded from: classes.dex */
    public interface ImageTextureEntry {
        Image acquireLatestImage();

        /* renamed from: id */
        long mo1266id();

        void pushImage(Image image);

        void release();
    }

    /* renamed from: io.flutter.view.TextureRegistry$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0403a {
        /* renamed from: a */
        void mo1265a();
    }

    /* renamed from: io.flutter.view.TextureRegistry$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0404b {
        void onTrimMemory(int i);
    }

    /* renamed from: io.flutter.view.TextureRegistry$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0405c {
        /* renamed from: a */
        void mo1264a(InterfaceC0404b interfaceC0404b);

        /* renamed from: b */
        void mo1263b(InterfaceC0403a interfaceC0403a);

        /* renamed from: c */
        SurfaceTexture mo1262c();

        /* renamed from: id */
        long mo1261id();
    }

    /* renamed from: a */
    ImageTextureEntry mo1268a();

    /* renamed from: b */
    InterfaceC0405c mo1267b();
}