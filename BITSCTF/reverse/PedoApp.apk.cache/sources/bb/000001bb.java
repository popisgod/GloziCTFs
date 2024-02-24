package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class FlutterMutatorsStack {
    private List<C0330a> mutators = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<Path> finalClippingPaths = new ArrayList();

    /* renamed from: io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack$a */
    /* loaded from: classes.dex */
    public class C0330a {

        /* renamed from: a */
        private Matrix f518a;

        /* renamed from: b */
        private Rect f519b;

        /* renamed from: c */
        private float[] f520c;

        /* renamed from: d */
        private EnumC0331b f521d;

        public C0330a(Matrix matrix) {
            this.f521d = EnumC0331b.TRANSFORM;
            this.f518a = matrix;
        }

        public C0330a(Rect rect) {
            this.f521d = EnumC0331b.CLIP_RECT;
            this.f519b = rect;
        }

        public C0330a(Rect rect, float[] fArr) {
            this.f521d = EnumC0331b.CLIP_RRECT;
            this.f519b = rect;
            this.f520c = fArr;
        }

        /* renamed from: a */
        public Matrix m1558a() {
            return this.f518a;
        }
    }

    /* renamed from: io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack$b */
    /* loaded from: classes.dex */
    public enum EnumC0331b {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public List<C0330a> getMutators() {
        return this.mutators;
    }

    public void pushClipRRect(int i, int i2, int i3, int i4, float[] fArr) {
        Rect rect = new Rect(i, i2, i3, i4);
        this.mutators.add(new C0330a(rect, fArr));
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i, int i2, int i3, int i4) {
        Rect rect = new Rect(i, i2, i3, i4);
        this.mutators.add(new C0330a(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        C0330a c0330a = new C0330a(matrix);
        this.mutators.add(c0330a);
        this.finalMatrix.preConcat(c0330a.m1558a());
    }
}