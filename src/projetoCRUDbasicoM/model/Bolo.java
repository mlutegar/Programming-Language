package projetoCRUDbasicoM.model;

import projetoCRUDbasicoM.model.enums.TipoBolo;

public class Bolo {
    private int qtdFarinha;
    private int qtdOvos;
    private int qtdOleo;
    private int qtdLeite;
    private int qtdAcucar;
    public TipoBolo tipoBolo;

    public Bolo(int qtdFarinha, int qtdAcucar, int qtdOleo, int qtdOvos, int qtdLeite){
        this.qtdOvos = qtdOvos;
        this.qtdFarinha = qtdFarinha;
        this.qtdAcucar = qtdAcucar;
        this.qtdOleo = qtdOleo;
        this.qtdLeite = qtdLeite;
    }

    public Bolo(int qtdFarinha, int qtdAcucar, int qtdOleo, int qtdOvos, int qtdLeite, TipoBolo tipoBolo){
        this.qtdOvos = qtdOvos;
        this.qtdFarinha = qtdFarinha;
        this.qtdAcucar = qtdAcucar;
        this.qtdOleo = qtdOleo;
        this.qtdLeite = qtdLeite;
        this.tipoBolo = tipoBolo;
    }

    public static void main(String[] args) {
        var bolo = new Bolo(300, 233, 12, 32, 43);
        bolo.tipoBolo = TipoBolo.COMUM;

        var bolo2 = new Bolo(300, 233, 12, 32, 43, TipoBolo.CHOCOLATE);
        var bolo3 = new Bolo(300, 233, 12, 32, 43, TipoBolo.LARANJA);
        var bolo4 = new Bolo(300, 233, 12, 32, 43, TipoBolo.DOCE_DE_LEITE);
    }
}
