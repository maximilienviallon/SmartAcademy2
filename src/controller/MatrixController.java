package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MatrixController  extends Controller implements Initializable {
    public void matrixBackToOverviewHandle(ActionEvent actionEvent) {
    }

    public void matrixExportHandle(ActionEvent actionEvent) {
    }

    public void matrixPrintHandle(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
