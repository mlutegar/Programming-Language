package projetoCRUDbasicoM.persist;

public class Bolo {
    private int qtdFarinha;
    private int qtdOvos;
    private int qtdOleo;
    private int qtdLeite;
    private int qtdAcucar;
    public boolean chocolate;
    public boolean laranja;
    public boolean doceLeite;

    public Bolo(int qtdFarinha, int qtdAcucar, int qtdOleo, int qtdOvos, int qtdLeite){
        this.qtdOvos = qtdOvos;
        this.qtdFarinha = qtdFarinha;
        this.qtdAcucar = qtdAcucar;
        this.qtdOleo = qtdOleo;
        this.qtdLeite = qtdLeite;
    }

    public static void main(String[] args) {
        var bolo = new Bolo(300, 233, 12, 32, 43);
        bolo.chocolate = true;
    }

}
