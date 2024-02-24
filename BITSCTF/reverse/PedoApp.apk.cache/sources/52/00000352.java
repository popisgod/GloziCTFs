package p048w0;

import java.util.concurrent.CancellationException;

/* renamed from: w0.e1 */
/* loaded from: classes.dex */
public final class C0719e1 {
    /* renamed from: a */
    public static final CancellationException m472a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}