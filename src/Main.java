
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int K = Integer.parseInt(tokens[0]);
        int L = Integer.parseInt(tokens[1]);
        int R = Integer.parseInt(tokens[2]);
        char[][] matrix = new char[K][L];


        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                matrix[i][j] = '0';
            }
        }

        String[] orangeBlack1Tokens = scanner.nextLine().split("\\s+");
        matrix[Integer.parseInt(orangeBlack1Tokens[0]) - 1][Integer.parseInt(orangeBlack1Tokens[1]) - 1] = '-';

        String[] orangeBlack2Tokens = scanner.nextLine().split("\\s+");
        matrix[Integer.parseInt(orangeBlack2Tokens[0]) - 1][Integer.parseInt(orangeBlack2Tokens[1]) - 1] = '-';

        while (R > 0) {

            char[][] newMatrix = new char[K][L];
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < L; j++) {
                    newMatrix[i][j] = matrix[i][j];
                }
            }

            for (int i = 0; i < K; i++) {
                for (int j = 0; j < L; j++) {
                    if (matrix[i][j] == '-') {
                        if (j + 1 < L && matrix[i][j + 1] != '-') {
                            newMatrix[i][j + 1] = '-';
                        }
                        if (j - 1 >= 0 && matrix[i][j - 1] != '-') {
                            newMatrix[i][j - 1] = '-';
                        }
                        if (i - 1 >= 0 && matrix[i - 1][j] != '-') {
                            newMatrix[i - 1][j] = '-';
                        }
                        if (i + 1 < K && matrix[i + 1][j] != '-') {
                            newMatrix[i + 1][j] = '-';
                        }
                    }
                }
            }
            matrix = newMatrix;
            R--;
        }

        int finalCount = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                if (matrix[i][j] != '-') {
                    finalCount++;
                }
            }
        }
        System.out.println(finalCount);
    }
}