package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.model.Aluno;

import javax.swing.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Aluno alu;
        alu = new Aluno();

        /*
            var teclado = new Scanner(System.in);

            System.out.println("Informe o nome: ");
            alu.setNome(teclado.nextLine());

            System.out.println("Informe o email: ");
            alu.setEmail(teclado.nextLine());

            System.out.println("Informe a matricula: ");
            alu.setMatricula(teclado.nextInt());

            System.out.println("Informe o sexo: ");
            alu.setSexo(teclado.next());

            teclado.close();
         */

        var nome = JOptionPane.showInputDialog(null, "Informe o nome: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        var email = JOptionPane.showInputDialog(null, "Informe o email: ", "Input Email", JOptionPane.QUESTION_MESSAGE);
        var matricula = JOptionPane.showInputDialog(null, "Informe a matricula: ", "Input Matricula", JOptionPane.QUESTION_MESSAGE);
        var sexo = JOptionPane.showInputDialog(null, "Informe o sexo: ", "Input Sexo", JOptionPane.QUESTION_MESSAGE);

        alu.setNome(nome);
        alu.setEmail(email);
        alu.setMatricula(Integer.parseInt(matricula));
        alu.setSexo(sexo);

        // Saida pelo console
        System.out.println("Aluno.nome: " + alu.getNome());
        System.out.println("Aluno.email: " + alu.getEmail());
        System.out.println("Aluno.matricula: " + alu.getMatricula());
        System.out.println("Aluno.sexo: " + alu.getSexo());

        // Saida com janela
        var msg = "Aluno.nome: " + alu.getNome() + "\nAluno.email: " + alu.getEmail() + "\nAluno.matricula: " + alu.getMatricula() + "\nAluno.sexo: " + alu.getSexo();
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.PLAIN_MESSAGE);

    }
}
