package controller;


import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class LogInController extends Controller {
    @FXML
    TextField loginIDTextField;
    @FXML
    TextField logInPasswordID;
    String title;



    public void handleLogIn(ActionEvent event) throws Exception {
        if (DBFacade.checkLogin(true, loginIDTextField.getText(), logInPasswordID.getText())) {
            System.out.println("new window");
            String permissionValue = DBFacade.checkPermission(loginIDTextField.getText());
            FXMLLoader fxmlLoader = null;

                switch(permissionValue) {
                    case "SmartAdmin":
                        System.out.println("permission identified... \nSmartAdmin, directing you to company overview");
                        title = "Company overview";
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                        break;
                    case "Admin":
                        System.out.println("permission identified... \nAdmin, directing you to company overview");
                        title = "Company overview";
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                        break;
                    case "HR":
                        System.out.println("permission identified... \nHuman resources directing you to permission overview");
                        title = "Permission overview";
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/permission overview.fxml"));
                        break;
                    case "Interviewer":
                        System.out.println("permission identified... \nInterviewer directing you to company overview");
                        title = "Company overview";
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                        break;
                    default:
                        System.out.println("permission identified... \nGuest, directing you to logged user detail");
                        title = "logged user detail overview";
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail screen overview.fxml"));
                        break;
                }
                   fxmlLoading(fxmlLoader,title);

                }
                else System.out.println("no window");

        }

    public void logInButtonHandle(ActionEvent actionEvent) {
    }
}
