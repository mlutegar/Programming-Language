package projetoCRUDbasicoM.app;

public class ControleFluxo {
    public static void main(String[] args) {
        int x = 10;
        int y = 100;

        for(int i = x; i < y; i++){
            if (i%2 == 0)
                continue;

            if (i == 75)
                break;

            System.out.println("i = " + i);
        }
    }
}
