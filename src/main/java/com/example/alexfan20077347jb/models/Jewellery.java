package com.example.alexfan20077347jb.models;

import com.example.alexfan20077347jb.utils.Utilities;

import java.io.Serializable;

public class Jewellery implements Serializable {

    //FIELDS
    String caseID;
    String trayID;
    String jewelleryID;
    String itemDescription;
    String itemType;
    String itemGender;
    String itemImageURL;
    String itemPrice;
    String totalStockNumber;
    public GenericList<Materials> materialList=new GenericList<>();

    //CONSTRUCTOR
    public Jewellery(String caseID, String trayID, String jewelleryID, String itemType, String itemGender, String itemDescription, String itemImageURL, String itemPrice){
        this.caseID = caseID;
        this.trayID = trayID;
        this.jewelleryID = jewelleryID;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.itemGender = itemGender;
        setItemImageURL(itemImageURL);
        this.itemPrice = itemPrice;
    }

    //GETTERS


    public String getCaseID() { return caseID; }

    public String getTrayID() { return trayID; }

    public String getJewelleryID() { return jewelleryID; }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemGender() {
        return itemGender;
    }

    public String getItemImageURL() {
        return itemImageURL;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getTotalStockNumber() { return totalStockNumber;}

    //SETTERS

    public void setCaseID(String caseID) { this.caseID = caseID;}

    public void setTrayID(String trayID) { this.trayID = trayID; }

    public void setJewelleryID(String jewelleryID) { this.jewelleryID = jewelleryID; }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemGender(String itemGender) {
        this.itemGender = itemGender;
    }

    public void setItemImageURL(String itemImageURL) {
        if(Utilities.isValidURL(itemImageURL)){
            this.itemImageURL = itemImageURL;
        }
    }

    public void setTotalStockNumber(String totalStockNumber) { this.totalStockNumber = totalStockNumber; }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Jewellery { " + "Case ID: " + getCaseID() + "Tray ID: " + getTrayID() + '\'' +
                 ", Jewellery ID: " + getJewelleryID() + '\'' +
                ", Item Description: " + getItemDescription() + '\'' +
                ", Item Type: " + getItemType() + '\'' +
                ", Item Gender: " + getItemGender() + '\'' +
                ", Item Image URL: " + getItemImageURL() + '\'' +
                ", Item Price: " + getItemPrice() + '\'' +
                '}';
    }
}
