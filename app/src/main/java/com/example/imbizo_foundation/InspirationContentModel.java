package com.example.imbizo_foundation;

public class InspirationContentModel {

    String entrepreneurName;
    String entrepreneurIntro;
    String entrepreneurPara1;
    String entrepreneurPara2;
    String entrepreneurURL;

    public InspirationContentModel(String entrepreneurName, String entrepreneurIntro, String entrepreneurPara1, String entrepreneurPara2, String entrepreneurURL) {
        this.entrepreneurName = entrepreneurName;
        this.entrepreneurIntro = entrepreneurIntro;
        this.entrepreneurPara1 = entrepreneurPara1;
        this.entrepreneurPara2 = entrepreneurPara2;
        this.entrepreneurURL = entrepreneurURL;
    }

    public InspirationContentModel() {
    }

    public String getEntrepreneurName() {
        return entrepreneurName;
    }

    public void setEntrepreneurName(String entrepreneurName) {
        this.entrepreneurName = entrepreneurName;
    }

    public String getEntrepreneurIntro() {
        return entrepreneurIntro;
    }

    public void setEntrepreneurIntro(String entrepreneurIntro) {
        this.entrepreneurIntro = entrepreneurIntro;
    }

    public String getEntrepreneurPara1() {
        return entrepreneurPara1;
    }

    public void setEntrepreneurPara1(String entrepreneurPara1) {
        this.entrepreneurPara1 = entrepreneurPara1;
    }

    public String getEntrepreneurPara2() {
        return entrepreneurPara2;
    }

    public void setEntrepreneurPara2(String entrepreneurPara2) {
        this.entrepreneurPara2 = entrepreneurPara2;
    }

    public String getEntrepreneurURL() {
        return entrepreneurURL;
    }

    public void setEntrepreneurURL(String entrepreneurURL) {
        this.entrepreneurURL = entrepreneurURL;
    }
}
