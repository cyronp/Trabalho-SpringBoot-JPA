package com.example.Trabalho_JPA;

import com.example.Trabalho_JPA.models.Categoria;
import com.example.Trabalho_JPA.models.Video;
import com.example.Trabalho_JPA.repositorys.CategoriaRepository;
import com.example.Trabalho_JPA.repositorys.VideoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class VideoRepositoryTest {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    void deveSalvarVideoComCategoria() {
        // Salva a categoria primeiro
        Categoria c = new Categoria();
        c.setNome("Comédia");
        Categoria categoriaSalva = categoriaRepository.save(c);

        // Cria o vídeo usando apenas o ID da categoria
        Video v = new Video();
        v.setTitulo("Filme engraçado");
        v.setDuracao(120);
        v.setCategoria_id(categoriaSalva.getId());

        Video salvo = videoRepository.save(v);

        // Recupera a categoria pelo ID
        Categoria categoriaDoVideo = categoriaRepository.findById(salvo.getCategoria_id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        assertNotNull(salvo.getId());
        assertEquals("Filme engraçado", salvo.getTitulo());
        assertEquals("Comédia", categoriaDoVideo.getNome());
    }

    @Test
    void deveBuscarPorTituloContaining() {
        // Salva a categoria
        Categoria cat = new Categoria();
        cat.setNome("Drama");
        Categoria categoriaSalva = categoriaRepository.save(cat);

        // Salva o vídeo usando apenas o ID da categoria
        Video v = new Video();
        v.setTitulo("Drama Especial");
        v.setDuracao(90);
        v.setCategoria_id(categoriaSalva.getId());
        videoRepository.save(v);

        // Busca pelo título contendo "Drama"
        List<Video> encontrados = videoRepository.findByTituloContainingOrderByTituloAsc("Drama");

        assertFalse(encontrados.isEmpty());
        assertEquals("Drama Especial", encontrados.get(0).getTitulo());

        // Recupera a categoria do primeiro vídeo encontrado pelo ID
        Categoria categoriaDoVideo = categoriaRepository.findById(encontrados.get(0).getCategoria_id())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        assertEquals("Drama", categoriaDoVideo.getNome());
    }


}
