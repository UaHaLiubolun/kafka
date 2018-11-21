package algorithms;

public class LongestPalindrome {


    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
        if (s.length() == 1) return s;
        int longest = 1;
        int start = 0;
        int[][] dp = new int[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = 1;
            if (i < chars.length - 1) {
                if (chars[i] == chars[i + 1]) {
                    dp[i][i + 1] = 1;
                    start = i;
                    longest = 2;
                }
            }
        }
        printArray(dp);
        for (int i = 3; i <= chars.length; i++) {
            for (int j = 0; j + i - 1 < chars.length; j++) {
                int k = i + j -1;
                if (chars[k] == chars[j] && dp[j + 1][k - 1] == 1) {
                    dp[j][k] =  1;
                    start = j;
                    longest = i;
                }
            }
        }
        printArray(dp);
        return s.substring(start, start + longest);
    }


    void getStr(StringBuffer sb, char[] chars, int[][] ints, int x, int y) {
        if (x == -1 || y == -1) return;
        if (ints[x + 1][y + 1] == 10) {
            sb.append(chars[x]);
            getStr(sb, chars, ints, x - 1, y - 1);
        } else if (ints[x + 1][y + 1] == 15) {
            getStr(sb, chars, ints, x, y - 1);
        } else {
            getStr(sb, chars, ints, x - 1, y);
        }
    }

    void printArray(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LongestPalindrome longestSubstring = new LongestPalindrome();
        System.out.println(longestSubstring.longestPalindrome("babad"));
    }
}
