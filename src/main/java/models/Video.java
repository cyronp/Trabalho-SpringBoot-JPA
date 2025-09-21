package models;


import jakarta.persistence.*;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255,nullable = false,unique = true)
    private String titulo;
    @Column(length = 1000)
    private String descricao;
    @Column(nullable = false)
    private int duracao;
    @Column(nullable = false)
    private int categoria_id;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false, insertable = false, updatable = false)
    private Categoria categoria;


    public Video() {
    }

    public Video(int id, String titulo, String descricao, int duracao, int categoria_id) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.categoria_id = categoria_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
}
