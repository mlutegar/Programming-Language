package projetoCRUDbasicoM.model;

public class Aluno {
    private String nome;
    private String email;
    private int matricula;
    private String sexo;

    public void setNome(String nome) {this.nome = nome; }
    public void setEmail(String email){
        this.email = email;
    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public int getMatricula(){
        return matricula;
    }
    public String getSexo(){
        return sexo;
    }


    public void assistirAula(){
        System.out.println("O aluno está assistindo a aula de Java");
    }

    public String efetuarPergunta(){
        return "O aluno está fazendo uma pergunta sobre duvida dele de Java";
    }
}
