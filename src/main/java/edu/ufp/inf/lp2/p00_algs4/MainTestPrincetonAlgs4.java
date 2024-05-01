package edu.ufp.inf.lp2.p00_algs4;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

/**
 *
 * @author rui
 */
public class MainTestPrincetonAlgs4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("MainTestAlgs4->main(): tests for algs4 package!");

        //RedBlack organiza os nós de forma ordenada e permite pesquisas por intervalos
        RedBlackBST<Double, String> devices = new RedBlackBST();
        devices.put(0.0, "0.0");
        
        //SymbolTable organiza os dados, indexados por via de hash codes, facilitando a pesquisa
        ST<Double, String> st = new ST();
        st.put(0.0, "0.0");
        
        //Grafo dirigido cujos adges definem capacity e flow
        FlowNetwork fn = new FlowNetwork(10);
        //Add edge between  nodes 0->1, with capacity 10.0 and flow 5.0
        fn.addEdge(new FlowEdge(0,1,10.0, 5.0));
    }
}
