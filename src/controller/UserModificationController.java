package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class UserModificationController  extends Controller implements Initializable {
    public void UMSavButHandle(ActionEvent actionEvent) {
    }

    public void UMRemButHandle(ActionEvent actionEvent) {
    }

    public void UMAddButHandle(ActionEvent actionEvent) {
    }

    public void UMBacToOveButHandle(ActionEvent actionEvent) {
    }

    public void UMBacToDetButHandle(ActionEvent actionEvent) {
    }

    public void UMDelButHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
