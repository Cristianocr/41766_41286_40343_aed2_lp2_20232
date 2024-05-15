package edu.ufp.inf.lp2.p07_nio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileBinOutputStreamApp {

    public static void main(String[] args) {
        String filename = (args.length == 1 ? args[0] : "data/Test.bin");
        // 1st Save bin file
        fileBinOutputStream(filename);
        // 2nd read bin file
        fileBinInputStream(filename);
    }

    public static void fileBinOutputStream(String filepath) {
        Logger.getLogger(FileBinOutputStreamApp.class.getName()).log(Level.INFO, "fileBinOutputStream(): write to bin file " + filepath);
        //try-with-resources
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath)))) {
            double[] data= {1.3, 1.6, 2.1, 3.3, 4.8, 5.6, 6.1, 7.9, 8.2, 9.9};
            //write size of array
            dos.writeInt(data.length);
            // Write doubles into the file
            for (int i = 0; i < data.length; i++) {
                dos.writeDouble(data[i]);
            }
        } catch (Exception e) {
            Logger.getLogger(FileBinOutputStreamApp.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void fileBinInputStream(String filepath) {
        Logger.getLogger(FileBinOutputStreamApp.class.getName()).log(Level.INFO, "fileBinInputStream(): read from bin file " + filepath);
        //try-with-resources
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filepath)))) {
            //Read and print into console...
            int length = dis.readInt();

            while (length > 0) {
                System.out.println("Value: " + dis.readDouble());
                length--;
            }

        } catch (Exception e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO, e.toString());
        }
    }
}
