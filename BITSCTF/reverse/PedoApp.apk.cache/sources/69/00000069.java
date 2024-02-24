package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import p004b.C0099a;

/* renamed from: androidx.versionedparcelable.b */
/* loaded from: classes.dex */
class C0081b extends AbstractC0080a {

    /* renamed from: d */
    private final SparseIntArray f129d;

    /* renamed from: e */
    private final Parcel f130e;

    /* renamed from: f */
    private final int f131f;

    /* renamed from: g */
    private final int f132g;

    /* renamed from: h */
    private final String f133h;

    /* renamed from: i */
    private int f134i;

    /* renamed from: j */
    private int f135j;

    /* renamed from: k */
    private int f136k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0081b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0099a(), new C0099a(), new C0099a());
    }

    private C0081b(Parcel parcel, int i, int i2, String str, C0099a<String, Method> c0099a, C0099a<String, Method> c0099a2, C0099a<String, Class> c0099a3) {
        super(c0099a, c0099a2, c0099a3);
        this.f129d = new SparseIntArray();
        this.f134i = -1;
        this.f135j = 0;
        this.f136k = -1;
        this.f130e = parcel;
        this.f131f = i;
        this.f132g = i2;
        this.f135j = i;
        this.f133h = str;
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: A */
    public void mo2165A(byte[] bArr) {
        if (bArr == null) {
            this.f130e.writeInt(-1);
            return;
        }
        this.f130e.writeInt(bArr.length);
        this.f130e.writeByteArray(bArr);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: C */
    protected void mo2164C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f130e, 0);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: E */
    public void mo2163E(int i) {
        this.f130e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: G */
    public void mo2162G(Parcelable parcelable) {
        this.f130e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: I */
    public void mo2161I(String str) {
        this.f130e.writeString(str);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: a */
    public void mo2160a() {
        int i = this.f134i;
        if (i >= 0) {
            int i2 = this.f129d.get(i);
            int dataPosition = this.f130e.dataPosition();
            this.f130e.setDataPosition(i2);
            this.f130e.writeInt(dataPosition - i2);
            this.f130e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: b */
    protected AbstractC0080a mo2159b() {
        Parcel parcel = this.f130e;
        int dataPosition = parcel.dataPosition();
        int i = this.f135j;
        if (i == this.f131f) {
            i = this.f132g;
        }
        int i2 = i;
        return new C0081b(parcel, dataPosition, i2, this.f133h + "  ", this.f126a, this.f127b, this.f128c);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: g */
    public boolean mo2158g() {
        return this.f130e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: i */
    public byte[] mo2157i() {
        int readInt = this.f130e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f130e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: k */
    protected CharSequence mo2156k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f130e);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: m */
    public boolean mo2155m(int i) {
        while (this.f135j < this.f132g) {
            int i2 = this.f136k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f130e.setDataPosition(this.f135j);
            int readInt = this.f130e.readInt();
            this.f136k = this.f130e.readInt();
            this.f135j += readInt;
        }
        return this.f136k == i;
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: o */
    public int mo2154o() {
        return this.f130e.readInt();
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: q */
    public <T extends Parcelable> T mo2153q() {
        return (T) this.f130e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: s */
    public String mo2152s() {
        return this.f130e.readString();
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: w */
    public void mo2151w(int i) {
        mo2160a();
        this.f134i = i;
        this.f129d.put(i, this.f130e.dataPosition());
        mo2163E(0);
        mo2163E(i);
    }

    @Override // androidx.versionedparcelable.AbstractC0080a
    /* renamed from: y */
    public void mo2150y(boolean z) {
        this.f130e.writeInt(z ? 1 : 0);
    }
}