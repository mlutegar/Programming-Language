package supermarketProject.app;

import supermarketProject.service.ProductService;

import javax.swing.*;

public class AppSearch {
    public void searchById(){
        var service = new ProductService();
        var id = JOptionPane.showInputDialog(null, "Enter the product id: ", "Input Id", JOptionPane.QUESTION_MESSAGE);
        var pro = service.findById(4L);

        var msg =
                "\n\nId: " + pro.getId() +
                "\nName: " + pro.getName() +
                "\nQuantity: " + pro.getQuantity() +
                "\nPrice: " + pro.getPrice() +
                "\nType: " + pro.getType() +
                "\nProvider: " + pro.getProvider() +
                "\nRegister: " + pro.getRegister();
        JOptionPane.showMessageDialog(null, msg, "Answer", JOptionPane.INFORMATION_MESSAGE);
    }
    public void listProduct(){
        var service = new ProductService();
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
        System.out.println("\n The products listed in the database are: ");
        service.findAll().forEach(product -> System.out.println(product.getName()));
    }
    public void searchByName(){
        var service = new ProductService();
        var name = JOptionPane.showInputDialog(null, "Enter the product name: ", "Input name: " , JOptionPane.QUESTION_MESSAGE);
        var answerList = service.findByName(name).stream().map(product ->
                "\n\nId: " + product.getId() +
                        "\nName: " + product.getName() +
                        "\nQuantity: " + product.getQuantity() +
                        "\nPrice: R$" + product.getPrice() +
                        "\nType: " + product.getType() +
                        "\nProvider: " + product.getProvider() +
                        "\nRegister: " + product.getRegister()
        ).toList();
        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "answer", JOptionPane.INFORMATION_MESSAGE);
    }
    public void searchByProvider(){
        var service = new ProductService();
        var provider = JOptionPane.showInputDialog(null, "Enter the product name: ", "Input name: " , JOptionPane.QUESTION_MESSAGE);
        var answerList = service.findByProvider(provider).stream().map(product ->
                "\n\nId: " + product.getId() +
                        "\nName: " + product.getName() +
                        "\nQuantity: " + product.getQuantity() +
                        "\nPrice: R$" + product.getPrice() +
                        "\nType: " + product.getType() +
                        "\nProvider: " + product.getProvider() +
                        "\nRegister: " + product.getRegister()
        ).toList();
        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "answer", JOptionPane.INFORMATION_MESSAGE);
    }
    public void searchByType(){
        var service = new ProductService();
        var type = JOptionPane.showInputDialog(null, "Enter the product name: ", "Input name: " , JOptionPane.QUESTION_MESSAGE);
        var answerList = service.findByType(type).stream().map(product ->
                "\n\nId: " + product.getId() +
                        "\nName: " + product.getName() +
                        "\nQuantity: " + product.getQuantity() +
                        "\nPrice: R$" + product.getPrice() +
                        "\nType: " + product.getType() +
                        "\nProvider: " + product.getProvider() +
                        "\nRegister: " + product.getRegister()
        ).toList();
        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "answer", JOptionPane.INFORMATION_MESSAGE);
    }
}
