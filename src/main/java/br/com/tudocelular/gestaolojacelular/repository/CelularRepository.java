package br.com.tudocelular.gestaolojacelular.repository;

import br.com.tudocelular.gestaolojacelular.domain.model.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository("celularRepository")
public interface CelularRepository extends JpaRepository<Celular, UUID> {

    @Modifying
    @Transactional
    @Query(value = "update Celular c set c.preco = :preco where c.celularId = :id")
    void updateByPreco(UUID id, float preco);

    Celular findByPreco(float preco);
}
