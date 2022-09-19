package projetoCRUDbasicoM.service;

import projetoCRUDbasicoM.model.Aluno;
import projetoCRUDbasicoM.persist.AlunoDAO;
import java.util.List;

public class AlunoService {
    private AlunoDAO dao;

    public AlunoService(){
        dao = new AlunoDAO();
    }

    public boolean save(Aluno aluno){
        return dao.save(aluno);
    }

    public List<Aluno> findAll(){
        return dao.findAll();
    }

    public Aluno findById(long id){ return dao.findById(id);}

    public List<Aluno> findByName(String nome){ return dao.findByName(nome);}
}
