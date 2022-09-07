package projetoCRUDbasicoM.structures;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EstruturaDeRepeticao {

    public void estruturaFor(List<String> nomes){
        for(int i = 0; i < nomes.size(); i++){
            System.out.print(nomes.get(i));

            if(i != (nomes.size() - 1))
                System.out.print(", ");

            if(i == (nomes.size() - 1))
                System.out.println("\n");
        }
    }

    public void estruturaWhile(boolean test){
        int i = 0;
        System.out.println("loop iniciado");

        while(true) {
            i++;
            if(i == 500000)
                test = true;

            if(test)
                break;
        }

        System.out.println("loop finalizado\n");
    }

    public void estruturaDoWhile(){
        var teclado = new Scanner(System.in);
        var contador = 0;

        do {
            System.out.print("Informe a senha: ");
            contador++;
        } while(!teclado.next().equals("Senha123@"));

        teclado.close();
        System.out.println("\nQuantidades de tentativas: " + contador);
    }

    public void estruturaForEach(List<Integer> numeros){

    }

    public static void main(String[] args) {
        var edr = new EstruturaDeRepeticao();
        edr.estruturaFor(Arrays.asList("Luis", "Carlos Eduardo", "Antonio", "Carlos Rodrigo", "Ighor", "Lucas", "Thawan", "Thiago", "Thaisa"));
        edr.estruturaWhile(false);
        edr.estruturaDoWhile();
    }

}
