package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.model.Aluno;
import projetoCRUDbasicoM.service.AlunoService;

import javax.swing.*;
import java.util.ArrayList;

public class AppDeleteAll {
    public static void main(String[] args) {
        var service = new AlunoService();
        var alunos = service.findByName("Luis");
        alunos.add(new Aluno());
        var status = service.deleteAll(alunos);

        var msg = "Status de exclusão: " + (status ? "Sucesso" : "Falha");
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
