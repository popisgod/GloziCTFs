package io.flutter.plugin.editing;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import p001a0.C0033k;
import p005b0.C0109a;
import p053z.C0894o;

/* renamed from: io.flutter.plugin.editing.d  reason: invalid class name */
/* loaded from: classes.dex */
public class textserviceSpellCheckerSession$SpellCheckerSessionListenerC0352d implements C0894o.InterfaceC0896b, SpellCheckerSession.SpellCheckerSessionListener {

    /* renamed from: a */
    private final C0894o f612a;

    /* renamed from: b */
    private final TextServicesManager f613b;

    /* renamed from: c */
    private SpellCheckerSession f614c;

    /* renamed from: d */
    C0033k.InterfaceC0038d f615d;

    public textserviceSpellCheckerSession$SpellCheckerSessionListenerC0352d(TextServicesManager textServicesManager, C0894o c0894o) {
        this.f613b = textServicesManager;
        this.f612a = c0894o;
        c0894o.m46b(this);
    }

    @Override // p053z.C0894o.InterfaceC0896b
    /* renamed from: a */
    public void mo45a(String str, String str2, C0033k.InterfaceC0038d interfaceC0038d) {
        if (this.f615d != null) {
            interfaceC0038d.mo66a("error", "Previous spell check request still pending.", null);
            return;
        }
        this.f615d = interfaceC0038d;
        m1490c(str, str2);
    }

    /* renamed from: b */
    public void m1491b() {
        this.f612a.m46b(null);
        SpellCheckerSession spellCheckerSession = this.f614c;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    /* renamed from: c */
    public void m1490c(String str, String str2) {
        Locale m2098b = C0109a.m2098b(str);
        if (this.f614c == null) {
            this.f614c = this.f613b.newSpellCheckerSession(null, m2098b, this, true);
        }
        this.f614c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        ArrayList arrayList;
        C0033k.InterfaceC0038d interfaceC0038d;
        if (sentenceSuggestionsInfoArr.length == 0) {
            interfaceC0038d = this.f615d;
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
            if (sentenceSuggestionsInfo == null) {
                interfaceC0038d = this.f615d;
                arrayList = new ArrayList();
            } else {
                for (int i = 0; i < sentenceSuggestionsInfo.getSuggestionsCount(); i++) {
                    SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i);
                    int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
                    if (suggestionsCount > 0) {
                        HashMap hashMap = new HashMap();
                        int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i);
                        int lengthAt = sentenceSuggestionsInfo.getLengthAt(i) + offsetAt;
                        hashMap.put("startIndex", Integer.valueOf(offsetAt));
                        hashMap.put("endIndex", Integer.valueOf(lengthAt));
                        ArrayList arrayList2 = new ArrayList();
                        boolean z = false;
                        for (int i2 = 0; i2 < suggestionsCount; i2++) {
                            String suggestionAt = suggestionsInfoAt.getSuggestionAt(i2);
                            if (!suggestionAt.equals("")) {
                                arrayList2.add(suggestionAt);
                                z = true;
                            }
                        }
                        if (z) {
                            hashMap.put("suggestions", arrayList2);
                            arrayList.add(hashMap);
                        }
                    }
                }
                interfaceC0038d = this.f615d;
            }
        }
        interfaceC0038d.mo65b(arrayList);
        this.f615d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}