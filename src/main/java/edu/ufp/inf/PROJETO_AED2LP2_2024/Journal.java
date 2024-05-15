package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.Objects;

public class Journal extends Publicacao {
    private String nome;
    private String publisher;
    private int ano;
    private String periodicidade;
    private double jcrIF;
    private double scopusIF;

    public Journal(String titulo, String nome, String publisher, int ano, String periodicidade, double jcrIF, double scopusIF) {
        super(titulo, "Journal");
        this.nome = nome;
        this.publisher = publisher;
        this.ano = ano;
        this.periodicidade = periodicidade;
        this.jcrIF = jcrIF;
        this.scopusIF = scopusIF;
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

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public double getJcrIF() {
        return jcrIF;
    }

    public void setJcrIF(double jcrIF) {
        this.jcrIF = jcrIF;
    }

    public double getScopusIF() {
        return scopusIF;
    }

    public void setScopusIF(double scopusIF) {
        this.scopusIF = scopusIF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return ano == journal.ano && Double.compare(jcrIF, journal.jcrIF) == 0 && Double.compare(scopusIF, journal.scopusIF) == 0 && Objects.equals(nome, journal.nome) && Objects.equals(publisher, journal.publisher) && Objects.equals(periodicidade, journal.periodicidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, publisher, ano, periodicidade, jcrIF, scopusIF);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "nome='" + nome + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ano=" + ano +
                ", periodicidade='" + periodicidade + '\'' +
                ", jcrIF=" + jcrIF +
                ", scopusIF=" + scopusIF +
                '}';
    }
}