package com.example.Trabalho_JPA;

import com.example.Trabalho_JPA.models.Categoria;
import com.example.Trabalho_JPA.repositorys.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    void deveSalvarCategoria() {
        // Cria a categoria
        Categoria c = new Categoria();
        c.setNome("Ação");

        // Salva no banco
        Categoria categoriaSalva = categoriaRepository.save(c);

        // Recupera do banco usando o id
        Categoria categoriaDoBanco = categoriaRepository.findById(categoriaSalva.getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        // Validações
        assertNotNull(categoriaDoBanco.getId());
        assertEquals("Ação", categoriaDoBanco.getNome());
    }

}
