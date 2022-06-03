package DBconnection;

import java.sql.*;

public class DBhandler extends configs{
     Connection dbConnection;
     public Connection getConnection(){
          String connString = "jdbc:mysql://" + this.dbhost + ":" + this.dbport + "/" + this.dbname;
          try {
               Class.forName("com.mysql.cj.jdbc.Driver");
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          }
          try {
               dbConnection = DriverManager.getConnection(connString,this.dbuser, this.bdpassword);
          } catch (SQLException e) {
               e.printStackTrace();
          }
          return dbConnection;
     }

}
