package edu.ufp.inf.PROJETO_AED2LP2_2024;


import edu.princeton.cs.algs4.DepthFirstSearch;
import edu.princeton.cs.algs4.DijkstraSP;
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

    /**
     *
     * @param nomePublicacao
     * @param anoInicio
     * @param anoFim
     * @param artigos
     * @return
     */
    public List<Artigo> listarArtigosPorPublicacao(String nomePublicacao, Hashtable<Integer, Artigo> artigos) {
        List<Artigo> resultado = new ArrayList<>();
        for (Artigo artigo : artigos.values()) {
            if (artigo.getTipoPublicacao().equalsIgnoreCase(nomePublicacao) &&
                    artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
                resultado.add(artigo);
            }
        }
        return resultado;
    }

    public int citacoesDePrimeiraOrdem(Artigo artigo) {
        return citacoes.indegree(artigo.getId());
    }

    public int citacoesDeSegundaOrdem(Artigo artigo) {
        int count = 0;
        for (DirectedEdge e : citacoes.adj(artigo.getId())) {
            count += citacoes.indegree(e.to());
        }
        return count;
    }

    public int autocitacoes(Artigo artigo, Hashtable<Integer, Artigo> artigos) {
        Set<String> autores = new HashSet<>(artigo.getAutores());
        int count = 0;
        for (DirectedEdge e : citacoes.adj(artigo.getId())) {
            Artigo citado = artigos.get(e.to());
            for (String autor : citado.getAutores()) {
                if (autores.contains(autor)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    public EdgeWeightedDigraph getTemporalGraph() {
        EdgeWeightedDigraph temporalGraph = new EdgeWeightedDigraph(citacoes.V());
        for (DirectedEdge e : citacoes.edges()) {
            double weight = e.weight()[0]; // Supondo que o peso temporal é o primeiro elemento do array attr
            temporalGraph.addEdge(new DirectedEdge(e.from(), e.to(), weight));
        }
        return temporalGraph;
    }

    public double caminhoMaisCurto(int fromId, int toId) {
        EdgeWeightedDigraph temporalGraph = getTemporalGraph();
        DijkstraSP sp = new DijkstraSP(temporalGraph, fromId);
        return sp.distTo(toId);
    }

    public GrafoArtigos subgrafoPorTipoPublicacao(String tipoPublicacao, Hashtable<Integer, Artigo> artigos) {
        List<Integer> vertices = new ArrayList<>();
        for (Artigo artigo : artigos.values()) {
            if (artigo.getTipoPublicacao().equalsIgnoreCase(tipoPublicacao)) {
                vertices.add(artigo.getId());
            }
        }
        GrafoArtigos subgrafo = new GrafoArtigos(vertices.size());
        for (int v : vertices) {
            for (DirectedEdge e : citacoes.adj(v)) {
                if (vertices.contains(e.to())) {
                    subgrafo.citacoes.addEdge(e);
                }
            }
        }
        return subgrafo;
    }


    public boolean isConexo() {
        DepthFirstSearch dfs = new DepthFirstSearch(citacoes, 0);
        for (int v = 0; v < citacoes.V(); v++) {
            if (!dfs.marked(v)) {
                return false;
            }
        }
        return true;
    }

}