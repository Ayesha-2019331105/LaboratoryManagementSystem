package LaboratoryManagement.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentProfile extends ProfileController{

    @FXML
    private ImageView studentImg;

    @FXML
    private Button logout;

    @FXML
    private Button assignment;

    @FXML
    private Button overview;

    @FXML
    private Button result;

    @FXML
    private Label err;

    @FXML
    private Label regnum;

    @FXML
    private Label university;

    static String course;
    static Integer grpno;

    @Override
    void show(){
        conn = handler.getConnection();
        String s1 = "SELECT * from student where username=? and password=?";
        try {
            pst = conn.prepareStatement(s1);
            pst.setString(1,loginController.USERID);
            pst.setString(2,loginController.PASS);
            ResultSet rs = pst.executeQuery();
            rs.next();
            grpno = rs.getInt("groupno");
            username.setText("Username: " + loginController.USERID);
            fullname.setText("Name: " + rs.getString("name"));
            university.setText("University name: " + rs.getString("university"));
            department.setText("Department: " + rs.getString("department"));
            regnum.setText("RegNo.: " +rs.getString("registration"));
            contact.setText("Contact: " + rs.getString("contact"));
            InputStream imageData = rs.getBinaryStream("studentImg");
            Image img = new Image(imageData);
            studentImg.setImage(img);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField coursename;
    @FXML
    void handleAssignment(ActionEvent event) throws Exception{
        String ss = "SELECT * from courselist where courseName = ?";
        try {
            pst = conn.prepareStatement(ss);
            pst.setString(1,course);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()){
                err.setVisible(true);
            }
            else{
                assignment.getScene().getWindow().hide();
                Stage assgn = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/assignmentTable.fxml"));
                Scene sc = new Scene(root);
                assgn.setScene(sc);
                assgn.show();
                //assgn.setResizable(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleOverview(ActionEvent event) throws Exception{

    }

    @FXML
    void handleResult(ActionEvent event) throws Exception{

    }

    @FXML
    void handlelogout(ActionEvent event) throws IOException {
        logout.getScene().getWindow().hide();
        Stage newassign=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/login.fxml"));
        Scene sc = new Scene(root);
        newassign.setScene(sc);
        newassign.show();
        //newassign.setResizable(false);
    }


    @FXML
    void coursenameAction(KeyEvent event) {
        coursename.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toLowerCase());
            return change;
        }));
        course = coursename.getText();
    }
}
