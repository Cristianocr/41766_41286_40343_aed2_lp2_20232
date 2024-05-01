package edu.ufp.inf.lp2.p05_figgeo;

import java.awt.*;

public class Triangle extends FigGeo {

    public Triangle() {
    }

    public Triangle(Color c) {
        super(c);
    }

    public Triangle(Color c, Point A, Point B, Point C) {
        super(c);
        super.addPoint(A);
        super.addPoint(B);
        super.addPoint(C);
    }

    public Triangle(Color c, float radius, Point A, Point B, Point C) {
        this(c, A, B, C);
        super.addPoint(A);
        super.addPoint(B);
        super.addPoint(C);
    }

    @Override
    public double area() {
        Point A = super.getPoint(0);
        Point B = super.getPoint(1);
        Point C = super.getPoint(2);

        return Math.abs((A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY())
                + C.getX() * (A.getY() - B.getY())) / 2.0);
    }

    @Override
    public double perimeter() {
        Point A = super.getPoint(0);
        Point B = super.getPoint(1);
        Point C = super.getPoint(2);

        return Math.abs((A.dist(B) + B.dist(C) + C.dist(A)));

    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public boolean isInside(FigGeo f) {
        return false;
    }

    @Override
    public boolean isInterceptedBy(FigGeo f) {
        return false;
    }

    public int compareTO(Triangle t) {
        return 0;
    }


    @Override
    public String toString() {
        return "Triangle{}";
    }
}