package com.example.Trabalho_JPA.config;

import com.example.Trabalho_JPA.models.Usuario;
import com.example.Trabalho_JPA.repositorys.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository repository) {
        return args -> {
            Usuario u1 = new Usuario();
            u1.setNome("Vitor");
            u1.setEmail("vitor@gmail.com");
            u1.setSenha("123");
            repository.save(u1);


            System.out.println("Usuarios no banco: " + repository.findAll());
        };
    }
}