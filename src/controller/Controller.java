package controller;

import Domain.Companies;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
}
