package com.example.Trabalho_JPA.repositorys;


import com.example.Trabalho_JPA.models.Categoria;
import com.example.Trabalho_JPA.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByTituloContainingOrderByTituloAsc(String titulo);

    List<Video> findByCategoriaOrderByTituloAsc(Categoria categoria);

}
