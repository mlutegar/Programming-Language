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
            return response != 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (SQLException e) {
            logError(e, "Error on save aluno. Error:  ");
            return Boolean.FALSE;
        } finally {
            closeStatements(stmt, null, conn);
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
                alunos.add(setAluno(rs));
            }
            return alunos;

        } catch (SQLException e) {
            logError(e, "Error on list aluno. Error:  ");
            return new ArrayList<>();
        } finally {
            closeStatements(stmt, rs, null);
        }
    }
    public Aluno findById(long id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from aluno where id = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            return rs.next() ? setAluno(rs) : new Aluno();
        } catch (SQLException e) {
            logError(e, "Error on find id aluno. Error:  ");
            return new Aluno();
        } finally {
            closeStatements(stmt, rs, null);
        }
    }
    public List<Aluno> findByName(String nome){
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(
                    "select * from aluno where nome like ?"
            );
            stmt.setString(1, '%' + nome + '%'); // '' para char "" para string
            rs = stmt.executeQuery();

            var alunos = new ArrayList<Aluno>();
            while (rs.next()) {
                alunos.add(setAluno(rs));
            }
            return alunos;

        } catch (SQLException e) {
            logError(e, "Error on find aluno by name. Error:  ");
            return new ArrayList<>();
        } finally {
            closeStatements(stmt, rs, null);
        }
    }
    public  Aluno findByMatricula(int matricula){
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from aluno where matricula = ?");
            stmt.setInt(1, matricula);
            rs = stmt.executeQuery();

            return rs.next() ? setAluno(rs) : new Aluno();
        } catch (SQLException e) {
            logError(e, "Error on find id aluno. Error:  ");
            return new Aluno();
        } finally {
            closeStatements(stmt, rs, null);
        }
    }
    public  Aluno findByEmail(String email){
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from aluno where email = ?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            return rs.next() ? setAluno(rs) : new Aluno();
        } catch (SQLException e) {
            logError(e, "Error on find email aluno. Error:  ");
            return new Aluno();
        } finally {
                closeStatements(stmt, rs, null);
            }
    }
    public boolean deleteById(long id) {
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("delete from aluno where id = ?");
            stmt.setLong(1, id);

            var response = stmt.executeUpdate();
            return response != 0 ? Boolean.TRUE : Boolean.FALSE;

        } catch (SQLException e) {
            logError(e, "Error on delete aluno. Error:  ");
            return Boolean.FALSE;
        } finally {
            closeStatements(stmt, null, conn);
        }
    }
    public boolean deleteAll(List<Aluno> alunos) {
        PreparedStatement stmt = null;

        try{
            conn = getConnection();
            stmt = conn.prepareStatement("delete from aluno where id in (?)");

            var idList = alunos.stream().map(Aluno::getId).toArray(Long[]::new);
            var arrayIds = conn.createArrayOf("long", idList);
            stmt.setArray(1, arrayIds);

            var response = stmt.executeUpdate();

            return (response != 0) ? Boolean.TRUE : Boolean.FALSE;
        } catch (SQLException e) {
            logError(e, "Error on save aluno. Error:  ");
            return Boolean.FALSE;
        } finally {
            closeStatements(stmt, null, conn);
        }
    }
    private Aluno setAluno(ResultSet rs) throws SQLException {
        return new Aluno(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("email"),
            rs.getInt("matricula"),
            rs.getString("sexo")
        );
    }
    private void closeStatements(PreparedStatement stmt, ResultSet rs, Connection conn) {
        try {
            if (conn != null)
                conn.close();
            if (stmt != null)
                stmt.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            logError(e, "Error on close statements. Error:  ");
        }
    }
    private static void logError(SQLException e, String error) {
        e.printStackTrace();
        System.err.println(error + e.getMessage());
    }
    //public  Aluno update(Aluno aluno) {}
}