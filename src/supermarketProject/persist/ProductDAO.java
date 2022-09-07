package supermarketProject.persist;

import supermarketProject.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 07/09/2002
 * @Version: 1.0
 * @Description: Class responsible for inserting and retrieving values from the database
 * */

public class ProductDAO extends DAO {
    private Connection conn;

    public boolean save(Product product) {
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "insert into product(name, quantity, price, type, provider) values (?, ?, ?, ?, ?)"
            );

            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setFloat(3, product.getPrice());
            pstmt.setString(4, product.getType());
            pstmt.setString(5, product.getProvider());

            var response = pstmt.executeUpdate();
            if(response != 0)
                return Boolean.TRUE;
            return Boolean.FALSE;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on save product. Error: " + e.getMessage());
            return Boolean.FALSE;
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

}
