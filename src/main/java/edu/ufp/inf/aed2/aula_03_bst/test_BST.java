package edu.ufp.inf.aed2.aula_03_bst;


import edu.princeton.cs.algs4.StdRandom;



public class test_BST {
    public static void bst_test1(){
        BST_AED2_UFP< Integer, Integer> bst = new BST_AED2_UFP<Integer, Integer>();

        int [] keys = {4,2,6,1,3,5,7};
        Iterable<Integer> numbers;

        for(Integer x : keys){
            bst.put(x, StdRandom.uniformInt(1000, 9999));
        }


        System.out.printf("Number of leafs: %d\n", bst.leafCount());
        System.out.printf("Number of keys: %d\n", bst.keysCount());
        System.out.printf("Number of even keys: %d\n", bst.evenKeysCount());
        //System.out.printf("Tree Height: %d\n", bst.treeHeight());

        System.out.println("keys by tree level...");
        numbers = bst.getKeysByLevel();
        //show(numbers);

        System.out.println("print keys inorder...");
        numbers = bst.inorder();
        //show(numbers);
    }

}
