package edu.ufp.inf.PROJETO_AED2LP2_2024;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class GrafoAutores {

    private EdgeWeightedGraph colaboracoes;

    public GrafoAutores(int V) {
        this.colaboracoes = new EdgeWeightedGraph(V);
    }

    public GrafoAutores(Hashtable<Integer, Autor> autores) {
        this.colaboracoes = new EdgeWeightedGraph(autores.size());
    }

    public void increaseGraph(int i) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(i * 4);
        this.colaboracoes = new EdgeWeightedGraph(G);
    }

    public void addColaboracao(Autor a, Autor b, ArrayList<Integer> artigos) {
        if (a.getId() > colaboracoes.V()) {
            increaseGraph(a.getId());
        }
        if (b.getId() > colaboracoes.V()) {
            increaseGraph(b.getId());
        }
        Edge edgeA = findVwW(a, b);
        Edge edgeB = findVwW(b, a);
        if (edgeA != null && edgeB != null) {
            updateEdges(edgeA, edgeB, artigos);
        } else {
            Edge e = new Edge(a.getId(), b.getId(), artigos);
            colaboracoes.addEdge(e);
        }
    }

    public void addColaboracao(Autor a, Autor b, Integer artigo) {
        if (a.getId() > colaboracoes.V()) {
            increaseGraph(a.getId());
        }
        if (b.getId() > colaboracoes.V()) {
            increaseGraph(b.getId());
        }
        Edge edgeA = findVwW(a, b);
        Edge edgeB = findVwW(b, a);
        if (edgeA != null && edgeB != null) {
            updateEdges(edgeA, edgeB, artigo);
        } else {
            Edge e = new Edge(a.getId(), b.getId());
            e.addArtigo(artigo);
            colaboracoes.addEdge(e);
        }
    }

    public Edge findVwW(Autor a, Autor b) {
        Iterable<Edge> iteratorA = colaboracoes.adj(a.getId());
        for (Edge e : iteratorA) {
            if (e.other(a.getId()) == b.getId()) {
                return e;
            }
        }
        return null;
    }

    public void updateEdges(Edge a, Edge b, ArrayList<Integer> artigos) {
        for (Integer id : artigos) {
            if (!a.getArticleIds().contains(id) && !b.getArticleIds().contains(id)) {
                a.addArtigo(id);
                b.addArtigo(id);
            }
        }
    }

    public void updateEdges(Edge a, Edge b, Integer artigoId) {
        if (!a.getArticleIds().contains(artigoId) && !b.getArticleIds().contains(artigoId)) {
            a.addArtigo(artigoId);
            b.addArtigo(artigoId);
        }
    }

    public int getDegree(Autor a) {
        return colaboracoes.degree(a.getId());
    }

    public int hasWorkWith(Integer i) {
        return colaboracoes.degree(i);
    }

    public int hasWorkWith(Autor a) {
        return colaboracoes.degree(a.getId());
    }

    public EdgeWeightedGraph getColaboracoes() {
        return colaboracoes;
    }

    public Set<Autor> obterCoautores(Autor autor) {
        return null;
    }

    public void imprimirGrafo() {
        Iterable<Edge> iterator = colaboracoes.edges();
        for (Edge e : iterator) {
            StdOut.println(e.toString());
        }
    }
}