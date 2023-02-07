package com.example.alexfan20077347jb.Controllers;

import com.example.alexfan20077347jb.HelloApplication;
import com.example.alexfan20077347jb.models.DisplayCase;
import com.example.alexfan20077347jb.models.DisplayTray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.alexfan20077347jb.HelloApplication.LISTS;

public class DisplayTrayController implements Initializable{

    public static DisplayTrayController displayTrayControl;

    @FXML
    private Label displayTrayText;

    @FXML
    public ChoiceBox<DisplayCase> casechoice;

    @FXML
    private TextField trayIdentifier, trayInLayColour, trayDimensions;

    @FXML
    public ListView trays;

    public void addDisplayTray(ActionEvent actionEvent){

        int traynum = Integer.parseInt(trayIdentifier.getText());
        if(casechoice.getSelectionModel().getSelectedItem()!=null){ // if a case exists in the choice box
            trays.getItems().add("Case ID: " + casechoice.getSelectionModel().getSelectedItem().getCaseNumber() +  " Tray ID: " + trayIdentifier.getText() + " Tray Colour: " +
                    trayInLayColour.getText() + " Tray Dimensions: " + trayDimensions.getText() + "cm"); // add to list
            DisplayTray addDT = new DisplayTray(casechoice.getSelectionModel().getSelectedItem().getCaseNumber(), trayIdentifier.getText(), trayInLayColour.getText(), trayDimensions.getText()); // adds a display case using the elements you entered
            LISTS.getTrayList().addElement(addDT); // add to linked list
            casechoice.getSelectionModel().getSelectedItem().trayList.addElement(addDT);
            JewelleryController.JewelControl.traychoice.getItems().add(addDT); // add to choice box in jewellery
        }
    }

    public void deleteDisplayTray(ActionEvent actionEvent){
        int deleteTrays = trays.getSelectionModel().getSelectedIndex(); // get tray at selected mouse click
        trays.getItems().remove(trays.getSelectionModel().getSelectedIndex()); // remove from listview
        LISTS.getTrayList().delete(deleteTrays); // remove from linked list
        JewelleryController.JewelControl.traychoice.getItems().remove(trays.getSelectionModel().getSelectedIndex()); // remove from jewellery choice box

    }


    public void selectedCaseForTrays(ActionEvent actionEvent){ // displays the trays for selected case
        DisplayCase displaycase = casechoice.getSelectionModel().getSelectedItem(); // select case
        trays.getItems().clear(); // clear listview
        for(int i = 0; i < LISTS.getTrayList().getListSize(); i++){ // loop through traylist
            DisplayTray displaytray = LISTS.getTrayList().get(i).getContents(); // get the lists contents
            if(displaytray.getDisplayCaseNumber()==displaycase.getCaseNumber()){ // if trays casenumber is equal to the cases casenumber then display the trays from the chosen case
                trays.getItems().add("Case ID: " + displaycase.getCaseNumber() +" Tray ID: " + displaytray.getTrayIdentifier() + " Tray Colour: " + displaytray.getInlayColour() + " Tray Dimensions: " + displaytray.getTrayDimensions() + "cm");
            }
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){ // https://docs.oracle.com/javase/8/javafx/api/javafx/fxml/Initializable.html
    displayTrayControl = this;

    }
}
