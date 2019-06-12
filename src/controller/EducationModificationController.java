package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class
EducationModificationController  extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;
    public void EMSaveButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Education Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    public void CMRemoveButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void EMBacToOveButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void CMBackToDetButHandle(ActionEvent actionEvent)  throws IOException {
        title = "Education Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }

}
