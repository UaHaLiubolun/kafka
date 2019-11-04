/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.LongestCommonSubsequence
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * LongestCommonSubsequence
 * @description TODO
 * @author liubolun
 * @date 2019年11月03日 17:36
 * @version 2.9
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j] + 1, dp[i][j + 1] + 1);
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abced", "ace"));
    }
}
