package br.com.tudocelular.gestaolojacelular.repository;

import br.com.tudocelular.gestaolojacelular.model.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("celularRepository")
public interface CelularRepository extends JpaRepository<Celular, UUID> {
}
