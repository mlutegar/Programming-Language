package supermarketProject.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import supermarketProject.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 07/09/2002
 * @Version: 1.0
 * @Description: Class responsible for inserting and retrieving values from the database
 * */

public class ProductDAO extends DAO {
    private static Logger logger = LoggerFactory.getLogger(ProductDAO.class);
    public boolean save(Product product) {
        var sql = "insert into product(name, quantity, price, type, provider) values (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setFloat(3, product.getPrice());
            pstmt.setString(4, product.getType());
            pstmt.setString(5, product.getProvider());

            logger.debug("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE; // retorna error => 0 | success => 1

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on save product. Error: {}", e.getMessage());
            return Boolean.FALSE;
        }
    }
    public List<Product> findAll() {
        var products = new ArrayList<Product>();
        var sql = "select * from product";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    products.add(setProduct(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on list products. Error: {}", e.getMessage());
            return new ArrayList<>();
        }
        return products;
    }
    public Product findById(long id){
        var sql = "select * from product where id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? setProduct(rs) : new Product();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on find id product. Error: {}", e.getMessage());
            return new Product();
        }
    }
    public List<Product> findByName(String name) {
        var products = new ArrayList<Product>();
        var sql = "select * from product where name like ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, '%' + name + '%');
            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    products.add(setProduct(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on list products. Error: {}", e.getMessage());
            return new ArrayList<>();
        }
        return products;
    }
    public List<Product> findByType(String type) {
        var products = new ArrayList<Product>();
        var sql = "select * from product where type like ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, '%' + type + '%');
            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    products.add(setProduct(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on list products. Error: {}", e.getMessage());
            return new ArrayList<>();
        }
        return products;
    }
    public List<Product> findByProvider(String provider) {
        var products = new ArrayList<Product>();
        var sql = "select * from product where provider like ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, '%' + provider + '%');
            logger.info("Query executada: {}", sql);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    products.add(setProduct(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on list products. Error: {}", e.getMessage());
            return new ArrayList<>();
        }
        return products;
    }
    public Boolean update(Product product, long id){
        var sql = "update product set name = ?, quantity = ?, price = ?, type = ?, provider = ? where id  = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(6, (int) id);
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setFloat(3, product.getPrice());
            pstmt.setString(4, product.getType());
            pstmt.setString(5, product.getProvider());
            logger.info("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on save product. Error: {}", e.getMessage());
            return Boolean.FALSE;
        }
    }
    public Boolean deleteById(long id){
        var sql = "delete from product where id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            logger.info("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on delete product. Error: {}", e.getMessage());
            return Boolean.FALSE;
        }
    }
    public boolean deleteAll(List<Product> products) {
        var sql = "delete from product where id in (?)";
        var sqlIN = products.stream().map(product -> String.valueOf(product.getId())).collect(Collectors.joining(",", "(", ")"));
        sql = sql.replace("(?)", sqlIN);
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            logger.info("Query executada: {}", sql);
            return (pstmt.executeUpdate() != 0) ? Boolean.TRUE : Boolean.FALSE;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error on delete table product. Error: {}", e.getMessage());
            return Boolean.FALSE;
        }
    }
    private Product setProduct(ResultSet rs) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getFloat("price"), rs.getString("type"), rs.getString("provider"), rs.getString("register"));
    }
}
