package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.model.Aluno;

public class App {
    public static void main(String[] args) {
        Aluno alu;
        alu = new Aluno();

        alu.assistirAula(); // Teste 1
        System.out.println(alu.efetuarPergunta()); // Teste 2
    }
}
