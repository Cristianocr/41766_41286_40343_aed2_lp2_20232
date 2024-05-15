package edu.ufp.inf.lp2.p07_nio;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UrlInputApp {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://homepage.ufp.pt/rmoreira/LP2/data.txt");
        readTxtFileFromUrl(url);
        downloadFileFromUrl(url);
    }

    public static void readTxtFileFromUrl(URL url) {
        try (InputStream is = url.openStream()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            int lineCount = 0;
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("InputFromUrlApp - readTxtFileFromUrl(): [" + ++lineCount + "]: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadFileFromUrl(URL url) {
        BufferedWriter bw = null;

        try (InputStream is = url.openStream()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line;

            File f = new File("data", "fileDonwload.txt");
            bw = new BufferedWriter(new FileWriter(f));

            while ((line = in.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException ioe) {
            //ioe.printStackTrace();
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, ioe);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
