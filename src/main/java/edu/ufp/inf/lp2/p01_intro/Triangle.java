package edu.ufp.inf.lp2.p01_intro;

import java.util.Objects;

import static java.lang.Math.abs;

public class Triangle {

    private Point upperpt;

    public Point lowerLeftpt;

    public Point lowerRightpt;

    public Triangle(Point upperpt, Point lowerLeftpt, Point lowerRightpt) {
        this.upperpt = upperpt;
        this.lowerLeftpt = lowerLeftpt;
        this.lowerRightpt = lowerRightpt;
    }

    public void move(float dx, float dy) {
        this.upperpt.move(dx, dy);
        this.lowerLeftpt.move(dx, dy);
        this.lowerRightpt.move(dx, dy);
    }

    public double area(Point A, Point B, Point C) {
        return Math.abs((A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY()) + C.getX() * (A.getY() - B.getY())) / 2.0);
    }

    public float perimeter() {
        float a = abs(this.upperpt.dist(lowerRightpt));
        float b = abs(this.upperpt.dist(lowerLeftpt));
        float c = abs(this.lowerLeftpt.dist(lowerRightpt));
        return a + b + c;
    }

    public boolean isInside(Point p) {
        double areaTotal = area(this.upperpt, this.lowerLeftpt, this.lowerRightpt);

        /* Calcular a área dos três subtriângulos formados por P e dois vértices do triângulo ABC */
        double area1 = area(p, this.upperpt, this.lowerLeftpt);
        double area2 = area(p, this.lowerLeftpt, this.lowerRightpt);
        double area3 = area(p, this.lowerRightpt, this.upperpt);

        /* Se a soma das áreas dos três subtriângulos for igual à área total, então o ponto está dentro do triângulo */
        return areaTotal == area1 + area2 + area3;
    }

    public boolean isOutside(Point p) {
        return !isInside(p);
    }

    public Point getUpperpt() {
        return upperpt;
    }

    public void setUpperpt(Point upperpt) {
        this.upperpt = upperpt;
    }

    public Point getLowerLeftpt() {
        return lowerLeftpt;
    }

    public void setLowerLeftpt(Point lowerLeftpt) {
        this.lowerLeftpt = lowerLeftpt;
    }

    public Point getLowerRightpt() {
        return lowerRightpt;
    }

    public void setLowerRightpt(Point lowerRightpt) {
        this.lowerRightpt = lowerRightpt;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "upperpt=" + upperpt +
                ", lowerLeftpt=" + lowerLeftpt +
                ", lowerRightpt=" + lowerRightpt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(upperpt, triangle.upperpt) && Objects.equals(lowerLeftpt, triangle.lowerLeftpt) && Objects.equals(lowerRightpt, triangle.lowerRightpt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upperpt, lowerLeftpt, lowerRightpt);
    }

    public static void main(String[] args) {
    }
}