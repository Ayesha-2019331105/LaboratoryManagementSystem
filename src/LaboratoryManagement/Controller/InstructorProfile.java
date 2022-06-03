package LaboratoryManagement.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstructorProfile extends ProfileController{

    @FXML
    private Label designation;

    @Override
    void show(){
        conn = handler.getConnection();
        String s1 = "SELECT * from instructor where username=? and password=?";
        try {
            pst = conn.prepareStatement(s1);
            pst.setString(1,loginController.USERID);
            pst.setString(2,loginController.PASS);
            ResultSet rs = pst.executeQuery();
            rs.next();
            username.setText("Username: " + loginController.USERID);
            fullname.setText("Name: " + rs.getString("name"));
            contact.setText("Contact: " + rs.getString("contact"));
            address.setText("Address: " + rs.getString("address"));
            designation.setText("Designation: " + rs.getString("designation"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
