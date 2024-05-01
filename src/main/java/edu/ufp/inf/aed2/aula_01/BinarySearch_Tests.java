package edu.ufp.inf.aed2.aula_01;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

public class BinarySearch_Tests {
    public static int[] generateInts(int quantity) {

        int[] numbers = null;

        numbers = new int[quantity];

        for (int i = 0; i < quantity; i++) {
            numbers[i] = StdRandom.uniform(1000, 9999);
        }

        return numbers;
    }

    public static void show(int[] numbers) {
        for (int v : numbers) {
            System.out.printf("%d ", v);
        }
        System.out.printf("\n");
    }

    public static int search(int[] numbers, Integer search) {
        return BinarySearch.indexOf(numbers, search);
    }
}
