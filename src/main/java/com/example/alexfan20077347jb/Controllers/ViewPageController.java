package com.example.alexfan20077347jb.Controllers;

import com.example.alexfan20077347jb.models.DisplayCase;
import com.example.alexfan20077347jb.models.DisplayTray;
import com.example.alexfan20077347jb.models.GenericList;
import com.example.alexfan20077347jb.models.Jewellery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.alexfan20077347jb.HelloApplication.LISTS;

public class ViewPageController implements Initializable {

    public static ViewPageController ViewPageControl;

    @FXML
    public TextField search;


    @FXML
    public ListView searchview, viewall;

    public void SearchJewelleryByName(ActionEvent actionEvent) {
        searchview.getItems().clear();
        String searchItem = search.getText().toLowerCase();
        if (LISTS.getJewelleryList().getListSize() != 0) {
            GenericList<DisplayCase>.GenericNode<DisplayCase> dcTemp = LISTS.getCaseList().head;
            while (dcTemp != null) { // LOOP THROUGH DISPLAY CASES
                GenericList<DisplayTray>.GenericNode<DisplayTray> dtTemp = dcTemp.getContents().trayList.head;
                while (dtTemp != null) { // LOOP THROUGH DISPLAY TRAYS
                    GenericList<Jewellery>.GenericNode<Jewellery> itemTemp = dtTemp.getContents().jewelleryList.head;
                    while (itemTemp != null) { // LOOP THROUGH JEWELLERY
                        if (itemTemp.getContents().getItemType().contains(searchItem) || itemTemp.getContents().getItemDescription().contains(searchItem)) { // IF ITEM TYPE = searchItem String
                            searchview.getItems().add(itemTemp.getContents()); // ADD ITEM TO LIST
                        }
                        itemTemp = itemTemp.next; // CHECK NEXT
                    }
                    dtTemp = dtTemp.next; // CHECK NEXT
                }
                dcTemp = dcTemp.next; // CHECK NEXT
            }
        }
    } // SHOWS LINKED LISTS ARE CONNECTED




    public void viewJewellery(ActionEvent actionEvent){
        viewall.getItems().clear();
            if(LISTS.getJewelleryList().getListSize()!=0){ // DISPLAYS ALL JEWELLERY IN LISTVIEW
            for(int j = 0; j < LISTS.getJewelleryList().getListSize(); j++) {
                Jewellery jewellery = LISTS.getJewelleryList().get(j).getContents();
                viewall.getItems().add("Case ID: "+ jewellery.getCaseID() + " Tray ID: " + jewellery.getTrayID() +
                        ", Jewellery ID: " + jewellery.getJewelleryID() +
                        ", Item Description: " + jewellery.getItemDescription() +
                        ", Item Type: " + jewellery.getItemType() +
                        ", Item Gender: " + jewellery.getItemGender() +
                        ", Item Image URL: " + jewellery.getItemImageURL() +
                        ", Item Price: " + jewellery.getItemPrice());

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ViewPageControl = this;
    }
}
