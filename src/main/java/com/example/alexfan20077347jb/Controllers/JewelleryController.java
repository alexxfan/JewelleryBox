package com.example.alexfan20077347jb.Controllers;

import com.example.alexfan20077347jb.models.DisplayCase;
import com.example.alexfan20077347jb.models.DisplayTray;
import com.example.alexfan20077347jb.models.Jewellery;
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

public class JewelleryController implements Initializable{

    public static JewelleryController JewelControl;

    @FXML
    private Label jewelleryText;
    @FXML
    private Label totalStock;
    @FXML
    private Label totalStockValue;

    @FXML

    public ChoiceBox<DisplayTray> traychoice;

    @FXML
    private TextField jewelleryID, itemDescription, itemType, itemGender, itemImageURL, itemPrice;


    @FXML
    public ListView jewelleryList;

    public void addJewellery(ActionEvent actionEvent){
        int itemnum = Integer.parseInt(jewelleryID.getText());
        if (traychoice.getSelectionModel().getSelectedItem()!=null){
            jewelleryList.getItems().add("Case ID: " + traychoice.getSelectionModel().getSelectedItem().getDisplayCaseNumber() +
                    " Tray ID: " + traychoice.getSelectionModel().getSelectedItem().getTrayIdentifier() + " Jewellery ID: " + jewelleryID.getText() + " Item Type: " + itemType.getText()
            + " Item Gender Target: " + itemGender.getText() + " Item Description: " + itemDescription.getText() + " Item Image URL: " + itemImageURL.getText()
                    + " Item Price: €" + itemPrice.getText());
            Jewellery addJewellery = new Jewellery(traychoice.getSelectionModel().getSelectedItem().displayCaseNumber,traychoice.getSelectionModel().getSelectedItem().getTrayIdentifier(), jewelleryID.getText() ,itemType.getText(), itemGender.getText(), itemDescription.getText(), itemImageURL.getText(), itemPrice.getText());
            LISTS.getJewelleryList().addElement(addJewellery);
            traychoice.getSelectionModel().getSelectedItem().jewelleryList.addElement(addJewellery);
            MaterialsController.materialControl.jewellerychoice.getItems().add(addJewellery);
        }
    }

    public void deleteJewellery(ActionEvent actionEvent){
        int deleteJewellery = jewelleryList.getSelectionModel().getSelectedIndex();
        jewelleryList.getItems().remove(jewelleryList.getSelectionModel().getSelectedIndex());
        LISTS.getJewelleryList().delete(deleteJewellery);
        MaterialsController.materialControl.jewellerychoice.getItems().remove(jewelleryList.getSelectionModel().getSelectedIndex());
    }


    // IGNORE ALL THIS


//    public void totalStockNum(){
//        for(int i = 0; i < LISTS.getJewelleryList().getListSize(); i++){
//            totalStockValue.getText() = LISTS.getJewelleryList().get(i).getContents().getItemPrice();
//        }



    public void selectedJewelleryForTray(ActionEvent actionEvent){ // DISPLAYS JEWELLERY FOR SELECTED CASE
        DisplayTray displaytray = traychoice.getSelectionModel().getSelectedItem();
        jewelleryList.getItems().clear();
        for(int i = 0; i < LISTS.getJewelleryList().getListSize(); i++){
            Jewellery jewellery = LISTS.getJewelleryList().get(i).getContents();
            if(displaytray.getTrayIdentifier()==jewellery.getTrayID()){
                jewelleryList.getItems().add(" Case ID: " + displaytray.getDisplayCaseNumber() + " Tray ID: " + displaytray.getTrayIdentifier() + " Jewellery ID: " + jewellery.getJewelleryID()
                + " Item Type: " + jewellery.getItemType()
                        + " Item Gender Target: " + jewellery.getItemGender() + " Item Description: " + jewellery.getItemDescription() +
                        " Item Image URL: " + jewellery.getItemImageURL()
                        + " Item Price: €" + jewellery.getItemPrice());
            }
        }
    }



    public void initialize(URL url, ResourceBundle resourceBundle){
        JewelControl = this;
    }


}
