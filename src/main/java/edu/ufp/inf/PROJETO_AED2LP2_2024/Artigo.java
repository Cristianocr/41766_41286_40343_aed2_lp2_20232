package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.ArrayList;
import java.util.Objects;

public class Artigo {
    private String id;
    private String titulo;
    private ArrayList<String> palavrasChave;
    private String abstracto;
    private String tipoPublicacao;
    private int ano;
    private int numDownloads;
    private int numVisualizacoes;
    private ArrayList<Autor> autores;
    private ArrayList<Artigo> referencias;

    public Artigo(String titulo, ArrayList<String> palavrasChave, String abstracto, String tipoPublicacao, int ano,
                  int numDownloads, int numVisualizacoes) {
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.abstracto = abstracto;
        this.tipoPublicacao = tipoPublicacao;
        this.ano = ano;
        this.numDownloads = numDownloads;
        this.numVisualizacoes = numVisualizacoes;
        this.autores = new ArrayList<>();
        this.referencias = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(ArrayList<String> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getAbstracto() {
        return abstracto;
    }

    public void setAbstracto(String abstracto) {
        this.abstracto = abstracto;
    }

    public String getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(String tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumDownloads() {
        return numDownloads;
    }

    public void setNumDownloads(int numDownloads) {
        this.numDownloads = numDownloads;
    }

    public int getNumVisualizacoes() {
        return numVisualizacoes;
    }

    public void setNumVisualizacoes(int numVisualizacoes) {
        this.numVisualizacoes = numVisualizacoes;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<Artigo> getReferencias() {
        return referencias;
    }

    public void setReferencias(ArrayList<Artigo> referencias) {
        this.referencias = referencias;
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void adicionarReferencia(Artigo artigo) {
        referencias.add(artigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artigo artigo = (Artigo) o;
        return ano == artigo.ano && numDownloads == artigo.numDownloads && numVisualizacoes == artigo.numVisualizacoes && Objects.equals(titulo, artigo.titulo) && Objects.equals(palavrasChave, artigo.palavrasChave) && Objects.equals(abstracto, artigo.abstracto) && Objects.equals(tipoPublicacao, artigo.tipoPublicacao) && Objects.equals(autores, artigo.autores) && Objects.equals(referencias, artigo.referencias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, palavrasChave, abstracto, tipoPublicacao, ano, numDownloads, numVisualizacoes, autores, referencias);
    }

    @Override
    public String toString() {
        return "Artigo{" +
                "titulo='" + titulo + '\'' +
                ", palavrasChave=" + palavrasChave +
                ", abstracto='" + abstracto + '\'' +
                ", tipoPublicacao='" + tipoPublicacao + '\'' +
                ", ano=" + ano +
                ", numDownloads=" + numDownloads +
                ", numVisualizacoes=" + numVisualizacoes +
                ", autores=" + autores +
                ", referencias=" + referencias +
                '}';
    }
}