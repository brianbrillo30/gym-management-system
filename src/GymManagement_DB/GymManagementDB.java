/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GymManagement_DB;

/**
 *
 * @author Wang
 */
//Database Connection
import java.sql.Connection;
import java.sql.DriverManager;

public class GymManagementDB {
    
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/gym_management_system";
    static String uname = "root";
    static String pass = "";
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,uname, pass);
        }
        return con;
    }    
    
}
