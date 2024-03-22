/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;
import java.awt.event.KeyEvent; // for the constants of the keys on the keyboard
import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import javaapplication4.Board;
import javaapplication4.Tile;
import javaapplication4.EightPuzzle;





/**
 *
 * @author macbook
 */
public class Display {
    
    
    public static void printPuzzle(int[] puzzle) {
        for (int i = 0; i < puzzle.length; i += 3) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(puzzle, i, i + 3)));
        }
    }
    
    
    

    
    
    
    
    private static final Color backgroundColor = new Color(145, 234, 255);
   // the color used for drawing the boundaries around the board
   private static final Color boxColor = new Color(31, 160, 239);
   // the line thickness value for the boundaries around the board
   // (it is twice the value used for the tiles as only half of it is visible)
   private static final double lineThickness = 0.02;
   
     private static final Color tileColor = new Color(15, 76, 129);
   // the color used for the number on the tile (a static constant)
   private static final Color numberColor = new Color(31, 160, 239);
   // the color used for the box around the tile (a static constant)
   private static final Color boxColor1 = new Color(31, 160, 239);
   // the line thickness value for the box around the tile (a static constant)
   private static final double lineThickness1 = 0.01;
   // the font used for the number on the tile (a static constant)
   private static final Font numberFont = new Font("Arial", Font.BOLD, 50);
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//  public static void drawPuzzle(int[] puzzle) {
//    StdDraw.setCanvasSize(600, 600); // Set canvas size
//    StdDraw.setXscale(0, 1200); // Set x-axis scale
//    StdDraw.setYscale(0, 1200); // Set y-axis scale
//    StdDraw.clear();
//    int n = (int) Math.sqrt(puzzle.length);
//    double tileSize = (double) 600 / n;
//    Color backgroundColor = new Color(145, 234, 255);
//
//    // Draw background
//    StdDraw.setPenColor(backgroundColor);
//    StdDraw.filledRectangle(300, 300, 300, 300);
//
//    // Set line thickness
//    double lineThickness = 0.02;
//    StdDraw.setPenRadius(lineThickness);
//
//    // Draw tiles
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) {
//            int index = i * n + j;
//            int tile = puzzle[index];
//            if (tile != 0) {
//                Color boxColor = new Color(31, 160, 239);
//                StdDraw.setPenColor(boxColor);
//                StdDraw.filledRectangle(j * tileSize + tileSize / 2, 600 - i * tileSize - tileSize / 2, tileSize / 2, tileSize / 2);
//                StdDraw.setPenColor(StdDraw.BLACK);
//                StdDraw.text(j * tileSize + tileSize / 2, 600 - i * tileSize - tileSize / 2, Integer.toString(tile));
//
//                // Draw lines around the tile
//                double x = j * tileSize;
//                double y = 600 - i * tileSize;
//                StdDraw.setPenColor(backgroundColor); // Set line color to background color
//                StdDraw.line(x, y, x, y - tileSize);
//                StdDraw.line(x, y, x + tileSize, y);
//                StdDraw.line(x + tileSize, y, x + tileSize, y - tileSize);
//                StdDraw.line(x, y - tileSize, x + tileSize, y - tileSize);
//            }
//        }
//    }
//
//    // Reset line thickness to default
//    StdDraw.setPenRadius();
//
//    StdDraw.show();
//}
//
//  
//  
   
   
   
   public static void drawPuzzle(int[] puzzle) {
    // Set canvas size and scales
    
    StdDraw.setCanvasSize(600, 600);
    StdDraw.setXscale(0, 600);
    StdDraw.setYscale(0, 600);

    // Clear the canvas
    StdDraw.clear();

    // Calculate grid dimensions based on puzzle length
    int n = (int) Math.sqrt(puzzle.length);
    double tileSize = (double) 600 / n;

    // Draw background rectangle
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledRectangle(300, 300, 300, 300);

    // Set line thickness
    StdDraw.setPenRadius(0.01);

    // Draw tiles and numbers
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int index = i * n + j;
            int tileValue = puzzle[index];

            if (tileValue != 0) {
                // Draw the tile background
                StdDraw.setPenColor(tileColor);
                StdDraw.filledRectangle(j * tileSize + tileSize / 2,
                                       600 - i * tileSize - tileSize / 2,
                                       tileSize / 2, tileSize / 2);

                // Draw the tile number
                StdDraw.setFont(new Font("Arial", Font.PLAIN, 20));
                StdDraw.setPenColor(numberColor);
                StdDraw.text(j * tileSize + tileSize / 2,
                             600 - i * tileSize - tileSize / 2,
                             Integer.toString(tileValue));
            }

            // Draw grid lines
            StdDraw.setPenColor(boxColor);
            StdDraw.line(j * tileSize, 600 - i * tileSize, (j + 1) * tileSize, 600 - i * tileSize);
            StdDraw.line(j * tileSize, 600 - i * tileSize, j * tileSize, 600 - (i + 1) * tileSize);
        }
    }

    // Reset line thickness to default (optional, recommended)
    StdDraw.setPenRadius();

    // Display the drawing
    StdDraw.show();
}

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    
    
    
    
    
    
    

