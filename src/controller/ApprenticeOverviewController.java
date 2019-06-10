package controller;

import Domain.Apprentices;
import Domain.Companies;
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


public class ApprenticeOverviewController  extends Controller implements Initializable {
    @FXML
    TableView AOTableView = new TableView();
    @FXML
    TableColumn<Apprentices,String> colCPR = new TableColumn();
    @FXML
    TableColumn<Apprentices,String> colName = new TableColumn();
    @FXML
    TableColumn<Apprentices,String> colEmail = new TableColumn();
    @FXML
    TableColumn<Apprentices,String> colPhone = new TableColumn();
    @FXML
    TableColumn <Apprentices,String> colCompID = new TableColumn();

    FXMLLoader fxmlLoader;
    String title;
    Integer CompanyID;

    public void AOSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void AOEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void AOUseOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void AOComOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void AOExpCsvButHandle(ActionEvent actionEvent) {
    }

    public void AOPrintButHandle(ActionEvent actionEvent) {
    }

    public void AOCreaNewButHandle(ActionEvent actionEvent) throws IOException{
    }

    public void AOSelectButHandle(ActionEvent actionEvent) throws IOException{
    }

    public void AODisMatButHandle(ActionEvent actionEvent) throws IOException{
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CompanyID = KeeperOfKeys.getCompanyIDInstance().currentCompanyID().getsCompanyID();
        System.out.println(CompanyID);
        ObservableList companyList = FXCollections.observableArrayList(DBFacade.retrieveApprentices());

        AOTableView.setItems(companyList);

        colCPR.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCPR()));
        colName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        colEmail.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEmail()));
        colPhone.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPhone()));
        colCompID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCompanyID().toString()));

        AOTableView.getColumns().setAll(colCPR,colName,colEmail,colPhone,colCompID);
    }
}
