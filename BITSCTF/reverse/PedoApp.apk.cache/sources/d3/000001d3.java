package io.flutter.plugin.editing;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.editing.C0349c;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import p031o.C0576b;
import p053z.C0898q;

/* renamed from: io.flutter.plugin.editing.b */
/* loaded from: classes.dex */
public class C0347b extends BaseInputConnection implements C0349c.InterfaceC0351b {

    /* renamed from: a */
    private final View f584a;

    /* renamed from: b */
    private final int f585b;

    /* renamed from: c */
    private final C0898q f586c;

    /* renamed from: d */
    private final C0349c f587d;

    /* renamed from: e */
    private final EditorInfo f588e;

    /* renamed from: f */
    private ExtractedTextRequest f589f;

    /* renamed from: g */
    private boolean f590g;

    /* renamed from: h */
    private CursorAnchorInfo.Builder f591h;

    /* renamed from: i */
    private ExtractedText f592i;

    /* renamed from: j */
    private InputMethodManager f593j;

    /* renamed from: k */
    private final Layout f594k;

    /* renamed from: l */
    private C0346a f595l;

    /* renamed from: m */
    private final InterfaceC0348a f596m;

    /* renamed from: n */
    private int f597n;

    /* renamed from: io.flutter.plugin.editing.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0348a {
        /* renamed from: a */
        boolean mo1506a(KeyEvent keyEvent);
    }

    public C0347b(View view, int i, C0898q c0898q, InterfaceC0348a interfaceC0348a, C0349c c0349c, EditorInfo editorInfo) {
        this(view, i, c0898q, interfaceC0348a, c0349c, editorInfo, new FlutterJNI());
    }

    public C0347b(View view, int i, C0898q c0898q, InterfaceC0348a interfaceC0348a, C0349c c0349c, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f590g = false;
        this.f592i = new ExtractedText();
        this.f597n = 0;
        this.f584a = view;
        this.f585b = i;
        this.f586c = c0898q;
        this.f587d = c0349c;
        c0349c.m1505a(this);
        this.f588e = editorInfo;
        this.f596m = interfaceC0348a;
        this.f595l = new C0346a(flutterJNI);
        this.f594k = new DynamicLayout(c0349c, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f593j = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    /* renamed from: b */
    private boolean m1513b(int i) {
        if (i == 16908319) {
            setSelection(0, this.f587d.length());
            return true;
        } else if (i == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f587d);
            int selectionEnd = Selection.getSelectionEnd(this.f587d);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f584a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f587d.subSequence(min, max)));
                this.f587d.delete(min, max);
                setSelection(min, min);
            }
            return true;
        } else if (i == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f587d);
            int selectionEnd2 = Selection.getSelectionEnd(this.f587d);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f584a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f587d.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        } else if (i == 16908322) {
            ClipData primaryClip = ((ClipboardManager) this.f584a.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f584a.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.f587d));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.f587d));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.f587d.delete(min2, max4);
                }
                this.f587d.insert(min2, coerceToText);
                int length = min2 + coerceToText.length();
                setSelection(length, length);
            }
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: c */
    private CursorAnchorInfo m1512c() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.f591h;
        if (builder == null) {
            this.f591h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f591h.setSelectionRange(this.f587d.m1497i(), this.f587d.m1498h());
        int m1499g = this.f587d.m1499g();
        int m1500f = this.f587d.m1500f();
        if (m1499g < 0 || m1500f <= m1499g) {
            this.f591h.setComposingText(-1, "");
        } else {
            this.f591h.setComposingText(m1499g, this.f587d.toString().subSequence(m1499g, m1500f));
        }
        return this.f591h.build();
    }

    /* renamed from: d */
    private ExtractedText m1511d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.f592i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.f587d.m1497i();
        this.f592i.selectionEnd = this.f587d.m1498h();
        this.f592i.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.f587d.toString() : this.f587d;
        return this.f592i;
    }

    /* renamed from: e */
    private boolean m1510e(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.f587d);
        int selectionEnd = Selection.getSelectionEnd(this.f587d);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int max = z ? Math.max(this.f595l.m1521b(this.f587d, selectionEnd), 0) : Math.min(this.f595l.m1522a(this.f587d, selectionEnd), this.f587d.length());
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        if (z3) {
            setSelection(max, max);
        } else {
            setSelection(selectionStart, max);
        }
        return true;
    }

    /* renamed from: g */
    private boolean m1508g(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.f587d);
        int selectionEnd = Selection.getSelectionEnd(this.f587d);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        if (z3) {
            if (z) {
                Selection.moveUp(this.f587d, this.f594k);
            } else {
                Selection.moveDown(this.f587d, this.f594k);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f587d);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(this.f587d, this.f594k);
            } else {
                Selection.extendDown(this.f587d, this.f594k);
            }
            setSelection(Selection.getSelectionStart(this.f587d), Selection.getSelectionEnd(this.f587d));
        }
        endBatchEdit();
        return true;
    }

    /* renamed from: h */
    private byte[] m1507h(InputStream inputStream, int i) {
        int i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            try {
                i2 = inputStream.read(bArr);
            } catch (IOException unused) {
                i2 = -1;
            }
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    @Override // io.flutter.plugin.editing.C0349c.InterfaceC0351b
    /* renamed from: a */
    public void mo1478a(boolean z, boolean z2, boolean z3) {
        this.f593j.updateSelection(this.f584a, this.f587d.m1497i(), this.f587d.m1498h(), this.f587d.m1499g(), this.f587d.m1500f());
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        ExtractedTextRequest extractedTextRequest = this.f589f;
        if (extractedTextRequest != null) {
            this.f593j.updateExtractedText(this.f584a, extractedTextRequest.token, m1511d(extractedTextRequest));
        }
        if (this.f590g) {
            this.f593j.updateCursorAnchorInfo(this.f584a, m1512c());
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f587d.m1504b();
        this.f597n++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        return super.clearMetaKeyStates(i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.f587d.m1494l(this);
        while (this.f597n > 0) {
            endBatchEdit();
            this.f597n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    @TargetApi(25)
    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    Uri contentUri = inputContentInfo.getContentUri();
                    String mimeType = inputContentInfo.getDescription().getMimeType(0);
                    Context context = this.f584a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (openInputStream != null) {
                                byte[] m1507h = m1507h(openInputStream, 65536);
                                HashMap hashMap = new HashMap();
                                hashMap.put("mimeType", mimeType);
                                hashMap.put("data", m1507h);
                                hashMap.put("uri", contentUri.toString());
                                this.f586c.m42b(this.f585b, hashMap);
                                inputContentInfo.releasePermission();
                                return true;
                            }
                        } catch (FileNotFoundException unused) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        if (this.f587d.m1497i() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return super.deleteSurroundingTextInCodePoints(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f597n--;
        this.f587d.m1502d();
        return endBatchEdit;
    }

    /* renamed from: f */
    public boolean m1509f(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return m1510e(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return m1510e(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return m1508g(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return m1508g(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                EditorInfo editorInfo = this.f588e;
                if ((131072 & editorInfo.inputType) == 0) {
                    performEditorAction(editorInfo.imeOptions & 255);
                    return true;
                }
            }
            int selectionStart = Selection.getSelectionStart(this.f587d);
            int selectionEnd = Selection.getSelectionEnd(this.f587d);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                beginBatchEdit();
                if (min != max) {
                    this.f587d.delete(min, max);
                }
                this.f587d.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
                int i = min + 1;
                setSelection(i, i);
                endBatchEdit();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.f587d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = (i & 1) != 0;
        if (z == (this.f589f == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z ? "on" : "off");
            C0576b.m742a("InputConnectionAdaptor", sb.toString());
        }
        this.f589f = z ? extractedTextRequest : null;
        return m1511d(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        beginBatchEdit();
        boolean m1513b = m1513b(i);
        endBatchEdit();
        return m1513b;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        if (i == 0) {
            this.f586c.m28p(this.f585b);
        } else if (i == 1) {
            this.f586c.m37g(this.f585b);
        } else if (i == 2) {
            this.f586c.m38f(this.f585b);
        } else if (i == 3) {
            this.f586c.m31m(this.f585b);
        } else if (i == 4) {
            this.f586c.m30n(this.f585b);
        } else if (i == 5) {
            this.f586c.m36h(this.f585b);
        } else if (i != 7) {
            this.f586c.m39e(this.f585b);
        } else {
            this.f586c.m33k(this.f585b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f586c.m34j(this.f585b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i & 1) != 0) {
            this.f593j.updateCursorAnchorInfo(this.f584a, m1512c());
        }
        boolean z = (i & 2) != 0;
        if (z != this.f590g) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z ? "on" : "off");
            C0576b.m742a("InputConnectionAdaptor", sb.toString());
        }
        this.f590g = z;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f596m.mo1506a(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        return super.setComposingRegion(i, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        beginBatchEdit();
        boolean commitText = charSequence.length() == 0 ? super.commitText(charSequence, i) : super.setComposingText(charSequence, i);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        beginBatchEdit();
        boolean selection = super.setSelection(i, i2);
        endBatchEdit();
        return selection;
    }
}