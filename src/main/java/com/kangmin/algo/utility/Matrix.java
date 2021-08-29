package main.java.com.kangmin.algo.utility;

public class Matrix {
    /**
     * method to rotate a N*N matrix CW 90 degree
     * @param origin the matrix before rotation
     */
    protected static int[][] rotateCW90(int[][] origin) {
        int size = origin.length;
        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - 1 - i] = origin[i][j];
            }
        }
        return rotated;
    }

    // for compare
    //*************************************************************************
    // Compare two N*N matrix, is match or not
    //*************************************************************************
    protected static boolean isMatch(int[][] A, int[][] B) {
        // assume same size
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        final int[][] a = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        final int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(isMatch(a, b));
        final int[][] c = rotateCW90(a);
        final int[][] d = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        System.out.println(isMatch(c, d));
    }
}
