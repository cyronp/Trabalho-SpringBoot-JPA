package com.example.Trabalho_JPA.models;

import jakarta.persistence.*;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long perfil_id;
    @Column(nullable = false)
    private Long video_id;
    @Column(nullable = false)
    private int nota;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false, insertable = false, updatable = false)
    private Video video;

    @OneToOne
    @JoinColumn(name = "perfil_id", nullable = false, insertable = false, updatable = false)
    private Perfil perfil;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Long perfil_id, Long video_id, int nota, String comentario) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.video_id = video_id;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(Long perfil_id) {
        this.perfil_id = perfil_id;
    }

    public Long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Long video_id) {
        this.video_id = video_id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
