package com.example.imbizo_foundation;

public class InspirationModel {

    String entrepreneurName;
    String entrepreneurURL;

    public InspirationModel(String entrepreneurName, String entrepreneurURL) {
        this.entrepreneurName= entrepreneurName;
        this.entrepreneurURL = entrepreneurURL;
    }

    public InspirationModel() {
    }
    public void setEntrepreneurName(String entrepreneurName) {
        this.entrepreneurName = entrepreneurName;
    }
    public void setEntrepreneurURL(String entrepreneurURL) {
        this.entrepreneurURL = entrepreneurURL;
    }
    public String getEntrepreneurName() {
        return entrepreneurName;
    }
    public String getEntrepreneurURL() {
        return entrepreneurURL;
    }
}