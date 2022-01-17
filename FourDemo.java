import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.awt.FileDialog;
import java.awt.Frame;
import java.util.Arrays;

public class FourDemo {
    public static void main(String[] args) throws FileNotFoundException {
        char [][] test = { {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}  };
        for (int i = 0; i < test.length; i++) {
            for(int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Seperation");
        FourDemo demo = new FourDemo();
        boolean minOrMaxChoice = demo.maxOrMin();
        FourInALine gameDemo = new FourInALine();
        gameDemo.printBoard();
        gameDemo.assignRow(minOrMaxChoice);
        gameDemo.printBoard();
        System.out.println(gameDemo.getRowLocation() + " is row " + gameDemo.getColumnLocation() + " is column");
        System.out.println(gameDemo.checkIfTerminal(test));
        gameDemo.successor();
    }
    public boolean maxOrMin() {
        Scanner keyboard = new Scanner(System.in);
        String firstInput = " "; //initialized string
        do { //Seeing if the user wants to go first
            if (!firstInput.equals("Y") && !firstInput.equals("N")) //if user entered incorrectly when loop back error message
                System.out.println("Invalid input please enter correctly");
            System.out.print("Would you like to go first? (Y or N) ");
            firstInput = keyboard.nextLine();
        } while (!firstInput.equals("Y") && !firstInput.equals("N"));
        boolean maxOrMin = false; //if true then max
        if(firstInput.equals("N"))
            maxOrMin = true; //if false then min
        return maxOrMin;
    }
    

}