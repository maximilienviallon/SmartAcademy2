package controller;


import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInController extends Controller {
    @FXML
    TextField loginIDTextField;
    @FXML
    public TextField logInPasswordID;



    private String userName;
    String title;






    public void logInButtonHandle(ActionEvent actionEvent) throws IOException {
        KeeperOfKeys.getInstance().currentUserName().setUserName(loginIDTextField.getText());

        if (DBFacade.checkLogin(true, loginIDTextField.getText(), logInPasswordID.getText())) {
            System.out.println("new window");
            String permissionValue = DBFacade.checkPermission(loginIDTextField.getText());
            FXMLLoader fxmlLoader;
            switch(permissionValue) {
                case "SmartAdmin":
                    System.out.println("permission identified... \nSmartAdmin, directing you to company overview");
                    title = "Company Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                    break;
                case "Administrator":
                    System.out.println("permission identified... \nAdmin, directing you to company overview");
                    title = "Company Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                    break;
                case "HR":
                    System.out.println("permission identified... \nHuman resources directing you to apprentice overview");
                    title = "Apprentice Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/apprentice overview.fxml"));
                    break;
                case "Interviewer":
                    System.out.println("permission identified... \nInterviewer directing you to company overview");
                    title = "Company Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                    break;
                default:
                    System.out.println("permission identified... \nGuest, directing you to logged user detail");
                    title = "Logged User Detail Overview";
                    fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail.fxml"));
                    break;
            }
            fxmlLoading(fxmlLoader,title);
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        else System.out.println("no window");

}

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }
}