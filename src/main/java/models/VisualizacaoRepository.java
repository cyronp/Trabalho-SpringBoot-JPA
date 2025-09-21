package models;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisualizacaoRepository extends JpaRepository<Visualizacao,Integer> {
    @Query("""
           SELECT v.id, v.titulo, COUNT(visu) AS totalVisualizacoes
           FROM Visualizacao visu
           JOIN visu.video v
           GROUP BY v.id, v.titulo
           ORDER BY totalVisualizacoes DESC
           """)
    List<Object[]> findTop10ByOrderByTotalVisualizacoesDesc();
}
