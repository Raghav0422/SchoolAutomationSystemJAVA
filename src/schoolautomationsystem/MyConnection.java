package schoolautomationsystem;

import java.sql.SQLException;

public class MyConnection {
    java.sql.PreparedStatement pre_s;
    java.sql.Statement stm;
    java.sql.Connection conn;
    java.sql.ResultSetMetaData rs_md;
    java.sql.ResultSet r_set;
    public MyConnection(){
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/sas","root","2000raghav22");
             System.out.println("connection with mySql Established");
        } catch (ClassNotFoundException | SQLException ex) {
            //javax.swing.JOptionPane.showMessageDialog(null,"Connection not established\n"+ex, "Error",2);
            ex.getStackTrace();
        }
    }
}
