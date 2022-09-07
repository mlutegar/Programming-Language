package projetoCRUDbasicoM.structures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EstruturaDeRepeticao {

    public void estruturaFor(List<String> nomes){
        Collections.sort(nomes);
        for(int i = 0; i < nomes.size(); i++){
            System.out.print(nomes.get(i));

            if(nomes.get(i).startsWith("Lu")) {
                System.out.print(" (O nome começa com Lu) ");
            }

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
        System.out.println("\nQuantidades de tentativas: " + contador + "\n");
    }

    public void estruturaForEach(List<Integer> numeros){
        Collections.sort(numeros); // ordena os números

        for(int numero: numeros){ // numero é a variavél, que no for normal é o 'i'. Ele vai incrementando-se 1 em 1. // numeros é a array especificiada na mais
            System.out.print(numero + " ");
        }
    }

    public static void main(String[] args) {
        var edr = new EstruturaDeRepeticao();
        edr.estruturaFor(Arrays.asList("Luis", "Carlos Eduardo", "Antonio", "Carlos Rodrigo", "Ighor", "Lucas", "Thawan", "Thiago", "Thaisa"));
        edr.estruturaWhile(false);
        edr.estruturaDoWhile();
        edr.estruturaForEach(Arrays.asList(532, 231, 544, 90, 43, 56, 17, 69, 21, 12, 534));
    }

}
