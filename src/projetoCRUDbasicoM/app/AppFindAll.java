package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.service.AlunoService;

import javax.swing.*;
// import java.util.Scanner;

public class AppFindAll {
    public static void main(String[] args) {
        var service = new AlunoService();

        service.findAll().forEach(aluno -> System.out.println(aluno.getNome()));
        var respostaList = service.findAll().stream().map(
                aluno -> "Aluno.nome: " + aluno.getNome() +
                        "\nAluno.email: " + aluno.getEmail() +
                        "\nAluno.matricula: " + aluno.getMatricula() +
                        "\nAluno.sexo: " + aluno.getSexo()
        ).toList();
        JOptionPane.showMessageDialog(null, respostaList, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}
