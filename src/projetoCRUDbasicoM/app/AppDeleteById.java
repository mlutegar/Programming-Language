package projetoCRUDbasicoM.app;

import projetoCRUDbasicoM.service.AlunoService;

import javax.swing.*;

public class AppDeleteById {
    public static void main(String[] args) {
        var service = new AlunoService();
        var status = service.deleteById(1);

        var msg = "Status da exclusão: " + (status ? "Sucesso" : "Falha");
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}
