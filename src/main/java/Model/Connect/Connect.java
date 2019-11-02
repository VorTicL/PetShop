/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author João
 */
public class Connect {

    public static Connection connect() {

        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://wm63be5w8m7gs25a.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/z5c32cq2n3788otg";
            String user = "uc2z0ljujh5n6x1k";
            String password = "imet5dkp9xdmypse";

            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException sc) {
            return null;
        }
    }
}
