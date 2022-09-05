package projetoCRUDbasicoM.model;

import projetoCRUDbasicoM.model.Aluno;

public class AlunoTecnico extends Aluno {
    private String especializacao;
    private String nome;

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return "Aluno curso técnico: " + this.nome;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    public String getEspecializacao() {
        return especializacao;
    }
}
