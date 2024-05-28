package edu.ufp.inf.PROJETO_AED2LP2_2024;


import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class GrafoArtigos {

    EdgeWeightedDigraph citacoes;

    public GrafoArtigos(int V) {
        if (V == 0) {
            this.citacoes = new EdgeWeightedDigraph(1);
        }
        this.citacoes = new EdgeWeightedDigraph(V);
    }

    public GrafoArtigos(Hashtable<Integer, Artigo> artigos) {
        this.citacoes = new EdgeWeightedDigraph(artigos.size());
    }

    public void increaseGraph(int i) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(i * 3);
        this.citacoes = new EdgeWeightedDigraph(G);

    }

    public void adicionarCitacao(Artigo from, Artigo to) {
        if (to.getId() > citacoes.V()) {
            increaseGraph(to.getId());
        }
        if (from.getId() > citacoes.V()) {
            increaseGraph(from.getId());
        }

        double[] attr = new double[2];
        if ((from.getAno() - to.getAno()) < 0) {
            return;
        }
        attr[0] = from.getAno() - to.getAno();
        attr[1] = outDegree(from) + 1 - outDegree(to);
        DirectedEdge edge = new DirectedEdge(from.getId(), to.getId(), attr);
        citacoes.addEdge(edge);
    }

    public void removerCitacao(Artigo from, Artigo to) {
        if (citacoes.adj(from.getId()).iterator().hasNext()) {
            for (Iterator<DirectedEdge> iterator = citacoes.adj(from.getId()).iterator(); iterator.hasNext(); ) {
                DirectedEdge edge = iterator.next();
                if (edge.to() == to.getId()) {
                    iterator.remove(); // Remover a aresta
                    break; // Parar o loop após remover a primeira ocorrência da aresta
                }
            }
        }
    }

    public int outDegree(Artigo a) {
        return citacoes.outdegree(a.getId());
    }

    public int intDegree(Artigo a) {
        return citacoes.indegree(a.getId());
    }

    public void imprimirCitacoes(Artigo a) {
        Iterable<DirectedEdge> iterator = citacoes.adj(a.getId());
        for (DirectedEdge e : iterator) {
            StdOut.println(e.toString());
        }
    }

    public void imprimirGrafo() {
        Iterable<DirectedEdge> iterator = citacoes.edges();
        for (DirectedEdge e : iterator) {
            StdOut.println(e.toString());
        }
    }
}