package com.example.Trabalho_JPA.repositorys;

import com.example.Trabalho_JPA.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
