package projetoCRUDbasicoM.persist;

import java.sql.SQLException;

/**
* @Author: Michel Lutegar D'Orsi Pereira
* @Since: 07/09/2002
* @Version: 1.0
* @Description: Classe responsavel por abrir a conexão com o banco de dados
* */

public class DAO { //DAO: Data Access Object

    public DAO(){ //Define a estrutura da classe
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // tenta executar o código
        } catch (ClassNotFoundException cnfe) { // condição é o tipo de erro
            cnfe.printStackTrace(); // se der falha executa um novo código
            System.err.println("Class not found. Error: " + cnfe.getMessage());
        }
    }

    protected Connection getConnection() throws SQLException {}

}
