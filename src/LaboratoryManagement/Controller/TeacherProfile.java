package LaboratoryManagement.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherProfile extends ProfileController{

    @FXML
    private Button logout;

    @FXML
    private Button group;

    @FXML
    private Label address;

    @FXML
    private Label designation;

    @FXML
    private Button report;

    @FXML
    private Button assignment;

    @FXML
    private Button Course;

    @Override
    void show(){
        conn = handler.getConnection();
        String s1 = "SELECT * from teacher where username=? and password=?";
        try {
            pst = conn.prepareStatement(s1);
            pst.setString(1,loginController.USERID);
            pst.setString(2,loginController.PASS);
            ResultSet rs = pst.executeQuery();
            rs.next();
            username.setText("Username: " + loginController.USERID);
            fullname.setText("Name: " + rs.getString("name"));
            department.setText("Department: " + rs.getString("department"));
            contact.setText("Contact: " + rs.getString("contact"));
            address.setText("Address: " + rs.getString("address"));
            designation.setText("Designation: " + rs.getString("designation"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void addCourse(ActionEvent event) throws IOException {
        Course.getScene().getWindow().hide();
        Stage newassign=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/Addcourse.fxml"));
        Scene sc = new Scene(root);
        newassign.setScene(sc);
        newassign.show();
        newassign.setResizable(false);
    }

    @FXML
    void assignGroup(ActionEvent event) {

    }

    @FXML
    void assignassignment(ActionEvent event) throws Exception{

        assignment.getScene().getWindow().hide();
        Stage newassign=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/AssignmentAssign.fxml"));
        Scene sc = new Scene(root);
        newassign.setScene(sc);
        newassign.show();
        newassign.setResizable(false);

    }

    @FXML
    void handlelogout(ActionEvent event) throws IOException {
        logout.getScene().getWindow().hide();
        Stage newassign=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/login.fxml"));
        Scene sc = new Scene(root);
        newassign.setScene(sc);
        newassign.show();
        newassign.setResizable(false);
    }

    @FXML
    void showReports(ActionEvent event) {

    }

}
