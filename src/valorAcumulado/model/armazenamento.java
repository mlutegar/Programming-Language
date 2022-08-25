package valorAcumulado.model;

public class armazenamento {
    private int valor;

    public int getValor() {
        return valor;
    }
    public void setValor(int valor){
        this.valor = this.valor + valor;
    }

}
