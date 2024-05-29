package edu.ufp.inf.PROJETO_AED2LP2_2024;


import edu.princeton.cs.algs4.DepthFirstSearch;
import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

/**
 * This class represents a graph of articles.
 * It provides methods to manipulate and analyze the graph, such as adding citations between articles,
 * removing citations, calculating various citation-related metrics, and extracting subgraphs based on publication types.
 */
public class GrafoArtigos {

    EdgeWeightedDigraph citacoes;


    /**
     * Constructs a graph of articles with the specified number of vertices.
     *
     * @param V The number of vertices in the graph.
     */
    public GrafoArtigos(int V) {
        if (V == 0) {
            this.citacoes = new EdgeWeightedDigraph(1);
        }
        this.citacoes = new EdgeWeightedDigraph(V);
    }


    /**
     * Constructs a graph of articles based on a hashtable of articles.
     *
     * @param artigos A hashtable containing articles where the keys are article IDs and the values are articles.
     */
    public GrafoArtigos(Hashtable<Integer, Artigo> artigos) {
        this.citacoes = new EdgeWeightedDigraph(artigos.size());
    }

    public void increaseGraph(int i) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(i * 3);
        this.citacoes = new EdgeWeightedDigraph(G);

    }


    /**
     * Adds citations between two articles.
     * If the target article ID is greater than the number of vertices in the graph, the graph is resized.
     *
     * @param from The source article.
     * @param to   The target article.
     */
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

    /*public void removerCitacao(Artigo from, Artigo to) {
        if (citacoes.adj(from.getId()).iterator().hasNext()) {
            for (Iterator<DirectedEdge> iterator = citacoes.adj(from.getId()).iterator(); iterator.hasNext(); ) {
                DirectedEdge edge = iterator.next();
                if (edge.to() == to.getId()) {
                    iterator.remove(); // Remover a aresta
                    break; // Parar o loop após remover a primeira ocorrência da aresta
                }
            }
        }
    }*/

    /**
     * grau de saida citacoes
     * @param a
     * @return
     */
    public int outDegree(Artigo a) {
        return citacoes.outdegree(a.getId());
    }

    /**
     * Grau de entrada citacoes
     * @param a
     * @return
     */
    public int intDegree(Artigo a) {
        return citacoes.indegree(a.getId());
    }

    /**
     * imprime citacoes de um artigo
     * @param a
     */
    public void imprimirCitacoes(Artigo a) {
        Iterable<DirectedEdge> iterator = citacoes.adj(a.getId());
        for (DirectedEdge e : iterator) {
            StdOut.println(e.toString());
        }
    }

    /**
     * imprime o grafo
     */
    public void imprimirGrafo() {
        Iterable<DirectedEdge> iterator = citacoes.edges();
        for (DirectedEdge e : iterator) {
            StdOut.println(e.toString());
        }
    }

    /**
     * lista os artigos pelo tipo publicacao
     * @param tipoPublicacao
     * @param artigos
     */
    public void listarArtigosTipoPublicacao(Publicacao tipoPublicacao, Hashtable<Integer, Artigo> artigos) {
        String s;
        if (tipoPublicacao instanceof Conference) {
            System.out.println("Artigos de Conferencia\n");
            s = "Conference";
        } else {
            System.out.println("Artigos de Journal \n");
            s = "Journal";
        }
        for (int v = 0; v < citacoes.V(); v++) {
            if (citacoes.adj(v).iterator().hasNext()) {
                if (artigos.get(v).getTipoPublicacao().equals(s)) {
                    System.out.println("Artigo " + v + ": " + artigos.get(v).getTitulo());
                }
            }
        }
    }

    /**
     * lista os artigos por que os publica
     * @param tipoPublicacao
     * @param artigos
     */
    public void listarArtigosPorPublicador(Publicacao tipoPublicacao, Hashtable<Integer, Artigo> artigos) {
        if (tipoPublicacao instanceof Conference) {
            System.out.println("Artigos da Conferencia" + ((Conference) tipoPublicacao).getNome() + "\n");
        } else {
            System.out.println("Artigos do Journal" + ((Journal) tipoPublicacao).getNome() + "\n");
        }
        for (int v = 0; v < citacoes.V(); v++) {
            if (citacoes.adj(v).iterator().hasNext()) {
                if (artigos.get(v).getPublicacao().getTitulo().equals(tipoPublicacao.getTipo())) {
                    System.out.println("Artigo " + v + ": " + artigos.get(v).getTitulo());
                }
            }
        }
    }

    /**
     * gets the indegree
     * @param artigo
     * @return indegree
     */
    public int citacoesDePrimeiraOrdem(Artigo artigo) {
        return citacoes.indegree(artigo.getId());
    }

    /**
     * citacoes
     * @param artigo
     * @return
     */
    public int citacoesDeSegundaOrdem(Artigo artigo) {
        int count = 0;
        for (DirectedEdge e : citacoes.adj(artigo.getId())) {
            count += citacoes.indegree(e.to());
        }
        return count;
    }


    /**
     *
     * @param artigo
     * @param artigos
     * @return
     */
    public int autocitacoes(Artigo artigo, Hashtable<Integer, Artigo> artigos) {
        int count = 0;
        int size= artigo.getAutores().size();
        for (DirectedEdge e : citacoes.adj(artigo.getId())) {
            Artigo citado = artigos.get(e.to());
            if (findCommonElements(citado.getAutores(), artigo.getAutores()) == size) {
                count++;
            }
        }
        return count;
    }


    /**
     * Finds the number of common elements between two ArrayLists of authors.
     *
     * @param list1 The first list of authors.
     * @param list2 The second list of authors.
     * @return The number of common elements between the two lists.
     */
    public int findCommonElements(ArrayList<Autor> list1, ArrayList<Autor> list2) {
        int count = 0;
        for (Autor autor : list1) {
            for (Autor value : list2) {
                if (autor.equals(value)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * Gets the temporal graph representing the citations with only one attribute (temporal information).
     *
     * @return The temporal graph.
     */
    public edu.princeton.cs.algs4.EdgeWeightedDigraph getTemporalGraph() {
        edu.princeton.cs.algs4.EdgeWeightedDigraph temporalGraph = new edu.princeton.cs.algs4.EdgeWeightedDigraph(citacoes.V());
        for (DirectedEdge e : citacoes.edges()) {
            double weight = e.weight()[0];
            temporalGraph.addEdge(new edu.princeton.cs.algs4.DirectedEdge(e.from(), e.to(), weight));
        }
        return temporalGraph;
    }

    /**
     * Computes the shortest path between two articles based on the temporal graph.
     *
     * @param fromId The ID of the source article.
     * @param toId   The ID of the target article.
     * @return The length of the shortest path between the source and target articles.
     */
    public double caminhoMaisCurto(int fromId, int toId) {
        edu.princeton.cs.algs4.EdgeWeightedDigraph temporalGraph = getTemporalGraph();
        DijkstraSP sp = new DijkstraSP(temporalGraph, fromId);
        return sp.distTo(toId);
    }


    /**
     * Extracts a subgraph containing only articles of a specific publication type.
     *
     * @param tipoPublicacao The type of publication (e.g., "Conference" or "Journal").
     * @param artigos         A hashtable containing articles where the keys are article IDs and the values are articles.
     * @return The subgraph containing only articles of the specified publication type.
     */
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


    /*public boolean isConexo() {
        DepthFirstSearch dfs = new DepthFirstSearch(citacoes, 0);
        for (int v = 0; v < citacoes.V(); v++) {
            if (!dfs.marked(v)) {
                return false;
            }
        }
        return true;
    }*/

}