package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserModificationController  extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;


    public void UMSavButHandle(ActionEvent actionEvent) throws IOException {
        title = "Employee Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UMRemButHandle(ActionEvent actionEvent) {

    }

    public void UMAddButHandle(ActionEvent actionEvent) {
    }

    public void UMBacToOveButHandle(ActionEvent actionEvent) throws IOException{
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UMBacToDetButHandle(ActionEvent actionEvent) throws IOException{
        title = "Employee Detail";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice detail.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void UMDelButHandle(ActionEvent actionEvent)  throws IOException{
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }
}
