import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.awt.FileDialog;
import java.awt.Frame;
import java.util.Arrays;

public class FourDemo {
    public static void main(String[] args) throws FileNotFoundException {
        char [][] test = new char[8][8];
        for (int i = 0; i < test.length; i++) {
            for(int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j] + "-");
            }
            System.out.println();
        }
        System.out.println("Seperation");
        FourInALine gameDemo = new FourInALine();
        gameDemo.printBoard();
        gameDemo.assignRow();
        gameDemo.printBoard();
        System.out.println(gameDemo.getRowLocation() + " is row " + gameDemo.getColumnLocation() + " is column");
        System.out.println(gameDemo.checkIfTerminal(test));
    }
    
  


}