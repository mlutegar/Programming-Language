package supermarketProject.persist;

import supermarketProject.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Product> findAll() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "select * from product"
            );
            rs = pstmt.executeQuery();

            var products = new ArrayList<Product>();
            while(rs.next()) {
                var product = new Product();
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getFloat("price"));
                product.setType(rs.getString("type"));
                product.setProvider(rs.getString("provider"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list product. Error: " + e.getMessage());
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
        return null;
    }

    public ArrayList<Product> findById(long id){
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "select * from product where id = ?"
            );
            pstmt.setInt(1, (int) id);
            rs = pstmt.executeQuery();

            var products = new ArrayList<Product>();
            while(rs.next()) {
                var product = new Product();
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getFloat("price"));
                product.setType(rs.getString("type"));
                product.setProvider(rs.getString("provider"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list product. Error: " + e.getMessage());
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
        return null;
    }

    public Boolean update(Product product, long id){
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "update product set name = ?, quantity = ?, price = ?, type = ?, provider = ? where id = ?;"
            );

            pstmt.setInt(6, (int) id);
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

    public void deleteById(long id){
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "delete from product where id = ?"
            );
            pstmt.setInt(1, (int) id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on delete product. Error: " + e.getMessage());
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public boolean deleteAll(){
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "delete from product where id != 0"
            );

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on delete all products. Error: " + e.getMessage());
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
        return false;
    }
}
