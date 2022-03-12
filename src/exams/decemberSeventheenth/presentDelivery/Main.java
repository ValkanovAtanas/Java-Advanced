package exams.decemberSeventheenth.presentDelivery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] presentsCount = new int[1];
        presentsCount[0] = Integer.parseInt(scanner.nextLine());
        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = fillTheMatrix(matrixSize, scanner);
        boolean isSantaOutOfNeighborhood = false;
        int[] presentsGivenToNiceKids = new int[1];

        int niceKidsAtFirst = findNiceKids(matrix);


        while (true) {
            if (presentsCount[0] <= 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }
            String command = scanner.nextLine();
            if (command.equals("Christmas morning"))
                break;


            if (didSantaWentOutOfNeighborhood(matrix, command)) {
                removeSFromMatrix(matrix, isSantaOutOfNeighborhood);
                isSantaOutOfNeighborhood = true;
                System.out.println("Santa ran out of presents!");
                break;
            }
            moveSanta(matrix, command, presentsCount, presentsGivenToNiceKids);
        }
        printTheMatrix(matrix);
        if (findNiceKids(matrix) == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", presentsGivenToNiceKids[0]);
        } else {
            System.out.printf("No presents for %d nice kid/s.", findNiceKids(matrix));
        }
    }

    private static int findNiceKids(char[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'V') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void moveSanta(char[][] matrix, String command, int[] presentsCount, int[] presentsGivenToNiceKids) {
        int[] position = findPositionOfSanta(matrix);
        int positionRow = position[0];
        int positionCol = position[1];
        switch (command) {
            case "up":
                positionRow--;
                break;
            case "down":
                positionRow++;
                break;
            case "left":
                positionCol--;
                break;
            case "right":
                positionCol++;
                break;
        }

        if (matrix[positionRow][positionCol] == 'V') {
            matrix[position[0]][position[1]] = '-';
            matrix[positionRow][positionCol] = 'S';
            presentsCount[0]--;
            presentsGivenToNiceKids[0]++;
        } else if (matrix[positionRow][positionCol] == 'C') {
            matrix[position[0]][position[1]] = '-';
            matrix[positionRow][positionCol] = 'S';
            santaEatsCookie(matrix, positionRow, positionCol, presentsCount, presentsGivenToNiceKids);
        } else {
            matrix[position[0]][position[1]] = '-';
            matrix[positionRow][positionCol] = 'S';
        }
    }


    private static void santaEatsCookie(char[][] matrix, int positionRow, int positionCol, int[] presentsCount, int[] presentsGivenToNiceKids) {
        if (matrix[positionRow - 1][positionCol] == 'V' || matrix[positionRow - 1][positionCol] == 'X') {
            presentsCount[0]--;
            presentsGivenToNiceKids[0]++;
            matrix[positionRow - 1][positionCol] = '-';
        }

        if (matrix[positionRow + 1][positionCol] == 'V' || matrix[positionRow + 1][positionCol] == 'X') {
            presentsCount[0]--;
            presentsGivenToNiceKids[0]++;
            matrix[positionRow + 1][positionCol] = '-';
        }

        if (matrix[positionRow][positionCol - 1] == 'V' || matrix[positionRow][positionCol - 1] == 'X') {
            presentsCount[0]--;
            presentsGivenToNiceKids[0]++;
            matrix[positionRow][positionCol - 1] = '-';
        }

        if (matrix[positionRow][positionCol + 1] == 'V' || matrix[positionRow][positionCol + 1] == 'X') {
            presentsCount[0]--;
            presentsGivenToNiceKids[0]++;
            matrix[positionRow][positionCol + 1] = '-';
        }
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void removeSFromMatrix(char[][] matrix, boolean isSantaOutOfNeighborhood) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'S') {
                    matrix[row][col] = '-';
                    return;
                }
            }
        }
    }

    private static boolean didSantaWentOutOfNeighborhood(char[][] matrix, String command) {
        int[] position = findPositionOfSanta(matrix);
        int positionRow = position[0];
        int positionCol = position[1];
        switch (command) {
            case "up":
                if (positionRow == 0)
                    return true;
                break;
            case "down":
                if (positionRow == matrix.length - 1)
                    return true;
                break;
            case "left":
                if (positionCol == 0)
                    return true;
                break;
            case "right":
                if (positionCol == matrix.length - 1)
                    return true;
                break;
        }
        return false;
    }

    private static int[] findPositionOfSanta(char[][] matrix) {
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

    private static char[][] fillTheMatrix(int matrixSize, Scanner scanner) {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int row = 0; row < matrix.length; row++) {
            char[] charRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = charRow;
        }
        return matrix;
    }
}