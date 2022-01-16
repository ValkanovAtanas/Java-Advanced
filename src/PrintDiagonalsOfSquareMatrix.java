import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] matrix = readSquareMatrix(scanner);

        printFirstDiagonal(matrix);
        printSecondDiagonal(matrix);
    }

    private static void printSecondDiagonal(int[][] matrix) {
        int diagonalRowPos = matrix.length - 1;
        int diagonalColPos = 0;

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[diagonalRowPos][diagonalColPos] + " ");
            diagonalRowPos--;
            diagonalColPos++;
        }
        System.out.println();
    }

    private static void printFirstDiagonal(int[][] matrix) {
        int diagonalRowPos = 0;
        int diagonalColPos = 0;

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[diagonalRowPos][diagonalColPos] + " ");
            diagonalRowPos++;
            diagonalColPos++;
        }
        System.out.println();
    }

    private static int[][] readSquareMatrix(Scanner scanner) {
        int numOfRowsAndCols = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[numOfRowsAndCols][numOfRowsAndCols];

        for (int row = 0; row < numOfRowsAndCols; row++) {
            for (int col = 0; col < numOfRowsAndCols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        return matrix;
    }
}
