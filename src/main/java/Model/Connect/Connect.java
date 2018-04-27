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
            String url = "jdbc:mysql://localhost:3306/petshop";
            String user = "root";
            String password = "";

            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException sc) {
            return null;
        }
    }
}
