package com.example.Trabalho_JPA.models;


import jakarta.persistence.*;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255,unique = true,nullable = false)
    private String nome_perfil;
    @Column(nullable = false)
    private Long usuario_id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, insertable = false, updatable = false)
    private Usuario usuario;


    public Perfil() {
    }

    public Perfil(Long id, String nome_perfil, Long usuario_id) {

        this.id = id;
        this.nome_perfil = nome_perfil;
        this.usuario_id = usuario_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_perfil() {
        return nome_perfil;
    }

    public void setNome_perfil(String nome_perfil) {
        this.nome_perfil = nome_perfil;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}
