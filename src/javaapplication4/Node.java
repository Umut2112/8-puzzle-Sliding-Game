/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package javaapplication4;


import java.awt.Font;
import java.util.*;
import edu.princeton.cs.introcs.StdDraw;

class Node {
    int[] puzzle;
    int g; // cost from start to current node
    int h; // heuristic cost (Manhattan distance)
    int f; // f = g + h
    int zeroRow, zeroCol; // position of 0 in the puzzle
    String moves; // String to keep track of moves
    Node parent ; 
    
    public Node(int[] puzzle, int g, int h, int zeroRow, String moves) {
        this.puzzle = puzzle;
        this.g = g;
        this.h = h;
        this.f = g + h;
        this.zeroRow = zeroRow;
        this.zeroCol = zeroCol;
        this.moves = moves;
        
    }
}

