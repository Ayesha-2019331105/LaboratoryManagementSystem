package LaboratoryManagement.Controller;

import DBconnection.DBhandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProfileController {
    @FXML
    protected Label contact;

    @FXML
    protected Label department;

    @FXML
    protected Label fullname;

    @FXML
    protected Label username;

    @FXML
    protected Label address;


    protected Connection conn;
    protected DBhandler handler;
    protected PreparedStatement pst;

    void show(){

    }
    @FXML
    void initialize() {
        handler = new DBhandler();
        show();
//        username.setVisible(true);
//        university.setVisible(true);
//        department.setVisible(true);
//        regnum.setVisible(true);
    }
}
