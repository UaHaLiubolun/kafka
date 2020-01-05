/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.StoneGame
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * StoneGame
 * @description StoneGame
 * @author liubolun
 * @date 2019年12月17日 16:58
 * @version 3.1.1
 */
public class StoneGame {

    public int stoneGame(int[] piles) {
        int[][] dp = new int[piles.length + 2][piles.length + 2];
        for (int size = 1; size <= piles.length; size++) {
            for (int i = 0; i + size < piles.length; i++) {
                int j = i + size;
                int temp = i + piles.length + j;
                if (temp % 2 == 1) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j - 1] + piles[i], dp[i + 1][j - 1] + piles[j]);
                }
            }
        }
        return dp[1][piles.length];
    }

    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        System.out.println(stoneGame.stoneGame(new int[]{2,7,9,4,4}));
    }
}
