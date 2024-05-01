package edu.ufp.inf.aed2.aula_02;

import edu.princeton.cs.algs4.BinarySearchST;

public class ST_fichaEx {
    public static BinarySearchST<String, Integer> generateAges() {
        BinarySearchST<String, Integer> st;

        st = new BinarySearchST<String, Integer>();
        st.put("Excelente", 20);
        st.put("Muito Bom", 18);
        st.put("Bom", 16);
        st.put("Suficiente", 12);
        st.put("Insuficiente", 7);
        st.put("Fraco", 3);

        return st;
    }

    public static int ST_qualitativeCount(BinarySearchST<String, Integer> st, String[] notes){
        int media=0;
        for(String n : notes){
            media += st.get(n);
        }
        return media/ notes.length;
    }
}
