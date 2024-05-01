package edu.ufp.inf.aed2.aula_01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;


public class File_Tests {
    public static void generateFile_p(String filename, Integer quantity) {

        Out out = new Out(filename);

        for (int i = 0; i < quantity; i++) {
            out.println(StdRandom.uniform(1000, 9999));
        }

        out.close();
    }

    public static void loadIntsFile_p(String filename) {

        In in = new In(filename);
        String line;

        while (in.hasNextLine()){
            line = in.readLine();
            System.out.println(line);
        }

        in.close();
    }
}
