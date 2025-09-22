package models;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findByTituloContainingOrderByTituloAsc(String titulo);

    List<Video> findByCategoriaOrderByTituloAsc(Categoria categoria);

}
