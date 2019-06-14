package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    public void fxmlLoading (FXMLLoader fxmlLoader,String title) throws IOException {
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root,1900,1000));
        stage.show();
    }

    public void printScreen(){

    }

    public void saveCSV()
    {

    }
}
