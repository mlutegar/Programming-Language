package supermarketProject.app;

import supermarketProject.service.ProductService;

import javax.swing.*;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 20/09/2022
 * @Version: 1.0
 * @Description: Class responsible for delete products in the supermarket
 * */

public class AppDelete {
    public void deleteAllProducts(){
        var service = new ProductService();
        var products = service.findByName("");
        var status = service.deleteAll(products);
        var msg = "Status: " + (status ? "Successfully" : "Failed");
        JOptionPane.showMessageDialog(null, msg, "Answer", JOptionPane.INFORMATION_MESSAGE);
    }
    public void deleteProductById(){
        var service = new ProductService();
        var id = JOptionPane.showInputDialog(null, "Enter the product id: ", "Input Id", JOptionPane.QUESTION_MESSAGE);
        var status = service.deleteById(Long.parseLong(id));

        var msg = "Status" + (status ? "Successfully" : "Failed");
        JOptionPane.showMessageDialog(null, msg, "Answer", JOptionPane.INFORMATION_MESSAGE);
    }

}
