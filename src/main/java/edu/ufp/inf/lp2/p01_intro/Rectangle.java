package edu.ufp.inf.lp2.p01_intro;

import java.util.Objects;

import static java.lang.Math.abs;

public class Rectangle {

    private Point ulc;

    private Point lrc;

    public Rectangle(Point ulc, Point lrc) {
        this.ulc = ulc;
        this.lrc = lrc;
    }

    public void move(float dx, float dy) {
        this.lrc.move(dx, dy);
        this.ulc.move(dx, dy);
    }

    public float area() {
        float dx = abs(this.ulc.disX(lrc));
        float dy = abs(this.ulc.disY(lrc));
        return dx * dy;
    }

    public float perimeter() {
        float dx = abs(this.ulc.disX(lrc));
        float dy = abs(this.ulc.disY(lrc));
        return ((dx * 2) + (dy * 2));
    }

    public boolean isInside(Point p) {
        return ((p.getY() >= lrc.getY() && p.getY() <= ulc.getY()) && (p.getX() >= ulc.getX() && p.getX() <= lrc.getX()));
    }

    public boolean isOutside(Point p) {
        return !isInside(p);
    }

    public Point getUlc() {
        return ulc;
    }

    public void setUlc(Point ulc) {
        this.ulc = ulc;
    }

    public Point getLrc() {
        return lrc;
    }

    public void setLrc(Point lrc) {
        this.lrc = lrc;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "ulc=" + ulc +
                ", lrc=" + lrc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(ulc, rectangle.ulc) && Objects.equals(lrc, rectangle.lrc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ulc, lrc);
    }

    public static void main(String[] args) {
        Point p0 = new Point(1.0f, 2.0f);
        Point p1 = new Point(0.0f, 1.0f);
        Point p2 = new Point(5.0f, 1.0f);
        Point p3 = new Point(4.0f, 3.0f);

        Rectangle r0 = new Rectangle(p0, p1);
        Rectangle r1 = new Rectangle(p2, p3);


    }
}