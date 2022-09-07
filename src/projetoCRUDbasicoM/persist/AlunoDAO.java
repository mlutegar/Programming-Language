package projetoCRUDbasicoM.persist;

import projetoCRUDbasicoM.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlunoDAO extends DAO{
    private Connection conn;

    public void save(Aluno aluno) {
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "insert into aluno values (nome, email, matricula, sexo) values (?, ?, ?, ?, ?)"
            );

            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getEmail());
            pstmt.setInt(3, aluno.getMatricula());
            pstmt.setString(4, aluno.getSexo());

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on save aluno. Error:  " + e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error:  " + e.getMessage());
            }
        }
    }

    public List<Aluno> findAll() {
        try {
            conn = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list aluno. Error:  " + e.getMessage());
        } finally {
            try {

            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error:  " + e.getMessage());
            }
        }
    }
}
