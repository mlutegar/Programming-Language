package valorAcumulado.app;

import valorAcumulado.model.armazenamento;
import javax.swing.*;

public class app {

    public static void main(String[] args) {
        armazenamento store;
        store = new armazenamento();

        String value;

        for (int x = 0; x<100; x++){
            value = JOptionPane.showInputDialog("Informe um número...");

            if(Integer.parseInt(value) == 0){
                break;
            }

            store.setValor(Integer.parseInt(value));
        }

        System.out.println("O valor total acumulado é: " + store.getValor());
    }

}
