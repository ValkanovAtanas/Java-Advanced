import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillTheMatrix(size, scanner);
        int foodAtFirst = findFoodCount(matrix);
        int foodEaten = 0;
        while (true) {
            String command = scanner.nextLine();
            if (didSnakeGoOutside(matrix, command)) {
                int snakePositionRow = findSnakePosition(matrix)[0];
                int snakePositionCol = findSnakePosition(matrix)[1];
                matrix[snakePositionRow][snakePositionCol] = '.';
                System.out.println("Game over!");
                break;
            }
            moveTheSnake(matrix, command);
            foodEaten = foodAtFirst - findFoodCount(matrix);
            if (foodEaten >= 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
        }

        System.out.print("Food eaten: ");
        System.out.println(foodEaten);

        printTheMatrix(matrix);
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveTheSnake(char[][] matrix, String command) {
        int snakePositionRow = findSnakePosition(matrix)[0];
        int snakePositionCol = findSnakePosition(matrix)[1];
        matrix[snakePositionRow][snakePositionCol] = '.';
        switch (command) {
            case "up":
                snakePositionRow--;
                break;
            case "down":
                snakePositionRow++;
                break;
            case "left":
                snakePositionCol--;
                break;
            case "right":
                snakePositionCol++;
                break;
        }
        if (matrix[snakePositionRow][snakePositionCol] == 'B') {
            getIntoBurrow(matrix, snakePositionRow, snakePositionCol);
        } else {
            matrix[snakePositionRow][snakePositionCol] = 'S';
        }

    }

    private static void getIntoBurrow(char[][] matrix, int snakePositionRow, int snakePositionCol) {
        matrix[snakePositionRow][snakePositionCol] = '.';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'B') {
                    matrix[row][col] = 'S';
                    return;
                }
            }
        }
    }

    private static int findFoodCount(char[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == '*') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static boolean didSnakeGoOutside(char[][] matrix, String command) {
        int snakePositionRow = findSnakePosition(matrix)[0];
        int snakePositionCol = findSnakePosition(matrix)[1];

        switch (command) {
            case "up":
                if (snakePositionRow == 0) {
                    return true;
                }
                break;
            case "down":
                if (snakePositionRow == matrix.length - 1) {
                    return true;
                }
                break;
            case "left":
                if (snakePositionCol == 0) {
                    return true;
                }
                break;
            case "right":
                if (snakePositionCol == matrix.length - 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static int[] findSnakePosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'S') {
                    position[0] = row;
                    position[1] = col;
                    return position;
                }
            }
        }
        return position;
    }

    private static char[][] fillTheMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = line[col];
                matrix[row][col] = currChar;
            }
        }
        return matrix;
    }
}
