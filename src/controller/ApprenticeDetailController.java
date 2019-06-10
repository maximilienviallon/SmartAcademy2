package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApprenticeDetailController  extends Controller implements Initializable {
    FXMLLoader fxmlLoader;
    String title;
    String username;
    public void backToApprenticeOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ApprenticeExportHandle(ActionEvent actionEvent) {
    }

    public void ApprenticePrintHandle(ActionEvent actionEvent) {
    }

    public void ApprenticeEditHandle(ActionEvent actionEvent) throws IOException {
        title = "Employee Modification";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice modification.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void ApprenticeRemoveHandle(ActionEvent actionEvent) throws IOException {
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice Overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(userName);
    }
}
