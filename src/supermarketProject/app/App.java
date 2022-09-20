package supermarketProject.app;

import javax.swing.*;
import java.util.Objects;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 07/09/2002
 * @Version: 1.0
 * @Description: Class responsible for adding new products in the supermarket
 * */

public class App {
    public static void main(String[] args) {
        AppData data;
        AppDelete delete;
        AppSearch search;

        data = new AppData();
        delete = new AppDelete();
        search = new AppSearch();

        var choice = " ";

        while (!Objects.equals(choice, "0")){
            choice = JOptionPane.showInputDialog(null, """
                Choose what you want to do:
                1: Insert product
                2: List products
                3: Choose product by id
                4: Choose product by name
                5: Choose product by provider
                6: Choose product by type
                7: Update product
                8: Delete product by id
                9: Delete all
                0: Quit""", "Choose an action", JOptionPane.QUESTION_MESSAGE);


            if (Objects.equals(choice, "1"))
                data.insert();
            else if (Objects.equals(choice, "2"))
                search.listProduct();
            else if (Objects.equals(choice, "3"))
                search.searchById();
            else if (Objects.equals(choice, "4"))
                search.searchByName();
            else if (Objects.equals(choice, "5"))
                search.searchByProvider();
            else if (Objects.equals(choice, "6"))
                search.searchByType();
            else if (Objects.equals(choice, "7"))
                data.updateProduct();
            else if (Objects.equals(choice, "8"))
                delete.deleteProductById();
            else if (Objects.equals(choice, "9"))
                delete.deleteAllProducts();
        }
    }
}
