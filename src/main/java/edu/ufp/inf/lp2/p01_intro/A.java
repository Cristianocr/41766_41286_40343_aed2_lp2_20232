package edu.ufp.inf.lp2.p01_intro;

import java.util.ArrayList;

public class A {
    @Override
    public String toString() {
        return super.toString();
    }

    public A() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);

        Object o = new Object();
        o = new A();
        o = new Point(0.0f, 0.0f);

        ((Point) o).dist(new Point(1.0f, 1.0f));

        Rectangle r = new Rectangle(new Point(0.0f, 1.0f), new Point(1.0f, 0.0f));
        o = r;
        System.out.println(((Rectangle) o).isInside(new Point(0.5f, 0.5f)));

    }

    static void testGenerifiedArrayList() {
        ArrayList<Point> arrayList1 = new ArrayList<>();

        arrayList1.add(new Point(1.0f, 1.0f));
        arrayList1.add(new Point(2.0f, 2.0f));

        Point p3 = new Point();

        arrayList1.add(p3);

        System.out.println(arrayList1.indexOf(p3));
    }
}
