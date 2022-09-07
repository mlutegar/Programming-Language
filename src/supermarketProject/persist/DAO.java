package supermarketProject.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 07/09/2002
 * @Version: 1.0
 * @Description: Class responsible for opening the connection to the database
 * */

public class DAO {

    public DAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.err.println("Class not found. Error: " + cnfe.getMessage());
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/db01", "root", "");
    }
}
