package kotlinx.coroutines.internal;

import java.util.List;
import p048w0.AbstractC0799y1;

/* loaded from: classes.dex */
public interface MainDispatcherFactory {
    AbstractC0799y1 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}