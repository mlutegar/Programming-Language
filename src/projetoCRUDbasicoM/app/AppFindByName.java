package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.service.AlunoService;

import javax.swing.*;

public class AppFindByName {
    public static void main(String[] args) {
        var service = new AlunoService();

        var respostaList = service.findByName("Michel").stream().map(
                aluno -> "Aluno.nome: " + aluno.getNome() +
                            "\nAluno.email: " + aluno.getEmail() +
                            "\nAluno.matricula: " + aluno.getMatricula() +
                            "\nAluno.sexo: " + aluno.getSexo()
        ).toList();
        JOptionPane.showMessageDialog(null, respostaList, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}
