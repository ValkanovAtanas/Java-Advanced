import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        int[] helenPosition = new int[2];
        int[] parisPosition = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            String currRowString = scanner.nextLine();
            char[] rowChar = currRowString.toCharArray();
            matrix[row] = rowChar;
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'H') {
                    helenPosition[0] = row;
                    helenPosition[1] = col;
                }
                if (matrix[row][col] == 'P') {
                    parisPosition[0] = row;
                    parisPosition[1] = col;
                }
            }
        }
        String input = scanner.nextLine();
        while (true) {
            String command = input.split("\\s+")[0];
            int rowOfSpartan = Integer.parseInt(input.split("\\s+")[1]);
            int colOfSpartan = Integer.parseInt(input.split("\\s+")[2]);
            matrix[rowOfSpartan][colOfSpartan] = 'S';
            int[] parisNewPosition = parisNewPosition(matrix, parisPosition, command);
            energy--;
            if (isParisGoingOut(matrix, parisPosition, command)) {

            } else if (matrix[parisNewPosition[0]][parisNewPosition[1]] == 'S') {
                matrix[parisPosition[0]][parisPosition[1]] = '-';
                matrix[parisNewPosition[0]][parisNewPosition[1]] = 'P';
                parisPosition = parisNewPosition;
                energy -= 2;
            } else if (matrix[parisNewPosition[0]][parisNewPosition[1]] == 'H') {
                matrix[parisPosition[0]][parisPosition[1]] = '-';
                matrix[parisNewPosition[0]][parisNewPosition[1]] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                break;
            } else {
                matrix[parisPosition[0]][parisPosition[1]] = '-';
                matrix[parisNewPosition[0]][parisNewPosition[1]] = 'P';
                parisPosition = parisNewPosition;
            }
            if (energy <= 0) {
                matrix[parisNewPosition[0]][parisNewPosition[1]] = 'X';
                System.out.printf("Paris died at %d;%d.%n", parisNewPosition[0], parisNewPosition[1]);
                break;
            }
            input = scanner.nextLine();
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] parisNewPosition(char[][] matrix, int[] parisPosition, String command) {
        int[] parisNewPosition = new int[2];
        switch (command) {
            case "up":
                parisNewPosition[0] = parisPosition[0] - 1;
                parisNewPosition[1] = parisPosition[1];
                break;
            case "down":
                parisNewPosition[0] = parisPosition[0] + 1;
                parisNewPosition[1] = parisPosition[1];
                break;
            case "left":
                parisNewPosition[0] = parisPosition[0];
                parisNewPosition[1] = parisPosition[1] - 1;
                break;
            case "right":
                parisNewPosition[0] = parisPosition[0];
                parisNewPosition[1] = parisPosition[1] + 1;
                break;
        }
        return parisNewPosition;
    }

    private static boolean isParisGoingOut(char[][] matrix, int[] parisPosition, String command) {
        int parisRow = parisPosition[0];
        int parisCol = parisPosition[1];
        switch (command) {
            case "up":
                if (parisRow == 0) {
                    return true;
                }
                break;
            case "down":
                if (parisRow == matrix.length - 1) {
                    return true;
                }
                break;
            case "left":
                if (parisCol == 0) {
                    return true;
                }
                break;
            case "right":
                if (parisCol == matrix[0].length - 1) {
                    return true;
                }
                break;
        }
        return false;
    }
}
