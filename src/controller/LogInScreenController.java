package controller;

import Persistence.DB;
import Persistence.DBFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LogInScreenController extends Controller {
    @FXML
    TextField loginIDTextField;
    @FXML
    TextField logInPasswordID;




    public void handleLogIn(ActionEvent event) throws Exception {
        if (DBFacade.checkLogin(true, loginIDTextField.getText(), logInPasswordID.getText())) {
            System.out.println("new window");
            String permissionValue = DBFacade.checkPermission(loginIDTextField.getText());
            FXMLLoader fxmlLoader = null;

                switch(permissionValue) {
                    case "SmartAdmin":
                        System.out.println("permission identified... \nSmartAdmin, directing you to company overview");
                        break;
                    case "Admin":
                        System.out.println("permission identified... \nAdmin, directing you to company overview");
                        break;
                    case "HR":
                        System.out.println("permission identified... \nHuman resources directing you to permission overview");
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/permission overview.fxml"));
                        break;
                    case "Interviewer":
                        System.out.println("permission identified... \nInterviewer directing you to company overview");
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/company overview.fxml"));
                        break;
                    default:
                        System.out.println("permission identified... \nGuest, directing you to logged user detail");
                        fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/logged user detail screen overview.fxml"));
                        break;
                }
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                }
                else System.out.println("no window");

        }
    }
