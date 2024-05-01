package edu.ufp.inf.lp2.p05_figgeo;

import java.awt.*;

import static java.lang.Math.abs;

public class Rectangle extends FigGeo {

    public Rectangle() {
        super();
    }

    public Rectangle(Color c) {
        super(c);
    }

    public Rectangle(Color c, Point upLeft, Point lowRight) {
        this(c);
        super.addPoint(upLeft);
        super.addPoint(lowRight);
    }

    @Override
    public double area() {
        Point upLeft = super.getPoint(0);
        Point lowRight = super.getPoint(1);
        return upLeft.disX(lowRight) * upLeft.disY(lowRight);
    }

    @Override
    public double perimeter() {
        Point upLeft = super.getPoint(0);
        Point lowRight = super.getPoint(1);
        return upLeft.disX(lowRight) * 2 + upLeft.disY(lowRight) * 2;
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public boolean isInside(FigGeo f) {
        Rectangle fRectangle = (Rectangle) f;
        Point fUpLeft = fRectangle.getPoint(0);
        Point fLowerRight = fRectangle.getPoint(1);
        Point upLeft = this.getPoint(0);
        Point lowRigth = this.getPoint(1);

        return (fUpLeft.getY() <= upLeft.getY() && fUpLeft.getX() >= upLeft.getX() &&
                fLowerRight.getY() >= lowRigth.getY() && fLowerRight.getX() <= lowRigth.getX());
    }

    @Override
    public boolean isInterceptedBy(FigGeo f) {
        Rectangle fRectangle = (Rectangle) f;
        Point fUpLeft = fRectangle.getPoint(0);
        Point fLowerRight = fRectangle.getPoint(1);
        Point upLeft = this.getPoint(0);
        Point lowRigth = this.getPoint(1);

        return fUpLeft.isBetweenX(upLeft, lowRigth) || fUpLeft.isBetweenY(upLeft, lowRigth)||
                fLowerRight.isBetweenX(upLeft, lowRigth)||fLowerRight.isBetweenY(upLeft, lowRigth);
    }

    @Override
    public String toString() {
        return "Rectangle{}";
    }
}