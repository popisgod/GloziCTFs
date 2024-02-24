package p019i;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;

/* renamed from: i.a */
/* loaded from: classes.dex */
public final class C0239a {

    /* renamed from: a */
    private static final String[] f292a = new String[0];

    /* renamed from: a */
    public static void m1832a(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }
}