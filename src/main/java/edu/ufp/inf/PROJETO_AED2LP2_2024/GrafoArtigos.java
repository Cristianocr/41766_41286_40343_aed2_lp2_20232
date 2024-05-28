package edu.ufp.inf.PROJETO_AED2LP2_2024;

import edu.princeton.cs.algs4.Graph;

import java.util.*;

public class GrafoArtigos {
    private Graph colaboration;
    private Map<Artigo, List<Artigo>> adjList;

    public GrafoArtigos() {
        this.adjList = new HashMap<>();
    }

    public void adicionarArtigo(Artigo artigo) {
        this.adjList.putIfAbsent(artigo, new ArrayList<>());
    }

    public void adicionarCitacao(Artigo from, Artigo to) {
        if (!this.adjList.containsKey(from) || !this.adjList.containsKey(to)) {
            throw new IllegalArgumentException("Artigo não encontrado no grafo");
        }
        this.adjList.get(from).add(to);
    }

    public List<Artigo> obterCitacoes(Artigo artigo) {
        return this.adjList.getOrDefault(artigo, new ArrayList<>());
    }

    public void imprimirGrafo() {
        for (Map.Entry<Artigo, List<Artigo>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey().getTitulo() + "," + entry.getKey().getId() + " -> ");
            for (Artigo cited : entry.getValue()) {
                System.out.print(cited.getTitulo() +  "," + entry.getKey().getId() + ", ");
            }
            System.out.println();
        }
    }
}