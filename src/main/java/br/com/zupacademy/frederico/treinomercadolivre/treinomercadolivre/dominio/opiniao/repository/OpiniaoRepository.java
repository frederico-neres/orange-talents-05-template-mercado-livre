package br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.repository;

import br.com.zupacademy.frederico.treinomercadolivre.treinomercadolivre.dominio.opiniao.Opiniao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpiniaoRepository extends JpaRepository<Opiniao, Long> {

    @Query("SELECT AVG(o.nota) FROM Opiniao o WHERE o.id = ?1")
    Double averageOfNota(Long id);

    Page<Opiniao> findAll(Pageable pageable);
}
