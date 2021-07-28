package com.gzeinnumer.cbi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CheckBeforeIntent {

    private boolean isSave = true;
    @SuppressLint("StaticFieldLeak")
    static volatile CheckBeforeIntent singleton = null;
    private final List<View> views;
    private Context context;
    private CheckBeforeIntentCallBack checkBeforeIntentCallBack;

    public CheckBeforeIntent(Context context) {
        this.context = context;
        this.views = new ArrayList<>();
    }

    public static CheckBeforeIntent with(Context context) {
        synchronized (CheckBeforeIntent.class) {
            singleton = new CheckBeforeIntent(context);
        }
        return singleton;
    }

    public CheckBeforeIntent addView(View view) {
        views.add(view);
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
