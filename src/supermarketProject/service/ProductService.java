package supermarketProject.service;

import supermarketProject.model.Product;
import supermarketProject.persist.ProductDAO;

import java.util.List;

public class ProductService {
    private ProductDAO dao;

    public ProductService() {
        dao = new ProductDAO();
    }

    public boolean save(Product product) {
        return dao.save(product);
    }

    public List<Product> findAll(){return dao.findAll(); }

    public Product findById(long id) {
        return dao.findById(id);
    }

    public boolean update(Product product, long id){
        return dao.update(product, id);
    }

    public boolean deleteById(long id){ return dao.deleteById(id); }

    public boolean deleteAll() { return dao.deleteAll(); }

}
