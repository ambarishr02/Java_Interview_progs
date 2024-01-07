package BackTracking;

public class NQueens {

    public static void main(String[] args) {
        int n = 4; // Change this value for different board sizes
        solveNQueens(n);
    }

    private static void solveNQueens(int n) {
        int[] queensPlacement = new int[n];
        placeQueens(queensPlacement, 0, n);
    }

    private static void placeQueens(int[] queensPlacement, int row, int n) {
        if (row == n) {
            printQueens(queensPlacement);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queensPlacement, row, col)) {
                queensPlacement[row] = col;
                placeQueens(queensPlacement, row + 1, n);
            }
        }
    }

    private static boolean isSafe(int[] queensPlacement, int row, int col) {
        for (int i = 0; i < row; i++) {

            if (queensPlacement[i] == col || Math.abs(queensPlacement[i] - col) == Math.abs(i - row)) {
                System.out.println("queensPlacement[i]="+queensPlacement[i]+",col="+col);
                System.out.println("Math.abs(queensPlacement[i] - col)="+Math.abs(queensPlacement[i] - col)+",Math.abs(i - row)="+Math.abs(i - row));
                return false;
            }
        }
        return true;
    }

    private static void printQueens(int[] queensPlacement) {
        int n = queensPlacement.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queensPlacement[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
