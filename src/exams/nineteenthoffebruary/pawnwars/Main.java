package exams.nineteenthoffebruary.pawnwars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        int[] whitePosition = new int[2];
        int[] blackPosition = new int[2];
        fillMatrixAndFindPawnPositions(matrix, whitePosition, blackPosition, scanner);
//        black pawn's turn is on even, white pawn's turn is on odd
        int[] whiteOrBlackTurnCounter = new int[]{1};
        int[] wasWhitePromotedAsQueen = new int[1];
        int[] wasBlackPromotedAsQueen = new int[1];
        int[] didWhiteKilledBlack = new int[1];
        int[] didBlackKilledWhite = new int[1];
        while (true) {
            pawnMove(
                    matrix,
                    whitePosition,
                    blackPosition,
                    whiteOrBlackTurnCounter,
                    wasBlackPromotedAsQueen,
                    wasWhitePromotedAsQueen,
                    didBlackKilledWhite,
                    didWhiteKilledBlack);
            if (wasBlackPromotedAsQueen[0] == 1) {
                System.out.print("Game over! Black pawn is promoted to a queen at ");
                System.out.print(positionParser(matrix, blackPosition));
                System.out.print(".");
                break;
            }
            if (wasWhitePromotedAsQueen[0] == 1) {
                System.out.print("Game over! White pawn is promoted to a queen at ");
                System.out.print(positionParser(matrix, whitePosition));
                System.out.print(".");
                break;
            }
            if (didBlackKilledWhite[0] == 1) {
                System.out.print("Game over! Black capture on ");
                System.out.print(positionParser(matrix, blackPosition));
                System.out.print(".");
                break;
            }
            if (didWhiteKilledBlack[0] == 1) {
                System.out.print("Game over! White capture on ");
                System.out.print(positionParser(matrix, whitePosition));
                System.out.print(".");
                break;
            }
        }

    }

    private static String positionParser(char[][] matrix, int[] position) {
            String row = "87654321";
            String col = "abcdefgh";
            char rowChar = row.charAt(position[0]);
            char colChar = col.charAt(position[1]);
            String output = String.format("%c%c", colChar, rowChar);
        return output;
    }

    private static void pawnMove(char[][] matrix,
                                 int[] whitePosition,
                                 int[] blackPosition,
                                 int[] whiteOrBlackTurnCounter,
                                 int[] wasBlackPromotedAsQueen,
                                 int[] wasWhitePromotedAsQueen,
                                 int[] didBlackKilledWhite,
                                 int[] didWhiteKilledBlack
    ) {
        if (whiteOrBlackTurnCounter[0] % 2 == 1) {
            whitePawnMove(matrix, whitePosition, blackPosition, wasWhitePromotedAsQueen, didWhiteKilledBlack);
        } else {
            blackPawnMove(matrix, whitePosition, blackPosition, wasBlackPromotedAsQueen, didBlackKilledWhite);
        }


        whiteOrBlackTurnCounter[0]++;
    }

    private static void blackPawnMove(char[][] matrix, int[] whitePosition, int[] blackPosition, int[] wasBlackPromotedAsQueen, int[] didBlackKilledWhite) {
        int whitePositionRow = whitePosition[0];
        int whitePositionCol = whitePosition[1];
        int blackPositionRow = blackPosition[0];
        int blackPositionCol = blackPosition[1];

        if ((blackPositionCol == whitePositionCol - 1 && blackPositionRow == whitePositionRow - 1)
                || (blackPositionCol == whitePositionCol + 1 && blackPositionRow == whitePositionRow - 1)) {
            matrix[blackPositionRow][blackPositionCol] = '-';
            blackPosition[0] = whitePosition[0];
            blackPosition[1] = whitePosition[1];
            matrix[blackPosition[0]][blackPosition[1]] = 'b';
            didBlackKilledWhite[0] = 1;
        } else if (blackPositionRow == 7) {
            wasBlackPromotedAsQueen[0] = 1;
        } else {
            matrix[blackPositionRow][blackPositionCol] = '-';
            blackPosition[0] = blackPositionRow + 1;
            matrix[blackPosition[0]][blackPosition[1]] = 'b';
        }
    }

    private static void whitePawnMove(char[][] matrix, int[] whitePosition, int[] blackPosition, int[] wasWhitePromotedAsQueen, int[] didWhiteKilledBlack) {
        int whitePositionRow = whitePosition[0];
        int whitePositionCol = whitePosition[1];
        int blackPositionRow = blackPosition[0];
        int blackPositionCol = blackPosition[1];

        if ((blackPositionCol == whitePositionCol - 1 && blackPositionRow == whitePositionRow - 1)
                || (blackPositionCol == whitePositionCol + 1 && blackPositionRow == whitePositionRow - 1)) {
            matrix[whitePositionRow][whitePositionCol] = '-';
            whitePosition[0] = blackPosition[0];
            whitePosition[1] = blackPosition[1];
            matrix[whitePosition[0]][whitePosition[1]] = 'w';
            didWhiteKilledBlack[0] = 1;
        } else if (whitePositionRow == 0) {
            wasWhitePromotedAsQueen[0] = 1;
        } else {
            matrix[whitePositionRow][whitePositionCol] = '-';
            whitePosition[0] = whitePositionRow - 1;
            matrix[whitePosition[0]][whitePosition[1]] = 'w';
        }
    }

    private static void fillMatrixAndFindPawnPositions(char[][] matrix, int[] whitePosition, int[] blackPosition, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String currLine = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = currLine.charAt(col);
                matrix[row][col] = currChar;
                if (currChar == 'b') {
                    blackPosition[0] = row;
                    blackPosition[1] = col;
                }
                if (currChar == 'w') {
                    whitePosition[0] = row;
                    whitePosition[1] = col;
                }
            }
        }
    }
}
