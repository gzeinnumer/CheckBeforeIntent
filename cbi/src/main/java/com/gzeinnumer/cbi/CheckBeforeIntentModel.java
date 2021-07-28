package com.gzeinnumer.cbi;

public class CheckBeforeIntentModel {

    boolean value;
    String msg = "Required correct value";

    public CheckBeforeIntentModel(boolean value) {
        this.value = value;
    }

    public CheckBeforeIntentModel(boolean value, String msg) {
        this.value = value;
        this.msg = msg;
    }
}
