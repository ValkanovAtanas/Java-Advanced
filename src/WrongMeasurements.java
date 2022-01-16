import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++) {
            int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = array;
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        int rowOfMatrix = scanner.nextInt();
        int colOfMatrix = scanner.nextInt();
        int wrongValue = matrix[rowOfMatrix][colOfMatrix];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currElement = matrix[row][col];
                if (currElement == wrongValue) {
                    newMatrix[row][col] = correctWrongElement(matrix, row, col, wrongValue);
                } else {
                    newMatrix[row][col] = matrix[row][col];
                }
            }
        }

        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int correctWrongElement(int[][] matrix, int currentRow, int currentCol, int wrongValue) {
        int sum = 0;
        //left
        if(currentCol > 0 && matrix[currentRow][currentCol - 1] != wrongValue) {
            sum += matrix[currentRow][currentCol - 1];
        }
        //right
        if(currentCol < matrix[currentRow].length - 1 && matrix[currentRow][currentCol + 1] != wrongValue) {
            sum += matrix[currentRow][currentCol + 1];
        }
        //up
        if(currentRow > 0 && matrix[currentRow - 1][currentCol] != wrongValue) {
            sum += matrix[currentRow - 1][currentCol];
        }
        //down
        if(currentRow < matrix.length - 1 && matrix[currentRow + 1][currentCol] != wrongValue) {
            sum += matrix[currentRow + 1][currentCol];
        }
        return sum;
    }

    private static boolean isValidPosition(int[][] matrix, int currentRow, int currentCol) {
        if (currentRow > 0
                && currentRow < matrix.length
                && currentCol > 0
                && currentCol < matrix[currentRow].length) {
            return true;
        } else {
            return false;
        }
    }
}
