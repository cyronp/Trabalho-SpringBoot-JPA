package com.example.Trabalho_JPA;

import com.example.Trabalho_JPA.models.Perfil;
import com.example.Trabalho_JPA.models.Usuario;
import com.example.Trabalho_JPA.repositorys.PerfilRepository;
import com.example.Trabalho_JPA.repositorys.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.Date;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PerfilRepositoryTest {

    Date hoje = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void deveSalvarPerfilComUsuario() {
        Date hoje = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Salva o usuário
        Usuario u = new Usuario(null, "Ana", "ana@test.com", "senha", hoje);
        Usuario salvoUsuario = usuarioRepository.save(u);

        // Cria o perfil apenas com o id do usuário
        Perfil p = new Perfil();
        p.setNome_perfil("Perfil da Ana");
        p.setUsuario_id(salvoUsuario.getId());

        Perfil salvoPerfil = perfilRepository.save(p);

        // Recupera o usuário do banco usando o id
        Usuario usuarioDoPerfil = usuarioRepository.findById(salvoPerfil.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        assertEquals("Perfil da Ana", salvoPerfil.getNome_perfil());
        assertEquals("Ana", usuarioDoPerfil.getNome());
    }

}
