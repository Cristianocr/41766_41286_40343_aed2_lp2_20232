/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufp.inf.aed2.tp_03.red_blacks;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;

/**
 *
 * @author jtorres
 */
public class RedBlackBST_Draw_AED2_UFP {

    public static void main(String[] args) {
        //exemplo1_LLRB_Draw_Ints();
        exemplo2_LLRB_Draw_Strings();
    }

    /*****************************************************************************
     *  Test client for Int keys
     *****************************************************************************/
    public static void exemplo1_LLRB_Draw_Ints() {
        RedBlackBST_AED2_UFP<Integer, Integer> st =
                new RedBlackBST_AED2_UFP<Integer, Integer>();
        int [] mykeys = new int[] {35,45,30,20,10,31,32,34};
        System.out.println(Arrays.toString(mykeys));
        for (int i=0; i < mykeys.length; i++) {
            st.put(mykeys[i], 0);
            drawRedBlackTreeIntKeys(st);
            while (!StdDraw.mousePressed());
            while (StdDraw.mousePressed());
        }
    }

    /*****************************************************************************
    *  Test client for String keys
    *****************************************************************************/
    public static void exemplo2_LLRB_Draw_Strings() {
        RedBlackBST_AED2_UFP<String, Integer> st = new RedBlackBST_AED2_UFP();
        String [] mykeys = new String[] {"E","A","S","Y","Q","U","T","I","O","N"};
        for (int i=0; i < mykeys.length; i++) {
            st.put(mykeys[i], 0);
            drawRedBlackTreeStringKeys(st);
            while (!StdDraw.mousePressed());
            while (StdDraw.mousePressed());
        }
    }


    // draws a (binary) using the method position() that returns the position of element in XY coordinates
    public static void drawRedBlackTreeStringKeys(RedBlackBST_AED2_UFP<String, Integer> st) {
        // point (x,y) = (0,0) is lower left point
        float y_offset = (float) 0.03;//0.02
        double raio = 0.02; // radius of each circle drawn on canvas
        double line_end_factor = raio*Math.cos(45*(Math.PI/180));
        float h_factor = 3*(1 + st.height()); // get tree height
        StdDraw.setCanvasSize(600, 600); // new canvas size. Default window size is 512-by-512 pixels.                
        StdDraw.setFont(StdDraw.getFont().deriveFont(12f)); // change font size to 11. Default is 16        
        for (String s : st.keys()) {
            float[] position = st.position(s, 1);
            float y_node_pos = position[0]/h_factor + y_offset; // convert node level to y coords
            float x_node_pos = (position[2] + position[1]) / 2; // x coords
            float y_parent_nodes_pos = (position[0] - 1)/h_factor + y_offset; // y coords for parent node
            float x_parent_node_pos = (position[4] + position[3]) / 2; // x coords for parent node level
            if (x_parent_node_pos >= 0) { // is there a valid parent node?
                if (position[5] > 0.5) {
                    StdDraw.setPenRadius(0.004);
                    StdDraw.setPenColor(StdDraw.RED); // line color
                } else {
                    StdDraw.setPenRadius();
                    StdDraw.setPenColor(StdDraw.BLACK); // line color
                }
                if (position[6] < 0) //left child node
                    StdDraw.line(x_node_pos, 1 - y_node_pos, x_parent_node_pos - line_end_factor, 1 - y_parent_nodes_pos - line_end_factor);
                else //right child node
                    StdDraw.line(x_node_pos, 1 - y_node_pos, x_parent_node_pos + line_end_factor, 1 - y_parent_nodes_pos - line_end_factor);
                
            }
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledCircle(x_node_pos, 1 - y_node_pos, raio);
            StdDraw.setPenColor(StdDraw.BLACK);              
            StdDraw.text(x_node_pos, 1 - y_node_pos, s);
        }
    }
    
    // draws a (binary) using the method position() that returns the position of element in XY coordinates
    public static void drawRedBlackTreeIntKeys(RedBlackBST_AED2_UFP<Integer, Integer> st) {
        // point (x,y) = (0,0) is lower left point
        float y_offset = (float) 0.02;//0.02
        double raio = 0.02; // radius of each circle drawn on canvas
        double line_end_factor = raio*Math.cos(45*(Math.PI/180));
        float h_factor = 3*(1 + st.height()); // get tree height
        StdDraw.setCanvasSize(600, 600); // new canvas size. Default window size is 512-by-512 pixels.                
        StdDraw.setFont(StdDraw.getFont().deriveFont(12f)); // change font size to 11. Default is 16        
        for (Integer s : st.keys()) {
            float[] position = st.position(s, 1);
            float y_node_pos = position[0]/h_factor + y_offset; // convert node level to y coords
            float x_node_pos = (position[2] + position[1]) / 2; // x coords
            float y_parent_nodes_pos = (position[0] - 1)/h_factor + y_offset; // y coords for parent node
            float x_parent_node_pos = (position[4] + position[3]) / 2; // x coords for parent node level
            if (x_parent_node_pos >= 0) { // is there a valid parent node?
                if (position[5] > 0.5) {
                    StdDraw.setPenRadius(0.004);
                    StdDraw.setPenColor(StdDraw.RED); // line color
                } else {
                    StdDraw.setPenRadius();
                    StdDraw.setPenColor(StdDraw.BLACK); // line color
                }
                if (position[6] < 0) //left child node
                    StdDraw.line(x_node_pos, 1 - y_node_pos, x_parent_node_pos - line_end_factor, 1 - y_parent_nodes_pos - line_end_factor);
                else //right child node
                    StdDraw.line(x_node_pos, 1 - y_node_pos, x_parent_node_pos + line_end_factor, 1 - y_parent_nodes_pos - line_end_factor);
            }
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledCircle(x_node_pos, 1 - y_node_pos, raio);
            StdDraw.setPenColor(StdDraw.BLACK);              
            StdDraw.text(x_node_pos, 1 - y_node_pos, s+"");
        }
    }    
    
}
