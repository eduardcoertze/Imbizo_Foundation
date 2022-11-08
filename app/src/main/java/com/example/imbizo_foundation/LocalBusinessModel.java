package com.example.imbizo_foundation;

public class LocalBusinessModel {

    String localBusinessName;
    String imageUrl;

    public String getLocalBusinessName() {
        return localBusinessName;
    }

    public void setLocalBusinessName(String localBusinessName) {
        this.localBusinessName = localBusinessName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalBusinessModel(String localBusinessName, String imageUrl) {
        this.localBusinessName = localBusinessName;
        this.imageUrl = imageUrl;
    }

    public LocalBusinessModel() {
    }
}
