package LaboratoryManagement.Controller;

import DBconnection.DBhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class assignmentAssign {
    public TextArea assignment;

    public TextField coursename;

    public DatePicker date;

    public TextField groupno;

    @FXML
    private Button back;

    @FXML
    private Button save;

    @FXML
    private TextField expName;


    public Connection conn;
    public DBhandler handler;
    public PreparedStatement pst;

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        Stage newassign=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/TeacherProfile.fxml"));
        Scene sc = new Scene(root);
        newassign.setScene(sc);
        newassign.show();
        newassign.setResizable(false);

    }

    @FXML
    void saveAssignment(ActionEvent event) {
        String tableName = coursename.getText();
        String ss = "SELECT * from courselist where courseName = ?";
        try {
            pst = conn.prepareStatement(ss);
            pst.setString(1,tableName);
            ResultSet rs = pst.executeQuery();
            if (!rs.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("No such course is found!");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String stm;
        stm = "INSERT INTO " + tableName + "(groupno,expName,assignment,date)"
                +"VALUES (?,?,?,?)";
        try {
            pst = conn.prepareStatement(stm);
            pst.setInt(1,Integer.parseInt(groupno.getText()));
            pst.setString(2,expName.getText());
            pst.setString(3,assignment.getText());
            pst.setDate(4, Date.valueOf(date.valueProperty().get()));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        handler = new DBhandler();
        conn = handler.getConnection();
    }
}
