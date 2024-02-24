package p001a0;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: a0.t */
/* loaded from: classes.dex */
public final class C0048t implements InterfaceC0031i<String> {

    /* renamed from: a */
    private static final Charset f55a = Charset.forName("UTF8");

    /* renamed from: b */
    public static final C0048t f56b = new C0048t();

    private C0048t() {
    }

    @Override // p001a0.InterfaceC0031i
    /* renamed from: c */
    public String mo2243a(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i = 0;
        }
        return new String(bArr, i, remaining, f55a);
    }

    @Override // p001a0.InterfaceC0031i
    /* renamed from: d */
    public ByteBuffer mo2242b(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f55a);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}