package projetoCRUDbasicoM.persist;

import projetoCRUDbasicoM.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends DAO {
    private Connection conn;

    public boolean save(Aluno aluno) {
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(
                    "insert into aluno (nome, email, matricula, sexo) values (?, ?, ?, ?)"
            );

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getMatricula());
            stmt.setString(4, aluno.getSexo());

            var response = stmt.executeUpdate();
            if (response != 0)
                return Boolean.TRUE;

            return Boolean.FALSE;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on save aluno. Error:  " + e.getMessage());
            return Boolean.FALSE;
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error:  " + e.getMessage());
            }
        }
    }

    public List<Aluno> findAll() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(
                    "select * from aluno"
            );
            rs = stmt.executeQuery();

            var alunos = new ArrayList<Aluno>();
            while (rs.next()) {
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
            return new ArrayList<>();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error:  " + e.getMessage());
            }
        }
    }

    public Aluno findById(long id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("select * from aluno where id = ?");
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            Aluno aluno = new Aluno();
            if (rs.next()) {
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSexo(rs.getString("sexo"));
            }
            return aluno;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error on find id aluno. Error: " + e.getMessage());
            return new Aluno();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error: " + e.getMessage());
            }
        }
    }

    public List<Aluno> findByName(String nome){
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(
                    "select * from aluno where nome = ?"
            );
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            var alunos = new ArrayList<Aluno>();
            while (rs.next()) {
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
            return new ArrayList<>();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error on close statements. Error:  " + e.getMessage());
            }
        }
    }

}
    /*public  List<Aluno> findByName(String nome){}
    //public  Aluno findByMatricula(int matricula){}
    //public  Aluno findByEmail(String email){}


    // public  Aluno update(Aluno aluno) {}

    // public boolean deleteById(long id) {}

    // public boolean deleteAll() {}

*/
