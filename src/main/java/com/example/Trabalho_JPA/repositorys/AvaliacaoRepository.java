package com.example.Trabalho_JPA.repositorys;

import com.example.Trabalho_JPA.models.Avaliacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
    @Query("""
           SELECT v.id, v.titulo, AVG(a.nota) AS media
           FROM Avaliacao a
           JOIN a.video v
           GROUP BY v.id, v.titulo
           ORDER BY media DESC
           """)
    List<Object[]> findTopVideosByAvaliacao(Pageable pageable);
}
