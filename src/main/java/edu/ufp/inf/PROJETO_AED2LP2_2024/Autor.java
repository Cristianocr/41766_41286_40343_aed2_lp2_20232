package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.ArrayList;
import java.util.Objects;

public class Autor {
    private String nome;
    private String nomeCientifico;
    private String filiacao;
    private String orcid;
    private String cienciaId;
    private String googleScholarId;
    private String scopusAuthorId;
    private ArrayList<Artigo> artigos;

    public Autor(String nomeCientifico, String filiacao, String nome, String cienciaId, String googleScholarId, String scopusAuthorId, ArrayList<Artigo> artigos) {
        this.nomeCientifico = nomeCientifico;
        this.filiacao = filiacao;
        this.nome = nome;
        this.cienciaId = cienciaId;
        this.googleScholarId = googleScholarId;
        this.scopusAuthorId = scopusAuthorId;
        this.artigos = artigos;
        this.orcid = ORCIDGenerator.generateUniqueORCID(nome, nomeCientifico);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public String getOrcid() {
        return orcid;
    }

    public String getCienciaId() {
        return cienciaId;
    }

    public void setCienciaId(String cienciaId) {
        this.cienciaId = cienciaId;
    }

    public String getGoogleScholarId() {
        return googleScholarId;
    }

    public void setGoogleScholarId(String googleScholarId) {
        this.googleScholarId = googleScholarId;
    }

    public String getScopusAuthorId() {
        return scopusAuthorId;
    }

    public void setScopusAuthorId(String scopusAuthorId) {
        this.scopusAuthorId = scopusAuthorId;
    }

    public ArrayList<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(ArrayList<Artigo> artigos) {
        this.artigos = artigos;
    }

    public void addCitacao(Artigo artigo){
        if(!artigos.contains(artigo)){
            this.artigos.add(artigo);
        }
    }

    public void removeCitacao(Artigo artigo) {
        if(artigos.contains(artigo)){
            this.artigos.remove(artigo);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nome, autor.nome) && Objects.equals(nomeCientifico, autor.nomeCientifico) && Objects.equals(filiacao, autor.filiacao) && Objects.equals(orcid, autor.orcid) && Objects.equals(cienciaId, autor.cienciaId) && Objects.equals(googleScholarId, autor.googleScholarId) && Objects.equals(scopusAuthorId, autor.scopusAuthorId) && Objects.equals(artigos, autor.artigos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nomeCientifico, filiacao, orcid, cienciaId, googleScholarId, scopusAuthorId, artigos);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", nomeCientifico='" + nomeCientifico + '\'' +
                ", filiacao='" + filiacao + '\'' +
                ", orcid='" + orcid + '\'' +
                ", cienciaId='" + cienciaId + '\'' +
                ", googleScholarId='" + googleScholarId + '\'' +
                ", scopusAuthorId='" + scopusAuthorId + '\'' +
                ", artigos=" + artigos +
                '}';
    }
}

