package br.com.tudocelular.gestaolojacelular.service;

import br.com.tudocelular.gestaolojacelular.domain.model.Celular;
import br.com.tudocelular.gestaolojacelular.repository.CelularRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CelularService {
    private final CelularRepository celularRepository;
    public CelularService(CelularRepository celularRepository) {
        this.celularRepository = celularRepository;
    }

    public Celular save(Celular celular){
        return celularRepository.save(celular);
    }

    public List<Celular> findAll(){
        return celularRepository.findAll();
    }

    public Celular findById(UUID id){
        return celularRepository.findById(id).orElse(new Celular());
    }

    public void deleteById(UUID id){
        celularRepository.deleteById(id);
    }

    public void update(UUID id, float preco) {
        celularRepository.updateByPreco(id, preco);
    }

    public Celular findByPreco(float preco) {
        return celularRepository.findByPreco(preco);
    }
}
