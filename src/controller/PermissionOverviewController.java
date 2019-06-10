package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PermissionOverviewController  extends Controller implements Initializable {

    FXMLLoader fxmlLoader;
    String title;

    public void POSetButHandle(ActionEvent actionEvent) throws IOException {
        title = "Logged User Detail Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POEduOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/education overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POAppOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Apprentice Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POUseOverButHandle(ActionEvent actionEvent)throws IOException{
        title = "User Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/user overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POComOverButHandle(ActionEvent actionEvent) throws IOException{
        title = "Company Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
        fxmlLoading(fxmlLoader,title);
    }

    public void POExpCsvButHandle(ActionEvent actionEvent) {
    }

    public void POPrintButHandle(ActionEvent actionEvent) {
    }

    public void POCreaNewButHandle(ActionEvent actionEvent) throws IOException{
    }

    public void POSelectButHandle(ActionEvent actionEvent) throws IOException{
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userName = KeeperOfKeys.getUserNameInstance().currentUserName().getUserName();
        System.out.println(userName);
    }
}
