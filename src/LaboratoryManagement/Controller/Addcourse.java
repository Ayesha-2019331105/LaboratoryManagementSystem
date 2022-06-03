package LaboratoryManagement.Controller;

import DBconnection.DBhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Addcourse {
    @FXML
    private Button back;

    @FXML
    private TextField code;

    @FXML
    private TextField courseName;

    @FXML
    private TextField credit;

    @FXML
    private TextField teacher;

    @FXML
    private Button save;

    public Connection conn;
    public DBhandler handler;
    public PreparedStatement pst;

    @FXML
    void checkDigCode(KeyEvent event) {
        String ch = code.getText();
        if(!(ch.matches("[0-9]*"))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Only digits are allowed!");
            alert.show();
        }
    }

    @FXML
    void checkDigCredit(KeyEvent event) {
        String ch = credit.getText();
        if(!(ch.matches("[0-9]*"))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Only digits are allowed!");
            alert.show();
        }
    }

    @FXML
    void saveCourse(ActionEvent event) {

        courseName.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toLowerCase());
            return change;
        }));
        String stm = "INSERT INTO courselist(courseName,courseCode,teacherName,credit)"+ "VALUES (?,?,?,?)";
        try {
            pst = conn.prepareStatement(stm);
            pst.setString(1,courseName.getText());
            pst.setString(2,code.getText());
            pst.setString(3,teacher.getText());
            pst.setString(4,credit.getText());
            pst.executeUpdate();
            System.out.println("Course Added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tableName = courseName.getText();
        String st = " CREATE TABLE " + tableName
                + "(idCourse INT NOT NULL AUTO_INCREMENT,"
                +"groupno INT NOT NULL,"
                +"expName VARCHAR(45) NOT NULL,"
                + "assignment VARCHAR(255) NOT NULL,"
                +"date DATETIME NOT NULL,"
                + "PRIMARY KEY (idCourse))";
        try {
            Statement sql = conn.createStatement();
            sql.executeUpdate(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleback(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        Stage newassign=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/TeacherProfile.fxml"));
        Scene sc = new Scene(root);
        newassign.setScene(sc);
        newassign.show();
        newassign.setResizable(false);
    }

    @FXML
    void initialize() {
        handler = new DBhandler();
        conn = handler.getConnection();
    }
}
