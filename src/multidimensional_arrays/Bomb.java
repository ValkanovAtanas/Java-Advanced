package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int[] currentPosition = new int[2];
        String[] commands = scanner.nextLine().split(",");
        fillTheMatrix(matrix, currentPosition, scanner);


        System.out.println();
    }

    private static void fillTheMatrix(char[][] matrix, int[] currentPosition, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] stringArray = scanner.nextLine().split(" ");
            for (int col = 0; col < stringArray.length; col++) {
                matrix[row][col] = stringArray[col].charAt(0);
            }
        }
    }
}
