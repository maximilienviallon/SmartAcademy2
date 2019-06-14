package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * class for log in controller.
 */
public class LogBrowserController  extends Controller implements Initializable {
    String title;
    FXMLLoader fxmlLoader;
    String username;

    /**
     * this method is handling the "back to overview" button.
     * @param actionEvent
     * @throws IOException
     */
    public void logBackToOverviewHandle(ActionEvent actionEvent) throws IOException {
        title = "Employee Overview";
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
        fxmlLoading(fxmlLoader,title);
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    /**
     * this method is handling the "export" button.
     * @param actionEvent
     */
    public void logExportHandle(ActionEvent actionEvent) {
        saveCSV();
    }

    /**
     * this method is handling the "print" button.
     * @param actionEvent
     */
    public void logPrintHandle(ActionEvent actionEvent) {
        printScreen();
    }

    /**
     * initializes.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username = KeeperOfKeys.getLoggedUserNameInstance().currentLoggedUserName().getUserName();
        System.out.println(username);
    }
}
