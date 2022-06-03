module laboratoryManagement {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.java;
    opens LaboratoryManagement;
    opens LaboratoryManagement.Controller;
}