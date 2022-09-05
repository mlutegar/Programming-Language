package projetoCRUDbasicoM.structures;

public class EstruturaDeDecisao {

    public void estruturaSimples(String a){
        if(a.equalsIgnoreCase("Java")){
            System.out.println("Estamos trabalhando com Java");
        }
    }
    public void estruturaComposta(String a){
        if(a.equalsIgnoreCase("Java")){
            System.out.println("Estamos trabalhando com Java");
        } else {
            System.out.println("Não é a linguagem atual de estudo");
        }
    }

    public void estruturaEncadeada(String a){
        if(a.equalsIgnoreCase("PHP")){
            System.out.println("Linguagem voltada para web comumente usada para aplicações simples");
        } else if(a.equalsIgnoreCase("MySQL")) {
            System.out.println("SBGD muito utilizada para aprendizagem de banco de dados");
        } else if(a.equalsIgnoreCase("Angular")){
            System.out.println("Framework javascript para aplicações Front-End");
        } else if(a.equalsIgnoreCase("Java")){
            System.out.println("Linguagem voltada para qualquer tipo de plataforma, muito utilizada por empresas para aplicações de grande porte");
        } else {
            System.out.println("Opção invalida");
        }
    }

    public void estruturaTernario(String a){
        System.out.println(a.equalsIgnoreCase("Java") ? "Linguagem Top" : "Xiii cala a boca");
    }

    public void estruturaCompacta(String a){
        if(a.equalsIgnoreCase("Java"))
            System.out.println("Linguagem simples de aprender");
        else
            System.out.println("Pode até ser mais que o Java, mas com muito mais gambis");
    }

    public static void main(String[] args) {
        var edd = new EstruturaDeDecisao();
        edd.estruturaComposta("PHP");
        edd.estruturaSimples("java");
        edd.estruturaEncadeada("Ruby");
        edd.estruturaTernario("Java");
        edd.estruturaCompacta("C");
    }
}
