package edu.ufp.inf.aed2;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.ufp.inf.aed2.aula_01.BinarySearch_Tests;
import edu.ufp.inf.aed2.aula_01.QSort_Tests;
import edu.ufp.inf.aed2.aula_02.ST_BinarySearch_Tests;
import edu.ufp.inf.aed2.aula_05.testHash;

import java.util.Scanner;

import static edu.ufp.inf.aed2.aula_05.testHash.hash;


public class MainTestPrincetonAlgs4 {
    public static void main(String[] args) {
        System.out.println("MainTestPrincetonAlgs4->main(): test Princeton algs4!");
        /**
         * aula_01
         exemplo1_princeton();
         binarySearch_test();
         qSort_Test();
         **/

        /*aula_02
        St_tests();*/
        hashTest();
    }

    /**
     * aula_01
     */
    public static void exemplo1_princeton() {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();

        st.put("Azul", 10);
        st.put("Verde", 50);
        System.out.println("Tabela (inicial):");
        for (String s : st.keys()) {
            System.out.println(s + "-" + st.get(s));
        }
        st.put("Azul", 25);
        st.put("Verde", 75);
        System.out.println("Tabela (depois de atualizar):");
        for (String s : st.keys()) {
            System.out.println(s + "-" + st.get(s));
        }

    }

    public static void binarySearch_test() {
        Scanner scanner = new Scanner(System.in);
        int quantity = 10;
        int[] numbers = null;
        int numberToSearch;
        int position;

        numbers = BinarySearch_Tests.generateInts(quantity);
        BinarySearch_Tests.show(numbers);

        System.out.printf("insert a number to search: \n");
        numberToSearch = scanner.nextInt();

        position = BinarySearch_Tests.search(numbers, numberToSearch);
        System.out.printf("the position is %d\n", position);
    }

    public static void qSort_Test() {
        int quantity = 10;
        Integer[] numbers = null;

        numbers = QSort_Tests.generateInts(quantity);
        QSort_Tests.show(numbers);

        QSort_Tests.sort(numbers);
        QSort_Tests.show(numbers);

    }

    /**
     * aula_02
     */

    public static void st_tests() {

        BinarySearchST<String, Integer> ages = new BinarySearchST<>();

        ages = ST_BinarySearch_Tests.generateAges();
        ST_BinarySearch_Tests.showST3(ages);
        ST_BinarySearch_Tests.showST4(ages, "Cristiano", "Zeza");
    }


    /**
     * aula_05
     */

    public static void hashTest(){
        //testHash.ex1_1(256);
        testHash.ex4(7);
    }




}