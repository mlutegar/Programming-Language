package supermarketProject.app;

import supermarketProject.service.ProductService;

import javax.swing.*;

public class AppDelete {
    public void deleteAllProducts(){
        var service = new ProductService();
        var name = JOptionPane.showInputDialog("Input...");
        var products = service.findByName(name);

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
