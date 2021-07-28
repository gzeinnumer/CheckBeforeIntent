package com.gzeinnumer.cbi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckBeforeIntent {

    private boolean isSave = true;
    @SuppressLint("StaticFieldLeak")
    private final ArrayList<View> views;
    private CheckBeforeIntentCallBack checkBeforeIntentCallBack;

    public CheckBeforeIntent() {
        this.views = new ArrayList<>();
    }

    public CheckBeforeIntent addView(View view) {
        views.add(view);
        return this;
    }

    public CheckBeforeIntent addView(View... view) {
        views.addAll(Arrays.asList(view));
        return this;
    }

    public CheckBeforeIntent addView(ArrayList<View> view) {
        views.addAll(view);
        return this;
    }

    public CheckBeforeIntent addView(List<View> view) {
        views.addAll(view);
        return this;
    }

    public void build() {
        isSave = true;
        for (int i = 0; i < views.size(); i++) {
            if (((TextView)views.get(i)).getText().toString().length()>0){
                isSave = false;
                break;
            }
        }
        checkBeforeIntentCallBack.isSaveToLeave(isSave);
    }

    public CheckBeforeIntent isSaveToLeave(CheckBeforeIntentCallBack checkBeforeIntentCallBack) {
        this.checkBeforeIntentCallBack = checkBeforeIntentCallBack;
        return this;
    }

    public interface CheckBeforeIntentCallBack{
        void isSaveToLeave(boolean isSave);
    }
}
