package edu.ufp.inf.lp2.p01_intro;

import java.util.ArrayList;

public class MyArrayDemo {
    public static void main(String[] args) {
        testArrayPrimitives();
        testArrayObjects();
        testRawArrayList();
    }

    public static void testArrayPrimitives() {
        int[] intArray = new int[3];
        float floatArray[] = new float[3];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = 2;
            System.out.println(intArray[i]);
        }

        //intArray[3] = 4; vai dar erro por estar a acessar memoria nao definida

    }

    public static void testArrayObjects() {

        Point[] pointArray = new Point[3];

        for (int i = 0; i < pointArray.length; i++) {
            pointArray[i] = new Point((float) i, (float) i);
            System.out.println(pointArray[i]);
        }

    }

    public static void testRawArrayList() {
        ArrayList arrayList1 = new ArrayList();

        arrayList1.add(new Point(0.0f, 0.0f));
        arrayList1.add("Hello");
        arrayList1.add(1);

        Point p1 = (Point) arrayList1.get(0);

        System.out.println("\n" + p1 + "\n" + arrayList1.get(1) + "\n" + arrayList1.get(2));

    }


}
