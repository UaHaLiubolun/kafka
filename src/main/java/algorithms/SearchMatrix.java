/*
 * @projectName kafak
 * @package algorithms.shortest.path
 * @className algorithms.SearchMatrix
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * SearchMatrix
 * @description TODO
 * @author liubolun
 * @date 2019年10月29日 17:12
 * @version 3.0.0
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
