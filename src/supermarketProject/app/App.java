package supermarketProject.app;

import supermarketProject.model.Product;
import supermarketProject.persist.ProductDAO;

import javax.swing.*;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 07/09/2002
 * @Version: 1.0
 * @Description: Class responsible for adding new products in the supermarket
 * */

public class App {
    public static void main(String[] args) {
        Product pro;
        pro = new Product();

        var service = new ProductDAO();
        
        pro.setName(JOptionPane.showInputDialog(null, "Enter the product name: ", "Input Nome", JOptionPane.QUESTION_MESSAGE));
        pro.setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the product price: ", "Input Price", JOptionPane.QUESTION_MESSAGE)));
        pro.setType(JOptionPane.showInputDialog(null, "Enter the product type: ", "Input Type", JOptionPane.QUESTION_MESSAGE));
        pro.setProvider(JOptionPane.showInputDialog(null, "Enter the product provider: ", "Input Provider", JOptionPane.QUESTION_MESSAGE));
        pro.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the product quantity: ", "Input Quantity", JOptionPane.QUESTION_MESSAGE)));

        var situation = "Recording failed. check the log.";
        var statusIcon = JOptionPane.ERROR_MESSAGE;
        var response = service.save(pro);

        if(response) {
            situation = "Successfully recorded.";
            statusIcon = JOptionPane.INFORMATION_MESSAGE;
        }

        var msg = "Recording status at the database: " + situation + "\n\n" + "Product.name: " + pro.getName() + "\nProduct.quantity: " + pro.getQuantity() + "\nProduct.price: " + pro.getPrice() + "\nProduct.type: " + pro.getType() + "\nProduct.provider: " + pro.getProvider();
        JOptionPane.showMessageDialog(null, msg, "Answer", statusIcon);

    }
}
