package controller;

import Domain.Educations;
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

public class UserOverviewController  extends Controller implements Initializable {
    @FXML
    TableView<Users> UOTableView = new TableView<>();

    @FXML
    TableColumn<Users,String> colUserName = new TableColumn<>();
    @FXML
    TableColumn<Users,String> colPermission = new TableColumn<>();
    @FXML
    TableColumn<Users,String> colApprenticeName = new TableColumn<>();
    @FXML
    TableColumn<Users,String> colContactName = new TableColumn<>();

    FXMLLoader fxmlLoader;
    String title;

    String UserName;

    public void UOSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UOEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UOAppOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UOComOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UOExpCsvButHandle(ActionEvent actionEvent) {
    }

    public void UOPrintButHandle(ActionEvent actionEvent) {
    }

    public void UOCreaNewButHandle(ActionEvent actionEvent) throws IOException{
        title = "User Creation";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user creation.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UOSelectButHandle(ActionEvent actionEvent) throws IOException{
        Users user = UOTableView.getSelectionModel().getSelectedItem();
        KeeperOfKeys.getLoggedUserNameInstance().currentUserName().setsUserName(user.getUsername());
        title = "User Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UOViewLogButHandle(ActionEvent actionEvent) throws IOException{
    }

    public void UOPerOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Permission Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/permission overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);

        ObservableList<Users> userList = FXCollections.observableArrayList(DBFacade.retrieveUsers());
        UOTableView.setItems(userList);

        colUserName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getUsername()));
        colPermission.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPermission()));
        colApprenticeName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getApprenticeName()));
        colContactName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getConName()));
        UOTableView.getColumns().setAll(colUserName,colPermission,colApprenticeName,colContactName);
    }

    public String getsUserName() {
        return UserName;
    }

    public void setsUserName(String userName) {
        UserName = userName;
    }

}
