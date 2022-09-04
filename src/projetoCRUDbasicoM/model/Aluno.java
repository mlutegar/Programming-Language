package projetoCRUDbasicoM.model;

public class Aluno {
    public String nome;
    private String email;
    protected int matricula;
    String sexo;

    public void assistirAula(){
        System.out.println("O aluno está assistindo a aula de Java");
    }

    public String efetuarPergunta(){
        return "O aluno está fazendo uma pergunta sobre duvida dele de Java";
    }
}
