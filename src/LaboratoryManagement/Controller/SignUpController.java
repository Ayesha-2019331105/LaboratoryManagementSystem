package LaboratoryManagement.Controller;

import DBconnection.DBhandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    protected TextField address;

   @FXML
    protected Button backHomepage;

   @FXML
    protected TextField name;

    @FXML
    protected ResourceBundle resources;

    @FXML
    protected PasswordField password;

    @FXML
    protected TextField username;

    @FXML
    protected RadioButton female;

    @FXML
    protected RadioButton male;

    @FXML
    protected Button signup;

    @FXML
    protected TextField contact;

    protected Connection conn;
    protected DBhandler handler;
    protected PreparedStatement pst;
    static boolean signedUp;
    public void handleBackHomepage() throws IOException {
    backHomepage.getScene().getWindow().hide();
    Stage login = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/HomePage.fxml"));
    Scene sc = new Scene(root);
    login.setScene(sc);
    login.show();
}

    @FXML
    void initialize() {

        handler = new DBhandler();
        conn = handler.getConnection();
        signedUp = false;
    }
    static boolean Err;
    public String getGender(){
        String gen = "";
        if (male.isSelected()){
            gen = "Male";
        }else if(female.isSelected()){
            gen = "Female";
        }else{
            Err = true;
        }
        return gen;
    }

    String uniqueUsername, stm;
    @FXML
    void checkDuplicate(KeyEvent event) {
       uniqueUsername =  username.getText();
       stm = "SELECT * from ";
    }

}