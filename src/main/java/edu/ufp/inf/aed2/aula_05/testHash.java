package edu.ufp.inf.aed2.aula_05;

public class testHash {

    public static int hash(int key, int M) {
        if(key%M >= 7){
            return 6;
        }
        return key % M;
    }

    public static void ex1_1(int M){
        int[] hashValues = new int[(int) Math.pow(2, 16)];

        for (int key = 0; key < Math.pow(2, 16); key++) {
            int hashValue = hash(key, M);
            hashValues[key] = hashValue;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Key: " + i + " -> Hash Value: " + hashValues[i]);
        }

    }


    public static void ex4(int M){
        int[] meuArray = {1, 8, 27, 64, 125, 216, 343};
        int[] hashValues = new int[M];

        for(int k : meuArray){
            int hashValue = hash(k, M);
            hashValues[hashValue] = k;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Key: " + i + " -> Hash Value: " + hashValues[i]);
        }

    }

}