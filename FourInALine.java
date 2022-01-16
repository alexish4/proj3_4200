import java.util.Scanner;

public class FourInALine {
    private char [][] matrix = new char[8][8];
    private int rowLocation = 0;
    private int columnLocation = 0;
    
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
    
    public void assignRow() { //marking location according to user input
        Scanner keyboard = new Scanner(System.in);
        String locationInput;
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
        int row = 0;
        if (locationInput.charAt(0) == 'a') //enumerating
            row = 0;
        else if (locationInput.charAt(0) == 'b')
            row = 1;
        else if (locationInput.charAt(0) == 'c')
            row = 2;
        else if (locationInput.charAt(0) == 'd')
            row = 3;
        else if (locationInput.charAt(0) == 'e')
            row = 4;
        else if (locationInput.charAt(0) == 'f')
            row = 5;
        else if (locationInput.charAt(0) == 'g')
            row = 6;
        else if (locationInput.charAt(0) == 'h')
            row = 7;
        
        int column = Integer.parseInt(String.valueOf(locationInput.charAt(1))) - 1;
        setRowLocation(row);
        setColumnLocation(column);
    }
    public boolean checkLocation(String locationInput) { //checking if input is valid
        boolean okay = true;

        if (locationInput.charAt(0) != 'a' && locationInput.charAt(0) != 'b' && locationInput.charAt(0) != 'c'
        && locationInput.charAt(0) != 'd' && locationInput.charAt(0) != 'e' && locationInput.charAt(0) != 'f'
        && locationInput.charAt(0) != 'g' && locationInput.charAt(0) != 'h') {
            okay = false;
        }
        int column = Integer.parseInt(String.valueOf(locationInput.charAt(1))); //turning second char to int

        if (column < 1 || column > 8)
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
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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
}