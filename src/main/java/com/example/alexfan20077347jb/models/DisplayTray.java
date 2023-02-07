package com.example.alexfan20077347jb.models;

import java.io.Serializable;

public class DisplayTray implements Serializable {
    // FIELDS
    public String displayCaseNumber;
    public String trayIdentifier;
    public String inlayColour;
    public String trayDimensions;
    public GenericList<Jewellery> jewelleryList=new GenericList<>();

    // CONSTRUCTOR
    public DisplayTray(String displayCaseNumber, String trayIdentifier, String inlayColour, String trayDimensions){
        this.displayCaseNumber = displayCaseNumber;
        this.trayIdentifier = trayIdentifier;
        this.inlayColour = inlayColour;
        this.trayDimensions = trayDimensions;
    }

    // GETTERS


    public String getDisplayCaseNumber() { return displayCaseNumber; }

    public String getTrayIdentifier() {
        return trayIdentifier;
    }

    public String getInlayColour() {
        return inlayColour;
    }

    public String getTrayDimensions() {
        return trayDimensions;
    }

    // SETTERS


    public void setDisplayCaseNumber(String displayCaseNumber) { this.displayCaseNumber = displayCaseNumber; }

    public void setTrayIdentifier(String trayIdentifier) {
        this.trayIdentifier = trayIdentifier;
    }

    public void setInlayColour(String inlayColour) {
        this.inlayColour = inlayColour;
    }

    public void setTrayDimensions(String trayDimensions) {
        this.trayDimensions = trayDimensions;
    }

    // toString
    @Override
    public String toString() {
        return "DisplayTray {" + "Case ID: " + getDisplayCaseNumber() +
                "Tray ID: " + getTrayIdentifier() + '\'' +
                ", Tray Colour: " + getInlayColour() + '\'' +
                ", Tray Dimensions: " + getTrayDimensions() +
                '}';
    }
}
