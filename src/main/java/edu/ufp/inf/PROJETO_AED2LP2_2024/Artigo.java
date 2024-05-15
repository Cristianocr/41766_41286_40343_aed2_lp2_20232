package edu.ufp.inf.PROJETO_AED2LP2_2024;

import edu.ufp.inf.lp2.p01_intro.A;

import java.util.ArrayList;
import java.util.Objects;

public class Artigo {
    private static int lastId = 0;
    private Integer id;
    private String titulo;
    private ArrayList<String> palavrasChave;
    private String abstracto;
    private String tipoPublicacao;
    private int ano;
    private int numDownloads;
    private int numVisualizacoes;
    private int numlikes;
    private ArrayList<Autor> autores;

    public Artigo(String titulo, ArrayList<String> palavrasChave, String abstracto, String tipoPublicacao, int ano, int numDownloads, int numVisualizacoes, int numlikes, ArrayList<Autor> autores) {
        this.id = ++lastId;
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.abstracto = abstracto;
        this.tipoPublicacao = tipoPublicacao;
        this.ano = ano;
        this.numDownloads = numDownloads;
        this.numVisualizacoes = numVisualizacoes;
        this.numlikes = numlikes;
        this.autores = autores;
    }

    public Integer getId() {
        return id;
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

    public void addPlavraChave(String palavraChave) {
        this.palavrasChave.add(palavraChave);
    }

    public void removePlavraChave(String palavraChave) {
        if(!this.palavrasChave.contains(palavraChave)){
            this.palavrasChave.remove(palavraChave);
        }
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

    public int getNumlikes() {
        return numlikes;
    }

    public void setNumlikes(int numlikes) {
        this.numlikes = numlikes;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void removeAutor(Autor autor) {
        if(autores.contains(autor)){
            this.autores.remove(autor);
        }
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artigo artigo = (Artigo) o;
        return ano == artigo.ano && numDownloads == artigo.numDownloads && numVisualizacoes == artigo.numVisualizacoes && numlikes == artigo.numlikes && Objects.equals(id, artigo.id) && Objects.equals(titulo, artigo.titulo) && Objects.equals(palavrasChave, artigo.palavrasChave) && Objects.equals(abstracto, artigo.abstracto) && Objects.equals(tipoPublicacao, artigo.tipoPublicacao) && Objects.equals(autores, artigo.autores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, palavrasChave, abstracto, tipoPublicacao, ano, numDownloads, numVisualizacoes, numlikes, autores);
    }

    @Override
    public String toString() {
        return "Artigo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", palavrasChave=" + palavrasChave +
                ", abstracto='" + abstracto + '\'' +
                ", tipoPublicacao='" + tipoPublicacao + '\'' +
                ", ano=" + ano +
                ", numDownloads=" + numDownloads +
                ", numVisualizacoes=" + numVisualizacoes +
                ", numlikes=" + numlikes +
                ", autores=" + autores +
                '}';
    }
}