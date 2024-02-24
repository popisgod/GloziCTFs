package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: io.flutter.embedding.android.m */
/* loaded from: classes.dex */
public class C0284m {

    /* renamed from: a */
    long f397a;

    /* renamed from: b */
    EnumC0285a f398b;

    /* renamed from: c */
    long f399c;

    /* renamed from: d */
    long f400d;

    /* renamed from: e */
    boolean f401e;

    /* renamed from: f */
    String f402f;

    /* renamed from: io.flutter.embedding.android.m$a */
    /* loaded from: classes.dex */
    public enum EnumC0285a {
        kDown(0),
        kUp(1),
        kRepeat(2);
        

        /* renamed from: d */
        private long f407d;

        EnumC0285a(long j) {
            this.f407d = j;
        }

        /* renamed from: a */
        public long m1667a() {
            return this.f407d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public ByteBuffer m1668a() {
        try {
            String str = this.f402f;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 48);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(this.f397a);
            allocateDirect.putLong(this.f398b.m1667a());
            allocateDirect.putLong(this.f399c);
            allocateDirect.putLong(this.f400d);
            allocateDirect.putLong(this.f401e ? 1L : 0L);
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}