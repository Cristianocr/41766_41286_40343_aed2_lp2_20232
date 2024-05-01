package edu.ufp.inf.lp2.p05_figgeo;

import java.awt.*;

import static java.lang.Math.PI;

public class Circle extends FigGeo {

    private float radius;

    public Circle() {

    }

    public Circle(Color c, float radius) {
        super(c);
        this.radius = radius;
    }

    public Circle(Color c, float radius, Point center) {
        this(c, radius);
        super.addPoint(center);
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public boolean isInside(FigGeo f) {
        Circle fCircle = (Circle) f;
        Point fCenter = fCircle.getPoint(0);
        Point center = this.getPoint(0);
        return center.dist(fCenter) <= fCircle.radius + this.radius;
    }

    @Override
    public boolean isInterceptedBy(FigGeo f) {
        Circle fCircle = (Circle) f;
        Point fCenter = fCircle.getPoint(0);
        Point center = this.getPoint(0);
        return center.dist(fCenter) <= this.radius - fCircle.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}