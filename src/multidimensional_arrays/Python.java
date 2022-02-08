package multidimensional_arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commandsArray = scanner.nextLine().split(", ");
        char[][] matrix = new char[size][size];
        int[] snakePosition = new int[2];
        fillTheMatrix(size, scanner, matrix, snakePosition);
        List<Integer> snakeSize = new ArrayList<>();
        snakeSize.add(1);
        int[] isSnakeDead = new int[1];

        for (int i = 0; i < commandsArray.length; i++) {
            String currentCommand = commandsArray[i];
            moveTheSnake(matrix, currentCommand, snakePosition, snakeSize, isSnakeDead);
            if (isSnakeDead[0] == 1) {
                break;
            }
        }
        int foodCount = findFoodCount(matrix);
        if (isSnakeDead[0] == 0 && foodCount > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
        } else if (isSnakeDead[0] == 0) {
            System.out.printf("You win! Final python length is %d", snakeSize.size());
        } else {
            System.out.print("You lose! Killed by an enemy!");
        }

    }

    private static int findFoodCount(char[][] matrix) {
        int foodCounter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'f') {
                    foodCounter++;
                }
            }
        }
        return foodCounter;
    }

    private static void moveTheSnake(char[][] matrix, String currentCommand, int[] snakePosition, List<Integer> snakeSize, int[] isSnakeDead) {
        int newSnakeRow = 0;
        int newSnakeCol = 0;

        switch (currentCommand) {
            case "up":
                if (snakePosition[0] == 0) {
                    newSnakeRow = matrix.length - 1;
                } else {
                    newSnakeRow = snakePosition[0] - 1;
                }
                newSnakeCol = snakePosition[1];
                break;
            case "down":
                if (snakePosition[0] == matrix.length - 1) {
                    newSnakeRow = 0;
                } else {
                    newSnakeRow = snakePosition[0] + 1;
                }
                newSnakeCol = snakePosition[1];
                break;
            case "right":
                if (snakePosition[1] == matrix.length - 1) {
                    newSnakeCol = 0;
                } else {
                    newSnakeCol = snakePosition[1] + 1;
                }
                newSnakeRow = snakePosition[0];
                break;
            case "left":
                if (snakePosition[1] == 0) {
                    newSnakeCol = matrix.length - 1;
                } else {
                    newSnakeCol = snakePosition[1] - 1;
                }
                newSnakeRow = snakePosition[0];
                break;
        }

        if (matrix[newSnakeRow][newSnakeCol] == 'f') {
            snakeSize.add(1);
            matrix[newSnakeRow][newSnakeCol] = '*';
        } else if (matrix[newSnakeRow][newSnakeCol] == 'e') {
            isSnakeDead[0] = 1;
            return;
        } else {
            matrix[newSnakeRow][newSnakeCol] = 's';
        }
        matrix[snakePosition[0]][snakePosition[1]] = '*';
        snakePosition[0] = newSnakeRow;
        snakePosition[1] = newSnakeCol;
    }

    private static void fillTheMatrix(int size, Scanner scanner, char[][] matrix, int[] snakePosition) {
        for (int row = 0; row < size; row++) {
            String currLine = scanner.nextLine();
            currLine = currLine.replaceAll(" ", "");
            for (int col = 0; col < size; col++) {
                char currChar = currLine.charAt(col);
                matrix[row][col] = currChar;
                if (currChar == 's') {
                    snakePosition[0] = row;
                    snakePosition[1] = col;
                }
            }
        }
    }
}
