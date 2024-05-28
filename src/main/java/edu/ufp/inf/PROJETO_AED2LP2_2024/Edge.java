package edu.ufp.inf.PROJETO_AED2LP2_2024;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private ArrayList<Integer> articleIds;

    public Edge() {
    }

    public Edge(int v, int w, ArrayList<Integer> articleIds) {
        if (v < 0) {
            throw new IllegalArgumentException("vertex index must be a non-negative integer");
        } else if (w < 0) {
            throw new IllegalArgumentException("vertex index must be a non-negative integer");
        } else {
            this.v = v;
            this.w = w;
            this.articleIds = articleIds;
        }
    }

    public Edge(int v, int w) {
        if (v < 0) {
            throw new IllegalArgumentException("vertex index must be a non-negative integer");
        } else if (w < 0) {
            throw new IllegalArgumentException("vertex index must be a non-negative integer");
        } else {
            this.v = v;
            this.w = w;
            this.articleIds = new ArrayList<>();
        }
    }

    public void addArtigo(Integer id) {
        this.articleIds.add(id);
    }

    public ArrayList<Integer> getArticleIds() {
        return this.articleIds;
    }

    public int either() {
        return this.v;
    }

    public int other(int vertex) {
        if (vertex == this.v) {
            return this.w;
        } else if (vertex == this.w) {
            return this.v;
        } else {
            throw new IllegalArgumentException("Illegal endpoint");
        }
    }

    @Override
    public int compareTo(Edge that) {
        return Integer.compare(this.articleIds.size(), that.articleIds.size());
    }

    public String toString() {
        return String.format("%d-%d %s", this.v, this.w, this.articleIds.toString());
    }

    public static void main(String[] args) {
        ArrayList<Integer> articleIds = new ArrayList<>();
        Edge e = new Edge(12, 34, articleIds);
        StdOut.println(e);
    }
}
