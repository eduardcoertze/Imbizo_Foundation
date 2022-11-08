package com.example.imbizo_foundation;

public class LocalBusinessContentModel {

    String businessName;
    String businessIntro;
    String businessPara1;
    String businessPara2;
    String businessURL;

    public LocalBusinessContentModel(String businessName, String businessIntro, String businessPara1, String businessPara2, String businessURL) {
        this.businessName = businessName;
        this.businessIntro = businessIntro;
        this.businessPara1 = businessPara1;
        this.businessPara2 = businessPara2;
        this.businessURL = businessURL;
    }

    public LocalBusinessContentModel() {
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessIntro() {
        return businessIntro;
    }

    public void setBusinessIntro(String businessIntro) {
        this.businessIntro = businessIntro;
    }

    public String getBusinessPara1() {
        return businessPara1;
    }

    public void setBusinessPara1(String businessPara1) {
        this.businessPara1 = businessPara1;
    }

    public String getBusinessPara2() {
        return businessPara2;
    }

    public void setBusinessPara2(String businessPara2) {
        this.businessPara2 = businessPara2;
    }

    public String getBusinessURL() {
        return businessURL;
    }

    public void setBusinessURL(String businessURL) {
        this.businessURL = businessURL;
    }
}
