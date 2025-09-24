package com.example.Trabalho_JPA;

import com.example.Trabalho_JPA.models.Usuario;
import com.example.Trabalho_JPA.repositorys.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.Date;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UsuarioRepositoryTest {

    Date hoje = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void deveSalvarUsuario() {
        Usuario u = new Usuario(null,"Carlos", "carlos@test.com", "1234", hoje);
        Usuario salvo = usuarioRepository.save(u);

        assertNotNull(salvo.getId());
        assertEquals("Carlos", salvo.getNome());
    }

    @Test
    void naoDeveSalvarEmailDuplicado() {
        usuarioRepository.save(new Usuario(null, "João", "dup@test.com", "123", hoje));
        Usuario u2 = new Usuario(null, "Maria", "dup@test.com", "456", hoje);

        assertThrows(DataIntegrityViolationException.class, () -> {
            usuarioRepository.saveAndFlush(u2);
        });
    }
}
