package supermarketProject.app;

import supermarketProject.model.Product;
import supermarketProject.service.ProductService;

import javax.swing.*;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 20/09/2022
 * @Version: 1.0
 * @Description: Class responsible for search products in the supermarket
 * */

public class AppSearch {
    public void searchById(){
        var service = new ProductService();
        var id = JOptionPane.showInputDialog(null, "Enter the product id: ", "Input Id", JOptionPane.QUESTION_MESSAGE);
        var pro = service.findById(Long.parseLong(id));

        var msg =
                getProduct(pro);
        JOptionPane.showMessageDialog(null, msg, "Answer", JOptionPane.INFORMATION_MESSAGE);
    }
    public void listProduct(){
        var service = new ProductService();
        var answerList = service.findAll().stream().map(AppSearch::getProduct
        ).toList();
        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "Answer", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("\n The products listed in the database are: ");
        service.findAll().forEach(product -> System.out.println(product.getName()));
    }
    public void searchByName(){
        var service = new ProductService();
        var name = JOptionPane.showInputDialog(null, "Enter the product name: ", "Input name: " , JOptionPane.QUESTION_MESSAGE);
        var answerList = service.findByName(name).stream().map(AppSearch::getProduct
        ).toList();
        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "answer", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("\n The products listed in the database are: ");
        service.findByName(name).forEach(product -> System.out.println(product.getName()));
    }
    public void searchByProvider(){
        var service = new ProductService();
        var provider = JOptionPane.showInputDialog(null, "Enter the product name: ", "Input name: " , JOptionPane.QUESTION_MESSAGE);
        var answerList = service.findByProvider(provider).stream().map(AppSearch::getProduct
        ).toList();
        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "answer", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("\n The products listed in the database are: ");
        service.findByProvider(provider).forEach(product -> System.out.println(product.getName()));
    }
    public void searchByType(){
        var service = new ProductService();
        var type = JOptionPane.showInputDialog(null, "Enter the product name: ", "Input name: " , JOptionPane.QUESTION_MESSAGE);
        var answerList = service.findByType(type).stream().map(AppSearch::getProduct
        ).toList();
        JOptionPane.showMessageDialog(null, answerList.toString().replace("[","").replace("]",""), "answer", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("\n The products listed in the database are: ");
        service.findByType(type).forEach(product -> System.out.println(product.getName()));
    }

    private static String getProduct(Product product) {
        return "\n\nId: " + product.getId() +
                "\nName: " + product.getName() +
                "\nQuantity: " + product.getQuantity() +
                "\nPrice: R$" + product.getPrice() +
                "\nType: " + product.getType() +
                "\nProvider: " + product.getProvider() +
                "\nRegister: " + product.getRegister();
    }
}
