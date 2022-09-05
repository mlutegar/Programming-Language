package projetoCRUDbasicoM.structures;

import java.util.Arrays;
import java.util.List;

public class EstruturaDeRepeticao {

    public void estruturaFor(List<String> nomes){
        for(int i = 0; i < nomes.size(); i++){
            System.out.println(nomes.get(i));
            if(i != (nomes.size() - 1))
                System.out.println(" ");
        }
    }

    public void estruturaWhile(boolean test){

    }

    public void estruturaDoWhile(){

    }

    public void estruturaForEach(List<Integer> numeros){

    }

    public static void main(String[] args) {
        var edr = new EstruturaDeRepeticao();
        edr.estruturaFor(Arrays.asList("Luis", "Carlos Eduardo", "Antonio", "Carlos Rodrigo", "Ighor", "Lucas", "Thawan", "Thiago", "Thaisa"));

    }

}
