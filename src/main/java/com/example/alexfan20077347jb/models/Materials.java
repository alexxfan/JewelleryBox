package com.example.alexfan20077347jb.models;

import java.io.Serializable;

public class Materials implements Serializable {

    //FIELDS
    String jewelleryID;
    String materialType;
    String description;
    String quantity;
    String quality;

    //CONSTRUCTOR
    public Materials(String jewelleryID, String materialType, String description, String quantity, String quality) {
        this.jewelleryID = jewelleryID;
        this.materialType = materialType;
        this.description = description;
        this.quantity = quantity;
        this.quality = quality;
    }

    //GETTERS
    public String getJewelleryID() {
        return jewelleryID;
    }

    public String getMaterialType() {
        return materialType;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getQuality() {
        return quality;
    }

    //SETTERS
    public void setJewelleryID(String jewelleryID) { this.jewelleryID = jewelleryID; }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    //toString
    @Override
    public String toString() {
        return "Materials {" + "Jewellery ID: " + getJewelleryID() + '\'' +
                ", Material Name/Type: " + getMaterialType() + '\'' +
                ", Description: " + getDescription() + '\'' +
                ", Weight/Quantity/Amount: " + getQuantity() +
                ", Quality: " + getQuality() +
                '}';
    }
}
