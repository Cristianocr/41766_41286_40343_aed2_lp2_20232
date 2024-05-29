package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.Objects;

public class Publicacao {
    private static int proximoId = 1;
    private int id;
    private String titulo;
    private String tipo;
    private boolean active = false;


    public Publicacao(String titulo, String tipo) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacao that = (Publicacao) o;
        return id == that.id && Objects.equals(titulo, that.titulo) && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, tipo);
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}