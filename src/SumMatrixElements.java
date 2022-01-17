import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<int[][], Integer> matrixMap = readMatrixAndCalculateSum(scanner);
        printRowsColsSumFromMatrixMap(matrixMap);

    }

    private static void printRowsColsSumFromMatrixMap(Map<int[][], Integer> matrixMap) {
        int[][] matrix = new int[0][0];
        int sum = 0;

        for (Map.Entry<int[][], Integer> entry : matrixMap.entrySet()) {
            matrix = entry.getKey();
            sum = entry.getValue();
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }

    private static Map<int[][], Integer> readMatrixAndCalculateSum(Scanner scanner) {
        String line = scanner.nextLine();
        //if the rows and columns of the matrix are on a single line separated by whitespace
        String[] split = line.split(",\\s+");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);

        Map<int[][], Integer> matrixMap = new HashMap<>();
        int[][] matrix = new int[rows][cols];
        Integer sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            line = scanner.nextLine();
            split = line.split(",\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(split[col]);
                sum += matrix[row][col];
            }
        }
        matrixMap.put(matrix, sum);
        return matrixMap;
    }
}
