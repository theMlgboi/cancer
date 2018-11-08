/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package floodintro;

/**
 *
 * @author Andrew Archer
 */
public class FloodIntro {
  //Make global variables (cell&cancerSize) which are accessible
  //from anywhere inside the class FloodIntro
  public static String cell[][];
  public static int cancerSize;

  public static void main(String[] args) {
    int row, col;
    //Create 2D array size 15 x 15
    cell = new String[15][15];

    //Fill the array with healthy cells
    for (row = 0; row < 15; row++) {
      for (col = 0; col < 15; col++) {
        cell[row][col] = "+";
        
      }
    }

    
    
    //Fill 70 random elements in the cell with an negative
    //Do no choose an element along the border
    //The border will always contain elements with spaces
    
    for (int i = 0; i < 70; i++) {
      row = (int) (Math.random() * 13 + 1);
      col = (int) (Math.random() * 13 + 1);
      cell[row][col] = "-";
     
    }
    

    //Print out the current cell with the cancer
    displayGrid();

    //variable to determine the size of the cancer
    cancerSize = 0;

    //searchs the cell for canceres parts
    //sends the coordinates of the cancer to the floodFill method
    for( row=1;row<=14;row++){
        for(col=1;col<=14;col++){
            
                floodFill(row,col);
            
        }
    }

   
    System.out.println("The cell had " + cancerSize +
      " cancer cells in it");
    System.out.println("The new cell is:");
    //Print out the cell without the cancer in it
    
    displayGrid();
  }

  public static void floodFill(int row, int col) {
    if (cell[row][col].equals("-")) {
      cell[row][col] = " ";
      cancerSize++;
      floodFill(row - 1, col - 1);
      floodFill(row - 1, col);
      floodFill(row - 1, col + 1);
      floodFill(row, col - 1);
      floodFill(row, col + 1);
      floodFill(row + 1, col - 1);
      floodFill(row + 1, col);
      floodFill(row + 1, col + 1);
    }
  }

  public static void displayGrid() {
    String output = "";
    for (int row = 0; row <= 14; row++) {
      
      
      for (int col = 0; col <= 14; col++) {
        output += cell[row][col];
      }
      output += "\n";
    }
    System.out.println(output);
  }
}