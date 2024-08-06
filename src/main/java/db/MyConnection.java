package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
   public static Connection connection=null;
   public static Connection getConnection(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       try {
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/File_Hider","root","root");
           System.out.println("Connection Successful");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return connection;

   }

   public static void setConnection(){
       if(connection!=null){
           try{
               connection.close();

           }catch(SQLException ex){
               ex.printStackTrace();

           }
       }
   }

    public static void main(String[] args) {
        MyConnection.getConnection();
    }
}
