package controller;

import Domain.Companies;
import Persistence.DBFacade;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class CompanyOverviewController implements Initializable {
    @FXML
    public LogInScreenController logInCont;
    @FXML
    TableView ComOTableView = new TableView();
    TableColumn<Companies,String> colName= new TableColumn<>();
    TableColumn<Companies,String> colFieldOfExp= new TableColumn<>();
    TableColumn<Companies,String> colZipcode= new TableColumn<>();
    TableColumn<Companies,String> colCvr= new TableColumn<>();
    TableColumn<Companies,String> colPNumber= new TableColumn<>();
    TableColumn<Companies,String> colCity= new TableColumn<>();





    @Override
    public void initialize(URL location, ResourceBundle resources) {
       String userName =  KeeperOfKeys.getInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}


