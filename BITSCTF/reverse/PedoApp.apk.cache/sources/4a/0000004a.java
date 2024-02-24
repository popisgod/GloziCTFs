package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import androidx.window.C0082R;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k */
    static final PorterDuff.Mode f86k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    Object f88b;

    /* renamed from: j */
    public String f96j;

    /* renamed from: a */
    public int f87a = -1;

    /* renamed from: c */
    public byte[] f89c = null;

    /* renamed from: d */
    public Parcelable f90d = null;

    /* renamed from: e */
    public int f91e = 0;

    /* renamed from: f */
    public int f92f = 0;

    /* renamed from: g */
    public ColorStateList f93g = null;

    /* renamed from: h */
    PorterDuff.Mode f94h = f86k;

    /* renamed from: i */
    public String f95i = null;

    /* renamed from: b */
    private static int m2222b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    /* renamed from: e */
    private static String m2219e(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                return "BITMAP_MASKABLE";
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: a */
    public int m2223a() {
        int i = this.f87a;
        if (i != -1 || Build.VERSION.SDK_INT < 23) {
            if (i == 2) {
                return this.f91e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return m2222b((Icon) this.f88b);
    }

    /* renamed from: c */
    public void m2221c() {
        Parcelable parcelable;
        this.f94h = PorterDuff.Mode.valueOf(this.f95i);
        switch (this.f87a) {
            case -1:
                parcelable = this.f90d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                parcelable = this.f90d;
                if (parcelable == null) {
                    byte[] bArr = this.f89c;
                    this.f88b = bArr;
                    this.f87a = 3;
                    this.f91e = 0;
                    this.f92f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                String str = new String(this.f89c, Charset.forName("UTF-16"));
                this.f88b = str;
                if (this.f87a == 2 && this.f96j == null) {
                    this.f96j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f88b = this.f89c;
                return;
        }
        this.f88b = parcelable;
    }

    /* renamed from: d */
    public void m2220d(boolean z) {
        this.f95i = this.f94h.name();
        switch (this.f87a) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f88b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f89c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f89c = ((String) this.f88b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f89c = (byte[]) this.f88b;
                return;
            case 4:
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                this.f89c = this.f88b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f90d = (Parcelable) this.f88b;
    }

    public String toString() {
        int height;
        if (this.f87a == -1) {
            return String.valueOf(this.f88b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m2219e(this.f87a));
        switch (this.f87a) {
            case 1:
            case C0082R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                sb.append(" size=");
                sb.append(((Bitmap) this.f88b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f88b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f96j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m2223a())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f91e);
                if (this.f92f != 0) {
                    sb.append(" off=");
                    height = this.f92f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case C0082R.styleable.SplitPairRule_splitRatio /* 6 */:
                sb.append(" uri=");
                sb.append(this.f88b);
                break;
        }
        if (this.f93g != null) {
            sb.append(" tint=");
            sb.append(this.f93g);
        }
        if (this.f94h != f86k) {
            sb.append(" mode=");
            sb.append(this.f94h);
        }
        sb.append(")");
        return sb.toString();
    }
}