package com.jacklin.anddigitaltelecomsapi;

/**
 * Created by Jacklin on 22/04/2018.
 */
public class PhoneNumber {

    private String number;
    private boolean isActivated;

    public PhoneNumber(String number, boolean isActivated) {
        this.number = number;
        this.isActivated = isActivated;
    }

    public String getNumber() {
        return number;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
