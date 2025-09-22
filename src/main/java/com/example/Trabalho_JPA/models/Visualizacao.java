package com.example.Trabalho_JPA.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Visualizacao {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int perfil_id;
    @Column(nullable = false)
    private int video_id;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_hora;
    @Column(nullable = false)
    private int progresso;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false, insertable = false, updatable = false)
    private Video video;

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false, insertable = false, updatable = false)
    private Perfil perfil;

    public Visualizacao() {
    }

    public Visualizacao(Long id, int perfil_id, int video_id, Date data_hora, int progresso) {
        this.id = id;
        this.perfil_id = perfil_id;
        this.video_id = video_id;
        this.data_hora = data_hora;
        this.progresso = progresso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(int perfil_id) {
        this.perfil_id = perfil_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }
}
