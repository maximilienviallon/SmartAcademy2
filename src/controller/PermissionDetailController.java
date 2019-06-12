package controller;

import Domain.Permissions;
import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PermissionDetailController  extends Controller implements Initializable {

    FXMLLoader fxmlLoader;
    String title;
    String username;
    Integer permissionID;

    public void backToPermissionOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Permission Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/permission Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void PermisionExportHandle(ActionEvent actionEvent) {
    }

    public void PermisionPrintHandle(ActionEvent actionEvent) {
    }

    public void PermisionRemoveHandle(ActionEvent actionEvent)throws IOException {
        title = "permission Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/permission Overview.fxml"));
        fxmlLoading(fxmlLoader, title);
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        permissionID = KeeperOfKeys.getLoggedUserNameInstance().currentPermissionID().getsPermissionID();
        Permissions view = DBFacade.retrievePermissions().get(0);
    }
}
