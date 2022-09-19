package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.service.AlunoService;

import javax.swing.*;

public class AppFindById {
    public static void main(String[] args) {
        var service = new AlunoService();
        var alu = service.findById(1);

        var msg = "Aluno.nome: " + alu.getNome() + "\nAluno.email: " + alu.getEmail() + "\nAluno.matricula: " + alu.getMatricula() + "\nAluno.sexo: " + alu.getSexo();
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}
