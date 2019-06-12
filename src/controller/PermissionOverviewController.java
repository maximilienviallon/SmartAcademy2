package controller;

import Domain.Companies;
import Domain.Educations;
import Domain.Permissions;
import Persistence.DBFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PermissionOverviewController  extends Controller implements Initializable {
    @FXML
    TableView<Permissions> POTableView = new TableView();

    TableColumn<Permissions,String> colPermissionID = new TableColumn<>();

    @FXML
    TableColumn<Permissions,String> colPermissions = new TableColumn();
    @FXML
    TableColumn<Permissions,String> colCompanyID = new TableColumn<>();
    @FXML
    private TextField POSeaText;

    FXMLLoader fxmlLoader;
    String title;
    Integer permissionID;
    String username;

    public void POSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void POEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void POAppOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void POUseOverButHandle(ActionEvent actionEvent)throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void POComOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void POExpCsvButHandle(ActionEvent actionEvent) {
    }

    public void POPrintButHandle(ActionEvent actionEvent) {
    }

    public void POSelectButHandle(ActionEvent actionEvent) throws IOException{
        Permissions permissions = POTableView.getSelectionModel().getSelectedItem();
        KeeperOfKeys.getLoggedUserNameInstance().currentPermissionID().setsPermissionID(permissions.getPermissionID());
        title = "Permission Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/permission detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username= KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);

        ObservableList<Permissions> permissionList = FXCollections.observableArrayList(DBFacade.retrievePermissions());
        POTableView.setItems(permissionList);

        colPermissionID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPermissionID().toString()));
        colPermissions.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPermission()));
        colCompanyID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCompanyID().toString()));

        POTableView.getColumns().setAll(colPermissions,colCompanyID);

        FilteredList<Permissions> filteredData = new FilteredList<>(permissionList, p -> true); // Set the filter Predicate whenever the filter changes.
        POSeaText.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Permissions -> { // If filter text is empty, display all.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Permissions.getPermission().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(Permissions.getCompanyID()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false; // Does not match.
            });
        });//Wrap the FilteredList in a SortedList.
        SortedList<Permissions> sortedData = new SortedList<>(filteredData); //Bind the SortedList comparator to the TableView comparator. Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(POTableView.comparatorProperty()); //Add sorted (and filtered) data to the table.
        POTableView.setItems(sortedData);


    }

    public Integer getsPermissionID() {
        return permissionID;
    }

    public void setsPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

}
