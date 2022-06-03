package LaboratoryManagement.Controller;

import LaboratoryManagement.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class assignmentDetails implements Initializable {

    @FXML
    private ImageView logo;

    @FXML
    private Button back;

    @FXML
    private Label coursenamelabel;

    @FXML
    private Label reportlabel;

    @FXML
    private Label experimentnamelabel;

    @FXML
    private Label groupnolabel;

    @FXML
    private Label materialslabel;

    private User tableview;

    public void  initData(User assignmenttable){
        tableview = assignmenttable;
        coursenamelabel.setText(tableview.getCourseName());
        groupnolabel.setText(tableview.getGroupNo().toString());
        experimentnamelabel.setText(tableview.getExpName());
        materialslabel.setText(tableview.getMaterials());
        reportlabel.setText(tableview.getReport());

    }

    @FXML
    void handleback(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        Stage newassign=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/LaboratoryManagement/FXML/AssignmentTable.fxml"));
        Scene sc = new Scene(root);
        newassign.setScene(sc);
        newassign.show();
        newassign.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
