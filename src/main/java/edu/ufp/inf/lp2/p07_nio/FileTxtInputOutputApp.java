package edu.ufp.inf.lp2.p07_nio;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileTxtInputOutputApp {

    public static void main(String[] args) {
        String filepath = (args.length == 1 ? args[0] : "data/Alunos.txt");
        //1st write to file
        printWriterTxtFile(filepath);
        //2nd read and parse from file
        bufferedReaderFileTxt(filepath);
        scannerTxtFile(filepath);
    }

    public static void printWriterTxtFile(String filepath) {
        System.err.println("FilePrintWriterApp - printWriterTxtFile(): saving into file " + filepath);
        PrintWriter pw = null;
        try {
            //Open stream
            pw = new PrintWriter(new FileWriter(new File(filepath)));
            // Print into to the file
            String name = "Nuno Alexandre";
            int number = 1111;
            float grade = 15.5f;
            pw.println(name + ", " + number + ", " + grade);
            pw.println("Pedro Lucas, 2222, 18.5");
            // Flush
            pw.flush();
            pw.println("Antonio Miguel, 3333, 14.5");
        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - printWriterTxtFile(): " + e);
        } finally {
            // Flush and close
            if (pw != null) pw.close();
        }
    }

    public static void bufferedReaderFileTxt(String filepath) {
        System.err.println("FilePrintWriterApp - bufferedReaderFileTxt(): reading file from " + filepath);
        //Use try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
            // Read lines from file
            String line = "";
            int lineCount = 1;
            while ((line = br.readLine()) != null) {
                System.out.println("Line " + (lineCount++) + ": " + line);
                int tokenCount = 0;
                String name = null;
                int number = 0;
                float grade = 0.0f;
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    System.out.println("FileBufferedReaderApp - bufferedReaderFileTxt(): token [" + tokenCount + "] = " + token);
                    switch (tokenCount) {
                        case 0:
                            name = token;
                            break;
                        case 1:
                            number = Integer.parseInt(token.trim());
                            break;
                        case 2:
                            grade = Float.parseFloat(token);
                            break;
                    }
                    tokenCount++;
                }
                System.out.println("FileBufferedReaderApp - bufferedReaderFileTxt(): parsed tokes into = " + name + "," + number + "," + grade);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void scannerTxtFile(String filepath) {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(filepath)))) {
            //Scanner uses default delimiter ' ' (whitespace)
            //We may define delimiters other than whitespace, using regular expressions
            //e.g.
            // "\\s*, " -> (string followed by ', ') OR
            // "\\s*," -> (string followed by ',') OR
            // "\\s*\n" -> (string followed by '\n')
            s.useDelimiter("\\s*, |\\s*,|\\s*\n");
            //Walk through the file content (token by token) using regular expressions above
            while (s.hasNext()) {
                String name = s.next();
                System.out.println("name=|" + name + "|");
                int number = s.nextInt();
                System.out.println("number=|" + number + "|");
                System.out.println("name = " + name);
                //If LOCAL OS float separator is ',' then replace '.' by ','
                //name.replace('.', ',');
                System.out.println(s.nextFloat());
                float grade = Float.parseFloat(String.valueOf(s.nextFloat()));
                System.out.println("grade=|" + grade + "|");
            }

            /*
            //Create scanner for given string
            Scanner s = new Scanner("a1,b23,c3,d4,e5,f6");
            //Delimiters are any digits (d) followed by an optional (?) ','
            s.useDelimiter("\\d,?");
            while (s.hasNext()) {
                System.out.println("|"+s.next()+"|");
            }
            */
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}