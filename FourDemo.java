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
        FourInALine gameDemo = new FourInALine();
        gameDemo.assignRow();
        System.out.println(gameDemo.getRowLocation() + " is row " + gameDemo.getColumnLocation() + " is column");
        System.out.println(gameDemo.checkIfTerminal(test));
    }
    
    public int[][] readFile(int ROWS, int COLUMNS) throws FileNotFoundException {
        int[][] numArray = new int[ROWS][COLUMNS];
        Scanner sc = new Scanner(choseTextFile());
        while (sc.hasNextLine()) {
            for (int i = 0; i < numArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    numArray[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        return numArray;
    }

    private static File choseTextFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File To Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file = dialog.getFiles();
        return file[0];
    }
}