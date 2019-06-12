package controller;

import Domain.Users;
import Persistence.DBFacade;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserDetailController  extends Controller implements Initializable {


    String title;
    FXMLLoader fxmlLoader;
    String username;
    public void backToUserOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UserExportHandle(ActionEvent actionEvent) {
    }

    public void UserPrintHandle(ActionEvent actionEvent) {
    }

    public void UserEditHandle(ActionEvent actionEvent) throws IOException {
        title = "User Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user modification.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UserRemoveHandle(ActionEvent actionEvent) throws IOException {
        title = "USer Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        username = KeeperOfKeys.getLoggedUserNameInstance().currentUserName().getsUserName();
        Users view = DBFacade.retrieveUsers().get(0);
    }
}
