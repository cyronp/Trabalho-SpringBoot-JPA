package models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Integer> {
    @Query("""
            SELECT a.video_id, AVG(a.nota) as media 
            FROM Avaliacao a 
            GROUP BY a.video_id
            ORDER BY media DESC
            """)
    List<Object[]> findTop10ByOrderBymediaDesc();
}