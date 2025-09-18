package models;

public class Perfil {
    int id;
    String nome_perfil;
    int usuario_id;

    public Perfil() {
    }

    public Perfil(int id, String nome_perfil, int usuario_id) {

        this.id = id;
        this.nome_perfil = nome_perfil;
        this.usuario_id = usuario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_perfil() {
        return nome_perfil;
    }

    public void setNome_perfil(String nome_perfil) {
        this.nome_perfil = nome_perfil;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
