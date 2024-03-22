/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.awt.event.KeyEvent; // for the constants of the keys on the keyboard
import edu.princeton.cs.introcs.*;
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
public class HeuristicMethod {
    

    int[] puzzle;
    int pathCost;
    int heuristicValue;
    HeuristicMethod parent;

    // Constructor
    
    
    
    
    
    
    
    
    private  final int[] GOAL_STATE_1D = {1, 2, 3, 4, 5, 6, 7, 8, 0};

        public int misplacedTiles(int[] puzzle) {
        int misplaced = 0;
        for (int i = 0; i < puzzle.length; i++) {
            
                if (puzzle[i] != 0) 
      
                        if  (puzzle[i] != GOAL_STATE_1D[i]) {
                    misplaced++;
                
            }
        }
        return misplaced;
    }
        
       public static int manhattanDistance(int[] puzzle) {
        int distance = 0;
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] != 0) {
                int goalIndex = puzzle[i] - 1;
                int goalRow = goalIndex / 3;
                int goalCol = goalIndex % 3;
                int currentRow = i / 3;
                int currentCol = i % 3;
                distance += Math.abs(currentRow - goalRow) + Math.abs(currentCol - goalCol);
            }
        }
        return distance;
    }
       
       
       
       
       
       
       public int[] MakingMove(int[] puzzle) {
    for (int i = 0; i < puzzle.length; i++) {
        if (puzzle[i] == 0 && StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && i != 2 && i != 5 && i != 8 && i + 1 < puzzle.length) {
            puzzle[i] = puzzle[i + 1];
            puzzle[i + 1] = 0;
            break;
        } else if (puzzle[i] == 0 && StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && i != 0 && i != 3 && i != 6 && i - 1 >= 0) {
            puzzle[i] = puzzle[i - 1];
            puzzle[i - 1] = 0;
            break;
        } else if (puzzle[i] == 0 && StdDraw.isKeyPressed(KeyEvent.VK_UP) && i != 0 && i != 1 && i != 2 && i - 3 >= 0) {
            puzzle[i] = puzzle[i - 3];
            puzzle[i - 3] = 0;
            break;
        } else if (puzzle[i] == 0 && StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && i != 6 && i != 7 && i != 8 && i + 3 < puzzle.length) {
            puzzle[i] = puzzle[i + 3];
            puzzle[i + 3] = 0;
            break;
        }
    }
    return puzzle;
}
       
       
       public static void findAndPrintInversions(int[] puzzle) {
    int inversions = 0;
    for (int i = 0; i < puzzle.length; i++) {
        for (int j = i + 1; j < puzzle.length; j++) {
            if (puzzle[i] > puzzle[j] && puzzle[j] != 0) {
                inversions++;
            }
        }
    }
    if (inversions % 2 == 0) {
        System.out.println("Solveable.");
    } else {
        System.out.println("Not Solveable.");
    }
}
}
       
   
       

    
    

       






























       
       
       
       

