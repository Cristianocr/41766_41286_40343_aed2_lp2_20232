package edu.ufp.inf.lp2.p01_intro;

import java.util.Objects;

import static java.lang.Math.abs;

public class Circle {

    private Point center;

    private Point periferic;

    public Circle(Point center, Point periferic) {
        this.center = center;
        this.periferic = periferic;
    }

    public void move(float dx, float dy) {
        this.center.move(dx, dy);
        this.periferic.move(dx, dy);
    }

    public float area() {
        float dist = radius();
        return dist * dist * (float) Math.PI;
    }

    public float perimeter() {
        float r = radius();
        return (float) Math.PI * 2 * r;
    }

    public float radius() {
        return abs(this.center.dist(periferic));
    }

    public boolean isInside(Point p) {
        return (abs(this.center.dist(p)) <= this.radius());
    }

    public boolean isOutside(Point p) {
        return !isInside(p);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getPeriferic() {
        return periferic;
    }

    public void setPeriferic(Point periferic) {
        this.periferic = periferic;
    }

    @Override
    public String toString() {
        return "Circle{" + "center=" + center + ", periferic=" + periferic + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Objects.equals(center, circle.center) && Objects.equals(periferic, circle.periferic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, periferic);
    }

    public static void main(String[] args) {
    }
}