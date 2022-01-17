import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[4][3];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {

            }
        }
    }
    private static int[][] readMatrix(Scanner scanner) {
        String line = scanner.nextLine();
        //if the rows and columns of the matrix are on a single line separated by whitespace
        String[] split = line.split("\\s+");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);
        
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            line = scanner.nextLine();
            split = line.split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(split[col]);
            }            
        }
        return matrix;
    }
}
