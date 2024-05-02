package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.ArrayList;
import java.util.Objects;

public class Publicacao {
    private String nome;
    private String publisher;
    private int ano;
    private String tipo; // "Conferencia" ou "Journal"
    private String local;
    private String edicaoNumero;
    private String periodicidade;
    private double jcrIf; // Fator de Impacto do Journal (Journal Citation Reports)
    private double scopusIf; // Fator de Impacto do Scopus
    private ArrayList<Artigo> artigos;

    public Publicacao(String nome, String publisher, int ano, String tipo) {
        this.nome = nome;
        this.publisher = publisher;
        this.ano = ano;
        this.tipo = tipo;
        this.artigos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEdicaoNumero() {
        return edicaoNumero;
    }

    public void setEdicaoNumero(String edicaoNumero) {
        this.edicaoNumero = edicaoNumero;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public double getJcrIf() {
        return jcrIf;
    }

    public void setJcrIf(double jcrIf) {
        this.jcrIf = jcrIf;
    }

    public double getScopusIf() {
        return scopusIf;
    }

    public void setScopusIf(double scopusIf) {
        this.scopusIf = scopusIf;
    }

    public ArrayList<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(ArrayList<Artigo> artigos) {
        this.artigos = artigos;
    }

    public void adicionarArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }

    public void removerArtigo(Artigo artigo) {
        this.artigos.remove(artigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacao that = (Publicacao) o;
        return ano == that.ano && Double.compare(jcrIf, that.jcrIf) == 0 && Double.compare(scopusIf, that.scopusIf) == 0 && Objects.equals(nome, that.nome) && Objects.equals(publisher, that.publisher) && Objects.equals(tipo, that.tipo) && Objects.equals(local, that.local) && Objects.equals(edicaoNumero, that.edicaoNumero) && Objects.equals(periodicidade, that.periodicidade) && Objects.equals(artigos, that.artigos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, publisher, ano, tipo, local, edicaoNumero, periodicidade, jcrIf, scopusIf, artigos);
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "nome='" + nome + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ano=" + ano +
                ", tipo='" + tipo + '\'' +
                ", local='" + local + '\'' +
                ", edicaoNumero='" + edicaoNumero + '\'' +
                ", periodicidade='" + periodicidade + '\'' +
                ", jcrIf=" + jcrIf +
                ", scopusIf=" + scopusIf +
                ", artigos=" + artigos +
                '}';
    }
}