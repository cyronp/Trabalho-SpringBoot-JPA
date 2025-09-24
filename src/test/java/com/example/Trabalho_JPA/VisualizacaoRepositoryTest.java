package com.example.Trabalho_JPA;

import com.example.Trabalho_JPA.models.*;
import com.example.Trabalho_JPA.repositorys.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class VisualizacaoRepositoryTest {


    @Autowired
    private VisualizacaoRepository visualizacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    void deveSalvarVisualizacao() {
        // 1️⃣ Salva o usuário
        Usuario usuario = new Usuario(null, "Lucas", "lucas@test.com", "123", new Date());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // 2️⃣ Salva o perfil usando apenas o ID do usuário
        Perfil perfil = new Perfil();
        perfil.setNome_perfil("Perfil do Lucas");
        perfil.setUsuario_id(usuarioSalvo.getId());
        Perfil perfilSalvo = perfilRepository.save(perfil);

        // 3️⃣ Salva a categoria
        Categoria categoria = new Categoria(null, "Terror");
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        // 4️⃣ Salva o vídeo usando apenas o ID da categoria
        Video video = new Video();
        video.setTitulo("Filme de Terror");
        video.setDuracao(100);
        video.setCategoria_id(categoriaSalva.getId());
        Video videoSalvo = videoRepository.save(video);

        // 5️⃣ Cria a visualizacao usando os IDs
        Visualizacao visualizacao = new Visualizacao();
        visualizacao.setPerfil_id(perfilSalvo.getId());
        visualizacao.setVideo_id(videoSalvo.getId());
        visualizacao.setData_hora(new Date());
        visualizacao.setProgresso(50);

        Visualizacao visualizacaoSalva = visualizacaoRepository.save(visualizacao);

        // 6️⃣ Recupera os objetos relacionados pelo ID para validação
        Perfil perfilDoBanco = perfilRepository.findById(visualizacaoSalva.getPerfil_id())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        Usuario usuarioDoPerfil = usuarioRepository.findById(perfilDoBanco.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Video videoDoBanco = videoRepository.findById(visualizacaoSalva.getVideo_id())
                .orElseThrow(() -> new RuntimeException("Vídeo não encontrado"));

        // 7️⃣ Validações
        assertNotNull(visualizacaoSalva.getId());
        assertEquals("Lucas", usuarioDoPerfil.getNome());
        assertEquals("Filme de Terror", videoDoBanco.getTitulo());
        assertEquals(50, visualizacaoSalva.getProgresso());
    }
}
