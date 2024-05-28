package edu.ufp.inf.PROJETO_AED2LP2_2024;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Stack;

import java.util.*;

public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        } else {
            if(V == 0){
                this.V = 1;
            }else{
                this.V = V;
            }
            this.E = 0;
            this.adj = new Bag[V];

            for (int v = 0; v < V; ++v) {
                this.adj[v] = new Bag();
            }

        }
    }

    public EdgeWeightedGraph(int V, int E) {
        this(V);
        if (E < 0) {
            throw new IllegalArgumentException("Number of edges must be non-negative");
        } else {
            for (int i = 0; i < E; ++i) {
                int v = StdRandom.uniformInt(V);
                int w = StdRandom.uniformInt(V);
                Edge e = new Edge(v, w);
                this.addEdge(e);
            }

        }
    }

    public EdgeWeightedGraph(In in) {
        if (in == null) {
            throw new IllegalArgumentException("argument is null");
        } else {
            try {
                this.V = in.readInt();
                this.adj = new Bag[this.V];

                int E;
                for (E = 0; E < this.V; ++E) {
                    this.adj[E] = new Bag();
                }

                E = in.readInt();
                if (E < 0) {
                    throw new IllegalArgumentException("Number of edges must be non-negative");
                } else {
                    for (int i = 0; i < E; ++i) {
                        int v = in.readInt();
                        int w = in.readInt();
                        this.validateVertex(v);
                        this.validateVertex(w);
                        double weight = in.readDouble();
                        int[] ids = in.readAllInts();
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        for (int id : ids) {
                            arrayList.add(id);
                        }
                        Edge e = new Edge(v, w, arrayList);
                        this.addEdge(e);
                    }

                }
            } catch (NoSuchElementException var9) {
                NoSuchElementException e = var9;
                throw new IllegalArgumentException("invalid input format in EdgeWeightedGraph constructor", e);
            }
        }
    }

    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.V());
        this.E = G.E();

        for (int v = 0; v < G.V(); ++v) {
            Stack<Edge> reverse = new Stack();
            Iterator var4 = G.adj[v].iterator();

            Edge e;
            while (var4.hasNext()) {
                e = (Edge) var4.next();
                reverse.push(e);
            }

            var4 = reverse.iterator();

            while (var4.hasNext()) {
                e = (Edge) var4.next();
                this.adj[v].add(e);
            }
        }

    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= this.V) {
            throw new IllegalArgumentException("Graph: vertex " + v + " is not between 0 and " + (this.V - 1));
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        this.validateVertex(v);
        this.validateVertex(w);
        this.adj[v].add(e);
        this.adj[w].add(e);
        ++this.E;
    }

    public Iterable<Edge> adj(int v) {
        this.validateVertex(v);
        return this.adj[v];
    }

    public int degree(int v) {
        this.validateVertex(v);
        return this.adj[v].size();
    }

    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag();

        for (int v = 0; v < this.V; ++v) {
            int selfLoops = 0;
            Iterator var4 = this.adj(v).iterator();

            while (var4.hasNext()) {
                Edge e = (Edge) var4.next();
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }

                    ++selfLoops;
                }
            }
        }

        return list;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.V + " " + this.E + NEWLINE);

        for (int v = 0; v < this.V; ++v) {
            s.append("" + v + ": ");
            Iterator var3 = this.adj[v].iterator();

            while (var3.hasNext()) {
                Edge e = (Edge) var3.next();
                s.append("" + e + "  ");
            }

            s.append(NEWLINE);
        }

        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        StdOut.println(G);
    }
}
