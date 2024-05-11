package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BD {
    private Map<String, Artigo> artigos;
    private Map<String, Autor> autores;
    private Set<Publicacao> publicacoes;
    private GrafoArtigos grafoArtigos;
    private GrafoAutores grafoAutores;

    public BD() {
        this.artigos = new HashMap<>();
        this.autores = new HashMap<>();
        this.publicacoes = new HashSet<>();
        this.grafoArtigos = new GrafoArtigos();
        this.grafoAutores = new GrafoAutores();
    }

    // Métodos para adicionar, remover e pesquisar artigos
    public void adicionarArtigo(Artigo artigo) {
        artigos.put(artigo.getId(), artigo);
    }

    public void removerArtigo(String id) {
        artigos.remove(id);
    }

    public Artigo pesquisarArtigo(String id) {
        return artigos.get(id);
    }

    // Métodos para adicionar, remover e pesquisar autores
    public void adicionarAutor(Autor autor) {
        autores.put(autor.getId(), autor);
    }

    public void removerAutor(String id) {
        autores.remove(id);
    }

    public Autor pesquisarAutor(String id) {
        return autores.get(id);
    }

    // Métodos para adicionar, remover e pesquisar publicações
    public void adicionarPublicacao(Publicacao publicacao) {
        publicacoes.add(publicacao);
    }

    public void removerPublicacao(Publicacao publicacao) {
        publicacoes.remove(publicacao);
    }

    // Métodos para manipular grafos de artigos e autores
    public GrafoArtigos getGrafoArtigos() {
        return grafoArtigos;
    }

    public GrafoAutores getGrafoAutores() {
        return grafoAutores;
    }
}
