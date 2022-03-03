package exams.nineteenthofaugust;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(size, scanner);
        int flowersCountAtFirst = findFlowersCount(matrix);

        String command;
        while (!"End".equals(command = scanner.nextLine())) {
            if (didBeeWentOut(matrix, command, findBeePosition(matrix))) {
                matrix = putTheBeeOut(matrix);
                System.out.println("The bee got lost!");
                break;
            }
            moveTheBee(matrix, command);
        }
        int flowersCountAtLast = findFlowersCount(matrix);
        int pollinatedFlowers = flowersCountAtFirst - flowersCountAtLast;
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            int flowersNeeded = 5 - pollinatedFlowers;
            System.out.printf("The bee couldn't pollinate the flowers, she needed %s flowers more%n", flowersNeeded);
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

    private static char[][] putTheBeeOut(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'B') {
                    matrix[row][col] = '.';
                    return matrix;
                }
            }
        }
        return matrix;
    }

    private static void moveTheBee(char[][] matrix, String command) {
        int[] beePosition = findBeePosition(matrix);
        int beePositionRow = beePosition[0];
        int beePositionCol = beePosition[1];

        int[] beePositionAfterCommand = beePosition;
        switch (command) {
            case "up":
                beePositionAfterCommand[0]--;
                break;
            case "down":
                beePositionAfterCommand[0]++;
                break;
            case "left":
                beePositionAfterCommand[1]--;
                break;
            case "right":
                beePositionAfterCommand[1]++;
                break;
        }
        if (matrix[beePositionAfterCommand[0]][beePositionAfterCommand[1]] == 'O') {
            matrix[beePositionRow][beePositionCol] = '.';
            matrix[beePositionAfterCommand[0]][beePositionAfterCommand[1]] = 'B';
            moveTheBee(matrix, command);
        } else {
            matrix[beePositionRow][beePositionCol] = '.';
            matrix[beePositionAfterCommand[0]][beePositionAfterCommand[1]] = 'B';
        }
    }

    private static boolean didBeeWentOut(char[][] matrix, String command, int[] beePosition) {
        switch (command) {
            case "up":
                if (beePosition[0] == 0) {
                    return true;
                }
                break;
            case "down":
                if (beePosition[0] == matrix.length - 1) {
                    return true;
                }
                break;
            case "left":
                if (beePosition[1] == 0) {
                    return true;
                }
                break;
            case "right":
                if (beePosition[1] == matrix.length - 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static int findFlowersCount(char[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'f') {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] findBeePosition(char[][] matrix) {
        int[] beePosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'B') {
                    beePosition[0] = row;
                    beePosition[1] = col;
                    return beePosition;
                }
            }
        }
        return beePosition;
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String currLine = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                char currChar = currLine.charAt(col);
                matrix[row][col] = currChar;
            }
        }
        return matrix;
    }
}