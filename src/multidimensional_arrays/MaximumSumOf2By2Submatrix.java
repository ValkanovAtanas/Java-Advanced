package multidimensional_arrays;

import java.util.Scanner;

public class MaximumSumOf2By2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int[][] biggestSubMatrix = findBiggestSubMatrix(matrix);
        int sum = biggestSubMatrix[0][0] + biggestSubMatrix[0][1] + biggestSubMatrix[1][0] + biggestSubMatrix[1][1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(biggestSubMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    private static int[][] findBiggestSubMatrix(int[][] matrix) {
        int[][] biggestSubMatrix = new int[2][2];
        int sum = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (currSum > sum) {
                    sum = currSum;
                    biggestSubMatrix[0][0] = matrix[i][j];
                    biggestSubMatrix[0][1] = matrix[i][j + 1];
                    biggestSubMatrix[1][0] = matrix[i + 1][j];
                    biggestSubMatrix[1][1] = matrix[i + 1][j + 1];
                }
            }
        }

        return biggestSubMatrix;
    }

    private static int[][] readMatrix(Scanner scanner) {
        String line = scanner.nextLine();
        //if the rows and columns of the matrix are on a single line separated by whitespace
        String[] split = line.split(",\\s+");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            line = scanner.nextLine();
            split = line.split(",\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(split[col]);
            }
        }
        return matrix;
    }
}
