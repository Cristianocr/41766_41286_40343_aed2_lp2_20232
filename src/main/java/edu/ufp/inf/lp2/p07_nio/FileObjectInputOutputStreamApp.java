package edu.ufp.inf.lp2.p07_nio;

import edu.ufp.inf.lp2.p05_figgeo.Point;
import edu.ufp.inf.lp2.p05_figgeo.Circle;
import edu.ufp.inf.lp2.p05_figgeo.Rectangle;

import java.awt.*;
import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileObjectInputOutputStreamApp {

    public static void main(String[] args) {
        String filename = (args.length == 1 ? args[0] : "data/Date.bin");
        //1st write objetcs into file
        fileObjectOutputStream(filename);
        //2nd read objects from file
        fileObjectInputStream(filename);
    }

    public static void fileObjectOutputStream(String filepath) {
        Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO, "fileObjectOutputStream(): write objects into file " + filepath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))){
            // Create message and Date objects
            String msg = "Today's Date:";
            Date today = new Date(System.currentTimeMillis());
            // Write String object followed by Date object
            oos.writeObject(msg);
            oos.writeObject(today);
            // Manipulate the classes Point and...
            Point p = new Point(1.0, 1.0);
            // Since Rectangle uses Point, then it needs to be serializable too
            // NB: Point and FigGeo must implement Serializable
            // NB: Rectangle extends FigGeo, hence, it does not need to implement Serializable
            Rectangle r = new Rectangle( Color.BLUE, new Point(0.0, 1.0), new Point(1.0, 0.0));
            //The same for Circle...
            Circle c = new Circle(new Point(0.0, 0.0), 1.0, Color.BLUE);
            // Write serialized objects into file
            oos.writeObject(p);
            oos.writeObject(r);
            oos.writeObject(c);
        } catch (IOException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void fileObjectInputStream(String filepath) {
        Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO, "fileObjectInputStream(): read objects from file " + filepath);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            // We must read and cast in the same order all saved objects
            String msg = (String) ois.readObject();
            Date today = (Date) ois.readObject();

            // Print out content
            System.out.println(msg + " " + today.toString());

            // Create objects from the file stream
            Point p = (Point) ois.readObject();
            Rectangle r = (Rectangle) ois.readObject();
            Circle c = (Circle) ois.readObject();

            System.out.println(p.toString());
            System.out.println(r.toString());
            System.out.println(c.toString());

        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }
    }
}

