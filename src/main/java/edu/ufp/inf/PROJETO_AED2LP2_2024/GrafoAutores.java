package edu.ufp.inf.PROJETO_AED2LP2_2024;

import java.util.*;

public class GrafoAutores {
    private Map<Autor, Set<Autor>> adjList;

    public GrafoAutores() {
        this.adjList = new HashMap<>();
    }

    public void adicionarAutor(Autor autor) {
        this.adjList.putIfAbsent(autor, new HashSet<>());
    }

    public void adicionarCoautoria(Autor autor1, Autor autor2) {
        this.adjList.putIfAbsent(autor1, new HashSet<>());
        this.adjList.putIfAbsent(autor2, new HashSet<>());
        this.adjList.get(autor1).add(autor2);
        this.adjList.get(autor2).add(autor1);  // Aresta bidirecional
    }

    public Set<Autor> obterCoautores(Autor autor) {
        return this.adjList.getOrDefault(autor, new HashSet<>());
    }

    public void imprimirGrafo() {
        for (Map.Entry<Autor, Set<Autor>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey().getNome() + " -> ");
            for (Autor coautor : entry.getValue()) {
                System.out.print(coautor.getNome() + ", ");
            }
            System.out.println();
        }
    }
}