/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import edu.princeton.cs.introcs.*;
import static java.nio.file.Files.move;


public class EightPuzzleSolver {
    
    private  final int[] GOAL_STATE_1D = {1, 2, 3, 4, 5, 6, 7, 8, 0};


    private static int[] goalStates;


    public static boolean isGoalState(int[] puzzle) {
    int n = (int) Math.sqrt(puzzle.length);
    for (int i = 0; i < puzzle.length; i++) {
        if (puzzle[i] != (i + 1) % (n * n)) {
            return false;
        }
    }
    return true;
}


    // Helper function to generate successor nodes
   public static List<Node> generateSuccessors(Node node) {
    List<Node> successors = new ArrayList<>();
    int n = (int) Math.sqrt(node.puzzle.length);
    // Define possible moves (right, left, up, down)
    int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    char[] moveChars = {'R', 'L', 'U', 'D'};
    int zeroIndex = -1;
    for (int i = 0; i < node.puzzle.length; i++) {
        if (node.puzzle[i] == 0) {
            zeroIndex = i;
            break;
        }
    }
    int zeroRow = zeroIndex / n;
    int zeroCol = zeroIndex % n;
    for (int i = 0; i < moves.length; i++) {
        int[] move = moves[i];
        int newRow = zeroRow + move[0];
        int newCol = zeroCol + move[1];
        int newIndex = newRow * n + newCol;
        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
            int[] newPuzzle = Arrays.copyOf(node.puzzle, node.puzzle.length);
            // Swap zero with the adjacent tile
            newPuzzle[zeroIndex] = newPuzzle[newIndex];
            newPuzzle[newIndex] = 0;
            // Create a new node and add to successors
            successors.add(new Node(newPuzzle, node.g + 1, HeuristicMethod.manhattanDistance(newPuzzle), zeroIndex, node.moves + moveChars[i]));
        }
    }
    return successors;
}


    


     //A* Algorithm
    public static String solvePuzzle(int[] puzzle) {
    PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));
    Set<String> closed = new HashSet<>();
    setGoalStates(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
    int zeroIndex = -1;
    // Find position of zero
    for (int i = 0; i < puzzle.length; i++) {
        if (puzzle[i] == 0) {
            zeroIndex = i;
            break;
        }
    }
    Node startNode = new Node(puzzle, 0, HeuristicMethod.manhattanDistance(puzzle), zeroIndex, "");
    open.add(startNode);
    while (!open.isEmpty()) {
        Node currentNode = open.poll();
        if (isGoalState(currentNode.puzzle)) {
            return currentNode.moves;
        }
        closed.add(Arrays.toString(currentNode.puzzle));

        List<Node> successors = generateSuccessors(currentNode);
        for (Node successor : successors) {
            if (!closed.contains(Arrays.toString(successor.puzzle))) {
                open.add(successor);
            }
        }
    }
    return "No solution found."; // No solution found
}

    
    

    
    
    public static void setGoalStates(int[] goalStates) {
    EightPuzzleSolver.goalStates = goalStates;
}

    
    
   public static int[] getGoalStates() {		
       return goalStates;
   }

	
        
        
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
        
        
        
        
        public void findAndPrintInversions(int[] puzzle) {
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
                   

      static void performMoves(int[] puzzle, char[] moves) {
    for (char move : moves) {
        performMove(puzzle, move);
    }
}

    /**
     *
     * @param puzzle
     * @param move
     */
    static void performMove(int[] puzzle, char move) {
    int size = (int) Math.sqrt(puzzle.length);

    // Find the index of the zero tile
    int zeroIndex = -1;
    for (int i = 0; i < puzzle.length; i++) {
        if (puzzle[i] == 0) {
            zeroIndex = i;
            break;
        }
    }

    // Calculate the new index after the move
    int newIndex = -1;
    switch (move) {
        case 'U':
            if (zeroIndex >= size) {
                newIndex = zeroIndex - size;
            }
            break;
        case 'D':
            if (zeroIndex < puzzle.length - size) {
                newIndex = zeroIndex + size;
            }
            break;
        case 'L':
            if (zeroIndex % size != 0) {
                newIndex = zeroIndex - 1;
            }
            break;
        case 'R':
            if ((zeroIndex + 1) % size != 0) {
                newIndex = zeroIndex + 1;
            }
            break;
    }

    // Swap the values at zeroIndex and newIndex if newIndex is valid
    if (newIndex != -1) {
        int temp = puzzle[zeroIndex];
        puzzle[zeroIndex] = puzzle[newIndex];
        puzzle[newIndex] = temp;
    }
}

                   
                   


                   
                   public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }

}
        
                   
        
        

        

    
    

    
    