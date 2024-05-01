package edu.ufp.inf.lp2.p01_intro;

import java.util.Objects;

public class Point {

    private float x;

    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float disX(Point p) {
        return this.x - p.x;
    }

    public float disY(Point p) {
        return this.y - p.y;
    }

    public float dist(Point p) {
        float dx = this.disX(p);
        float dy = this.disY(p);
        return (float) Math.sqrt((dx * dx + dy * dy));
    }

    public void moveX(float delta) {
        this.x += delta;
    }

    public void moveY(float delta) {
        this.y += delta;
    }

    public void move(float deltaX, float deltaY) {
        this.moveX(deltaX);
        this.moveY(deltaY);
    }

    public boolean isBetweenX(Point pleft, Point pright) {
        return this.x > pleft.x && this.x < pright.x;
    }

    public boolean isBetweenY(Point pupper, Point plower) {
        return this.y > pupper.y && this.y < plower.y;
    }

    /**
     *
     * @param pleft
     * @param pright
     * @return
     */
    public boolean isBetween(Point pleft, Point pright) {
        return this.isBetweenX(pleft, pright) && isBetweenY(pleft, pright);
    }

    public void printPoint() {
        System.out.println("Point = x: " + this.x + "y: " + this.y + "\n");
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Float.compare(x, point.x) == 0 && Float.compare(y, point.y) == 0;
    }

    public Point() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point p0 = new Point(1.0f, 2.0f);
        Point p1 = new Point(0.0f, 1.0f);
    }
}