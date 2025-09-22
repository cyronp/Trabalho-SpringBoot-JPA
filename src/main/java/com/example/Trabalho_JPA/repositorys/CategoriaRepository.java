package com.example.Trabalho_JPA.repositorys;

import com.example.Trabalho_JPA.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
