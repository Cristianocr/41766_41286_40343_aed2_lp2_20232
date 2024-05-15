package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.*;

public class BD {
    private Hashtable<Integer, Artigo> artigos;
    private Hashtable<String, Autor> autores;
    private Hashtable<Integer, Publicacao> publicacoes;
    private GrafoArtigos grafoArtigos;
    private GrafoAutores grafoAutores;

    public BD() {
        this.artigos = new Hashtable<>();
        this.autores = new Hashtable<>();
        this.publicacoes = new Hashtable<>();
        this.grafoArtigos = new GrafoArtigos();
        this.grafoAutores = new GrafoAutores();
    }

    // Métodos para adicionar, remover e pesquisar artigos
    public void adicionarArtigo(Artigo artigo) {
        artigos.put(artigo.getId(), artigo);
    }

    public void removerArtigo(int id) {
        artigos.remove(id);
    }

    public Artigo pesquisarArtigo(int id) {
        return artigos.get(id);
    }

    // Métodos para adicionar, remover e pesquisar autores
    public void adicionarAutor(Autor autor) {
        autores.put(autor.getOrcid(), autor);
    }

    public void removerAutor(String orcid) {
        autores.remove(orcid);
    }

    public Autor pesquisarAutor(String orcid) {
        return autores.get(orcid);
    }

    // Métodos para adicionar, remover e pesquisar publicações
    public void adicionarPublicacao(Publicacao publicacao) {
        publicacoes.put(publicacao.getId(), publicacao);
    }

    public void removerPublicacao(int id) {
        publicacoes.remove(id);
    }

    public Publicacao pesquisarPublicacao(int id) {
        return publicacoes.get(id);
    }

    // Métodos para manipular grafos de artigos e autores
    public GrafoArtigos getGrafoArtigos() {
        return grafoArtigos;
    }

    public GrafoAutores getGrafoAutores() {
        return grafoAutores;
    }
}
