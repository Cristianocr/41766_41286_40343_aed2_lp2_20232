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

    public int hasWorkWith(Integer i) {
        return colaboracoes.degree(i);
    }

    public int hasWorkWith(Autor a) {
        return colaboracoes.degree(a.getId());
    }

    public int artigosEntre2Autores(Autor a, Autor b) {
        Edge e = findVwW(a, b);
        if (e != null) {
            return e.getArticleIds().size();
        }
        return 0;
    }

    public int calcularNumeroSaltos(Autor a, Autor b) {
        // Implementação de um algoritmo de caminho mais curto, como Dijkstra ou BFS
        return 1;
    }

    public GrafoAutores autoresMesmaFiliacao(String filiacao, BD bd) {
        GrafoAutores subGrafo = new GrafoAutores(colaboracoes.V());
        ArrayList<Autor> autores = getAutores(bd.getAutoresID());
        for (int v = 0; v < colaboracoes.V(); v++) {
            if (colaboracoes.adj(v).iterator().hasNext()) {
                if (autores.get(v).getFiliacao().equals(filiacao)) {
                    for (Edge e : colaboracoes.adj(v)) {
                        if (autores.get(e.other(v)).getFiliacao().equals(filiacao)) {
                            subGrafo.colaboracoes.addEdge(e);
                        }
                    }
                }
            }
        }
        return subGrafo;
    }

    /**
     * @param a
     * @return
     */
    public ArrayList<Autor> getAutores(Hashtable<Integer, Autor> a) {
        ArrayList<Autor> autores = new ArrayList<>();
        for (Integer i : a.keySet()) {
            if (colaboracoes.adj(i) != null) {
                autores.add(a.get(i));
            }
        }
        return autores;
    }

    /**
     * @param edges
     * @return
     */
    public boolean isIterableEmpty(Iterable<Edge> edges) {
        return !edges.iterator().hasNext();
    }

    /**
     * @return
     */
    public boolean isConexo() {
        boolean[] marked = new boolean[colaboracoes.V()];
        int count = dfs(0, marked);
        return count == colaboracoes.V();
    }

    /**
     * @param v
     * @param marked
     * @return
     */
    private int dfs(int v, boolean[] marked) {
        marked[v] = true;
        int count = 1;
        for (Edge e : colaboracoes.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) {
                count += dfs(w, marked);
            }
        }
        return count;
    }

    /**
     * @param artigos
     * @return
     */
    public ArrayList<Integer> autoresPorArtigos(ArrayList<Artigo> artigos) {
        ArrayList<Integer> artigos1 = convertArtigos(artigos);
        ArrayList<Integer> visualizados = new ArrayList<>();
        ArrayList<Integer> resultado = new ArrayList<>();
        int size = artigos.size();
        for (int v = 0; v < colaboracoes.V(); v++) {
            if (colaboracoes.adj(v).iterator().hasNext()) {
            } else {
                for (Edge e : colaboracoes.adj(v)) {
                    //ajeitar isto - está mal
                    visualizados = findCommonElements(visualizados, findCommonElements(e.getArticleIds(), artigos1));
                    if (visualizados.size() == size) {
                        resultado.add(v);
                        break;
                    }
                }
            }
        }
        return resultado;
    }

    public ArrayList<Integer> convertArtigos(ArrayList<Artigo> artigo) {
        ArrayList<Integer> resultado = new ArrayList<>();
        for (Artigo a : artigo) {
            resultado.add(a.getId());
        }
        return resultado;
    }

    public ArrayList<Integer> findCommonElements(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        HashSet<Integer> set = new HashSet<>(list1);
        ArrayList<Integer> commonElements = new ArrayList<>();

        for (Integer element : list2) {
            if (set.contains(element)) {
                commonElements.add(element);
            }
        }
        return commonElements;
    }


    /*public Map<Integer, List<Autor>> citacoesPorJournal(String journal) {
        Map<Integer, List<Autor>> resultado = new HashMap<>();
        for (int v = 0; v < colaboracoes.V(); v++) {
            Autor autor = // método para obter o autor pelo id v;
            for (Edge e : colaboracoes.adj(v)) {
                for (Integer artigoId : e.getArticleIds()) {
                    Artigo artigo = // método para obter artigo pelo id;
                    if (artigo.getJournal().equals(journal) && // método para verificar se está no período ) {
                        resultado.putIfAbsent(artigoId, new ArrayList<>());
                        resultado.get(artigoId).add(autor);
                    }
                }
            }
        }
        return resultado;
    }*/
}