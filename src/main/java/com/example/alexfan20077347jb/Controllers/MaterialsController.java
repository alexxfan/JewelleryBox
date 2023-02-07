package com.example.alexfan20077347jb.Controllers;

import com.example.alexfan20077347jb.models.DisplayCase;
import com.example.alexfan20077347jb.models.DisplayTray;
import com.example.alexfan20077347jb.models.Jewellery;
import com.example.alexfan20077347jb.models.Materials;
import javafx.beans.property.ReadOnlySetProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import static com.example.alexfan20077347jb.HelloApplication.LISTS;

import java.net.URL;
import java.util.ResourceBundle;

public class MaterialsController implements Initializable {

    public static MaterialsController materialControl;

    @FXML
    private Label materialstext;

    @FXML
    public ChoiceBox<Jewellery> jewellerychoice;

    @FXML
    private TextField nametype, description, weightamountquantity, quality;


    @FXML
    public ListView materialList;

    public void addMaterial(ActionEvent actionEvent){
        if(jewellerychoice.getSelectionModel().getSelectedItem()!=null){
            materialList.getItems().add("Jewellery ID: " + jewellerychoice.getSelectionModel().getSelectedItem().getJewelleryID() + " Material Name/Type: "
            + nametype.getText() + " Description: " + description.getText() + " Weight/Quantity/Amount: " + weightamountquantity.getText() +
            " Quality: " + quality.getText());
            Materials addMaterials = new Materials(jewellerychoice.getSelectionModel().getSelectedItem().getJewelleryID(),nametype.getText(), description.getText(), weightamountquantity.getText(), quality.getText());
            LISTS.getMaterialList().addElement(addMaterials);
            jewellerychoice.getSelectionModel().getSelectedItem().materialList.addElement(addMaterials);
        }
    }

    public void deleteMaterial(ActionEvent actionEvent){
        int deleteMaterial = materialList.getSelectionModel().getSelectedIndex();
        materialList.getItems().remove(materialList.getSelectionModel().getSelectedIndex());
        LISTS.getMaterialList().delete(deleteMaterial);
    }

    public void selectedJewelleryForMaterial(ActionEvent actionEvent){
        Jewellery jewellery = jewellerychoice.getSelectionModel().getSelectedItem();
        materialList.getItems().clear();
        for(int i = 0; i < LISTS.getMaterialList().getListSize(); i++){
            Materials materials = LISTS.getMaterialList().get(i).getContents();
            if(materials.getJewelleryID()==jewellery.getJewelleryID()){
                materialList.getItems().add("Jewellery ID: " + jewellery.getJewelleryID() +" Material Name/Type : " + materials.getMaterialType() + " Description: "
                        + materials.getDescription() + " Weight/Quantity/Amount: " + materials.getQuantity() + " Quality: " + materials.getQuality());
            }
        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle){
        materialControl = this;
    }
}
