package edu.ufp.inf.aed2.aula_01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

public class QSort_Tests {

    public static Integer[] generateInts(Integer quantity){
        Integer[] numbers = null;

        numbers = new Integer[quantity];

        for(int i =0; i<quantity; i++){
            numbers[i] = StdRandom.uniform(1000, 9999);
        }

        return numbers;
    }

    public static void show (Integer[] numbers){
        for(int v:numbers){
            System.out.printf("%d ", v);
        }
        System.out.printf("\n");
    }

    public static void sort(Integer[] numbers){
        //Quick.sort(numbers);
        Merge.sort(numbers);
    }
}
