package exams.februaryTwentySecond.revolt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = fillTheMatrix(sizeOfMatrix, scanner);
        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            moveThePlayer(matrix, command);
            if (didPlayerReachedTheFinish(matrix)) {
                System.out.println("Player won!");
                break;
            }
        }

        if (!didPlayerReachedTheFinish(matrix)) {
            System.out.println("Player lost!");
        }

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

    private static boolean didPlayerReachedTheFinish(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'F') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void moveThePlayer(char[][] matrix, String command) {
        int[] position = findThePlayersPosition(matrix);
        int currPosRow = position[0];
        int currPosCol = position[1];

        matrix[position[0]][position[1]] = '-';
        changePosition(position, command, matrix);

        if (matrix[position[0]][position[1]] == 'B') {
            changePosition(position, command, matrix);
        } else if (matrix[position[0]][position[1]] == 'T') {
            position[0] = currPosRow;
            position[1] = currPosCol;
        }
        matrix[position[0]][position[1]] = 'f';

    }

    private static void changePosition(int[] position, String command, char[][] matrix) {
        switch (command) {
            case "up":
                position[0]--;
                break;
            case "down":
                position[0]++;
                break;
            case "left":
                position[1]--;
                break;
            case "right":
                position[1]++;
                break;
        }
        correctPositionIfPlayersWentOut(matrix, position);
    }

    private static void correctPositionIfPlayersWentOut(char[][] matrix, int[] position) {
        if (position[0] < 0) {
            position[0] = matrix.length - 1;
        }
        if (position[0] > matrix.length - 1) {
            position[0] = 0;
        }
        if (position[1] < 0) {
            position[1] = matrix.length - 1;
        }
        if (position[1] > matrix.length - 1) {
            position[1] = 0;
        }
    }

    private static int[] findThePlayersPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'f') {
                    position[0] = row;
                    position[1] = col;
                    return position;
                }
            }
        }
        return position;
    }

    private static char[][] fillTheMatrix(int sizeOfMatrix, Scanner scanner) {
        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];
        for (int row = 0; row < matrix.length; row++) {
            char[] charArray = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = charArray[col];
            }
        }
        return matrix;
    }
}
