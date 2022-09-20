package supermarketProject.app;

import supermarketProject.model.Product;
import supermarketProject.service.ProductService;

import javax.swing.*;

public class AppData {
    public void insert(){
        var service = new ProductService();
        Product pro;

        pro = new Product();
        pro.setName(JOptionPane.showInputDialog(null, "Enter the product name: ", "Input Nome", JOptionPane.QUESTION_MESSAGE));
        pro.setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the product price: ", "Input Price", JOptionPane.QUESTION_MESSAGE)));
        pro.setType(JOptionPane.showInputDialog(null, "Enter the product type: ", "Input Type", JOptionPane.QUESTION_MESSAGE));
        pro.setProvider(JOptionPane.showInputDialog(null, "Enter the product provider: ", "Input Provider", JOptionPane.QUESTION_MESSAGE));
        pro.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the product quantity: ", "Input Quantity", JOptionPane.QUESTION_MESSAGE)));

        var situation = "Recording failed. check the log.";
        var statusIcon = JOptionPane.ERROR_MESSAGE;

        var response = service.save(pro);
        if (response) {
            situation = "Successfully recorded.";
            statusIcon = JOptionPane.INFORMATION_MESSAGE;
        }

        var msg =
                "Recording status at the database: " + situation + "\n\n" +
                        "Name: " + pro.getName() +
                        "\nQuantity: " + pro.getQuantity() +
                        "\nPrice: R$" + pro.getPrice() +
                        "\nType: " + pro.getType() +
                        "\nProvider: " + pro.getProvider();

        JOptionPane.showMessageDialog(null, msg, "Answer", statusIcon);
    }
    public void updateProduct(){
        Product pro;
        pro = new Product();
        var service = new ProductService();

        // Choose the product id you want to change
        var id = JOptionPane.showInputDialog(null, "Enter the product id: ", "Input Id", JOptionPane.QUESTION_MESSAGE);

        // Receive user information
        pro.setName(JOptionPane.showInputDialog(null, "Enter the product name: ", "Input Nome", JOptionPane.QUESTION_MESSAGE));
        pro.setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the product price: ", "Input Price", JOptionPane.QUESTION_MESSAGE)));
        pro.setType(JOptionPane.showInputDialog(null, "Enter the product type: ", "Input Type", JOptionPane.QUESTION_MESSAGE));
        pro.setProvider(JOptionPane.showInputDialog(null, "Enter the product provider: ", "Input Provider", JOptionPane.QUESTION_MESSAGE));
        pro.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the product quantity: ", "Input Quantity", JOptionPane.QUESTION_MESSAGE)));

        // Insert information into the database
        var situation = "Recording failed. check the log.";
        var statusIcon = JOptionPane.ERROR_MESSAGE;
        var response = service.update(pro, Long.parseLong(id));

        if(response) {
            situation = "Successfully recorded.";
            statusIcon = JOptionPane.INFORMATION_MESSAGE;
        }

        var msg =
                "Recording status at the database: " + situation + "\n\n" +
                        "Name: " + pro.getName() +
                        "\nQuantity: " + pro.getQuantity() +
                        "\nPrice: R$" + pro.getPrice() +
                        "\nType: " + pro.getType() +
                        "\nProvider: " + pro.getProvider();

        JOptionPane.showMessageDialog(null, msg, "Answer", statusIcon);
    }
}
