package algorithms.shortest.path;

import java.util.Arrays;

public class Floyd {
    private int max = Integer.MAX_VALUE / 3;
    private int[][] path;
    void solve(int[][] matrix) {
        path = new int[matrix.length][matrix.length];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (matrix[j][k] > (matrix[j][i] + matrix[i][k])) {
                        path[j][k] = i;
                        matrix[j][k] = matrix[j][i] + matrix[i][k];
                    }
                }
            }
        }
    }


    private int[][] getGroup() {
        int[][] result = {
                {0, 1, 5, max, max, max, max, max, max},
                {1, 0, 3, 7, 5, max, max, max, max},
                {5, 3, 0, max, 1, 7, max, max, max},
                {max, 7, max, 0, 2, max, 3, max, max},
                {max, 5, 1, 2, 0, 3, 6, 9, max},
                {max, max, 7, max, 3, 0, max ,5, max},
                {max, max, max, 3, 6, max, 0, 2, 7},
                {max, max, max, max, 9, 5, 2, 0, 4},
                {max, max, max, max, max, max, 4, 6, 0}
        };
        return result;
    }

    public static void main(String[] args) {
        Floyd f = new Floyd();
        int[][] result = f.getGroup();
        f.solve(result);
        for (int i = 0; i < result.length; i++) {

        }
    }
}
