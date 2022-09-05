package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.model.Aluno;

import javax.swing.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Aluno alu;
        alu = new Aluno();

        var teclado = new Scanner(System.in);


        System.out.println("Informe o nome: ");
        alu.setNome(teclado.nextLine());

        System.out.println("Informe o email: ");
        alu.setEmail(teclado.nextLine());

        System.out.println("Informe a matricula: ");
        alu.setMatricula(teclado.nextInt());

        System.out.println("Informe o sexo: ");
        alu.setSexo(teclado.next());

        System.out.println("Aluno.nome: " + alu.getNome());
        System.out.println("Aluno.email: " + alu.getEmail());
        System.out.println("Aluno.matricula: " + alu.getMatricula());
        System.out.println("Aluno.sexo: " + alu.getSexo());

        /*
        var msg = alu.getNome() + alu.getEmail() + alu.getMatricula() + alu.getSexo();
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.PLAIN_MESSAGE);
         */
    }
}
