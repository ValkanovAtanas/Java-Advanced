package exams.retake_exam_august.formula_one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[sizeOfMatrix][];
        fillTheMatrix(matrix, countOfCommands, scanner);
        int[] currPosition = findPlayerCurrentPosition(matrix);
        int[] isWinner = new int[1];

        for (int i = 0; i < countOfCommands; i++) {
            String command = scanner.nextLine();
            moveThePlayer(command, matrix, currPosition, isWinner);
        }

        if (isWinner[0] == 1) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveThePlayer(String command, char[][] matrix, int[] currPosition, int[] isWinner) {
        int[] newPosition = new int[2];
        int currRowPosition = currPosition[0];
        int currColPosition = currPosition[1];
        switch (command) {
            case "up":
                if (currRowPosition == 0) {
                    newPosition[0] = matrix.length - 1;
                } else {
                    newPosition[0] = currRowPosition - 1;
                }
                newPosition[1] = currColPosition;
                break;
            case "down":
                if (currRowPosition == matrix.length - 1) {
                    newPosition[0] = 0;
                } else {
                    newPosition[0] = currRowPosition + 1;
                }
                newPosition[1] = currColPosition;
                break;
            case "left":
                if (currColPosition == 0) {
                    newPosition[1] = matrix.length - 1;
                } else {
                    newPosition[1] = currColPosition - 1;
                }
                newPosition[0] = currRowPosition;
                break;
            case "right":
                if (currColPosition == matrix.length - 1) {
                    newPosition[1] = 0;
                } else {
                    newPosition[1] = currColPosition + 1;
                }
                newPosition[0] = currRowPosition;
                break;
        }

        int newRowPosition = newPosition[0];
        int newColPosition = newPosition[1];

        if (matrix[newRowPosition][newColPosition] == 'B') {
            matrix[currRowPosition][currColPosition] = '.';
            currPosition[0] = newRowPosition;
            currPosition[1] = newColPosition;
            moveThePlayer(command, matrix, currPosition, isWinner);
        } else if (matrix[newRowPosition][newColPosition] == 'T') {

        } else {
            if (matrix[currRowPosition][currColPosition] != 'B') {
                matrix[currRowPosition][currColPosition] = '.';
            }
            if (matrix[newRowPosition][newColPosition] == 'F') {
                isWinner[0] = 1;
            }
            matrix[newRowPosition][newColPosition] = 'P';
            currPosition[0] = newRowPosition;
            currPosition[1] = newColPosition;
        }


    }

    private static int[] findPlayerCurrentPosition(char[][] matrix) {
        int[] currentPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    currentPosition[0] = row;
                    currentPosition[1] = col;
                    return currentPosition;
                }
            }
        }
        return currentPosition;
    }

    private static void fillTheMatrix(char[][] matrix, int countOfCommands, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            char[] currLine = scanner.nextLine().toCharArray();
            matrix[row] = currLine;
        }
        return;
    }
}