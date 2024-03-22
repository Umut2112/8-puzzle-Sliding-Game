/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package javaapplication4;


import java.awt.event.KeyEvent; // for the constants of the keys on the keyboard
import edu.princeton.cs.introcs.*;
import static edu.princeton.cs.introcs.StdDraw.text;
import static java.nio.file.Files.move;
import java.util.Arrays;
import javaapplication4.Board;
import javaapplication4.EightPuzzleSolver;
import javaapplication4.HeuristicMethod;
import javaapplication4.Tile;
import java.util.Arrays;
import javaapplication4.Display;
import static javaapplication4.EightPuzzleSolver.solvePuzzle;






// A program that partially implements the 8 puzzle.
public class EightPuzzle {
        
        


public static int[] GOALSTATE_1D = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    
     
    
    
    

   // The main method is the entry point where the program starts execution.
   public static void main(String[] args) {
      
       
      // StdDraw setup
      // -----------------------------------------------------------------------
      // set the size of the canvas (the drawing area) in pixels
      StdDraw.setCanvasSize(600, 600);
      // set the range of both x and y values for the drawing canvas
      StdDraw.setScale(0.05, 4);
      // enable double buffering to animate moving the tiles on the board
      StdDraw.enableDoubleBuffering();
       // create a random board for the 8 puzzle

        HeuristicMethod misplaced = new HeuristicMethod();
        Board board = new Board();
       // EightPuzzleSolver Solver = new EightPuzzleSolver();
      
      

       int[] newBoard = misplaced.MakingMove(board.getInitialState());
      

      
//        String solution = EightPuzzleSolver.solvePuzzle(board.getInitialState());
//        System.out.println("Start State:");
//        Display.drawPuzzle(board.getInitialState());
//        System.out.println("Solution Moves: " + solution);
//
//        int delay = 500; // milliseconds
//        for (int i = 0; i < solution.length(); i++) {
//            char move = solution.charAt(i);
//            EightPuzzleSolver.performMove(board.getInitialState(), move);
//            Display.drawPuzzle(board.getInitialState());
//            StdDraw.pause(delay);
      
        
        












      
      
      

      
      
       misplaced.findAndPrintInversions(board.getInitialState());
       
       //System.out.println("Number of misplaced tiles: " + misplaced.misplacedTiles(board.getInitialState()));
       //System.out.println("Third Index of Inıtial State = " + board.getInitialState()[3]);
       //System.out.println(Arrays.toString(misplaced.MakingMove(board.getInitialState())));
       //System.out.println("Manhattan distance: " + misplaced.manhattanDistance(board.getInitialState()));
       
       //System.out.println("First PathCost = "  + path_cost);
       //System.out.println("First board = "  + Arrays.toString(board.getInitialState()));
       
       

        


      

      // The main animation and user interaction loop
      // -----------------------------------------------------------------------
      while (true) {
          
        
         // draw the board, show the resulting drawing and pause for a short time
         
         board.draw();
         
         board.drawButton();
         //board.drawTextField();
         board.drawTextField();
        
        
         StdDraw.show();
         StdDraw.show();
         StdDraw.pause(100); // 100 ms
          // Now you can update the game board based on the best move
    
        
         //EightPuzzleSolver.solvePuzzle(board.getInitialState());
         
        
        
        
        
        
        
        
        //System.out.println("Solution Moves: " + solution);
        
        
        
        
         

        
    
        
   
         
         
         

         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
           // move the empty cell right
           board.moveRight();
           

           //System.out.println("After pressing the key right new board = " + Arrays.toString(misplaced.MakingMove(board.getInitialState())));
           //System.out.println("After pressing the key right new mannahtanDistance = " + misplaced.manhattanDistance(newBoard));
           
                       

           
         }
             
         // if the user has pressed the left arrow key on the keyboard
         if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
             // move the empty cell left
            board.moveLeft();
            
            //System.out.println("After pressing the key left new board = " + Arrays.toString(misplaced.MakingMove(board.getInitialState())));
            //System.out.println("After pressing the key left new mannahtanDistance = " + misplaced.manhattanDistance(newBoard));
            
            
            
            


         }
         // if the user has pressed the up arrow key on the keyboard
         if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            // move the empty cell up
            board.moveUp();
            
            //System.out.println("After pressing  the key up new board = " + Arrays.toString(misplaced.MakingMove(board.getInitialState())));
            //System.out.println("After pressing the key up new mannahtanDistance = " + misplaced.manhattanDistance(newBoard));
            //System.out.println("After pressing the key up new board = " + Arrays.toString(newBoard3));
                        

         }
            
         // if the user has pressed the down arrow key on the keyboard
         if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
            // move the empty cell down
            board.moveDown();
            
            //System.out.println("After pressing down the key new board = " + Arrays.toString(misplaced.MakingMove(board.getInitialState())));
            //System.out.println("After pressing the key down new mannahtanDistance = " + misplaced.manhattanDistance(newBoard));
            //System.out.println("After pressing the key down new board = " + Arrays.toString(newBoard4));
             
                         

             
         }
         
         
         if(Arrays.equals(newBoard, GOALSTATE_1D)) {
             System.out.println("Game Over.");
             break;
    }
         
             
         
            
        
    }
      
}
   
   
   
   
}


         
         
         
         
         
         

         
      
      
         
        

         
         
               
      

         
            
         
         
         
         
      
      



      
        
            
            
            
           
            

   
   
   
   
   
   

