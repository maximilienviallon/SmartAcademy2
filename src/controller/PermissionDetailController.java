package controller;

import Domain.Permissions;
import Domain.Users;
import Persistence.DBFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PermissionDetailController  extends Controller implements Initializable {
    @FXML
    TableView<Users> permissionDetailTableView = new TableView<>();
    @FXML
    TableColumn<Users,String> colUserName = new TableColumn();
    @FXML
    TableColumn<Users,String> colPermission = new TableColumn();
    @FXML
    TableColumn<Users,String> colApprenticeName = new TableColumn();
    @FXML
    TableColumn<Users,String> colContactName = new TableColumn();

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


        ObservableList<Users> userList = FXCollections.observableArrayList(DBFacade.retrieveUsersByPermissions(permissionID));
        permissionDetailTableView.setItems(userList);

        colUserName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getUsername()));
        colPermission.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPermission()));
        colApprenticeName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getApprenticeName()));
        colContactName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getConName()));
        permissionDetailTableView.getColumns().setAll(colUserName,colPermission,colApprenticeName,colContactName);
    }
}
