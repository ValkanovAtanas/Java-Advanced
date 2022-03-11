package exams.decemberSeventheenth.presentDelivery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presentsCount = Integer.parseInt(scanner.nextLine());
        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = fillTheMatrix(matrixSize, scanner);

        while (presentsCount > 0) {
            String command = scanner.nextLine();
            if(command.equals("Christmas morning"))
                break;


        }

        System.out.println();
    }

    private static int[] findPosition (char[][] matrix) {
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
