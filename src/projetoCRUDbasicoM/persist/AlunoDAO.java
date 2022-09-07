package projetoCRUDbasicoM.persist;

import projetoCRUDbasicoM.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "select * from aluno"
            );
            rs = pstmt.executeQuery();

            var alunos = new ArrayList<Aluno>();
            while(rs.next()) {
                var aluno = new Aluno();
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSexo(rs.getString("sexo"));
                alunos.add(aluno);
            }
            return alunos;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on list aluno. Error:  " + e.getMessage());
        } finally {
            try {
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error:  " + e.getMessage());
            }
        }
        return null;
    }
}
