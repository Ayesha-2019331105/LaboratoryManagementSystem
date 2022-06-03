package LaboratoryManagement.Controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class TeacherSignUpController extends SignUpController{

    @FXML
    private TextField department;

    @FXML
    private TextField salary;

    @FXML
    private TextField designation;

    public void handlesignup() {
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        if((Objects.equals(username.getText(), "")) || (Objects.equals(name.getText(), "")) || (Objects.equals(designation.getText(), "")) || (Objects.equals(salary.getText(), ""))
                || (Objects.equals(contact.getText(), "")) || (Objects.equals(password.getText(), "")) || (Objects.equals(department.getText(), ""))
                || (Objects.equals(address.getText(), "")) || Err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Fill up all information");
            alert.show();
        }
        else {
            pt.setOnFinished(ev -> System.out.println("SignUp successfully"));
            pt.play();
            //saving data
            String insert = "INSERT INTO teacher(name,username,password,contact,gender,department,address,designation,salary)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";

            conn = handler.getConnection();

            try {
                pst = conn.prepareStatement(insert);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                pst.setString(1, name.getText());
                pst.setString(2, username.getText());
                pst.setString(3, password.getText());
                pst.setString(4, contact.getText());
                pst.setString(5, getGender());
                pst.setString(6, department.getText());
                pst.setString(7, address.getText());
                pst.setString(8, designation.getText());
                pst.setString(9, salary.getText());

                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    void checkDuplicate(KeyEvent event) {
        super.checkDuplicate(event);
        super.stm = stm + "teacher where username=?";
        try {
            pst = conn.prepareStatement(super.stm);
            pst.setString(1,super.uniqueUsername);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Username is duplicate!");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
