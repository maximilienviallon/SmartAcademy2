package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactModificationController  extends Controller implements Initializable {
    public void CMSaveButHandle(ActionEvent actionEvent) {
    }

    public void CMBackToOButHandle(ActionEvent actionEvent) {
    }

    public void CMBackToDetButHandle(ActionEvent actionEvent) {
    }

    public void CMRemoveButHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
