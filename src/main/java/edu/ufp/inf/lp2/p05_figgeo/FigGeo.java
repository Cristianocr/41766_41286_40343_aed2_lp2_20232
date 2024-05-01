package edu.ufp.inf.lp2.p05_figgeo;

import java.awt.*;
import java.util.ArrayList;

public abstract class FigGeo implements FigGeoDimsI, FigGeoDrawI, FigGeoRelsI {
    private Color color;

    private ArrayList<Point> points = new ArrayList<>();

    public FigGeo(){
    }

    public FigGeo(Color c){
        color =c;
    }

    public void addPoint(Point p) {
        if(!this.points.contains(p)){
            this.points.add(p);
        }
    }

    public Point getPoint(int index) {
        return (index >0 && index < this.points.size()) ? this.points.get(index) : null;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
