package projetoCRUDbasicoM.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAO { //DAO: Data Access Object

    public DAO(){ //Define a estrutura da classe
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // tenta executar o código
        } catch (ClassNotFoundException cnfe) { // condição é o tipo de erro
            cnfe.printStackTrace(); // se der falha executa um novo código
            System.err.println("Class not found. Error: " + cnfe.getMessage());
        }
    }

    protected Connection getConnection() throws SQLException { // JDBC é uma API de nível de chamada, o que significa que as instruções SQL são transmitidas como sequências para a API que, então, se encarrega de executá-las no RDMS.
        return DriverManager.getConnection("jdbc:mysql://localhost/db01", "root", ""); // jdbc = Java Database Connectivity
    }

}
