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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompanyOverviewController extends Controller implements Initializable {
    @FXML
    public LogInController logInCont;
    @FXML
    TableView ComOTableView = new TableView();
    @FXML
    TableColumn<Companies, String> colName = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colFieldOfExp = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colZipcode = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colCVR = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colPNumber = new TableColumn<>();
    @FXML
    TableColumn<Companies, String> colCity = new TableColumn<>();

    FXMLLoader fxmlLoader;
    String title;
    String userName;


    public void ComOSetButHandle(ActionEvent actionEvent) throws IOException{
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ComOAppOverButHandle(ActionEvent actionEvent)throws IOException {
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ComOUseOverButHandle(ActionEvent actionEvent) throws IOException {
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ComOEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Education Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ComOExpCsvButHandle(ActionEvent actionEvent) {
        ArrayList<Apprentices> unobservable2 = DBFacade.retrieveApprentices(6);
        System.out.println(unobservable2.get(0).getName());
        System.out.println(unobservable2.get(1).getName());
        System.out.println(unobservable2.get(2).getName());
    }

    public void ComOPrintButHandle(ActionEvent actionEvent) {
        ArrayList<Companies> unobservable = DBFacade.retrieveCompanies(DBFacade.checkYourPrivilege(userName));
        System.out.println(unobservable.get(0).getCvr());
        System.out.println(unobservable.get(1).getName());
        System.out.println(unobservable.get(1).getCvr());
        System.out.println(unobservable.get(2).getFieldOfExpertise());
    }

    public void ComOCreaNewButHandle(ActionEvent actionEvent) throws IOException{
    }

    public void ComOSelectButHandle(ActionEvent actionEvent) throws IOException{
    }

    public void ComOConOButHandle(ActionEvent actionEvent) throws IOException{
        title = "Contact Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/contact overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName = KeeperOfKeys.getInstance().currentUserName().getUserName();

        ObservableList companyList = FXCollections.observableArrayList(DBFacade.retrieveCompanies(DBFacade.checkYourPrivilege(userName)));

        ComOTableView.setItems(companyList);

        colName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        colCity.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCity()));
        colCVR.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCvr()));
        colFieldOfExp.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFieldOfExpertise()));
        colPNumber.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getpNum()));
        colZipcode.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getZipcode()));
        ComOTableView.getColumns().setAll(colName,colCity,colCVR,colFieldOfExp,colPNumber,colZipcode);
    }



   
}





