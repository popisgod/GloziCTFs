package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC0066c;

@Keep
/* loaded from: classes.dex */
public class HiddenLifecycleReference {
    private final AbstractC0066c lifecycle;

    public HiddenLifecycleReference(AbstractC0066c abstractC0066c) {
        this.lifecycle = abstractC0066c;
    }

    public AbstractC0066c getLifecycle() {
        return this.lifecycle;
    }
}