package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int[] currentPosition = new int[2];
        String[] commands = scanner.nextLine().split(",");
        fillTheMatrix(matrix, currentPosition, scanner);
        int[] countOfBombs = new int[1];
        int[] areAllBombsFound = new int[1];
        int[] isItTheEnd = new int[1];

        for (int i = 0; i < commands.length; i++) {
            String currCommand = commands[i];
            moveTheSapper(matrix, currentPosition, currCommand, countOfBombs, areAllBombsFound, isItTheEnd);
            if (isItTheEnd[0] == 1) {
                System.out.printf("END! %d bombs left on the field", findCountOfLeftBombs(matrix));
                break;
            } else if (findCountOfLeftBombs(matrix) == 0) {
                System.out.println("Congratulations! You found all bombs!");
                areAllBombsFound[0] = 1;
                break;
            }

        }
        if (isItTheEnd[0] == 0 && areAllBombsFound[0] == 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", findCountOfLeftBombs(matrix), currentPosition[0], currentPosition[1]);
        }

    }

    private static int findCountOfLeftBombs(char[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'B') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void moveTheSapper(char[][] matrix, int[] currentPosition, String currCommand, int[] countOfBombs, int[] areAllBombsFound, int[] isItTheEnd) {
        int[] newPosition = currentPosition;
        switch (currCommand) {
            case "up":
                if (currentPosition[0] != 0) {
                    newPosition[0] = currentPosition[0] - 1;
                    newPosition[1] = currentPosition[1];
                }
                break;
            case "down":
                if (currentPosition[0] != matrix.length - 1) {
                    newPosition[0] = currentPosition[0] + 1;
                    newPosition[1] = currentPosition[1];
                }
                break;
            case "left":
                if (currentPosition[1] != 0) {
                    newPosition[0] = currentPosition[0];
                    newPosition[1] = currentPosition[1] - 1;
                }
                break;
            case "right":
                if (currentPosition[1] != matrix.length - 1) {
                    newPosition[0] = currentPosition[0];
                    newPosition[1] = currentPosition[1] + 1;
                }
                break;
        }
        if (matrix[newPosition[0]][newPosition[1]] == 'B') {
            matrix[newPosition[0]][newPosition[1]] = 's';
            matrix[currentPosition[0]][currentPosition[1]] = '+';
            countOfBombs[0]++;
            System.out.println("You found a bomb!");
        } else if (matrix[newPosition[0]][newPosition[1]] == 'e') {
            isItTheEnd[0] = 1;
        }
        currentPosition = newPosition;
    }

    private static void fillTheMatrix(char[][] matrix, int[] currentPosition, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] stringArray = scanner.nextLine().split(" ");
            for (int col = 0; col < stringArray.length; col++) {
                char currChar = stringArray[col].charAt(0);
                matrix[row][col] = currChar;
                if (currChar == 's') {
                    currentPosition[0] = row;
                    currentPosition[1] = col;
                }
            }
        }
    }
}