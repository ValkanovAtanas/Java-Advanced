import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        boolean isThereBonus = false;
        int[] mousePosition = new int[2];
        int[] bonusPosition = new int[2];

        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String currLine = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = currLine.charAt(col);
                matrix[row][col] = currChar;
                if (currChar == 'M') {
                    mousePosition[0] = row;
                    mousePosition[1] = col;
                }
                if (currChar == 'B') {
                    isThereBonus = true;
                    bonusPosition[0] = row;
                    bonusPosition[1] = col;
                }
            }
        }
        int cheeseEaten = 0;

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            if (isMouseOutside(input, mousePosition, matrix)) {
                System.out.println("Where is the mouse?");
                matrix[mousePosition[0]][mousePosition[1]] = '-';
                break;
            }
            mousePosition = newMousePosition(input, mousePosition[0], mousePosition[1]);
            if (matrix[mousePosition[0]][mousePosition[1]] == 'c') {
                cheeseEaten++;
            }
            if (Arrays.equals(mousePosition, bonusPosition)) {
                changeMousePosition(matrix, mousePosition, input);
                continue;
            }
            changeMousePosition(matrix, mousePosition, input);
            input = scanner.nextLine();
        }
        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                System.out.printf("%c", currChar);
            }
            System.out.println();
        }
    }


    private static char[][] changeMousePosition(char[][] matrix, int[] mousePosition, String input) {
        switch (input) {
            case "up":
                matrix[mousePosition[0] + 1][mousePosition[1]] = '-';
                break;
            case "down":
                matrix[mousePosition[0] - 1][mousePosition[1]] = '-';
                break;
            case "left":
                matrix[mousePosition[0]][mousePosition[1] + 1] = '-';
                break;
            case "right":
                matrix[mousePosition[0]][mousePosition[1] - 1] = '-';
                break;

        }
        matrix[mousePosition[0]][mousePosition[1]] = 'M';
        return matrix;
    }

    private static int[] newMousePosition(String input, int rowPos, int colPos) {

        int[] newMousePosition = {rowPos, colPos};
        switch (input) {
            case "up":
                newMousePosition[0] -= 1;
                break;
            case "down":
                newMousePosition[0] += 1;
                break;
            case "left":
                newMousePosition[1] -= 1;
                break;
            case "right":
                newMousePosition[1] += 1;
                break;

        }
        return newMousePosition;
    }

    private static boolean isMouseOutside(String input, int[] mousePosition, char[][] matrix) {
        switch (input) {
            case "up":
                if (mousePosition[0] - 1 < 0) {
                    return true;
                }
                break;
            case "down":
                if (mousePosition[0] + 1 > matrix.length - 1) {
                    return true;
                }
                break;
            case "left":
                if (mousePosition[1] - 1 < 0) {
                    return true;
                }
                break;
            case "right":
                if (mousePosition[1] + 1 > matrix.length - 1) {
                    return true;
                }
                break;
        }
        return false;
    }
}
