/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.ChampagneTower
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * ChampagneTower
 * @description ChampagneTower
 * @author liubolun
 * @date 2019年12月18日 11:08
 * @version 3.1.1
 */
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[102][102];
        dp[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double last = (dp[i][j] - 1) / 2;
                if (last > 0) {
                    dp[i + 1][j] = last;
                    dp[i + 1][j + 1] = last;
                }
            }
        }
        return Math.min(1, dp[query_row - 1][query_glass - 1]);
    }
}
