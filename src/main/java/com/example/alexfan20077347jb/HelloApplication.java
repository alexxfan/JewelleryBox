package com.example.alexfan20077347jb;

import com.example.alexfan20077347jb.Controllers.DisplayCaseController;
import com.example.alexfan20077347jb.Controllers.DisplayTrayController;
import com.example.alexfan20077347jb.Controllers.JewelleryController;
import com.example.alexfan20077347jb.Controllers.MaterialsController;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.example.alexfan20077347jb.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloApplication extends javafx.application.Application implements Initializable {

    public static HelloApplication helloapp;

    public static class Lists implements Serializable { //LIST class lets me access lists without looping through everything, meaning each linked list has an independant list
        public GenericList<DisplayCase> caseList = new GenericList<>();
        public GenericList<DisplayTray> trayList = new GenericList<>();
        public GenericList<Jewellery> jewelleryList = new GenericList<>();
        public GenericList<Materials> materialList = new GenericList<>();

        public GenericList<DisplayCase> getCaseList() {
            return caseList;
        }

        public GenericList<DisplayTray> getTrayList() {
            return trayList;
        }

        public GenericList<Jewellery> getJewelleryList() {
            return jewelleryList;
        }

        public GenericList<Materials> getMaterialList() {
            return materialList;
        }
    }

    public static HelloApplication.Lists LISTS = new Lists();

    @Override
    public void start(Stage stage) throws IOException {
        LISTS = new HelloApplication.Lists();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Jewellery Storage System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



    @FXML
    public static void load() throws Exception { // load
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(fileName())));
        LISTS = (HelloApplication.Lists) in.readObject();
        in.close();
    }

    public static void save() throws Exception { // save
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(fileName())));
        out.writeObject(LISTS);
        out.close();
    }

    public static String fileName(){
        return "Jewellery.dat";
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        helloapp = this;
    }

}

