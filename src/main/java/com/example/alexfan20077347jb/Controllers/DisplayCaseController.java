package com.example.alexfan20077347jb.Controllers;

import com.example.alexfan20077347jb.HelloApplication;
import com.example.alexfan20077347jb.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.alexfan20077347jb.HelloApplication.LISTS;

public class DisplayCaseController implements Initializable {

    public static DisplayCaseController displaycasecontrol;

    @FXML
    private Label displayCaseText;

    @FXML
    private TextField caseName, caseNumber, caseType, caseLighting;

    @FXML
    public ListView cases;

    public void addDisplayCase(ActionEvent actionEvent){
        int casenum = Integer.parseInt(caseNumber.getText());
        cases.getItems().add("Display Case: " + caseName.getText() + " Case Number: " + caseNumber.getText() +
                " Case Type: " + caseType.getText() + " Case Lighting: " + caseLighting.getText());
        DisplayCase addDC = new DisplayCase(caseName.getText(), caseNumber.getText(), caseType.getText(), caseLighting.getText()); // adds a display case using the elements you entered
        LISTS.getCaseList().addElement(addDC); // adds the display case to the list
        DisplayTrayController.displayTrayControl.casechoice.getItems().add(addDC); // adds a display case to the choicebox in the display tray tab
//        JewelleryController.JewelControl.casechoice.getItems().add(addDC);
    }

    //int n=Integer.parseInt(str);
    public void deleteDisplayCase(ActionEvent actionEvent){
        int deleteDC = cases.getSelectionModel().getSelectedIndex(); // select a case
        cases.getItems().remove(cases.getSelectionModel().getSelectedIndex()); // get case you selected and remove it
        LISTS.getCaseList().delete(deleteDC); // remove case from list
        DisplayTrayController.displayTrayControl.casechoice.getItems().remove(cases.getSelectionModel().getSelectedIndex()); // remove from choicebox
//        JewelleryController.JewelControl.casechoice.getItems().remove(cases.getSelectionModel().getSelectedIndex());
    }

    public void clearAll(ActionEvent actionEvent){ // clears literally everything
        LISTS.getCaseList().clear();
        LISTS.getTrayList().clear();
        LISTS.getJewelleryList().clear();
        LISTS.getMaterialList().clear();

        cases.getItems().clear();

        DisplayTrayController.displayTrayControl.casechoice.getItems().clear();
        DisplayTrayController.displayTrayControl.trays.getItems().clear();

        JewelleryController.JewelControl.traychoice.getItems().clear();
        JewelleryController.JewelControl.jewelleryList.getItems().clear();

        MaterialsController.materialControl.jewellerychoice.getItems().clear();
        MaterialsController.materialControl.materialList.getItems().clear();

        ViewPageController.ViewPageControl.searchview.getItems().clear();
        ViewPageController.ViewPageControl.viewall.getItems().clear();


    }


    @FXML
    public void save(ActionEvent actionEvent) throws Exception { // save
        try {
            HelloApplication.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void load(ActionEvent actionEvent) throws Exception{ // load
        HelloApplication.load();

        for(int i = 0; i < LISTS.getCaseList().getListSize(); i++){
            GenericList<DisplayCase>.GenericNode<DisplayCase> temp = LISTS.getCaseList().get(i);
            if(temp != null){
                cases.getItems().add(temp.getContents());
                DisplayTrayController.displayTrayControl.casechoice.getItems().add(temp.getContents());

            }
        }

        for(int i = 0; i < LISTS.getTrayList().getListSize(); i++){
            GenericList<DisplayTray>.GenericNode<DisplayTray> temp = LISTS.getTrayList().get(i);
            if(temp != null){
                DisplayTrayController.displayTrayControl.trays.getItems().add(temp.getContents());
                JewelleryController.JewelControl.traychoice.getItems().add(temp.getContents());
            }
        }

        for(int i = 0; i < LISTS.getJewelleryList().getListSize(); i++){
            GenericList<Jewellery>.GenericNode<Jewellery> temp = LISTS.getJewelleryList().get(i);
            if(temp != null){
                JewelleryController.JewelControl.jewelleryList.getItems().add(temp.getContents());
                MaterialsController.materialControl.jewellerychoice.getItems().add(temp.getContents());
            }
        }

        for(int i = 0; i < LISTS.getMaterialList().getListSize(); i++){
            GenericList<Materials>.GenericNode<Materials> temp = LISTS.getMaterialList().get(i);
            if(temp != null){
                MaterialsController.materialControl.materialList.getItems().add(temp.getContents());
            }
        }

        // populating lists and choice boxes

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displaycasecontrol = this;
    }
}