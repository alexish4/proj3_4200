import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FourInALine {
    private char [][] matrix = new char[8][8];
    private int rowLocation = 0;
    private int columnLocation = 0;
    private int utility = 100;
    
    public int getRowLocation() {
        return rowLocation;
    }
    public void setRowLocation(int rowLocation) {
        this.rowLocation = rowLocation;
    }
    public int getColumnLocation() {
        return columnLocation;
    }
    public void setColumnLocation(int columnLocation) {
        this.columnLocation = columnLocation;
    }
    
    public void assignRow(boolean minOrMax) { //marking location according to user input
        Scanner keyboard = new Scanner(System.in);
        String locationInput = " ";
        boolean loopAgain = false;
        
        do { //get input and use checklocation method to see if input is valid if not we keep looping until valid
            if (loopAgain) //check in beginning to see if display that input was not valid
                System.out.println("Please enter appropriate value, make sure letter is lower-case\n");
            System.out.println("Please enter the location that you want to mark:"); //want to use do while
            locationInput = keyboard.nextLine();
            if (!checkLocation(locationInput))
                loopAgain = true;
            else
                loopAgain = false;
        } while (loopAgain);
        keyboard.close();
        int column = 0;
        if (locationInput.charAt(0) == 'a') //enumerating
            column = 0;
        else if (locationInput.charAt(0) == 'b')
            column = 1;
        else if (locationInput.charAt(0) == 'c')
            column = 2;
        else if (locationInput.charAt(0) == 'd')
            column = 3;
        else if (locationInput.charAt(0) == 'e')
            column = 4;
        else if (locationInput.charAt(0) == 'f')
            column = 5;
        else if (locationInput.charAt(0) == 'g')
            column = 6;
        else if (locationInput.charAt(0) == 'h')
            column = 7;
        
        int row = Integer.parseInt(String.valueOf(locationInput.charAt(1))) - 1;
        setRowLocation(row);
        setColumnLocation(column);
        if (!minOrMax)
            matrix[row][column] = 'X';
        else
            matrix[row][column] = 'O';
    }
    public boolean checkLocation(String locationInput) { //checking if input is valid
        boolean okay = true;

        if (locationInput.charAt(0) != 'a' && locationInput.charAt(0) != 'b' && locationInput.charAt(0) != 'c'
        && locationInput.charAt(0) != 'd' && locationInput.charAt(0) != 'e' && locationInput.charAt(0) != 'f'
        && locationInput.charAt(0) != 'g' && locationInput.charAt(0) != 'h') {
            okay = false;
        }
        int row = Integer.parseInt(String.valueOf(locationInput.charAt(1))); //turning second char to int

        if (row < 1 || row > 8)
            okay = false;
        if (locationInput.length() > 2)
            return false;
        // if (matrix[row][column] != ' ')
        //     okay = false;
        // else {
        //     setRowLocation(row);
        //     setColumnLocation(column);
        // }
        return okay;
    }
    public void printBoard() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }
    public boolean checkIfTerminal(char [][] test) { //need to test
        boolean terminal = false;
        int countIndex = 0; //counting how many in a row
        
        for (int i = 0; i < matrix.length; i++) { //checking if x won
            for (int j = 0; j < matrix[0].length; j++) {
                countIndex = 0;
                if (countIndex < 4 && test[i][j] == 'X') {
                    int row = i;
                    int column = j;
                    for (; column >= 0; column--) { //counting west
                        if(column != j && test[row][column] == 'X') 
                            countIndex++;
                    }
                    row = i;
                    column = j;
                    for (column = j; column < matrix.length; column++) { //counting east
                        if(column != j && test[row][column] == 'X') 
                            countIndex++;
                    }
                    if (countIndex >= 3)
                        terminal = true; // if count index equals 4
                    
                    countIndex = 0; //reset for vertical
                    row = i;
                    column = j;
                    for (; row >= 0; row--) { //counting North
                        if(row != i && test[row][column] == 'X') 
                            countIndex++;
                    }
                    row = i;
                    column = j;
                    for (row = i; row < matrix.length; row++) { //counting North
                        if(row != i && test[row][column] == 'X') 
                            countIndex++;
                    }
                    System.out.println(i + " is i " + j + " is j " + countIndex + " is countIndex");
                }
                if (countIndex >= 3)
                    terminal = true; // if count index equals 4
            }
        }

        for (int i = 0; i < matrix.length; i++) { //checking if O won
            for (int j = 0; j < matrix[0].length; j++) {
                countIndex = 0;
                if (countIndex < 4 && test[i][j] == 'O') {
                    int row = i;
                    int column = j;
                    for (; column >= 0; column--) { //counting west
                        if(column != j && test[row][column] == 'O') 
                            countIndex++;
                    }
                    row = i;
                    column = j;
                    for (column = j; column < matrix.length; column++) { //counting east
                        if(column != j && test[row][column] == 'O') 
                            countIndex++;
                    }
                    if (countIndex >= 3)
                    terminal = true; // if count index equals 4

                    countIndex = 0; //reset for vertical
                    row = i;
                    column = j;
                    for (; row >= 0; row--) { //counting North
                        if(row != i && test[row][column] == 'O') 
                            countIndex++;
                    }
                    row = i;
                    column = j;
                    for (row = i; row < matrix.length; row++) { //counting North
                        if(row != i && test[row][column] == 'O') 
                            countIndex++;
                    }
                    System.out.println(i + " is i " + j + " is j " + countIndex + " is countIndex");
                }
                if (countIndex >= 3)
                    terminal = true; // if count index equals 4
            }
        }
        return terminal;
    }
    public void successor(char [][] state) {
        int limit = 0; //initialized to zero
        List <char [][]> successors = new ArrayList<char [][]>();
        char [][] aSuccessor = new char [8][8];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == ' ') {
                    aSuccessor = state.clone();
                    aSuccessor [i][j] = 'O';
                    successors.add(aSuccessor);
                }
            }
        }
        System.out.println(successors.size() + " is size of list");
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.deepToString(successors.get(i)));
        }

    }
}
