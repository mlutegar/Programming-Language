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

    }

    protected Connection getConnection() throws SQLException {}

}
