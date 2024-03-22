/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package javaapplication4;

import java.awt.Color; // used for coloring the board
import java.awt.Point; // used for the positions of the tiles and the empty cell
import edu.princeton.cs.introcs.*;
import java.awt.Font;
import java.util.Arrays;
import static javaapplication4.EightPuzzle.GOALSTATE_1D;
import static javaapplication4.EightPuzzleSolver.solvePuzzle;
import javaapplication4.Tile ;
import javaapplication4.HeuristicMethod;



// A class that is used for modeling the board in the 8 puzzle.
public class Board {
    
    private static boolean buttonClicked = false;
    private static String textFieldText = "Initial Text";

    
    int[][] puzzle = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
    int[] GOAL_STATE_1D = {1, 2, 3, 4, 5, 6, 7, 8, 0}; 
    
  
    
public void drawTextField() {
    
    
    
    // Get the initial state of the puzzle
    int[] newBoard = getInitialState();
    
    // Solve the puzzle and get the solution
    String solution1 = EightPuzzleSolver.solvePuzzle(newBoard);
    
    // Set the color for the text field
    StdDraw.setPenColor(StdDraw.BLACK);
    
    // Set the font for the text field
    Font font = new Font("Arial", Font.PLAIN, 16);
    StdDraw.setFont(font);
    
    // Draw the text field
    double textFieldX = 2; // X position of the text field
    double textFieldY = 3.8; // Y position of the text field
    StdDraw.text(textFieldX, textFieldY, " ");
    
    // Check if the new board is equal to the goal state
if (buttonClicked) {
            
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(textFieldX, textFieldY, " ");
            StdDraw.text(textFieldX, textFieldY, solution1);
            StdDraw.show();
            buttonClicked = false; // Reset the button clicked flag
        } else {
            // Draw the text field with the default text
            
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(textFieldX, textFieldY, " ");
            StdDraw.show();
        }
    
    // Show the drawing
    StdDraw.show();
}

        
       

    
    
    
    // A method for drawing the button at the bottom of the page
public void drawButton() {
    // Set the color for the button
    StdDraw.setPenColor(boxColor);
    
    
    // Draw the button rectangle
    double buttonWidth = 1; // Width of the button
    double buttonHeight = 0.4; // Height of the button
    double buttonX = 2; // X position of the button
    double buttonY = 0.3; // Y position of the button
    StdDraw.filledRectangle(buttonX, buttonY+0.002, buttonWidth / 2, buttonHeight / 2);
    
    // Set the color for the text
    StdDraw.setPenColor(Color.WHITE);
    
    // Set the font for the text
    Font font = new Font("Arial", Font.BOLD, 20);
    StdDraw.setFont(font);
    
    // Draw the text on the button
    String buttonText = "Solve!";
    StdDraw.text(buttonX, buttonY, buttonText);
    
    if (StdDraw.isMousePressed()) {
        double mouseX = StdDraw.mouseX();
        double mouseY = StdDraw.mouseY();

        if (mouseX >= buttonX - buttonWidth / 2 && mouseX <= buttonX + buttonWidth / 2 &&
            mouseY >= buttonY - buttonHeight / 2 && mouseY <= buttonY + buttonHeight / 2) {
            
            int[] initialState = getInitialState(); // Store the initial state of the puzzle
int[] currentState = Arrays.copyOf(initialState, initialState.length);

String solution = EightPuzzleSolver.solvePuzzle(initialState);
System.out.println("Solution: " + solution);
System.out.println("Start State:");
Display.printPuzzle(currentState); // Print the initial state
System.out.println("Solution Moves: " + solution);

for (int i = 0; i < solution.length(); i++) {
    char move = solution.charAt(i);
    EightPuzzleSolver.performMove(currentState, move);
    System.out.println("Move: " + move);
    Display.printPuzzle(currentState); // Print the current state
    Display.drawPuzzle(currentState);
    // Display.drawPuzzle(currentState); // Uncomment if you have a method to draw the puzzle
    StdDraw.pause(500); // Pause for 0.5 seconds between moves
    // StdDraw.clear(); // Uncomment if you need to clear the display before the next move
}


          



}

    // Show the drawing
    StdDraw.show();
}


    
}

   
   // Data fields: the class variables (actually constants here)
   // --------------------------------------------------------------------------
   // the background color used for the empty cell on the board
   private static final Color backgroundColor = new Color(145, 234, 255);
   // the color used for drawing the boundaries around the board
   private static final Color boxColor = new Color(31, 160, 239);
   // the line thickness value for the boundaries around the board
   // (it is twice the value used for the tiles as only half of it is visible)
   private static final double lineThickness = 0.02;
   
   private static int[] initialState;

   // Data fields: the instance variables
   // --------------------------------------------------------------------------
   // a matrix to store the tiles on the board in their current configuration
   private final Tile[][] tiles = new Tile[3][3];
   // the row and the column indexes of the empty cell
   private int emptyCellRow, emptyCellCol;

   // The default constructor creates a random board
   // --------------------------------------------------------------------------
   public Board() {
       

       
       
       
      // create an array that contains each number from 0 to 8
      int[] numbers = new int[9];
      for (int i = 0; i < 9; i++)
         numbers[i] = i;
      // randomly shuffle the numbers in the array by using the randomShuffling
      // method defined below
      randomShuffling(numbers);
      initialState = numbers;
      
      

      // create the tiles and the  empty cell on the board by using the randomly
      // shuffled numbers from 0 to 8 and store them in the tile matrix
      int arrayIndex = 0; // the index of the current number in the numbers array
      // for each tile in the tile matrix
      for (int row = 0; row < 3; row++)
         for (int col = 0; col < 3; col++) {
            // create a tile if the current value in the numbers array is not 0
            if (numbers[arrayIndex] != 0)
               // create a tile with the current number and assign this tile to
               // the current cell of the tile matrix
               tiles[row][col] = new Tile(numbers[arrayIndex]);
            // otherwise, this is an empty cell
            else {
               // assign the row and the column indexes of the empty cell
               emptyCellRow = row;
               emptyCellCol = col;
            }
            // increase the array index by 1
            arrayIndex++;
         }
   }

   // The method(s) of the Board class
   // --------------------------------------------------------------------------
   // An inner method that randomly reorders the elements in a given int array.
   private void randomShuffling(int[] array) {
      // loop through all the elements in the array
      for (int i = 0; i < array.length; i++) {
         // create a random index in the range [0, array.length - 1]
         int randIndex = (int) (Math.random() * array.length);
         // swap the current element with the randomly indexed element
         if (i != randIndex) {
            int temp = array[i];
            array[i] = array[randIndex];
            array[randIndex] = temp;
         }
      }
   }

   // A method for moving the empty cell right
   public boolean moveRight() {
      // the empty cell cannot go right if it is already at the rightmost column
      if (emptyCellCol == 2)
         return false; // return false as the empty cell cannot be moved
      // replace the empty cell with the tile on its right
      tiles[emptyCellRow][emptyCellCol] = tiles[emptyCellRow][emptyCellCol + 1];
      tiles[emptyCellRow][emptyCellCol + 1] = null;
      // update the column index of the empty cell
      emptyCellCol++;
      // return true as the empty cell is moved successfully
      return true;
   }

   // A method for moving the empty cell left
   public boolean moveLeft() {
      // the empty cell cannot go left if it is already at the leftmost column
      if (emptyCellCol == 0)
         return false; // return false as the empty cell cannot be moved
      // replace the empty cell with the tile on its left
      tiles[emptyCellRow][emptyCellCol] = tiles[emptyCellRow][emptyCellCol - 1];
      tiles[emptyCellRow][emptyCellCol - 1] = null;
      // update the column index of the empty cell
      emptyCellCol--;
      // return true as the empty cell is moved successfully
      return true;
   }

   // A method for moving the empty cell up
   public boolean moveUp() {
      // the empty cell cannot go up if it is already at the topmost row
      if (emptyCellRow == 0)
         return false; // return false as the empty cell cannot be moved
      // replace the empty cell with the tile above it
      tiles[emptyCellRow][emptyCellCol] = tiles[emptyCellRow - 1][emptyCellCol];
      tiles[emptyCellRow - 1][emptyCellCol] = null;
      // update the row index of the empty cell
      emptyCellRow--;
      // return true as the empty cell is moved successfully
      return true;
   }

   // A method for moving the empty cell down
   public boolean moveDown() {
      // the empty cell cannot go down if it is already at the bottommost row
      if (emptyCellRow == 2)
         return false; // return false as the empty cell cannot be moved
      // replace the empty cell with the tile below it
      tiles[emptyCellRow][emptyCellCol] = tiles[emptyCellRow + 1][emptyCellCol];
      tiles[emptyCellRow + 1][emptyCellCol] = null;
      // update the row index of the empty cell
      emptyCellRow++;
      // return true as the empty cell is moved successfully
      return true;
   }

   // A method for drawing the board by using the StdDraw library
   public void draw() {
       
               
      // clear the drawing canvas using the background color
      StdDraw.clear(backgroundColor);
      // for each tile in the tile matrix
      for (int row = 0; row < 3; row++)
         for (int col = 0; col < 3; col++) {
            // skip the empty cell
            if (tiles[row][col] == null)
               continue;
            // get the position of the tile based on its indexes
            // by using the getTilePosition method defined below
            Point tilePosition = getTilePosition(row, col);
            // draw the tile centered on its position
            tiles[row][col].draw(tilePosition.x, tilePosition.y);

         }
      // draw the box around the board
      StdDraw.setPenColor(boxColor);
      StdDraw.setPenRadius(lineThickness);
      StdDraw.square(2, 2, 1.5);
      StdDraw.setPenRadius(); // reset pen radius to its default value
   }

   // An inner method that returns the position of the tile on the board
   // with the given row and column indexes
   private Point getTilePosition(int rowIndex, int columnIndex) {
      // convert the indexes to the positions in StdDraw
      int posX = columnIndex + 1, posY = 3 - rowIndex;
      return new Point(posX, posY);
   }
   
   
   public  int [] getInitialState(){
       
       return initialState;
               
           
   }
   
   
   
   
   
   
}
   
   
  
