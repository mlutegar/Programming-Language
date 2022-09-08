package supermarketProject.app;

import supermarketProject.model.Product;
import supermarketProject.persist.ProductDAO;
import supermarketProject.service.ProductService;

import javax.swing.*;
import java.util.Objects;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 07/09/2002
 * @Version: 1.0
 * @Description: Class responsible for adding new products in the supermarket
 * */

public class App {

    public void insertProduct(){
        Product pro;
        pro = new Product();
        var service = new ProductService();

        // Receive user information
        pro.setName(JOptionPane.showInputDialog(null, "Enter the product name: ", "Input Nome", JOptionPane.QUESTION_MESSAGE));
        pro.setPrice(Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the product price: ", "Input Price", JOptionPane.QUESTION_MESSAGE)));
        pro.setType(JOptionPane.showInputDialog(null, "Enter the product type: ", "Input Type", JOptionPane.QUESTION_MESSAGE));
        pro.setProvider(JOptionPane.showInputDialog(null, "Enter the product provider: ", "Input Provider", JOptionPane.QUESTION_MESSAGE));
        pro.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the product quantity: ", "Input Quantity", JOptionPane.QUESTION_MESSAGE)));

        // Insert information into the database
        var situation = "Recording failed. check the log.";
        var statusIcon = JOptionPane.ERROR_MESSAGE;
        var response = service.save(pro);

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

    public void listProduct(){
        var service = new ProductService();
        System.out.println("\n The products listed in the database are: ");

        service.findAll().forEach(product -> System.out.println(product.getName()));
        var answerList = service.findAll().stream().map(product ->
                "\n\nId: " + product.getId() +
                "\nName: " + product.getName() +
                "\nQuantity: " + product.getQuantity() +
                "\nPrice: R$" + product.getPrice() +
                "\nType: " + product.getType() +
                "\nProvider: " + product.getProvider() +
                "\nRegister: " + product.getRegister()
        ).toList();

        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "Answer", JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchById(){
        var service = new ProductService();

        var id = JOptionPane.showInputDialog(null, "Enter the product id: ", "Input Id", JOptionPane.QUESTION_MESSAGE);
        var product = service.findById(Long.parseLong(id));

        var msg =
                "\n\nId: " + product.getId() +
                "\nName: " + product.getName() +
                "\nQuantity: " + product.getQuantity() +
                "\nPrice: " + product.getPrice() +
                "\nType: " + product.getType() +
                "\nProvider: " + product.getProvider() +
                "\nRegister: " + product.getRegister();
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
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

    public void deleteProductById(){
        var service = new ProductService();

        var id = JOptionPane.showInputDialog(null, "Enter the product id: ", "Input Id", JOptionPane.QUESTION_MESSAGE);
        var delete = service.deleteById(Long.parseLong(id));

        var situationDelete = "Failed to erase. Check the log: ";
        var statusDelete = JOptionPane.ERROR_MESSAGE;

        if(delete){
            situationDelete = "Successfully deleted: ";
            statusDelete = JOptionPane.INFORMATION_MESSAGE;
        }

        var deletebyId = "Recording status at the database: " + situationDelete;
        JOptionPane.showMessageDialog(null, deletebyId, "Answer", statusDelete);
    }

    public void deleteAllProducts(){
        var service = new ProductService();
        var delete = service.deleteAll();

        var situationDelete = "Failed to erase. Check the log: ";
        var statusDelete = JOptionPane.ERROR_MESSAGE;

        if(delete){
            situationDelete = "Successfully deleted:";
            statusDelete = JOptionPane.INFORMATION_MESSAGE;
        }

        var deletebyId = "Recording status at the database:" + situationDelete;
        JOptionPane.showMessageDialog(null, deletebyId, "Answer", statusDelete);
    }

    public static void main(String[] args) {
        var app = new App();

        var choice = " ";

        while (!Objects.equals(choice, "0")){
            choice = JOptionPane.showInputDialog(null, """
                Choose what you want to do:
                1: Insert product
                2: List products
                3: Choose product by id
                4: Update product
                5: Delete product by id
                6: Delete all
                0: Quit""", "Choose an action", JOptionPane.QUESTION_MESSAGE);


            if (Objects.equals(choice, "1"))
                app.insertProduct();
            else if (Objects.equals(choice, "2"))
                app.listProduct();
            else if (Objects.equals(choice, "3"))
                app.searchById();
            else if (Objects.equals(choice, "4"))
                app.updateProduct();
            else if (Objects.equals(choice, "5"))
                app.deleteProductById();
            else if (Objects.equals(choice, "6"))
                app.deleteAllProducts();
        }
    }
}
