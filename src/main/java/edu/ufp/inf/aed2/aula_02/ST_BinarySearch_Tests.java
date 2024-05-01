package edu.ufp.inf.aed2.aula_02;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.BinarySearchST;

public class ST_BinarySearch_Tests {

    public static BinarySearchST<String, Integer> generateAges() {
        BinarySearchST<String, Integer> st;

        st = new BinarySearchST<String, Integer>();
        st.put("Fernando", 18);
        st.put("Antonio", 23);
        st.put("Maria", 17);
        st.put("Manel", 23);
        st.put("Zeferino", 16);
        st.put("Rita", 20);

        return st;
    }

    public static void showST3(BinarySearchST<String, Integer> st) {
        for (String k : st.keys()) {
            System.out.printf("KEY: %-10s, VALUE %d, RANK: %d\n", k, st.get(k), st.rank(k));
        }

        System.out.printf("FLOOR(\"Matilde\"): %s\n", st.floor("Matilde"));

        System.out.printf("CEILING(\"Bernardo\"): %s\n", st.ceiling("Bernardo"));

        System.out.printf("MIN: %s\n", st.min());

        System.out.printf("MAX: %s\n", st.max());

        System.out.printf("SIZE: %d\n", st.size());
    }

    public static void showST4(BinarySearchST<String, Integer> st, String from, String to) {
        System.out.printf("Names between \"%s\" e \"%s\": ", from, to);
        for (String name : st.keys(from, to)) {
            System.out.printf("%s ", name);
        }
    }

}
