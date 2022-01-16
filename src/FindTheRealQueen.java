import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];

        for (int row = 0; row < 8; row++) {
            String line = scanner.nextLine();
            line = line.replaceAll("\\s+", "");
            char[] charArray = line.toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = charArray[col];
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (isValidQueen(matrix, row, col)) {
                    System.out.print(row + "" + col);
                    return;
                }
            }
        }

            System.out.println();
    }

    private static boolean isValidQueen(char[][] matrix, int row, int col) {
        for (int rowDirection = -1; rowDirection <= 1; rowDirection++) {
            for (int colDirection = -1; colDirection <= 1; colDirection++) {
                int currentRow = rowDirection + row;
                int currentCol = colDirection + col;

                boolean validPosition = currentRow >= 0
                        && currentRow < matrix.length
                        && currentCol >= 0
                        && currentCol < matrix[row].length;
                while (validPosition) {
                    if('q' == matrix[currentRow][currentCol]) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
