package edu.ufp.inf.PROJETO_AED2LP2_2024;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import edu.princeton.cs.algs4.StdOut;

public class DirectedEdge {
    private final int v;
    private final int w;
    private final double[] weight;

    public DirectedEdge(int v, int w, double[] weight) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertex names must be non-negative integers");
        } else if (w < 0) {
            throw new IllegalArgumentException("Vertex names must be non-negative integers");
        } else if (weight.length != 2) {
            throw new IllegalArgumentException("Weight is NaN");
        } else {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }

    public int from() {
        return this.v;
    }

    public int to() {
        return this.w;
    }

    public double[] weight() {
        return this.weight;
    }

    public String toString() {
        int var10000 = this.v;
        return "" + var10000 + "->" + this.w + " " + String.format("%5.2f", this.weight);
    }

    public static void main(String[] args) {
        edu.princeton.cs.algs4.DirectedEdge e = new edu.princeton.cs.algs4.DirectedEdge(12, 34, 5.67);
        StdOut.println(e);
    }
}
