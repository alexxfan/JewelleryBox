package com.example.alexfan20077347jb.models;


import java.io.Serializable;

public class DisplayCase implements Serializable {

    // FIELDS

    public String caseName;
    public String caseNumber;
    public String caseType;
    public String caseLighting;
    public GenericList<DisplayTray> trayList=new GenericList<>();


    // CONSTRUCTOR

    public DisplayCase(String caseName, String caseNumber, String caseType, String caseLighting) {
        this.caseName = caseName;
        this.caseNumber = caseNumber;
        this.caseType = caseType;
        this.caseLighting = caseLighting;
    }

    // GETTERS

    public String getCaseName() {
        return caseName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getCaseLighting() {
        return caseLighting;
    }

    // SETTERS


    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public void setCaseLighting(String caseLighting) {
        this.caseLighting = caseLighting;
    }

    // toString


    @Override
    public String toString() {
        return "Display Case {" +
                "Case Name: '" + getCaseName() + '\'' +
                ", Case Number: '" + getCaseNumber() + '\'' +
                ", Case Type: " + getCaseType() + '\'' +
                ", Case Lighting: " + getCaseLighting() + '\'' +
                '}';
    }
}
