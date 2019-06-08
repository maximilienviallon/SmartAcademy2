package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PermissionModificationController  extends Controller implements Initializable {
    public void EMBacToDetBut(ActionEvent actionEvent) {
    }

    public void EMRemBut(ActionEvent actionEvent) {
    }

    public void EMSaveButHandle(ActionEvent actionEvent) {
    }

    public void EMBacToOveButHandle(ActionEvent actionEvent) {
    }

    public void CMBackToDetButHandle(ActionEvent actionEvent) {
    }

    public void CMRemoveButHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
