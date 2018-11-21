package algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            int k = 0;
            for (int j = i; j < chars.length; j++) {
                if (set.add(chars[j])) {
                    k++;
                } else {
                    set.clear();
                    break;
                }
            }
            if (k > max) {
                max = k;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring substring = new LongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring("pwwkew"));
    }

}
